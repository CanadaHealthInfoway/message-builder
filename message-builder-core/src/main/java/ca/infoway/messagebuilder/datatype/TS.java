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

package ca.infoway.messagebuilder.datatype;

import java.util.Date;

/**
 * <p>HL7 datatype TS backed by a java Date.
 * 
 * <p>A quantity specifying a point on the axis of natural time. A point in time is
 * most often represented as a calendar expression.
 * 
 * <p>Semantically, however, time is independent from calendars and best described
 * by its relationship to elapsed time (measured as a physical quantity in the
 * dimension of time). A TS plus an elapsed time yields another TS. Inversely, a
 * TS minus another TS yields an elapsed time.
 * 
 * <p>As nobody knows when time began, a TS is conceptualized as the amount of time
 * that has elapsed from some arbitrary zero-point, called an epoch. Because
 * there is no absolute zero-point on the time axis; natural time is a
 * difference-scale quantity, where only differences are defined but no ratios.
 * (For example, no TS is - absolutely speaking - "twice as late" as another
 * TS.)
 * 
 * <p>Given some arbitrary zero-point, one can express any point in time as an
 * elapsed time measured from that offset. Such an arbitrary zero-point is
 * called an epoch. This epoch-offset form is used as a semantic representation
 * here, without implying that any system would have to implement TS in that
 * way. Systems that do not need to compute distances between TSs will not need
 * any other representation than a calendar expression literal.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public interface TS extends QTY<Date>, SetOperatorType {
}
