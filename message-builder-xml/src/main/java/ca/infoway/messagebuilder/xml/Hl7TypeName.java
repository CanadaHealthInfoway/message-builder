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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.xml;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

/**
 * <p>A class to hold an HL7 type name and its generic HL7 type parameters. Includes some utility methods.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @sharpen.ignore - datatype - translated manually 
 */
public class Hl7TypeName {
	
	private final String name;
	private final List<Hl7TypeName> parameters;

	/**
	 * <p>Constructs an HL7TypeName for the given type with no generic parameters. 
	 * 
	 * @param name the hl7 type
	 */
	@SuppressWarnings("unchecked")
	Hl7TypeName(String name) {
		this.name = name;
		this.parameters = Collections.EMPTY_LIST;
	}
	
	/**
	 * <p>Constructs an HL7TypeName for the given type with the supplied generic parameters. 
	 * 
	 * @param name the hl7 type
	 * @param parameters the hl7 type generic parameters
	 */
	Hl7TypeName(String name, List<Hl7TypeName> parameters) {
		this.name = name;
		this.parameters = parameters;
	}
	
	/**
	 * <p>Builds a string representation of this object.
	 * 
	 * @return the string representation of this object.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.name);
		if (!CollectionUtils.isEmpty(this.parameters)) {
			builder.append("<");
			boolean first = true;
			for (Hl7TypeName parameter : this.parameters) {
				if (!first) {
					builder.append(",");
				}
				builder.append(parameter.toString());
				first = false;
			}
			builder.append(">");
		}
		return builder.toString();
	}
	
	/**
	 * <p>Returns the unspecialized name for this hl7 type name.
	 * 
	 * @return the unspecialized name
	 */
	public String getUnspecializedName() {
		StringBuilder builder = new StringBuilder();
		builder.append(getRootName());
		if (!CollectionUtils.isEmpty(this.parameters)) {
			builder.append("<");
			boolean first = true;
			for (Hl7TypeName parameter : this.parameters) {
				if (!first) {
					builder.append(",");
				}
				builder.append(parameter.getUnspecializedName());
				first = false;
			}
			builder.append(">");
		}
		return builder.toString();
	}
	
	/**
	 * <p>Returns the name of this hl7 type.
	 * 
	 * @return the name of this hl7 type.
	 */
	public String getUnparameterizedName() {
		return this.name;
	}
	
	/**
	 * <p>Returns the generic parameters of this hl7 type.
	 * 
	 * @return the generic parameters of this hl7 type.
	 */
	public List<Hl7TypeName> getParameters() {
		return this.parameters;
	}
	
	/**
	 * <p>Constructs an Hl7TypeName object from the given string. 
	 * 
	 * @param typeName the type name
	 * @return the constructed Hl7TypeName
	 */
	public static Hl7TypeName parse(String typeName) {
		return new Hl7TypeParser().parse(typeName);
	}
	
	/**
	 * <p>Returns the root name of this hl7 type name.
	 * 
	 * @return the root name of this hl7 type name
	 */
	public String getRootName() {
		if (this.name.contains(".")) {
			return StringUtils.substringBefore(this.name, ".");
		} else {
			return this.name;
		}
	}

	/**
	 * <p>Returns whether the supplied object is equal to this object.
	 * 
	 * @param obj the object to compare
	 * @return whether the supplied object is equal to this object.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj.getClass() != getClass()) {
			return false;
		} else {
			return StringUtils.equals(this.toString(), ((Hl7TypeName) obj).toString());
		}
	}
	
	/**
	 * <p>Returns the hashcode for this object.
	 * 
	 * @return the hashcode for this object
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
