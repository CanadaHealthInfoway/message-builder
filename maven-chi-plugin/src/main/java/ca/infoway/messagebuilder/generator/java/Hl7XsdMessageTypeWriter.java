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

import java.io.File;
import java.util.Collection;

import org.apache.commons.lang.WordUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.XsdDataType;
import ca.infoway.messagebuilder.generator.XsdTypeConverter;
import ca.infoway.messagebuilder.xml.TypeName;

public class Hl7XsdMessageTypeWriter extends Hl7XsdTypeWriter {

	private final ComplexTypePackage complexTypePackage;
	private final NameTranslator translator;
	private XsdTypeConverter converter = new XsdTypeConverter();
	private final NamingPolicy namingPolicy;
	private final File simpleXsdDataTypeFolder;
	
	public Hl7XsdMessageTypeWriter(ComplexTypePackage complexTypePackage, NameTranslator translator, TypeAnalysisResult typeResults, NamingPolicy namingPolicy) {
		super(typeResults);
		this.translator = translator;
		this.complexTypePackage = complexTypePackage;
		this.namingPolicy = namingPolicy;
		this.simpleXsdDataTypeFolder = XsdMessageWriterUtil.getXsdSDFolder();
	}

	@Override
	protected void writeContents(Element schema)	throws GeneratorException {
		Collection<Type> values = this.complexTypePackage.getTypes().values();
		for (Type type : values) {
			addTypeToSchema(schema, type);
		}
	}

	private void addSimpleDataTypesInclude(Document document, Element schema) {
		String path = "";
		if (this.simpleXsdDataTypeFolder == null) {
			path = "../../../../../../classes/simpleDataTypes";
		} else {
			path = this.simpleXsdDataTypeFolder.getAbsolutePath();
		}
		addInclude(schema, path);
	}
	
	@Override
	protected String getTypeName() {
		return this.complexTypePackage.getName().getName();
	}
	
	private void addTypeToSchema(Element schema, Type type) throws GeneratorException {
		if (!type.isAbstract()) {
			writeRelationships(schema, type);
		} else {
			writeChoices(schema, type);
		}
		XsdMessageWriterUtil seqReorderer = new XsdMessageWriterUtil();
		seqReorderer.reorderSchema(schema);
	}

	private void writeChoices(Element schema, Type type) {
		Document document = schema.getOwnerDocument();
		Element choices = document.createElement("xs:group");
		choices.setAttribute("name", type.getTypeName().getName());
		Element choice = document.createElement("xs:choice");
		choices.appendChild(choice);
		document.createElement("xs:element");
		for (RenderedType childTypeName : type.getChildTypes()) {

			Type childType = getType(childTypeName.getTypeName());
			if (childType == null) {
				throw new IllegalStateException("Could not find childType '" + childTypeName.getTypeName()
						+ "' in result types");
			} else if (childType.isAbstract()) {
				Element propertyElement = document.createElement("xs:group");
				choice.appendChild(propertyElement);
				propertyElement.setAttribute("ref", "chi:" + childTypeName.getTypeName());
			} else {
				Element propertyElement = document.createElement("xs:element");
				choice.appendChild(propertyElement);
				String name = WordUtils.uncapitalize(this.translator.getClassNameWithoutPackage(childTypeName.getTypeName()));
				propertyElement.setAttribute("name", type.getTypeName().getParent().getName() + "." + childTypeName.getTypeName().getParent().getName() + "." + name);
				propertyElement.setAttribute("type", "chi:" + childTypeName.getTypeName());
			}
			addInclude(schema, childTypeName.getTypeName().getParent().getName());
		}	
		schema.appendChild(choices);
	}

	void writeRelationships(Element schema, Type type) throws DOMException, GeneratorException {
		Document document = schema.getOwnerDocument();
		Element complexType = document.createElement("xs:complexType");
		complexType.setAttribute("name", type.getTypeName().getName());
		Element sequence = document.createElement("xs:sequence");
		complexType.appendChild(sequence);
		PropertyNameResolver propertyNameResolver = new PropertyNameResolver(
				this.translator.getClassNameWithoutPackage(this.complexTypePackage.getName()), 
				type.getRelationships(), this.namingPolicy);
		for (BaseRelationship baseRelationship : type.getRelationships()) {
			if (!isTemplateRelationship(baseRelationship)) {
				writeRelationship(document, schema, sequence, baseRelationship, propertyNameResolver);
			}
		}
		schema.appendChild(complexType);
	}

	/**
	 * @param baseRelationship
	 * @return true if relationship is a template relationship or relationship 
	 *         is to a type that contains a template relationship
	 */
	private boolean isTemplateRelationship(BaseRelationship baseRelationship) {
		return baseRelationship.getRelationshipType() == RelationshipType.ASSOCIATION &&
				(((Association) baseRelationship).isTemplateType() ||
				((Association) baseRelationship).getAssociationType().isTemplateType());
	}

	void writeRelationship(Document document, Element schema, Element sequence, BaseRelationship relationship, PropertyNameResolver resolver) throws GeneratorException {
		sequence.appendChild(createXsdRelationshipConstruct(document, schema,
				relationship, resolver));
	}

	private Element createXsdRelationshipConstruct(Document document, Element schema,
			BaseRelationship relationship, PropertyNameResolver resolver)
			throws GeneratorException {
		if (relationship.getRelationshipType() == RelationshipType.ASSOCIATION && relationship.isChoice()) {
			Element propertyElement =  document.createElement("xs:group");
			TypeName typeName = new TypeName(relationship.getType());
			propertyElement.setAttribute("ref", "chi:" + typeName.getName());
			propertyElement.setAttribute("minOccurs", "" + relationship.getCardinality().getMin());
			propertyElement.setAttribute("maxOccurs", "" + relationship.getCardinality().getMax());
			addInclude(schema, typeName.getParent().getName());
			return propertyElement;
		} else {
			Element propertyElement =  document.createElement("xs:element");
			propertyElement.setAttribute("name", WordUtils.uncapitalize(resolver.getName(relationship)));
			if (relationship.getRelationshipType() == RelationshipType.ATTRIBUTE) {
				XsdDataType xsdType = this.converter.convertToType(relationship.getRelationship(), ((Attribute) relationship).isIndicator());
				propertyElement.setAttribute("type", xsdType.getQualifiedName());
				addSimpleDataTypesInclude(document, schema);
			} else {
				TypeName typeName = new TypeName(relationship.getType());
				propertyElement.setAttribute("type", "chi:" + typeName.getName());				
				addInclude(schema, typeName.getParent().getName());
			}
			propertyElement.setAttribute("minOccurs", "" + relationship.getCardinality().getMin());
			propertyElement.setAttribute("maxOccurs", "" + relationship.getCardinality().getMax());
			return propertyElement;
		}
	}
}
