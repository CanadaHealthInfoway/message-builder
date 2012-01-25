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
 * <p>Potential update modes.
 * 
 * <p>This enum models the various Update Mode Kinds in the HL7 standards materials.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class UpdateModeType extends EnumPattern {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3066114109382422542L;

	/** 
	 * <p> The add update mode. 
	 */
	public static final UpdateModeType ADD = new UpdateModeType("ADD", "A"); 
	/**
	 * <p> The remoe update mode.
	 */
	public static final UpdateModeType REMOVE = new UpdateModeType("REMOVE", "D"); 
	/**
	 * <p> The replace update mode.
	 */
	public static final UpdateModeType REPLACE = new UpdateModeType("REPLACE", "R"); 
	/**
	 * <p> The add or update update mode.
	 */
	public static final UpdateModeType ADD_OR_UPDATE = new UpdateModeType("ADD_OR_UPDATE", "N"); 
	/**
	 * <p> The no change update mode.
	 */
	public static final UpdateModeType NO_CHANGE = new UpdateModeType("NO_CHANGE", "N"); 
	/**
	 * <p> The unknown update mode.
	 */
	public static final UpdateModeType UNKNOWN = new UpdateModeType("UNKNOWN", "U"); 

	private final String codeValue;


	private UpdateModeType(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}
	
	/**
	 * <p>Gets the code for the update mode.
	 * @return the codeValue
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
