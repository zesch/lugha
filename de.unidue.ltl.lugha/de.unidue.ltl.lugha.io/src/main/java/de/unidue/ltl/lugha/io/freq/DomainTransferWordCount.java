package de.unidue.ltl.lugha.io.freq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.ConditionalFrequencyDistribution;
import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.FrequencyDistribution;
import de.tudarmstadt.ukp.dkpro.core.api.resources.DkproContext;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.tokit.RegexTokenizer;
import de.unidue.ltl.lugha.io.util.FullyDiacritizedWordCheck;
import de.unidue.ltl.lugha.normalization.DiacriticsRemover;
import de.unidue.ltl.lugha.normalization.PunctuationRemover;
import de.unidue.ltl.lugha.normalization.TextNormalizer;
import de.unidue.ltl.lugha.transliteration.BuckwalterTransliterator;
import de.unidue.ltl.lugha.transliteration.Transliterator;
import de.unidue.ltl.lugha.uima.FarasaSegmenter;


public class DomainTransferWordCount {
	
	public static final String LTR = "\u202A";
	public static final String RTL = "\u202B";
	public static final String POP = "\u202C";
	
	private Transliterator buckwalter = new BuckwalterTransliterator();

	private ConditionalFrequencyDistribution<String,String> cfd;
	private ConditionalFrequencyDistribution<String,String> cfdPartial;
	private FrequencyDistribution<String> fd;

	public static void main(String[] args) 
			throws Exception
	{
		DomainTransferWordCount exp = new DomainTransferWordCount();
		exp.analyze();
	}
	
	public DomainTransferWordCount() {
		buckwalter = new BuckwalterTransliterator();
		cfd = new ConditionalFrequencyDistribution<String, String>();
		cfdPartial = new ConditionalFrequencyDistribution<String, String>();
		fd = new FrequencyDistribution<String>();
	}
		
	public void analyze() 
		throws Exception
	{
		String corpusFile = CorpusFile.getCorpusPath(CorpusName.WIKI);
		System.out.println("Corpus Name: "+corpusFile);
		
//		String corpusFile = DkproContext.getContext().getWorkspace("corpora").getAbsolutePath() + "/arabic/tashkeela.txt";
//		String corpusFile = DkproContext.getContext().getWorkspace("corpora").getAbsolutePath() + "/arabic/quran.txt";
//		String corpusFile = DkproContext.getContext().getWorkspace("corpora").getAbsolutePath() + "/arabic/rdi.txt";
//		String corpusFile = DkproContext.getContext().getWorkspace("corpora").getAbsolutePath() + "/arabic/WikiNewsTruth.txt";
					
	    initializeCFD(
	    		CollectionReaderFactory.createReaderDescription(
						CorporaStatisitcsArabicReader.class,
						CorporaStatisitcsArabicReader.PARAM_SENTENCES_FILE, corpusFile,
						CorporaStatisitcsArabicReader.PARAM_ENCODING, "UTF-8",
						CorporaStatisitcsArabicReader.HAS_DIACRITICS, "Yes"
	    		),
	    		AnalysisEngineFactory.createEngine(
						FarasaSegmenter.class
				)
//	    		AnalysisEngineFactory.createEngine(
//						RegexTokenizer.class,
//						RegexTokenizer.PARAM_TOKEN_BOUNDARY_REGEX, " "
//				)
	    );

//	      String[] roots = new String[]{"byt"};//Elm, Eqd,*kr 
	      String[] roots = new String[]{"*kr"};
//        String[] roots = new String[]{"Earabo", "AlEarabo"};
//        String[] roots = new String[]{"Elm", "*kr", "Eyn", "Zlm", "Eql", "$Er", "fjr", "nbE", "byt"};
        

	    System.out.println("===============Top 21===============");
        for (String item : fd.getMostFrequentSamples(21)) {
        	System.out.println("  " + item);
        }
	    
	        
        for (String root : roots) {
        	printDivider(root, "full");
            printSet(cfd, root);
        }
        
        for (String root : roots) {
        	printDivider(root, "partial");
            printSet(cfdPartial, root);
        }
        
        System.out.println();
        
        // plot fully-diacritized ambiguity
        FrequencyDistribution<Integer> ambiguity = new FrequencyDistribution<Integer>();
        for (String root : cfd.getConditions()) {
        	ambiguity.inc(cfd.getFrequencyDistribution(root).getKeys().size());
        }
        List<Integer> levels = new ArrayList<Integer>(ambiguity.getKeys());
        Collections.sort(levels);
        for (Integer level : levels) {
        	System.out.println(level + " : " + ambiguity.getCount(level));
        }
        int[] sizes = new int[]{15,16,17,18,19,20,55};
        for (int size : sizes) {
        	printDistribution(cfd, size);
        }
        
        // plot partially-diacritized ambiguity
//        FrequencyDistribution<Integer> partialAmbiguity = new FrequencyDistribution<Integer>();
//        for (String root : cfdPartial.getConditions()) {
//        	partialAmbiguity.inc(cfdPartial.getFrequencyDistribution(root).getKeys().size());
//        }
//        List<Integer> partialLevels = new ArrayList<Integer>(partialAmbiguity.getKeys());
//        Collections.sort(partialLevels);
//        for (Integer level : partialLevels) {
//        	System.out.println(level + " : " + partialAmbiguity.getCount(level));
//        }
//
//        int[] partSizes = new int[]{15,16,17,18,19,20,55};
//        for (int size : partSizes) {
//        	printDistribution(cfdPartial, size);
//        }

    }
	
