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

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.C_SHARP;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.generator.lang.CodeTemplate;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

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
	
	@Override
	String generateMapByPartTypeAnnotations(int indent, String[] xmlPathName, BaseRelationship baseRelationship, ProgrammingLanguage programmingLanguage) {
		return StringUtils.EMPTY;
	}
}
