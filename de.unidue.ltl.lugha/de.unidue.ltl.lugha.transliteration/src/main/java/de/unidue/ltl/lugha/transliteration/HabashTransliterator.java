package de.unidue.ltl.lugha.transliteration;

import de.unidue.ltl.lugha.normalization.TextNormalizer;

/**
 * TODO
 */
public class HabashTransliterator 
	implements Transliterator
{

	public String getLatinString(String arabicString)
	{

		// I would not call normalize implicitly here
		String normalizedText = TextNormalizer.normalizeText(arabicString);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < normalizedText.length(); i++)
		{

			String unigram = arabicString.substring(i, i + 1);
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