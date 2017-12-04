package de.unidue.ltl.lugha.io.freq;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.ConditionalFrequencyDistribution;
import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.FrequencyDistribution;
import de.unidue.ltl.lugha.normalization.DiacriticsRemover;
import de.unidue.ltl.lugha.normalization.PunctuationRemover;
import de.unidue.ltl.lugha.normalization.TextNormalizer;
import de.unidue.ltl.lugha.transliteration.BuckwalterTransliterator;
import de.unidue.ltl.lugha.transliteration.Transliterator;


public class DomainTransferWordCount {

	public static void main(String[] args) throws Exception {

		countsForDiacWords();
		
	}
	
	public static void countsForDiacWords() throws Exception {

		String corpusFile = CorpusFile.getCorpusPath(CorpusName.Tashkeela11Books);

		CollectionReaderDescription reader = CollectionReaderFactory
				.createReaderDescription(CorporaStatisitcsArabicReader.class,
						CorporaStatisitcsArabicReader.PARAM_SENTENCES_FILE,
						corpusFile,
						CorporaStatisitcsArabicReader.PARAM_ENCODING, "UTF-8",
						CorporaStatisitcsArabicReader.HAS_DIACRITICS, "Yes");

		
		List<String> wordsList = getWords(reader);
		
		Transliterator buckwalter = new BuckwalterTransliterator();

		
		
	    ConditionalFrequencyDistribution<String,String> cfd = new ConditionalFrequencyDistribution<String, String>();
	    
        for (String diacToken : wordsList) {

        	//condition is w/o Diacritics
        	        	
				String condition = DiacriticsRemover.removeDiacritics(diacToken);
				
				String encode = buckwalter.getLatinString(condition);
				
				//Does diacToken has nunations?
				if(buckwalter.getLatinString(diacToken).endsWith("F")){
					
					diacToken = DiacriticsRemover.removeTanweenFath(diacToken);
					
				}else if(buckwalter.getLatinString(diacToken).endsWith("N")){
					
					diacToken = DiacriticsRemover.removeTanweenDamm(diacToken);
					
				}else if(buckwalter.getLatinString(diacToken).endsWith("K")){
					
					diacToken = DiacriticsRemover.removeTanweenKasr(diacToken);
					
				}
				
				cfd.inc(encode, diacToken);
				
				/*
				if(encode.equals("Elm")){
//					if (!fullyDiacritized(diacToken)) {
//						cfd.inc(encode, "partial");
//					}
//					else {						
						cfd.inc(encode, diacToken);
//					}
				}
				
				if(encode.equals("*kr")){
					cfd.inc(encode, diacToken);
				}
				
				if(encode.equals("Eyn")){
					cfd.inc(encode, diacToken);
				}
				 */
				
		}
        
        
        System.out.println("==================================Elm==================================");
        printSet(cfd, "Elm");

        System.out.println("==================================Thkr=================================");
        printSet(cfd, "*kr");
        
        System.out.println("==================================Eyn==================================");
        printSet(cfd, "Eyn");

        System.out.println("==================================Zlm==================================");
        printSet(cfd, "Zlm");

        System.out.println("==================================Eql==================================");
        printSet(cfd, "Eql");

        System.out.println("==================================$Er==================================");
        printSet(cfd, "$Er");

        System.out.println("==================================fjr==================================");
        printSet(cfd, "fjr");

        System.out.println("==================================nbE==================================");
        printSet(cfd, "nbE");

	}
	
	private static void printSet(ConditionalFrequencyDistribution<String, String> cfd, String root) {
        FrequencyDistribution<String> fd = cfd.getFrequencyDistribution(root);
        for(String key : fd.getKeys()){
			System.out.println(key + " : " + fd.getCount(key));
		}
	}
	
	public static List<String>  getWords(CollectionReaderDescription reader) {
		
        List<String> words  = new ArrayList<String>();
        
        for (JCas jcas : new JCasIterable(reader)) {
        	
            String sentence = jcas.getDocumentText();
            sentence = TextNormalizer.fullyNormalizeText(PunctuationRemover.removePunctuation(TextNormalizer.fullyNormalizeText(sentence)));
            
			for (String word : sentence.split(" ")) {
				
				words.add(word);
				
			}

        }
        
        return words;

	}

}
