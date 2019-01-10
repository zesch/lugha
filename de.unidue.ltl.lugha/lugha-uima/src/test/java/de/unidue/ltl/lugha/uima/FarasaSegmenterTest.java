package de.unidue.ltl.lugha.uima;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;


public class FarasaSegmenterTest {

	@Test
	public void testFarasaSegmenter()
			throws Exception 
	{

		JCas jcas = JCasFactory.createText("النص المراد معالجته");

		SimplePipeline.runPipeline(jcas,
				AnalysisEngineFactory.createEngineDescription(FarasaSegmenter.class)
		);

		List<String> tokens = new ArrayList<>();
		for (Token t : JCasUtil.select(jcas, Token.class)) {
		    String s = t.getCoveredText();
		    tokens.add(s);
		}
		
		assertEquals(7, tokens.size());
		assertEquals("ال", tokens.get(0));
		assertEquals("نص", tokens.get(1));
		assertEquals("ال", tokens.get(2));
		assertEquals("مراد", tokens.get(3));
		assertEquals("معالج", tokens.get(4));
		assertEquals("ت", tokens.get(5));
		assertEquals("ه", tokens.get(6));

	}
	
	@Test
	public void testFarasaSegmenterWithDiacritics()
			throws Exception 
	{

		JCas jcas = JCasFactory.createText("الطبعة الأولى ، ");
		
		SimplePipeline.runPipeline(jcas,
				AnalysisEngineFactory.createEngineDescription(FarasaSegmenter.class)
		);

		List<String> tokens = new ArrayList<>();
        for (Token t : JCasUtil.select(jcas, Token.class)) {
            String s = t.getCoveredText();
            tokens.add(s);
        }
        
        assertEquals(6, tokens.size());
        assertEquals("ال", tokens.get(0));
        assertEquals("طبع", tokens.get(1));
        assertEquals("ة", tokens.get(2));
        assertEquals("ال", tokens.get(3));
        assertEquals("أولى", tokens.get(4));
        assertEquals("،", tokens.get(5));

	}
}
