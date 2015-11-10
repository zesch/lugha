package de.unidue.ltl.lugha.transliteration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuckwalterTest {

	@Test
	public void buckwalterTest() {
		
		Transliterator buckwalter = new BuckwalterTransliterator();
		
		String text = "اعطى الولد البنت كتابا ساءل امْرَأَتِي";
		
		String latin = buckwalter.getLatinString(text);
		
		assertEquals("AETY Alwld Albnt ktAbA sA'l Amora>atiy", latin);
	}
	
}
