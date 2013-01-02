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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator.java;

import java.io.IOException;
import java.io.Writer;

import ca.infoway.messagebuilder.generator.lang.CodeTemplate;

class PropertyDefinitionGenerator extends FieldTemplateProcessor {
	
	private static final String JAVA_PROPERTY_READ_DEFINITION = "@Hl7XmlMapping('{'{0}'}'){11}\n" + 
			"public {8} get{2}() '{'\n" +
			"    {3}\n" +
			"'}'";
	private static final String JAVA_PROPERTY_WRITE_DEFINITION =  
			"public void set{2}({8} {4}) '{'\n" +
			"    {5}\n" +
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
	private static final String JAVA_INTERFACE_WRITE_DEFINITION = "public void set{2}({8} {4});";
	
	private static final String CSHARP_ANNOTATION = "[Hl7XmlMappingAttribute(new string[] '{'{0}'}')]{11}\n";
	private static final String CSHARP_PROPERTY_DEFINITION = "public {8} {2} '{'\n";
	private static final String CSHARP_PROPERTY_GETTER_DEFINITION = 
		"    get '{' {3} '}'";
	private static final String CSHARP_PROPERTY_SETTER_DEFINITION = 
			"    set '{' {5} '}'";
	private static final CodeTemplate CSHARP_READ_ONLY_PROPERTY = new CodeTemplate(CSHARP_ANNOTATION + 
			CSHARP_PROPERTY_DEFINITION +
			CSHARP_PROPERTY_GETTER_DEFINITION + "\n" +
			"'}'");
	private static final CodeTemplate CSHARP_DERIVED_CHOICE_PROPERTY = new CodeTemplate( 
			CSHARP_PROPERTY_DEFINITION +
			CSHARP_PROPERTY_GETTER_DEFINITION + "\n" +
			"'}'\n\n" +
			CSHARP_DERIVED_CHOICE_HAS_PROPERTY_DEFINITION);
	private static final CodeTemplate CSHARP_READ_ONLY_INTERFACE = new CodeTemplate(CSHARP_ANNOTATION + 
			"{8} {2} '{'\n" +
			"    get;\n" +
			"'}'");
	private static final CodeTemplate CSHARP_READ_WRITE_PROPERTY = new CodeTemplate(CSHARP_ANNOTATION + 
			CSHARP_PROPERTY_DEFINITION +
			CSHARP_PROPERTY_GETTER_DEFINITION + "\n" +
			CSHARP_PROPERTY_SETTER_DEFINITION + "\n" +
			"'}'");
	private static final CodeTemplate CSHARP_READ_WRITE_INTERFACE = new CodeTemplate(CSHARP_ANNOTATION + 
			"{8} {2} '{'\n" +
			"    get;\n" +
			"    set;\n" +
			"'}'");
	private static final CodeTemplate JAVA_READ_ONLY_PROPERTY = new CodeTemplate(JAVA_PROPERTY_READ_DEFINITION);
	private static final CodeTemplate JAVA_READ_ONLY_INTERFACE = new CodeTemplate(JAVA_INTERFACE_READ_DEFINITION);
	private static final CodeTemplate JAVA_WRITE_PROPERTY = new CodeTemplate(JAVA_PROPERTY_WRITE_DEFINITION);
	private static final CodeTemplate JAVA_WRITE_INTERFACE = new CodeTemplate(JAVA_INTERFACE_WRITE_DEFINITION);
	private static final CodeTemplate JAVA_READ_WRITE_INTERFACE = new CodeTemplate(JAVA_INTERFACE_READ_DEFINITION + "\n" +
			JAVA_INTERFACE_WRITE_DEFINITION);
	private static final CodeTemplate JAVA_READ_WRITE_PROPERTY = new CodeTemplate(JAVA_PROPERTY_READ_DEFINITION + "\n" +
			JAVA_PROPERTY_WRITE_DEFINITION);
	private static final CodeTemplate JAVA_DERIVED_CHOICE_PROPERTY = new CodeTemplate(JAVA_DERIVED_CHOICE_PROPERTY_DEFINITION);
		
	PropertyDefinitionGenerator(FieldDefinition fieldDefinition) {
		super(fieldDefinition);
	}
	
	public void createPropertyDefinition(int indent, Writer writer, boolean isAbstract) throws IOException {
		write(chooseTemplate(isAbstract), indent, writer);
	}

	public void createGetterPropertyDefinition(int indent, Writer writer, boolean isAbstract) throws IOException {
		write(chooseGetterTemplate(isAbstract), indent, writer);
	}

	public void createSetterPropertyDefinition(int indent, Writer writer, boolean isAbstract) throws IOException {
		write(chooseSetterTemplate(isAbstract), indent, writer);
	}

	private CodeTemplate chooseTemplate(boolean isAbstract) {
		if (getFieldDefinition().getProgrammingLanguage().isJava()) {
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
	
	private CodeTemplate chooseGetterTemplate(boolean isAbstract) {
		if (getFieldDefinition().getProgrammingLanguage().isJava()) {
			if (getFieldDefinition().isDerivedChoice()) {
				return JAVA_DERIVED_CHOICE_PROPERTY;
			} else {
				return isAbstract ? JAVA_READ_ONLY_INTERFACE : JAVA_READ_ONLY_PROPERTY;
			}
		} else {
			if (getFieldDefinition().isDerivedChoice()) {
				return CSHARP_DERIVED_CHOICE_PROPERTY;
			} else {
				return isAbstract ? CSHARP_READ_ONLY_INTERFACE : CSHARP_READ_ONLY_PROPERTY;
			}
		}
	}
	
	private CodeTemplate chooseSetterTemplate(boolean isAbstract) {
		if (getFieldDefinition().getProgrammingLanguage().isJava()) {
			if (getFieldDefinition().isWritable()) {
				return isAbstract ? JAVA_WRITE_INTERFACE : JAVA_WRITE_PROPERTY;
			} else {
				// should not get here
				throw new UnsupportedOperationException("Can't choose a setter template for a non-writable property");
			}
		} else {
			// doesn't make sense from c# perspective
			throw new UnsupportedOperationException("Can't choose a setter-only template for c#");
		}
	}
	
}
