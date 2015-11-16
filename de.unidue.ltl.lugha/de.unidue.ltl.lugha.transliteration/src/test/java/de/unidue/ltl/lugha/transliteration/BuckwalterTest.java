/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.transliteration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * This class contains a JTest for Arabic Buckwalter's 1-to-1 Transliterator
 * 
 */

public class BuckwalterTest {

	@Test
	public void buckwalterTest() {
		
		BidiTransliterator buckwalter = new BuckwalterTransliterator();
		
		String arabic = "اعطى الولد البنت كتابا ساءل امْرَأَتِي";
		String latin = "AETY Alwld Albnt ktAbA sA'l Amora>atiy";
		
		assertEquals(latin, buckwalter.getLatinString(arabic));
		assertEquals(arabic, buckwalter.getArabicString(latin));		
	}
}