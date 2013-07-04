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

package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.xml.ConformanceLevel;

public class Case1Simplifier extends InlineableSimplifier {

	public Case1Simplifier(LogUI log, SimplifiableDefinitions definitions) {
		super(log, definitions);
	}

	@Override
	protected boolean isInlineable(SimplifiablePackage complexTypePackage, SimplifiableType inlineableType) {
		boolean result = true;
		
		// inlines types with only 1 non-fixed relationship
		// cardinality of the 1 non-fixed relationship must be "1", OR *all* relationships referencing the type to be inlined must have a cardinality of "1"; 
		// relationships referencing the type to be inlined cannot be POPULATED
		// rejects types that are root, abstract or have a template variable for their 1 non-fixed relationship
		if (inlineableType.isRootType()) {
			result = false;
		} else if (getNonFixedRelationships(inlineableType).size() != 1) {
			result = false;
		} else if (isTemplateVariable(getNonFixedRelationships(inlineableType).get(0))) {
			result = false;
		} else if (inlineableType.getMessagePart().isAbstract()) {
			result = false;
		}

		Collection<SimplifiableType> allTypes = complexTypePackage.getTypes();  
		result = result && checkCardinalityCompatibility(inlineableType, allTypes);  // don't use &=
		result = result && checkConformanceCompatibility(inlineableType, allTypes);  // don't use &=
		
		return result;
	}
	
	private boolean isTemplateVariable(SimplifiableRelationship simplifiableRelationship) {
		return simplifiableRelationship.isTemplateParameterPresent();
	}

	private boolean checkConformanceCompatibility(SimplifiableType inlineableType,
			Collection<SimplifiableType> types) {
		boolean result = true;
		outer: for (SimplifiableType type : types) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					if (!isConformanceCapableOfSupportingInlining(inlineableType, relationship)) {
						result = false;
						break outer;
					}
				}
			}
		}
		return result;
	}

	private boolean checkCardinalityCompatibility(SimplifiableType inlineableType,
			Collection<SimplifiableType> types) {
		boolean result = true;
		outer: for (SimplifiableType type : types) {
			for (SimplifiableRelationship relationship : type.getRelationships()) {
				if (matches(inlineableType, relationship)) {
					if (!isCardinalityCapableOfSupportingInlining(inlineableType, relationship)) {
						result = false;
						break outer;
					}
				}
			}
		}
		return result;
	}

	protected List<SimplifiableRelationship> getNonFixedRelationships(SimplifiableType inlineableType) {
		List<SimplifiableRelationship> nonFixedRelationships = new ArrayList<SimplifiableRelationship>();
		List<SimplifiableRelationship> allRelationships = inlineableType.getRelationships();
		for (SimplifiableRelationship baseRelationship : allRelationships) {
			if (!baseRelationship.getRelationship().isFixed()) {
				nonFixedRelationships.add(baseRelationship);
			}
		}
		return nonFixedRelationships;
	}
	
	private boolean isConformanceCapableOfSupportingInlining(SimplifiableType inlineableType, SimplifiableRelationship relationship) {
		return !relationship.getRelationship().isPopulated();
	}

	private boolean isCardinalityCapableOfSupportingInlining(SimplifiableType inlineableType,
			SimplifiableRelationship relationship) {
		
		if (EXACTLY_ONE.equals(relationship.getRelationship().getCardinality())) {
			return true;
		} else if (EXACTLY_ONE.equals(getSingleRelationship(inlineableType).getRelationship().getCardinality())) {
			return true;
		} else {
			return false;
		}
	}
	
	private SimplifiableRelationship getSingleRelationship(SimplifiableType inlineableType) {
		return getNonFixedRelationships(inlineableType).get(0);
	}
	
}
