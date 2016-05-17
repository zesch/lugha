package de.unidue.ltl.lugha.normalization;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PunctuationRemoverTest {

	@Test
	public void punctuationRemoverTest() {
		
    	String withPunc = "المسلم أن ينمي مقدرته ومواهبه وقوته، وأن يعطي من خلال عمله على أفضل وجه، وعلى أحسن حال";
    	
    	String withoutPunc = PunctuationRemover.removePunctuation(withPunc);
    	
		assertEquals("المسلم أن ينمي مقدرته ومواهبه وقوته وأن يعطي من خلال عمله على أفضل وجه وعلى أحسن حال", withoutPunc);

	}

}
