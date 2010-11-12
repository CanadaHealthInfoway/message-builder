package ca.infoway.messagebuilder.generator.java;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ClassUtils;

import ca.infoway.messagebuilder.generator.lang.Decorator;
import ca.infoway.messagebuilder.generator.lang.Indenter;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class MapByPartTypeAnnotationDecorator extends Indenter implements Decorator {

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
	private final int indentLevel;
	
	private boolean print = true;

	public MapByPartTypeAnnotationDecorator(int indent, BaseRelationship baseRelationship, ProgrammingLanguage programmingLanguage) {
		this.indentLevel = indent;
		this.baseRelationship = baseRelationship;
		this.programmingLanguage = programmingLanguage;
	}

	public String render() {
		String mappingsString = "";
		
		if (isInlined(this.baseRelationship)) {
			List<NameAndType> mappingsByPartType = createMappings(new ArrayList<NameAndType>(), this.baseRelationship);
			this.print = false;
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
			builder.append(nameAndType.name);
			builder.append(",type=\"");
			builder.append(nameAndType.type);
			builder.append("\")");
			first = false;
		}
		builder.append("})");
		return builder.toString();
	}

	private String createMappingsForJava(List<NameAndType> mappingsByPartType) {
		StringBuilder builder = new StringBuilder();
		indent(this.indentLevel, builder);
		builder.append("@Hl7MapByPartTypes({");
		StringBuilder mappingPath = new StringBuilder();
		String mappingSeparator = "";
		boolean first = true;
		for (NameAndType nameAndType : mappingsByPartType) {
			if (!first) {
				builder.append(",\n");
				indent(this.indentLevel+1, builder);
			}
			mappingPath.append(mappingSeparator).append(nameAndType.name);
			mappingSeparator = "/"; 
			
			builder.append("@Hl7MapByPartType(name=\"");
			builder.append(mappingPath);
			builder.append("\",type=\"");
			builder.append(nameAndType.type);
			builder.append("\")");
			first = false;
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
			
			if (baseRelationship.getOriginalType().endsWith(".Manufacturer")) {
				this.print = true;
			}
			
			list.add(new NameAndType(baseRelationship.getName(), baseRelationship.getOriginalType()));
		} else {
			// do nothing (attributes are ignored)
		}
		
		if (this.print) {
			System.out.println("Mapping   >>>> " + ClassUtils.getShortClassName(baseRelationship.getClass()));
			System.out.println("Name      >>>> " + baseRelationship.getName());
			System.out.println("Type      >>>> " + baseRelationship.getType());
			System.out.println("Orig.Type >>>> " + baseRelationship.getOriginalType());
			if (baseRelationship instanceof InlinedAssociation) {
				System.out.println("Orig.Type >>>> " + ((InlinedAssociation) baseRelationship).getElidedRelationship().getType());
			}
			System.out.println();
		}
		
		return list;
	}

	private boolean isInlined(BaseRelationship baseRelationship) {
		return baseRelationship instanceof InlinedAssociation || baseRelationship instanceof InlinedAttribute;
	}

}
