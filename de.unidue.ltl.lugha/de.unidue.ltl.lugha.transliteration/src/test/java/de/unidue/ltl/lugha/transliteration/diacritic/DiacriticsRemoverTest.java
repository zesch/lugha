package de.unidue.ltl.lugha.transliteration.diacritic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unidue.ltl.lugha.transliteration.diacritic.DiacriticsRemover;

public class DiacriticsRemoverTest {

	@Test
	public void diacriticsRemoverTest() {
		  	
    	String withDiacritics = "رَبِّ أَعِنِّي وَلَا تُعِنْ عَلَيَّ وَانْصُرْنِي وَلَا تَنْصُرْ عَلَيَّ";
    	String withoutDiacritics = DiacriticsRemover.removeDiacritics(withDiacritics);		
		assertEquals("رب أعني ولا تعن علي وانصرني ولا تنصر علي", withoutDiacritics);

	}

}
