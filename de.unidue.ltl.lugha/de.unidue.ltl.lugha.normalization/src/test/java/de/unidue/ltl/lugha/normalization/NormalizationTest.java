package de.unidue.ltl.lugha.normalization;

import static org.junit.Assert.*;

import org.junit.Test;

public class NormalizationTest {

	@Test
	public void discardWhitespaceTest() {
		String tatweel = "تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا";
		String normalized = NormalizeArabicText.discarddExtraWhiteSpaces(tatweel);
		assertEquals("تطويـــــــــــــــــــــــــــــــــــل هكـــــــــذا", normalized);
	}
}
