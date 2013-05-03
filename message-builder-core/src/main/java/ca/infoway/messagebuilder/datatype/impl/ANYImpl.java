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

package ca.infoway.messagebuilder.datatype.impl;

import static ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.NOT_APPLICABLE;
import static ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.OTHER;
import static ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.UNKNOWN;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
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
 * @sharpen.ignore - datatype - translated manually 
 */
public class ANYImpl<V> extends BareANYImpl implements ANY<V> {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 5073666472702745793L;
	
	private final Class<?> rawType;
	
	private V value;
	private NullFlavor nullFlavor;
	
	private StandardDataType dataType;

	private String language;
	
	private String displayName;
	private final List<CD> translations = new ArrayList<CD>();
	private String originalText;
	
	/**
	 * <p>Constructs an empty ANY.
	 */
	public ANYImpl() {
		this((Class<?>) null);
	}

	/**
	 * <p>Constructs an ANY object based on an underlying java datatype.
	 *  
	 * @param rawType the java datatype this ANY is based on
	 */
	public ANYImpl(Class<?> rawType) {
		this(rawType, null, null);
	}

	/**
	 * <p>Constructs an ANY object.
	 * 
	 * @param value the underlying java value of thie ANY object.
	 * @param nullFlavor the null flavor to set on the ANY object
	 */
	public ANYImpl(V value, NullFlavor nullFlavor) {
		this(null, value, nullFlavor);
	}

	/**
	 * <p>Constructs an ANY object.
	 * 
	 * @param rawType the java datatype this ANY is based on
	 * @param value the underlying java value of thie ANY object.
	 * @param nullFlavor the null flavor to set on the ANY object
	 */
	public ANYImpl(Class<?> rawType, V value, NullFlavor nullFlavor) {
		this(rawType, value, nullFlavor, StandardDataType.ANY);
	}

	/**
	 * <p>Constructs an ANY object.
	 * 
	 * @param value the underlying java value of thie ANY object.
	 * @param nullFlavor the null flavor to set on the ANY object
	 * @param dataType the enum datatype of this ANy object
	 */
	public ANYImpl(V value, NullFlavor nullFlavor, StandardDataType dataType) {
		this(null, value, nullFlavor, dataType);
	}
	
	/**
	 * <p>Constructs an ANY object.
	 * 
	 * @param rawType the java datatype this ANY is based on
	 * @param value the underlying java value of thie ANY object.
	 * @param nullFlavor the null flavor to set on the ANY object
	 * @param dataType the enum datatype of this ANy object
	 */
	public ANYImpl(Class<?> rawType, V value, NullFlavor nullFlavor, StandardDataType dataType) {
		this.rawType = rawType;
		this.value = value;
		this.nullFlavor = nullFlavor;
		this.dataType = dataType;
	}
	
	/**
	 * <p>Returns the value.
	 * 
	 * @return the underlying java datatype value 
	 */
	public V getValue() {
		return this.value;
	}

	/**
	 * <p>Sets a value on the ANY object.
	 * 
	 * @param value the value to set on this ANY object
	 */
	public void setValue(V value) {
		validateValue(value);
		this.value = value;
	}
	
	private void validateValue(V value) {
		if (value!=null && this.rawType!=null && !this.rawType.isInstance(value)) {
			throw new RuntimeException(MessageFormat.format(
					"Invalid raw type {0} for {1}. Valid raw type is {2}", value.getClass(), getClass(), this.rawType.getName()));
		}
	}

	/**
	 * <p>Obtain the null representation (typically "null") for this particular ANY type (V).
	 * 
	 * <p>For example, the null representation  of a list will be an empty list.
	 * 
	 * @return the value representing null for the ANY type (V)
	 */
	protected V getNullValue() {
		return null;
	}
	
	/**
	 * <p>Determines if the object currently has a null flavor set.
	 * 
	 * @return whether the object currently has a null flavor.
	 */
	public boolean hasNullFlavor() {
		return getNullFlavor() != null;
	}
	
