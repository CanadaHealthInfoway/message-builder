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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.tools.NameAssigner;
import ca.infoway.messagebuilder.tools.messageset.MessageSetCloner;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.delta.AddChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.AddConstraint;
import ca.infoway.messagebuilder.xml.delta.ClassDelta;
import ca.infoway.messagebuilder.xml.delta.CloneConstraint;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.RealmCode;
import ca.infoway.messagebuilder.xml.delta.RemoveChoiceConstraint;
import ca.infoway.messagebuilder.xml.delta.RemoveConstraint;

public class ClassDeltaVisitor extends ConstraintVisitor {

	private final MessageSet messageSet;
	private final ClassDelta delta;

	public ClassDeltaVisitor(ClassDelta delta, MessageSet messageSet) {
		this.messageSet = messageSet;
		this.delta = delta;
	}
	
	@Override
	public void visit(Constraint constraint) {
		super.visit(constraint);
		if (constraint instanceof CloneConstraint) {
			visitCloneConstraint((CloneConstraint) constraint);
		} else if (constraint instanceof AddConstraint) {
			visitAddConstraint((AddConstraint)constraint);
		} else if (constraint instanceof AddChoiceConstraint) {
			visitAddChoiceConstraint((AddChoiceConstraint)constraint);
		} else if (constraint instanceof RemoveChoiceConstraint) {
			visitRemoveChoiceConstraint((RemoveChoiceConstraint)constraint);
		}
	}

	@Override
	void visitRemoveConstraint(RemoveConstraint constraint) {
		String className = constraint.getClassName();
		TypeName name = new TypeName(className);
		PackageLocation packageLocation = this.messageSet.getPackageLocations().get(name.getRootName().getName());
		if (packageLocation != null){
			if (constraint.getRelationshipName() == null) {
				packageLocation.getMessageParts().remove(className);
				if (packageLocation.getMessageParts().isEmpty()) {
					this.messageSet.getPackageLocations().remove(name.getRootName().getName());
				}
			} else {
				Relationship relationship = packageLocation.getMessageParts().get(className).getRelationship(constraint.getRelationshipName());
				if (relationship != null) {
					packageLocation.getMessageParts().get(className).getRelationships().remove(relationship);
				}
			}
		} 
		
		// Also remove any references to this message part in the choice blocks of other message parts
		for (MessagePart messagePart : this.messageSet.getAllMessageParts()) {
			if (messagePart.isAbstract() && messagePart.hasSpecializationChild(className)) {
				removeChoiceFromAbstractClass(messagePart, className);
			}
		}
	}

	@Override
	void visitCloneConstraint(CloneConstraint constraint) {
		String className = constraint.getOriginalClassName();
		TypeName name = new TypeName(className);
		PackageLocation originPackageLocation = this.messageSet.getPackageLocations().get(name.getRootName().getName());
		if (originPackageLocation != null) {
			MessagePart clone = new MessageSetCloner().clone(originPackageLocation.getMessageParts().get(className), RealmCode.createTrivialRealmCode());
			clone.setName(constraint.getClassName());
			TypeName destinationName = new TypeName(constraint.getClassName());
			PackageLocation destinationPackageLocation = this.messageSet.getPackageLocations().get(destinationName.getRootName().getName());
			destinationPackageLocation.getMessageParts().put(constraint.getClassName(), clone);
		}
	}
	
	@Override
	void visitAddConstraint(AddConstraint constraint) {
		String className = this.delta.getClassName();
		TypeName name = new TypeName(className);
		PackageLocation packageLocation = this.messageSet.getPackageLocations().get(name.getRootName().getName());
		if (packageLocation != null) {
			MessagePart messagePart = new MessagePart(className);
			messagePart.setAbstract(constraint.getIsAbstract() == null ? false : constraint.getIsAbstract());
			messagePart.setRimClass(constraint.getRimClass());
			packageLocation.getMessageParts().put(className, messagePart);
		} else { 
			// TODO SPD/GN: What to do if package does not exist? Create?
			//Determined to be out of scope for v2 (also according to Greg new package names have to go through standards collaborative)
//			PackageLocation newPackageLocation = new PackageLocation();
//			String packageName = name.getRootName().getName();
//			newPackageLocation.setName(packageName);
//			newPackageLocation.setRootType(className);
//			MessagePart messagePart = new MessagePart(className);
//			newPackageLocation.getMessageParts().put(className, messagePart);
//			this.messageSet.getPackageLocations().put(packageName, newPackageLocation);
		}
	}
	
