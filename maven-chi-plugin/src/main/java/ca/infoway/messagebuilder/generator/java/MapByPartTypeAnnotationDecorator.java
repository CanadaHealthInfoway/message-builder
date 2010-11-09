package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.generator.lang.Decorator;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class MapByPartTypeAnnotationDecorator implements Decorator {

	static class NameAndType {
		final String name;
		final String type;

		public NameAndType(String name, String type) {
			this.name = name;
			this.type = type;
		}
	}
	
	private final BaseRelationship baseRelationship;
	private final ProgrammingLanguage programmingLanguage;

	public MapByPartTypeAnnotationDecorator(BaseRelationship baseRelationship, ProgrammingLanguage programmingLanguage) {
		this.baseRelationship = baseRelationship;
		this.programmingLanguage = programmingLanguage;
	}

	public String render() {
		String mappingsString = "";
		
		if (isInlined(this.baseRelationship)) {
			List<NameAndType> mappingsByPartType = createMappings(new ArrayList<NameAndType>(), this.baseRelationship);
			mappingsString = createMappingsString(mappingsByPartType);
		}

		return mappingsString;
	}

	private String createMappingsString(List<NameAndType> mappingsByPartType) {
		String result = null;
		switch (this.programmingLanguage) {
		case JAVA:
			result = createMappingsForJava(mappingsByPartType);
			break;
		case C_SHARP:
			result = createMappingsForCsharp(mappingsByPartType);
			break;
		default:
			throw new IllegalStateException(this.getClass().getSimpleName() + " currently only works with Java or CSharp.");
		}
		return result;
	}

	private String createMappingsForCsharp(List<NameAndType> mappingsByPartType) {
		// FIXME - TM - handle CSHARP
		
		StringBuilder builder = new StringBuilder("@Hl7MapByPartTypes({");
		String comma = "";
		for (NameAndType nameAndType : mappingsByPartType) {
			builder.append(comma);
			builder.append("@Hl7MapByPartType(name=\"");
			builder.append(nameAndType.name);
			builder.append(",type=\"");
			builder.append(nameAndType.type);
			builder.append("\")");
			comma = ",";
		}
		builder.append("})");
		return builder.toString();
	}

	private String createMappingsForJava(List<NameAndType> mappingsByPartType) {
		StringBuilder builder = new StringBuilder("@Hl7MapByPartTypes({");
		StringBuilder mappingPath = new StringBuilder();
		String comma = "";
		String mappingSeparator = "";
		for (NameAndType nameAndType : mappingsByPartType) {
			mappingPath.append(mappingSeparator).append(nameAndType.name);
			mappingSeparator = "/"; 
			
			builder.append(comma);
			builder.append("@Hl7MapByPartType(name=\"");
			builder.append(mappingPath);
			builder.append("\",type=\"");
			builder.append(nameAndType.type);
			builder.append("\")");
			comma = ",";
		}
		builder.append("})");
		return builder.toString();
	}

	private List<NameAndType> createMappings(ArrayList<NameAndType> list, BaseRelationship baseRelationship) {
		if (baseRelationship instanceof InlinedAssociation) {
			InlinedAssociation inlinedAssociation = (InlinedAssociation) baseRelationship;
			createMappings(list, inlinedAssociation.getElidedRelationship());
			createMappings(list, inlinedAssociation.getInlinedRelationship());
		} else if (baseRelationship instanceof InlinedAttribute) {
			InlinedAttribute inlinedAttribute = (InlinedAttribute) baseRelationship;
			createMappings(list, inlinedAttribute.getElidedRelationship());
			createMappings(list, inlinedAttribute.getInlinedRelationship());
		} else if (baseRelationship instanceof Association) {
			list.add(new NameAndType(baseRelationship.getName(), baseRelationship.getType()));
		} else {
			// do nothing (attributes are ignored)
		}
		return list;
	}

	private boolean isInlined(BaseRelationship baseRelationship) {
		return baseRelationship instanceof InlinedAssociation || baseRelationship instanceof InlinedAttribute;
	}

}
