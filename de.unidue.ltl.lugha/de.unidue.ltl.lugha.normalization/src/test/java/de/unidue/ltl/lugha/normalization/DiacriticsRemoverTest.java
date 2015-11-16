/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unidue.ltl.lugha.normalization.DiacriticsRemover;

/**
 * 
 * This class contains a JTest for Arabic diacritics remover
 * 
 */

public class DiacriticsRemoverTest {

	@Test
	public void diacriticsRemoverTest() {
		  	
    	String withDiacritics = "قَامَ الْقَسَمِ الْعَرَبِيِّ فِيْ جُوْجِلْ بِبَرْمَجَةٌ أَدَاةِ مُفِيْدَةٍ تَقُوْمُ بِتَشْكِيْلَ الْكَلِمَاتِ";
    	
    	String withoutDiacritics = DiacriticsRemover.removeDiacritics(withDiacritics);
    	
		assertEquals("قام القسم العربي في جوجل ببرمجة أداة مفيدة تقوم بتشكيل الكلمات", withoutDiacritics);

	}

}
