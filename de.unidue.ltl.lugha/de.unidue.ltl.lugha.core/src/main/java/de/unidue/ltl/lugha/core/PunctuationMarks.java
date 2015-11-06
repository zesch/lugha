package de.unidue.ltl.lugha.core;

import java.util.HashSet;
import java.util.Set;

public class PunctuationMarks {

	public static Set<String> punctuations = new HashSet<String>();

	static {
		// TODO this looks copied :) is it?
		punctuations.add(",");
		punctuations.add(":");
		punctuations.add("،"); // Araic comma
		punctuations.add("؛"); // Arabic semi-colons
		punctuations.add("؟"); // Arabic question mark
		punctuations.add("'");
		punctuations.add("!");
		punctuations.add("?");
		punctuations.add("-");
		punctuations.add("--");
		punctuations.add("(");
		punctuations.add(")");
		punctuations.add("..."); // points of ellipsis.

	}

}
