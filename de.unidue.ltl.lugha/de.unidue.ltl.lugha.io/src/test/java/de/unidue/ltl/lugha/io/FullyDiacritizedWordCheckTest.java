package de.unidue.ltl.lugha.io;


import static org.apache.uima.fit.factory.CollectionReaderFactory.createReaderDescription;
import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.api.io.ResourceCollectionReaderBase;
import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.unidue.ltl.lugha.io.util.FullyDiacritizedWordCheck;
import de.unidue.ltl.lugha.normalization.TextNormalizer;

public class FullyDiacritizedWordCheckTest {
	
	public static final String SOURCE_FOLDER = "/scr/test/seq/count.txt";

	
//	@Test
//	public void testFullyDiacritizedWordCheck1() throws Exception {
//				
//		assertEquals(false, FullyDiacritizedWordCheck.fullyDiacritized("عِلْم"));		
//		System.out.println("");
//		
//		assertEquals(true, FullyDiacritizedWordCheck.fullyDiacritized("عِلْمٍ"));//Tanween Kasr at m
//		System.out.println("");
//		
//		assertEquals(true, FullyDiacritizedWordCheck.fullyDiacritized("عَلِمْ"));
//		System.out.println("");
//		
//		assertEquals(true, FullyDiacritizedWordCheck.fullyDiacritized("عِلْمُ"));
//		
//	}

	@Test
	public void testFullyDiacritizedWordCheck2() throws Exception {
				
		assertEquals(false, FullyDiacritizedWordCheck.isFullyDiacritized("ذُكِر"));		
		System.out.println("");
		
		assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَّرَ"));
		System.out.println("");
		
		assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَرٌ"));
		System.out.println("");
		
		assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَرٌ"));
		System.out.println("");		
		
		assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("عَقْلٍ"));//Tanween Kasr at l
		
	}
	
	@Test
	public void testFullyDiacritizedWordCheckCounts() throws Exception {
		
		 List<String> list = SimpleReader.readFile("corpora/count.txt");
				 
		 System.out.println("Size: "+list.size());
		 
		 int count = 0;
		 
		 for(String line: list){
			
//			 System.out.println("Sentence: "+line);
			 String normalized = TextNormalizer.fullyNormalizeText(line);
			 System.out.println("Normalized Sentence: " + TextNormalizer.fullyNormalizeText(line));
			 
			 for(String token : normalized.split(" ")){
				 if(FullyDiacritizedWordCheck.isFullyDiacritized(token))
					 count++;
			 }
			 
		 }
		 
		 System.out.println("Diacritized words count :: "+count);
		 
		 assertEquals(13, count);
		 
//			CollectionReaderDescription reader = createReaderDescription(
//					TextReader.class,
//					ResourceCollectionReaderBase.PARAM_SOURCE_LOCATION, SOURCE_FOLDER, 
////					ResourceCollectionReaderBase.PARAM_PATTERNS, "[+]*.txt",
//					TextReader.PARAM_ENCODING, "UTF-8"); //"CP1256"
//			
//
//			for (JCas jcas : new JCasIterable(reader)) {
//
// 				String doc = jcas.getDocumentText();
//
// 				System.out.println("Sentence: "+doc);
// 				
//            	String sentence = TextNormalizer.fullyNormalizeText(doc);
//
//				System.out.println("Sentence: "+sentence);
//
//				DocumentMetaData md = DocumentMetaData.get(jcas);
//
//	
//		}

	}
		

}
