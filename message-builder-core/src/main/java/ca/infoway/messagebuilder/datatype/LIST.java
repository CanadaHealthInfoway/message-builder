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

import java.util.List;

/**
 * <p>HL7 datatype LIST. Backed by a java List.
 * 
 * <p>Used when multiple repetitions are allowed and order matters.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the HL7 datatype held by the LIST 
 * @param <V> the underlying Java datatype held by the underlying Java List
 * @sharpen.ignore - datatype - translated manually 
 */
public interface LIST<T extends ANY<? extends V>, V> extends COLLECTION<T>  {
	
	/**
	 * <p>Returns the underlying Java List containing values in the underlying Java datatype.
	 * 
	 * @return the underlying Java List containing values in the underlying Java datatype
	 */
	List<V> rawList();
	
	<U extends V> List<U> rawList(Class<U> elementType);
}
