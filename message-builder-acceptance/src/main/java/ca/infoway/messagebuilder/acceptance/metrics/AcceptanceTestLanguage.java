/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.acceptance.metrics;

public enum AcceptanceTestLanguage {
	
	JAVA("Java"),
	DOT_NET(".Net");
	
	private String languageLiteral;
	
	public String getLanguageLiteral() {
		return this.languageLiteral;
	}
	
	public static AcceptanceTestLanguage getLanguage(String languageLiteral) {
		for (AcceptanceTestLanguage language : AcceptanceTestLanguage.values()) {
			if (language.getLanguageLiteral().equals(languageLiteral)) {
				return language;
			}
		}
		return null;
	}

	private AcceptanceTestLanguage(String languageLiteral) {
		this.languageLiteral = languageLiteral;
	}
	
}
