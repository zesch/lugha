/*******************************************************************************
 * Copyright 2019
 * Language Technology Lab
 * University of Duisburg-Essen, Germany
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.unidue.ltl.lugha.io.freq;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.core.api.parameter.ComponentParameters;
import de.tudarmstadt.ukp.dkpro.core.api.resources.ResourceUtils;
import de.unidue.ltl.lugha.normalization.DiacriticsRemover;
import de.unidue.ltl.lugha.normalization.TextNormalizer;

public class CorporaStatisitcsArabicReader
    extends JCasCollectionReader_ImplBase
{

    /**
     * Character encoding of the input data
     */
    public static final String PARAM_ENCODING = ComponentParameters.PARAM_SOURCE_ENCODING;
    @ConfigurationParameter(name = PARAM_ENCODING, mandatory = true, defaultValue = "UTF-8")
    private String encoding;

    /**
     * Path to the file containing the sentences = Arabic diacritized text (with diacritic marks)
     */
    public static final String PARAM_SENTENCES_FILE = "SentencesFile";
    @ConfigurationParameter(name = PARAM_SENTENCES_FILE, mandatory = true)
    private String sentencesFile;

    public static final String HAS_DIACRITICS = "HasDiacrtics";
    @ConfigurationParameter(name = HAS_DIACRITICS, mandatory = true, defaultValue = "false")
    private boolean hasDiacrtics;

    private List<String> texts;

    private int offset;

    /**
     * The initialize method aims at putting the file content into a datastructure
     */
    @Override
    public void initialize(UimaContext context) throws ResourceInitializationException
    {
        super.initialize(context);

        texts = new ArrayList<String>();
        try (InputStream is = ResourceUtils.resolveLocation(sentencesFile, this, context)
                .openStream()) {
            for (String sentence : IOUtils.readLines(is, encoding)) {
                sentence = TextNormalizer.fullyNormalizeText(sentence);
                if (sentence.trim().length() > 0) {
                    texts.add(sentence);
                }
            }
        }
        catch (IOException e) {
            throw new ResourceInitializationException(e);
        }
        offset = 0;
    }

    public boolean hasNext() throws IOException, CollectionException
    {
        return offset < texts.size();
    }

    @Override
    public void getNext(JCas aJCas) throws IOException, CollectionException
    {
        String withDiacritics = TextNormalizer.normalizeText(texts.get(offset));
        String withoutDiacritics = DiacriticsRemover.removeDiacritics(withDiacritics);

        if (!hasDiacrtics) {
            aJCas.setDocumentText(withoutDiacritics);
        }
        else {
            aJCas.setDocumentText(withDiacritics);
        }

        aJCas.setDocumentLanguage("ar");

        DocumentMetaData dmd = DocumentMetaData.create(aJCas);
        dmd.setDocumentTitle("Sentence" + offset);
        dmd.setDocumentUri("Sentence" + offset);
        dmd.setDocumentId(String.valueOf(offset));

        offset++;
    }

    public Progress[] getProgress()
    {
        return new Progress[] { new ProgressImpl(offset, texts.size(), "sentences") };
    }
}
