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
import ca.infoway.messagebuilder.datatype.TN;
import ca.infoway.messagebuilder.datatype.lang.TrivialName;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;

/**
 * <p>Hl7 datatype TN backed by the javav datatype TrivialName.
 * 
 * <p>A string used for simple names for things (e.g. drug names) and places (e.g. "Canada Health Infoway")
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually 
 */
public class TNImpl extends ENImpl<TrivialName> implements TN {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = -3857569397613505550L;

	/**
	 * <p>Constructs an empty TN.
	 */
	public TNImpl() {
		this((TrivialName) null);
	}

	/**
	 * <p>Constructs a TN using the given value.
	 * 
	 * @param defaultValue the initial value.
	 */
	public TNImpl(TrivialName defaultValue) {
		super(TrivialName.class, defaultValue, null, StandardDataType.TN);
	}

	/**
	 * <p>Constructs a TN having the supplied null flavor. 
	 * 
	 * @param nullFlavor a null flavor
	 */
	public TNImpl(NullFlavor nullFlavor) {
		super(TrivialName.class, null, nullFlavor, StandardDataType.TN);
	}
}
