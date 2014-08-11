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

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.delta.CardinalityConstraint;
import ca.infoway.messagebuilder.xml.delta.ConformanceConstraint;
import ca.infoway.messagebuilder.xml.delta.Delta;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.delta.RemoveConstraint;

public abstract class RelationshipDeltaVisitor extends ConstraintVisitor {

	private Log log = LogFactory.getLog(getClass());
	protected final Delta delta;
	protected final MessageSet messageSet;
	private final Relationship relationship;
	
	RelationshipDeltaVisitor(Delta delta, MessageSet messageSet) {
		this.delta = delta;
		this.messageSet = messageSet;
		if (DeltaChangeType.ADD.equals(delta.getDeltaChangeType())) {
			createRelationship();
		}
		// storing relationship in case it ends up getting removed from message set; other constraints that apply to the same relationship, though redundant, will fail otherwise
		this.relationship = getRelationshipFromMessageSet();
	}
	
	private void createRelationship() {
		List<Relationship> relationships = this.messageSet.getMessagePart(this.delta.getClassName()).getRelationships();

		Relationship newRelationship = new Relationship();
		newRelationship.setName(this.delta.getRelationshipName());
		assignSortKey(newRelationship, relationships);
		this.messageSet.getMessagePart(this.delta.getClassName()).getRelationships().add(newRelationship);
	}

	public abstract void assignSortKey(Relationship newRelationship, List<Relationship> relationships);

	@Override
	void visitConformanceConstraint(ConformanceConstraint constraint) {
		Relationship relationship = getRelationship();
		logWarning("conformance", constraint.getOriginalValue(), relationship.getConformance());
		ConformanceLevel newConformance = constraint.getNewValue();
		if (ConformanceLevel.NOT_ALLOWED.equals(newConformance)) {
			removeRelationship();
		} else {
			relationship.setConformance(newConformance);
		}
	}
	
	@Override
	void visitCardinalityConstraint(CardinalityConstraint constraint) {
		Relationship relationship = getRelationship();
		logWarning("cardinality", constraint.getOriginalCardinality(), relationship.getCardinality());
		relationship.setCardinality(constraint.getNewCardinality());
	}

	void logWarning(String name, Object originalValue, Object newValue) {
		if (!ObjectUtils.equals(originalValue, newValue)) {
			this.log.warn(describeDelta() + "Original " +
					name + " does not match " + originalValue);
		}
	}
	
	String describeDelta() {
		return delta.getClassName() + " -> " + delta.getRelationshipName() + ": ";
	}

	public Relationship getRelationship() {
		return this.relationship;
	}
	
	private Relationship getRelationshipFromMessageSet() {
		// can getMessagePart return a null in some edge cases??
		return this.messageSet.getMessagePart(this.delta.getClassName()).getRelationship(this.delta.getRelationshipName());
	}
	
	@Override
	Documentation getDocumentation() {
		Documentation documentation = getRelationship().getDocumentation();
		if (documentation == null) {
			documentation = new Documentation();
			getRelationship().setDocumentation(documentation);
		}
		return documentation;
	}
	
	@Override
	void visitRemoveConstraint(RemoveConstraint constraint) {
		// TM - redmine 10275 - attribute/association "removes" were not coming through in a directly-generated message set
		removeRelationship();
	}

	private boolean removeRelationship() {
		MessagePart messagePart = this.messageSet.getMessagePart(this.delta.getClassName());
		if (messagePart != null) {
			return messagePart.getRelationships().remove(getRelationship());
		}
		return false;
	}
	
	@Override
	public void postProcess() {
		List<Relationship> relationships = this.messageSet.getMessagePart(this.delta.getClassName()).getRelationships();
		Collections.sort(relationships);
	}
}
