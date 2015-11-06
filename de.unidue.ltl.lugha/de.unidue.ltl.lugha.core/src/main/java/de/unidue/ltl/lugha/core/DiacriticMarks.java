package de.unidue.ltl.lugha.core;

import java.util.HashSet;
import java.util.Set;

public class DiacriticMarks {

	public static Set<String> diacritics = new HashSet<String>();

	static {

		diacritics.add("\u064B"); // FATHATAN
		diacritics.add("\u064C"); // DAMMATAN
		diacritics.add("\u064D"); // KASRATAN
		diacritics.add("\u064E"); // FATHA
		diacritics.add("\u064F"); // DAMMA
		diacritics.add("\u0650"); // KASRA
		diacritics.add("\u0651"); // SHADDA
		diacritics.add("\u0652"); // SUKUN
	}

}
