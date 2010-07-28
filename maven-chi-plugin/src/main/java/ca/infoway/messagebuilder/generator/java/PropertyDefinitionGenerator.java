package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.lang.CodeTemplate;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

class PropertyDefinitionGenerator extends FieldTemplateProcessor {
	
	private static final String JAVA_PROPERTY_READ_DEFINITION = "@Hl7XmlMapping('{'{0}'}')\n" + 
			"public {8} get{2}() '{'\n" +
			"    {3}\n" +
			"'}'";
	private static final String JAVA_DERIVED_CHOICE_PROPERTY_DEFINITION =  
		"public {8} get{2}() '{'\n" +
		"    {3}\n" +
		"'}'\n\n" + 
		"public boolean has{2}() '{'\n" +
		"    {10}\n" +
		"'}'";
	private static final String CSHARP_DERIVED_CHOICE_HAS_PROPERTY_DEFINITION =
		"public bool Has{2}() '{'\n" +
		"    {10}\n" +
		"'}'";
	private static final String JAVA_INTERFACE_READ_DEFINITION = "public {8} get{2}();";
	private static final String CSHARP_ANNOTATION = "[Hl7XmlMappingAttribute(new string[] '{'{0}'}')]";
	private static final String CSHARP_PROPERTY_DEFINITION = "public {8} {2} '{'\n";
	private static final String CSHARP_PROPERTY_GETTER_DEFINITION = 
		"    get '{' {3} '}'";
	private static final String CSHARP_PROPERTY_SETTER_DEFINITION = 
			"    set '{' {5} '}'";
	private static final CodeTemplate CSHARP_READ_ONLY_PROPERTY = new CodeTemplate(CSHARP_ANNOTATION + "\n" + 
			CSHARP_PROPERTY_DEFINITION +
			CSHARP_PROPERTY_GETTER_DEFINITION + "\n" +
			"'}'");
	private static final CodeTemplate CSHARP_DERIVED_CHOICE_PROPERTY = new CodeTemplate( 
			CSHARP_PROPERTY_DEFINITION +
			CSHARP_PROPERTY_GETTER_DEFINITION + "\n" +
			"'}'\n\n" +
			CSHARP_DERIVED_CHOICE_HAS_PROPERTY_DEFINITION);
	private static final CodeTemplate CSHARP_READ_ONLY_INTERFACE = new CodeTemplate(CSHARP_ANNOTATION + "\n" + 
			"{8} {2} '{'\n" +
			"    get;\n" +
			"'}'");
	private static final CodeTemplate CSHARP_READ_WRITE_PROPERTY = new CodeTemplate(CSHARP_ANNOTATION + "\n" + 
			CSHARP_PROPERTY_DEFINITION +
			CSHARP_PROPERTY_GETTER_DEFINITION + "\n" +
			CSHARP_PROPERTY_SETTER_DEFINITION + "\n" +
			"'}'");
	private static final CodeTemplate CSHARP_READ_WRITE_INTERFACE = new CodeTemplate(CSHARP_ANNOTATION + "\n" + 
			"{8} {2} '{'\n" +
			"    get;\n" +
			"    set;\n" +
			"'}'");
	private static final CodeTemplate JAVA_READ_ONLY_PROPERTY = new CodeTemplate(JAVA_PROPERTY_READ_DEFINITION);
	private static final CodeTemplate JAVA_READ_ONLY_INTERFACE = new CodeTemplate(JAVA_INTERFACE_READ_DEFINITION);
	private static final CodeTemplate JAVA_READ_WRITE_INTERFACE = new CodeTemplate(JAVA_INTERFACE_READ_DEFINITION + "\n" +
			"public void set{2}({8} {4});");
	private static final CodeTemplate JAVA_READ_WRITE_PROPERTY = new CodeTemplate(JAVA_PROPERTY_READ_DEFINITION + "\n" +
			"public void set{2}({8} {4}) '{'\n" +
			"    {5}\n" +
			"'}'");
	private static final CodeTemplate JAVA_DERIVED_CHOICE_PROPERTY = new CodeTemplate(JAVA_DERIVED_CHOICE_PROPERTY_DEFINITION);
		
	private final ProgrammingLanguage language;

	PropertyDefinitionGenerator(FieldDefinition fieldDefinition, ProgrammingLanguage language) {
		super(fieldDefinition, language);
		this.language = language;
	}
	
	public void createPropertyDefinition(int indent, Writer writer, boolean isAbstract) throws IOException {
		write(chooseTemplate(isAbstract), indent, writer);
	}

	private CodeTemplate chooseTemplate(boolean isAbstract) {
		if (this.language.isJava()) {
			if (getFieldDefinition().isWritable()) {
				return isAbstract ? JAVA_READ_WRITE_INTERFACE : JAVA_READ_WRITE_PROPERTY;
			} else if (getFieldDefinition().isDerivedChoice()) {
				return JAVA_DERIVED_CHOICE_PROPERTY;
			} else {
				return isAbstract ? JAVA_READ_ONLY_INTERFACE : JAVA_READ_ONLY_PROPERTY;
			}
		} else {
			if (getFieldDefinition().isWritable()) {
				return isAbstract ? CSHARP_READ_WRITE_INTERFACE : CSHARP_READ_WRITE_PROPERTY;
			} else if (getFieldDefinition().isDerivedChoice()) {
				return CSHARP_DERIVED_CHOICE_PROPERTY;
			} else {
				return isAbstract ? CSHARP_READ_ONLY_INTERFACE : CSHARP_READ_ONLY_PROPERTY;
			}
		}
	}
}
