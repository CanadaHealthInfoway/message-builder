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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.cda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.codehaus.plexus.util.StringOutputStream;
import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.generator.util.Namespaces;
import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.MessageSet;

public class CdaXsdFormatterTest {
	
	private CdaXsdProcessor parser;
	private CdaXsdFormatter fixture;
	private Document schemaDocument;
	private XPathHelper helper = new XPathHelper();

	private Serializer serializer = new Persister(new AnnotationStrategy());
	
	@Before
	public void setUp() throws Exception {
		parser = new CdaXsdProcessor();
		fixture = new CdaXsdFormatter();

		Schema schema = (Schema) this.serializer.read(Schema.class, CdaXsdFormatterTest.class.getResourceAsStream("POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		parser.processSchema(schema, messageSet);
		
		Schema outputSchema = new Schema();
		fixture.formatSchema(outputSchema, messageSet);
		
		StringOutputStream stream = new StringOutputStream();
		this.serializer.write(outputSchema, stream);
		
		schemaDocument = new DocumentFactory().createFromString(stream.toString());
}
	
	@Test
	public void shouldFormatMessagePart() throws Exception {
		
		assertEquals(88, helper.getNodes(schemaDocument, "/xs:schema/xs:complexType", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("POCD_MT000040.Act", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:complexType[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.AssignedAuthor", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:complexType[3]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.Component2", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:complexType[14]/@name", Namespaces.XSD_NAMESPACE));
		
		// weird sort order issues...
		assertEquals("POCD_MT000040.InFulfillmentOf", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:complexType[40]/@name", Namespaces.XSD_NAMESPACE));
	}

	@Test
	public void shouldFormatAttributes() throws Exception {
		
		Node actNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='POCD_MT000040.Act']", Namespaces.XSD_NAMESPACE);
		assertEquals(4, helper.getNodes(actNode, "xs:attribute", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("nullFlavor", helper.getAttributeValue(actNode, "xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("NullFlavor", helper.getAttributeValue(actNode, "xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(actNode, "xs:attribute[1]/@use", Namespaces.XSD_NAMESPACE));

		assertEquals("classCode", helper.getAttributeValue(actNode, "xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("x_ActClassDocumentEntryAct", helper.getAttributeValue(actNode, "xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(actNode, "xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));
		
		assertEquals("moodCode", helper.getAttributeValue(actNode, "xs:attribute[3]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("x_DocumentActMood", helper.getAttributeValue(actNode, "xs:attribute[3]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(actNode, "xs:attribute[3]/@use", Namespaces.XSD_NAMESPACE));
		
		assertEquals("negationInd", helper.getAttributeValue(actNode, "xs:attribute[4]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("bl", helper.getAttributeValue(actNode, "xs:attribute[4]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(actNode, "xs:attribute[4]/@use", Namespaces.XSD_NAMESPACE));
		
		Node assignedAuthorNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='POCD_MT000040.AssignedAuthor']", Namespaces.XSD_NAMESPACE);
		assertEquals(2, helper.getNodes(assignedAuthorNode, "xs:attribute", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("classCode", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("RoleClassAssignedEntity", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("ASSIGNED", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[2]/@fixed", Namespaces.XSD_NAMESPACE));
		
		Node criterionNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='POCD_MT000040.Criterion']", Namespaces.XSD_NAMESPACE);
		assertEquals(3, helper.getNodes(criterionNode, "xs:attribute", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("classCode", helper.getAttributeValue(criterionNode, "xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ActClassObservation", helper.getAttributeValue(criterionNode, "xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(criterionNode, "xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("OBS", helper.getAttributeValue(criterionNode, "xs:attribute[2]/@default", Namespaces.XSD_NAMESPACE));
	}

	@Test
	public void shouldFormatElements() throws Exception {
		Node actNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='POCD_MT000040.Act']", Namespaces.XSD_NAMESPACE);
		assertEquals(19, helper.getNodes(actNode, "xs:sequence/xs:element", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("realmCode", helper.getAttributeValue(actNode, "xs:sequence/xs:element[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("CS", helper.getAttributeValue(actNode, "xs:sequence/xs:element[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(actNode, "xs:sequence/xs:element[1]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(actNode, "xs:sequence/xs:element[1]/@maxOccurs", Namespaces.XSD_NAMESPACE));

		assertEquals("templateId", helper.getAttributeValue(actNode, "xs:sequence/xs:element[3]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("II", helper.getAttributeValue(actNode, "xs:sequence/xs:element[3]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(actNode, "xs:sequence/xs:element[3]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(actNode, "xs:sequence/xs:element[3]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("code", helper.getAttributeValue(actNode, "xs:sequence/xs:element[5]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("CD", helper.getAttributeValue(actNode, "xs:sequence/xs:element[5]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[5]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[5]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("effectiveTime", helper.getAttributeValue(actNode, "xs:sequence/xs:element[8]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("IVL_TS", helper.getAttributeValue(actNode, "xs:sequence/xs:element[8]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(actNode, "xs:sequence/xs:element[8]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[8]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("subject", helper.getAttributeValue(actNode, "xs:sequence/xs:element[11]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.Subject", helper.getAttributeValue(actNode, "xs:sequence/xs:element[11]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(actNode, "xs:sequence/xs:element[11]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[11]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("specimen", helper.getAttributeValue(actNode, "xs:sequence/xs:element[12]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.Specimen", helper.getAttributeValue(actNode, "xs:sequence/xs:element[12]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(actNode, "xs:sequence/xs:element[12]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(actNode, "xs:sequence/xs:element[12]/@maxOccurs", Namespaces.XSD_NAMESPACE));
	}
	
	@Test
	public void shouldFormatChoices() throws Exception {
		Node authorNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='POCD_MT000040.AssignedAuthor']", Namespaces.XSD_NAMESPACE);
		assertNotNull(helper.getSingleNode(authorNode, "xs:sequence/xs:choice", Namespaces.XSD_NAMESPACE));
		assertEquals(2, helper.getNodes(authorNode, "xs:sequence/xs:choice/xs:element", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("assignedPerson", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.Person", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[1]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[1]/@maxOccurs", Namespaces.XSD_NAMESPACE));

		assertEquals("assignedAuthoringDevice", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.AuthoringDevice", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[2]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[2]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		Node componentNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='POCD_MT000040.Component2']", Namespaces.XSD_NAMESPACE);
		assertNotNull(helper.getSingleNode(componentNode, "xs:sequence/xs:choice", Namespaces.XSD_NAMESPACE));
		assertEquals(2, helper.getNodes(componentNode, "xs:sequence/xs:choice/xs:element", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("structuredBody", helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.StructuredBody", helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[2]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[2]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[2]/@maxOccurs", Namespaces.XSD_NAMESPACE));
	}

	@Test
	public void shouldFormatConstrainedDatatypes() throws Exception {
		Node actNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='POCD_MT000040.Act']", Namespaces.XSD_NAMESPACE);

		assertEquals("typeId", helper.getAttributeValue(actNode, "xs:sequence/xs:element[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.InfrastructureRoot.typeId", helper.getAttributeValue(actNode, "xs:sequence/xs:element[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(actNode, "xs:sequence/xs:element[2]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[2]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals(2, helper.getNodes(schemaDocument, "/xs:schema/xs:complexType/xs:complexContent", Namespaces.XSD_NAMESPACE).getLength());

		Node typeIdNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[1]", Namespaces.XSD_NAMESPACE);
		assertEquals("POCD_MT000040.InfrastructureRoot.typeId", helper.getAttributeValue(typeIdNode, "@name", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getSingleNode(typeIdNode, "xs:complexContent/xs:extension", Namespaces.XSD_NAMESPACE));
		assertEquals("II", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/@base", Namespaces.XSD_NAMESPACE));

		assertEquals("root", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("uid", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("2.16.840.1.113883.1.3", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@fixed", Namespaces.XSD_NAMESPACE));

		assertEquals("extension", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("st", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));

		Node roiValueNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[74]", Namespaces.XSD_NAMESPACE);
		assertEquals("POCD_MT000040.RegionOfInterest.value", helper.getAttributeValue(roiValueNode, "@name", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getSingleNode(roiValueNode, "xs:complexContent/xs:restriction", Namespaces.XSD_NAMESPACE));
		assertEquals("INT", helper.getAttributeValue(roiValueNode, "xs:complexContent/xs:extension/@base", Namespaces.XSD_NAMESPACE));

		assertEquals("unsorted", helper.getAttributeValue(roiValueNode, "xs:complexContent/xs:extension/xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("xs:boolean", helper.getAttributeValue(roiValueNode, "xs:complexContent/xs:extension/xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("false", helper.getAttributeValue(roiValueNode, "xs:complexContent/xs:extension/xs:attribute[1]/@default", Namespaces.XSD_NAMESPACE));
	}
	
	@Test
	public void shouldFormatMetadata() throws Exception {
		assertEquals("urn:hl7-org:v3", helper.getAttributeValue(schemaDocument, "/xs:schema/@targetNamespace", Namespaces.XSD_NAMESPACE));
		assertEquals("qualified", helper.getAttributeValue(schemaDocument, "/xs:schema/@elementFormDefault", Namespaces.XSD_NAMESPACE));
		assertEquals("Generated using schema builder version 2.0. Stylesheets:\n" +
				"RoseTreeToMIFStaticModel.xsl version: 1.1\n" +
				"StaticMifToXsd.xsl version 2.0", helper.getTextString(schemaDocument, "/xs:schema/xs:annotation/xs:documentation/text()", Namespaces.XSD_NAMESPACE));
		assertEquals("../../processable/coreschemas/datatypes.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[1]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("../../processable/coreschemas/voc.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[2]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("../../processable/coreschemas/NarrativeBlock.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[3]/@schemaLocation", Namespaces.XSD_NAMESPACE));
	}
}
