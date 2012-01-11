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

package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.Named;
import ca.infoway.messagebuilder.generator.dependency.DependencyTracker;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.intelliware.commons.dependency.LayeredGraph;
import ca.intelliware.commons.dependency.Node;

public class Exciser {

	private final MessageSet messageSet;
	private Set<ExcisedItem> removals = Collections.synchronizedSet(new HashSet<ExcisedItem>());
	private Map<String, PackageLocation> removedPackageLocations = Collections.synchronizedMap(new HashMap<String, PackageLocation>());
	private final ExcisionEvaluator evaluator; 

	public Exciser(MessageSet messageSet, ExcisionEvaluator evaluator) {
		this.messageSet = messageSet;
		this.evaluator = evaluator;
	}

	public Set<ExcisedItem> execute() {
		DependencyTracker dependencies = DependencyTracker.create(this.messageSet);
		removeProblemDifferences(dependencies);
		return this.removals;
	}

	void removeProblemDifferences(DependencyTracker dependencies) {
		removeProblemInteractions(dependencies);
		removeProblemMessageParts(dependencies);
		removeProblemPackageLocations(dependencies);
	}

	private void removeProblemPackageLocations(DependencyTracker dependencies) {
		for (PackageLocation location : new ArrayList<PackageLocation>(this.messageSet.getPackageLocations().values())) {
			if (this.evaluator.shouldRemove(location)) {
				removeComponent(dependencies, location);
			}
		}
	}

	private void removeComponent(DependencyTracker dependencies, Named named) {
		removeComponent(dependencies, named.getName(), named.getName());
	}

	private void removeProblemMessageParts(DependencyTracker dependencies) {
		for (MessagePart messagePart : this.messageSet.getAllMessageParts()) {
			boolean remove = this.evaluator.shouldRemove(messagePart);
			
			if (remove) {
				removeComponent(dependencies, messagePart);
			}
		}
	}

	private void removeDependenciesOfComponent(DependencyTracker dependencies, String name, String exciseSourceName) {
		LayeredGraph<String> layeredGraph = dependencies.getPrimaryLayeredGraph();
		Node<String> node = layeredGraph.getNode(name);

		Set<String> afferentCouplings = node.getAfferentCouplings();
		for (String afferent : afferentCouplings) {
			removeComponent(dependencies, afferent, exciseSourceName);
		}
	}

	private void removeProblemInteractions(DependencyTracker dependencies) {
		for (Interaction interaction : new ArrayList<Interaction>(this.messageSet.getInteractions().values())) {
			if (this.evaluator.shouldRemove(interaction)) {
				removeComponent(dependencies, interaction);
			}
		}
	}

	private void removeComponent(DependencyTracker dependencies, String name, String exciseSourceName) {
		TypeName typeName = new TypeName(name);
		HasDifferences removedItem = null;
		if (typeName.isInteraction()) {
			removedItem = this.messageSet.getInteractions().remove(name);
		} else if (typeName.isRoot()) {
			removedItem = removePackageLocation(name);
		} else {
			PackageLocation location = findPackageLocation(typeName);
			if (location != null) {
				removedItem = location.getMessageParts().remove(name);
			}
		}
		if (removedItem != null) {
			ExcisedItem excisedItem = new ExcisedItem(removedItem, exciseSourceName);
			if (this.removals.add(excisedItem)) {
				removeDependenciesOfComponent(dependencies, name, exciseSourceName);
				removeChoiceDependenciesOfComponent(dependencies, name);
			}
		}
	}

	private HasDifferences removePackageLocation(String name) {
		HasDifferences removedItem = this.messageSet.getPackageLocations().remove(name);
		if (removedItem != null) {
			this.removedPackageLocations.put(name, (PackageLocation) removedItem);
		}
		return removedItem;
	}

	private PackageLocation findPackageLocation(TypeName typeName) {
		String parentName = typeName.getParent().getName();
		PackageLocation location = this.messageSet.getPackageLocations().get(parentName);
		if (location == null) {
			location = this.removedPackageLocations.get(parentName);
		}
		return location;
	}

	private void removeChoiceDependenciesOfComponent(DependencyTracker dependencies, String name) {
		LayeredGraph<String> layeredGraph = dependencies.getChoiceLayeredGraph();
		Node<String> node = layeredGraph.getNode(name);
		
		if (node != null) {
			Set<String> afferentCouplings = node.getAfferentCouplings();
			for (String afferent : afferentCouplings) {
				removeChoiceReference(name, afferent);
			}
		}
	}

	private void removeChoiceReference(String name, String afferent) {
		TypeName typeName = new TypeName(afferent);
		if (typeName.isInteraction()) {
			Interaction interaction = this.messageSet.getInteractions().get(afferent);
			if (interaction != null) {
				removeChoiceComponentFromArguments(name, interaction.getArguments());
			}
		} else {
			MessagePart messagePart = this.messageSet.getMessagePart(afferent);
			if (messagePart != null) {
				removeChoiceReferenceFromMessagePart(name, messagePart);
			}
		}
	}

	private void removeChoiceReferenceFromMessagePart(String name, MessagePart messagePart) {
		if (messagePart.isAbstract()) {
			List<String> specializationChilds = messagePart.getSpecializationChilds();
			for (String child : new ArrayList<String>(specializationChilds)) {
				if (StringUtils.equals(name, child)) {
					specializationChilds.remove(child);
				}
			}
		} else {
			for (Relationship relationship : messagePart.getRelationships()) {
				List<Relationship> choices = relationship.getChoices();
				removeMatchingChoices(name, choices);
			}
		}
	}

	private void removeChoiceComponentFromArguments(String name, List<Argument> arguments) {
		for (Argument argument : arguments) {
			removeMatchingChoices(name, argument.getChoices());
			removeChoiceComponentFromArguments(name, argument.getArguments());
		}
	}

	private void removeMatchingChoices(String name, List<Relationship> choices) {
		for (Relationship choice : new ArrayList<Relationship>(choices)) {
			if (StringUtils.equals(name, choice.getType())) {
				choices.remove(choice);
			} else {
				removeMatchingChoices(name, choice.getChoices());
			}
		}
	}
}
