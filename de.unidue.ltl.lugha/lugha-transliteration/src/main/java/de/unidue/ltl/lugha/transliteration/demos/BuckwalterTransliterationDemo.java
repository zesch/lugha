/*******************************************************************************
 * Copyright 2019
 * Language Technology Lab
 * University of Duisburg-Essen, Germany
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
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