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

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.xpath.XPathExpressionException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.generator.Namespaces;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;
import ca.infoway.messagebuilder.xml.TypeName;

@RunWith(JMock.class)
public class Hl7XsdMessageTypeWriterTest {

	private Mockery jmock = new Mockery();
	
	private NameTranslator translator;

	private TypeName typeName;

	private TypeName interactionType;
	
	@Before
	public void setUp() throws Exception {
		this.translator = this.jmock.mock(NameTranslator.class);
		this.typeName = new TypeName("ABCD_MT123456CA.MyType");
		this.interactionType = new TypeName("ABCD_IN123456CA");
		this.jmock.checking(new Expectations() {{
			allowing(Hl7XsdMessageTypeWriterTest.this.translator).getPackageName(with(any(TypeName.class)));
			allowing(Hl7XsdMessageTypeWriterTest.this.translator).getClassNameWithoutPackage(Hl7XsdMessageTypeWriterTest.this.interactionType); will(returnValue("Fred"));
			allowing(Hl7XsdMessageTypeWriterTest.this.translator).getClassNameWithoutPackage(Hl7XsdMessageTypeWriterTest.this.typeName); will(returnValue("MyTranslatedType"));
			allowing(Hl7XsdMessageTypeWriterTest.this.translator).getClassNameWithoutPackage(with(any(TypeName.class)));
			allowing(Hl7XsdMessageTypeWriterTest.this.translator).getFullyQualifiedClassName(with(any(TypeName.class)));
		}});
	}

	@Test
	public void shouldWriteAttributeWithTypeTranslation() throws Exception {
		ComplexTypePackage complexTypePackage = new ComplexTypePackage(this.typeName.getParent());
		final Type type = new Type(this.typeName);
		type.setAbstract(true);
		Relationship relationship = new Relationship();
		relationship.setCardinality(new Cardinality(1,1));
		relationship.setName("id");
		relationship.setType("II");
		Attribute attribute = new Attribute(relationship, null);
		type.getRelationships().add(attribute);

		Hl7XsdMessageTypeWriter typeWriter = new Hl7XsdMessageTypeWriter(complexTypePackage, this.translator, null, NamingPolicy.getDefaultPolicy());
		Document document = new DocumentFactory().createFromString("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<xs:schema xmlns:chi=\"urn:ca.infoway.messagebuilder.simplexml.v1\" elementFormDefault=\"qualified\" targetNamespace=\"urn:ca.infoway.messagebuilder.simplexml.v1\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">"
				+ "  <xs:complexType name=\"OtherIdentifiersBean\"><xs:sequence /></xs:complexType>" +
				"</xs:schema>");

		Element sequence = (Element) new XPathHelper().getSingleNode(document, "//xs:sequence", Namespaces.XSD_NAMESPACE);

		typeWriter.writeRelationship(document, document.getDocumentElement(), sequence, attribute, new PropertyNameResolver("Fred", type.getRelationships(), NamingPolicy.getDefaultPolicy()));
	}
	
	@Test
	public void shouldAttachTypePackageNameToElementName() throws SAXException, XPathExpressionException {
		Type testType = new Type(new TypeName("COCT_MT911108CA.ActingPerson"));
		Relationship mainRelationship = new Relationship();

		Type childType1 = new Type(new TypeName("COCT_MT090108CA.AssignedEntity"));
		Type childType2 = new Type(new TypeName("COCT_MT090508CA.AssignedEntity"));
		Type childType3 = new Type(new TypeName("COCT_MT910108CA.PersonalRelationship"));
		
		testType.getChildTypes().add(childType1);
		testType.getChildTypes().add(childType2);
		testType.getChildTypes().add(childType3);

		testType.setAbstract(true);
		testType.getRelationships().add(Association.createTemplateAssociation(mainRelationship, new TemplateVariable("T")));

		ComplexTypePackage complexTypePackage = new ComplexTypePackage(testType.getTypeName());
		complexTypePackage.getTypes().put(testType.getTypeName().getName(), testType);

		TypeAnalysisResult result = new TypeAnalysisResult();
		result.getAllPackages().add(complexTypePackage);
		result.getTypes().put(childType1.getTypeName(), childType1);
		result.getTypes().put(childType2.getTypeName(), childType2);
		result.getTypes().put(childType3.getTypeName(), childType3);

		Hl7XsdMessageTypeWriter typeWriter = new Hl7XsdMessageTypeWriter(complexTypePackage, this.translator, result, NamingPolicy.getDefaultPolicy());
		Document document = new DocumentFactory().newDocument();
		document.setXmlStandalone(true);		
		Element schema = document.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "xs:schema");
		schema.setAttribute(XMLConstants.XMLNS_ATTRIBUTE + ":chi", "urn:ca.infoway.messagebuilder.simplexml.v1");
		schema.setAttribute("targetNamespace", "urn:ca.infoway.messagebuilder.simplexml.v1");
		schema.setAttribute("elementFormDefault", "qualified");
		typeWriter.writeContents(schema);

