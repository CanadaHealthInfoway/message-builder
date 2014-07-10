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
 * Last modified: $LastChangedDate: 2014-04-10 17:43:48 -0400 (Thu, 10 Apr 2014) $
 * Revision:      $LastChangedRevision: 8508 $
 */

package ca.infoway.messagebuilder.xml;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * <p>Specification of cardinality and fixed value constraints on fields inside a standard datatype.
 * 
 * <p>Only used in the context of CDA documents
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
@Root
public class ConstrainedDatatype {
	
	private static final String CONSTRAINT_TYPE_RESTRICTION = "RES";
	private static final String CONSTRAINT_TYPE_EXTENSION = "EXT";

	@Attribute
	private String name;
	@Attribute(required=false)
	private String baseType;
	@Attribute
	private String constraintType = CONSTRAINT_TYPE_RESTRICTION;

	@ElementList(required=false,inline=true)
	private List<Relationship> relationships = new ArrayList<Relationship>();

	/**
	 * <p>Default constructor.
	 */
	public ConstrainedDatatype() {
	}
	
	/**
	 * <p>Standard constructor.
	 * @param name - the relationship name
	 * @param type - the relationship type
	 * @param cardinality - the cardinality.
	 */
	public ConstrainedDatatype(String name, String baseType) {
		this.name = name;
		this.baseType = baseType;
	}
	
	/**
	 * <p>Get the name.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * <p>Set the name.
	 * @param name - the new value.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>Get the standard type that is being constrained.  
	 * 
	 * @return the type
	 */
	public String getBaseType() {
		return this.baseType;
	}

	/**
	 * <p>Set the standard type that is being constrained.
	 * @param type - the new value
	 */
	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public List<Relationship> getRelationships() {
		return relationships;
	}
	
	/**
	 * <p>Set the constraint type to be restriction
	 */
	public void setRestriction() {
		this.constraintType = CONSTRAINT_TYPE_RESTRICTION;
	}

	public boolean isRestriction() {
		return CONSTRAINT_TYPE_RESTRICTION.equals(this.constraintType);
	}
	
	/**
	 * <p>Set the constraint type to be extension
	 */
	public void setExtension() {
		this.constraintType = CONSTRAINT_TYPE_EXTENSION;
	}
	
	public boolean isExtension() {
		return CONSTRAINT_TYPE_EXTENSION.equals(this.constraintType);
	}
}
