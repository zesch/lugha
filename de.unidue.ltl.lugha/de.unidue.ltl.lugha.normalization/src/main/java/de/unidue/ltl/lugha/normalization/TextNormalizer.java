/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;

import java.util.ArrayList;
import java.util.List;



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

	public static String normalizeAllAlifsToBareAlif(String text)
	{
		
		StringBuilder sb = new StringBuilder();
		
		int lettersCount = 0;
		
	    int count = Character.codePointCount(text, 0, text.length());
	    for (int i = 0; i < count; i++) {
	        int c = text.codePointAt(i);
	        
	        if ((c == NormalizationConstants.ALIF_HAMZA_ABOVE) || 
	        	(c == NormalizationConstants.ALIF_HAMZA_BELOW ) || 
	        	(c == NormalizationConstants.ALIF_MADDA ))
	        {
	        	sb.append(Character.toChars(NormalizationConstants.ALIF));
	        	lettersCount++;
	        }else{
	        	sb.append(Character.toChars(c));
	        }
	        
	    }
	    	    
	    return sb.toString();

	}
	
	public static String normalizeTaaMarbutaWithHaa(String text)
	{
		
		StringBuilder sb = new StringBuilder();
		
		int lettersCount = 0;
		
	    int count = Character.codePointCount(text, 0, text.length());
	    
	    for (int i = 0; i < count; i++) {
	        int c = text.codePointAt(i);
	        
	        if ((c == NormalizationConstants.TAA_MARBUTA) )
	        {
	        	sb.append(Character.toChars(NormalizationConstants.HAA));
	        	lettersCount++;
	        }else{
	        	sb.append(Character.toChars(c));
	        }
	        
	    }
	    	    
	    return sb.toString();

	}

	public static String normalizeYaaMarbutaWithDotlessYaa(String text)
	{
		
		StringBuilder sb = new StringBuilder();
		
		int lettersCount = 0;
		
	    int count = Character.codePointCount(text, 0, text.length());
	    
	    for (int i = 0; i < count; i++) {
	        int c = text.codePointAt(i);
	        
	        if ((c == NormalizationConstants.YAA) )
	        {
	        	sb.append(Character.toChars(NormalizationConstants.DOTLESS_YAA));
	        	lettersCount++;
	        }else{
	        	sb.append(Character.toChars(c));
	        }
	        
	    }
	    	    
	    return sb.toString();

	}


	public static String normalizeAlifWaslaToBareAlif(String text)
	{
		
		StringBuilder sb = new StringBuilder();
		
		int lettersCount = 0;
		
	    int count = Character.codePointCount(text, 0, text.length());
	    for (int i = 0; i < count; i++) {
	        int c = text.codePointAt(i);
	        
	        if ((c == NormalizationConstants.ALIF_WASLA_ABOVE))
	        {
	        	sb.append(Character.toChars(NormalizationConstants.ALIF));
	        	lettersCount++;
	        }else{
	        	sb.append(Character.toChars(c));
	        }
	        
	    }
	    	    
	    return sb.toString();

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

	public static List<String> tokenizeConcatenatedText(String text)
	{
		List<String> tokens = new ArrayList<String>();

		StringBuilder word = new StringBuilder();
		StringBuilder others = new StringBuilder();
		
	    int count = Character.codePointCount(text, 0, text.length());
	    for (int i = 0; i < count; i++) {
	        int c = text.codePointAt(i);
	        if (Character.isWhitespace(c) || 
	        	(c >= 0x0600 && c <=0x06E0) || 
	        	(c >= 0xFE70 && c<=0xFEFF))
	        {
	        	word.append(Character.toChars(c));
	        	
	        }else{
	        	others.append(Character.toChars(c));

	        }
	    }
	    	  
	    tokens.add(word.toString());
	    tokens.add(others.toString());
	    
	    return tokens;
	}

	public static String normalizeDiac(String s) {
        s = s.replace("ـ", "");
        int i, index;
        String s2;
        String[] CORRECT_DIAC = {"اَلْ", "ال", "اَل", "ال", "الْ", "ال", "الْ", "ال", "وَاَلْ", "وَال", "وَاَل", "وَال", "وَالْ", "وَال", "وَالْ", "وَال"};

        s2 = s;
        for (i = 0; i < CORRECT_DIAC.length / 2; i++) {
            index = s.indexOf(CORRECT_DIAC[i * 2]);
            if (index == 0) {
                s2 = String.format("%s%s", CORRECT_DIAC[i * 2 + 1], s.substring(index + CORRECT_DIAC[i * 2].length()));
                break;
            }
        }

        return s2;
    }
	
	   public static String removeDefaultDiac(String s) {
	        String out;

	        out = s;
	        out = out.replaceAll("َا", "ا");
	        out = out.replaceAll("ِي", "ي");
	        out = out.replaceAll("ُو", "و");
	        out = out.replaceAll("الْ", "ال");

	        out = out.replaceAll("ْ", "");

	        out = out.replaceAll("َّ", "َّ");
	        out = out.replaceAll("ِّ", "ِّ");
	        out = out.replaceAll("ُّ", "ُّ");
	        out = out.replaceAll("ًّ", "ًّ");
	        out = out.replaceAll("ٍّ", "ٍّ");
	        out = out.replaceAll("ٌّ", "ٌّ");

	        out = out.replaceAll("اَ", "ا");

	        // التقاء الساكنين: ref:اخْتِتَامُ, sys:اِخْتِتامُ
	        out = out.replaceAll("اِ", "ا");

	        return out;
	    }


}
