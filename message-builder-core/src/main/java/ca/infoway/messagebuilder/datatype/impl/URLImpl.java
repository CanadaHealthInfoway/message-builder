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

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.URL;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Uniform resource Locator. Bound to an underlying TelecommunicationAddress.
 *
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore - datatype - translated manually 
 */
public class URLImpl extends ANYImpl<TelecommunicationAddress> implements URL {

	/**
	 * <p>Constructs an empty URL.
	 */
	public URLImpl() {
		this((TelecommunicationAddress) null);
	}

	/**
	 * <p>Constructs a URL with the goven value.
	 * 
	 * @param defaultValue the initial URL value
	 */
	public URLImpl(TelecommunicationAddress defaultValue) {
		this(defaultValue, null, StandardDataType.URL);
	}

	/**
	 * <p>Constructs a URL with a null flavor.
	 * 
	 * @param nullFlavor the null flavor for the url
	 */
	public URLImpl(NullFlavor nullFlavor) {
		this(null, nullFlavor, StandardDataType.URL);
	}

	/**
	 * <p>Constructs a URL with both a telecom address value and a null flavor.
	 * 
	 * @param defaultValue initial value for the telecom address
	 * @param nullFlavor initial null flavor for the URL
	 * @param dataType the datatype enum representing this telecom address 
	 */
	public URLImpl(TelecommunicationAddress defaultValue, NullFlavor nullFlavor, StandardDataType dataType) {
		super(TelecommunicationAddress.class, defaultValue, nullFlavor, dataType);
	}
	
}
