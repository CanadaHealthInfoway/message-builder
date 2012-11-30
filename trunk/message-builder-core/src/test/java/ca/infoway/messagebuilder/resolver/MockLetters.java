/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.resolver;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.lang.EnumPattern;

public class MockLetters extends EnumPattern implements MockCharacters {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = 6400732969093598844L;
	
	public static final MockLetters A = new MockLetters("A"); 
	public static final MockLetters B = new MockLetters("B"); 
	public static final MockLetters C = new MockLetters("C"); 
	public static final MockLetters D = new MockLetters("D"); 
	public static final MockLetters E = new MockLetters("E"); 
	public static final MockLetters LMNO = new MockLetters("LMNO"); 
	public static final MockLetters OTHER = new MockLetters("OTHER");

	private MockLetters(String name) {
		super(name);
	}
	
	public String getCodeSystem() {
		return "a.b.c.e.f.g.h";
	}

	public String getCodeValue() {
		return this != OTHER ? name() : null;
	}

	public NullFlavor getNullFlavor() {
		return this != OTHER ? null : ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.OTHER;
	}

	public boolean hasNullFlavor() {
		return this == OTHER;
	} 
}
