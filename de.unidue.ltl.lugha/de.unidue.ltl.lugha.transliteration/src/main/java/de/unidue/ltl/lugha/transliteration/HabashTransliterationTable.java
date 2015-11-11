package de.unidue.ltl.lugha.transliteration;



import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.bidimap.UnmodifiableBidiMap;

/**
 * 
 * @web: http://nizarhabash.com/publications/chapter2BisHabash_et_al-2007-web.pdf
 *
 */
public class HabashTransliterationTable {

	public static final BidiMap unicodeMap;
	
	static {
		
		// TODO mapping should work in both directions - use different map implementation
		
		BidiMap map = new  DualHashBidiMap();;
		
		map.put("\u0621", "\'");
		map.put("\u0622", "0x100");//Latin capital letter a with macron: Ā
		map.put("\u0623", "0xc2");//Latin capital letter a with caron: Ǎ
		map.put("\u0624", "0x175");//Latin small letter w with circumflex: ŵ
		map.put("\u0625", "0x1cd");//Latin capital letter a with caron: Ǎ
		map.put("\u0626", "0x177");//Latin small letter y with circumflex: ŷ
		map.put("\u0627", "A");
		map.put("\u0628", "b");
		map.put("\u0629", "0x127");//Latin small letter h with stroke: ħ
		
		map.put("\u062A", "t");
		map.put("\u062B", "0x3b8");//Greek small letter theta: θ
		map.put("\u062C", "j");
		map.put("\u062D", "H");
		map.put("\u062E", "x");
		map.put("\u062F", "d");
		
		map.put("\u0630","0xf0");//Latin small letter eth: ð
		map.put("\u0631", "r");
		map.put("\u0632", "z");
		map.put("\u0633", "s");
		map.put("\u0634", "0x161");//Latin small letter s with caron: š
		map.put("\u0635", "S");		
		map.put("\u0636", "D");
		map.put("\u0637", "T");
		map.put("\u0638", "0x10e");//Latin capital letter d with caron: Ď
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!
		map.put("\u0639", "0x3c2");//Greek small letter final sigma: ς
		map.put("\u063A", "0x1d6c4");//Mathematical bold small gamma: 𝛄
		
		map.put("\u0641", "f");
		map.put("\u0642", "q");
		map.put("\u0643", "k");
		map.put("\u0644", "l");
		
		map.put("\u0645", "m");
		map.put("\u0646", "n");
		map.put("\u0647", "h");
		map.put("\u0648", "w");
		map.put("\u0649", "0xfd");//Latin small letter y with acute: ý
		
		map.put("\u064A", "y");
		map.put("\u064B", "0xe3");//Latin small letter a with tilde: ã
		map.put("\u064C", "0x169");//Latin small letter u with tilde: ũ
		map.put("\u064D", "0x129");//Latin small letter i with tilde: ĩ
		
		map.put("\u064E", "a");		
		map.put("\u064F", "u");		
		map.put("\u0650", "i");
		
		map.put("\u0651", "~");
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!
		map.put("\u0652", "o");		
		map.put("\u0640", "_");
		
		//Not found in Habash, Quraan and Religious Script (Classical Arabic)
//		map.put("\u0670", "`");
//		map.put("\u0671", "{");
		
        unicodeMap = UnmodifiableBidiMap.decorate(map);
        
	}
}
