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

import ca.infoway.messagebuilder.datatype.CR;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CodeRole;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>HL7 R2 datatype CR. Backed by a CodeRole.
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class CRImpl extends ANYImpl<CodeRole> implements CR {

	/**
	 * <p>Constructs an empty CR.
	 */
	public CRImpl() {
		this((CodeRole) null);
	}

	/**
	 * <p>Constructs a CR with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public CRImpl(CodeRole defaultValue) {
		super(CodeRole.class, defaultValue, null, StandardDataType.CR);
	}

	/**
	 * <p>Constructs an BL with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public CRImpl(NullFlavor nullFlavor) {
		super(CodeRole.class, null, nullFlavor, StandardDataType.CR);
	}

}
