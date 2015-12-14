/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;


import de.unidue.ltl.lugha.core.PunctuationMarks;


/**
 * Normalizes Arabic text by removing Punctuation marks
 */
public class PunctuationRemover {

	/**
	 * Removes all Arabic punctuation marks in a given text.
	 * 
	 * @param text
	 *  The input text, e.g.: "قال المدير: “عندنا اجتماع بعد قليل.”"
	 *  
	 * @return  The text without Arabic punctuation marks, e.g. "قال المدير عندنا اجتماع بعد قليل"
	 */
	public static String removePunctuations(String text) {
				
		String normalizedText = TextNormalizer.normalizeText(text);
				
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < normalizedText.length(); i++) {
			String unigram = text.substring(i, i + 1);
				if (!PunctuationMarks.getPunctuationMarks().contains(unigram))
				{
					sb.append(unigram);
				}
		}
		
//		System.out.println("No Punct:"+sb.toString());
		
		return sb.toString();
	}

}