    /**
     * <p>Returns the current null flavor state of the object.
     * 
     * @return the null flavor
     */
	public NullFlavor getNullFlavor() {
		return this.nullFlavor;
	}
	
	/**
	 * <p>Determines if this ANY object has a null flavor.
	 * 
	 * @return whether this object has a null flavor 
	 */
	public boolean isNull() {
		return hasNullFlavor();
	}

	/**
	 * <p>Determines if this ANY object has no null flavor.
	 * 
	 * @return whether this object has no null flavor 
	 */
	public boolean nonNull() {
		return !isNull();
	}

	/**
	 * <p>Determines whether this ANY object has a null flavor of "Not applicable".
	 *  
	 * @return whether this ANY object has a null flavor of "Not applicable" 
	 */
	public boolean notApplicable() {
		return NOT_APPLICABLE.equals(getNullFlavor());
	}

	/**
	 * <p>Determines whether this ANY object has a null flavor of "other".
	 *  
	 * @return whether this ANY object has a null flavor of "other" 
	 */
	public boolean other() {
		return OTHER.equals(getNullFlavor());
	}

    /**
     * <p>Sets a null flavor on the object.
     * 
     * @param nullFlavor the null flavor to set
     */
	public void setNullFlavor(NullFlavor nullFlavor) {
		this.nullFlavor = nullFlavor;
	}

	/**
	 * <p>Determines whether this ANY object has a null flavor of "unknown".
	 *  
	 * @return whether this ANY object has a null flavor of "unknown" 
	 */
	public boolean unknown() {
		return UNKNOWN.equals(getNullFlavor());
	}

	/**
	 * <p>Compares two ANY objects to see if they are equal.
	 * 
	 * @param obj the object to compare
	 * @return whether the objects are equal
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		return this.equal((ANY) obj);
	}

	private boolean equal(ANY<V> otherAny) {
		boolean equal;
		if (isNull() || otherAny.isNull()) {
			equal = false;
		} else {
			equal = getValue() != null ? getValue().equals(otherAny.getValue()) : otherAny.getValue()==null; 
		}
		return equal;
	}
	
	/**
	 * <p>Generates a hashcode for this class.
	 * 
	 * @return the hashcode
	 */
	@Override
	public int hashCode() {
		int result = 17;
		if (this.value != null) {
			result ^= this.value.hashCode();
		}
		if (this.nullFlavor != null) {
			result ^= this.nullFlavor.hashCode();
		}
		return result;
	}
	
	/**
	 * <p>Represents the fact that every data value implicitly carries information about its own data type. 
	 * Thus, given a data value one can inquire about its data type.
	 * 
	 * @return the underlying enum datatype
	 */
	public final StandardDataType getDataType() {
		return this.dataType;
	}

	/**
	 * <p>Sets this ANY's datatype.
	 * 
	 * @param dataType the underlying enum datatype
	 */
	public final void setDataType(StandardDataType dataType) {
			this.dataType = dataType;
	}

	@Override
	public Object getBareValue() {
		return getValue();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void setBareValue(Object value) {
		this.value = (V) value;
	}
	
	
	
	
	
	/**
	 * <p>Returns the ST's language.
	 * 
	 * @return the language of the ST
	 */
	public String getLanguage() {
		return this.language;
	}
	
	/**
	 * <p>Sets the language of the ST.
	 * 
	 * @param language a language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	/**
	 * <p>Returns the display name.
	 * 
	 * @return the display name
	 */
	public String getDisplayName() {
		return this.displayName;
	}
	
	/**
	 * <p>Sets the display name.
	 * 
	 * @param displayName the display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * <p>Returns the translations for this CD.
	 * 
	 * @return the translations for this CD
	 */
	public List<CD> getTranslations() {
		return this.translations;
	}

	/**
	 * <p>Returns the original text.
	 * 
	 * @return the original text
	 */
	public String getOriginalText() {
		return originalText;
	}

	/**
	 * <p>Sets the original text.
	 * 
	 * @param originalText the original text
	 */
	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}
	
}
