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
package de.unidue.ltl.lugha.io;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import de.unidue.ltl.lugha.io.util.FullyDiacritizedWordCheck;
import de.unidue.ltl.lugha.normalization.TextNormalizer;

public class FullyDiacritizedWordCheckTest
{

    @Test
    public void testFullyDiacritizedWordCheck2() throws Exception
    {
        assertEquals(false, FullyDiacritizedWordCheck.isFullyDiacritized("ذُكِر"));
        assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَّرَ"));
        assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَرٌ"));
        assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("ذَكَرٌ"));
        assertEquals(true, FullyDiacritizedWordCheck.isFullyDiacritized("عَقْلٍ"));// Tanween Kasr
    }

    @Test
    public void testFullyDiacritizedWordCheckCounts() throws Exception
    {

        List<String> list = FileUtils.readLines(new File("src/main/resources/corpora/count.txt"),
                "utf-8");
        int count = 0;

        for (String line : list) {
            String normalized = TextNormalizer.fullyNormalizeText(line);
            System.out.println("Normalized Sentence: " + normalized);

            for (String token : normalized.split(" ")) {
                if (FullyDiacritizedWordCheck.isFullyDiacritized(token))
                    count++;
            }

        }
        assertEquals(13, count);
    }

}
