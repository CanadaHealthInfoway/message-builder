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
package ca.infoway.messagebuilder.datatype.lang.util;

import ca.infoway.messagebuilder.lang.EnumPattern;

public class CalendarCycle extends EnumPattern {
	
	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = 2463751994500229084L;
	
	public static final CalendarCycle YEAR = new CalendarCycle("YEAR", "Y");
	public static final CalendarCycle YEAR_2 = new CalendarCycle("YEAR_2", "CY");
	public static final CalendarCycle MONTH_OF_THE_YEAR = new CalendarCycle("MONTH_OF_THE_YEAR", "M");
	public static final CalendarCycle MONTH_OF_THE_YEAR_2 = new CalendarCycle("MONTH_OF_THE_YEAR_2", "MY");
	public static final CalendarCycle MONTH_CONTINUOUS = new CalendarCycle("MONTH_CONTINUOUS", "CM");
	public static final CalendarCycle WEEK_CONTINUOUS = new CalendarCycle("WEEK_CONTINUOUS", "W");
	public static final CalendarCycle WEEK_CONTINUOUS_2 = new CalendarCycle("WEEK_CONTINUOUS_2", "CW");
	public static final CalendarCycle WEEK_OF_THE_YEAR = new CalendarCycle("WEEK_OF_THE_YEAR", "WY");
	public static final CalendarCycle DAY_OF_THE_MONTH = new CalendarCycle("DAY_OF_THE_MONTH", "D");
	public static final CalendarCycle DAY_OF_THE_MONTH_2 = new CalendarCycle("DAY_OF_THE_MONTH_2", "DM");
	public static final CalendarCycle DAY_CONTINUOUS = new CalendarCycle("DAY_CONTINUOUS", "CD");
	public static final CalendarCycle DAY_OF_THE_YEAR = new CalendarCycle("DAY_OF_THE_YEAR", "DY");
	public static final CalendarCycle DAY_OF_THE_WEEK = new CalendarCycle("DAY_OF_THE_WEEK", "J");
	public static final CalendarCycle DAY_OF_THE_WEEK_2 = new CalendarCycle("DAY_OF_THE_WEEK_2", "DW");
	public static final CalendarCycle HOUR_OF_THE_DAY = new CalendarCycle("HOUR_OF_THE_DAY", "H");
	public static final CalendarCycle HOUR_OF_THE_DAY_2 = new CalendarCycle("HOUR_OF_THE_DAY_2", "HD");
	public static final CalendarCycle HOUR_CONTINUOUS = new CalendarCycle("HOUR_CONTINUOUS", "CH");
	public static final CalendarCycle MINUTE_OF_THE_HOUR = new CalendarCycle("MINUTE_OF_THE_HOUR", "N");
	public static final CalendarCycle MINUTE_OF_THE_HOUR_2 = new CalendarCycle("MINUTE_OF_THE_HOUR_2", "NH");
	public static final CalendarCycle MINUTE_CONTINUOUS = new CalendarCycle("MINUTE_CONTINUOUS", "CN");
	public static final CalendarCycle SECOND_OF_THE_MINUTE = new CalendarCycle("SECOND_OF_THE_MINUTE", "S");
	public static final CalendarCycle SECOND_OF_THE_MINUTE_2 = new CalendarCycle("SECOND_OF_THE_MINUTE_2", "SN");
	public static final CalendarCycle SECOND_CONTINUOUS = new CalendarCycle("SECOND_CONTINUOUS", "CS");
	
	private final String calendarCycleCode;

	private CalendarCycle(String name, String calendarCycleCode) {
		super(name);
		this.calendarCycleCode = calendarCycleCode;
	}

	public String getCalendarCycleCode() {
		return this.calendarCycleCode;
	}

}
