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
		
		List<String> stopWords = FileUtils.readLines(new File("corpora/stopwords.txt"));		

		stopWords.addAll( FileUtils.readLines(new File("corpora/stopwords-ar.txt")) );
		
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
