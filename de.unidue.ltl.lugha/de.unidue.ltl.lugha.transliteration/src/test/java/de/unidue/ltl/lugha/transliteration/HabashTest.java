package de.unidue.ltl.lugha.transliteration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
