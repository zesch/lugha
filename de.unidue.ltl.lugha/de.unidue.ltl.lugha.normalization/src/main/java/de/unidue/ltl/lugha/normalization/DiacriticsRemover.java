/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;


import de.unidue.ltl.lugha.core.DiacriticMarks;


/**
 * Normalizes Arabic text by removing diacritic marks
 */
public class DiacriticsRemover {

	/**
	 * Removes all diacritic marks in a given text.
	 * 
	 * @param text
	 * 	The input text, e.g.: "قَامَ الْقَسَمِ الْعَرَبِيِّ فِيْ جُوْجِلْ بِبَرْمَجَةٌ أَدَاةِ مُفِيْدَةٍ تَقُوْمُ بِتَشْكِيْلَ الْكَلِمَاتِ" 
	 *            
	 * @return The text without diacritics, e.g. "قام القسم العربي في جوجل ببرمجة أداة مفيدة تقوم بتشكيل الكلمات"
	 */
	public static String removeDiacritics(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < normalizedText.length(); i++) {
			String unigram = text.substring(i, i + 1);
				if (!DiacriticMarks.getDiacritics().contains(unigram))
				{
					sb.append(unigram);
				}
		}
		
		return sb.toString();
	}

}
