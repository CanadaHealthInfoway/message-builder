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
 * Last modified: $LastChangedDate: 2013-05-13 20:54:55 -0400 (Mon, 13 May 2013) $
 * Revision:      $LastChangedRevision: 6862 $
 */

package ca.infoway.messagebuilder.generator.lang;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import ca.infoway.messagebuilder.GeneratorException;
import ca.infoway.messagebuilder.NamedType;
import ca.infoway.messagebuilder.generator.LogLevel;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.lang.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.generator.util.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.Annotation;
import ca.infoway.messagebuilder.xml.Argument;
import ca.infoway.messagebuilder.xml.Documentation;
import ca.infoway.messagebuilder.xml.Interaction;
import ca.infoway.messagebuilder.xml.MessagePart;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

class DefinitionToResultConverter {
	
	private TypeConverter converter;
	Map<String,Type> types = new HashMap<String,Type>();
	private final SimplifiableDefinitions definitions;
	private final String basePackageName;
	private final ProgrammingLanguage programmingLanguage;
	private final OutputUI outputUI;
	private final NamingPolicy namingPolicy;
	private final boolean isCda;

	DefinitionToResultConverter(SimplifiableDefinitions definitions,
			String basePackageName, ProgrammingLanguage programmingLanguage, OutputUI outputUI,
			NamingPolicy namingPolicy, boolean isR2, boolean isCda) {
		this.definitions = definitions;
		this.basePackageName = basePackageName;
		this.programmingLanguage = programmingLanguage;
		this.outputUI = outputUI;
		this.namingPolicy = namingPolicy;
		this.converter = new TypeConverter(isR2);
		this.isCda = isCda;
	}

	public TypeAnalysisResult convert() throws GeneratorException {
		TypeAnalysisResult result = new TypeAnalysisResult();
		reassessInlining(result);
		createAllTypes(result);  // should also create packages
		createAllRelationships(result);
		createAllHierarchies(result);
		createInteractions(result);
		createLanguageSpecificNames(result);
		return result;
	}

	protected void reassessInlining(TypeAnalysisResult result) {
		for (SimplifiableType parentType : this.definitions.getAllTypes()) {
			// check anything with potential for merging
			if (!parentType.getMergedWithTypes().isEmpty()) {

				boolean isNewCase = !parentType.isMerged();
				
				for (SimplifiableRelationship relationship : parentType.getRelationships()) {
					SimplifiableType childType = relationship.getType();
					// can't check isMerged here, as it will always report false when inlined; need to check if it has merged with any other types
					if (relationship.isAssociation() && childType != null && childType.isInlined() && childType.getMergedWithTypes().size() > 0) {
						boolean allInlined = true;
						for (SimplifiableType simplifiableType : childType.getMergedWithTypes()) {
							allInlined &= simplifiableType.isInlined();
						}
						if (!allInlined) {
							for (SimplifiableType simplifiableType : childType.getMergedWithTypes()) {
								String logMessage = (isNewCase ? "[new case] " : "") + "Rejected inlining for ParentType: " +  parentType.getTypeName()
										+ " inlining type:" + simplifiableType.getTypeName()
										+ " relationship:" + relationship.getRelationship().getName()
										+ " conformance:" + relationship.getRelationship().getConformance()
										+ " cardinality:" + relationship.getRelationship().getCardinality();
								if (simplifiableType.isInlined()) {
									simplifiableType.setInlined(false);
									logMessage += " because parent and child types are merged, and not all merged child types inline";
								} else {
									logMessage += " but this type wasn't inlined to begin with";
								}
								this.outputUI.log(LogLevel.INFO, logMessage);
							}
						}
					}
				}
			}
		}
	}

