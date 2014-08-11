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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.datatype.lang.util.SetOperator;
import ca.infoway.messagebuilder.domainvalue.PostalAddressUse;

/**
 * <p>Java datatype for AD Hl7 datatype. 
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-AD
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PostalAddress implements Serializable {
	
	private static final long serialVersionUID = -12550370508382374L;
    
    private final List<PostalAddressPart> parts = Collections.synchronizedList(new ArrayList<PostalAddressPart>());
	private Set<PostalAddressUse> uses = Collections.synchronizedSet(new LinkedHashSet<PostalAddressUse>());
	
	// added for R2 usage only
	private Map<Date, SetOperator> useablePeriods = new LinkedHashMap<Date, SetOperator>();
	private Boolean isNotOrdered;

    /**
     * <p>Obtains the postal address' set of uses.
     * 
     * @return set of postal address uses
     */
    public Set<PostalAddressUse> getUses() {
        return this.uses;
    }
    
    /**
     * <p>Replaces the postal address' set of uses.
     * 
     * @param uses  set of postal address uses
     */
    public void setUses(Set<PostalAddressUse> uses) {
        this.uses = uses;
    }
    
    /**
     * <p>Adds a postal address use.
     * 
     * @param use a postal address use
     */
    public void addUse(PostalAddressUse use) {
        this.uses.add(use);
    }
    
    /**
     * <p>Obtains the list of postal address parts for this postal address.
     * 
     * @return list of postal address parts
     */
    public List<PostalAddressPart> getParts() {
        return this.parts;
    }
    
    /**
     * <p>Add a part to this postal address.
     * 
     * @param postalAddressPart the part to add
     */
    public void addPostalAddressPart(PostalAddressPart postalAddressPart) {
        this.parts.add(postalAddressPart);
    }
    
	/**
	 * Useable periods or the given telecom address. The periods will be sorted internally. 
	 * 
	 * @return the useable periods
	 */
	public Map<Date, SetOperator> getUseablePeriods() {
		return useablePeriods;
	}
	
	/**
	 * Convenience method for adding a period and inclusive operator.
	 * 
	 * @param periodInTime
	 * @param inclusive
	 * @return whether the added period replaced an existing period 
	 */
	public boolean addUseablePeriod(Date periodInTime, SetOperator operator) {
		// leave it up to the user to worry about a given time replacing an existing one
		return this.useablePeriods.put(periodInTime, operator == null ? SetOperator.INCLUDE : operator) != null;
	}

    public Boolean getIsNotOrdered() {
		return isNotOrdered;
	}

	public void setIsNotOrdered(Boolean isNotOrdered) {
		this.isNotOrdered = isNotOrdered;
	}

	@Override
    public int hashCode() {
        return new HashCodeBuilder()
		        .append(this.uses)
		        .append(this.parts)
		        .append(this.useablePeriods)
		        .append(this.isNotOrdered)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((PostalAddress) obj);
        }
    }
    
    private boolean equals(PostalAddress that) {
        return new EqualsBuilder()
                .append(this.uses, that.uses)
                .append(this.parts, that.parts)
                .append(this.useablePeriods, that.useablePeriods)
                .append(this.isNotOrdered, that.isNotOrdered)
                .isEquals();
    }
    
}
