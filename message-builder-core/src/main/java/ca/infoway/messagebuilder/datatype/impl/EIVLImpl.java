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
 * Last modified: $LastChangedDate: 2013-05-03 19:44:36 -0400 (Fri, 03 May 2013) $
 * Revision:      $LastChangedRevision: 6815 $
 */

package ca.infoway.messagebuilder.datatype.impl;

import ca.infoway.messagebuilder.datatype.EIVL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>R2 datatype CE. Backed by a Code.
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class EIVLImpl<EventRelatedPeriodicIntervalTime> extends ANYImpl<EventRelatedPeriodicIntervalTime> implements EIVL<EventRelatedPeriodicIntervalTime> {
	/**
	 * <p>Constructs an empty EIVL.
	 */
	public EIVLImpl() {
		this((EventRelatedPeriodicIntervalTime) null);
	}

	/**
	 * <p>Constructs an EIVL with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public EIVLImpl(EventRelatedPeriodicIntervalTime defaultValue) {
		this(defaultValue, null, StandardDataType.EIVL_TS);
	}

	/**
	 * <p>Constructs an EIVL with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public EIVLImpl(NullFlavor nullFlavor) {
		this(null, nullFlavor, StandardDataType.EIVL_TS);
	}

	/**
	 * <p>Constructs an EIVL using the supplied parameters.
	 * 
	 * @param value an initial value
	 * @param nullFlavor a null flavor
	 * @param dataType an HL7 datatype
	 */
	public EIVLImpl(EventRelatedPeriodicIntervalTime value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(value, nullFlavor, dataType);
	}
	
}
