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
 * Last modified: $LastChangedDate: 2013-05-15 18:39:56 -0400 (Wed, 15 May 2013) $
 * Revision:      $LastChangedRevision: 6874 $
 */

package ca.infoway.messagebuilder.datatype.lang;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.Code;

/**
 * <p>CR (R2) data type
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class CodeRole implements Serializable {
    
    private static final long serialVersionUID = 5932473836237229686L;

    private CodedTypeR2<Code> name;
    private CodedTypeR2<Code> value;
    private boolean inverted = false;

	/**
     * <p>Constructs an empty CR 
     */
    public CodeRole() {
    }

    /**
     * Constructs a CR with default inverted value
     * 
     * @param name
     * @param value
     */
    public CodeRole(CodedTypeR2<Code> name, CodedTypeR2<Code> value) {
    	this(name, value, false);
    }

    /**
     * Constructs a CR with all fields
     * 
     * @param name
     * @param value
     * @param inverted
     */
    public CodeRole(CodedTypeR2<Code> name, CodedTypeR2<Code> value, boolean inverted) {
		this.name = name;
		this.value = value;
		this.inverted = inverted;
    }

    /**
     * The name code.
     * 
     * @return name
     */
    public CodedTypeR2<Code> getName() {
		return name;
	}

    /**
     * Set the name code.
     * 
     * @param name
     */
	public void setName(CodedTypeR2<Code> name) {
		this.name = name;
	}

	/**
	 * The value code.
	 * 
	 * @return value
	 */
	public CodedTypeR2<Code> getValue() {
		return value;
	}

	/**
	 * Set the value code.
	 * 
	 * @param value
	 */
	public void setValue(CodedTypeR2<Code> value) {
		this.value = value;
	}

	/**
	 * Whether the type is inverted or not.
	 * 
	 * @return inverted
	 */
	public boolean isInverted() {
		return inverted;
	}

	/**
	 * Sets the inverted state.
	 * 
	 * @param inverted
	 */
	public void setInverted(boolean inverted) {
		this.inverted = inverted;
	}

	/**
     * <p>Generates a hash code for this object
     * 
     * @return the hashcode
     */
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.name)
                .append(this.value)
                .append(this.inverted)
                .toHashCode();
    }

    /**
     * <p>Compares the supplied object with this object to see if they are equal.
     * 
     * @param obj the object to compare
     * @return whether the objects are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((CodeRole) obj);
        }
    }
    
    private boolean equals(CodeRole that) {
        return new EqualsBuilder()
        		.append(this.name, that.name)
                .append(this.value, that.value)
                .append(this.inverted, that.inverted)
                .isEquals();
    }
    
}
