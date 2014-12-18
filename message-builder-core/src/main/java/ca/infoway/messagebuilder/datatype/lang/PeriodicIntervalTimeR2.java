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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-05-15 18:39:56 -0400 (Wed, 15 May 2013) $
 * Revision:      $LastChangedRevision: 6874 $
 */

package ca.infoway.messagebuilder.datatype.lang;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.datatype.lang.util.CalendarCycle;

/**
 * <p>Periodic Interval of Time (PIVL_TS; R2)
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
public class PeriodicIntervalTimeR2 extends MbDate implements Serializable {

	private static final long serialVersionUID = -7334434139857699836L;
	
	private Interval<Date> phase;
	private PhysicalQuantity period;
	private CalendarCycle alignment;
	private Boolean institutionSpecified;
	private Integer frequencyRepetitions;
	private PhysicalQuantity frequencyQuantity;

	public PeriodicIntervalTimeR2(Interval<Date> phase, PhysicalQuantity period) {
		this(phase, period, null, null, null, null);
	}
	
	public PeriodicIntervalTimeR2(Integer frequencyRepetitions, PhysicalQuantity frequencyQuantity) {
		this(null, null, null, null, frequencyRepetitions, frequencyQuantity);
	}
	
	public PeriodicIntervalTimeR2(Interval<Date> phase, PhysicalQuantity period, CalendarCycle alignment, Boolean institutionSpecified, Integer frequencyRepetitions, PhysicalQuantity frequencyQuantity) {  
		this.period = period;
		this.phase = phase;
		this.alignment = alignment;
		this.institutionSpecified = institutionSpecified;
		this.frequencyRepetitions = frequencyRepetitions;
		this.frequencyQuantity = frequencyQuantity;
	}

	public static PeriodicIntervalTimeR2 createFromPivlR1(PeriodicIntervalTime pivlR1) {
		DateDiff period = pivlR1.getPeriod();
		PhysicalQuantity periodPq = (period != null ? period.getValueAsPhysicalQuantity() : null);
		Interval<Date> phase = pivlR1.getPhase();
		PhysicalQuantity quantity = pivlR1.getQuantity();
		Integer repetitions = pivlR1.getRepetitions();
		return new PeriodicIntervalTimeR2(phase, periodPq, null, null, repetitions, quantity);
	}
	
    public Interval<Date> getPhase() {
		return phase;
	}
    
	public void setPhase(Interval<Date> phase) {
		this.phase = phase;
	}

	public PhysicalQuantity getPeriod() {
		return period;
	}

	public void setPeriod(PhysicalQuantity period) {
		this.period = period;
	}

	public CalendarCycle getAlignment() {
		return alignment;
	}

	public void setAlignment(CalendarCycle alignment) {
		this.alignment = alignment;
	}

	public Boolean getInstitutionSpecified() {
		return institutionSpecified;
	}
	
	public void setInstitutionSpecified(Boolean institutionSpecified) {
		this.institutionSpecified = institutionSpecified;
	}

	public Integer getFrequencyRepetitions() {
		return frequencyRepetitions;
	}

	public void setFrequencyRepetitions(Integer frequencyRepetitions) {
		this.frequencyRepetitions = frequencyRepetitions;
	}

	public PhysicalQuantity getFrequencyQuantity() {
		return frequencyQuantity;
	}

	public void setFrequencyQuantity(PhysicalQuantity frequencyQuantity) {
		this.frequencyQuantity = frequencyQuantity;
	}

	@Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.period)
                .append(this.phase)
                .append(this.alignment)
                .append(this.institutionSpecified)
                .append(this.frequencyRepetitions)
                .append(this.frequencyQuantity)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((PeriodicIntervalTimeR2) obj);
        }
    }
    
	private boolean equals(PeriodicIntervalTimeR2 that) {
        return new EqualsBuilder()
                .append(this.period, that.period)
                .append(this.phase, that.phase)
                .append(this.alignment, that.alignment)
                .append(this.institutionSpecified, that.institutionSpecified)
                .append(this.frequencyRepetitions, that.frequencyRepetitions)
                .append(this.frequencyQuantity, that.frequencyQuantity)
                .isEquals();
    }
	
}
