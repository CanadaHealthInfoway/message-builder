/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.Describable;

/**
 * <p>Postal address parts are held by a postal address object and together make up the full address.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PostalAddressPart implements Serializable {

	private static final long serialVersionUID = -8651771688623021546L;
	private PostalAddressPartType type;
	private String value;
	private Code code;
	
	/**
	 * <p>Constructs an empty part.
	 */
	public PostalAddressPart() {
	}
	
	/**
	 * <p>Constructs a part with the given type and value. 
	 * 
	 * @param type the part type
	 * @param value the value of the part type
	 */
	public PostalAddressPart(PostalAddressPartType type, String value) {
		this.type = type;
		this.value = value;
	}
	
	/**
	 * <p>Constructs a part with the given type and value. 
	 * 
	 * @param value the value of the part type
	 * @param type the part type
	 */
	@Deprecated
	public PostalAddressPart(String value, PostalAddressPartType type) {
		this.type = type;
		this.value = value;
	}
	
	/**
	 * <p>Constructs a part with the given value (and no type).
	 * 
	 * @param value the value of the part type
	 */
	public PostalAddressPart(String value) {
		this.value = value;
	}
	
	/**
	 * <p>Constructs a postal address part with the supplied parameters. 
	 * 
	 * @param type the part type
	 * @param code the code for the part type
	 * @param originalValue the value of the part type
	 */
	public PostalAddressPart(PostalAddressPartType type, Code code, String originalValue) {
		this.type = type;
		this.code = code;
		this.value = originalValue;
	}
	
	/**
	 * <p>Constructs a postal address part with the supplied parameters. 
	 * 
	 * @param type the part type
	 * @param code the code for the part type
	 */
	public PostalAddressPart(PostalAddressPartType type, Code code) {
		this.type = type;
		this.code = code;
	}

	/**
	 * <p>Constructs a postal address part with the supplied parameters. 
	 * 
	 * @param type the part type
	 * @param codedString a coded string containing the code and value for this postal address part type
	 */
	public PostalAddressPart(PostalAddressPartType type, CodedString<? extends Code> codedString) {
		this.type = type;
		this.code = codedString == null ? null : codedString.getCode();
		this.value = codedString == null ? null : codedString.getValue();
	}
	
	/**
	 * <p>Gets the postal address part type.
	 * 
	 * @return the type
	 */
	public PostalAddressPartType getType() {
		return this.type;
	}
	
	/**
	 * <p>Sets the postal address part type.
	 * 
	 * @param type the type to set
	 */
	public void setType(PostalAddressPartType type) {
		this.type = type;
	}
	
	/**
	 * <p>Obtains the part type value, from either the value itself or the code.
	 * 
	 * @return the part type value
	 */
	public String getValue() {
		if (this.code != null && this.code instanceof Describable) {
			return ((Describable) this.code).getDescription();
		} else if (this.code != null) {
			return this.code.getCodeValue();
		} else {
			return this.value;
		}
	}
	
	/**
	 * <p>Sets the part type value (as a string).
	 * 
	 * @param value the part type value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * <p>The hashcode, based on type, value, and code.
	 * 
	 * @return the hashcode 
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.type).append(this.value).append(this.code).toHashCode();
	}
	
	/**
	 * <p>Compares the supplied object to this object for equality.
	 * 
	 * @param obj the object to compare
	 * @return whether the supplied object is equal to this object
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		} else {
			PostalAddressPart that = (PostalAddressPart) obj;
			return new EqualsBuilder()
					.append(this.type, that.type)
					.append(this.value, that.value)
					.append(this.code, that.code)
					.isEquals();
		}
	}
	
	/**
	 * <p>Gets the code, if available.
	 * 
	 * @return the code
	 */
	public Code getCode() {
		return this.code;
	}
	
	/**
	 * <p>Sets the code.
	 * 
	 * @param code the code
	 */
	public void setCode(Code code) {
		this.code = code;
	}
	
	/**
	 * <p>Returns a string representation of this object.
	 * 
	 * @return the object formatted as a string
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.type != null) {
			builder.append(this.type.toString());
			builder.append(" ");
		}
		if (StringUtils.isNotBlank(getValue())) {
			builder.append(getValue());
		}
		return builder.toString();
	}

	/**
	 * <p>Converts this postal address into a coded string. Makes use of value and code (and specifically, not the part type). 
	 * 
	 * @return this postal address part as a coded string (using value and code)
	 */
	public CodedString<Code> asCodedString() {
		return new CodedString<Code>(this.value, this.code);
	}
}
