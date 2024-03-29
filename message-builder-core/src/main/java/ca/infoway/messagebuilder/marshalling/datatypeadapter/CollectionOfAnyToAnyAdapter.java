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

package ca.infoway.messagebuilder.marshalling.datatypeadapter;

import java.util.Collection;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.COLLECTION;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;

/**
 * @sharpen.ignore - due to generics issues
 */
public class CollectionOfAnyToAnyAdapter implements DataTypeAdapter {

	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		if (COLLECTION.class.isAssignableFrom(fromDataType) 
		  && !StandardDataType.isSetOrList(toDataTypeName)) {
			return true;
		}
		return false;
	}
	
	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDataType) {
		return false;
	}

	public BareANY adapt(Class<? extends BareANY> toDataType, BareANY any) {
		return any;
	}

	public BareANY adapt(String toDataTypeName, BareANY any) {
		Collection collection = ((COLLECTION<?>) any).getValue();
		
		BareANY element = null;
		if (collection!=null && !collection.isEmpty()) {
			element = (BareANY) collection.iterator().next();
		} else {
			element = new ANYImpl();
		}
		
		return (BareANY) element; 
	}


}
