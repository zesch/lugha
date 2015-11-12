package de.unidue.ltl.lugha.transliteration;

import de.unidue.ltl.lugha.normalization.TextNormalizer;

public class BuckwalterTransliterator 
	implements Transliterator
{
	

	public  String getLatinString(String arabicString) {
		
		String normalizedArabicText = TextNormalizer.normalizeText(arabicString);

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < normalizedArabicText.length(); i++) {
			
			String unigram = normalizedArabicText.substring(i, i + 1);
			
				if ( BuckwalterTransliterationTable.unicodeMap.containsKey(unigram) )
				{
					
					sb.append(BuckwalterTransliterationTable.unicodeMap.get(unigram));
					
				}else{
					
					sb.append(unigram);
					
				}
		}
		
		
		return sb.toString();
		
	}

}
