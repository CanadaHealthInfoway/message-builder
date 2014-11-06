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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.tools.delta;

import java.util.List;

import org.codehaus.plexus.util.StringUtils;

import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.UpdateMode;
import ca.infoway.messagebuilder.xml.UpdateModeType;
import ca.infoway.messagebuilder.xml.delta.AttributeDelta;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.DatatypeConstraint;
import ca.infoway.messagebuilder.xml.delta.DefaultValueConstraint;
import ca.infoway.messagebuilder.xml.delta.FixedConstraint;
import ca.infoway.messagebuilder.xml.delta.LengthConstraint;
import ca.infoway.messagebuilder.xml.delta.SortOrderConstraint;
import ca.infoway.messagebuilder.xml.delta.UpdateModeDefaultConstraint;
import ca.infoway.messagebuilder.xml.delta.UpdateModeValuesConstraint;
import ca.infoway.messagebuilder.xml.delta.VocabularyBindingConstraint;
import ca.infoway.messagebuilder.xml.delta.VocabularyStrengthConstraint;

public class AttributeDeltaVisitor extends RelationshipDeltaVisitor {

	public AttributeDeltaVisitor(AttributeDelta delta, MessageSet messageSet) {
		super(delta, messageSet);
	}
	
	@Override
	public void visit(Constraint constraint) {
		if (constraint instanceof DatatypeConstraint) {
			visitDatatypeConstraint((DatatypeConstraint) constraint);
		} else if (constraint instanceof LengthConstraint) {
			visitLengthConstraint((LengthConstraint) constraint);
		} else if (constraint instanceof DefaultValueConstraint) {
			visitDefaultValueConstraint((DefaultValueConstraint) constraint);
		} else if (constraint instanceof FixedConstraint) {
			visitFixedConstraint((FixedConstraint) constraint);
		} else if (constraint instanceof VocabularyBindingConstraint) {
			visitVocabularyBindingConstraint((VocabularyBindingConstraint) constraint);
		} else if (constraint instanceof VocabularyStrengthConstraint) {
			visitVocabularyStrengthConstraint((VocabularyStrengthConstraint) constraint);
		} else if (constraint instanceof UpdateModeValuesConstraint) {
			visitUpdateModeConstraint((UpdateModeValuesConstraint) constraint);
		} else if (constraint instanceof UpdateModeDefaultConstraint) {
			visitUpdateModeDefaultConstraint((UpdateModeDefaultConstraint) constraint);
		} else if (constraint instanceof SortOrderConstraint) {
			visitSortOrderConstraint((SortOrderConstraint) constraint);
		} else {
			super.visit(constraint);
		}
	}
	
	private void visitUpdateModeDefaultConstraint(UpdateModeDefaultConstraint constraint) {
		Relationship relationship = getRelationship();
		if (relationship.getUpdateMode() == null) {
			relationship.setUpdateMode(new UpdateMode());
		}
		logWarning("update mode default", constraint.getOriginalValue(), relationship.getUpdateMode().getUpdateModeDefault());
		relationship.getUpdateMode().setUpdateModeDefault(constraint.getNewValue());
	}

	private void visitUpdateModeConstraint(UpdateModeValuesConstraint constraint) {
		Relationship relationship = getRelationship();
		if (relationship.getUpdateMode() == null) {
			relationship.setUpdateMode(new UpdateMode());
		}
		List<UpdateModeType> updateModesAllowed = relationship.getUpdateMode().getUpdateModesAllowed();
		for (UpdateModeType updateMode : constraint.getNewUpdateModes()) {
			updateModesAllowed.add(updateMode);
		}
		relationship.getUpdateMode().setUpdateModesAllowed(updateModesAllowed);
	}

	private void visitVocabularyStrengthConstraint(VocabularyStrengthConstraint constraint) {
		Relationship relationship = getRelationship();
		logWarning("coding strength", constraint.getOriginalValue(), relationship.getCodingStrength());
		relationship.setCodingStrength(constraint.getNewValue());
	}

	private void visitVocabularyBindingConstraint(VocabularyBindingConstraint constraint) {
		Relationship relationship = getRelationship();
		logWarning("domain source", constraint.getOriginalDomainSource(), relationship.getDomainSource());
		logWarning("domain type", constraint.getOriginalDomainType(), relationship.getDomainType());
		relationship.setDomainSource(constraint.getNewDomainSource());
		relationship.setDomainType(constraint.getNewDomainType());  // error/warning if empty?
	}

	private void visitFixedConstraint(FixedConstraint constraint) {
		Relationship relationship = getRelationship();
		logWarning("fixed value", constraint.getOriginalValue(), relationship.getFixedValue());
		String newFixedValue = sanitize(constraint.getNewValue());
		relationship.setFixedValue(newFixedValue);
		if (newFixedValue != null) {
			relationship.setDefaultValue(null);	// Issue 13667 - if there is a fixed value, there must not be a default value - JR
		}
	}

	private void visitDefaultValueConstraint(DefaultValueConstraint constraint) {
		Relationship relationship = getRelationship();
		logWarning("default value", constraint.getOriginalValue(), relationship.getDefaultValue());
		String newDefaultValue = sanitize(constraint.getNewValue());
		relationship.setDefaultValue(newDefaultValue);
		if (newDefaultValue != null) {
			relationship.setFixedValue(null);	// Issue 13667 - if there is a default value, there must not be a fixed value - JR
		}
	}

	private void visitLengthConstraint(LengthConstraint constraint) {
		Relationship relationship = getRelationship();
		logWarning("length", constraint.getOriginalValue(), relationship.getLength());
		relationship.setLength(constraint.getNewValue());
	}

	void visitDatatypeConstraint(DatatypeConstraint constraint) {
		Relationship relationship = getRelationship();
		String originalType = relationship.getType();
		logWarning("data type", constraint.getOriginalValue(), originalType);
		relationship.setType(constraint.getNewValue());
		if (this.messageSet.isCda() && (StringUtils.equals(originalType, "ANY") || StringUtils.equals(originalType, "LIST<ANY>"))) {
			relationship.setPrintDatatype(true);
		}
	}

	@Override
	public void assignSortKey(Relationship newRelationship, List<Relationship> relationships) {
		// assign a reasonable default, in case there is no sort order constraint
		int lastSortKey = 0;
		for (Relationship relationship : relationships) {
			if (relationship.isAttribute() && relationship.getSortOrder() > lastSortKey) {
				lastSortKey = relationship.getSortOrder();
			}
		}
		newRelationship.setSortOrder(++lastSortKey);
	}
}
