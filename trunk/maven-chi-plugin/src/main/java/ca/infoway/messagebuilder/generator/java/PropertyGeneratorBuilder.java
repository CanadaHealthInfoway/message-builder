/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import ca.infoway.messagebuilder.generator.lang.Indenter;
import ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage;

public class PropertyGeneratorBuilder extends Indenter {

	private PropertyTypeProvider typeProvider = new PropertyTypeProviders.Identity(null);
	PropertyNameProvider nameProvider;
	
	PropertyTypeProvider implTypeProvider = new PropertyTypeProviders.Identity(null);
	
	final ProgrammingLanguage language;
	
	private FieldDefinition fieldDefinition;
	
	public PropertyGeneratorBuilder(ProgrammingLanguage language) {
		this.language = language;
	}

	public PropertyGeneratorBuilder setType(PropertyTypeProvider typeProvider) {
		this.typeProvider = typeProvider;
		return this;
	}
	
	public PropertyGeneratorBuilder setName(PropertyNameProvider nameProvider) {
		this.nameProvider = nameProvider;
		return this;
	}

	public PropertyGeneratorBuilder setInitializer() {
		setInitializer(this.typeProvider);
		return this;
	}

	public PropertyGeneratorBuilder setInitializer(PropertyTypeProvider implType) {
		this.implTypeProvider = implType;
		return this;
	}

	public PropertyGeneratorBuilder addGetter() {
		addGetter(this.typeProvider, this.nameProvider);
		return this;
	}
	
	public PropertyGeneratorBuilder addGetter(List<String> xmlMappings) {
		addGetter(this.typeProvider, this.nameProvider, xmlMappings);
		return this;
	}
	
	public PropertyGeneratorBuilder addGetter(PropertyTypeProvider typeProvider, PropertyNameProvider nameProvider) {
		addGetter(typeProvider, nameProvider, Collections.<String>emptyList());
		return this;
	}

	public PropertyGeneratorBuilder addGetter(PropertyTypeProvider typeProvider, PropertyNameProvider nameProvider, List<String> xmlMappings) {
		addGetter(typeProvider, nameProvider, xmlMappings, GetterBodyStyle.DEFAULT);
		return this;
	}

	public PropertyGeneratorBuilder addGetter(GetterBodyStyle style) {
		addGetter(typeProvider, nameProvider, Collections.<String>emptyList(), style);
		return this;
	}

	public PropertyGeneratorBuilder addGetter(PropertyTypeProvider typeProvider, PropertyNameProvider nameProvider, GetterBodyStyle style) {
		return this;
	}
	
	public PropertyGeneratorBuilder addGetter(PropertyTypeProvider typeProvider, PropertyNameProvider nameProvider, List<String> xmlMappings, GetterBodyStyle style) {
		return this;
	} 

	public PropertyGeneratorBuilder addSetter() {
		addSetter(this.typeProvider, this.nameProvider);
		return this;
	}

	public PropertyGeneratorBuilder addSetter(PropertyTypeProvider typeProvider, PropertyNameProvider nameProvider) {
		addSetter(typeProvider, nameProvider, SetterBodyStyle.DEFAULT);
		return this;
	}

	public PropertyGeneratorBuilder addSetter(SetterBodyStyle style) {
		addSetter(this.typeProvider, this.nameProvider, style);
		return this;
	}
	
	public PropertyGeneratorBuilder addSetter(PropertyTypeProvider typeProvider, PropertyNameProvider nameProvider, SetterBodyStyle style) {
		return this;
	}

	public PropertyGenerator build(ClassNameManager manager, BaseRelationshipNameResolver resolver) {
		return new PropertyGeneratorImpl(manager, resolver);
	}

	class PropertyGeneratorImpl extends Indenter implements PropertyGenerator {

		private final ClassNameManager manager;
		private final BaseRelationshipNameResolver resolver;

		public PropertyGeneratorImpl(ClassNameManager manager, BaseRelationshipNameResolver resolver) {
			this.manager = manager;
			this.resolver = resolver;
		}

		public void createAttributeDefinition(int indentLevel, Writer writer) throws IOException {
			if (fieldDefinition != null) {
				fieldDefinition.initializeContext(manager, resolver);
				new FieldDefinitionGenerator(fieldDefinition).createFieldDeclaration(indentLevel, writer);
				fieldDefinition.resetContext();
			}
		}

		public void createGetters(int indentLevel, Writer writer) throws IOException {
			createGetters(indentLevel, writer, false);
		}
		
