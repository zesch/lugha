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
package de.unidue.ltl.lugha.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PunctuationMarks {

	private static final Set<String> punctuations;

	static {

		Set<String> set = new HashSet<String>();
		
		set.add(",");
		set.add(":");
		set.add("،"); // Araic comma
		set.add("؛"); // Arabic semi-colons
		set.add("؟"); // Arabic question mark
		set.add("'");
		set.add("!");
		set.add("?");
		set.add("-");
		set.add("--");
		set.add("(");
		set.add(")");
		set.add("<<");
		set.add(">>");
		set.add("..."); // points of ellipsis.

		punctuations = Collections.unmodifiableSet(set);
	}

	public static Set<String> getPunctuations() {
		return punctuations;
	}
}
