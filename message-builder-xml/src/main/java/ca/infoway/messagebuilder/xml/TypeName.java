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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * <p>The type name.
 * 
 * <p>A typical name looks like this: <code>REPC_IN002620.ControlActProcess</code> .
 * The parent of this name would be <code>REPC_IN002620</code>
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class TypeName {

	public static final String PART_SEPARATOR = ".";
	private final String name;
	private final Boolean isInteraction;
	private final boolean isCdaDocumentRoot; // EXPERIMENT

	/**
	 * <p>Standard constructor.
	 * @param name - the name of the type
	 */
	public TypeName(String name) {
		this(name, null, false);
	}
	
	public TypeName(String name, Boolean isInteraction) {
		this(name, isInteraction, false);
	}

	public TypeName(String name, Boolean isInteraction, boolean isCdaDocumentRoot) {
		this.name = name!=null ? name.replace('$', '.') : name;
		this.isInteraction = isInteraction;
		this.isCdaDocumentRoot = isCdaDocumentRoot;
	}

	/**
	 * <p>The number of parts (separated by the period character) in the name.
	 * @return - the number of parts
	 */
	public int getPartCount() {
		return StringUtils.split(this.name, PART_SEPARATOR).length;
	}
	
	/**
	 * <p>Get a flag indicating whether or not the type name represents a top-most type.
	 * @return true if the relationship is a top-level type; false otherwise.
	 */
	public boolean isRoot() {
		return getRootName() == this;
	}

	/**
	 * <p>Get the name of the top-level type.  For example the root name of 
	 * "PRPA_MT101103CA.ParameterList" is "PRPA_MT101103CA".  The root name
	 * of "PRPA_MT101103CA" is "PRPA_MT101103CA".
	 * @return the root name.
	 */
	public TypeName getRootName() {
		if (this.name.contains(PART_SEPARATOR)) {
			return new TypeName(StringUtils.substringBefore(this.name, PART_SEPARATOR));
		} else {
			return this;
		}
	}
	/**
	 * <p>Get the name of the parent type.  For example the parent name of 
	 * "PRPA_MT101103CA.ParameterList" is "PRPA_MT101103CA".  The parent name
	 * of "PRPA_MT101103CA" is "".
	 * @return - the parent name
	 */
	public TypeName getParent() {
		if (this.name.contains(PART_SEPARATOR)) {
			return new TypeName(StringUtils.substringBeforeLast(this.name, PART_SEPARATOR));
		} else {
			return new TypeName("");
		}
	}
	
	/**
	 * <p>Standard equals method.
	 * @param obj - the other object
	 * @return true if this object equals the parameter; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			TypeName that = (TypeName) obj;
			return new EqualsBuilder()
					.append(this.name, that.name)
					.isEquals();
		}
	}
	
	/**
	 * <p>Standard hash code method.
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name).toHashCode();
	}

	/**
	 * <p>Get the name.
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * <p>Gets the unqualified part name.  For example the unqualified name of 
	 * "PRPA_MT101103CA.ParameterList" is "ParameterList".  The unqualified name
	 * of "PRPA_MT101103CA" is "PRPA_MT101103CA".
	 * @return the unqualified name
	 */
	public String getUnqualifiedName() {
		if (getPartCount() > 1) {
			return StringUtils.substringAfterLast(this.name, PART_SEPARATOR);
		} else if (getPartCount() == 1) {
			return this.name;
		} else {
			return "";
		}
	}
	/**
	 * <p>Standard toString method.
	 * @return the type name
	 */
	@Override
	public String toString() {
		return getName();
	}

	/**
	 * <p>Get a flag indicating whether or not a type name is an interaction.  
	 * Interactions tend to have '_IN' in the middle of the name.  For example, 
	 * "PRPA_IN101103CA" is an interaction name.
	 *
	 * @deprecated this naming convention is not always followed. Do NOT depend on this method to definitively determine if a type name is an interaction. 
	 * 
	 * @return true if the type name is an interaction; false otherwise.
	 */
	@Deprecated
	public boolean isInteraction() {
		// TM - hack to allow CDA procssing to mark some names as interactions
		if (this.isInteraction != null && (boolean) this.isInteraction) { //Cast for .NET
			return true;
		}
		return getPartCount() == 1 && this.name.length() >= 7 
			&& "_IN".equals(this.name.substring(4, 7));
	}
	
	/**
	 * @deprecated No longer applicable for CDA. Should not be used in general.
	 * 
	 * <p>Get a flag indicating whether or not a type name is a package location.  
	 * Interactions tend to have '_MT' in the middle of the name.  For example, 
	 * "PORX_MT010120CA" is a package location name.
	 * 
	 * @return true if the type name is a package location; false otherwise.
	 */
	@Deprecated
	public boolean isPackageLocation() {
		return getPartCount() == 1 && this.name.length() >= 7 
				&& "_MT".equals(this.name.substring(4, 7));
	}
	
	/**
	 * <p>Get the name of the top-level type.  For example the root name of 
	 * "PRPA_MT101103CA.ParameterList" is "PRPA_MT101103CA".  The root name
	 * of "PRPA_MT101103CA" is "PRPA_MT101103CA".
	 * @return the root name.
	 */
	public static String determineRootName(String name) {
		TypeName typeName = new TypeName(name);
		return typeName.getRootName().getName();
	}
	
	public boolean isCdaDocumentRoot() {
		return this.isCdaDocumentRoot;
	}
}
