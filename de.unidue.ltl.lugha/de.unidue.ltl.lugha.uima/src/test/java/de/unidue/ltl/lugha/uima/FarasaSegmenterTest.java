package de.unidue.ltl.lugha.uima;

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

		for (Token t : JCasUtil.select(jcas, Token.class)) {
			System.out.printf("[%s] ", t.getCoveredText());
		}

	}
}
