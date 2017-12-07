package de.unidue.ltl.lugha.io.util;

import de.unidue.ltl.lugha.transliteration.BuckwalterTransliterator;


public class FullyDiacritizedWordCheck {
	
	
	public static boolean fullyDiacritized(String token) {
		
		boolean status = true;
		
		ArabicString arString =  new ArabicString(
				new BuckwalterTransliterator());
		
		arString.initialize(token);
				
		
		for (ArabicLetter letter: arString.getLetters()){
			
			if(letter.getDiacritics().size() == 0){
				System.out.println("Letter has no diacritics: " + letter.getLetter() );
				status = false;
			}
		}

        
        System.out.println("("+token+")  fully diacritized, status: " + status );
        
        return status;

	}
	
}
