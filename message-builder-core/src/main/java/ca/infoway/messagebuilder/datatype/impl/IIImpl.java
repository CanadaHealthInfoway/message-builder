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

import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype for instance identifier. Backed by the java datatype Identifier.
 * 
 * <p>An identifier that uniquely identifies a thing or object. Examples are object 
 * identifier for HL7 RIM objects, medical record number, order id, service catalog 
 * item id, Vehicle Identification Number (VIN), etc. Instance identifiers are 
 * defined based on ISO object identifiers. 
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class IIImpl extends ANYImpl<Identifier> implements II {

	private static final long serialVersionUID = -2292476001838737646L;

	/**
	 * <p>Constructs an empty Identifier.
	 */
	public IIImpl() {
		this((Identifier) null);
	}

	/**
	 * <p>Constructs an Identifier using the supplied value.
	 * 
	 * @param defaultValue the initial value
	 */
	public IIImpl(Identifier defaultValue) {
		super(Identifier.class, defaultValue, null, StandardDataType.II);
	}

	/**
	 * <p>Constructs an Identifier with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public IIImpl(NullFlavor nullFlavor) {
		super(Identifier.class, null, nullFlavor, StandardDataType.II);
	}
	
}
