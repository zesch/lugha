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

public class ArabicLetter
{

    private String letter;
    private String transliteration;
    private List<ArabicDiacritic> diacritics;

    public ArabicLetter()
    {
        diacritics = new ArrayList<ArabicDiacritic>();
    }

    public String getLetter()
    {
        return letter;
    }

    public void setLetter(String letter)
    {
        this.letter = letter;
    }

    public String getTransliteration()
    {
        return transliteration;
    }

    public void setTransliteration(String transliteration)
    {
        this.transliteration = transliteration;
    }

    public List<ArabicDiacritic> getDiacritics()
    {
        return diacritics;
    }

    public void setDiacritics(List<ArabicDiacritic> diacritics)
    {
        this.diacritics = diacritics;
    }

    public boolean hasDiacritics()
    {
        return getDiacritics().size() > 0;
    }

    public String getDiacriticsAr()
    {

        StringBuilder sb = new StringBuilder();

        for (ArabicDiacritic obj : diacritics) {
            sb.append(obj.getDiacritic());
        }

        return sb.toString();

    }

    public String getDiacriticsTransliterated()
    {
        StringBuilder sb = new StringBuilder();

        for (ArabicDiacritic obj : diacritics) {

            if (obj.getTransliteration().equals("~")) {
                sb.append("B");
            }
            else {
                sb.append(obj.getTransliteration());
            }
        }

        String str = sb.toString();

        if (str.isEmpty()) {
            return "none";
        }

        return sb.toString();

    }

}
