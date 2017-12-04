package de.unidue.ltl.lugha.io.freq;

public class CorpusFile {

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
	
	public static String getDKProHomeGoldFilePath(CorpusName name) throws Exception {

		String sourceFile = "";

		switch (name) {
		case QURAN:
			sourceFile = DKPRO_HOME + "/data/gold/quran.txt";
			break;
		case RDI:
			sourceFile = DKPRO_HOME + "/data/gold/rdi.txt";
			break;
		case Tashkeela11Books:
			sourceFile = DKPRO_HOME + "/data/gold/11Books.txt";
			break;
		case TASHKEELA:
			sourceFile = DKPRO_HOME + "/data/gold/d-hakim.txt";
			break;
		default:
			throw new Exception("Unknown corpus: " + name);
		}

		return sourceFile;
	}

	public static String getDKProHomeNonDiacFilePath(CorpusName name) throws Exception {

		String sourceFile = "";

		switch (name) {
		case QURAN:
			sourceFile = DKPRO_HOME + "/data/non/quran.txt";
			break;
		case RDI:
			sourceFile = DKPRO_HOME + "/data/non/rdi.txt";
			break;
		case Tashkeela11Books:
			sourceFile = DKPRO_HOME + "/data/non/11Books.txt";
			break;
		case TASHKEELA:
			sourceFile = DKPRO_HOME + "/data/non/tashkeela.txt";
			break;
		default:
			throw new Exception("Unknown corpus: " + name);
		}

		return sourceFile;
	}

	public static String getDKProHomeFarasaDiacFilePath(CorpusName name) throws Exception {

		String sourceFile = "";

		switch (name) {
		case QURAN:
			sourceFile = DKPRO_HOME + "/data/farasa/quran.txt";
			break;
		case RDI:
			sourceFile = DKPRO_HOME + "/data/farasa/rdi.txt";
			break;
		case Tashkeela11Books:
			sourceFile = DKPRO_HOME + "/data/farasa/11Books.txt";
			break;
		case TASHKEELA:
			sourceFile = DKPRO_HOME + "/data/farasa/tashkeela.txt";
			break;
		default:
			throw new Exception("Unknown corpus: " + name);
		}

		return sourceFile;
	}

	public static String getTargetGoldFilePath(CorpusName name) throws Exception {

		String sourceFile = "";

		switch (name) {
		case QURAN:
			sourceFile = "src/test/resources/gold/quran.txt";
			break;
		case RDI:
			sourceFile = "src/test/resources/gold/rdi.txt";
			break;
		case Tashkeela11Books:
			sourceFile = "src/test/resources/gold/11Books.txt";
			break;
		case TASHKEELA:
			sourceFile = "src/test/resources/gold/11BooksB.txt";//All books
			break;
		default:
			throw new Exception("Unknown corpus: " + name);
		}

		return sourceFile;
	}

	public static String getNonDiacritizedFilePath(CorpusName name) throws Exception {

		String sourceFile = "";

		switch (name) {
		case QURAN:
			sourceFile = "src/test/resources/mada/non/quran.txt";
			break;
		case RDI:
			sourceFile = "src/test/resources/mada/non/rdi.txt";
			break;
		case Tashkeela11Books:
			sourceFile = "src/test/resources/mada/non/11Books.txt";
			break;
		case TASHKEELA:
			sourceFile = "src/test/resources/mada/non/11BooksB.txt";
			break;
		default:
			throw new Exception("Unknown corpus: " + name);
		}

		return sourceFile;
	}

	public static String getFarasaFilePath(CorpusName name) throws Exception {

		String sourceFile = "";

		switch (name) {
		case QURAN:
			sourceFile = "src/test/resources/farasa/quran.txt";
			break;
		case RDI:
			sourceFile = "src/test/resources/farasa/rdi.txt";
			break;
		case Tashkeela11Books:
			sourceFile = "src/test/resources/farasa/11Books.txt";
			break;
		case TASHKEELA:
			sourceFile = "src/test/resources/farasa/11BooksB.txt";
			break;
		default:
			throw new Exception("Unknown corpus: " + name);
		}

		return sourceFile;
	}

}