	MessagePart getMessagePart() {
		return this.messageSet.getMessagePart(this.delta.getClassName());
	}
	
	@Override
	Documentation getDocumentation() {
		Documentation documentation = getMessagePart().getDocumentation();
		if (documentation == null) {
			getMessagePart().setDocumentation(documentation = new Documentation());
		}
		return documentation;
	}
	
	void visitAddChoiceConstraint(AddChoiceConstraint constraint) {
		if (!getMessagePart().getSpecializationChilds().contains(constraint.getChoiceClassName()) &&
				this.messageSet.getMessagePart(constraint.getChoiceClassName()) != null) {
			
			SpecializationChild child = null;
			String parentPackageName = TypeName.determineRootName(this.delta.getClassName());
			String childPackageName = TypeName.determineRootName(constraint.getChoiceClassName());
			if (!parentPackageName.equals(childPackageName)) {
				PackageLocation packageLocation = this.messageSet.getPackageLocation(childPackageName);
				if (packageLocation.isCmet() && packageLocation.getCmetBindings().size() == 1) {
					child = new SpecializationChild(constraint.getChoiceClassName(), packageLocation.getCmetBindings().get(0).getCmetName(), getMessagePart().getDerivedFromClass());
				} else {
					child = new SpecializationChild(constraint.getChoiceClassName());
				}
			} else {
				child = new SpecializationChild(constraint.getChoiceClassName());
			}
			if(constraint.isDefault()) {
				child.setDefault(Boolean.TRUE);
			} // else leave it null
			
			getMessagePart().getSpecializationChilds().add(child);
			for (MessagePart messagePart : this.messageSet.getAllMessageParts()) {
				addChoiceToAllRelationships(messagePart.getRelationships(), getMessagePart().getName(), constraint);
			}
		}
	}
	
	/**
	 * Create a NameAssigner that has been initialized with all the traversal names already in use in a collection of relationships.
	 *  This NameAssigner will be used to create names for new choices in the relationship that do not conflict with any existing choices.
	 *  
	 * @param existingChoices the list of top level choices in the relationship
	 * @return an initialized NameAssigner
	 */
	private NameAssigner createInitializedNameAssigner(List<Relationship> existingChoices) {
		Set<String> existingNames = new HashSet<String>();
		
		collectExistingNames(existingChoices, existingNames);
		
		NameAssigner nameAssigner = new NameAssigner();
		nameAssigner.initialize(existingNames);
		return nameAssigner;
	}

	private void collectExistingNames(List<Relationship> existingChoices, Set<String> existingNames) {
		for (Relationship choice : existingChoices) {
			existingNames.add(choice.getName());
			collectExistingNames(choice.getChoices(), existingNames);
		}
	}
	
	/**
	 * Inspects a collection of relationships and, if any of them include the designated abstract message part, add the new choice as a child of that message part.
	 *  This method initializes a new NameAssigner for each relationship in the collection.
	 * 
	 * @param relationships a collection of relationships to update
	 * @param parentMessagePartName	the abstract message part that is being modified
	 * @param newChildMessagePartName the new choice to be added
	 */
	private void addChoiceToAllRelationships(List<Relationship> relationships, String parentMessagePartName, AddChoiceConstraint constraint) {
		for (Relationship relationship : relationships) {
			NameAssigner nameAssigner = createInitializedNameAssigner(relationship.getChoices());
			
			addChoiceToRelationship(relationship, parentMessagePartName, constraint, nameAssigner);
		}
	}

