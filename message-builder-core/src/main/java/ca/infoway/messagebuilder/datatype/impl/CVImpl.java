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

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>HL7 datatype CV. Backed by a Code.
 * 
 * <p>Coded data, specifying only a code, code system, and optionally display name and original text. Used only as the 
 * type of properties of other	data types.
 * 
 * <p>CV is used when any reasonable use case will require only a single code value to be sent. Thus, it should not 
 * be used in circumstances where multiple alternative codes for a given value are desired. This type may be used 
 * with both the CNE (coded, non-extensible) and the CWE (coded, with extensibility) domain qualifiers.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <V> the underlying code type.
 * @sharpen.ignore - datatype - translated manually 
 */
public class CVImpl extends CEImpl implements CV {

	private static final long serialVersionUID = 6243037854254648829L;
	
	/**
	 * <p>Constructs an empty CV.
	 */
	public CVImpl() {
		this((Code) null);
	}

	/**
	 * <p>Constructs a CV with the given value.
	 * 
	 * @param defaultValue an initial value
	 */
	public CVImpl(Code defaultValue) {
		this(defaultValue, null, StandardDataType.CV);
	}

	/**
	 * <p>Constructs a CV with the given null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public CVImpl(NullFlavor nullFlavor) {
		this(null, nullFlavor, StandardDataType.CV);
	}

	/**
	 * <p>Constructs a CV using the supplied parameters.
	 * 
	 * @param value an initial value
	 * @param nullFlavor a null flavor
	 * @param dataType an HL7 datatype
	 */
	public CVImpl(Code value, NullFlavor nullFlavor, StandardDataType dataType) {
		super(value, nullFlavor, dataType);
	}
	
	
}
