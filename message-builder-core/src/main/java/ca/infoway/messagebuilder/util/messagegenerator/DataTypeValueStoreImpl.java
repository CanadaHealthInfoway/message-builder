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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.util.messagegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.resolver.CodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;

/**
 * 
 * This class is not thread safe. Recommend creating a value store per call to the sample message generator;
 *
 * @sharpen.ignore sample message generator is for MB Java only
 */
public class DataTypeValueStoreImpl implements DataTypeValueStore {
	
	private final Log log = LogFactory.getLog(DataTypeValueStoreImpl.class);

	protected CodeResolver codeResolver = new TrivialCodeResolver();

	private Map<StandardDataType, List<Object>> valueGenerators = new HashMap<StandardDataType, List<Object>>();
	private Map<StandardDataType, Integer> valueIndexes = new HashMap<StandardDataType, Integer>();
	protected Map<StandardDataType, StandardDataType> abstractMapping = new HashMap<StandardDataType, StandardDataType>();
	
	public DataTypeValueStoreImpl() {
	}
	
	/**
	 * Replaces the values stored for the supplied datatype. Resets index counter.
	 * 
	 * @param dataType
	 * @param values
	 */
	public void setValues(StandardDataType dataType, List<Object> values) {
		this.valueGenerators.put(dataType, values);
		this.valueIndexes.put(dataType, 0);
	}

	/**
	 * Adds a value to the data store for the supplied datatype. Resets index counter.
	 * 
	 * @param dataType
	 * @param value
	 */
	public void addValue(StandardDataType dataType, Object value) {
		if (!this.valueGenerators.containsKey(dataType)) {
			this.valueGenerators.put(dataType, new ArrayList<Object>());
		}
		this.valueGenerators.get(dataType).add(value);
		this.valueIndexes.put(dataType, 0);
	}

	/**
	 * Obtains the next value for the supplied datatype. Property type passed in to 
	 * enable handling of coded types.
	 */
	public Object getValueForDatatype(String dataType, Class<?> propertyType) {
		StandardDataType type = StandardDataType.getByTypeName(dataType);
		List<Object> values = this.valueGenerators.get(type);
		int index = this.valueIndexes.get(type);
		
		Object result = null;
		
		if (type != null && values != null) {
			if (index < values.size()) {
				this.valueIndexes.put(type, index + 1 >= values.size() ? 0 : index + 1);
				result = values.get(index);
				if (type.isCoded()) {
					result = handleCodedType(propertyType, type, result);
				}
			} else {
				this.log.error("Index out of bounds for data store: " + dataType + " index=" + index + " size=" + values.size());
			}
		} else {
			if (type == null) {
				this.log.error("Could not determine a StandardDataType from: " + dataType);
			} else {
				this.log.warn("No values stored for type: " + dataType);
			}
		}
		
		return result;
	}

	/**
	 * Special handling required for coded types, as they must be created as a specific return type matching their domain.
	 * 
	 * @param propertyType
	 * @param type
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Object handleCodedType(Class<?> propertyType, StandardDataType type, Object result) {
		// can't easily return a real code for the domain, so adjust the mock value to show the domain as well 
		String codeValue = result.toString() + " (" + propertyType.getSimpleName() + ")";
		return new TrivialCodeResolver().lookup((Class<Code>) propertyType, codeValue, CodeSystem.HEALTH_CANADA.getRoot());
	}
	
	/**
	 * For abstract types, checks to see what actual type is used for the stored value. 
	 */
	public StandardDataType getDatatypeUsedForAbstract(String dataType) {
		StandardDataType type = StandardDataType.getByTypeName(dataType);
		return this.abstractMapping.get(type);
	}

}
