package de.unidue.ltl.lugha.io.freq;

public class CorpusFile {

	/**
	 * TODO: By TZ
	 * Change the paths accordingly
	 */
	
	public static String DKPRO_HOME = "/Users/ltl2014lf/Documents/DKPro";
	
	public static String getCorpusPath(CorpusName name) throws Exception {

		String sourceFile = "";

		switch (name) {
		case ALJAZEERA:
			sourceFile = DKPRO_HOME + "/data/farasa/aljazeera.txt";
			break;
		case KACST:
			sourceFile = DKPRO_HOME + "/data/farasa/KACST.txt";
			break;
		case KHALEEJ:
			sourceFile = DKPRO_HOME + "/data/farasa/Khaleej.txt";
			break;
		case WATAN:
			sourceFile = DKPRO_HOME + "/data/farasa/Watan.txt";
			break;
		case TWEETS:
			sourceFile = DKPRO_HOME + "/data/farasa/Tweets.txt";
			break;			
		case WIKI:
			sourceFile = DKPRO_HOME + "/data/seq/WikiNewsTruth.txt";
			break;		
		case QURAN:
			sourceFile = DKPRO_HOME + "/data/seq/quran.txt";
			break;
		case RDI:
			sourceFile = DKPRO_HOME + "/data/gold/rdi.txt";
			break;
		case Tashkeela11Books:
			sourceFile = DKPRO_HOME + "/data/seq/11Books.txt";
			break;
		case TASHKEELA:
			sourceFile = DKPRO_HOME + "/data/seq/tashkeela.txt";
			break;
		default:
			throw new Exception("Unknown corpus: " + name);
		}

		return sourceFile;
	}

}
