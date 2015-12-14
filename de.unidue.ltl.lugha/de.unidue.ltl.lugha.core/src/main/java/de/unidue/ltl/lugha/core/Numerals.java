/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.core;

import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

/**
 * Class that holds the Arabic Numerals to be removed from text.
 *
 */

public class Numerals {

	private static final Set<String> numeralsAr;

	static {

		Set<String> set = new HashSet<String>();

		set.add("0");
		set.add("1");
		set.add("2");	
		set.add("3");
		set.add("4");		
		set.add("5");
		set.add("6");
		set.add("7");	
		set.add("8");
		set.add("9");		


		numeralsAr = Collections.unmodifiableSet(set);
	}
	
	public static Set<String> getNumerals() {
		return numeralsAr;
	}
}