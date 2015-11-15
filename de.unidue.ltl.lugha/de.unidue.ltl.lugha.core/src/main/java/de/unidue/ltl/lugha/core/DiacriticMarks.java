/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @Web: http://blogs.transparent.com/arabic/2-arabic-diacritics-al-tashkeel-الـتـشـكـيـــل/
 *
 */

public class DiacriticMarks {

	/**
	 * 
	 * This class contains the basic set of 8 Arabic diacritic marks
	 * 
	 */

	public static final Set<String> diacritics;

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
		
	}

}
