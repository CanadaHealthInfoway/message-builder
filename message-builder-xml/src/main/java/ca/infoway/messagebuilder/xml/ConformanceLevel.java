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

package ca.infoway.messagebuilder.xml;

import ca.infoway.messagebuilder.lang.EnumPattern;


/**
 * <p>Conformance level.
 * 
 * <p>This enum models the various conformance levels in the HL7 standards materials.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class ConformanceLevel extends EnumPattern {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3066114109382422542L;
	
	/**
	 * <p>The mandatory conformance level.  A mandatory data element must exist in 
	 * the HL7 message and must have a non-null value.
	 */
	public static final ConformanceLevel MANDATORY = new ConformanceLevel("MANDATORY", "Mand", 0); 
	/**
	 * <p>The populated conformance level.  A populated data element must exist in the
	 * HL7 message, but may have a null flavor associated with it.
	 */
	public static final ConformanceLevel POPULATED = new ConformanceLevel("POPULATED", "Pop", 1); 
	/**
	 * <p>The required conformance level.  This term is prone to misunderstanding, becase
	 * in terms of the data in the message, required elements are closest to optional
	 * elements.  What distinguishes the required conformance level from the optional
	 * conformance level is that a compliant system should save, persist or process any
	 * data values provided.
	 */
	public static final ConformanceLevel REQUIRED = new ConformanceLevel("REQUIRED", "Req", 2); 
	/**
	 * <p>The optional conformance level.  An optional data element might or might not
	 * exist in the HL7 message.  Null flavors are also possible.
	 */
	public static final ConformanceLevel OPTIONAL = new ConformanceLevel("OPTIONAL", "Opt", 3); 
	/**
	 * <p>The ignored conformance level.  
	 */
	public static final ConformanceLevel IGNORED = new ConformanceLevel("IGNORED", "Ign", 4);
	/**
	 * <p>The not allowed conformance level.  
	 */
	public static final ConformanceLevel NOT_ALLOWED = new ConformanceLevel("NOT_ALLOWED", "X", 5);

	private final String description;
	private final int permissiveRank;


	private ConformanceLevel(String name, String description, int permissiveRank) {
		super(name);
		this.description = description;
		this.permissiveRank = permissiveRank;
	}
	
	/**
	 * <p>Gets a human-readable description of the conformance level.
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * <p>A convenience method to see if one conformance level is more permissive than
	 * another conformance level.
	 * @param conformanceLevel - the other conformance level.
	 * @return true if the conformance level is more permissive than the parameter value.
	 */
	public boolean isMorePermissive(ConformanceLevel conformanceLevel) {
		return conformanceLevel==null || this.permissiveRank > conformanceLevel.permissiveRank;
	}
}
