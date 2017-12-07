package de.unidue.ltl.lugha.io;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unidue.ltl.lugha.io.util.FullyDiacritizedWordCheck;

public class FullyDiacritizedWordCheckTest {
	
	@Test
	public void testFullyDiacritizedWordCheck() throws Exception {
				
		assertEquals(false, FullyDiacritizedWordCheck.fullyDiacritized("عِلْم"));
		
		System.out.println("");
		
		assertEquals(true, FullyDiacritizedWordCheck.fullyDiacritized("عِلْمٍ"));//Tanween Kasr at m

		System.out.println("");
		
		assertEquals(true, FullyDiacritizedWordCheck.fullyDiacritized("عِلْمُ"));
		
	}


}
