package de.unidue.ltl.lugha.transliteration;

/**
 * A transliterator that can convert an Arabic string into a Latin representation and vice versa
 */
public interface BidiTransliterator 
	extends Transliterator
{
	/**
	 * @param latinString a String with text in the Latin alphabet
	 * @return A transliterated version in the Arabic alphabet
	 */
	public String getArabicString(String latinString);

}
