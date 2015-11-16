/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.transliteration;

import org.apache.commons.collections.BidiMap;

/**
 * Abstract base class for bidimap based @BidiTransliterator 
 * 
 */
public abstract class BidiMapTranslitator 
	implements BidiTransliterator
{

	protected abstract BidiMap getBidiMap();

	public String getLatinString(String arabicString) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arabicString.length(); i++)
		{	
			String unigram = arabicString.substring(i, i + 1);
	
			if (getBidiMap().containsKey(unigram) ) {
				sb.append(getBidiMap().get(unigram));
			}
			else {	
				sb.append(unigram);
			}
		}
		
		return sb.toString();
		
	}

	public String getArabicString(String latinString) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < latinString.length(); i++)
		{	
			String unigram = latinString.substring(i, i + 1);
	
			if (getBidiMap().containsValue(unigram) ) {
				sb.append(getBidiMap().getKey(unigram));
			}
			else {	
				sb.append(unigram);
			}
		}
		
		return sb.toString();
	}
}