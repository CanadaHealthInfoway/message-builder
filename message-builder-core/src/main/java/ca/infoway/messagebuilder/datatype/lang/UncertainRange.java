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

import ca.infoway.messagebuilder.datatype.lang.util.Representation;

/**
 * <p>Uncertain Range.
 * 
 * <p>This java data type is used when a continuous range needs to be expressed.
 *  
 * <p>Recommended to use the UncertainRangeFactory class for object creation
 *
 * <p>For URG&lt;TS.DATE&gt; This data type is used when an occurrence is tied to a specific date, 
 * but the actual date is not known, merely the range of dates within which the date falls. 
 * This differs from IVL&lt;TS.DATE&gt; in that it refers to a single occurrence rather than a period 
 * covering multiple days.
 * 
 * <p>For URG&lt;PQ.x&gt;: This is used to express a single quantity whose specific value is not known, but 
 * whose upper and lower bounds are known. The URG data type already places implicit constraints on 
 * probability. Outside the range, probability is 0, within the range, probability is unknown. PQ.x 
 * implies any of the PQ.x data types in the specification (e.g. PQ.LAB, PQ.DISTANCE), not the PQ data type by itself.                             
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying urg's java datatype (eg. Date)
 * 
 * @sharpen.ignore - datatype - translated manually
 */
public class UncertainRange<T> extends Interval<T> {

	/**
	 * <p>Constructs an uncertain range.
	 * 
	 * <p>Recommended to use the UncertainRangeFactory class for object creation
	 * 
	 * @param low lower bound
	 * @param high upper bound
	 * @param centre middle bound
	 * @param width size of width
	 * @param representation the type of range
	 */
	public UncertainRange(T low, T high, T centre, Diff<T> width, Representation representation) {
		super(low, high, centre, width, representation);
	}

}
