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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2012-01-10 21:43:11 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3330 $
 */

package ca.infoway.messagebuilder.datatype.lang;

/**
 * <p>An interface for types that contain, or can access or compute, an identifier.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public interface Identifiable {
	
	/**
	 * <p>Returns the identifier.
	 * 
	 * @return the Identifier
	 */
	public Identifier getId();
}
