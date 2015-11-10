package de.unidue.ltl.lugha.transliteration;

import de.unidue.ltl.lugha.normalization.TextNormalizer;

public class BuckwalterTransliterator 
	implements Transliterator
{
	

	public  String getLatinString(String arabicString) {
		
		String normalizedText = TextNormalizer.normalizeText(arabicString);

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < normalizedText.length(); i++) {
			
			String unigram = arabicString.substring(i, i + 1);
			
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
