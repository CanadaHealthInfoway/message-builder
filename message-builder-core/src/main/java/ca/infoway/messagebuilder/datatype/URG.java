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

package ca.infoway.messagebuilder.datatype;

import ca.infoway.messagebuilder.datatype.lang.UncertainRange;

/**
 * <p>Uncertain Range.
 * 
 * <p>This data type is used when a continuous range needs to be expressed. 
 *
 * <p>For URG(TS.DATE) This data type is used when an occurrence is tied to a specific date, 
 * but the actual date is not known, merely the range of dates within which the date falls. 
 * This differs from IVL(TS.DATE) in that it refers to a single occurrence rather than a period 
 * covering multiple days.
 * 
 * <p>For URG(PQ.x): This is used to express a single quantity whose specific value is not known, but 
 * whose upper and lower bounds are known. The URG data type already places implicit constraints on 
 * probability. Outside the range, probability is 0, within the range, probability is unknown. PQ.x 
 * implies any of the PQ.x data types in the specification (e.g. PQ.LAB, PQ.DISTANCE), not the PQ data type by itself.                             
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> any quantity(QTY)-based HL7 datatype
 * @param <V> the underlying quantity datatype 
 * @sharpen.ignore - datatype - translated manually 
 */
public interface URG<T extends QTY<V>, V> extends IVL<T, UncertainRange<V>> {
	
}
