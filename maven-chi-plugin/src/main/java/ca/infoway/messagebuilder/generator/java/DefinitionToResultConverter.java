package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.infoway.messagebuilder.generator.TypeConverter;
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

		Set<String> mergedTypeNames = new HashSet<String>();
		for (SimplifiableType type : this.definitions.getAllTypes()) {
			if (type.isMerged()) {
				mergedTypeNames.add(type.getMergedTypeName());
			}
		}
		
		for (String name : mergedTypeNames) {
			Type mergedType = this.types.get(name);
			MergedTypeCollator collator = new MergedTypeCollator();
			for (TypeName typeName : mergedType.getMergedTypes()) {
				
				Type originalType = this.types.get(typeName.getName());
				mergedType.getMergedTypes().add(typeName);
				for (BaseRelationship relationship : originalType.getRelationships()) {
					collator.addRelationship(originalType.getName(), relationship);
				}
				
				// Old TODO: BCH: javadoc, etc.
				if (originalType.isAbstract()) {
					mergedType.setAbstract(true);
				}
				if (originalType.isRootType()) {
					mergedType.setRootType(originalType.isRootType());
				}
				// TODO: restore this...
//				mergedType.getChildTypes().addAll(this.mergeResult.substituteAll(originalType.getChildTypes()));
//				mergedType.getInterfaceTypes().addAll(this.mergeResult.substituteAll(originalType.getInterfaceTypes()));
			}
		}
	}

	private void handleInlining(Type type) {
		for (BaseRelationship relationship : new ArrayList<BaseRelationship>(type.getRelationships())) {
			if (isInlined(relationship)) {
				inline(type, relationship);
			} else if (isMerged(relationship)) {
				// TM: TODO: create a MergedAssociation with the merged type
				System.out.println("Need to handle merges some time soon.  Doofus.");
			}
		}
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
			} else if (simplifiableType.isMerged()) {
				if (!this.types.containsKey(simplifiableType.getMergedTypeName())) {
					Type mergedType = new Type(new TypeName(simplifiableType.getMergedTypeName()));
					this.types.put(simplifiableType.getMergedTypeName(), mergedType);
				}
				Type mergedType = this.types.get(simplifiableType.getMergedTypeName());
				// TM: TODO: child types, javadoc, interface names, etc.
				mergedType.getMergedTypes().add(type.getName());
			} else {
				result.addType(type);
			}
		}
	}
}
