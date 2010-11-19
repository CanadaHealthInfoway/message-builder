package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.JAVA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.infoway.messagebuilder.generator.java.InteractionType.ArgumentType;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.xml.TypeName;

public class ImportTypeUtil {
	
	private static Set<Object> getImports(InteractionType type, ProgrammingLanguage language) {
		Set<Object> importTypes = new HashSet<Object>();
		if (language == ProgrammingLanguage.C_SHARP) {
			importTypes.add("Ca.Infoway.Messagebuilder.Annotation.Hl7PartTypeMapping");
			importTypes.add("Ca.Infoway.Messagebuilder.Model.IInteraction");
		} else {
			importTypes.add("ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping");
			importTypes.add("ca.infoway.messagebuilder.model.InteractionBean");
		}
		TypeName parentTypeName = ((InteractionType) type).getParentType();
		if (parentTypeName != null) {
			importTypes.add(parentTypeName);
		}
		addArgumentTypes(importTypes, type.getArguments());
		return importTypes;
	}
	private static void addArgumentTypes(Set<Object> importTypes,
			List<ArgumentType> arguments) {
		for (ArgumentType argument : arguments) {
			importTypes.add(argument.getType());
			addArgumentTypes(importTypes, argument.getArgumentTypes());
		}
	}
	private static Set<Object> getImports(Type type, ProgrammingLanguage language) {
		
		Set<Object> importTypes = new HashSet<Object>();
		
		importTypes.add("ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping");
		if (!type.isAbstract()) {
			importTypes.add(language == JAVA 
					? "ca.infoway.messagebuilder.model.MessagePartBean" 
					: "Ca.Infoway.Messagebuilder.Model.MessagePartBean"); // TODO: BCH: remove 'Bean'
		}
		if (type.isRootType()) {
			importTypes.add("ca.infoway.messagebuilder.annotation.Hl7RootType");
		}
		
		// add imports for all relationships, even if type is abstract
		for (BaseRelationship relationship : type.getRelationships()) {
			if (!relationship.isFixed()) {
				importTypes.addAll(relationship.getImportTypes());
			}
		}
		
		importTypes.addAll(type.getInterfaceTypes());
		return importTypes;
	}

	public static Set<Object> getImports(RenderedType type, ProgrammingLanguage language) {
		if (type instanceof InteractionType) {
			return getImports((InteractionType) type, language);
		} else if (type instanceof Type) {
			return getImports((Type) type, language);
		} else {
			throw new IllegalArgumentException("RenderedType is not supported");
		}
	}
}
