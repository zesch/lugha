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

/**
 * Abstract base class for bidimap based @BidiTransliterator 
 * 
 */
public abstract class BidiMapTranslitator 
	implements BidiTransliterator
{
    protected BidiMap map = null;

	protected BidiMap getBidiMap() {
	    return map;
	}

	public String getLatinString(String arabicString) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arabicString.length(); i++)
		{	
			String unigram = arabicString.substring(i, i + 1);
	
			if (getBidiMap().containsKey(unigram) ) {
				sb.append(getBidiMap().get(unigram));
			}
			else {	
				sb.append(unigram);
			}
		}
		
		return sb.toString();
		
	}

	public String getArabicString(String latinString) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < latinString.length(); i++)
		{	
			String unigram = latinString.substring(i, i + 1);
	
			if (getBidiMap().containsValue(unigram) ) {
				sb.append(getBidiMap().getKey(unigram));
			}
			else {	
				sb.append(unigram);
			}
		}
		
		return sb.toString();
	}
}