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

package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.EN;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.EntityName;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Super class for HL7 name-based datatypes. Backed by a java datatype that must be an extension of EntityName.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying java entity name type
 * @sharpen.ignore - datatype - translated manually 
 */
public class ENImpl<V extends EntityName> extends ANYImpl<V> implements EN<V> {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -7224412497518261363L;

	/**
	 * <p>Constructs an empty EN.
	 */
	public ENImpl() {
		this((V) null);
	}

	/**
	 * <p>Constructs an EN with the given initial value.
	 * 
	 * @param defaultValue the initial value
	 */
	public ENImpl(V defaultValue) {
		this(EntityName.class, defaultValue, null, StandardDataType.EN);
	}

	/**
	 * <p>Constructs an EN with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public ENImpl(NullFlavor nullFlavor) {
		this(EntityName.class, null, nullFlavor, StandardDataType.EN);
	}
	
	/**
	 * <p>Constructs an EN given the supplied parameters.
	 *  
	 * @param rawType the underlying java datatype
	 * @param value an initial value (based on EntityName)
	 * @param nullFlavor a null flavor
	 * @param dataType a data type enum
	 */
	public ENImpl(Class<?> rawType, V value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(rawType, value, nullFlavor, dataType);
	}	
}
