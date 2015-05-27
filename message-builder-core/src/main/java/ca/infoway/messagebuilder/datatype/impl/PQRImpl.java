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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.PQR;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>R2 datatype PQR. Backed by a Code.
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class PQRImpl<T extends Code> extends ANYImpl<CodedTypeR2<T>> implements PQR<T> {
	/**
	 * <p>Constructs an empty CV.
	 */
	public PQRImpl() {
		this((CodedTypeR2<T>) null);
	}

	/**
	 * <p>Constructs a CV with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public PQRImpl(CodedTypeR2<T> defaultValue) {
		this(defaultValue, null, StandardDataType.PQR);
	}

	/**
	 * <p>Constructs a CV with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public PQRImpl(NullFlavor nullFlavor) {
		this(null, nullFlavor, StandardDataType.PQR);
	}

	/**
	 * <p>Constructs a CV using the supplied parameters.
	 * 
	 * @param value an initial value
	 * @param nullFlavor a null flavor
	 * @param dataType an HL7 datatype
	 */
	public PQRImpl(CodedTypeR2<T> value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(value, nullFlavor, dataType);
	}
	
}
