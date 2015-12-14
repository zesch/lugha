/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;


import de.unidue.ltl.lugha.core.Numerals;


/**
 * Normalizes Arabic text by removing Arabic Numerals
 */
public class NumeralsRemover {
    
	/**
	 * Removes all Arabic numerals marks in a given text.
	 * 
	 * @param text
	 * 	The input text, e.g.: "قال المدير1 عندنا اجتماع2 بعد قليل3"
	 * 
	 * @return  The text without Arabic numerals, e.g. "قال المدير عندنا اجتماع بعد قليل"
	 */
	public static String removeNumerals(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < normalizedText.length(); i++) {
			String unigram = text.substring(i, i + 1);
				if (!Numerals.getNumerals().contains(unigram))
				{
					sb.append(unigram);
				}
		}
		
//		System.out.println("No Num:"+sb.toString());
		
		return sb.toString();
	}

}
