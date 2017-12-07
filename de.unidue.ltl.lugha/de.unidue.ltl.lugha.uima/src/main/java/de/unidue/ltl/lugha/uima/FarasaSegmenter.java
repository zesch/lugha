package de.unidue.ltl.lugha.uima;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.qcri.farasa.segmenter.Farasa;

public class FarasaSegmenter 
	extends JCasAnnotator_ImplBase
{

	private Farasa farasa;
	
	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException 
	{
		super.initialize(context);
		
		try {
			farasa = new Farasa();
		} catch (FileNotFoundException e) {
			throw new ResourceInitializationException(e);
		} catch (ClassNotFoundException e) {
			throw new ResourceInitializationException(e);
		} catch (IOException e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		String originalString = jcas.getDocumentText();
		
		List<String> segments = farasa.segmentLine(jcas.getDocumentText());
		String segmentedString = StringUtils.join(segments, " ");
		for (int i=0; i<segmentedString.length(); i++) {
			System.out.println(segmentedString.substring(i, i+1));
		}
		for (int i=0; i<originalString.length(); i++) {
			System.out.println(originalString.substring(i, i+1));
		}
	}

}
