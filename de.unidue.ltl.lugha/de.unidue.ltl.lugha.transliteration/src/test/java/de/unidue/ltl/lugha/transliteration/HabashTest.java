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
		
		Transliterator habash = new HabashTransliterator();
		
		String text = "";
		String latin = "";
		
//		text = "أُرِيــــدُ كِــــتـابــاً‏";
//		latin = habash.getLatinString(text);	
//		assertEquals("Âuriydu kitAbAã", latin);

//		text = "أُرِيدُ كِتاباً‏";
//		latin = habash.getLatinString(text);	
//		assertEquals("Âuriydu kitAbAã", latin);

		text = "تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا";
		latin = habash.getLatinString(text);	
		assertEquals("tTwyl hkðA", latin);
		
		
	}
	
}
