package ca.infoway.messagebuilder.generator.dependency;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.java.SimplifiableDefinitions;
import ca.infoway.messagebuilder.generator.java.SimplifiableInteraction;
import ca.infoway.messagebuilder.generator.java.SimplifiableType;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.Relationship;
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
		
		for (String child : messagePart.getSpecializationChilds()) {
			// Do NOT add dependency from implementors to interface
			// otherwise removing an interface type could remove a huge number of components
			//manager.add(child, name);  
			this.choiceManager.add(name, child);
		}
		
		for (Relationship relationship : messagePart.getRelationships()) {
			if (relationship.isAssociation() 
					&& StringUtils.isNotBlank(relationship.getType())) {
				this.manager.add(name, relationship.getType());
				List<Relationship> choices = relationship.getChoices();
				buildChoiceDependencies(this.choiceManager, name, choices);
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
