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

import java.util.ArrayList;
import java.util.List;

import de.unidue.ltl.lugha.core.DiacriticMarks;
import de.unidue.ltl.lugha.transliteration.Transliterator;

public class ArabicString
{

    private List<ArabicLetter> letters;

    private Transliterator transliterator;

    public ArabicString(Transliterator transliterator)
    {
        super();
        letters = new ArrayList<ArabicLetter>();
        this.transliterator = transliterator;
    }

    public void addLetter(ArabicLetter letter)
    {
        letters.add(letter);
    }

    public void addDiacriticForCurrentLetter(ArabicDiacritic diacritic)
    {
        ArabicLetter currentLetter = letters.get(letters.size() - 1);
        List<ArabicDiacritic> diacritics = currentLetter.getDiacritics();
        diacritics.add(diacritic);
        currentLetter.setDiacritics(diacritics);
    }

    public List<ArabicLetter> getLetters()
    {
        return letters;
    }

    public void setLetters(List<ArabicLetter> letters)
    {
        this.letters = letters;
    }

    // TODO this is not very robust, as it assumes fully diacritized and fails in many other cases
    public void initialize(String withDiacritics)
    {
        String transliteration = transliterator.getLatinString(withDiacritics);

        for (int i = 0; i < withDiacritics.length(); i++) {
            String character = withDiacritics.substring(i, i + 1);
            String transliterated = transliteration.substring(i, i + 1);

            ArabicLetter letter = new ArabicLetter();

            if (DiacriticMarks.getDiacritics().contains(character)) {
                this.addDiacriticForCurrentLetter(new ArabicDiacritic(character, transliterated));
            }
            else {
                letter = new ArabicLetter();
                letter.setLetter(character);
                letter.setTransliteration(transliterated);
                this.addLetter(letter);
            }
        }
    }
}