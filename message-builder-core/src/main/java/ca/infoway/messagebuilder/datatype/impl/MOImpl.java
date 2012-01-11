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

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Hl7 Datatype MO (MO.CAD). Backed by java datatype Money.
 * 
 * <p>Used to convery monetary values in Canadian currency.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class MOImpl extends QTYImpl<Money> implements MO {

	private static final long serialVersionUID = -2175517396842067356L;

	/**
	 * <p>Constructs an empty MO.
	 */
	public MOImpl() {
		this((Money) null);
	}

	/**
	 * <p>Constructs an MO with the supplied value.
	 * 
	 * @param defaultValue the initial value
	 */
	public MOImpl(Money defaultValue) {
		super(Money.class, defaultValue, null, StandardDataType.MO);
	}

	/**
	 * <p>Constructs an MO with the supplied null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public MOImpl(NullFlavor nullFlavor) {
		super(Money.class, null, nullFlavor, StandardDataType.MO);
	}
	
}
