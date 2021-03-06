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
package de.unidue.ltl.lugha.transliteration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * This class contains a JTest for Arabic Buckwalter's 1-to-1 Transliterator
 * 
 */

public class BuckwalterTest {

	@Test
	public void buckwalterTest() {
		
		Transliterator buckwalter = new BuckwalterTransliterator();

		String arabic = "اعطى الولد البنت كتابا ساءل امْرَأَتِي";
		String latin = "AETY Alwld Albnt ktAbA sA'l Amora>atiy";
		
		assertEquals(latin, buckwalter.getLatinString(arabic));
		assertEquals(arabic, buckwalter.getArabicString(latin));		
	}
}