	private void createAllHierarchies(TypeAnalysisResult result) {
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = this.types.get(simplifiableType.getName());
			if (simplifiableType.isMerged()) {
				Type mergedType = this.types.get(simplifiableType.getMergedTypeName().getName());
				for (TypeName typeName : convertAll(collectAllInterfaceNames(simplifiableType))) {
					Type interfaceType = result.getTypeByName(typeName);
					if (interfaceType != null) {
						type.getInterfaceTypes().add(interfaceType);
						mergedType.getInterfaceTypes().add(interfaceType);
					}
				}
				for (TypeName typeName : convertAllNames(collectAllChildNames(simplifiableType))) {
					Type childType = result.getTypeByName(typeName);
					if (childType != null) {
						type.getChildTypes().add(childType);
						mergedType.getChildTypes().add(childType);
					}
				}
			} else {
				for (TypeName typeName : convertAll(simplifiableType.getInterfaceTypes())) {
					Type interfaceType = result.getTypeByName(typeName);
					if (interfaceType != null) {
						type.getInterfaceTypes().add(result.getTypeByName(typeName));
					}
				}
				for (TypeName typeName : convertAllNames(simplifiableType.getChildTypes())) {
					Type interfaceType = result.getTypeByName(typeName);
					if (interfaceType != null) {
						type.getChildTypes().add(result.getTypeByName(typeName));
					}
				}
			}
		}		
	}

	private Set<String> collectAllInterfaceNames(SimplifiableType simplifiableType) {
		Set<String> result = new HashSet<String>();
		result.addAll(simplifiableType.getInterfaceTypes());
		for (SimplifiableType type : simplifiableType.getMergedWithTypes()) {
			if (!type.isInlined()) {
				result.addAll(type.getInterfaceTypes());
			}
		}
		return result;
	}

	private Set<TypeName> collectAllChildNames(SimplifiableType simplifiableType) {
		Set<TypeName> result = new HashSet<TypeName>();
		result.addAll(simplifiableType.getChildTypes());
		for (SimplifiableType type : simplifiableType.getMergedWithTypes()) {
			if (!type.isInlined()) {
				result.addAll(type.getChildTypes());
			}
		}
		return result;
	}

	private void createLanguageSpecificNames(TypeAnalysisResult result) {
		SimpleNameTranslator translator = new SimpleNameTranslator(this.programmingLanguage, this.basePackageName, result, this.namingPolicy, this.isCda);
		for (Type type : result.getAllMessageTypes()) {
			type.setLanguageSpecificName(translator.getLanguageSpecificName(type.getTypeName()));
		}
		for (Type type : result.getAllInteractions()) {
			type.setLanguageSpecificName(translator.getLanguageSpecificName(type.getTypeName()));
		}
	}

	private void createAllRelationships(TypeAnalysisResult result) throws GeneratorException {
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = this.types.get(simplifiableType.getName());
			for (Map.Entry<Fingerprint, Collection<SimplifiableRelationship>> entry : simplifiableType.getMatchedRelationships().entrySet()) {
				BaseRelationship relationship = createRelationship(result, entry.getValue());
				if (relationship != null) {
					type.getRelationships().add(relationship);
				}
			}
		}
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = this.types.get(simplifiableType.getName());
			if (type != null) {
				handleInlining(type);
			}
		}
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = this.types.get(simplifiableType.getName());
			if (type != null) {
				handleMerging(type);
			}
		}

		createRelationshipsForAllMergedTypes();
	}

	void createRelationshipsForAllMergedTypes() {
		for (TypeName name : getAllMergedTypes()) {
			Type mergedType = this.types.get(name.getName());
			MergedTypeCollator collator = createCollator(mergedType);
			
			for (Fingerprint fingerprint : collator.relationshipNames()) {
				BaseRelationship exemplar = collator.getExemplar(fingerprint);
				if (exemplar.getRelationshipType() == RelationshipType.ATTRIBUTE) {
					mergedType.getRelationships().add(
							new Case3SimplifiedAttribute((Attribute) exemplar, 
									collator.getRelationships(fingerprint)));
				} else {
					mergedType.getRelationships().add(
							new Case3SimplifiedAssociation((Association) exemplar, 
									collator.getRelationships(fingerprint)));
				}
			}
			
			Map<String, Integer> duplicationXmlName = new HashMap<String, Integer>();
			for (BaseRelationship relationship : mergedType.getRelationships()) {
				for (String xmlName : relationship.getAllXmlMappings()) {
					if (duplicationXmlName.containsKey(xmlName)) {
						duplicationXmlName.put(xmlName, duplicationXmlName.get(xmlName) + 1);
					} else {
						duplicationXmlName.put(xmlName, 1);
					}
				}
			}
			for (Map.Entry<String, Integer> entry : duplicationXmlName.entrySet()) {
				if (entry.getValue() > 1) {
					for (BaseRelationship relationship : mergedType.getRelationships()) {
						if (Arrays.asList(relationship.getAllXmlMappings()).contains(entry.getKey())) {
							((MergedRelationshipSupport) relationship).markMapByPartTypeRequired();
						}
					}
				}
			}
		}
	}

	private BaseRelationship createRelationship(TypeAnalysisResult result,
			Collection<SimplifiableRelationship> value) {
		
		if (value.size() == 1) {
			return createRelationship(result, (SimplifiableRelationship) CollectionUtils.get(value, 0));
		} else {
			Association relationship = null;
			List<BaseRelationship> relationships = new ArrayList<BaseRelationship>();
			for (SimplifiableRelationship simplifiableRelationship : value) {
				BaseRelationship temp = createRelationship(result, simplifiableRelationship);
				if (temp != null) {
					if (!(temp instanceof Association)) {
						throw new GeneratorException("Expected an association, but was : " + temp.getClass());
					} else if (relationship == null) {
						relationship = (Association) temp;
					}
					relationships.add(temp);
				}
			}
			
			return new Case3SimplifiedAssociation(relationship, relationships);
		}
	}

	private BaseRelationship createRelationship(TypeAnalysisResult result,
			SimplifiableRelationship simplifiableRelationship) {
		return createRelationship(result, simplifiableRelationship.getRelationship());
	}

	MergedTypeCollator createCollator(Type mergedType) {
		MergedTypeCollator collator = new MergedTypeCollator();
		for (NamedType typeName : mergedType.getMergedTypes()) {
			Type originalType = this.types.get(typeName.getTypeName().getName());
			for (BaseRelationship relationship : originalType.getRelationships()) {
				collator.addRelationship(originalType.getTypeName(), relationship);
			}
		}
		return collator;
	}

	private Set<TypeName> getAllMergedTypes() {
		Set<TypeName> mergedTypeNames = new HashSet<TypeName>();
		for (SimplifiableType type : this.definitions.getAllTypes()) {
			if (type.isMerged()) {
				mergedTypeNames.add(type.getMergedTypeName());
			}
		}
		return mergedTypeNames;
	}

	private Set<TypeName> convertAll(Set<String> interfaceTypes) {
		Set<TypeName> result = new HashSet<TypeName>();
		for (String string : interfaceTypes) {
			TypeName typeNameForType = getTypeNameForType(string);
			if (typeNameForType != null) {
				result.add(typeNameForType);
			}
		}
		return result;
	}

	private Set<TypeName> convertAllNames(Set<TypeName> interfaceTypes) {
		Set<TypeName> result = new HashSet<TypeName>();
		for (TypeName typeName : interfaceTypes) {
			TypeName typeNameForType = getTypeNameForType(typeName.getName());
			if (typeNameForType != null) {
				result.add(typeNameForType);
			}
		}
		return result;
	}
	
	private void handleInlining(Type type) throws GeneratorException {
		for (BaseRelationship relationship : new ArrayList<BaseRelationship>(type.getRelationships())) {
			if (isInlined(type, relationship) && !isAlreadyInlined(relationship)) {
				inline(type, relationship);
			}
		}
	}

	private boolean isAlreadyInlined(BaseRelationship relationship) {
		return relationship instanceof InlinedAssociation || relationship instanceof InlinedAttribute;
	}

	private void handleMerging(Type type) {
		for (BaseRelationship relationship : new ArrayList<BaseRelationship>(type.getRelationships())) {
			if (isMerged(type, relationship)) {
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

	private boolean isMerged(Type containingType, BaseRelationship relationship) {
		if (relationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
			return false;
		} else if (((Association) relationship).isTemplateType()) {
			return false;
		} else {
			SimplifiableType type = this.definitions.getType(relationship.getType());
			if (type == null) {
				this.outputUI.log(LogLevel.ERROR, "Cannot find type: " + 
						relationship.getType() + " used by " + 
						containingType.getTypeName() + "." + 
						relationship.getName());
				return false;
			} else {
				boolean merged = type.isMerged();
				if (!merged && !type.isInlined() && !type.getMergedWithTypes().isEmpty()) {
					int count = 0;
					for (SimplifiableType typeMerged : type.getMergedWithTypes()) {
						count += typeMerged.isInlined() ? 0 : 1;
					}
					if (count == 1) {
						this.outputUI.log(LogLevel.INFO, "Not merging type when only 1 type in merge list: " + type.getTypeName());
					}
				}
				return merged;
			}
		}
	}

	private void inline(Type type, BaseRelationship relationship) throws GeneratorException {
		// don't need to worry about inlining a merged type - merging has not been handled yet
		int index = type.getRelationships().indexOf(relationship);
		Type elidedType = this.types.get(relationship.getType());
		if (isIndicatorBean(elidedType, relationship)) {
			// should be ok to fix TypeConverter to non-R2 (even if it is R2)
			Attribute newRelationship = new Attribute(relationship.getRelationship(), new TypeConverter(false).convertToType("BL", null), true);
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

	private boolean isIndicatorBean(Type elidedType, BaseRelationship relationship) throws GeneratorException {
		SimplifiableType type = this.definitions.getType(elidedType.getTypeName().getName());
		if (type == null) {
			throw new GeneratorException("Could not find type " + elidedType.getTypeName().getName() + " when trying to determine if is indicator bean");
		}
		return type.isIndicator() && !relationship.isMandatory();
	}

	private boolean isInlined(Type containingType, BaseRelationship relationship) {
		if (relationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
			return false;
		} else if (((Association) relationship).isTemplateType()) {
			return false;
		} else {
			SimplifiableType type = this.definitions.getType(relationship.getType());
			if (type == null) {
				System.out.println("Cannot find type: " + 
						relationship.getType() + " used by " + 
						containingType.getTypeName() + "." + 
						relationship.getName());
				return false;
			} else {
				return type.isInlined();
			}
		}
	}

	private BaseRelationship createRelationship(TypeAnalysisResult result, 
			Relationship relationship) {
		if (relationship.isAttribute()) {
			return new Attribute(relationship, this.converter.convertToType(relationship));
		} else if (relationship.isTemplateRelationship()) {
			return Association.createTemplateAssociation(
					relationship, new TemplateVariableGenerator().getNext(relationship));
		} else {
			Type relationshipType = this.types.get(relationship.getType());
			if (relationshipType == null) {
				// TODO: BCH: hacky-tricky handling of abstract types with relationships
				return null;
			} else {
				List<Choice> choiceTypes = createChoiceTypes(new ArrayList<Choice>(), relationship, result);
				return Association.createStandardAssociation(
						relationship, relationshipType, choiceTypes);
			}
		}
	}

	private List<Choice> createChoiceTypes(List<Choice> choiceTypes, Relationship relationship, TypeAnalysisResult result) {
		if (relationship.isChoice()) {
			List<Relationship> choices = relationship.getChoices();
			for (Relationship choiceRelationship : choices) {
				createChoiceTypes(choiceTypes, choiceRelationship, result);
				TypeName typeName = getTypeNameForType(choiceRelationship.getType());
				choiceTypes.add(new Choice(choiceRelationship.getName(), result.getTypeByName(typeName)));
			}
		}
		return choiceTypes;
	}

	private void createAllTypes(TypeAnalysisResult result) {
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = new Type(simplifiableType.getTypeName(), simplifiableType.isRootType());	// Experiment
			this.types.put(simplifiableType.getName(), type);
			type.setMergedName(simplifiableType.getMergedTypeName());
			type.setBusinessName(simplifiableType.getBusinessName());
			type.setCdaDocumentRoot(simplifiableType.isCdaDocumentRoot());
			if (simplifiableType.isInlined() && simplifiableType.getInterfaceTypes().isEmpty()) {
				// skip it
			} else {
				MessagePart messagePart = simplifiableType.getMessagePart();
				if (messagePart.getDocumentation() != null) {
					if(!isEmpty(messagePart.getDocumentation().getAnnotations())) {
						type.setTypeDocumentation(new TypeDocumentation(messagePart.getDocumentation()));
					}
				}
				if (simplifiableType.isMerged()) {
					Type mergedType = createMergedType(simplifiableType, type);
					
					if (result.getTypeByName(mergedType.getTypeName()) == null) {
						result.addType(mergedType);
					}
				} else {
					type.setCategory(simplifiableType.getCategory());
					type.setAbstract(messagePart.isAbstract());
					result.addType(type);
				}
			}
		}
	}

	private Type createMergedType(SimplifiableType simplifiableType, Type type) {
		TypeName mergedTypeName = simplifiableType.getMergedTypeName();
		if (!this.types.containsKey(mergedTypeName.getName())) {
			Type mergedType = new Type(mergedTypeName);
			assignCategoryIfSame(simplifiableType, mergedType);
			this.types.put(mergedTypeName.getName(), mergedType);
		}
		Type mergedType = this.types.get(mergedTypeName.getName());
		mergedType.getMergedTypes().add(type);

		List<Type> typeList = new ArrayList<Type>();
		Set<NamedType> mergedTypes = mergedType.getMergedTypes();
		for (NamedType namedType : mergedTypes) {
			typeList.add((Type) namedType);
		}
		
		// this will re-calculate the merged docs every time a new type is merged in
		MergedDocumentation mergedDocumentation = new MergedDocumentation(typeList);
		mergedType.setBusinessName(mergedDocumentation.getBusinessName());
		mergedType.setTypeDocumentation(new TypeDocumentation(mergedDocumentation));
		
		MessagePart messagePart = simplifiableType.getMessagePart();
		if (messagePart.isAbstract()) {
			mergedType.setAbstract(true);
		}
		if (simplifiableType.isRootType()) {
			mergedType.setRootType(true);
		}
		return mergedType;
	}

	private void assignCategoryIfSame(SimplifiableType simplifiableType, Type mergedType) {
		Set<String> categories = new HashSet<String>();
		categories.add(simplifiableType.getCategory());
		for (SimplifiableType otherType : simplifiableType.getMergedWithTypes()) {
			categories.add(otherType.getCategory());
		}
		if (categories.size() == 1) {
			mergedType.setCategory((String) CollectionUtils.get(categories, 0));
		}
	}
	
	private void createInteractions(TypeAnalysisResult result) {
		for (SimplifiableInteraction simplifiableInteraction : this.definitions.getAllInteractions()) {
			Interaction interaction = simplifiableInteraction.getInteraction();

			// TM - CDA - hack to pass in the fact this type name defines an interaction
			InteractionType interactionType = new InteractionType(new TypeName(interaction.getName(), true));
			
			TypeName parentTypeName = getTypeNameForType(interaction.getSuperTypeName());
			
			interactionType.setParentType(result.getTypeByName(parentTypeName));
			
			Documentation interactionDocumentation = addAdditionalDocsToInteraction(interaction);
			interactionType.setTypeDocumentation(new TypeDocumentation(interactionDocumentation));
			
			interactionType.setBusinessName(interaction.getBusinessName());
			interactionType.getArguments().addAll(groupArgumentsAndTypes(interaction.getArguments()));
			interactionType.setCda(this.isCda);
			result.getTypes().put(interactionType.getTypeName(), interactionType);
		}
	}

	private Documentation addAdditionalDocsToInteraction(Interaction interaction) {
		List<Annotation> extraDocs = createExtraDocInformation(interaction);
		Documentation interactionDocumentation = interaction.getDocumentation();
		if (interactionDocumentation == null) {
			interactionDocumentation = new Documentation();
		}
		boolean hasBusinessName = interactionDocumentation.getBusinessName() != null;
		interactionDocumentation.setBusinessName(interaction.getName() + (hasBusinessName ? (": " + interactionDocumentation.getBusinessName()) : ""));
		interactionDocumentation.getAnnotations().addAll(extraDocs);
		return interactionDocumentation;
	}

	private List<Annotation> createExtraDocInformation(Interaction interaction) {
		List<Annotation> extraDocs = new ArrayList<Annotation>();
		extraDocs.add(new Annotation("Message: " + interaction.getSuperTypeName()));
		for (Argument argument : interaction.getArguments()) {
			extraDocs.add(new Annotation("Control Act: " + argument.getName()));
			for (Relationship choice : argument.getChoices()) {
				extraDocs.add(new Annotation("----&gt; Control Act Choice: " + choice.getType()));
			}
			for (Argument subArg : argument.getArguments()) {
				extraDocs.add(new Annotation("--&gt; Payload: " + subArg.getName()));
				for (Relationship choice : subArg.getChoices()) {
					extraDocs.add(new Annotation("----&gt; Payload Choice: " + choice.getType()));
				}
			}
		}
		return extraDocs;
	}

	private TypeName getTypeNameForType(String type) {
		SimplifiableType simplifiableType = this.definitions.getType(type);
		if (simplifiableType == null) {
			return null;
		} else {
			return simplifiableType.isMerged() 
					? simplifiableType.getMergedTypeName() : new TypeName(simplifiableType.getName());
		}
	}

	private List<ArgumentType> groupArgumentsAndTypes(List<Argument> arguments) {
		List<ArgumentType> result = new ArrayList<ArgumentType>();
		for (Argument argument : arguments) {
			TypeName typeName = getTypeNameForType(argument.getName());
			ArgumentType argumentType = new ArgumentType(argument, typeName);
			argumentType.getArgumentTypes().addAll(groupArgumentsAndTypes(argument.getArguments()));
			result.add(argumentType);
		}
		return result;
	}
	
	protected SimplifiableDefinitions getDefinitions() {
		return this.definitions;
	}
	
	protected OutputUI getOutputUI() {
		return this.outputUI;
	}
	
}
