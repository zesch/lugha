package de.unidue.ltl.lugha.io;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import de.unidue.ltl.lugha.io.freq.StopWords;

public class StopWordsTest {
	
	@Test
	public void testStopWords() throws Exception {
		
		Set<String> set = StopWords.getArabciStopWords();
		
   	 	System.out.println("Size: " + set.size());

		String stopWord = "يفعلان";
		
		assertEquals(true, set.contains(stopWord));

	}

}
