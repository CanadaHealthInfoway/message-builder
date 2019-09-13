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

import ca.infoway.messagebuilder.tools.NameAssigner;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.delta.AssociationDelta;
import ca.infoway.messagebuilder.xml.delta.AssociationSortOrderConstraint;
import ca.infoway.messagebuilder.xml.delta.AssociationTypeConstraint;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.SortOrderConstraint;

public class AssociationDeltaVisitor extends RelationshipDeltaVisitor {

	public AssociationDeltaVisitor(AssociationDelta delta, MessageSet messageSet) {
		super(delta, messageSet);
	}
	
	@Override
	public void visit(Constraint constraint) {
		super.visit(constraint);
		if (constraint instanceof AssociationTypeConstraint) {
			visitAssociationTypeConstraint((AssociationTypeConstraint) constraint);
		} else if (constraint instanceof SortOrderConstraint) {
			visitSortOrderConstraint((SortOrderConstraint) constraint);
		} else if (constraint instanceof AssociationSortOrderConstraint) {
			visitAssociationSortOrderConstraint((AssociationSortOrderConstraint) constraint);
		}
	}

	private void visitAssociationTypeConstraint(AssociationTypeConstraint constraint) {
		Relationship relationship = getRelationship();
		logWarning("data type", constraint.getOriginalValue(), relationship.getType());
		String associationType = constraint.getNewValue();
		relationship.setType(associationType);
		
		relationship.getChoices().clear();
		NameAssigner nameAssigner = new NameAssigner();
		populateChoices(relationship, nameAssigner);
		
		String sourcePackageName = TypeName.determineRootName(this.delta.getClassName());
		String destinationPackageName = TypeName.determineRootName(associationType);
		MessagePart destinationPart = this.messageSet.getMessagePart(associationType);
		if (!sourcePackageName.equals(destinationPackageName)) {
			PackageLocation packageLocation = this.messageSet.getPackageLocation(destinationPackageName);
			if (packageLocation.isCmet() && packageLocation.getCmetBindings().size() == 1) {
				relationship.setCmetBindingName(packageLocation.getCmetBindings().get(0).getCmetName());
				relationship.setCmetDerivationClassName(destinationPart.getDerivedFromClass());
			}
		}
	}

	private void populateChoices(Relationship relationship, NameAssigner nameAssigner) {
		MessagePart messagePart = this.messageSet.getMessagePart(relationship.getType());
		if (messagePart != null && messagePart.isAbstract()) {
			for (SpecializationChild childName : messagePart.getSpecializationChilds()) {
				Relationship childRelationship = new Relationship();
				childRelationship.setType(childName.getName());
				if (childName.isDefault()) {
					childRelationship.setDefaultChoice(Boolean.TRUE);
				}
				childRelationship.setName(nameAssigner.determineName(childName.getName()));
				populateChoices(childRelationship, nameAssigner);
				relationship.getChoices().add(childRelationship);
			}
		}
	}

	protected void visitAssociationSortOrderConstraint(AssociationSortOrderConstraint constraint) {
		Relationship relationship = getRelationship();
//		Warning not enforceable for new relationships, because generation in ADD scenario is dependent on other constraints
//		logWarning("association sort key", constraint.getOriginalValue(), relationship.getAssociationSortKey());
		relationship.setAssociationSortKey(constraint.getNewValue());
	}

	@Override
	public void assignSortKey(Relationship newRelationship, List<Relationship> relationships) {
		int lastSortKey = 0;
		for (Relationship relationship : relationships) {
			if (relationship.isAssociation() && relationship.getSortOrder() > lastSortKey) {
				lastSortKey = relationship.getSortOrder();
			}
		}
		newRelationship.setSortOrder(++lastSortKey);
		
		newRelationship.setAssociationSortKey("ZZZZZZZZ");	// should force it to the bottom
	}
}
