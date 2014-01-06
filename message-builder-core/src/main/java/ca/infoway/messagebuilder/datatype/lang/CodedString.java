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

import ca.infoway.messagebuilder.Code;

/**
 * <p>Java datatype backing the Hl7 datatype SC (Coded String).
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying code type
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class CodedString<T extends Code> {
    
    private final T code;
    private final String value;
    
    // these would normally be on Code itself, but they are not used in the pan-Canadian standards and only apply to SC
    private final String displayName;
    private final String codeSystemName;
    private final String codeSystemVersion;
    
    /**
     * <p>Constructs a CodedString based on a value and a code. 
     * 
     * @param value the value of the SC
     * @param code the code for the SC
     */
    public CodedString(String value, T code) {
    	this(value, code, null, null, null);
    }

    /**
     * 
     * @param value the value of the SC
     * @param code the code for the SC
     * @param displayName alternate display name for the SC
     * @param codeSystemName name of code system for the provided code
     * @param codeSystemVersion version of code system for the provided code
     */
	public CodedString(String value, T code, String displayName, String codeSystemName, String codeSystemVersion) {
        this.value = value;
        this.code = code;
		this.displayName = displayName;
		this.codeSystemName = codeSystemName;
		this.codeSystemVersion = codeSystemVersion;
    }
    
    /**
     * <p>Returns the code.
     * 
     * @return the code
     */
    public T getCode() {
        return this.code;
    }
    
    /**
     * <p>Returns the value.
     * 
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * <p>Returns the display anme.
     * 
     * @return the display name
     */
    public String getDisplayName() {
		return displayName;
	}

    /**
     * <p>Returns the code system name.
     * 
     * @return the code system name
     */
	public String getCodeSystemName() {
		return codeSystemName;
	}

    /**
     * <p>Returns the code system version.
     * 
     * @return the code system version
     */
	public String getCodeSystemVersion() {
		return codeSystemVersion;
	}

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
		        .append(this.code)
		        .append(this.value)
		        .append(this.displayName)
		        .append(this.codeSystemName)
		        .append(this.codeSystemVersion)
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
            return equals((CodedString<T>) obj);
        }
    }
    
    private boolean equals(CodedString<T> that) {
        return new EqualsBuilder()
                .append(this.code, that.code)
                .append(this.value, that.value)
		        .append(this.displayName, that.displayName)
		        .append(this.codeSystemName, that.codeSystemName)
		        .append(this.codeSystemVersion, that.codeSystemVersion)
                .isEquals();
    }
}
