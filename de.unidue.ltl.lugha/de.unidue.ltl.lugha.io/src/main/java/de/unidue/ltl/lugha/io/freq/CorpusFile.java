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
		case QURAN:
			sourceFile = DKPRO_HOME + "/data/seq/quran.txt";// 1.18
			break;
		case RDI:
			sourceFile = DKPRO_HOME + "/data/seq/rdi.txt";// 1.32
			break;
		case Tashkeela11Books:
			sourceFile = DKPRO_HOME + "/data/seq/11Books.txt";// 1.62
			break;
		case TASHKEELA:
			sourceFile = DKPRO_HOME + "/data/seq/tashkeela.txt";// 1.93
			break;
		default:
			throw new Exception("Unknown corpus: " + name);
		}

		return sourceFile;
	}

}
