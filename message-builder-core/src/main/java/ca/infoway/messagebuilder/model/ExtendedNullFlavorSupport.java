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
 * Last modified: $LastChangedDate: 2013-01-02 18:05:34 -0400 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.datatype.nullflavor.NullFlavorSupport;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

public interface ExtendedNullFlavorSupport extends NullFlavorSupport {

	public boolean hasNullFlavor(String propertyName);
	public NullFlavor getNullFlavor(String propertyName);
	public void setNullFlavor(String propertyName, NullFlavor nullFlavor);

	public boolean hasNullFlavorInList(String propertyName, int indexInList);
	public NullFlavor getNullFlavorInList(String propertyName, int indexInList);
	public boolean setNullFlavorInList(String propertyName, int indexInList, NullFlavor nullFlavor);
	
	public boolean hasNullFlavorInSet(String propertyName, Object valueInSet);
	public NullFlavor getNullFlavorInSet(String propertyName, Object valueInSet);
	public boolean setNullFlavorInSet(String propertyName, Object valueInSet, NullFlavor nullFlavor);

}
