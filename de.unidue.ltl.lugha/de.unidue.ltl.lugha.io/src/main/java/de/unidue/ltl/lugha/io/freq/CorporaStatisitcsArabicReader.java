package de.unidue.ltl.lugha.io.freq;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
import org.dkpro.tc.api.type.TextClassificationSequence;

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
    @ConfigurationParameter(name = HAS_DIACRITICS, mandatory = true, defaultValue = "No")
    private String hasDiacrtics;

    private List<String> texts;

    private int offset;
    
    /**
     * The initialize method aims at putting the file content into a datastructure
     */
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        
        texts = new ArrayList<String>();
        try {
        	
            URL resourceUrl = ResourceUtils.resolveLocation(sentencesFile, this, context);
            InputStream is = resourceUrl.openStream();
            
            for (String sentence : IOUtils.readLines(is, encoding)) {
            	
            	/**
            	 * TOOD:
            	 */
            	sentence = TextNormalizer.normalizeText(sentence);
            			 
            	if (sentence.trim().length() > 0){
            		texts.add(sentence);
            	}
                
            }
            is.close();
        }
        catch (IOException e) {
            throw new ResourceInitializationException(e);
        }

        offset = 0;
    }

    public boolean hasNext()
        throws IOException, CollectionException
    {
        return offset < texts.size();
    }

    @Override
    public void getNext(JCas aJCas)
        throws IOException, CollectionException
    {
    	
    	/**
    	 * TODO:
    	 */
    	String withDiacritics = TextNormalizer.normalizeText(texts.get(offset));
    	String withoutDiacritics = DiacriticsRemover.removeDiacritics(withDiacritics);   	
    	
    	if (hasDiacrtics.equals("No")){
        	aJCas.setDocumentText(withoutDiacritics);
    	}else{
    		aJCas.setDocumentText(withDiacritics);
    	}
    		
        aJCas.setDocumentLanguage("ar");

        DocumentMetaData dmd = DocumentMetaData.create(aJCas);
        dmd.setDocumentTitle("Sentence" + offset);
        dmd.setDocumentUri("Sentence" + offset);
        dmd.setDocumentId(String.valueOf(offset));
                
        addSequences(aJCas);
        
        offset++;
    }
    
    private void addSequences(JCas jcas) {
    	int offset = 0;
    	for (String token : jcas.getDocumentText().split(" ")) {
            TextClassificationSequence sequence = new TextClassificationSequence(jcas, offset, offset + token.length());
            sequence.addToIndexes();
            
            offset = offset + token.length() + 1;
    	}
    }

    public Progress[] getProgress()
    {
        return new Progress[] { new ProgressImpl(offset, texts.size(), "sentences") };
    }    
}
