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
    
    /**
     * <p>Constructs a CodedString based on a value and a code. 
     * 
     * @param value the value of the SC
     * @param code the code for the SC
     */
    public CodedString(String value, T code) {
        this.value = value;
        this.code = code;
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
		        .append(this.code)
		        .append(this.value)
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
                .isEquals();
    }
}
