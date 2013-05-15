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

package ca.infoway.messagebuilder.datatype.lang;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Used to hold a difference value of a given type.  
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the javav type the diff value represents
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class Diff<T> implements BareDiff {

	private final T value;
	private NullFlavor nullFlavor;

	/**
	 * <p>Constructs a diff using the supplied parameter.
	 * 
	 * @param value the difference value
	 */
	public Diff(T value) {
		this.value = value;
		this.nullFlavor = null;
	}

	public Diff(NullFlavor nullFlavor) {
		this.value = null;
		this.nullFlavor = nullFlavor;
	}

	/**
	 * <p>Returns the diff value.
	 * 
	 * @return the diff value
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * <p>Returns the diff's null flavor.
	 * 
	 * @return the null flavor
	 */
	public NullFlavor getNullFlavor() {
		return this.nullFlavor;
	}

	/**
	 * <p>Determines if the diff has null flavor.
	 * 
	 * @return whether the diff has a null flavor set. 
	 */
	public boolean hasNullFlavor() {
		return this.nullFlavor != null;
	}

	/**
	 * <p>Sets a nullflavor on this diff.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public void setNullFlavor(NullFlavor nullFlavor) {
		this.nullFlavor = nullFlavor;
	}

	public Object getBareValue() {
		return getValue();
	}
	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
		        .append(this.value)
		        .append(this.nullFlavor)
                .toHashCode();
    }

    @SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((Diff<T>) obj);
        }
    }
    
    private boolean equals(Diff<T> that) {
        return new EqualsBuilder()
                .append(this.value, that.value)
                .append(this.nullFlavor, that.nullFlavor)
                .isEquals();
    }
    
}
