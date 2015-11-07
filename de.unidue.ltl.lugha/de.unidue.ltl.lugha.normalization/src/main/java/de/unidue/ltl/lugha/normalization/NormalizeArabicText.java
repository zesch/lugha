package de.unidue.ltl.lugha.normalization;

public class NormalizeArabicText {

	public static String normalizeTatweel(String currentText) 

	{
						
		String result = currentText.replaceAll(NormalizationConstants.TATWEEL, "");		
		
		return result;
	}

}
