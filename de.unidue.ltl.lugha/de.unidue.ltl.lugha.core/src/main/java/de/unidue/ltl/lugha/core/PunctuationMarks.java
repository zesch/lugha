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

public class PunctuationMarks {

	private static final Set<String> punctuations;

	static {

		Set<String> set = new HashSet<String>();
		
		set.add(",");
		set.add(":");
		set.add("،"); // Araic comma
		set.add("؛"); // Arabic semi-colons
		set.add("؟"); // Arabic question mark
		set.add("'");
		set.add("!");
		set.add("?");
		set.add("-");
		set.add("--");
		set.add("(");
		set.add(")");
		set.add("<<");
		set.add(">>");
		set.add("..."); // points of ellipsis.

		punctuations = Collections.unmodifiableSet(set);
	}

	public static Set<String> getPunctuations() {
		return punctuations;
	}
}
