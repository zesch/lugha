package de.unidue.ltl.lugha.normalization;


/**
 * TODO add documentation
 */
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

		String withoutExtraSpaces = normalizeWhitespace(text);

		String withoutTatweel = normalizeTatweel(withoutExtraSpaces);

		return withoutTatweel;
	}

	/**
	 * TODO add documentation
	 * @param text
	 * @return
	 */
	public static String normalizeTatweel(String text) 
	{		
		return text.replaceAll(NormalizationConstants.TATWEEL, "");		
	}
	
	/**
	 * TODO add documentation
	 * 
	 * @param text
	 * @return
	 */
	public static String normalizeWhitespace(String text)
	{
		return text.replaceAll("\\s+", " ");
	}
}
