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

import de.unidue.ltl.lugha.core.PunctuationMarks;;

/**
 * Normalizes Arabic text by removing punctuation marks
 */
public class PunctuationRemover
{

    public static String removePunctuation(String text)
    {

        String normalizedText = TextNormalizer.normalizeText(text);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < normalizedText.length(); i++) {
            String unigram = text.substring(i, i + 1);
            if (!PunctuationMarks.getPunctuations().contains(unigram)) {
                sb.append(unigram);
            }
        }

        return sb.toString();
    }

    public static int hasPunctuation(String text)
    {

        int result = 0;

        String normalizedText = TextNormalizer.normalizeText(text);

        for (int i = 0; i < normalizedText.length(); i++) {

            String unigram = text.substring(i, i + 1);

            if (PunctuationMarks.getPunctuations().contains(unigram)) {
                result++;
            }

        }

        return result;

    }

}
