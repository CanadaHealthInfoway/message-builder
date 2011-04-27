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

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ObservationQueryMatchType;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ProbabilityMatchCode. An observation related to a query response. 
 * Example: The degree of match or match weight returned by a matching algorithm in a response to a query.
 */
public class ProbabilityMatchCode extends EnumPattern implements ObservationQueryMatchType, Describable {
	
	private static final long serialVersionUID = -4412180444594616563L;
	
	public static final ProbabilityMatchCode PATTERN_MATCH = new ProbabilityMatchCode("PATTERN_MATCH", "PTNM"); 
	public static final ProbabilityMatchCode PHONETIC_MATCH = new ProbabilityMatchCode("PHONETIC_MATCH", "PHCM");

	private final String codeValue;

	private ProbabilityMatchCode(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.SC_TEMP.getRoot();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCodeValue() {
		return this.codeValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}
}
