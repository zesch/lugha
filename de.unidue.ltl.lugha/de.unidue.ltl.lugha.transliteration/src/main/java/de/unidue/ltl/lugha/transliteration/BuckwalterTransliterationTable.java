/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
 ******************************************************************************/

package de.unidue.ltl.lugha.transliteration;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.bidimap.UnmodifiableBidiMap;

/**
 * 
 * @web: http://languagelog.ldc.upenn.edu/myl/ldc/morph/buckwalter.html
 *
 */
public class BuckwalterTransliterationTable {

	/**
	 * 
	 * This class contains the bi directional map for the 1-to-1 Buckwalter's Transliteration
	 * 
	 */
	
	public static final BidiMap unicodeMap;;
	
	static {
		
		BidiMap map = new  DualHashBidiMap();
		
		map.put("\u0621", "\'");
		map.put("\u0622", "|");
		map.put("\u0623", ">");
		map.put("\u0624", "&");
		map.put("\u0625", "<");
		map.put("\u0626", "}");
		map.put("\u0627", "A");
		map.put("\u0628", "b");
		map.put("\u0629", "p");
		
		//map.put("\u0629", "");
		
		map.put("\u062A", "t");
		map.put("\u062B", "v");
		map.put("\u062C", "j");
		map.put("\u062D", "H");
		map.put("\u062E", "x");
		map.put("\u062F", "d");
		
		map.put("\u0630","*");
		map.put("\u0631", "r");
		map.put("\u0632", "z");
		map.put("\u0633", "s");
		map.put("\u0634", "$");
		map.put("\u0635", "S");		
		map.put("\u0636", "D");
		map.put("\u0637", "T");
		map.put("\u0638", "Z");
		map.put("\u0639", "E");

		map.put("\u063A", "g");
		
		map.put("\u0640", "_");
		map.put("\u0641", "f");
		map.put("\u0642", "q");
		map.put("\u0643", "k");
		map.put("\u0644", "l");
		
		map.put("\u0645", "m");
		map.put("\u0646", "n");
		map.put("\u0647", "h");
		map.put("\u0648", "w");
		map.put("\u0649", "Y");
		
		map.put("\u064A", "y");
		map.put("\u064B", "F");
		map.put("\u064C", "N");
		map.put("\u064D", "K");
		map.put("\u064E", "a");
		map.put("\u064F", "u");
		
		map.put("\u0650", "i");
		map.put("\u0651", "~");
		map.put("\u0652", "o");
		map.put("\u0670", "`");
		map.put("\u0671", "{");
		
		unicodeMap = UnmodifiableBidiMap.decorate(map);
	}
}
