/*******************************************************************************
 * 
 * Copyright 2015
 * Language Technology Lab (LTL)
 * University of Duisburg-Essen
 * 
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

public class NormalizationConstants {
	
	// TODO why is everything char except TATWEEL?
	public static final char ALIF = '\u0627';
	public static final char ALIF_HAMZA_ABOVE = '\u0623';
	public static final char ALIF_HAMZA_BELOW = '\u0625';
	public static final char ALIF_MADDA = '\u0622';
	public static final char TAA_MARBUTA = '\u0629';
	public static final char HAA = '\u0647';
	public static final char YAA = '\u064A';
	public static final char DOTLESS_YAA = '\u0649';
	public static final String TATWEEL = "\u0640";

}
