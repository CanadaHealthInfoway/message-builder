package ca.infoway.messagebuilder.generator.java;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.generator.lang.TypeDocumentation;
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
	
	public TypeAnalysisResult convert() {
		TypeAnalysisResult result = new TypeAnalysisResult();
		createAllTypes(result);
		createAllRelationships(result);
		return result;
	}

	private void createAllRelationships(TypeAnalysisResult result) {
		for (SimplifiableType simplifiableType : this.definitions.getAllTypes()) {
			Type type = this.types.get(simplifiableType.getName());
			for (SimplifiableRelationship simplifiableRelationship : simplifiableType.getRelationships()) {
				type.getRelationships().add(createRelationship(result, simplifiableRelationship.getRelationship()));
			}
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

		Set<String> mergedTypeNames = new HashSet<String>();
		for (SimplifiableType type : this.definitions.getAllTypes()) {
			if (type.isMerged()) {
				mergedTypeNames.add(type.getMergedTypeName());
			}
		}
		
		for (String name : mergedTypeNames) {
			if (this.types.containsKey(name)) {
				System.out.println("found type: " + name);
				Type mergedType = this.types.get(name);
				MergedTypeCollator collator = new MergedTypeCollator();
				for (TypeName typeName : mergedType.getMergedTypes()) {
					
					Type originalType = this.types.get(typeName.getName());
					mergedType.getMergedTypes().add(typeName);
					for (BaseRelationship relationship : originalType.getRelationships()) {
						collator.addRelationship(originalType.getName(), relationship);
					}
					
					// TODO: restore this...
//					mergedType.getChildTypes().addAll(this.mergeResult.substituteAll(originalType.getChildTypes()));
//					mergedType.getInterfaceTypes().addAll(this.mergeResult.substituteAll(originalType.getInterfaceTypes()));
				}
				
				for (String relationshipName : collator.relationshipNames()) {
					BaseRelationship exemplar = collator.getExemplar(relationshipName);
					mergedType.getRelationships().add(exemplar);
				}
			} else {
				System.out.println("did NOT find type: " + name);
			}
		}
	}

	private void handleInlining(Type type) {
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
		String mergedTypeName = this.definitions.getType(relationship.getType()).getMergedTypeName();
		Type mergedType = this.types.get(mergedTypeName);
		BaseRelationship mergedAssociation = new MergedAssociation((Association) relationship, mergedType);
		int index = type.getRelationships().indexOf(relationship);
		type.getRelationships().remove(index);
		type.getRelationships().add(index, mergedAssociation);
	}

	private boolean isMerged(BaseRelationship relationship) {
		if (relationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
			return false;
		} else if (((Association) relationship).isTemplateType()) {
			return false;
		} else {
			return this.definitions.getType(relationship.getType()).isMerged();
		}
	}

	private void inline(Type type, BaseRelationship relationship) {
		int index = type.getRelationships().indexOf(relationship);
		Type elidedType = this.types.get(relationship.getType());
		handleInlining(elidedType); // and merging???
		for (BaseRelationship subRelationship : elidedType.getRelationships()) {
			if (subRelationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
				type.getRelationships().add(index++, new InlinedAttribute((Attribute) subRelationship, relationship));
			} else {
				type.getRelationships().add(index++, new InlinedAssociation((Association) subRelationship, relationship));
			}
		}
		type.getRelationships().remove(relationship);
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
			Type relationshipType = result.getTypeByName(new TypeName(relationship.getType()));
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
					String mergedTypeName = simplifiableType.getMergedTypeName();
					if (!this.types.containsKey(mergedTypeName)) {
						Type mergedType = new Type(new TypeName(mergedTypeName));
						this.types.put(mergedTypeName, mergedType);
					}
					Type mergedType = this.types.get(mergedTypeName);
					mergedType.getMergedTypes().add(type.getName());
					
					// TM - TODO: how to merge business name/documentation? (wasn't being done in pre-refactor merge code)
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
					
					if (result.getTypeByName(mergedType.getName()) == null) {
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
}
