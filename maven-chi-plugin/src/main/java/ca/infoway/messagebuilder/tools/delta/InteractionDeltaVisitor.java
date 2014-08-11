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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.infoway.messagebuilder.xml.delta.AddInteractionArgument;
import ca.infoway.messagebuilder.xml.delta.AddInteractionConstraint;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.InteractionDelta;
import ca.infoway.messagebuilder.xml.delta.RemoveConstraint;
import ca.infoway.messagebuilder.xml.delta.TemplateParameterConstraint;

public class InteractionDeltaVisitor extends ConstraintVisitor {

	private final MessageSet messageSet;
	private final InteractionDelta delta;

	public InteractionDeltaVisitor(InteractionDelta delta, MessageSet messageSet) {
		this.messageSet = messageSet;
		this.delta = delta;
	}

	
	@Override
	public void visit(Constraint constraint) {
		super.visit(constraint);
		if (constraint instanceof AddInteractionConstraint) {
			visitAddInteractionConstraint((AddInteractionConstraint)constraint);
		} else if (constraint instanceof TemplateParameterConstraint) {
			visitTemplateParameterConstraint((TemplateParameterConstraint)constraint);
		}
	}
	
	@Override
	void visitRemoveConstraint(RemoveConstraint constraint) {
		String interactionName = constraint.getClassName();
		this.messageSet.getInteractions().remove(interactionName);
	}

	@Override
	Documentation getDocumentation() {
		Interaction interaction = this.messageSet.getInteractions().get(this.delta.getClassName());
		if (interaction != null && interaction.getDocumentation() == null) {
			interaction.setDocumentation(new Documentation());
		}
		return interaction == null ? null : interaction.getDocumentation();
	}

	@Override
	void visitAddInteractionConstraint(AddInteractionConstraint constraint) {
		Interaction interaction = new Interaction();
		interaction.setName(delta.getClassName());
		interaction.setCategory(null); // SPD: what category should we put new interaction in? the same as package of payload?
		interaction.setSuperTypeName(constraint.getBaseTypeName());
		
		populateArguments(constraint.getBaseTypeName(), toMap(constraint.getArguments()), interaction.getArguments());
		
		this.messageSet.getInteractions().put(interaction.getName(), interaction);
		
	}
	
	private void visitTemplateParameterConstraint(TemplateParameterConstraint constraint) {
		Interaction interaction = this.messageSet.getInteractions().get(delta.getClassName());
		updateArgument(constraint, interaction.getArguments());
	}

	private void populateArguments(String typeName,
			Map<String, AddInteractionArgument> argumentMap,
			List<Argument> arguments) {
		TypeName name = new TypeName(typeName);
		PackageLocation basePackageLocation = this.messageSet.getPackageLocations().get(name.getRootName().getName());
		for (MessagePart messagePart : basePackageLocation.getMessageParts().values()) {
			for (Relationship relationship : messagePart.getRelationships()) {
				if (relationship.isTemplateRelationship()) {
					Argument argument = new Argument();
					AddInteractionArgument argumentTemplate = argumentMap.get(relationship.getTemplateParameterName());
					argument.setName(argumentTemplate.getMessagePartName());
					argument.setTemplateParameterName(argumentTemplate.getTemplateParameterName());
					argument.setTraversalName(argumentTemplate.getTraversalName());
					populateArguments(argumentTemplate.getMessagePartName(), argumentMap, argument.getArguments());
					arguments.add(argument);
				}
			}
		}
	}

	private void updateArgument(TemplateParameterConstraint constraint,	List<Argument> arguments) {
		// Assumes that the collection of arguments is already fully populated, and that changes only happen at leaf nodes
		// Refactoring will be required if these assumptions cease to hold
		for (Argument argument : arguments) {
			if (argument.getTemplateParameterName().equals(constraint.getTemplateParameterName())) {
				argument.setName(constraint.getNewMessagePartName());
				argument.setTraversalName(constraint.getNewTraversalName());
			} else {
				updateArgument(constraint, argument.getArguments());
			}
		}
	}

	private Map<String, AddInteractionArgument> toMap(List<AddInteractionArgument> arguments) {
		Map<String, AddInteractionArgument> result = new HashMap<String, AddInteractionArgument>();
		for (AddInteractionArgument argument : arguments) {
			result.put(argument.getTemplateParameterName(), argument);
		}
		return result;
	}
}
