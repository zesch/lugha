/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;


import de.unidue.ltl.lugha.core.DiacriticMarks;


/**
 * Normalizes Arabic text by removing diacritic marks
 */
public class DiacriticsRemover {

	/**
	 * Removes all diacritic marks in a given text.
	 * 
	 * @param text
	 * 	The input text, e.g.: "قَامَ الْقَسَمِ الْعَرَبِيِّ فِيْ جُوْجِلْ بِبَرْمَجَةٌ أَدَاةِ مُفِيْدَةٍ تَقُوْمُ بِتَشْكِيْلَ الْكَلِمَاتِ" 
	 *            
	 * @return The text without diacritics, e.g. "قام القسم العربي في جوجل ببرمجة أداة مفيدة تقوم بتشكيل الكلمات"
	 */
	public static String removeDiacritics(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < normalizedText.length(); i++) {
			String unigram = text.substring(i, i + 1);
				if (!DiacriticMarks.getDiacritics().contains(unigram))
				{
					sb.append(unigram);
				}
		}
		
		return sb.toString();
	}
	
	/**
	 * Replace Dager Alf with Fatha, we might include others
	 * @param text
	 * @return
	 */
	public static String replaceAdditionalDiacritics(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < normalizedText.length(); i++) {
			String unigram = text.substring(i, i + 1);
				if (!DiacriticMarks.getAdditionaldiacritics().contains(unigram))
				{
					sb.append(unigram);
				}else{
					sb.append("\u064E");
				}
		}
		
		return sb.toString();
	}
	
	public static String removeSukun(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder(); 
		
		for (int i = 0; i < normalizedText.length(); i++) {
			
			String unigram = text.substring(i, i + 1);
			
				if (! unigram.equals("\u0652") )
				{
					sb.append(unigram);
				}
		}
		
		return sb.toString();

	}

	public static String removeTanweenFath(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder(); 
		
		for (int i = 0; i < normalizedText.length(); i++) {
			
			String unigram = text.substring(i, i + 1);
			
				if (! unigram.equals("\u064B") )
				{
					sb.append(unigram);
				}
		}
		
		return sb.toString();

	}


	public static String removeTanweenDamm(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder(); 
		
		for (int i = 0; i < normalizedText.length(); i++) {
			
			String unigram = text.substring(i, i + 1);
			
				if (! unigram.equals("\u064C") )
				{
					sb.append(unigram);
				}
		}
		
		return sb.toString();

	}


	public static String removeTanweenKasr(String text) {
		
		String normalizedText = TextNormalizer.normalizeText(text);

		StringBuilder sb = new StringBuilder(); 
		
		for (int i = 0; i < normalizedText.length(); i++) {
			
			String unigram = text.substring(i, i + 1);
			
				if (! unigram.equals("\u064D") )
				{
					sb.append(unigram);
				}
		}
		
		return sb.toString();

	}
	
	public static String lastLetterDiacritics(String text) {
		
		for(String diac : DiacriticMarks.getDiacritics()){
			
			if (text.endsWith(diac)){
				return diac;
			}
		}
		
		return "";
		
	}
	
	public static boolean hasCaseEndings(String text) {
		
		for(String diac : DiacriticMarks.getDiacritics()){
			
			if (text.endsWith(diac)){
				return true;
			}
		}
		
		return false;
		
	}

	/**
	 * To remove last letter diacritics (case-endings), sometimes the last letter has 2 diacritics (one of them is Shadda), this is why it is recursive method
	 * @param text
	 * @return
	 */
	public static String removeLastLetterDiacritics(String text) {
		
		String normalizedWord = TextNormalizer.normalizeText(text);

		
        String str = "";
        
		if(hasCaseEndings(normalizedWord)){
			
			return removeLastLetterDiacritics  (normalizedWord.substring(0,normalizedWord.length()-1));
			
		}
		
//		System.out.println("-->: "+ normalizedWord);

		return str;

	}



}
