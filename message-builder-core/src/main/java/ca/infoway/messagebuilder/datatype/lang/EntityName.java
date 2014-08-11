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
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;

/**
 * <p>Abstract super class for names.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class EntityName {

	private List<EntityNamePart> parts = Collections.synchronizedList(new ArrayList<EntityNamePart>());
    private Set<EntityNameUse> uses = Collections.synchronizedSet(new TreeSet<EntityNameUse>());
    private Interval<Date> validTime;
    
	/**
     * <p>Obtains the name parts.
     * 
     * @return the list of name parts
     */
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
    
    
    /**
     * <p>Obtains the set of name uses for this name.
     * 
     * @return the set of name uses
     */
    public Set<EntityNameUse> getUses() {
        return this.uses;
    }
    
    /**
     * <p>Adds a name use to this name.
     * 
     * @param use the name use to add
     */
    public void addUse(EntityNameUse use) {
        this.uses.add(use);
    }
    
    /**
     * <p>Obtains the time interval for which this name is valid
     * 
     * @return the valid time interval
     */
    public Interval<Date> getValidTime() {
		return validTime;
	}

    /**
     * <p>Sets the time interval for which this name is valid
     * 
     * @param validTime
     */
	public void setValidTime(Interval<Date> validTime) {
		this.validTime = validTime;
	}

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.parts)
                .append(this.uses)
                .append(this.validTime)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((EntityName) obj);
        }
    }
    
    private boolean equals(EntityName that) {
        return new EqualsBuilder()
                .append(this.parts, that.parts)
                .append(this.uses, that.uses)
                .append(this.validTime, that.validTime)
                .isEquals();
    }
    
}
