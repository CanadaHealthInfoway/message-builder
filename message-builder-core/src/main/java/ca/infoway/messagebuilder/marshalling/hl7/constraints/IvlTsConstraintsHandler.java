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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */
package ca.infoway.messagebuilder.marshalling.hl7.constraints;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.error.ErrorLogger;
import ca.infoway.messagebuilder.xml.ConstrainedDatatype;

public class IvlTsConstraintsHandler {

	private final ConstraintsHandler constraintsHandler = new ConstraintsHandler();

	public IvlTsConstraintsHandler() {
	}
	
	public void handleConstraints(ConstrainedDatatype constraints, DateInterval dateInterval, ErrorLogger logger) {
		if (dateInterval == null || dateInterval.getInterval() == null || constraints == null) {
			return;
		}
		
		Interval<Date> interval = dateInterval.getInterval();

		// only checking the following cardinality constraints:
		// low 1/0
		// high 1/0/0-1
		// value 1

		boolean hasLow = (interval.getLow() != null || interval.getLowNullFlavor() != null);
		boolean hasHigh = (interval.getHigh() != null || interval.getHighNullFlavor() != null);
		boolean hasSimpleValue = (interval.getValue() != null);  // a nullFlavor instead of a simpleValue would have been handled elsewhere 

		// these are just doing existency checks
		this.constraintsHandler.validateConstraint("low", hasLow ? "low" : null, constraints, logger);
		this.constraintsHandler.validateConstraint("high", hasHigh ? "high" : null, constraints, logger);
		this.constraintsHandler.validateConstraint("value", hasSimpleValue ? "value" : null, constraints, logger);
	}

}
