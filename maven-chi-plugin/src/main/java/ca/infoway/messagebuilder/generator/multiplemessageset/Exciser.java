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
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Difference;
import ca.infoway.messagebuilder.xml.HasDifferences;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.PackageLocation;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;
import ca.intelliware.commons.dependency.DependencyManager;
import ca.intelliware.commons.dependency.LayeredGraph;
import ca.intelliware.commons.dependency.Node;

public class Exciser {

	class DependencyContainer {
		DependencyManager<String> manager;
		DependencyManager<String> choiceManager;
		
		public DependencyContainer(DependencyManager<String> manager, DependencyManager<String> choiceManager) {
			this.manager = manager;
			this.choiceManager = choiceManager;
		}
	}
	
	private final MessageSet messageSet;
	private Set<ExcisedItem> removals = Collections.synchronizedSet(new HashSet<ExcisedItem>());
	private Map<String, PackageLocation> removedPackageLocations = Collections.synchronizedMap(new HashMap<String, PackageLocation>()); 

	public Exciser(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public Set<ExcisedItem> execute() {
		DependencyContainer dependencies = buildUpDependencyMap();
		removeProblemDifferences(dependencies);
		return this.removals;
	}

	void removeProblemDifferences(DependencyContainer dependencies) {
		removeProblemInteractions(dependencies);
		removeProblemMessageParts(dependencies);
		removeProblemPackageLocations(dependencies);
	}

	private void removeProblemPackageLocations(DependencyContainer dependencies) {
		for (PackageLocation location : new ArrayList<PackageLocation>(this.messageSet.getPackageLocations().values())) {
			if (!isAllDifferencesOkay(location)) {
				removeComponent(dependencies, location);
			}
		}
	}

	private void removeComponent(DependencyContainer dependencies, Named named) {
		removeComponent(dependencies, named.getName(), named.getName());
	}

	private void removeProblemMessageParts(DependencyContainer dependencies) {
		for (MessagePart messagePart : this.messageSet.getAllMessageParts()) {
			boolean ok = isAllDifferencesOkay(messagePart);
			
			if (ok) {
				for (Relationship relationship : messagePart.getRelationships()) {
					ok &= isAllDifferencesOkay(relationship);
					if (ok) {
						ok &= checkChoicesForOkayness(relationship.getChoices());
					} else {
						break;
					}
				}
			}
			
			if (!ok) {
				removeComponent(dependencies, messagePart);
			}
		}
	}

	private boolean checkChoicesForOkayness(List<Relationship> choices) {
		boolean ok = true;
		for (Relationship relationship : choices) {
			ok &= isAllDifferencesOkay(relationship);
			if (ok) {
				ok &= checkChoicesForOkayness(relationship.getChoices());
			} else {
				break;
			}
		}
		return ok;
	}

	private void removeDependenciesOfComponent(DependencyContainer dependencies, String name, String exciseSourceName) {
		LayeredGraph<String> layeredGraph = dependencies.manager.getLayeredGraph();
		Node<String> node = layeredGraph.getNode(name);

		Set<String> afferentCouplings = node.getAfferentCouplings();
		for (String afferent : afferentCouplings) {
			removeComponent(dependencies, afferent, exciseSourceName);
		}
	}

	private void removeProblemInteractions(DependencyContainer dependencies) {
		for (Interaction interaction : new ArrayList<Interaction>(this.messageSet.getInteractions().values())) {
			boolean ok = isAllDifferencesOkay(interaction);
			if (ok) {
				ok = checkArgumentsforOkayness(interaction.getArguments());
			}
			if (!ok) {
				removeComponent(dependencies, interaction);
			}
		}
	}

	private boolean checkArgumentsforOkayness(List<Argument> arguments) {
		boolean ok = true;
		for (Argument argument : arguments) {
			ok &= isAllDifferencesOkay(argument);
			if (ok) {
				ok &= checkArgumentsforOkayness(argument.getArguments());
			} else {
				break;
			}
			
		}
		return ok;
	}

	private boolean isAllDifferencesOkay(HasDifferences differences) {
		boolean ok = true;
		
		for (Difference difference : differences.getDifferences()) {
			if (!difference.isOk()) {
				ok = false;
				break;
			}
		}
		return ok;
	}

	private void removeComponent(DependencyContainer dependencies, String name, String exciseSourceName) {
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

	private void removeChoiceDependenciesOfComponent(DependencyContainer dependencies, String name) {
		LayeredGraph<String> layeredGraph = dependencies.choiceManager.getLayeredGraph();
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

	DependencyContainer buildUpDependencyMap() {
		DependencyManager<String> manager = new DependencyManager<String>();
		DependencyManager<String> choiceManager = new DependencyManager<String>();
		DependencyContainer dependencies = new DependencyContainer(manager, choiceManager);
		
		for (MessagePart messagePart : this.messageSet.getAllMessageParts()) {
			String name = messagePart.getName();
			manager.add(name);
			// we have decided to *not* add the reverse dependency of package location to root type 
			manager.add(name, new TypeName(name).getParent().getName());
			
			for (String child : messagePart.getSpecializationChilds()) {
				manager.add(child, name);
				choiceManager.add(name, child);
			}
			
			for (Relationship relationship : messagePart.getRelationships()) {
				if (relationship.isAssociation() 
						&& StringUtils.isNotBlank(relationship.getType())) {
					manager.add(name, relationship.getType());
					List<Relationship> choices = relationship.getChoices();
					buildChoiceDependencies(choiceManager, name, choices);
				}
			}
		}
		
		for (Interaction interaction : this.messageSet.getInteractions().values()) {
			manager.add(interaction.getName(), interaction.getSuperTypeName());
			addArguments(dependencies, interaction, interaction.getArguments());
		}
		
		return dependencies;
	}

	private void buildChoiceDependencies(DependencyManager<String> choiceManager, String name, List<Relationship> choices) {
		for (Relationship choice : choices) {
			choiceManager.add(name, choice.getType());
			buildChoiceDependencies(choiceManager, name, choice.getChoices());
		}
	}

	private void addArguments(DependencyContainer dependencies, Interaction interaction, List<Argument> arguments) {
		for (Argument argument : arguments) {
			dependencies.manager.add(interaction.getName(), argument.getName());
			addArguments(dependencies, interaction, argument.getArguments());
			buildChoiceDependencies(dependencies.choiceManager, interaction.getName(), argument.getChoices());
		}
	}
}
