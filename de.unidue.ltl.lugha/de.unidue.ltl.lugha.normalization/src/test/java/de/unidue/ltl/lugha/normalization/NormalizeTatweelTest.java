package de.unidue.ltl.lugha.normalization;

import static org.junit.Assert.*;

import org.junit.Test;

import de.unidue.ltl.lugha.normalization.helper.Preporcessing;

public class NormalizeTatweelTest {

	@Test
	public void normalizeTatweelTest() {
		
		String withTatweel = "تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا";
				
		String normalized = TextNormalizer.normalizeText(withTatweel);
		assertEquals("تطويل هكذا", normalized);

	}
}
