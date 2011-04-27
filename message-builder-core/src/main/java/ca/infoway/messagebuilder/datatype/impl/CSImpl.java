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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Hl7 datatype CS. backed by a Code.
 * 
 * <p>Coded data in its simplest form, where only the code is not predetermined. The code system and code system version 
 * are fixed by the context in which the CS value occurs. CS is used for coded attributes that have a 
 * single HL7-defined value set.
 *
 * <p>CS can only be used in either of the following cases:
 * 
 * <p>- for a coded attribute which has a single HL7-defined code system, and where code additions to that value set 
 *   require formal HL7 action (such as harmonization.) Such coded attributes must have type CS.
 *   
 * <p>- for a property in this specification that is assigned to a single code system defined either in this 
 *   specification or defined outside HL7 by a body that has authority over the concept and the maintenance 
 *   of that code system.
 * 
 * <p>For example, since ED subscribes to the MIME design, it trusts IETF to manage the media type. This includes 
 * that this specification subscribes to the extension mechanism built into the 
 * MIME media type code (e.g., "application/x-myapp").
 * 
 * <p>For CS values, the designation of the domain qualifier will always be CNE (coded, non-extensible) 
 * and the context will determine which HL7 values to use.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code.
 * @sharpen.ignore - datatype - translated manually 
 */
public class CSImpl extends CVImpl implements CS {

	private static final long serialVersionUID = 1131698042396253284L;

	/**
	 * <p>Constructs an empty CS.
	 */
	public CSImpl() {
		this((Code) null);
	}

	/**
	 * <p>Constructs a CS using the supplied value.
	 * 
	 * @param defaultValue an initial value
	 */
	public CSImpl(Code defaultValue) {
		super(defaultValue, null, StandardDataType.CS);
	}

	/**
	 * <p>Constructs a CS with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public CSImpl(NullFlavor nullFlavor) {
		super(null, nullFlavor, StandardDataType.CS);
	}
	
}
