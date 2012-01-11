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

package ca.infoway.messagebuilder.datatype.lang;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Set Operator enum.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class SetOperator extends EnumPattern implements Code {
	
	private static final long serialVersionUID = 3137851858955816030L;
	
	public static final SetOperator CONVEX_HULL = new SetOperator("CONVEX_HULL", "H"); 
	public static final SetOperator INCLUDE = new SetOperator("INCLUDE", "I");
	public static final SetOperator EXCLUDE = new SetOperator("EXCLUDE", "E"); 
	public static final SetOperator INTERSECT = new SetOperator("INTERSECT", "A"); 
	public static final SetOperator PERIODIC_HULL = new SetOperator("PERIODIC_HULL", "P");
	
	private final String codeValue;

	private SetOperator(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}

	/**
	 * <p>Returns an empty string for the code system.
	 * 
	 * @return the code system for this enum (empty string)
	 */
	public String getCodeSystem() {
		return "";
	}

	/**
	 * <p>Returns the value of this enum.
	 * 
	 * @return the value of this enum.
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
