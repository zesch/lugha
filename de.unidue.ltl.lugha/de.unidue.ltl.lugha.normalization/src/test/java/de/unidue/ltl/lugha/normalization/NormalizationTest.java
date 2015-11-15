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

/**
 * 
 * This class contains a JTest for Arabic Normalization, i.e. the removal 
 * of Arabic specific letters:
 * 
 * 1- Removing extra spaces.
 * 2- Removing Arabic prolongation letter.
 * 
 */

public class NormalizationTest {

	@Test
	public void normalizeTatweelTest() {
		
		String withTatweel = "تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا";
				
		String normalized = TextNormalizer.normalizeText(withTatweel);
		assertEquals("تطويل هكذا", normalized);

	}
}
