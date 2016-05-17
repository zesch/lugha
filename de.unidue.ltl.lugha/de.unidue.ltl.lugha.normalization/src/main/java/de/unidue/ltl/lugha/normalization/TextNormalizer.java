/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;



/**
 * TODO add documentation
 */
public class TextNormalizer {

	/**
	 * Description of what kinds of normalization is performed
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
	 * Description of what kinds of normalization is performed
	 * 
	 * @param text
	 *   The input text:تطويــــــــــــــــــــــ123ـــــــــــــل         هكـــــــــذا
	 *            
	 * @return The normalized text:تطويل هكذا
	 */

	public static String fullyNormalizeText(String text) {

		return removeNonArabic(normalizeTatweel(normalizeWhitespace(text)));
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

	/**
	 * TODO add documentation
	 * 
	 * @param text
	 * @return
	 */
	public static String removeNonArabic(String text)
	{
		StringBuilder sb = new StringBuilder();
		
		int lettersCount = 0;
		
	    int count = Character.codePointCount(text, 0, text.length());
	    for (int i = 0; i < count; i++) {
	        int c = text.codePointAt(i);
	        if (Character.isWhitespace(c) || 
	        	(c >= 0x0600 && c <=0x06E0) || 
	        	(c >= 0xFE70 && c<=0xFEFF))
	        {
	        	sb.append(Character.toChars(c));
	        	lettersCount++;
	        }	        	
	    }
	    	    
	    return sb.toString();
	}
}
