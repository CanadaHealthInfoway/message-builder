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

package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.Relationship;

public abstract class InlineableSimplifier {

	protected static final Cardinality EXACTLY_ONE = new Cardinality(1, 1);
	
	protected final LogUI log;

	private final SimplifiableDefinitions definitions;

	protected InlineableSimplifier(LogUI log, SimplifiableDefinitions definitions) {
		this.log = log;
		this.definitions = definitions;
	}

	public void execute() {
		for (SimplifiablePackage simplifiablePackage : this.definitions.getAllPackages()) {
			for (SimplifiableType type : new ArrayList<SimplifiableType>(simplifiablePackage.getTypes())) {
				this.log.log(DEBUG, "Now analyzing " + type.getMessagePart().getName());
				if (isInlineable(simplifiablePackage, type)) {
					inline(type);
				}
			}
		}
	}
	
	protected void inline(SimplifiableType type) {
		type.setInlined(true);
	}

	protected abstract boolean isInlineable(SimplifiablePackage simplifiablePackage, SimplifiableType type);
	
	protected boolean matches(SimplifiableType inlineableType, SimplifiableRelationship relationship) {
		return relationship.getRelationship().isAssociation()
			&& ObjectUtils.equals(relationship.getRelationship().getType(),
					inlineableType.getMessagePart().getName());
	}
	
	protected List<SimplifiableRelationship> getNonFixedRelationships(SimplifiableType inlineableType) {
		List<SimplifiableRelationship> nonFixedRelationships = new ArrayList<SimplifiableRelationship>();
		List<SimplifiableRelationship> allRelationships = inlineableType.getRelationships();
		for (SimplifiableRelationship simplifiableRelationship : allRelationships) {
			Relationship r = simplifiableRelationship.getRelationship();
			if (!r.hasFixedValue()) {
				nonFixedRelationships.add(simplifiableRelationship);
			}
		}
		return nonFixedRelationships;
	}
	
}
