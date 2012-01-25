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

package ca.infoway.messagebuilder.xml;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum that represents the vocabulary Source.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class DomainSource extends EnumPattern {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3259949645508081979L;
	
	/**
	 * <p>A vocabulary source that represents the value set.
	 */
	public static final DomainSource VALUE_SET = new DomainSource("VALUE_SET", "valueSet"); 
	/**
	 * <p>A vocabulary source that represents the code system.
	 */
	public static final DomainSource CODE_SYSTEM = new DomainSource("CODE_SYSTEM", "codeSystem"); 
	/**
	 * <p>A vocabulary source that represents the concept domain (domain name).
	 */
	public static final DomainSource CONCEPT_DOMAIN = new DomainSource("CONCEPT_DOMAIN", "domain"); 

	
	private final String code;

	private DomainSource(String name, String description) {
		super(name);
		this.code = description;
	}

	/**
	 * <p>Gets the code of the vocabulary source.
	 * @return the code.
	 */
	public String getCode() {
		return this.code;
	}
}
