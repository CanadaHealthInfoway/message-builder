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
import java.text.MessageFormat;

import ca.infoway.messagebuilder.generator.lang.CodeTemplate;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;
import ca.infoway.messagebuilder.generator.lang.StringArrayToAnnotationDecorator;

abstract class FieldTemplateProcessor {

	private final FieldDefinition fieldDefinition;

	public FieldTemplateProcessor(FieldDefinition fieldDefinition) {
		this.fieldDefinition = fieldDefinition;
	}

	protected void write(CodeTemplate template, int indent, Writer writer) throws IOException {
		template.write(writer, indent, 
				decorate(this.fieldDefinition.getXmlPathName()),
				this.fieldDefinition.getFieldType(),
				this.fieldDefinition.getCapitalizedPropertyName(),
				populate(this.fieldDefinition.getGetterBodyStyle()),
				this.fieldDefinition.getFieldName(),
				populate(this.fieldDefinition.getSetterBodyStyle()),
				this.fieldDefinition.getFieldImplementationType(),
				this.fieldDefinition.getInitializationArguments(),
				this.fieldDefinition.getPropertyType(),
				this.fieldDefinition.getPropertyElementImplementationType(),
				populate(this.fieldDefinition.getDerivedChoiceHasBodyStyle()),
				generateMapByPartTypeAnnotations(indent, this.fieldDefinition.getXmlPathName(),
						 this.fieldDefinition.getBaseRelationship(), 
						 this.fieldDefinition.getProgrammingLanguage())
				);
	}

	protected String populate(MethodBody body) {
		if (body == null) {
			return "";
		} else {
			return MessageFormat.format(body.getBodyFormat(this.fieldDefinition.getProgrammingLanguage()), 
					this.fieldDefinition.getFieldName(), 
					this.fieldDefinition.getFieldName(),
					this.fieldDefinition.getFieldElementImplementationType(),
					this.fieldDefinition.getPropertyElementImplementationType(),
					this.fieldDefinition.getCollectionOfCodedPropertyElementType(),
					this.fieldDefinition.getFieldElementType(),
					this.fieldDefinition.getPropertyType());
		}
	}

	private String decorate(String[] strings) {
		return new StringArrayToAnnotationDecorator(strings).render();
	}

	String generateMapByPartTypeAnnotations(int indent, String[] xmlPathName, BaseRelationship baseRelationship, ProgrammingLanguage programmingLanguage) {
		return new MapByPartTypeAnnotationDecorator(indent, baseRelationship, programmingLanguage).render();
	}

	protected FieldDefinition getFieldDefinition() {
		return this.fieldDefinition;
	}
}
