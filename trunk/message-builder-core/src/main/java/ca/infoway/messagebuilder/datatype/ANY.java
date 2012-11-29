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

package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>ANY Hl7 datatype.
 * 
 * <p>Defines the basic properties of every data value.
 * 
 * <p>This is an abstract type, meaning that no value can be just a data value
 * without belonging to any concrete type. Every concrete type is a
 * specialization of this general abstract DataValue type.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying java datatype
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface ANY<V> extends BareANY {

	/**
	 * <p>Returns the value.
	 * 
	 * @return the underlying java datatype value 
	 */
	V getValue();
	
	/**
	 * <p>Sets a value on the ANY object.
	 * 
	 * @param value the value to set on this ANY object
	 */
	void setValue(V value);

	/**
	 * <p>Indicates that a value is a non-exceptional value of the data type.
	 * 
	 * <p>When a property, RIM attribute, or message field is called mandatory this means 
	 * that any non-NULL value of the type to which the property belongs has a non-NULL 
	 * value for that property, in other words, a field may not be NULL, providing that 
	 * its container (object, segment, etc.) is to have a non-NULL value.
	 * 
	 * @return whether this object has no null flavor 
	 */
	boolean nonNull();

	/**
	 * <p>If a value is an exceptional value (NULL-value), this specifies in what way and why proper information is missing.
	 * 
	 * <p>The null flavors are a general domain extension of all normal data types. Note the distinction between 
	 * value domain of any data type and the vocabulary domain of coded data types. A vocabulary domain is a 
	 * value domain for coded values, but not all value domains are vocabulary domains.
	 * 
	 * <p>The null flavor "other" is used whenever the actual value is not in the required value domain, 
	 * this may be, for example, when the value exceeds some constraints that are defined too 
	 * restrictive (e.g., age less than 100 years.)
	 * 
	 * <p>NOTE: NULL-flavors are applicable to any property of a data value or a higher-level object attribute. 
	 * Where the difference of null flavors is not significant, ITS are not required to represent them. If nothing 
	 * else is noted in this specification, ITS need not represent general NULL-flavors for data-value properties.
	 * 
	 * <p>Some of these null flavors are associated with named properties that can be used as simple predicates 
	 * for all data values. This is done to simplify the formulation of invariants in the remainder of this specification.
	 * 
	 * <p>Remember the difference between semantic properties and representational "components" of data values. 
	 * An ITS must only represent those components that are needed to infer the semantic properties.
	 *  
	 * <p>The null-flavor predicates nonNull, isNull, notApplicable, unknown, and other can all be 
	 * inferred from the nullFlavor property.
	 * 
     * @return the null flavor
	 */
	NullFlavor getNullFlavor();
	
    /**
     * <p>Sets a null flavor on the object.
     * 
     * @param nullFlavor the null flavor to set
     */
	void setNullFlavor(NullFlavor nullFlavor);

	/**
	 * <p>Indicates that a value is an exceptional value, or a NULL-value. A null value means that 
	 * the information does not exist, is not available or cannot be expressed in the data type's 
	 * normal value set.
	 * 
	 * <p>Every data element has either a proper value or it is considered NULL. If (and only if) 
	 * it is NULL, the isNull provides more detail as to in what way or why no proper value is supplied.
	 * 
	 * @return whether this object has a null flavor 
	 */
	boolean isNull();

	/**
	 * <p>A predicate indicating that this exceptional value is of nullFlavor not-applicable (NA), i.e.,  
	 * that a proper value is not meaningful in the given context.
	 * 
	 * @return whether this ANY object has a null flavor of "Not applicable" 
	 */
	boolean notApplicable();

	/**
	 * <p>A predicate indicating that this exceptional value is of nullFlavor unknown (UNK).
	 * 
	 * @return whether this ANY object has a null flavor of "unknown" 
	 */
	boolean unknown();

	/**
	 * <p>A predicate indicating that this exceptional value is of nullFlavor other (OTH), i.e., that the required 
	 * value domain does not contain the appropriate value.
	 * 
	 * @return whether this ANY object has a null flavor of "other" 
	 */
	boolean other();
	
}