	private void initializeCFD(CollectionReaderDescription reader, AnalysisEngine tokenizer)
			throws AnalysisEngineProcessException, IOException
	{

	    int wordCount = 0;
	    int partialCount = 0;
	    int dismissedCount = 0;
        for (JCas jcas : new JCasIterable(reader)) {
        	tokenizer.process(jcas);
        	
        	for (Token token : JCasUtil.select(jcas, Token.class)) {
				wordCount++;
								
				// TODO why do we need double normalization?
	            String word = TextNormalizer.fullyNormalizeText(
	            				PunctuationRemover.removePunctuation(
	            						TextNormalizer.fullyNormalizeText(token.getCoveredText())));

				// Replace dager Alif
//				word = DiacriticsRemover.replaceAdditionalDiacritics(word);

	            // remove nunation
				word = DiacriticsRemover.removeTanweenFath(word);
				word = DiacriticsRemover.removeTanweenDamm(word);
				word = DiacriticsRemover.removeTanweenKasr(word);

				if (word.contains(" ")) {
					dismissedCount++;
					continue;
				}
				
				String root = DiacriticsRemover.removeDiacritics(word);
			
				Set<String> stopWordsSet = StopWords.getArabciStopWords();
				
				String readableRoot = buckwalter.getLatinString(root);
				
				if (FullyDiacritizedWordCheck.isFullyDiacritized(word)) {
					cfd.inc(readableRoot, word);//I have to include this only
					
					if( stopWordsSet.contains(root) == false && root.trim().length() >=2 )
						fd.inc(word);
				}
				else {
					cfdPartial.inc(readableRoot, word);
					
					if( stopWordsSet.contains(root) == false && root.trim().length() >=2)
//						fd.inc(word);
					
					partialCount++;
				}	
			}
        }
        System.out.println("# words: " + wordCount);
        System.out.println("# types: " + cfd.getConditions().size());
        System.out.println("# partial (ratio): " + partialCount + " (" + (double) partialCount / wordCount + ")");
        System.out.println("# dismissed (ratio): " + dismissedCount + " (" + (double) dismissedCount / wordCount + ")");

	}
	
	private void printSet(ConditionalFrequencyDistribution<String, String> cfd, String root) {
		if (cfd.hasCondition(root)) {
	        FrequencyDistribution<String> fd = cfd.getFrequencyDistribution(root);
	        int sum = 0;
	        for(String key : fd.getKeys()){
	        	sum += fd.getCount(key);
				System.out.println(key + " : " + LTR + fd.getCount(key) + " - " + buckwalter.getLatinString(key));
			}
	        System.out.println("Total = "+ sum);
		}
	}
	
	private void printDivider(String root, String variant) {
        System.out.println("====== "+ root + " (" + variant + ") ===================");
	}
	
	private void printDistribution(ConditionalFrequencyDistribution<String, String> cfd, int sizeToPlot) {
		System.out.println("Ambiguity size: " + sizeToPlot);
		for (String root : cfd.getConditions()) {
        	if (cfd.getFrequencyDistribution(root).getKeys().size() == sizeToPlot) {
        		System.out.println(root + " (" + getDistributionString(cfd.getFrequencyDistribution(root)) + ")");
        	}
        }
		System.out.println();
	}
	
	private String getDistributionString(FrequencyDistribution<String> fd) {
		List<Integer> values = new ArrayList<Integer>();
		for (String key : fd.getKeys()) {
			values.add(new Long(fd.getCount(key)).intValue());
			// normalized
//			values.add(new Double(Math.floor((double) fd.getCount(key)*1000 / fd.getN())).intValue());
		}
		Collections.sort(values);
		return StringUtils.join(values, ",");
	}

}
