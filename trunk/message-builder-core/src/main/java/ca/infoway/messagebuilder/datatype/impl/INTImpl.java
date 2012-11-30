/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>HL7 datatype INT. Backed by an Integer.
 * 
 * <p>Covers:
 * 
 * <p>INT.POS: This is used to convey an integer number that is greater than or equal to "1".
 * 
 * <p>INT.NONNEG: This is used to convey an integer number that is greater than or equal to "0".
 * 	
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class INTImpl extends QTYImpl<Integer> implements INT {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -4882987994046782038L;
	
	/**
	 * <p>Constructs an empty INT.
	 */
	public INTImpl() {
		this((Integer) null);
	}
	
	/**
	 * <p>Constructs an INT with the given initial value.
	 * 
	 * @param defaultValue an initial value
	 */
	public INTImpl(Integer defaultValue) {
		super(Integer.class, defaultValue, null, StandardDataType.INT);
	}

	/**
	 * <p>Constructs an INT with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public INTImpl(NullFlavor nullFlavor) {
		super(Integer.class, null, nullFlavor, StandardDataType.INT);
	}
	
}
