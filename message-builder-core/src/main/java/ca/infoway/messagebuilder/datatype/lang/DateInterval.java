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
 * Last modified: $LastChangedDate: 2014-02-18 12:27:45 -0500 (Tue, 18 Feb 2014) $
 * Revision:      $LastChangedRevision: 8402 $
 */

package ca.infoway.messagebuilder.datatype.lang;

import java.util.Date;

public class DateInterval extends MbDate {

	private Interval<Date> interval;

	public DateInterval() {
	}
	
	public DateInterval(Interval<Date> actualInterval) {
		this.interval = actualInterval;
	}
	
	public Interval<Date> getInterval() {
		return this.interval;
	}

	public void setInterval(Interval<Date> interval) {
		this.interval = interval;
	}
	
}
