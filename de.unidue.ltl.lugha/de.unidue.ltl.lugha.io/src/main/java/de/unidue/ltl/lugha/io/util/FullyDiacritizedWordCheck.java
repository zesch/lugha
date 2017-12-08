package de.unidue.ltl.lugha.io.util;

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
}