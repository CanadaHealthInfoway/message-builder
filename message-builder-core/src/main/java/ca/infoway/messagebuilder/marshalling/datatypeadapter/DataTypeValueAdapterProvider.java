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

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.datatype.BareANY;


public class DataTypeValueAdapterProvider {
	
	private static final DataTypeAdapter NULL_DATA_TYPE_ADAPTER = new DataTypeAdapter() {
		public BareANY adapt(Class<? extends BareANY> toDataType, BareANY any) {
			return any;
		}
		public BareANY adapt(String toDataTypeName, BareANY any) {
			return any;
		}
		public boolean canAdapt(Class<? extends BareANY> fromDataType, String toDataTypeName) {
			return true;
		}
		public boolean canAdapt(String fromDataTypeName, Class<? extends BareANY> toDataType) {
			return true;
		}
	};
	
	private final List<DataTypeAdapter> adapters = new ArrayList<DataTypeAdapter>();
	
	public DataTypeValueAdapterProvider() {
		adapters.add(new TsToIvlAdapter()); 
		adapters.add(new IvlToTsAdapter());
		
		adapters.add(new CollectionToSetOfTnAdapter()); 
		
		adapters.add(new CollectionOfAnyToAnyAdapter());
		adapters.add(new AnyToSetOfAnyAdapter());
		adapters.add(new AnyToListOfAnyAdapter());
	}

	public DataTypeAdapter getAdapter(Class<? extends BareANY> fromDataType, String toDataTypeName) {
		DataTypeAdapter matchingAdapter = NULL_DATA_TYPE_ADAPTER;
		
		if (fromDataType!=null && toDataTypeName!=null) {
			for (DataTypeAdapter adapter : adapters) {
				if (adapter.canAdapt(fromDataType, toDataTypeName)) {
					matchingAdapter = adapter;
					break;
				}
			}
		}
		
		return matchingAdapter;
	}

	public DataTypeAdapter getAdapter(String fromDataTypeName, Class<? extends BareANY> toDataType) {
		DataTypeAdapter matchingAdapter = NULL_DATA_TYPE_ADAPTER;
		for (DataTypeAdapter adapter : adapters) {
			if (adapter.canAdapt(fromDataTypeName, toDataType)) {
				matchingAdapter = adapter;
				break;
			}
		}
		return matchingAdapter;
	}
	
}