	/**
	 * If the relationship involves the specified message part, either directly or as a choice, add the new choice at the right point in the choice hierarchy
	 * 
	 * @param relationship the relationship to be updated
	 * @param parentMessagePartName the abstract message part that receives the new choice
	 * @param newChildMessagePartName the new choice to be added
	 * @param nameAssigner a name assigner
	 */
	private void addChoiceToRelationship(Relationship relationship,	String parentMessagePartName, AddChoiceConstraint constraint, NameAssigner nameAssigner) {
		if (relationship.getType() != null && relationship.getType().equals(parentMessagePartName)) {
			Relationship choice = createChoice(constraint.getOptionName(), constraint.getChoiceClassName(), constraint.isDefault(), nameAssigner);
			relationship.getChoices().add(choice);
		} else {
			addChoiceToAllRelationships(relationship.getChoices(), parentMessagePartName, constraint, nameAssigner);
		}
	}

	/**
	 * Inspects a collection of relationships and, if any of them include the designated abstract message part, add the new choice as a child of that message part.
	 *  This method uses the same NameAssigner for every relationship in the collection.
	 * 
	 * @param relationships a collection of relationships to update
	 * @param parentMessagePartName	the abstract message part that is being modified
	 * @param newChildMessagePartName the new choice to be added
	 */
	private void addChoiceToAllRelationships(List<Relationship> relationships, String parentMessagePartName, AddChoiceConstraint constraint, NameAssigner nameAssigner) {
		for (Relationship relationship : relationships) {
			addChoiceToRelationship(relationship, parentMessagePartName, constraint, nameAssigner);
		}
	}
	
	private Relationship createChoice(String choiceName, String choiceType, boolean isDefault, NameAssigner nameAssigner) {
		MessagePart choiceMessagePart = this.messageSet.getMessagePart(choiceType);
		
		Relationship choice = new Relationship();
		choice.setType(choiceType);
		if (choiceName != null) {
			choice.setName(choiceName);
		} else {
			choice.setName(nameAssigner.determineName(choiceType));
		}
		
		if (isDefault) {
			choice.setDefaultChoice(Boolean.TRUE);
		}

		if (choiceMessagePart.isAbstract()) {
			for (SpecializationChild nestedChoice : choiceMessagePart.getSpecializationChilds()) {
				choice.getChoices().add(createChoice(null, nestedChoice.getName(), nestedChoice.isDefault(), nameAssigner));
			}
		}
		
		return choice;
	}

	void visitRemoveChoiceConstraint(RemoveChoiceConstraint constraint) {
		removeChoiceFromAbstractClass(getMessagePart(), constraint.getChoiceClassName());
	}

	private void removeChoiceFromAbstractClass(MessagePart abstractMessagePart, String choiceName) {
		abstractMessagePart.removeSpecializationChild(choiceName);
		for (MessagePart messagePart : this.messageSet.getAllMessageParts()) {
			removeChoiceFromRelationshipsToAbstractMessagePart(messagePart.getRelationships(), abstractMessagePart.getName(), choiceName);
		}
	}

	private void removeChoiceFromRelationshipsToAbstractMessagePart(List<Relationship> relationships, String abstractMessagePartName, String choiceName) {
		for (Relationship relationship : relationships) {
			if (relationship.getType() != null && relationship.getType().equals(abstractMessagePartName)) {
				removeChoiceFromChoiceList(relationship.getChoices(), choiceName);
			} else {
				removeChoiceFromRelationshipsToAbstractMessagePart(relationship.getChoices(), abstractMessagePartName, choiceName);
			}
		}
	}

	private void removeChoiceFromChoiceList(List<Relationship> choices,	String choiceName) {
		Set<Relationship> toRemove = new HashSet<Relationship>();
		for (Relationship choice : choices) {
			if (choice.getType().equals(choiceName)) {
				toRemove.add(choice);
			}
		}
		
		if (!toRemove.isEmpty()) {
			choices.removeAll(toRemove);
		}
	}
}
