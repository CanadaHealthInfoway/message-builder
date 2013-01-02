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
 * Last modified: $LastChangedDate: 2012-01-10 20:35:55 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3319 $
 */

package ca.infoway.messagebuilder;


/**
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 */
public enum Hl7BaseVersion {
	
	// if adding interfaces or behaviour to this enum, please consider using enum pattern for translation purposes

	MR2009,
	MR2007,
	MR2007_V02R01,  // does this have a better name to use?
	CERX;
	
}
