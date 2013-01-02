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

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>TEL Hl7 datatype implementation. This datatype is (via its superclass) backed by a TelecommunicationAddress.
 * 
 * <p>Represents CeRx's notion of a telecommunication address, such as a phone
 * number, fax, email or http address.
 *
 * <p>There are several parts to an tel address, but HL7 has dumped all the relevant 
 * information into a single text field. Urp.
 * 
 * <p>The first part is the URL scheme. This is something like tel: or http:. CeRx limits 
 * these based on the subclass of TEL (TEL.PHONEMAIL or TEL.URI).
 * 
 * <p>There are some number of uses for each address. CeRx limits this to three, which is
 * not enforced by this class. For the TEL.URI subclass, use is not permitted at all.
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-TEL
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class TELImpl extends URLImpl implements TEL {

	/**
	 * <p>Constructs an empty TEL.
	 */
	public TELImpl() {
		this((TelecommunicationAddress) null);
	}

	/**
	 * <p>Constructs a TEL based on a given TelecommunicationAddress.
	 * 
	 * @param defaultValue the initial value
	 */
	public TELImpl(TelecommunicationAddress defaultValue) {
		super(defaultValue, null, StandardDataType.TEL);
	}

	/**
	 * <p>Constructs a "null" TEL based on a given null flavor.
	 * 
	 * @param nullFlavor the null flavor to set on this TEL
	 */
	public TELImpl(NullFlavor nullFlavor) {
		super(null, nullFlavor, StandardDataType.TEL);
	}
	
}
