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
		
}
