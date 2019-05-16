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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.dependencyanalyzer;

import java.util.Set;

public interface Node<T> {

	public T getItem();
	public String getName();
	/**
	 * <p>Get a collection of the current item's dependencies.
	 *
	 * <p>For example, we say that one class depends upon another in cases of
	 * inheritance, interface implementation, parameter types, variable types, or
	 * thrown and caught exceptions. In short, all types referred to anywhere
	 * within the source of the measured class.
	 */
	public Set<T> getEfferentCouplings();

	/**
	 * <p>The number of other items that depend upon the current item.
	 */
	public Set<T> getAfferentCouplings();

	public int getLayer();
//	public boolean isAcyclic();
}
