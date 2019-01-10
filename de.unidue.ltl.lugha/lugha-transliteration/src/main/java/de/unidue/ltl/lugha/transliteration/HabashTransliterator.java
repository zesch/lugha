/*******************************************************************************
 * Copyright 2019
 * Language Technology Lab
 * University of Duisburg-Essen, Germany
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.unidue.ltl.lugha.transliteration;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.bidimap.UnmodifiableBidiMap;

/**
 * 
 * Transliteration following the Habash et al. method
 * @web: http://nizarhabash.com/publications/chapter2BisHabash_et_al-2007-web.pdf
 * 
 */
public class HabashTransliterator 
	extends BidiMapTranslitator
{

	private static final BidiMap unicodeMap;
	
	static {
				
		BidiMap map = new  DualHashBidiMap();;
		
		map.put("\u0621", "\'");
		map.put("\u0622", "Ā");//Latin capital letter a with macron: Ā=0x100
		map.put("\u0623", "Â");//Latin capital letter a with circumflex: Â=0xc2
		map.put("\u0624", "ŵ");//Latin small letter w with circumflex: ŵ=0x175
		map.put("\u0625", "Ǎ");//Latin capital letter a with caron: Ǎ=0x1cd
		map.put("\u0626", "ŷ");//Latin small letter y with circumflex: ŷ=0x177
		map.put("\u0627", "A");
		map.put("\u0628", "b");
		map.put("\u0629", "ħ");//Latin small letter h with stroke: ħ=0x127
		
		map.put("\u062A", "t");
		map.put("\u062B", "θ");//Greek small letter theta: θ=0x3b8
		map.put("\u062C", "j");
		map.put("\u062D", "H");
		map.put("\u062E", "x");
		map.put("\u062F", "d");
		
		map.put("\u0630","ð");//Latin small letter eth: ð=0xf0
		map.put("\u0631", "r");
		map.put("\u0632", "z");
		map.put("\u0633", "s");
		map.put("\u0634", "š");//Latin small letter s with caron: š=0x161
		map.put("\u0635", "S");		
		map.put("\u0636", "D");
		map.put("\u0637", "T");
		map.put("\u0638", "Ď");//Latin capital letter d with caron: Ď=0x10e
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!
		map.put("\u0639", "ς");//Greek small letter final sigma: ς=0x3c2
		map.put("\u063A", "𝛄");//Mathematical bold small gamma: 𝛄=0x1d6c4
		
		map.put("\u0641", "f");
		map.put("\u0642", "q");
		map.put("\u0643", "k");
		map.put("\u0644", "l");
		
		map.put("\u0645", "m");
		map.put("\u0646", "n");
		map.put("\u0647", "h");
		map.put("\u0648", "w");
		map.put("\u0649", "ý");//Latin small letter y with acute: ý=0xfd
		
		map.put("\u064A", "y");
		map.put("\u064B", "ã");//Latin small letter a with tilde: ã=0xe3
		map.put("\u064C", "ũ");//Latin small letter u with tilde: ũ=0x169
		map.put("\u064D", "ĩ");//Latin small letter i with tilde: ĩ=0x129
		
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

	@Override
	protected BidiMap getBidiMap() {
		return unicodeMap;
	}
}