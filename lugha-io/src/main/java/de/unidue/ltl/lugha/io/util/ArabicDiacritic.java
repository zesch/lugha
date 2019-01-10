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

public class ArabicDiacritic
{

    private String diacritic;
    private String transliteration;

    public ArabicDiacritic(String diacritic, String transliteration)
    {
        super();
        this.diacritic = diacritic;
        this.transliteration = transliteration;
    }

    public String getDiacritic()
    {
        return diacritic;
    }

    public void setDiacritic(String diacritic)
    {
        this.diacritic = diacritic;
    }

    public String getTransliteration()
    {
        return transliteration;
    }

    public void setTransliteration(String transliteration)
    {
        this.transliteration = transliteration;
    }
}