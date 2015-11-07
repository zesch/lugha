package de.unidue.ltl.lugha.normalization;

import de.unidue.ltl.lugha.normalization.helper.Preporcessing;

public class TextNormalizer {

	/**
	 * TODO description of what kinds of normalization is performed
	 * 
	 * @param text
	 *   The input text:تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا
	 *            
	 * @return The normalized text:تطويل هكذا
	 */

	public static String normalizeText(String text) {
		// FIXME include several steps for normalization here

		String withoutExtraSpaces = Preporcessing
				.discardExtraWhiteSpaces(text);

		String withoutTatweel = NormalizeArabicText
				.normalizeTatweel(withoutExtraSpaces);

		return withoutTatweel;
	}
}
