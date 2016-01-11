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

package ca.infoway.messagebuilder.marshalling;

import java.util.List;

import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.Realm;

/**
 * <p>A part bridge maps between a Message Part and the object that represents it.
 * In the most simple case, one part maps to one class, but in some cases (such
 * as with inlining) the part really maps to a subset of properties on the class in
 * which it was inlined.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
interface PartBridge {
	public String getTypeName();
	public List<BaseRelationshipBridge> getRelationshipBridges();
	public boolean isEmpty();
	public boolean isNullPart();
	/**
	 * <p>Indicates whether or not the part has been "collapsed" or "inlined" into 
	 * another part type.  
	 * 
	 * @return true if the part maps to a number of bean properties in a message bean, 
	 * rather than a bean, itself.  Otherwise, it returns false.
	 */
	public boolean isCollapsed();
	public String getPropertyName();

	/**
	 * <p>Indicates whether or not the part has a null flavor.
	 * 
	 * @return whether the part has a null flavor set on it
	 */
	public boolean hasNullFlavor();
	/**
	 * <p>Returns the part's null flavor, if it has one, or null.
	 * 
	 * @return the null flavor
	 */
	public NullFlavor getNullFlavor();
	
	public List<Realm> getRealmCode();
}
