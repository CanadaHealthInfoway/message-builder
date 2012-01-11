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

import java.util.Set;

/**
 * <p>HL7 datatype SET. Backed by a java Set.
 * 
 * <p>Used when multiple repetitions are allowed, order is irrelevant and duplicates are prohibited.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the HL7 datatype held by the SET 
 * @param <V> the underlying Java datatype held by the underlying Java Set
 */
public interface SET<T extends ANY<V>, V> extends COLLECTION<T> {

	/**
	 * <p>Returns the underlying Java Set containing values in the underlying Java datatype.
	 * 
	 * @return the underlying Java Set containing values in the underlying Java datatype
	 */
	Set<V> rawSet();
	
	<U extends V> Set<U> rawSet(Class<U> elementType);
	 
}
