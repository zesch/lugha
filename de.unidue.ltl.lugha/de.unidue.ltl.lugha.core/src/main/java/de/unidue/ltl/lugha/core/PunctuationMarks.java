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

public class PunctuationMarks {

	/**
	 * 
	 * This class contains the set of 13 Arabic punctuation marks
	 * 
	 */
	
	public static final Set<String> punctuations;

	static {

		Set<String> set = new HashSet<String>();

		set.add(",");
		set.add(":");
		set.add("،"); // Arabic comma
		set.add("؛"); // Arabic semi-colons
		set.add("؟"); // Arabic question mark
		set.add("'");
		set.add("!");
		set.add("?");
		set.add("-");
		set.add("--");
		set.add("(");
		set.add(")");
		set.add("..."); // points of ellipsis.	
		
		punctuations = Collections.unmodifiableSet(set);
		
	}

}
