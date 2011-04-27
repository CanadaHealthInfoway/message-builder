/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Data that is primarily intended for human interpretation or for further
 * machine processing outside the scope of HL7.
 * 
 * <p>This includes unformatted or formatted written language, multimedia data, or
 * structured information in as defined by a different standard (e.g.,
 * XML-signatures.) Instead of the data itself, an ED may contain only a
 * reference (see TEL.) Note that ST is a specialization of the ED where the
 * mediaType is fixed to text/plain.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying java datatype
 * @sharpen.ignore - datatype - translated manually 
 */
public class EDImpl<V> extends ANYImpl<V> implements ED<V> {

	private static final long serialVersionUID = -2285454412990019053L;

	/**
	 * <p>Constructs an empty ED.
	 */
	public EDImpl() {
		this((V) null);
	}
	
	/**
	 * <p>Constructs an ED with the supplied value.
	 * 
	 * @param defaultValue the initial value
	 */
	public EDImpl(V defaultValue) {
		this(null, defaultValue, null, StandardDataType.ED);
	}

	/**
	 * <p>Constructs an ED with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public EDImpl(NullFlavor nullFlavor) {
		this(null, null, nullFlavor, StandardDataType.ED);
	}

	/**
	 * <p>Constructs an ED using the supplied parameters.
	 * 
	 * @param rawType the underlying javav datatype
	 * @param value a java value
	 * @param nullFlavor a null flavor
	 * @param dataType the enum datatype
	 */
	public EDImpl(Class<?> rawType, V value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(rawType, value, nullFlavor, dataType);
	}
	
}
