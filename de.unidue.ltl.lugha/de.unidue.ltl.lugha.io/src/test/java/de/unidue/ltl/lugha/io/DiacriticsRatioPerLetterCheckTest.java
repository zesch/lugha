package de.unidue.ltl.lugha.io;


import org.junit.Test;

import de.unidue.ltl.lugha.io.util.DiacriticsRatioPerLetterCheck;

public class DiacriticsRatioPerLetterCheckTest {
	
	@Test
	public void testDiacriticsRatioPerLetter() throws Exception {
				
		System.out.println("Status:" + DiacriticsRatioPerLetterCheck.fullyDiacritized("عِلْم"));
		
		System.out.println("");
		
		System.out.println("Status:" + DiacriticsRatioPerLetterCheck.fullyDiacritized("عِلْمٍ"));//Tanween Kasr at m

		System.out.println("");
		
		System.out.println("Status:" + DiacriticsRatioPerLetterCheck.fullyDiacritized("عِلْمُ"));
		
	}


}
