/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.transliteration;

import de.unidue.ltl.lugha.normalization.TextNormalizer;

/**
 * 
 * This class implements getLatinString() method found in interface:
 * @link:de.unidue.ltl.lugha.transliteration.Transliterator
 * The provided transliteration confirms with Habash et. al scheme.
 * 
 */
public class HabashTransliterator 
	implements Transliterator
{

	public String getLatinString(String arabicString)
	{

		// I would not call normalize implicitly here
		String normalizedArabicText = TextNormalizer.normalizeText(arabicString);
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < normalizedArabicText.length(); i++)
		{

			String unigram = normalizedArabicText.substring(i, i + 1);
			if (HabashTransliterationTable.unicodeMap.containsKey(unigram))
			{
				sb.append(HabashTransliterationTable.unicodeMap.get(unigram));
			} 
			else {
				sb.append(unigram);
			}
		}

		return sb.toString();
	}
}