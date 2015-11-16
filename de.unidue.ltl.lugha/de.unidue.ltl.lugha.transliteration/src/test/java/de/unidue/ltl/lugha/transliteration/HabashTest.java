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
 * This class contains a JTest for Arabic Habash's 1-to-1 Transliterator
 * 
 */

public class HabashTest {

	@Test
	public void habashTest() {
				
		BidiTransliterator habash = new HabashTransliterator();
		
		String arabic = "اعطى الولد البنت كتابا ساءل امْرَأَتِي";
		String latin = "AςTý Alwld Albnt ktAbA sA'l AmoraÂatiy";
		
		assertEquals(latin, habash.getLatinString(arabic));
		assertEquals(arabic, habash.getArabicString(latin));
	}
}
