/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.generator.Namespaces;
import ca.infoway.messagebuilder.generator.NamingPolicy;
import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.Cardinality;
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
	
}
