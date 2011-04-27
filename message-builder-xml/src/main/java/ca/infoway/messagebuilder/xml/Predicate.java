/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.xml;

/**
 * <p>A generic interface for determining whether or not a condition applies.  
 * This interface is typically used while iterating over a number of items in a 
 * collection, to choose one particular option.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * @param <T> - the type of item to analyze
 */
public interface Predicate<T> {
	/**
	 * <p>Apply the predicate criteria.
	 * 
	 * @param t - the item to analyze
	 * @return true if the predicate matches; false otherwise
	 */
	boolean apply(T t);
}
