package de.unidue.ltl.lugha.normalization;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;


import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.ngrams.util.CharacterNGramStringIterable;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordPosTagger;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;

public class NormalizeArText {

	public static void main(String[] args)
			throws AnalysisEngineProcessException, ResourceInitializationException
	{

		String tatweel = "تطويـــــــــــــــــــــــــــــــــــل         هكـــــــــذا";
		
		System.out.println(tatweel);
		
		System.out.println(discradExtraWihteSpaces(tatweel));
		
		System.out.println(arrayListToString(discradExtraWihteSpaces(tatweel)));
		
		System.out.println(normalizeTatweelDKPro(tatweel));
		
	}
	
//=========================================My Code=========================================
	public static String normalizeTatweelDKPro(String currentText) 
			throws ResourceInitializationException, AnalysisEngineProcessException
	{
		
		ArrayList<String> tokens = new ArrayList<String>();
		
		ArrayList<String> modifiedText = discradExtraWihteSpaces(currentText);

    	AnalysisEngineDescription seg = createEngineDescription(BreakIteratorSegmenter.class);
        AnalysisEngineDescription tagger = createEngineDescription(StanfordPosTagger.class);
        AnalysisEngine engine = createEngine(createEngineDescription(seg, tagger));

		
        JCas aJCas = engine.newJCas();
        aJCas.setDocumentLanguage("ar");
        aJCas.setDocumentText(arrayListToString(modifiedText));
        engine.process(aJCas);
        
        Collection<Token> wordsList = JCasUtil.select(aJCas, Token.class);	               

		StringBuffer modifiedWord = new StringBuffer("");

        for (Token token : wordsList) {
        	
        	modifiedWord.setLength(0);      	
        	String word = token.getCoveredText();
        	
	        for (String unigram:  new CharacterNGramStringIterable(word, 1, 1)){
	        	
				if (!(NormalizationConstants.TATWEEL.contains(unigram))){
					modifiedWord.append(unigram);
				}
	        }
	        
	        tokens.add(modifiedWord.toString());
        }
		
		return arrayListToString(tokens);
	}
    
	public static String arrayListToString(ArrayList<String> tokens){
		
		String result = "";

		for (String token : tokens) {
			result = result + token + " ";
		}

		result = result.substring(0, result.length() - 1);
		
		return result;
	}
	//==================================================================================

	
	//----------------------------Modified code--------------------------------------
	public static ArrayList<String> discradExtraWihteSpaces(String currentText) {
		
		ArrayList<String> textList = new ArrayList<String>();
		
		StringBuffer word = new StringBuffer();
		
		currentText = currentText + " ";
		
		for (int i = 0; i < currentText.length(); i++) {

			// if the character is not a space, add it to a word
			if (( Character.isWhitespace(currentText.charAt(i)) == false)) {
				word.append(currentText.charAt(i));
			} else {
				if (word.length() != 0) {
					textList.add(word.toString());
					word.setLength(0);
				}
			}
		}
		
		return textList;
	}
    
	//----------------------------Their code--------------------------------------
	public static String normalizeTatweel(String currentText) {
		
		ArrayList<String> tokens = new ArrayList<String>();
		StringBuffer modifiedWord = new StringBuffer("");
		
		ArrayList<String> modifiedText = discradExtraWihteSpaces(currentText);

		// for each token in the text
		for (int i = 0; i < modifiedText.size(); i++) {
			modifiedWord.setLength(0);
			String ctoken = modifiedText.get(i);

			for (int j = 0; j < ctoken.length(); j++) {
				if (!(NormalizationConstants.TATWEEL.contains(ctoken.substring(
						j, j + 1))))
					modifiedWord.append(ctoken.substring(j, j + 1));
				else {

				}
			}
			tokens.add(modifiedWord.toString());
		}
		
		String result = "";

		for (String t : tokens) {
			result = result + t + " ";
		}

		result = result.substring(0, result.length() - 1);
		return result;
	}
	
}
