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

package de.unidue.ltl.lugha.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that holds the 8 diacritic marks in Arabic.
 *
 */
public class DiacriticMarks {

	private static final Set<String> diacritics;
	
	private static final Set<String> additionalDiacritics;

	static {

		Set<String> set = new HashSet<String>();
		
		set.add("\u064B"); // FATHATAN
		set.add("\u064C"); // DAMMATAN
		set.add("\u064D"); // KASRATAN
		set.add("\u064E"); // FATHA
		set.add("\u064F"); // DAMMA
		set.add("\u0650"); // KASRA
		set.add("\u0651"); // SHADDA
		set.add("\u0652"); // SUKUN
		
		diacritics = Collections.unmodifiableSet(set);
		
		set = new HashSet<String>();
		set.add("\u0670"); // Dagger alif
		
		additionalDiacritics = Collections.unmodifiableSet(set);
	}

	public static Set<String> getDiacritics() {
		return diacritics;
	}

	public static Set<String> getAdditionaldiacritics() {
		return additionalDiacritics;
	}
	
	public static boolean isDiacritic(String text) {
		if (text.length() > 1) {
			return false;
		}
		else {
			return getDiacritics().contains(text);
		}
	}	
}
