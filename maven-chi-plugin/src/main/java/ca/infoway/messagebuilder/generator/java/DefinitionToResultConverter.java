package ca.infoway.messagebuilder.generator.java;

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.generator.TypeConverter;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

public class DefinitionToResultConverter {
	
	private TypeConverter converter = new TypeConverter();
	private Map<String,Type> types = new HashMap<String,Type>();

	public TypeAnalysisResult convert(SimplifiableDefinitions definitions) {
		TypeAnalysisResult result = new TypeAnalysisResult();
		createAllTypes(definitions, result);
		createAllRelationships(definitions, result);
		return result;
	}

	private void createAllRelationships(SimplifiableDefinitions definitions,
			TypeAnalysisResult result) {
		for (SimplifiableType simplifiableType : definitions.getAllTypes()) {
			TemplateVariableGenerator generator = new TemplateVariableGenerator();
			Type type = result.getTypeByName(new TypeName(simplifiableType.getName()));
			if (type != null) {
				for (SimplifiableRelationship simplifiableRelationship : simplifiableType.getRelationships()) {
					Relationship relationship = simplifiableRelationship.getRelationship();
					
					// TODO: handle relationships that have been inlined or merged...
					if (relationship.isAttribute()) {
						type.getRelationships().add(new Attribute(relationship, this.converter.convertToType(relationship)));
					} else if (relationship.isTemplateRelationship()) {
						type.getRelationships().add(Association.createTemplateAssociation(
								relationship, generator.getNext(relationship), 0));
					} else {
						Type relationshipType = result.getTypeByName(new TypeName(relationship.getType()));
						type.getRelationships().add(Association.createStandardAssociation(
								relationship, relationshipType, 0));
					}
				}
			}
		}		
	}

	private void createAllTypes(SimplifiableDefinitions definitions, 
			TypeAnalysisResult result) {
		for (SimplifiableType simplifiableType : definitions.getAllTypes()) {
			Type type = new Type(new TypeName(simplifiableType.getName()), simplifiableType.isRootType());
			this.types.put(simplifiableType.getName(), type);
			if (!simplifiableType.isInlined() && !simplifiableType.isMerged()) {
				result.addType(type);
			}
		}
	}
}
