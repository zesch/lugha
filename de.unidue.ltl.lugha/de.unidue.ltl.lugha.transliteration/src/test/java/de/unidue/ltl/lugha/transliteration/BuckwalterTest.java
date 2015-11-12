package de.unidue.ltl.lugha.transliteration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
