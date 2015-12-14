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
 * Class that holds the Arabic Punctuation marks.
 * @web: http://blogs.transparent.com/arabic/punctuation-in-arabic/ 
 */

public class PunctuationMarks {

	private static final Set<String> punctuations;

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
		set.add("”");//right quotation marks.
		set.add("“");//left quotation marks. 
		
		set.add(".");
		set.add("{");
		set.add("}");		
		set.add("[");
		set.add("]");		
		set.add("/");


		punctuations = Collections.unmodifiableSet(set);
	}
	
	public static Set<String> getPunctuationMarks() {
		return punctuations;
	}
}