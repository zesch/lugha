package de.unidue.ltl.lugha.transliteration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HabashTest {

	@Test
	public void habashTest() {
		
		Transliterator habash = new HabashTransliterator();
		
		String text = "اعطى الولد البنت كتابا ساءل امْرَأَتِي";
		
		String latin = habash.getLatinString(text);
		
		assertEquals("AETY Alwld Albnt ktAbA sA'l Amora>atiy", latin);
	}
	
}
