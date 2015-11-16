/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.transliteration;

/**
 * A transliterator takes an Arabic input string and converts it into a representation in the Latin alphabet.
 * 
 */
public interface Transliterator {
	
	/**
	 * @param arabicString a String with Arabic text
	 * @return A transliterated version in the Latin alphabet
	 */
	public String getLatinString(String arabicString);

}
