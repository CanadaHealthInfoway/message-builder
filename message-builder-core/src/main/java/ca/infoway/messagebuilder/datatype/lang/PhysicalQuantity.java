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
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;

/**
 * <p>A class to represent CeRx's notion of a physical quantity. Backs the Hl7 datatype PQ.
 *
 * <p>There are two attributes of note: value (amount) and unit.
 * 
 * <p>The HL7 version of this class relies on the HL7 REAL, which is a
 * re-implemented BigDecimal for all intents and purposes.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @see <a href="http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PQ">The HL7 Definition</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PhysicalQuantity implements Serializable {
    
    private static final long serialVersionUID = 5932473836237229686L;
    
    private BigDecimal quantity;
    private UnitsOfMeasureCaseSensitive unit;

    /**
     * <p>Constructs an empty physical quantity. 
     */
    public PhysicalQuantity() {
    }
    
    /**
     * <p>Constructs a physical quantity based on an amount and a unit. 
     * 
     * @param quantity an amount
     * @param unit a unit of measurement
     */
    public PhysicalQuantity(BigDecimal quantity, UnitsOfMeasureCaseSensitive unit) {
        this.quantity = quantity;
        this.unit = unit;
    }
    
    /**
     * <p>Returns the quantity.
     * 
     * @return the quantity.
     */
    public BigDecimal getQuantity() {
        return this.quantity;
    }
    
    /**
     * <p>Sets the quantity to the supplied BigDecimal value. 
     * 
     * @param quantity the quantity as a big decimal
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * <p>Obtains the units of this PQ.
     * 
     * @return the units
     */
    public UnitsOfMeasureCaseSensitive getUnit() {
        return this.unit;
    }
    
    /**
     * <p>Sets the units of this PQ.
     * 
     * @param unit the units
     */
    public void setUnit(UnitsOfMeasureCaseSensitive unit) {
        this.unit = unit;
    }
    
    /**
     * <p>Generates a hash code for this object based on its quantity and units.
     * 
     * @return the hashcode
     */
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.quantity)
                .append(this.unit)
                .toHashCode();
    }

    /**
     * <p>Compares the supplied object with this object to see if they are equal.
     * 
     * @param obj the object to compare
     * @return whether the objects are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((PhysicalQuantity) obj);
        }
    }
    
    private boolean equals(PhysicalQuantity that) {
        return new EqualsBuilder().append(this.quantity, that.quantity)
                .append(this.unit, that.unit)
                .isEquals();
    }
    
    /**
     * <p>Converts this object to s atring.
     * 
     * @return a string representation of this object
     */
    public String toString() {
        return "" + this.quantity + getUnitAsString();
    }
    
    private String getUnitAsString() {
        String unitAsString = (this.unit == null) ? "" : this.unit.toString();
        if (StringUtils.isBlank(unitAsString)) {
            return "";
        } else if (StringUtils.isNumeric(unitAsString.substring(0, 1))) {
            return "(" + unitAsString + ")";
        } else {
            return unitAsString;
        }
    }
}
