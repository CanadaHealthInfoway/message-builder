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
package ca.infoway.messagebuilder.tools.template;

import ca.infoway.messagebuilder.tools.delta.AssociationDeltaVisitor;
import ca.infoway.messagebuilder.tools.delta.AttributeDeltaVisitor;
import ca.infoway.messagebuilder.tools.delta.ClassDeltaVisitor;
import ca.infoway.messagebuilder.tools.delta.ConstraintVisitor;
import ca.infoway.messagebuilder.tools.delta.InteractionDeltaVisitor;
import ca.infoway.messagebuilder.tools.delta.PackageLocationDeltaVisitor;
import ca.infoway.messagebuilder.tools.messageset.MessageSetCloner;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.delta.AssociationDelta;
import ca.infoway.messagebuilder.xml.delta.AttributeDelta;
import ca.infoway.messagebuilder.xml.delta.ClassDelta;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.Delta;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.delta.InteractionDelta;
import ca.infoway.messagebuilder.xml.delta.MessagePartType;
import ca.infoway.messagebuilder.xml.delta.PackageLocationDelta;
import ca.infoway.messagebuilder.xml.delta.RealmCode;
import ca.infoway.messagebuilder.xml.template.Template;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

/**
 * <p>Applies a delta set to a message set to produce a new message set.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class TemplateApplier {

	private MessageSetCloner messageSetCloner;

	public TemplateApplier(MessageSetCloner messageSetCloner) {
		this.messageSetCloner = messageSetCloner;
	}
	
	public TemplateApplier() {
		messageSetCloner = new MessageSetCloner();
	}
	
	public MessageSet resolveToMessageSet(MessageSet original, TemplateSet templateSet, String messageSetName) {
		MessageSet result = messageSetCloner.clone(original, RealmCode.from(original.getRealmCode()));
		
		// TM: #17316 - message sets generated within Remixer should have realm code and description from DeltaSet  
		result.setRealmCode(original.getRealmCode());
		
		// Add new package locations
		for (Template template : templateSet.getAllTemplates()) {
			result.addPackageLocation(createPackageLocation(template));
		}
		
		//Add All New Classes First
		for (Delta delta : templateSet.getAllDeltas()) {
			if (isCreateNewClassDelta(delta)) {
				apply(delta, result);
			}
		}
		
		for (Delta delta : templateSet.getAllDeltas()) {
			if (!isCreateNewClassDelta(delta)) {
				// TM - deltas that no longer apply (due to re-assigning the message set) should be excluded
				if (existsInMessageSet(delta, result)) {
					apply(delta, result);
				} else if (existsInTemplateSet(delta, templateSet)){
					apply(delta, result);
				} else if (isConstrainedDatatype(delta, result)) {
					applyConstrainedDatatype(delta, result);
				} else {
					System.out.println("couldn't apply delta - " + delta.getClassName() + (delta.getRelationshipName() != null ? "." + delta.getRelationshipName() : "") + " could not be found.");
				}
			}
		}
		
		return result;
	}

	public PackageLocation createPackageLocation(Template template) {
		PackageLocation packageLocation = new PackageLocation(template.getPackageName());
		packageLocation.setRootType(template.getEntryClassName());
		return packageLocation;
	}

	private boolean isCreateNewClassDelta(Delta delta) {
		return delta instanceof ClassDelta 
					&& (DeltaChangeType.ADD.equals(delta.getDeltaChangeType()) 
						|| DeltaChangeType.CLONE.equals(delta.getDeltaChangeType()));
	}
	
	private boolean existsInTemplateSet(Delta delta, TemplateSet templateSet) {
		boolean exists = false;
		String className = delta.getClassName();
		Delta addClassDelta = templateSet.getDelta(DeltaChangeType.ADD, className, null);
		exists = (addClassDelta != null);
		return exists;
	}

	/**
	 * Check to see class, relationship, or interaction referred by delta exists in messageSet
	 * @param 	delta
	 * @param 	messageSet
	 * @return 	boolean true if class exists, or (class and relationship exists), or if interaction exists.
	 */
	private boolean existsInMessageSet(Delta delta, MessageSet messageSet) {
		boolean exists = false;
		if (MessagePartType.CLASS.equals(delta.getType())) {
			MessagePart messagePart = messageSet.getMessagePart(delta.getClassName());
			exists = (messagePart != null);
		} else if (MessagePartType.ASSOCIATION.equals(delta.getType()) || MessagePartType.ATTRIBUTE.equals(delta.getType())) {
			MessagePart messagePart = messageSet.getMessagePart(delta.getClassName());
			if (messagePart == null) {
				exists = false;
			} else if (DeltaChangeType.ADD.equals(delta.getDeltaChangeType())) {
				exists = true;
			} else {
				exists = (messagePart.getRelationship(delta.getRelationshipName()) != null);
			}
		} else if (MessagePartType.INTERACTION.equals(delta.getType())) {
			exists = (messageSet.getInteractions().containsKey(delta.getClassName()));
		} else if (MessagePartType.PACKAGE_LOCATION.equals(delta.getType())) {
			exists = (messageSet.getPackageLocations().containsKey(delta.getClassName()));
		}
		return exists;
	}
	
	private boolean isConstrainedDatatype(Delta delta, MessageSet messageSet) {
		boolean parentFound = false;
		if (MessagePartType.ASSOCIATION.equals(delta.getType()) || MessagePartType.ATTRIBUTE.equals(delta.getType())) {
			MessagePart messagePart = messageSet.getMessagePart(delta.getClassName());
			String relationshipName = delta.getRelationshipName();
			
			while(!parentFound && relationshipName.lastIndexOf('.') > -1) {
				relationshipName = relationshipName.substring(0, relationshipName.lastIndexOf('.'));
				parentFound = messagePart.getRelationship(relationshipName) != null;
			}
		}

		return parentFound;
	}
	
	private void apply(Delta delta, MessageSet result) {
		if (delta instanceof InteractionDelta) {
			apply((InteractionDelta) delta, result);
		} else if (delta instanceof ClassDelta) {
			apply((ClassDelta) delta, result);
		} else if (delta instanceof AssociationDelta) {
			apply((AssociationDelta) delta, result);
		} else if (delta instanceof AttributeDelta) {
			apply((AttributeDelta) delta, result);
		} else if (delta instanceof PackageLocationDelta) {
			apply((PackageLocationDelta) delta, result);
		}
	}
	
	private void applyConstrainedDatatype(Delta delta, MessageSet result) {
		// TODO: something
	}
	
	private void apply(InteractionDelta delta, MessageSet messageSet) {
		visit(delta, new InteractionDeltaVisitor(delta, messageSet));
	}
	
	private void apply(ClassDelta delta, MessageSet messageSet) {
		visit(delta, new ClassDeltaVisitor(delta, messageSet));
	}
	
	private void apply(AssociationDelta delta, MessageSet messageSet) {
		visit(delta, new AssociationDeltaVisitor(delta, messageSet));
	}
	
	private void apply(AttributeDelta delta, MessageSet messageSet) {
		visit(delta, new AttributeDeltaVisitor(delta, messageSet));
	}
	
	private void apply(PackageLocationDelta delta, MessageSet messageSet) {
		visit(delta, new PackageLocationDeltaVisitor(delta, messageSet));
	}
	
	void visit(Delta delta, ConstraintVisitor visitor) {
		for (Constraint constraint : delta.getConstraints()) {
			visitor.visit(constraint);
		}
		visitor.postProcess();
	}
}
