package de.unidue.ltl.lugha.io;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unidue.ltl.lugha.io.util.FullyDiacritizedWordCheck;

public class FullyDiacritizedWordCheckTest {
	
//	@Test
//	public void testFullyDiacritizedWordCheck1() throws Exception {
//				
//		assertEquals(false, FullyDiacritizedWordCheck.fullyDiacritized("عِلْم"));		
//		System.out.println("");
//		
//		assertEquals(true, FullyDiacritizedWordCheck.fullyDiacritized("عِلْمٍ"));//Tanween Kasr at m
//		System.out.println("");
//		
//		assertEquals(true, FullyDiacritizedWordCheck.fullyDiacritized("عَلِمْ"));
//		System.out.println("");
//		
//		assertEquals(true, FullyDiacritizedWordCheck.fullyDiacritized("عِلْمُ"));
//		
//	}

	@Test
	public void testFullyDiacritizedWordCheck2() throws Exception {
				
		assertEquals(false, FullyDiacritizedWordCheck.isFullyDiacritized("ذُكِر"));		
		System.out.println("");
		
		assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَّرَ"));
		System.out.println("");
		
		assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَرٌ"));
		System.out.println("");
		
		assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَرٌ"));
		System.out.println("");		
		
		assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("عَقْلٍ"));//Tanween Kasr at l
		
	}


}