		public void createSetters(int indentLevel, Writer writer) throws IOException {
			createSetters(indentLevel, writer, false);
		}
		
		public void createGettersAndSetters(int indentLevel, Writer writer) throws IOException {
			createGettersAndSetters(indentLevel, writer, false);
		}
		
		public void createGettersForInterface(int indentLevel, Writer writer) throws IOException {
			createGetters(indentLevel, writer, true);
		}
		
		public void createSettersForInterface(int indentLevel, Writer writer) throws IOException {
			createSetters(indentLevel, writer, true);
		}
		
		public void createGettersAndSettersForInterface(int indentLevel, Writer writer) throws IOException {
			createGettersAndSetters(indentLevel, writer, true);
		}
		
		private void createGetters(int indentLevel, Writer writer, boolean isInterface) throws IOException {
			if (fieldDefinition != null) {
				fieldDefinition.initializeContext(this.manager, this.resolver);
				new PropertyDefinitionGenerator(fieldDefinition).createGetterPropertyDefinition(indentLevel, writer, isInterface);
				fieldDefinition.resetContext();
			}			
		}

		private void createSetters(int indentLevel, Writer writer, boolean isInterface) throws IOException {
			if (fieldDefinition != null) {
				fieldDefinition.initializeContext(this.manager, this.resolver);
				new PropertyDefinitionGenerator(fieldDefinition).createSetterPropertyDefinition(indentLevel, writer, isInterface);
				fieldDefinition.resetContext();
			}			
		}

		private void createGettersAndSetters(int indentLevel, Writer writer, boolean isInterface) throws IOException {
			if (fieldDefinition != null) {
				fieldDefinition.initializeContext(this.manager, this.resolver);
				new PropertyDefinitionGenerator(fieldDefinition).createPropertyDefinition(indentLevel, writer, isInterface);
				fieldDefinition.resetContext();
			}			
		}

		public void createConstructorInitialization(int indentLevel, Writer writer) throws IOException {
				
			if (fieldDefinition != null && fieldDefinition.isInitializedAtConstructionTime()) {
				fieldDefinition.initializeContext(this.manager, this.resolver);
				new FieldDefinitionGenerator(fieldDefinition).createConstructorInitialization(indentLevel, writer);
				fieldDefinition.resetContext();
			}
		}

		public void createDerivedChoiceGetterProperties(int indentLevel, Writer writer) throws IOException {
			// this is same as for getters and setters (correct?)
			if (fieldDefinition != null) {
				fieldDefinition.initializeContext(this.manager, this.resolver);
				new PropertyDefinitionGenerator(fieldDefinition).createGetterPropertyDefinition(indentLevel, writer, false);
				fieldDefinition.resetContext();
			}			
		}
	}

	@Deprecated
	class Setter extends Indenter {
		private final PropertyTypeProvider typeProvider;
		final PropertyNameProvider nameProvider;
		private final SetterBodyStyle style;
		public Setter(PropertyTypeProvider typeProvider, PropertyNameProvider nameProvider, SetterBodyStyle style) {
			this.typeProvider = typeProvider;
			this.nameProvider = nameProvider;
			this.style = style;
		}
		public void create(int indentLevel, Writer writer, ClassNameManager manager, BaseRelationshipNameResolver resolver, boolean isInterface) throws IOException {
		}
		String getName(BaseRelationshipNameResolver resolver) {
			return this.nameProvider.getName(resolver);
		}
		public SetterBodyStyle getStyle() {
			return this.style;
		}
	}

	static String capitalize(String text) {
		return WordUtils.capitalize(text);
	}
	
	public boolean isJava() {
		return getLanguage() == ProgrammingLanguage.JAVA;
	}

	private ProgrammingLanguage getLanguage() {
		return this.language;
	}

	static String stripTemplateParameters(String typeName) {
		return StringUtils.replace(typeName, "<"+StringUtils.substringAfter(typeName, "<"), "");
	}
	
	public interface PropertyTypeProvider {
		public abstract boolean hasType();
		public abstract String getType(ClassNameManager manager);
	}
	
	public interface PropertyNameProvider {
		String getName(BaseRelationshipNameResolver resolver);
	}

	FieldDefinition getFieldDefinition() {
		return this.fieldDefinition;
	}

	void setFieldDefinition(FieldDefinition fieldDefinition) {
		this.fieldDefinition = fieldDefinition;
	}
}
