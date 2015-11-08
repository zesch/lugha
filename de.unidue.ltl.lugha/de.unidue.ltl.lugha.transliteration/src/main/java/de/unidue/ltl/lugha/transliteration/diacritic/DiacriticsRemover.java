package de.unidue.ltl.lugha.transliteration.diacritic;


import de.unidue.ltl.lugha.core.DiacriticMarks;
import de.unidue.ltl.lugha.normalization.helper.Preporcessing;


public class DiacriticsRemover {

	public static String removeDiacritics(String currentText) {

		
		String modifiedText = Preporcessing
				.discardExtraWhiteSpaces(currentText);

		for (int i = 0; i < modifiedText.length(); i++) {

			String unigram = modifiedText.substring(i, i + 1);
			
				if ( true == DiacriticMarks.diacritics.contains(unigram) ){
					
					modifiedText = modifiedText.replaceAll(unigram, "");
					
				}
		}
		
		
		return modifiedText;
	}

}
