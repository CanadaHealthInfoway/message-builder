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

import ca.infoway.messagebuilder.datatype.lang.GeneralTimingSpecification;

/**
 * <p>The Hl7 Datatype for GTS (GTS.BOUNDEDPIVL). Backed by the javav datatype GeneralTimingSpecification.
 * 
 * <p>This data type is used to convey two pieces of information: The overall time-period 
 * when something occurred (or is to occur), as well as how often it should/did occur 
 * within that time-period
 *   
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @sharpen.ignore - datatype - translated manually 
 */
public interface GTS extends ANY<GeneralTimingSpecification> {

}
