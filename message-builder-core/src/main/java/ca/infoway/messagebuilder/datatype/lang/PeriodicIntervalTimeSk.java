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

import static ca.infoway.messagebuilder.datatype.lang.util.Representation.FREQUENCY;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.datatype.lang.util.Representation;

/**
 * <p>Periodic Interval of Time (PIVL) specializes SXCM. Backed by a java Date.
 * 
 * This is a special implementation for Saskatechewan since this jurisdiction redefined the GTS.BOUNDEDPIVL datatype. 
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PIVL
 * 
 * <p>Definition: An interval of time that recurs periodically. Periodic intervals
 * have two properties, phase and period. The phase specifies the "interval
 * prototype" that is repeated every period.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class PeriodicIntervalTimeSk extends PeriodicIntervalTime {

	private final Interval<PhysicalQuantity> quantitySk;

	private PeriodicIntervalTimeSk(DateDiff period, Interval<Date> phase, 
			Integer repetitions, Interval<PhysicalQuantity> quantitySk, 
			Representation representation) {
		super(period, phase, repetitions, null, representation);
		this.quantitySk = quantitySk;
	}

	/**
	 * <p>Constructs a PeriodicIntervalTimeSk using the supplied parameters.
	 * 
	 * @param repetitions number of repetitions
	 * @param quantity a physical quantity
	 * @return the constructed PeriodicIntervalTime
	 */
	public static PeriodicIntervalTimeSk createFrequencySk(Integer repetitions, PhysicalQuantity lowQuantity, PhysicalQuantity highQuantity) {
		Interval<PhysicalQuantity> ivlPq = IntervalUtil.createInterval(lowQuantity, highQuantity);
		return new PeriodicIntervalTimeSk(null, null, repetitions, ivlPq, FREQUENCY);
	}

	@Deprecated
	public PhysicalQuantity getQuantity() {
		throw new UnsupportedOperationException("getQuantity() call not allowed for SK version. Use getQuantitySk() instead.");
	}

	/**
	 * <p>Returns the physical quantity interval. 
	 * 
	 * @return the quantity interval
	 */
	public Interval<PhysicalQuantity> getQuantitySk() {
		return this.quantitySk;
	}
	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(this.quantitySk)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((PeriodicIntervalTimeSk) obj);
        }
    }
    
	private boolean equals(PeriodicIntervalTimeSk that) {
        return new EqualsBuilder().appendSuper(super.equals(that))
                .append(this.quantitySk, that.quantitySk)
                .isEquals();
    }
	
}
