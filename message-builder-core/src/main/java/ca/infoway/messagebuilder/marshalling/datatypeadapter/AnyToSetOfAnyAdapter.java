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

import java.util.Set;

import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;

/**
 * @sharpen.ignore - due to generics issues
 */
@SuppressWarnings("unchecked")
public class AnyToSetOfAnyAdapter implements DataTypeAdapter {

	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDataType) {
		return !StandardDataType.isSetOrList(fromDataTypeName)
		    && SET.class.isAssignableFrom(toDataType);
	}

	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		return false;
	}

	public BareANY adapt(Class<? extends BareANY> toDataType, BareANY any) {
		SETImpl set = new SETImpl(any.getClass());
		((Set) set.getValue()).add(any);
		return (BareANY) set;
	}

	public BareANY adapt(String toDataTypeName, BareANY any) {
		return any;
	}

}
