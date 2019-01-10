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
package de.unidue.ltl.lugha.normalization;

/**
 * 
 * This class contains the Normalization Constants, i.e. :
 * 
 * 1- The Arabic letters that we change when we a find the word stem (root)
 * 2- The Arabic prolongation letter, or the letter that is found in some Arabic script
 * 
 */
// TODO is this ever used?
public class NormalizationConstants {
	
	// TODO why is everything char except TATWEEL?
	public static final char ALIF = '\u0627';
	public static final char ALIF_HAMZA_ABOVE = '\u0623';
	public static final char ALIF_WASLA_ABOVE = '\u0671';
	public static final char ALIF_HAMZA_BELOW = '\u0625';
	public static final char ALIF_MADDA = '\u0622';
	public static final char TAA_MARBUTA = '\u0629';
	public static final char HAA = '\u0647';
	public static final char YAA = '\u064A';
	public static final char DOTLESS_YAA = '\u0649';
	public static final String TATWEEL = "\u0640";

}
