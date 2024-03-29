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

import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;

/**
 * <p>Set Component (SXCM)
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-SXCM
 * 
 * <p>Definition: An ITS-defined generic type extension for the base data type of a
 * set, representing a component of a general set over a discrete or continuous
 * value domain. Its use is mainly for continuous value domains. Discrete
 * (enumerable) set components are the individual elements of the base data
 * type.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying java datatype
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class SetComponent<T> {

	private final T value;
	private final SetOperator operator;

	/**
	 * 	<p>Constructs an empty SetComponent.
	 */
	public SetComponent() {
		this(null);
	}

	/**
	 * 	<p>Constructs a SetComponent with the given value.
	 * 
	 * @param value the underying java datatype value.
	 */
	public SetComponent(T value) {
		this(value, null);
	}

	/**
	 * 	<p>Constructs a SetComponent with the given value and operator.
	 * 
	 * @param value the underlying java datatype value
	 * @param operator the set operator for this set component
	 */
	public SetComponent(T value, SetOperator operator) {
		this.value = value;
		this.operator = operator;
	}

	/**
	 * <p>Returns the java datatype value.
	 * 
	 * @return the java datatype value.
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * <p>Returns the set operator.
	 * 
	 * @return the set operator
	 */
	public SetOperator getOperator() {
		return this.operator;
	}
	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
		        .append(this.value)
		        .append(this.operator)
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
            return equals((SetComponent<T>) obj);
        }
    }
    
    private boolean equals(SetComponent<T> that) {
        return new EqualsBuilder()
        		.append(this.value, that.value)
                .append(this.operator, that.operator)
                .isEquals();
    }
    
}
