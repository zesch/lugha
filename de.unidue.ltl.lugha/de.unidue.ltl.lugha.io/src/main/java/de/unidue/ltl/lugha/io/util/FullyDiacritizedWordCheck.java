package de.unidue.ltl.lugha.io.util;

import de.unidue.ltl.lugha.core.DiacriticMarks;
import de.unidue.ltl.lugha.transliteration.BuckwalterTransliterator;


public class FullyDiacritizedWordCheck {
	
	
	public static boolean fullyDiacritized(String token) {
		
		token = token.trim();
		
		System.out.println("'" + token + "'");
		System.out.println(token.length());
		
		// cannot be fully diacritized, if it contains only one character
		if (token.length() < 2) {
			return false;
		}
		
		ArabicString arString =  new ArabicString(new BuckwalterTransliterator());
		arString.initialize(token);
				
		for (ArabicLetter letter: arString.getLetters()){
			if (letter.hasDiacritics()) {
				return false;
			}
		}

        return true;
	}
	
	public static boolean isFullyDiacritized(String token) {
		StringBuilder sb = new StringBuilder();
				
		for (int i=0; i<token.length(); i++) {
			String ch = token.substring(i, i+1);
			
			if (DiacriticMarks.isDiacritic(ch)) {
				sb.append("d");
			}
			else {
				sb.append("c");
			}
		}
		String pattern = sb.toString().replaceAll("d+", "d");
		
		return pattern.matches("cd+");
	}
	
	
//	public static boolean isFullyDiacritized(String token) {
//		
//		boolean hasDiacritics = false;
//		
//		for (int i=0; i<token.length(); i++) {
//			String ch = token.substring(i, i+1);
//			
//			if (DiacriticMarks.getDiacritics().contains(ch)) {
//				hasDiacritics = true;
//			}
//			else {
//				if (!hasDiacritics) {
//					return false;
//				}
//				
//				// as we have seen a new character, clear the diacritics flag
//				hasDiacritics = false;
//			}
//		}
//		
//		return true;
//	}
}