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
		assertEquals("الرَّحْمَن الرَّحِيم", withoutAdditionalDiacritics);
		
		String withSukun = "بِسْمِ";
		String withoutSukun = DiacriticsRemover.removeSukun(withSukun);	
		assertEquals("بِسمِ", withoutSukun);
	}
	
	@Test
	public void testDiacriticsRemoverTest() {
		assertEquals(false, DiacriticsRemover.hasCaseEndings("تقوم"));		
		assertEquals(false, DiacriticsRemover.hasCaseEndings("عِلْم"));
		assertEquals(true, DiacriticsRemover.hasCaseEndings("بِسمِ"));//Kasra		
		assertEquals(true, DiacriticsRemover.hasCaseEndings("ذَكَرٌ"));//Damma		
		assertEquals(true, DiacriticsRemover.hasCaseEndings("بَيَّتَ"));//Fatha		
		assertEquals(true, DiacriticsRemover.hasCaseEndings("عِلْمً"));//Fathataan		
		assertEquals(true, DiacriticsRemover.hasCaseEndings("عَيَّنَّ"));//Fathataan		
	}


}
