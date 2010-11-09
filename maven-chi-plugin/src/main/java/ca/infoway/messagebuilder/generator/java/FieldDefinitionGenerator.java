package ca.infoway.messagebuilder.generator.java;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.C_SHARP;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.lang.CodeTemplate;

class FieldDefinitionGenerator extends FieldTemplateProcessor {
	
	private static final CodeTemplate C_SHARP_PROPERTY_CONSTRUCTOR_INITIALIZATION = new CodeTemplate("this.{4} = new {6}({7});");
	private static final CodeTemplate C_SHARP_FIELD_DECLARATION = new CodeTemplate("private {1} {4};");
	private static final CodeTemplate JAVA_INITIALIZED_FIELD_DECLARATION = new CodeTemplate("private {1} {4} = new {6}({7});");
	private static final CodeTemplate JAVA_FIELD_DECLARATION = new CodeTemplate("private {1} {4};");
	
	FieldDefinitionGenerator(FieldDefinition fieldDefinition) {
		super(fieldDefinition);
	}
	
	public void createConstructorInitialization(int indent, Writer writer) throws IOException {
		if (getFieldDefinition().getProgrammingLanguage() == C_SHARP) {
			write(C_SHARP_PROPERTY_CONSTRUCTOR_INITIALIZATION, indent, writer);
		}
	}
	public void createFieldDeclaration(int indent, Writer writer) throws IOException {
		if (getFieldDefinition().getProgrammingLanguage() == C_SHARP) {
			write(C_SHARP_FIELD_DECLARATION, indent, writer);
		} else if (getFieldDefinition().isInitializedAtConstructionTime()) {
			write(JAVA_INITIALIZED_FIELD_DECLARATION, indent, writer);
		} else {
			write(JAVA_FIELD_DECLARATION, indent, writer);
		}
	}
}
