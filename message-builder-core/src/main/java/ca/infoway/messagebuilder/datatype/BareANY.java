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

import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;

/**
 * @sharpen.ignore - datatype - translated manually 
 */
public interface BareANY extends NullFlavorSupport {
	public Object getBareValue();
	
	/**
	 * <p>Represents the fact that every data value implicitly carries information about its own data type. 
	 * Thus, given a data value one can inquire about its data type.
	 * 
	 * @return the underlying enum datatype
	 */
	public StandardDataType getDataType();

	/**
	 * <p>Sets this ANY's datatype.
	 * 
	 * @param dataType an hl7 datatype
	 */
	public void setDataType(StandardDataType dataType);
}
