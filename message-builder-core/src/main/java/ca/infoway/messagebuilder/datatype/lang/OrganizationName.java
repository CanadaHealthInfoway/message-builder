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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * <p>Java datatype that backs the HL7 datatype ON. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class OrganizationName extends EntityName {

    private List<EntityNamePart> parts = Collections.synchronizedList(new ArrayList<EntityNamePart>());
    
    /**
     * <p>Obtains the name parts.
     * 
     * @return the list of name parts
     */
    @Override
    public List<EntityNamePart> getParts() {
        return this.parts;
    }
    
    /**
     * <p>Adds a name part to the list of parts.
     * 
     * @param namePart the name part to add
     */
    public void addNamePart(EntityNamePart namePart) {
        this.parts.add(namePart);
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(this.parts)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((OrganizationName) obj);
        }
    }
    
    private boolean equals(OrganizationName that) {
        return new EqualsBuilder().appendSuper(super.equals(that))
                .append(this.parts, that.parts)
                .isEquals();
    }
}
