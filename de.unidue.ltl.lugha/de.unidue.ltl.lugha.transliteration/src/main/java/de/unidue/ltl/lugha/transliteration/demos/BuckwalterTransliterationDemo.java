package de.unidue.ltl.lugha.transliteration.demos;

import java.io.*;


import de.unidue.ltl.lugha.transliteration.BuckwalterTransliterator;
import de.unidue.ltl.lugha.transliteration.HabashTransliterator;
import de.unidue.ltl.lugha.transliteration.Transliterator;


public class BuckwalterTransliterationDemo {

	public static void main(String[] args) {

//		readFile("src/main/resources/A-D.txt");
//		readFile("src/main/resources/A-ND.txt");
//		readFile("src/main/resources/B-ND.txt");
		readFile("src/main/resources/B-D.txt");
		
	}
	
	public static String showBuckwalterTransliteration(String arabicString) {
		
		Transliterator buckwalter = new BuckwalterTransliterator();
		
		return buckwalter.getLatinString(arabicString);
		
	}//AETY Alwld Albnt ktAbA sA'l Amora>atiy

	public static void readFile(String FILENAME) {

			BufferedReader br = null;
			FileReader fr = null;

			try {

				fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);

				String sCurrentLine;

				br = new BufferedReader(new FileReader(FILENAME));

				while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(showBuckwalterTransliteration(sCurrentLine));
				}

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}

	}
	
}