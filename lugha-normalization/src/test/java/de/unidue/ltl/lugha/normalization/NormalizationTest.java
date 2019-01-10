/*******************************************************************************
 * Copyright 2019
 * Language Technology Lab
 * University of Duisburg-Essen, Germany
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
	
	@Test
	public void fullyNormalizeTatweelTest() {
		
		String text = "تطويـــــــــــــــــــــ123ــــــــــــــل         هكـــــــــذا";
				
		String normalized = TextNormalizer.fullyNormalizeText(text);
		assertEquals("تطويل هكذا", normalized);

	}
	
	@Test
	public void normalizeAlifsToBareFormTest() {
		
		String text = "آسامة";
				
		String normalized = TextNormalizer.normalizeAllAlifsToBareAlif(text);
		assertEquals("اسامة", normalized);

	}

}
