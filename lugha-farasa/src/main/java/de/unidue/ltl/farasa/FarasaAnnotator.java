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
package de.unidue.ltl.farasa;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.qcri.farasa.segmenter.Farasa;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.ltl.lugha.core.DiacriticMarks;

public class FarasaAnnotator 
	extends JCasAnnotator_ImplBase
{

	private Farasa farasa;
	
	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException 
	{
		super.initialize(context);
		
		try {
			farasa = new Farasa();
		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		String originalString = jcas.getDocumentText();
		Deque<String> originalQueue = new LinkedList<String>(Arrays.asList(originalString.split("")));
		
		List<String> segments = farasa.segmentLine(jcas.getDocumentText());
		String cleanedSegmentString = StringUtils.join(segments, " ").replaceAll("\\+", " ");
		Deque<String> segmentQueue = new LinkedList<String>(Arrays.asList(cleanedSegmentString.split("")));
		
		
		// add trailing space, so that last token gets added
		originalQueue.addLast(" ");
		segmentQueue.addLast(" ");

		int startOffset = 0;
		int endOffset = 0;
		
		while (!originalQueue.isEmpty()) {
			String currentChar = originalQueue.poll();
			
			if (DiacriticMarks.isDiacritic(currentChar)) {
				endOffset++;
				continue;
			}
			
			String segmentChar = segmentQueue.poll();
			if (segmentChar == null) {
				continue;
//				throw new RuntimeException("Segmented string unalignable with original version.\n '" + originalString + "'\n'" + cleanedSegmentString + "'");
			}
			
			if (!currentChar.equals(segmentChar)) {
				// segment within original token
				if (segmentChar.equals(" ")) {
					Token token = new Token(jcas, startOffset, endOffset);
					token.addToIndexes();
					
					// add original char back to queue
					originalQueue.addFirst(currentChar);
					startOffset = endOffset;
					continue;
				}
				else {
					continue;
//					throw new RuntimeException("Segmented string unalignable with original version.\n '" + originalString + "'\n'" + cleanedSegmentString + "'");					
				}
			}
			
			// original blank - add token
			if (currentChar.equals(" ")) {
				Token token = new Token(jcas, startOffset, endOffset);
				token.addToIndexes();
				endOffset++;
				startOffset = endOffset;
				continue;
			}

			endOffset++;
		}
	}
}
