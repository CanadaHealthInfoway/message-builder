package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.java.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.generator.lang.TypeDocumentation;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

class DefinitionToResultConverter {
	
	private TypeConverter converter = new TypeConverter();
	private Map<String,Type> types = new HashMap<String,Type>();
	private final SimplifiableDefinitions definitions;

	DefinitionToResultConverter(SimplifiableDefinitions definitions) {
		this.definitions = definitions;
	}
	
	public TypeAnalysisResult convert() throws GeneratorException {
		TypeAnalysisResult result = new TypeAnalysisResult();
		createAllTypes(result);  // should also create packages
		createAllRelationships(result);
		createInteractions(result);
		
		return result;
	}

	private void createAllRelationships(TypeAnalysisResult result) throws GeneratorException {
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = this.types.get(simplifiableType.getName());
			for (SimplifiableRelationship simplifiableRelationship : simplifiableType.getRelationships()) {
				type.getRelationships().add(createRelationship(result, simplifiableRelationship.getRelationship()));
			}
			for (String typeName : simplifiableType.getInterfaceTypes()) {
				type.getInterfaceTypes().add(new TypeName(typeName));
			}
			type.getChildTypes().addAll(simplifiableType.getChildTypes());
		}
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = result.getTypeByName(new TypeName(simplifiableType.getName()));
			if (type != null) {
				handleInlining(type);
			}
		}
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = result.getTypeByName(new TypeName(simplifiableType.getName()));
			if (type != null) {
				handleMerging(type);
			}
		}

		Set<TypeName> mergedTypeNames = new HashSet<TypeName>();
		for (SimplifiableType type : this.definitions.getAllTypes()) {
			if (type.isMerged()) {
				mergedTypeNames.add(type.getMergedTypeName());
			}
		}
		
		for (TypeName name : mergedTypeNames) {
			Type mergedType = this.types.get(name.getName());
			MergedTypeCollator collator = new MergedTypeCollator();
			for (NamedType typeName : mergedType.getMergedTypes()) {
				Type originalType = this.types.get(typeName.getTypeName().getName());
				for (BaseRelationship relationship : originalType.getRelationships()) {
					collator.addRelationship(originalType.getTypeName(), relationship);
				}
				
				mergedType.getChildTypes().addAll(substituteAll(originalType.getChildTypes()));
				mergedType.getInterfaceTypes().addAll(substituteAll(originalType.getInterfaceTypes()));
			}
			
			for (String relationshipName : collator.relationshipNames()) {
				BaseRelationship exemplar = collator.getExemplar(relationshipName);
				mergedType.getRelationships().add(exemplar);
			}
		}
	}

	private Collection<TypeName> substituteAll(Set<TypeName> typeNames) {
		Set<TypeName> result = new HashSet<TypeName>();
		for (TypeName typeName : typeNames) {
			SimplifiableType type = this.definitions.getType(typeName.getName());
			result.add(type.isMerged() ? type.getMergedTypeName() : typeName);
		}
		return result;
	}

	private void handleInlining(Type type) throws GeneratorException {
		for (BaseRelationship relationship : new ArrayList<BaseRelationship>(type.getRelationships())) {
			if (isInlined(relationship)) {
				inline(type, relationship);
			}
		}
	}

	private void handleMerging(Type type) {
		for (BaseRelationship relationship : new ArrayList<BaseRelationship>(type.getRelationships())) {
			if (isMerged(relationship)) {
				merge(type, relationship);
			}
		}
	}

	private void merge(Type type, BaseRelationship relationship) {
		TypeName mergedTypeName = this.definitions.getType(relationship.getType()).getMergedTypeName();
		Type mergedType = this.types.get(mergedTypeName.getName());
		BaseRelationship mergedAssociation = new MergedAssociation((Association) relationship, mergedType);
		int index = type.getRelationships().indexOf(relationship);
		type.getRelationships().set(index, mergedAssociation);
	}

	private boolean isMerged(BaseRelationship relationship) {
		if (relationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
			return false;
		} else if (((Association) relationship).isTemplateType()) {
			return false;
		} else {
			SimplifiableType type = this.definitions.getType(relationship.getType());
			return type.isMerged();
		}
	}

	private void inline(Type type, BaseRelationship relationship) throws GeneratorException {
		// don't need to worry about inlining a merged type - merging has not been handled yet
		int index = type.getRelationships().indexOf(relationship);
		Type elidedType = this.types.get(relationship.getType());
		if (isIndicatorBean(elidedType)) {
			Attribute newRelationship = new Attribute(relationship.getRelationship(), new TypeConverter().convertToType("BL", null), true);
			type.getRelationships().set(index, newRelationship);
		} else {
			handleInlining(elidedType); 
			for (BaseRelationship subRelationship : elidedType.getRelationships()) {
				if (subRelationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
					type.getRelationships().add(index++, new InlinedAttribute((Attribute) subRelationship, relationship));
				} else {
					type.getRelationships().add(index++, new InlinedAssociation((Association) subRelationship, relationship));
				}
			}
			type.getRelationships().remove(relationship);
		}
	}

	private boolean isIndicatorBean(Type elidedType) throws GeneratorException {
		SimplifiableType type = this.definitions.getType(elidedType.getTypeName().getName());
		if (type == null) {
			throw new GeneratorException("Could not find type " + elidedType.getTypeName().getName() + " when trying to determine if is indicator bean");
		}
		return type.isIndicator();
	}

	private boolean isInlined(BaseRelationship relationship) {
		if (relationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
			return false;
		} else if (((Association) relationship).isTemplateType()) {
			return false;
		} else {
			return this.definitions.getType(relationship.getType()).isInlined();
		}
	}

	private BaseRelationship createRelationship(TypeAnalysisResult result, 
			Relationship relationship) {
		if (relationship.isAttribute()) {
			return new Attribute(relationship, this.converter.convertToType(relationship));
		} else if (relationship.isTemplateRelationship()) {
			return Association.createTemplateAssociation(
					relationship, new TemplateVariableGenerator().getNext(relationship), 0);
		} else {
			Type relationshipType = this.types.get(relationship.getType());
			return Association.createStandardAssociation(
					relationship, relationshipType, 0);
		}
	}

	private void createAllTypes(TypeAnalysisResult result) {
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = new Type(new TypeName(simplifiableType.getName()), simplifiableType.isRootType());
			this.types.put(simplifiableType.getName(), type);
			if (simplifiableType.isInlined()) {
				// skip it
			} else {
				MessagePart messagePart = simplifiableType.getMessagePart();
				if (simplifiableType.isMerged()) {
					TypeName mergedTypeName = simplifiableType.getMergedTypeName();
					if (!this.types.containsKey(mergedTypeName.getName())) {
						Type mergedType = new Type(mergedTypeName);
						this.types.put(mergedTypeName.getName(), mergedType);
					}
					Type mergedType = this.types.get(mergedTypeName.getName());
					mergedType.getMergedTypes().add(type);
					
					// TM - TODO: how to merge business name/documentation? 
					//            (wasn't being done in pre-refactor merge code)
					// mergedType.setBusinessName(businessName);
					// mergedType.setTypeDocumentation(description);
					
					// no category when merged (?)
					// mergedType.setCategory(null); 
					
					if (messagePart.isAbstract()) {
						mergedType.setAbstract(true);
					}
					if (simplifiableType.isRootType()) {
						mergedType.setRootType(true);
					}
					
					if (result.getTypeByName(mergedType.getTypeName()) == null) {
						result.addType(mergedType);
					}
				} else {
					type.setCategory(simplifiableType.getCategory());
					if (messagePart.getDocumentation() != null) {
						type.setBusinessName(messagePart.getDocumentation().getBusinessName());
						if(!isEmpty(messagePart.getDocumentation().getParagraphs())) {
							type.setTypeDocumentation(new TypeDocumentation(messagePart.getDocumentation()));
						}
					}
					type.setAbstract(messagePart.isAbstract());
					result.addType(type);
				}
			}
		}
	}
	
	private void createInteractions(TypeAnalysisResult result) {
		for (SimplifiableInteraction simplifiableInteraction : this.definitions.getAllInteractions()) {
			Interaction interaction = simplifiableInteraction.getInteraction();
			InteractionType interactionType = new InteractionType(new TypeName(interaction.getName()));
			
			SimplifiableType simplifiableType = this.definitions.getType(interaction.getSuperTypeName());
			TypeName parentTypeName = simplifiableType.isMerged() 
					? simplifiableType.getMergedTypeName() : new TypeName(simplifiableType.getName());
			
			interactionType.setParentType(parentTypeName);
			interactionType.setTypeDocumentation(new TypeDocumentation(interaction.getDocumentation()));
			interactionType.setBusinessName(interaction.getBusinessName());
			interactionType.getArguments().addAll(groupArgumentsAndTypes(interaction.getArguments()));
			result.getTypes().put(interactionType.getTypeName(), interactionType);
		}
	}

	private List<ArgumentType> groupArgumentsAndTypes(List<Argument> arguments) {
		List<ArgumentType> result = new ArrayList<ArgumentType>();
		for (Argument argument : arguments) {
			SimplifiableType simplifiableType = this.definitions.getType(argument.getName());
			TypeName typeName = simplifiableType.isMerged() 
					? simplifiableType.getMergedTypeName() : new TypeName(simplifiableType.getName());
			
			ArgumentType argumentType = new ArgumentType(argument, typeName);
			argumentType.getArgumentTypes().addAll(groupArgumentsAndTypes(argument.getArguments()));
			result.add(argumentType);
		}
		return result;
	}
	
}
