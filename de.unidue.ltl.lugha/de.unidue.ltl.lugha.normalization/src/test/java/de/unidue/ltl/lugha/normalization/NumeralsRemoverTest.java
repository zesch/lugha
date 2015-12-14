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

import de.unidue.ltl.lugha.normalization.NumeralsRemover;

/**
 * 
 * This class contains a JTest for Arabic numerals remover
 * 
 */

public class NumeralsRemoverTest {

	@Test
	public void diacriticsRemoverTest() {
		  	
    	String withNumerals = "قال المدير1 عندنا اجتماع2 بعد قليل3";
    	
    	String withoutNumerals = NumeralsRemover.removeNumerals(withNumerals);
    	
		assertEquals("قال المدير عندنا اجتماع بعد قليل", withoutNumerals);

	}

}
