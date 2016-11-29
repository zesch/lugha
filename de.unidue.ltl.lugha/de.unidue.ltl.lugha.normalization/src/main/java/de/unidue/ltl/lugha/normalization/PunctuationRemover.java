/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;


import de.unidue.ltl.lugha.core.PunctuationMarks;;


/**
 * Normalizes Arabic text by removing punctuation marks
 */
public class PunctuationRemover {

	public static String removePunctuation(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < normalizedText.length(); i++) {
			String unigram = text.substring(i, i + 1);
				if (!PunctuationMarks.getPunctuations().contains(unigram))
				{
					sb.append(unigram);
				}
		}
		
		return sb.toString();
	}

	public static int hasPunctuation(String text) {
		
		int result = 0;
		
		String normalizedText = TextNormalizer.normalizeText(text);
		
		for (int i = 0; i < normalizedText.length(); i++) {
			
			String unigram = text.substring(i, i + 1);
			
			if (PunctuationMarks.getPunctuations().contains(unigram))
			{
				result ++;
			}

		}
		
		return result;

	}
	

}
