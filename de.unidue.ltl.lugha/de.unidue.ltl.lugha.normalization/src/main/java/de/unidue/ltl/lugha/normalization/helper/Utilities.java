package de.unidue.ltl.lugha.normalization.helper;

import java.util.ArrayList;

public class Utilities {
	
	public static String arrayListToString(ArrayList<String> tokens){
		
		String result = "";

		for (String token : tokens) {
			result = result + token + " ";
		}

		result = result.substring(0, result.length() - 1);
		
		return result;
	}

}
