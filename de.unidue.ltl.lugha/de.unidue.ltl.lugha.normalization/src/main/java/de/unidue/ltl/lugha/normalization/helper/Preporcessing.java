package de.unidue.ltl.lugha.normalization.helper;

import java.util.ArrayList;

public class Preporcessing {

	public static String discardExtraWhiteSpaces(String currentText) {
		
		ArrayList<String> tokens = new ArrayList<String>();
		
		StringBuffer word = new StringBuffer();

		currentText = currentText + " ";
		
		for (int i = 0; i < currentText.length(); i++) {

			// if the character is not a space, add it to a word
			if (false == Character.isWhitespace(currentText.charAt(i))) {
				word.append(currentText.charAt(i));
			} else {
				if (word.length() != 0) {
					tokens.add(word.toString());
					word.setLength(0);
				}
			}
		}
		
		String results = Utilities.arrayListToString(tokens);
		
		return results;
	}

}
