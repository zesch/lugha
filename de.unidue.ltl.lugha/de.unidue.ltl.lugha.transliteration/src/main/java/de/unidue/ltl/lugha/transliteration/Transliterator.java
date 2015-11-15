/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.transliteration;

/**
 * 
 * This interface is being implemented by different Transliteration schemes.
 * 
 */

public interface Transliterator {
	
	public String getLatinString(String arabicString);

}
