package de.unidue.ltl.lugha.transliteration.diacritic;


import de.unidue.ltl.lugha.core.DiacriticMarks;
import de.unidue.ltl.lugha.normalization.TextNormalizer;


public class DiacriticsRemover {

	/**
	 * TODO Description of what kinds of DiacriticsRemover is performed
	 * 
	 * @param text
	 *   The input text, eg. َبِّ أَعِنِّي وَلَا تُعِنْ عَلَيَّ وَانْصُرْنِي وَلَا تَنْصُرْ عَلَيَّ
	 *            
	 * @return The text without diacritics, e.g. رب أعني ولا تعن علي وانصرني ولا تنصر علي
	 */
	public static String removeDiacritics(String text) {

		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < normalizedText.length(); i++) {
			String unigram = text.substring(i, i + 1);
				if (!DiacriticMarks.diacritics.contains(unigram))
				{
					sb.append(unigram);
				}
		}
		
		
		return sb.toString();
	}

}
