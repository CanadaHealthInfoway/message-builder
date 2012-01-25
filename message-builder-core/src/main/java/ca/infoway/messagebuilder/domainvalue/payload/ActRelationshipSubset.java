/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum ActRelationshipSubset.
 */
public class ActRelationshipSubset extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.ActRelationshipSubset, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = -617461458714176662L;
	
	public static final ActRelationshipSubset EXPECTED_FUTURE = new ActRelationshipSubset("EXPECTED_FUTURE", "FUTURE");
	public static final ActRelationshipSubset EXPECTED_LAST = new ActRelationshipSubset("EXPECTED_LAST", "LAST");
	public static final ActRelationshipSubset EXPECTED_NEXT = new ActRelationshipSubset("EXPECTED_NEXT", "NEXT");
	public static final ActRelationshipSubset FIRST_KNOWN = new ActRelationshipSubset("FIRST_KNOWN", "FIRST");
	public static final ActRelationshipSubset FUTURE_SUMMARY = new ActRelationshipSubset("FUTURE_SUMMARY", "FUTSUM");
	public static final ActRelationshipSubset MAXIMUM = new ActRelationshipSubset("MAXIMUM", "MAX");
	public static final ActRelationshipSubset MINIMUM = new ActRelationshipSubset("MINIMUM", "MIN");
	public static final ActRelationshipSubset MOST_RECENT = new ActRelationshipSubset("MOST_RECENT", "RECENT");
	public static final ActRelationshipSubset PREVIOUS = new ActRelationshipSubset("PREVIOUS", "PAST");
	public static final ActRelationshipSubset PREVIOUS_SUMMARY = new ActRelationshipSubset("PREVIOUS_SUMMARY", "PREVSUM");
	public static final ActRelationshipSubset SUMMARY = new ActRelationshipSubset("SUMMARY", "SUM");

	private final String codeValue;

	private ActRelationshipSubset(String name, String codeValue) {
		super(name);
		this.codeValue = codeValue;

	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getCodeSystem() {
		return CodeSystem.VOCABULARY_ACT_RELATIONSHIP_SUBSET.getRoot();
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
