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
 * <p>An enum for interval representations. Some apply only to periodic intervals.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public enum Representation {

	// if adding interfaces or behaviour to this enum, please consider using enum pattern for translation purposes

	HIGH, 
	LOW, 
	CENTRE, 
	WIDTH, 
	LOW_HIGH, 
	LOW_WIDTH, 
	LOW_CENTER, 
	WIDTH_HIGH, 
	CENTRE_WIDTH, 
	CENTRE_HIGH,
	SIMPLE,
	
	// These representations are used in Periodic Interval
	
	// TOOD: BCH: separate these into another enum
	PERIOD, 
	PHASE, 
	FREQUENCY,
	PERIOD_PHASE;
	
	public boolean hasLow() {
		return this == LOW || this == LOW_CENTER || this == LOW_WIDTH || this == LOW_HIGH;
	}
	
	public boolean hasHigh() {
		return this == HIGH || this == LOW_HIGH || this == WIDTH_HIGH || this == CENTRE_HIGH;
	}
	
	public boolean hasCentre() {
		return this == CENTRE || this == LOW_CENTER || this == CENTRE_HIGH || this == CENTRE_WIDTH;
	}
	
	public boolean hasWidth() {
		return this == WIDTH || this == CENTRE_WIDTH || this == LOW_WIDTH || this == WIDTH_HIGH;
	}
	
}
