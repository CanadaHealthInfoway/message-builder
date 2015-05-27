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

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * <p>A class that models a specialization child of an abstract class.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - due to trickiness with isDefault field
 */
@Root
public class SpecializationChild implements Comparable<SpecializationChild> {

	@Attribute
	private String name;
	
	@Attribute(required=false)
	private String cmetBindingName;
	@Attribute(required=false)
	private String cmetDerivationClassName;
	@Attribute(required=false)
	private Boolean isDefault;
	
	/**
	 * <p>Standard constructor.
	 */	
	public SpecializationChild() {
	}
	
	/**
	 * <p>Standard constructor.
	 * @param name the name of the specializing class
	 */	
	public SpecializationChild(String name) {
		this.name = name;
	}

	/**
	 * <p>Standard constructor.
	 * @param name the name of the specializing class
	 * @param cmetBindingName the name used in MIF files to refer to an external message part
	 */	
	public SpecializationChild(String name, String cmetBindingName, String cmetDerivationClassName) {
		this.name = name;
		this.cmetBindingName = cmetBindingName;
		this.cmetDerivationClassName = cmetDerivationClassName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmetBindingName() {
		return cmetBindingName;
	}

	public void setCmetBindingName(String cmetBindingName) {
		this.cmetBindingName = cmetBindingName;
	}

	public String getCmetDerivationClassName() {
		return cmetDerivationClassName;
	}

	public void setCmetDerivationClassName(String cmetDerivationClassName) {
		this.cmetDerivationClassName = cmetDerivationClassName;
	}

	public boolean isDefault() {
		return isDefault == null ? false : (boolean) isDefault; //Cast for .NET
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public int compareTo(SpecializationChild o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof SpecializationChild) {
			SpecializationChild that = (SpecializationChild) obj;
			return this.getName().equals(that.getName());
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.name).toHashCode();
	}
}
