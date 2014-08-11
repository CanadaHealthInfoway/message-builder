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

import ca.infoway.messagebuilder.datatype.PIVLR2;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PeriodicIntervalTimeR2;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>R2 Periodic Interval of Time (PIVL) specializes SXCM. Backed by java datatype PeriodicIntervalTimeR2.
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-PIVL
 * 
 * <p>Definition: An interval of time that recurs periodically. Periodic intervals
 * have two properties, phase and period. The phase specifies the "interval
 * prototype" that is repeated every period.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class PIVLR2Impl extends ANYImpl<PeriodicIntervalTimeR2> implements PIVLR2 {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 159190145107996467L;

	/**
	 * <p>Constructs an empty PIVL.
	 */
	public PIVLR2Impl() {
		this((PeriodicIntervalTimeR2) null);
	}

	/**
	 * <p>Constructs a PIVL with the supplied value.
	 * 
	 * @param defaultValue initial value
	 */
	public PIVLR2Impl(PeriodicIntervalTimeR2 defaultValue) {
		super(PeriodicIntervalTimeR2.class, defaultValue, null, StandardDataType.PIVL_TS);
	}

	/**
	 * <p>Constructs a PIVL with the supplied null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public PIVLR2Impl(NullFlavor nullFlavor) {
		super(PeriodicIntervalTimeR2.class, null, nullFlavor, StandardDataType.PIVL_TS);
	}
	
}
