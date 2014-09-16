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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.BareANY;
import ca.infoway.messagebuilder.datatype.COLLECTION;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TNImpl;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.xml.Hl7TypeName;

@SuppressWarnings("unchecked")
public class CollectionToSetOfTnAdapter implements DataTypeAdapter {

	public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		if (COLLECTION.class.isAssignableFrom(fromDataType)
		 && StandardDataType.SET.equals(StandardDataType.getByTypeName(toDataTypeName))
		 && containerOfTn(toDataTypeName)) {
			return true;
		}
		return false;
	}
	
	private boolean containerOfTn(String fromDataTypeName) {
		boolean containerOfTn = false;
		List<Hl7TypeName> parameters = Hl7TypeName.parse(fromDataTypeName).getParameters();
		
		if (parameters!=null && !parameters.isEmpty()) {
			for (Hl7TypeName parameter : parameters) {
				if (StandardDataType.TN.getRootType().equals(parameter.getRootName()) ) {
					containerOfTn = true;
				}
			}
		}
		return containerOfTn;
	}
	
	public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDateType) {
		return false;
	}
	
	public BareANY adapt(BareANY any) {
		Collection collection = ((COLLECTION) any).rawCollection();

		SETImpl adaptedSet = new SETImpl(TNImpl.class);
		
		if (any.hasNullFlavor()) {
			NullFlavor nullFlavor = any.getNullFlavor();
			adaptedSet.setNullFlavor(nullFlavor);	
		} else {
			adaptedSet.rawSet().addAll(toSetOfTrivialName(collection));
		}
		
		return (ANY) adaptedSet;

	}

	private Set toSetOfTrivialName(Collection collection) {
		Set set = new LinkedHashSet();
		for (Object element : collection) {
			set.add(new TrivialName(element.toString()));
		}
		return set;
	}

}
