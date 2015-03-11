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

import ca.infoway.messagebuilder.datatype.IVL_TS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype IVL. Backed by the java datatype DateInterval.
 * 
 * <p>This data type is used when a continuous range needs to be expressed.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class IVL_TSImpl extends QTYImpl<DateInterval> implements IVL_TS {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -4882987994046782038L;
	
	/**
	 * <p>Constructs an empty INT.
	 */
	public IVL_TSImpl() {
		this((DateInterval) null);
	}
	
	/**
	 * <p>Constructs an INT with the given initial value.
	 * 
	 * @param defaultValue an initial value
	 */
	public IVL_TSImpl(DateInterval defaultValue) {
		super(DateInterval.class, defaultValue, null, StandardDataType.IVL_TS);
	}

	/**
	 * <p>Constructs an INT with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public IVL_TSImpl(NullFlavor nullFlavor) {
		super(DateInterval.class, null, nullFlavor, StandardDataType.IVL_TS);
	}
	
}
