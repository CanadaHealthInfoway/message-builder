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

package ca.infoway.messagebuilder.datatype.lang.util;

/**
 * <p>This class wraps a standard Date and provides for a datePattern to be supplied.
 * 
 * <p>The supplied date pattern will be used when formatting the date object as xml, 
 * and allows for dates to format the same way going out as coming in or to have a
 * specified format as desired when writing a response. 
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class DateWithPattern extends java.util.Date {

	private static final long serialVersionUID = 8208330288380914940L;

	private final String datePattern;

	/**
	 * <p>Instantiates a new date.
	 *
	 * @param javaDate the java date
	 * @param datePattern the date pattern
	 */
	public DateWithPattern(java.util.Date javaDate, String datePattern) {
		super(javaDate.getTime());
		this.datePattern = datePattern;
	}
	
	/**
	 * <p>Gets the date pattern.
	 *
	 * @return the date pattern
	 */
	public String getDatePattern() {
		return datePattern;
	}

}
