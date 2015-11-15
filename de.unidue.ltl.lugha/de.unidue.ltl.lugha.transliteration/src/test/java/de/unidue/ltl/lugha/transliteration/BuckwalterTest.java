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
		
		Transliterator buckwalter = new BuckwalterTransliterator();
		
		String text = "";
		String latin = "";
		
//		text = "تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا";
//		latin = buckwalter.getLatinString(text);		
//		assertEquals("tTwyl hk*A", latin);
		
		text = "اعطى الولد البنت كتابا ساءل امْرَأَتِي";		
		latin = buckwalter.getLatinString(text);	
		assertEquals("AETY Alwld Albnt ktAbA sA'l Amora>atiy", latin);
		
	}
	
}
