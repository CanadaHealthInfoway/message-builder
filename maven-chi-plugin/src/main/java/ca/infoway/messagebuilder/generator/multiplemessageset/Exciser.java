package ca.infoway.messagebuilder.generator.multiplemessageset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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

	private final MessageSet messageSet;
	private Set<String> removals = Collections.synchronizedSet(new HashSet<String>());

	public Exciser(MessageSet messageSet) {
		this.messageSet = messageSet;
	}

	public void execute() {
		DependencyManager<String> manager = buildUpDependencyMap();
		removeProblemDifferences(manager);
	}

	void removeProblemDifferences(DependencyManager<String> manager) {
		removeProblemInteractions(manager);
		removeProblemMessageParts(manager);
		removeProblemPackageLocations(manager);
	}

	private void removeProblemPackageLocations(DependencyManager<String> manager) {
		for (PackageLocation location : new ArrayList<PackageLocation>(this.messageSet.getPackageLocations().values())) {
			if (!isAllDifferencesOkay(location)) {
				removeComponent(manager, location);
			}
		}
	}

	private void removeComponent(DependencyManager<String> manager, Named named) {
		removeComponent(manager, named.getName());
	}

	private void removeProblemMessageParts(DependencyManager<String> manager) {
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
				removeComponent(manager, messagePart);
				removeDependenciesOfComponent(manager, messagePart.getName());
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

	private void removeDependenciesOfComponent(DependencyManager<String> manager, String name) {
		LayeredGraph<String> layeredGraph = manager.getLayeredGraph();
		Node<String> node = layeredGraph.getNode(name);

		Set<String> afferentCouplings = node.getAfferentCouplings();
		for (String afferent : afferentCouplings) {
			removeComponent(manager, afferent);
		}
	}

	private void removeProblemInteractions(DependencyManager<String> manager) {
		for (Interaction interaction : new ArrayList<Interaction>(this.messageSet.getInteractions().values())) {
			boolean ok = isAllDifferencesOkay(interaction);
			if (ok) {
				ok = checkArgumentsforOkayness(interaction.getArguments());
			}
			if (!ok) {
				removeComponent(manager, interaction);
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

	private void removeComponent(DependencyManager<String> manager, String name) {
		TypeName typeName = new TypeName(name);
		if (typeName.isInteraction()) {
			this.messageSet.getInteractions().remove(name);
		} else if (typeName.isRoot()) {
			this.messageSet.getPackageLocations().remove(name);
		} else {
			PackageLocation location = this.messageSet.getPackageLocations().get(typeName.getParent().getName());
			if (location != null) {
				location.getMessageParts().remove(name);
			}
		}
		if (this.removals.add(name)) {
			removeDependenciesOfComponent(manager, name);
		}
	}

	DependencyManager<String> buildUpDependencyMap() {
		DependencyManager<String> manager = new DependencyManager<String>();
		
		for (MessagePart messagePart : this.messageSet.getAllMessageParts()) {
			String name = messagePart.getName();
			manager.add(name);
			// we have decided to *not* add the reverse dependency of package location to root type 
			manager.add(name, new TypeName(name).getParent().getName());
			
			for (String child : messagePart.getSpecializationChilds()) {
				manager.add(child, name);
			}
			
			for (Relationship relationship : messagePart.getRelationships()) {
				if (relationship.isAssociation() 
						&& StringUtils.isNotBlank(relationship.getType())) {
					manager.add(name, relationship.getType());
				}
			}
		}
		
		for (Interaction interaction : this.messageSet.getInteractions().values()) {
			manager.add(interaction.getName(), interaction.getSuperTypeName());
			addArguments(manager, interaction, interaction.getArguments());
		}
		
		return manager;
	}

	private void addArguments(DependencyManager<String> manager, Interaction interaction, List<Argument> arguments) {
		for (Argument argument : arguments) {
			manager.add(interaction.getName(), argument.getName());
			addArguments(manager, interaction, argument.getArguments());
		}
	}
}
