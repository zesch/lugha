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

/**
 * A transliterator that can convert an Arabic string into a Latin representation and vice versa
 */
public interface BidiTransliterator 
	extends Transliterator
{
	/**
	 * @param latinString a String with text in the Latin alphabet
	 * @return A transliterated version in the Arabic alphabet
	 */
	public String getArabicString(String latinString);

}
