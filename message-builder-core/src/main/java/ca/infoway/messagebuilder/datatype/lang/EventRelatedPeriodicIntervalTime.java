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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import ca.infoway.messagebuilder.domainvalue.TimingEvent;

/**
 * <p>EIVL_TS
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class EventRelatedPeriodicIntervalTime implements Serializable {

	private static final long serialVersionUID = -7334434139857699836L;
	
	private Interval<PhysicalQuantity> offset;
	private TimingEvent event;

	public EventRelatedPeriodicIntervalTime() {
	}
	
	public EventRelatedPeriodicIntervalTime(Interval<PhysicalQuantity> offset, TimingEvent event) {
		this.offset = offset;
		this.event = event;
	}
	
	public Interval<PhysicalQuantity> getOffset() {
		return offset;
	}

	public void setOffset(Interval<PhysicalQuantity> offset) {
		this.offset = offset;
	}

	public TimingEvent getEvent() {
		return event;
	}

	public void setEvent(TimingEvent event) {
		this.event = event;
	}

	@Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.offset)
                .append(this.event)
                .toHashCode();
    }

	public boolean isEmpty() {
		return this.event == null && this.offset == null;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.getClass() != getClass()) {
            return false;
        } else {
            return equals((EventRelatedPeriodicIntervalTime) obj);
        }
    }
    
	private boolean equals(EventRelatedPeriodicIntervalTime that) {
        return new EqualsBuilder()
                .append(this.offset, that.offset)
                .append(this.event, that.event)
                .isEquals();
    }
	
}
