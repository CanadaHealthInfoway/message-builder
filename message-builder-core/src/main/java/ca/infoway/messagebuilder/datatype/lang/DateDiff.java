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

import java.math.BigDecimal;
import java.util.Date;

import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;

/**
 * <p>A specialist Diff class for Dates.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class DateDiff extends Diff<Date> implements NullFlavorSupport {

	// SS-20090407: Bug 10882 has been opened to allow this class to handle fractional units.
	
    // TODO SS-20080211: there is some overlap with DefaultTimeUnit here 
    public static final String YEAR = "a";
    public static final String MONTH = "mo";
    public static final String WEEK = "wk";
    public static final String SECOND = "s";
    public static final String MINUTE = "min";
    public static final String HOUR = "h";
    public static final String DAY = "d";
    private final Integer value;
    private final NullFlavor nullFlavor;
	private final PhysicalQuantity quantity;

	/**
	 * <p>Constructs a date diff from a given date.
	 * 
	 * @param value a date
	 */
    public DateDiff(Date value) {
        super(value);
        this.value = null;
        this.nullFlavor = null;
        this.quantity = null;
    }

    /**
     * <p>Constructs a date diff from the given parameters.
     * 
     * @param value a value
     * @param unit a unit
     */
    @Deprecated
    public DateDiff(int value, UnitsOfMeasureCaseSensitive unit) {
        this(new PhysicalQuantity(new BigDecimal(String.valueOf(value)), unit));
    }

    /**
     * <p>Constructs a date diff from the given parameter.
     * 
     * @param quantity a physical quantity
     */
    public DateDiff(PhysicalQuantity quantity) {
        super(asDate(quantity));
		this.quantity = quantity;
        this.value = quantity.getQuantity().intValue();
        this.nullFlavor = null;
    }

    /**
     * <p>Constructs a date diff with the given null flavor. 
     * 
     * @param nullFlavor a null flavor
     */
    public DateDiff(NullFlavor nullFlavor) {
        super(null);
        this.value = null;
        this.nullFlavor = nullFlavor;
        this.quantity = null;
    }

	private static Date asDate(PhysicalQuantity physicalQuantity) {
		UnitsOfMeasureCaseSensitive unit = physicalQuantity == null ? null : physicalQuantity.getUnit();
		BigDecimal value = physicalQuantity == null ? null : physicalQuantity.getQuantity();
		if (unit != null && unit instanceof DateConverter) {
			return new Date(((DateConverter) unit).toMilliseconds(value == null ? 0 : value.intValue()));
		} else if (unit != null) {
			DefaultTimeUnit timeUnit = DefaultTimeUnit.lookup(unit.getCodeValue());
			return (timeUnit == null) ? null : new Date(timeUnit.toMilliseconds(value));
		} else {
			return null;
		}
	}

	/**
	 * <p>Returns the units.
	 * 
	 * @return the units
	 */
    public UnitsOfMeasureCaseSensitive getUnit() {
        return this.quantity == null ? null : this.quantity.getUnit();
    }

    /**
     * <p>Strictly speaking, a DateDiff type uses a physical quantity to represent the 
     * width attribute.  This method only returns an int.  
     * Use <code>getValueAsPhysicalQuantity</code> instead.
     * 
     * @return the unit value
     */
    @Deprecated
    public Integer getUnitValue() {
        return this.value;
    }

    /**
     * <p>Returns the date diff as a physical quantity.
     * 
     * @return the date diff as a physical quantity.
     */
    public PhysicalQuantity getValueAsPhysicalQuantity() {
        return this.quantity;
    }
    
    /**
     * <p>Returns the string representation of this object.
     * 
     * @return the string representation of this object.
     */
    @Override
    public String toString() {
        if (getUnit() != null && this.value != null) {
            return "" + this.value + getUnit();
        } else {
            return super.toString();
        }
    }
    
    /**
     * <p>Returns the null flavor.
     * 
     * @return the null flavor
     */
    public NullFlavor getNullFlavor() {
        return this.nullFlavor;
    }

    /**
     * <p>Returns whether this object has a null flavor.
     * 
     * @return whether this object has a null flavor.
     */
    public boolean hasNullFlavor() {
        return this.nullFlavor != null;
    }
}