		NodeList schemaChildren = schema.getChildNodes();
		for(int i=0; i<schemaChildren.getLength(); i++) {
			Element group = (Element)schemaChildren.item(i);
			NodeList groupChildren = group.getChildNodes();
			for (int j=0; j<groupChildren.getLength(); j++) {
				Element choice = (Element)groupChildren.item(j);
				NodeList choiceChildren = choice.getChildNodes();
				for (int k=0; k<choiceChildren.getLength(); k++) {
					Element element = (Element)choiceChildren.item(k);
					String packageNameOfType = element.getAttribute("type").startsWith("chi:") ? element.getAttribute("type").substring("chi:".length(), element.getAttribute("type").indexOf(".")) : element.getAttribute("type").substring(0, element.getAttribute("type").indexOf("."));
					assertTrue(element.getAttribute("name").contains(packageNameOfType));
				}
			}
		}
	}
	
	@Test
	public void shouldAttachCurrentPackageNameToElementName() {
		Type testType = new Type(new TypeName("COCT_MT911108CA.ActingPerson"));
		Relationship mainRelationship = new Relationship();

		Type childType1 = new Type(new TypeName("COCT_MT090108CA.AssignedEntity"));
		Type childType2 = new Type(new TypeName("COCT_MT090508CA.AssignedEntity"));
		Type childType3 = new Type(new TypeName("COCT_MT910108CA.PersonalRelationship"));
		
		testType.getChildTypes().add(childType1);
		testType.getChildTypes().add(childType2);
		testType.getChildTypes().add(childType3);

		testType.setAbstract(true);
		testType.getRelationships().add(Association.createTemplateAssociation(mainRelationship, new TemplateVariable("T")));

		ComplexTypePackage complexTypePackage = new ComplexTypePackage(testType.getTypeName());
		complexTypePackage.getTypes().put(testType.getTypeName().getName(), testType);

		TypeAnalysisResult result = new TypeAnalysisResult();
		result.getAllPackages().add(complexTypePackage);
		result.getTypes().put(childType1.getTypeName(), childType1);
		result.getTypes().put(childType2.getTypeName(), childType2);
		result.getTypes().put(childType3.getTypeName(), childType3);

		Hl7XsdMessageTypeWriter typeWriter = new Hl7XsdMessageTypeWriter(complexTypePackage, this.translator, result, NamingPolicy.getDefaultPolicy());
		Document document = new DocumentFactory().newDocument();
		document.setXmlStandalone(true);		
		Element schema = document.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, "xs:schema");
		schema.setAttribute(XMLConstants.XMLNS_ATTRIBUTE + ":chi", "urn:ca.infoway.messagebuilder.simplexml.v1");
		schema.setAttribute("targetNamespace", "urn:ca.infoway.messagebuilder.simplexml.v1");
		schema.setAttribute("elementFormDefault", "qualified");
		typeWriter.writeContents(schema);

		NodeList schemaChildren = schema.getChildNodes();
		for(int i=0; i<schemaChildren.getLength(); i++) {
			Element group = (Element)schemaChildren.item(i);
			NodeList groupChildren = group.getChildNodes();
			for (int j=0; j<groupChildren.getLength(); j++) {
				Element choice = (Element)groupChildren.item(j);
				NodeList choiceChildren = choice.getChildNodes();
				for (int k=0; k<choiceChildren.getLength(); k++) {
					Element element = (Element)choiceChildren.item(k);
					//System.out.println(element + " : " + element.getAttribute("name") + " : " + element.getAttribute("type"));
					assertTrue(element.getAttribute("name").contains("COCT_MT911108CA"));
				}
			}
		}
	}
	
	@Test
	public void shouldReorderElementsOfSameTypeWithDifferentMinMaxOccurs() {
		Type testType = new Type(new TypeName("REPC_MT230002CA.Document"));
		testType.setBusinessName("Clinical Observation Document");
		testType.setAbstract(false);
		
		Relationship relationship1 = new Relationship();
		relationship1.setCardinality(Cardinality.create("1"));
		relationship1.setName("author");
		relationship1.setType("REPC_MT230002CA.Author");
		relationship1.setConformance(ConformanceLevel.MANDATORY);
		relationship1.setSortOrder(6);

		Relationship relationship4 = new Relationship();
		relationship4.setCardinality(Cardinality.create("0-10"));
		relationship4.setName("primaryInformationRecipient");
		relationship4.setType("REPC_MT230002CA.InformationRecipient");
		relationship4.setConformance(ConformanceLevel.REQUIRED);
		relationship4.setSortOrder(13);

		Relationship relationship5 = new Relationship();
		relationship5.setCardinality(Cardinality.create("1"));
		relationship5.setName("responsibleParty");
		relationship5.setType("REPC_MT230002CA.ResponsibleParty");
		relationship5.setConformance(ConformanceLevel.MANDATORY);
		relationship5.setSortOrder(14);

		Relationship relationship6 = new Relationship();
		relationship6.setCardinality(Cardinality.create("0-10"));
		relationship6.setName("subjectOf1");
		relationship6.setType("REPC_MT230002CA.Subject4");
		relationship6.setConformance(ConformanceLevel.REQUIRED);
		relationship6.setSortOrder(15);
		relationship6.getChoices().add(relationship5);
		
		Relationship relationship7 = new Relationship();
		relationship7.setCardinality(Cardinality.create("1"));
		relationship7.setName("subjectOf2");
		relationship7.setType("REPC_MT230002CA.Subject4");
		relationship7.setConformance(ConformanceLevel.REQUIRED);
		relationship7.setSortOrder(16);
		relationship7.getChoices().add(relationship5);
		
		testType.getRelationships().add(Association.createStandardAssociation(relationship1, new Type(new TypeName(relationship1.getType()))));
		testType.getRelationships().add(Association.createStandardAssociation(relationship4, new Type(new TypeName(relationship4.getType()))));
		testType.getRelationships().add(Association.createStandardAssociation(relationship6, new Type(new TypeName(relationship6.getType()))));
		testType.getRelationships().add(Association.createStandardAssociation(relationship7, new Type(new TypeName(relationship7.getType()))));
		testType.getRelationships().add(Association.createStandardAssociation(relationship1, new Type(new TypeName(relationship1.getType()))));
		
		ComplexTypePackage complexTypePackage = new ComplexTypePackage(testType.getTypeName());
		complexTypePackage.getTypes().put(testType.getTypeName().getName(), testType);

		TypeAnalysisResult result = new TypeAnalysisResult();
		result.getAllPackages().add(complexTypePackage);

		Hl7XsdMessageTypeWriter typeWriter = new Hl7XsdMessageTypeWriter(complexTypePackage, this.translator, result, NamingPolicy.getDefaultPolicy());
		Document document = new DocumentFactory().newDocument();
		document.setXmlStandalone(true);		
		Element schema = document.createElement("xs:schema");
		document.appendChild(schema);
		schema.setAttribute(XMLConstants.XMLNS_ATTRIBUTE + ":chi", "urn:ca.infoway.messagebuilder.simplexml.v1");
		schema.setAttribute("targetNamespace", "urn:ca.infoway.messagebuilder.simplexml.v1");
		schema.setAttribute("elementFormDefault", "qualified");
		typeWriter.writeContents(schema);
		
		ArrayList<Element> refElements = new ArrayList<Element>();
		
		//System.out.println(schema);
		NodeList schemaChildren = schema.getChildNodes();
		for(int i=0; i<schemaChildren.getLength(); i++) {
			Element group = (Element)schemaChildren.item(i);
			NodeList groupChildren = group.getChildNodes();
			//System.out.println(group + " : " + group.getAttribute("name") + " : " + group.getAttribute("type"));
			for (int j=0; j<groupChildren.getLength(); j++) {
				Element choice = (Element)groupChildren.item(j);
				NodeList choiceChildren = choice.getChildNodes();
				//System.out.println(choice + " : " + choice.getAttribute("name") + " : " + choice.getAttribute("type"));
				for (int k=0; k<choiceChildren.getLength(); k++) {
					Element element = (Element)choiceChildren.item(k);
					System.out.println(element + " : " + element.getAttribute("name") + " : " + element.getAttribute("type") + " : " + element.getAttribute("ref") + " : " + element.getAttribute("minOccurs") + " : " + element.getAttribute("maxOccurs"));
					if (element.getAttribute("name").length()<=0) {
						refElements.add(element);
					}
				}
			}
		}
		
		for (int i=1; i<refElements.size(); i++) {
			assertTrue(refElements.get(i-1).getAttribute("ref").equals(refElements.get(i).getAttribute("ref")) && Integer.parseInt(refElements.get(i-1).getAttribute("minOccurs")) > Integer.parseInt(refElements.get(i).getAttribute("minOccurs")));
		}
	}

}
