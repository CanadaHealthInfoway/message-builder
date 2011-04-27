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

import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 PN datatype. backed by the Java datatype PersonName.
 * 
 * <p>Covers:
 * 
 * <p>PN.BASIC: Used to express person names for general identification and communication purposes.
 * 
 * <p>PN.SIMPLE: Used to express person names without name parts.
 * 
 * <p>PN.FULL: Used to express person names within a registry where full qualification is needed. 
 * 
 * <p>PN.SEARCH: This type is used to convey name information for searching purposes. All matches are considered to be "starts with" for each specified property. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class PNImpl extends ENImpl<PersonName> implements PN {

	private static final long serialVersionUID = 3129178545240545639L;

	/**
	 * <p>Constructs an empty PN.
	 */
	public PNImpl() {
		this((PersonName) null);
	}

	/**
	 * <p>Constructs a PN with the given value.
	 * 
	 * @param defaultValue an intial value
	 */
	public PNImpl(PersonName defaultValue) {
		super(PersonName.class, defaultValue, null, StandardDataType.PN);
	}

	/**
	 * <p>Constructs a PN with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public PNImpl(NullFlavor nullFlavor) {
		super(PersonName.class, null, nullFlavor, StandardDataType.PN);
	}
	
}
