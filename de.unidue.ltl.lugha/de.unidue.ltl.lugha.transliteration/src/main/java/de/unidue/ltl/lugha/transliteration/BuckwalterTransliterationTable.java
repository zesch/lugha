package de.unidue.ltl.lugha.transliteration;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @web: http://languagelog.ldc.upenn.edu/myl/ldc/morph/buckwalter.html
 *
 */
public class BuckwalterTransliterationTable {

	public static final Map<String, String> unicodeMap = new HashMap<String, String>();

	static {
		
		
		addMapping("\u0621", "\'");
		addMapping("\u0622", "|");
		addMapping("\u0623", ">");
		addMapping("\u0624", "&");
		addMapping("\u0625", "<");
		addMapping("\u0626", "}");
		addMapping("\u0627", "A");
		addMapping("\u0628", "b");
		addMapping("\u0629", "p");
		
		//addMapping("\u0629", "");
		
		addMapping("\u062A", "t");
		addMapping("\u062B", "v");
		addMapping("\u062C", "j");
		addMapping("\u062D", "H");
		addMapping("\u062E", "x");
		addMapping("\u062F", "d");
		
		addMapping("\u0630","*");
		addMapping("\u0631", "r");
		addMapping("\u0632", "z");
		addMapping("\u0633", "s");
		addMapping("\u0634", "$");
		addMapping("\u0635", "S");		
		addMapping("\u0636", "D");
		addMapping("\u0637", "T");
		addMapping("\u0638", "Z");
		addMapping("\u0639", "E");

		addMapping("\u063A", "g");
		
		addMapping("\u0640", "_");
		addMapping("\u0641", "f");
		addMapping("\u0642", "q");
		addMapping("\u0643", "k");
		addMapping("\u0644", "l");
		
		addMapping("\u0645", "m");
		addMapping("\u0646", "n");
		addMapping("\u0647", "h");
		addMapping("\u0648", "w");
		addMapping("\u0649", "Y");
		
		addMapping("\u064A", "y");
		addMapping("\u064B", "F");
		addMapping("\u064C", "N");
		addMapping("\u064D", "K");
		addMapping("\u064E", "a");
		addMapping("\u064F", "u");
		
		addMapping("\u0650", "i");
		addMapping("\u0651", "~");
		addMapping("\u0652", "o");
		addMapping("\u0670", "`");
		addMapping("\u0671", "{");
		
	}

	public static void addMapping(String unicode, String map){
		
		unicodeMap.put(unicode, map);
	}
	
	public static void main(String[] args) {
		
		String text = "اعطى الولد البنت كتابا، ساءل امْرَأَتِي";
		
		String str1 = "\u064A";
		String str2 ="\u0650";
		
		System.out.println(unicodeMap.get(str1));
		System.out.println(unicodeMap.get(str2));
	}
	
}
