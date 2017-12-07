package de.unidue.ltl.lugha.io.util;

import java.util.ArrayList;
import java.util.List;

public class ArabicLetter {

	private String letter;
	private String transliteration;
	private List<ArabicDiacritic> diacritics;
	
	public ArabicLetter() {
		super();
		diacritics = new ArrayList<ArabicDiacritic>();
	}
	
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public String getTransliteration() {
		return transliteration;
	}
	public void setTransliteration(String transliteration) {
		this.transliteration = transliteration;
	}
	public List<ArabicDiacritic> getDiacritics() {
		return diacritics;
	}
	public void setDiacritics(List<ArabicDiacritic> diacritics) {
		this.diacritics = diacritics;
	}

	public String getDiacriticsAr() {
		
		String str ="";
		
		for (ArabicDiacritic obj : diacritics){
			str += obj.getDiacritic();
		}
		
		return str;
		
	}
	
	public String getDiacriticsTransliterated() {
		
		String str ="";
		
		/**
		 * TODO:
		 */
		
		for (ArabicDiacritic obj : diacritics){
			
//			if (obj.getTransliteration().equals("*")) {
//				str += "ð";
//			}
			if (obj.getTransliteration().equals("~")) {
				str += "B";
			}
			else {
				str += obj.getTransliteration();				
			}
		}
		
		if (str.equals("")) {
			str = "none";
		}
		
		return str;

	}	
	
}
