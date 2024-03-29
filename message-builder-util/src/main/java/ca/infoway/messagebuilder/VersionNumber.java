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

package ca.infoway.messagebuilder;

/**
 * <p>An interface usable by any class that provides a version number/id.
 */
public interface VersionNumber {
	
	/**
	 * <p>Gets the version literal. Null should not be returned.
	 *
	 * @return the version literal
	 */
	public String getVersionLiteral();
	
	/**
	 * The HL7v3 release that this version is based on. If at all possible, null should not be returned.
	 * 
	 * @return the base version
	 */
	public Hl7BaseVersion getBaseVersion();
	
	/**
	 * This method should only return getBaseVersion() in the great majority of cases.
	 * 
	 * @param datatype An object representing a datatype. Usually, but not restricted to, an instance of StandardDataType. 
	 * @return the HL7 release that the given datatype conforms to 
	 */
	public Hl7BaseVersion getBaseVersion(Typed datatype);
}
