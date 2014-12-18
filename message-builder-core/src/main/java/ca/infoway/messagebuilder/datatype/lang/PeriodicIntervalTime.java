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
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.PERIOD;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.PERIOD_PHASE;
import static ca.infoway.messagebuilder.datatype.lang.util.Representation.PHASE;

import java.util.Date;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.datatype.lang.util.Representation;

/**
 * <p>Periodic Interval of Time (PIVL) specializes SXCM. Backed by a java Date.
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
public class PeriodicIntervalTime extends SetComponent<Date> {

	private final DateDiff period;
	private final Interval<Date> phase;
	private final Representation representation;
	private final Integer repetitions;
	private final PhysicalQuantity quantity;

	protected PeriodicIntervalTime(DateDiff period, Interval<Date> phase, 
			Integer repetitions, PhysicalQuantity quantity, 
			Representation representation) {
		this.period = period;
		this.phase = phase;
		this.repetitions = repetitions;
		this.quantity = quantity;
		this.representation = representation;
	}

	/**
	 * <p>Constructs a PeriodicIntervalTime using the supplied parameters.
	 * 
	 * @param period DateDiff period
	 * @return the constructed PeriodicIntervalTime
	 */
	public static PeriodicIntervalTime createPeriod(DateDiff period) {
		Validate.notNull(period);
		return new PeriodicIntervalTime(period, null, null, null, PERIOD);
	}

	/**
	 * <p>Constructs a PeriodicIntervalTime using the supplied parameters.
	 * 
	 * @param phase phase Interval
	 * @return the constructed PeriodicIntervalTime
	 */
	public static PeriodicIntervalTime createPhase(Interval<Date> phase) {
		Validate.notNull(phase);
		return new PeriodicIntervalTime(null, phase, null, null,PHASE);
	}

	/**
	 * <p>Constructs a PeriodicIntervalTime using the supplied parameters.
	 * 
	 * @param period DateDiff period
	 * @param phase phase Interval
	 * @return the constructed PeriodicIntervalTime
	 */
	public static PeriodicIntervalTime createPeriodPhase(DateDiff period, Interval<Date> phase) {
		Validate.notNull(phase);
		return new PeriodicIntervalTime(period, phase, null, null, PERIOD_PHASE);
	}

	/**
	 * <p>Constructs a PeriodicIntervalTime using the supplied parameters.
	 * 
	 * @param repetitions number of repetitions
	 * @param quantity a physical quantity
	 * @return the constructed PeriodicIntervalTime
	 */
	public static PeriodicIntervalTime createFrequency(Integer repetitions, PhysicalQuantity quantity) {
		return new PeriodicIntervalTime(null, null, repetitions, quantity, FREQUENCY);
	}
	
	public static PeriodicIntervalTime createFromPivlR2(PeriodicIntervalTimeR2 pivlR2) {
		DateDiff dateDiff = (pivlR2.getPeriod() == null ? null : new DateDiff(pivlR2.getPeriod()));
		Representation representation = pivlR2.getPeriod() != null || pivlR2.getPhase() != null ? Representation.PERIOD_PHASE : Representation.FREQUENCY; 
		return new PeriodicIntervalTime(dateDiff, pivlR2.getPhase(), pivlR2.getFrequencyRepetitions(), pivlR2.getFrequencyQuantity(), representation);
	}

	
	/**
	 * <p>Gets the period.
	 * 
	 * @return the period
	 */
	public DateDiff getPeriod() {
		return this.period;
	}

	/**
	 * <p>Returns the phase.
	 * 
	 * @return the phase
	 */
	public Interval<Date> getPhase() {
		return this.phase;
	}

	/**
	 * <p>Returns the representation.
	 * 
	 * @return the representation.
	 */
	public Representation getRepresentation() {
		return this.representation;
	}

	/**
	 * <p>Returns the number of repetitions.
	 * 
	 * @return the number of repetitions
	 */
	public Integer getRepetitions() {
		return this.repetitions;
	}

	/**
	 * <p>Returns the physical quantity. 
	 * 
	 * @return the quantity
	 */
	public PhysicalQuantity getQuantity() {
		return this.quantity;
	}
	
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(this.period)
                .append(this.phase)
                .append(this.representation)
                .append(this.repetitions)
                .append(this.quantity)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((PeriodicIntervalTime) obj);
        }
    }
    
	private boolean equals(PeriodicIntervalTime that) {
        return new EqualsBuilder().appendSuper(super.equals(that))
                .append(this.period, that.period)
                .append(this.phase, that.phase)
                .append(this.representation, that.representation)
                .append(this.repetitions, that.repetitions)
                .append(this.quantity, that.quantity)
                .isEquals();
    }
	
}
