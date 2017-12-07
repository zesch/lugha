package de.unidue.ltl.lugha.uima;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


public class FarasaSegmenterTest {

	@Test
	public void testFarasaSegmenter() throws Exception {
		
		List<String> output = FarasaSegmenter.segment("النص المراد معالجته");  
		
		assertEquals(3, output.size());
		
		assertEquals("ال+نص", output.get(0) );

	}

	
}
