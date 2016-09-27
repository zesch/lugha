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
		
		
		String withAdditionalDiacritics = "الرَّحْمٰن الرَّحِيم";
		
		String withoutAdditionalDiacritics = DiacriticsRemover.replaceAdditionalDiacritics(withAdditionalDiacritics);	
		
		System.out.println(withoutAdditionalDiacritics);

		assertEquals("الرَّحْمَن الرَّحِيم", withoutAdditionalDiacritics);

		
		String withSukun = "بِسْمِ";
		
		String withoutSukun = DiacriticsRemover.removeSukun(withSukun);	
		
		System.out.println(withoutSukun);

		assertEquals("بِسمِ", withoutSukun);


	}

}
