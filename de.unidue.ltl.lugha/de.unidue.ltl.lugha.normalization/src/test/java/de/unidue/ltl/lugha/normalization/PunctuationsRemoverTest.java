/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.normalization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.unidue.ltl.lugha.normalization.PunctuationRemover;;

/**
 * 
 * This class contains a JTest for Arabic Punctuation remover
 * 
 */

public class PunctuationsRemoverTest {

	@Test
	public void diacriticsRemoverTest() {
		  	
    	String withPunctuations = "قال المدير: “عندنا اجتماع بعد قليل.”";
//    	String withPunctuations = "أحب السفر كل صيف، ولكن هذا العام لن أسافر بسبب انشغالي بالدراسة.";
    	
    	String withoutPunctuations = PunctuationRemover.removePunctuations(withPunctuations);

		assertEquals("قال المدير عندنا اجتماع بعد قليل", withoutPunctuations);
//		assertEquals("أحب السفر كل صيف ولكن هذا العام لن أسافر بسبب انشغالي بالدراسة", withoutPunctuations);

	}

}
