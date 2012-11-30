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
 * <p>An enum that represents the coding strenth.
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class CodingStrength extends EnumPattern {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3259949645508081979L;
	
	/**
	 * <p>A coding strength that represents a coded, non-extensible code (CNE).
	 */
	public static final CodingStrength CNE = new CodingStrength("CNE", "coded, non-extensible"); 
	/**
	 * <p>A coding strength that represents a coded with extensibility code (CWE).
	 */
	public static final CodingStrength CWE = new CodingStrength("CWE", "coded with extensibility");
	
	private final String description;

	private CodingStrength(String name, String description) {
		super(name);
		this.description = description;
	}

	/**
	 * <p>Gets a user-readable description of the coding strength.
	 * @return the description.
	 */
	public String getDescription() {
		return this.description;
	}
}
