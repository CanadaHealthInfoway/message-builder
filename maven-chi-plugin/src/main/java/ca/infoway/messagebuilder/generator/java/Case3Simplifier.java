package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.LogLevel.DEBUG;
import static ca.infoway.messagebuilder.generator.LogLevel.INFO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.LogUI;
import ca.infoway.messagebuilder.generator.java.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.marshalling.hl7.DomainTypeHelper;
import ca.infoway.messagebuilder.xml.TypeName;

public class Case3Simplifier {
	
	abstract class Case3MatcherFactory {
		public abstract Case3Matcher create(LogUI log, TypeProvider provider, Case3MergeResult result);
	}

	private LogUI log;
	private TypeAnalysisResult result;
	private Case3MergeResult mergeResult = new Case3MergeResult();
	private List<? extends Case3MatcherFactory> factories = Arrays.asList(
			new Case3MatcherFactory() {
				public Case3Matcher create(LogUI log, TypeProvider provider, Case3MergeResult result) {
					return new Case3ExactMatcher(log, provider, result);
				}
			},
			new Case3MatcherFactory() {
				public Case3Matcher create(LogUI log, TypeProvider provider, Case3MergeResult result) {
					return new Case3FuzzyMatcher(log, provider, result);
				}
			});
	
	
	public Case3Simplifier(LogUI log, TypeAnalysisResult result) {
		this.log = log;
		this.result = result;
	}
	public void execute() throws GeneratorException {
		createMatchResult();
		createMergedTypes();
		replaceReferencesWithMergedTypes();
	}
	private void replaceReferencesWithMergedTypes() {
		for (Type type : this.result.getAllMessageTypes()) {
			for (int i = 0, length = type.getRelationships().size(); i < length; i++) {
				BaseRelationship relationship = type.getRelationships().get(i);
				if (relationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
					// skip it... don't care
				} else if (relationship.isTemplateType()) {
					// also don't care
				} else {
					Association association = (Association) relationship;
					MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(association.getAssociationType().getName());
					if (descriptor != null) {
						Type mergedType = this.result.getTypes().get(descriptor.getNewName());
						association = new MergedAssociation(association, mergedType);
						type.getRelationships().remove(i);
						type.getRelationships().add(i, association);
					}
				}
			}
			
			for (TypeName interfaceType : new ArrayList<TypeName>(type.getInterfaceTypes())) {
				MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(interfaceType);
				if (descriptor != null) {
					type.getInterfaceTypes().remove(interfaceType);
					type.getInterfaceTypes().add(descriptor.getNewName());
				}
			}
		}
		for (InteractionType type : this.result.getAllInteractions()) {
			replaceParent(type);
			replaceArguments(type.getArguments());
		}
	}
	
	private void replaceParent(InteractionType type) {
		TypeName parentType = type.getParentType();
		MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(parentType);
		if (descriptor != null) {
			type.setParentType(descriptor.getNewName());
		}
	}
	
	private void replaceArguments(List<ArgumentType> arguments) {
		
		for (int i = 0, length = arguments == null ? 0 : arguments.size(); i < length; i++) {
			ArgumentType argument = arguments.get(i);
			MergedTypeDescriptor descriptor = this.mergeResult.getDescriptorByName(argument.getType());
			if (descriptor != null) {
				ArgumentType replacement = new ArgumentType(argument.getArgument(), descriptor.getNewName());
				replacement.getArgumentTypes().addAll(argument.getArgumentTypes());
				arguments.set(i, replacement);
			}
			replaceArguments(arguments.get(i).getArgumentTypes());
		}
	}
	
	private void createMergedTypes() {
		for (MergedTypeDescriptor descriptor : this.mergeResult.getDescriptors()) {
			Type mergedType = new Type(descriptor.getNewName());
			for (TypeName name : descriptor.getMergedTypes()) {
				Type originalType = this.result.getTypes().get(name);
				mergedType.getMergedTypes().add(name);
				for (BaseRelationship relationship : originalType.getRelationships()) {
					BaseRelationship storedRelationship = mergedType.getRelationship(relationship.getName());
					if (storedRelationship == null) {
						mergedType.getRelationships().add(relationship);
					} else if (storedRelationship.hasDomainType()) {
						// use the relationship that has the compatible type 
						String compatibleDomainType = DomainTypeHelper.getCompatibleDomainType(storedRelationship.getRelationship(), relationship.getRelationship());
						if (compatibleDomainType == null) {
							throw new IllegalStateException("Could not find compatible domain type for merging types: " + storedRelationship.getType() + ", " + relationship.getType());
						} else if (!DomainTypeHelper.hasDomainType(storedRelationship.getRelationship(), compatibleDomainType)) {
							// switch stored relationship
							this.log.log(DEBUG, "Simplification case 3: Switching domain type to be more compatible for merging types: " + storedRelationship.getType() + ", " + relationship.getType());
							int index = mergedType.getRelationships().indexOf(storedRelationship);
							mergedType.getRelationships().set(index, relationship);
						}
					}
				}
				// TODO: BCH: javadoc, etc.
				if (originalType.isAbstract()) {
					mergedType.setAbstract(true);
				}
				if (originalType.isRootType()) {
					mergedType.setRootType(originalType.isRootType());
				}
				mergedType.getChildTypes().addAll(this.mergeResult.substituteAll(originalType.getChildTypes()));
				mergedType.getInterfaceTypes().addAll(this.mergeResult.substituteAll(originalType.getInterfaceTypes()));
				
				this.result.removeType(originalType, mergedType);
			}
			this.result.addType(mergedType);
		}
	}
	
	/**
	 * <p>Walk through each of the matching approaches to populate the merge result.
	 * 
	 * <p>First, we look for exact matches, progressively matching each type against
	 * all possible other types until matching produces no changes.
	 */
	private void createMatchResult() {
		for (Case3MatcherFactory factory : this.factories) {
			createMatchResult(factory);
		}
	}
	private void createMatchResult(Case3MatcherFactory factory) {
		SortedTypeProvider provider = new SortedTypeProvider(this.result);
		this.mergeResult.initialize(this.result);
		boolean repeat = false;
		do {
			repeat = false;
			Case3Matcher matcher = factory.create(this.log, provider, this.mergeResult);
			this.log.log(INFO, "Simplification case 3: " + matcher.getDescription());
			for (Type type : provider.getAllMessageTypes()) {
				boolean changes = matcher.performMatching(type);
				this.log.log(DEBUG, "Simplification case 3: Now analyzing " + type.getName() + ". " +
						(changes ? "Candidate for simplification" : ""));
				repeat |= changes;
			}
		} while (repeat);
	}
}
