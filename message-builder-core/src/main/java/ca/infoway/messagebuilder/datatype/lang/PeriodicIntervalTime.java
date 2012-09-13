/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import static ca.infoway.messagebuilder.datatype.lang.Representation.FREQUENCY;
import static ca.infoway.messagebuilder.datatype.lang.Representation.PERIOD;
import static ca.infoway.messagebuilder.datatype.lang.Representation.PERIOD_PHASE;
import static ca.infoway.messagebuilder.datatype.lang.Representation.PHASE;

import java.util.Date;

import org.apache.commons.lang.Validate;

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
}
