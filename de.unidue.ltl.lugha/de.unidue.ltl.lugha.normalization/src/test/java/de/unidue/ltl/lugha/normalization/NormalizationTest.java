package de.unidue.ltl.lugha.normalization;

import static org.junit.Assert.*;

import org.junit.Test;

public class NormalizationTest {

	@Test
	public void discardWhitespaceTest() {
		
		String withTatweel = "تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا";
		
//		String withoutExtraSpaces = NormalizeArabicText.discardExtraWhiteSpaces(withTatweel);		
//		assertEquals("تطويـــــــــــــــــــــــــــــــــــل هكـــــــــذا", withoutExtraSpaces);
		
		String normalized = TextNormalizer.normalizeText(withTatweel);
		assertEquals("تطويل هكذا", normalized);


	}
}
