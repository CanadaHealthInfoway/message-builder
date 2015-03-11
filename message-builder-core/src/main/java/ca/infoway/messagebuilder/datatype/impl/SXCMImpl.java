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

import ca.infoway.messagebuilder.datatype.SXCM;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.SetComponent;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Set Component (SXCM) HL7 datatype. Backed by the java datatype SetComponent. 
 * 
 * <p>http://www.hl7.org/v3ballot/html/infrastructure/itsxml/datatypes-its-xml.htm#dtimpl-SXCM
 * 
 * <p>Definition: An ITS-defined generic type extension for the base data type of a
 * set, representing a component of a general set over a discrete or continuous
 * value domain. Its use is mainly for continuous value domains. Discrete
 * (enumerable) set components are the individual elements of the base data
 * type.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @param <T> the underlying java datatype
 * @sharpen.ignore - datatype - translated manually 
 */
public class SXCMImpl<T> extends ANYImpl<SetComponent<T>> implements SXCM<T> {
	
	/**
	 * <p>Constructs an empty SXCM.
	 */
	@SuppressWarnings("unchecked")
	public SXCMImpl() {
		this((SetComponent) null);
	}

	/**
	 * <p>Constructs an SXCM using the supplied value.
	 * 
	 * @param defaultValue the initial value
	 */
	public SXCMImpl(SetComponent<T> defaultValue) {
		super(SetComponent.class, defaultValue, null, StandardDataType.SXCM);
	}

	/**
	 * <p>Constructs an SXCM with the supplied null flavor.
	 * 
	 * @param nullFlavor a null flavor
	 */
	public SXCMImpl(NullFlavor nullFlavor) {
		super(SetComponent.class, null, nullFlavor, StandardDataType.SXCM);
	}
	
}
