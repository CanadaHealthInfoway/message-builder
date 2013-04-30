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

import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.QTY;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype IVL. Backed by the java datatype Interval.
 * 
 * <p>This data type is used when a continuous range needs to be expressed.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the HL7 datatype of the interval
 * @param <V> the Interval java type, or a subclass
 * @sharpen.ignore - datatype - translated manually 
 */
public class IVLImpl<T extends QTY<?>, V extends Interval<?>> extends ANYImpl<V> implements IVL<T, V> {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -5984093680112937602L;
	
	/**
	 * <p>Constructs an empty IVL.
	 */
	public IVLImpl() {
		this(null);
	}

	/**
	 * <p>Constructs an IVL with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public IVLImpl(V defaultValue) {
		this(Interval.class, defaultValue, null, StandardDataType.IVL);
	}

	/**
	 * <p>Constructs an IVL using the supplied parameters.
	 * 
	 * @param rawType the underlying java type
	 * @param value an initial value
	 * @param nullFlavor a null flavor
	 * @param dataType the HL7 datatype
	 */
	public IVLImpl(Class<?> rawType, V value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(rawType, value, nullFlavor, dataType);
	}

}
