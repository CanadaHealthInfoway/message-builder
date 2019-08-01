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

import ca.infoway.messagebuilder.datatype.lang.util.NamePartType;
import ca.infoway.messagebuilder.domainvalue.EntityNamePartQualifier;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Class to represent an entity name part, containing a name part type and a value. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class EntityNamePart {

    private final NamePartType type;
    private final String value;
    private final EntityNamePartQualifier qualifier;
    private final NullFlavor nullFlavor;
    
	/**
     * <p>Constructs an EntityNamePart using only a value.
     * 
     * @param value the name part value
     */
    public EntityNamePart(String value) {
        this(value, null);
    }
    
    /**
     * <p>Constructs an EntityNamePart using the supplied parameters.
     * 
     * @param value the name part value
     * @param type the name part type
     */
    public EntityNamePart(String value, NamePartType type) {
        this(value, type, null);
    }
    
    /**
     * <p>Constructs an EntityNamePart using the supplied parameters.
     * 
     * @param value the name part value
     * @param type the name part type
     * @param qualifier the name part qualifier
     */
	public EntityNamePart(String value, NamePartType type, EntityNamePartQualifier qualifier) {
		this(value, type, qualifier, null);
    }

    /**
     * <p>Constructs an EntityNamePart using the supplied parameters.
     * 
     * @param type the name part type
     * @param nullFlavor the null flavor explaining the absence of the value
     */
	public EntityNamePart(NamePartType type, NullFlavor nullFlavor) {
		this(null, type, null, nullFlavor);
    }

    /**
     * <p>Constructs an EntityNamePart using the supplied parameters.
     * 
     * This constructor may not make sense to have as public. May become private in a later release.
     * 
     * @param value the name part value
     * @param type the name part type
     * @param qualifier the name part qualifier
     */
	public EntityNamePart(String value, NamePartType type, EntityNamePartQualifier qualifier, NullFlavor nullFlavor) {
        this.value = value;
        this.type = type;
		this.qualifier = qualifier;
		this.nullFlavor = nullFlavor;
    }

    /**
     * <p>Returns the name part type.
     * 
     * @return the name part type
     */
    public NamePartType getType() {
        return this.type;
    }
    
    /**
     * <p>Returns the name part value.
     * 
     * @return the name part value
     */
    public String getValue() {
        return this.value;
    }
    
    /**
     * <p>Returns the name part nullFlavor.
     * 
     * @return the name part nullFlavor
     */
    public NullFlavor getNullFlavor() {
		return nullFlavor;
	}

    /**
     * Returns the qualifier value.
     * 
     * @return the qualifier
     */
    public EntityNamePartQualifier getQualifier() {
		return this.qualifier;
	}

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
			    .append(this.type)
			    .append(this.value)
			    .append(this.qualifier)
			    .append(this.nullFlavor)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((EntityNamePart) obj);
        }
    }
    
    private boolean equals(EntityNamePart that) {
        return new EqualsBuilder()
                .append(this.type, that.type)
                .append(this.value, that.value)
                .append(this.qualifier, that.qualifier)
                .append(this.nullFlavor, that.nullFlavor)
                .isEquals();
    }
}
