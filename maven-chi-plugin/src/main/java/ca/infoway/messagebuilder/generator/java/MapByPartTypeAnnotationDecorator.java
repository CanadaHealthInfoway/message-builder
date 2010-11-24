package ca.infoway.messagebuilder.generator.java;

import java.util.Set;

import ca.infoway.messagebuilder.generator.lang.Decorator;
import ca.infoway.messagebuilder.generator.lang.Indenter;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class MapByPartTypeAnnotationDecorator extends Indenter implements Decorator {

	private final BaseRelationship baseRelationship;
	private final ProgrammingLanguage programmingLanguage;
	private final int indentLevel;
	
	public MapByPartTypeAnnotationDecorator(int indent, BaseRelationship baseRelationship, ProgrammingLanguage programmingLanguage) {
		this.indentLevel = indent;
		this.baseRelationship = baseRelationship;
		this.programmingLanguage = programmingLanguage;
	}

	public String render() {
		return createMappingsString(this.baseRelationship.getMapByPartTypeMappings());
	}

	private String createMappingsString(Set<NameAndType> mappingsByPartType) {
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

	private String createMappingsForCsharp(Set<NameAndType> mappingsByPartType) {
		// FIXME - TM - handle CSHARP
		
		StringBuilder builder = new StringBuilder();
		indent(this.indentLevel, builder);
		builder.append("@Hl7MapByPartTypes({");
		boolean first = true;
		for (NameAndType nameAndType : mappingsByPartType) {
			if (!first) {
				builder.append(",\n");
				indent(this.indentLevel+1, builder);
			}
			builder.append("@Hl7MapByPartType(name=\"");
			builder.append(nameAndType.getName());
			builder.append(",type=\"");
			builder.append(nameAndType.getType());
			builder.append("\")");
			first = false;
		}
		builder.append("})");
		return builder.toString();
	}

	private String createMappingsForJava(Set<NameAndType> mappingsByPartType) {
		StringBuilder builder = new StringBuilder();
		indent(this.indentLevel, builder);
		builder.append("@Hl7MapByPartTypes({");
		boolean first = true;
		for (NameAndType nameAndType : mappingsByPartType) {
			if (!first) {
				builder.append(",\n");
				indent(this.indentLevel+1, builder);
			}
			
			builder.append("@Hl7MapByPartType(name=\"");
			builder.append(nameAndType.getName());
			builder.append("\",type=\"");
			builder.append(nameAndType.getType());
			builder.append("\")");
			first = false;
		}
		builder.append("})");
		return builder.toString();
	}

}
