package de.unidue.ltl.lugha.transliteration.diacritic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unidue.ltl.lugha.transliteration.diacritic.DiacriticsRemover;

public class DiacriticsRemoverTest {

	@Test
	public void diacriticsRemoverTest() {
		
		String withoutDiacritics = "";
		
//    	String sublimation = "اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ، وَعَلَى آلِ مُحَمَّدٍ";
//    	withoutDiacritics = DiacriticsRemover.removeDiacritics(sublimation);
//    	assertEquals("اللهم صل على محمد، وعلى آل محمد", withoutDiacritics);
    	
    	String duaa = "رَبِّ أَعِنِّي وَلَا تُعِنْ عَلَيَّ وَانْصُرْنِي وَلَا تَنْصُرْ عَلَيَّ";
		withoutDiacritics = DiacriticsRemover.removeDiacritics(duaa);		
		assertEquals("رب أعني ولا تعن علي وانصرني ولا تنصر علي", withoutDiacritics);

	}

}
