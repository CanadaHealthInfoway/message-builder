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

package ca.infoway.messagebuilder.generator.dependency;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.java.SimplifiableDefinitions;
import ca.infoway.messagebuilder.generator.java.SimplifiableInteraction;
import ca.infoway.messagebuilder.generator.java.SimplifiableType;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.DifferenceType;
import ca.infoway.messagebuilder.xml.DifferenceValue;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.SpecializationChild;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.intelliware.commons.dependency.DependencyManager;
import ca.intelliware.commons.dependency.LayeredGraph;

public class DependencyTracker {

	DependencyManager<String> manager;
	DependencyManager<String> choiceManager;
	
	
	private DependencyTracker() {
		this.manager = new DependencyManager<String>();
		this.choiceManager = new DependencyManager<String>();
	}
	
	void initialize(MessageSet messageSet) {
		for (MessagePart messagePart : messageSet.getAllMessageParts()) {
			createDependenciesOfMessagePart(messagePart);
		}
		for (Interaction interaction : messageSet.getInteractions().values()) {
			createDependenciesOfInteraction(interaction);
		}
	}

	void initialize(SimplifiableDefinitions definitions) {
		for (SimplifiableType type : definitions.getAllTypes()) {
			createDependenciesOfMessagePart(type.getMessagePart());
		}
		for (SimplifiableInteraction interaction : definitions.getAllInteractions()) {
			createDependenciesOfInteraction(interaction.getInteraction());
		}
	}
	
	private void createDependenciesOfInteraction(Interaction interaction) {
		this.manager.add(interaction.getName(), interaction.getSuperTypeName());
		addArguments(interaction, interaction.getArguments());
	}

	private void createDependenciesOfMessagePart(MessagePart messagePart) {
		String name = messagePart.getName();
		this.manager.add(name);
		// we have decided to *not* add the reverse dependency of package location to root type 
		this.manager.add(name, new TypeName(name).getParent().getName());
		
		for (SpecializationChild child : messagePart.getSpecializationChilds()) {
			// Do NOT add dependency from implementors to interface
			// otherwise removing an interface type could remove a huge number of components
			//manager.add(child, name);  
			this.choiceManager.add(name, child.getName());
		}
		
		for (Relationship relationship : messagePart.getRelationships()) {
			if (relationship.isAssociation() 
					&& StringUtils.isNotBlank(relationship.getType())) {
				this.manager.add(name, relationship.getType());
				buildDifferenceDependencies(name, relationship);
				List<Relationship> choices = relationship.getChoices();
				buildChoiceDependencies(this.choiceManager, name, choices);
			}
		}
	}

	// Redmine bug #673
	// - if there's an association type change, we need to build the dependencies 
	//   to both the old and new values
	private void buildDifferenceDependencies(String name, Relationship relationship) {
		for (Difference difference : relationship.getDifferences()) {
			if (difference.getType() == DifferenceType.ASSOCIATION_TYPE) {
				for (DifferenceValue value : difference.getDifferences()) {
					this.manager.add(name, value.getValue());
				}
			}
		}
	}

	private void buildChoiceDependencies(DependencyManager<String> choiceManager, String name, List<Relationship> choices) {
		for (Relationship choice : choices) {
			choiceManager.add(name, choice.getType());
			buildChoiceDependencies(choiceManager, name, choice.getChoices());
		}
	}

	private void addArguments(Interaction interaction, List<Argument> arguments) {
		for (Argument argument : arguments) {
			this.manager.add(interaction.getName(), argument.getName());
			addArguments(interaction, argument.getArguments());
			buildChoiceDependencies(this.choiceManager, interaction.getName(), argument.getChoices());
		}
	}
	
	public static DependencyTracker create(MessageSet messageSet) {
		DependencyTracker tracker = new DependencyTracker();
		tracker.initialize(messageSet);
		return tracker;
	}

	public static DependencyTracker create(SimplifiableDefinitions definitions) {
		DependencyTracker tracker = new DependencyTracker();
		tracker.initialize(definitions);
		return tracker;
	}
	
	public LayeredGraph<String> getPrimaryLayeredGraph() {
		return this.manager.getLayeredGraph();
	}

	public LayeredGraph<String> getChoiceLayeredGraph() {
		return this.choiceManager.getLayeredGraph();
	}
	
	DependencyManager<String> getChoiceManager() {
		return this.choiceManager;
	}
	DependencyManager<String> getManager() {
		return this.manager;
	}
}
