package de.unidue.ltl.lugha.io.util;

public class ArabicDiacritic {

	private String diacritic;
	private String transliteration;
	
	public ArabicDiacritic(String diacritic, String transliteration) {
		super();
		this.diacritic = diacritic;
		this.transliteration = transliteration;
	}
	public String getDiacritic() {
		return diacritic;
	}
	public void setDiacritic(String diacritic) {
		this.diacritic = diacritic;
	}
	public String getTransliteration() {
		return transliteration;
	}
	public void setTransliteration(String transliteration) {
		this.transliteration = transliteration;
	}
}