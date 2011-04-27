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

package ca.infoway.messagebuilder.domainvalue.payload;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum QuantityRequestLimit.
 */
public class QuantityRequestLimit extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.QueryRequestLimit {
	
	private static final long serialVersionUID = 669843685953278565L;

	public static final QuantityRequestLimit RECORDS = new QuantityRequestLimit("RECORDS", "RD");
	
	private final String codeValue;

	private QuantityRequestLimit(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return "2.16.840.1.113883.5.1112";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}
}
