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

import ca.infoway.messagebuilder.datatype.SXCM_R2;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor;

/**
 * <p>Set Component (SXCM) R2 datatype.
 *  
 * @sharpen.ignore - datatype - translated manually 
 */
public class SXCM_R2Impl<T> extends ANYImpl<T> implements SXCM_R2<T> {
	
	/**
	 * <p>Constructs an empty SXCM.
	 */
	public SXCM_R2Impl() {
		this((T) null);
	}

	/**
	 * <p>Constructs an SXCM using the supplied value.
	 * 
	 * @param defaultValue the initial value
	 */
	public SXCM_R2Impl(T defaultValue) {
		super(defaultValue == null ? null : defaultValue.getClass(), defaultValue, null, StandardDataType.SXCM);
	}

	/**
	 * <p>Constructs an SXCM with the supplied null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public SXCM_R2Impl(NullFlavor nullFlavor) {
		super(null, null, nullFlavor, StandardDataType.SXCM);
	}
	
}
