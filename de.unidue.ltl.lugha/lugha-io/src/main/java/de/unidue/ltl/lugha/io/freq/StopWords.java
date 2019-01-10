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
package de.unidue.ltl.lugha.io.freq;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class StopWords {

	public static void main(String[] args) throws IOException {

	}
	
	public static Set<String> getArabciStopWords() throws IOException {
		
		List<String> stopWords = FileUtils.readLines(new File("src/main/resources/corpora/stopwords.txt"), "utf-8");		

		stopWords.addAll( FileUtils.readLines(new File("src/main/resources/corpora/stopwords-ar.txt"), "utf-8") );
		
		Set<String> stopWordsSet = new HashSet<String>();
		
		
		for(String stopWord: stopWords)
			stopWordsSet.add(stopWord);

		stopWordsSet.add("ال");
		stopWordsSet.add("ات");
		stopWordsSet.add("ون");
		
		stopWordsSet.add("الا");
		stopWordsSet.add("إِلَّا");

		stopWordsSet.add("إلا");

		stopWordsSet.add("يا");

		stopWordsSet.add("إنما");

		stopWordsSet.add("أيها");
		
		return stopWordsSet;
	}


}
