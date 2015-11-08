package de.unidue.ltl.lugha.normalization;

import static org.junit.Assert.*;

import org.junit.Test;

import de.unidue.ltl.lugha.normalization.helper.Preporcessing;

public class NormalizationTest {

	@Test
	public void discardWhitespaceTest() {
		
		String withTatweel = "تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا";
		
		String withoutExtraSpaces = Preporcessing.discardExtraWhiteSpaces(withTatweel);		
		assertEquals("تطويـــــــــــــــــــــــــــــــــــل هكـــــــــذا", withoutExtraSpaces);
		

	}
}
