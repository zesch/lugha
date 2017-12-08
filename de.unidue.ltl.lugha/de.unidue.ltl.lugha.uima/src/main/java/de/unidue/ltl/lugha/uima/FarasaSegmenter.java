package de.unidue.ltl.lugha.uima;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.lang.StringUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.ietf.jgss.Oid;

import com.qcri.farasa.segmenter.Farasa;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.ltl.lugha.core.DiacriticMarks;

public class FarasaSegmenter 
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
		} catch (FileNotFoundException e) {
			throw new ResourceInitializationException(e);
		} catch (ClassNotFoundException e) {
			throw new ResourceInitializationException(e);
		} catch (IOException e) {
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
		
		
		String sOrig = cleanString(originalQueue);
		String sSeg = cleanString(segmentQueue);
		
		if (!sOrig.equals(sSeg)) {
			System.out.println(sOrig);
			System.out.println(sSeg);
			System.out.println();
		}
		
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
				throw new RuntimeException("Segmented string unalignable with original version.");
			}
//			System.out.println(currentChar + " - " + segmentChar);
			
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
//				else if (DiacriticMarks.isDiacritic(currentChar)) {
//					// add segment char back to queue
//					segmentQueue.addFirst(segmentChar);
//					endOffset++;
//					continue;
//				}
				else {
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
	
	private String cleanString(Deque<String> chSeq) {
		StringBuilder sb = new StringBuilder();
		for (String ch : chSeq) {
			if (ch.equals(" ")) {
				continue;
			}
			else if (DiacriticMarks.isDiacritic(ch)) {
				continue;
			}
			
			sb.append(ch);
		}
		return sb.toString();
	}

}
