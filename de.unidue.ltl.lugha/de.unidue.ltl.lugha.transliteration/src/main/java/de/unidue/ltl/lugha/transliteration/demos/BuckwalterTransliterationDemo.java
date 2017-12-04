package de.unidue.ltl.lugha.transliteration.demos;

import java.io.*;
import java.util.List;

import de.unidue.ltl.lugha.transliteration.BuckwalterTransliterator;
import de.unidue.ltl.lugha.transliteration.HabashTransliterator;
import de.unidue.ltl.lugha.transliteration.Transliterator;
//import de.unidue.ltl.lugha.io.SimpleReader;

public class BuckwalterTransliterationDemo {

	public static void main(String[] args) throws Exception{
		
//		System.out.println(showBuckwalterTransliteration("اتصل"));
		;
		List<String> list = null;
		
//		list = readFile("src/main/resources/A-D.txt");
//		list = readFile("src/main/resources/A-ND.txt");
//		list = readFile("src/main/resources/B-ND.txt");
		
//		list = SimpleReader.readFile("src/main/resources/B-D.txt");
//		
//		for(String line: list)
//			System.out.println(showBuckwalterTransliteration(line));

	}
	
	public static String showBuckwalterTransliteration(String arabicString) {
		
		Transliterator buckwalter = new BuckwalterTransliterator();
		
		return buckwalter.getLatinString(arabicString);
		
	}//AETY Alwld Albnt ktAbA sA'l Amora>atiy


	
}