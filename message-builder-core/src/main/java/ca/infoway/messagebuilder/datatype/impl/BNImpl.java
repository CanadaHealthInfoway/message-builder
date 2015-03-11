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
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.BN;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype BN. Backed by a Boolean.
 * 
 * <p>BL stands for the values of two-valued logic.
 * 
 * <p>A BN value can be either true or false, and may not be NULL.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class BNImpl extends ANYImpl<Boolean> implements BN {

	/**
	 * <p>Constructs an empty BL.
	 */
	public BNImpl() {
		this((Boolean) null);
	}

	/**
	 * <p>Constructs a BL with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public BNImpl(Boolean defaultValue) {
		super(Boolean.class, defaultValue, null, StandardDataType.BN);
	}

	/**
	 * <p>Constructs an BL with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public BNImpl(NullFlavor nullFlavor) {
		super(Boolean.class, null, nullFlavor, StandardDataType.BN);
	}

}
