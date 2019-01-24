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
package de.unidue.ltl.lugha.io.util;

import de.unidue.ltl.lugha.core.DiacriticMarks;
import de.unidue.ltl.lugha.transliteration.BuckwalterTransliterator;

public class FullyDiacritizedWordCheck
{

    public static boolean fullyDiacritized(String token)
    {

        token = token.trim();

        // cannot be fully diacritized, if it contains only one character
        if (token.length() < 2) {
            return false;
        }

        ArabicString arString = new ArabicString(new BuckwalterTransliterator());
        arString.initialize(token);

        for (ArabicLetter letter : arString.getLetters()) {
            if (letter.hasDiacritics() == false) {
                return false;
            }
        }

        return true;
    }

    public static boolean isFullyDiacritized(String token)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < token.length(); i++) {
            String ch = token.substring(i, i + 1);

            if (DiacriticMarks.isDiacritic(ch)) {
                sb.append("d");
            }
            else {
                sb.append("c");
            }
        }
        String pattern = sb.toString().replaceAll("d+", "d");

        return pattern.matches("(cd)+");
    }
}