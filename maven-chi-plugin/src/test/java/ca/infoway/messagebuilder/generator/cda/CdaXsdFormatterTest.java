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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.template.CdaTemplateProcessor;
import ca.infoway.messagebuilder.generator.template.CdaTemplateProcessorTest;
import ca.infoway.messagebuilder.generator.template.TemplateExport;
import ca.infoway.messagebuilder.generator.util.Namespaces;
import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.tools.template.TemplateApplier;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinition;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

@RunWith(MockitoJUnitRunner.class)
public class CdaXsdFormatterTest {
	
	private CdaXsdFormatter fixture;
	
	private ValueSetDefinition valueSetDefinition;
	private Document schemaDocument;
	private XPathHelper helper = new XPathHelper();

	private Serializer serializer = new Persister(new AnnotationStrategy());
	
	@Mock
	private OutputUI outputUI;
	private MessageSet derivedMessageSet;
	
	@Before
	public void setUp() throws Exception {

		Schema schema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/POCD_MT000040_SDTC.xsd"));
		Schema supplementalSchema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/SDTC.xsd"));
		
		MessageSet messageSet = new MessageSet();
		messageSet.setCda(true);
		messageSet.setGeneratedAsR2(true);
		new CdaXsdProcessor(outputUI).processSchema(schema, supplementalSchema, messageSet);
		
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CdaTemplateProcessorTest.class.getResourceAsStream("/Consolidation.xml"));
		valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, CdaTemplateProcessorTest.class.getResourceAsStream("/voc.xml"));
		
		TemplateSet templateSet = new TemplateSet();
		new CdaTemplateProcessor(valueSetDefinition, outputUI).parseTemplate(templateExport, messageSet, templateSet);
		
		TemplateApplier applier = new TemplateApplier();
		derivedMessageSet = applier.resolveToMessageSet(messageSet, templateSet, "");
		
		Schema outputSchema = new Schema();
		fixture = new CdaXsdFormatter(outputUI, valueSetDefinition);
		fixture.formatSchema(outputSchema, derivedMessageSet, "ConsultationNote");
		
		StringOutputStream stream = new StringOutputStream();
		this.serializer.write(outputSchema, stream);
		
		schemaDocument = new DocumentFactory().createFromString(stream.toString());
//		System.out.println(stream.toString());
	}
	
	@Test
	public void shouldFormatMessagePart() throws Exception {
		
		assertEquals(84, helper.getNodes(schemaDocument, "/xs:schema/xs:complexType", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("ConsultationNote.AllergiesSectionentriesRequiredComponent3", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:complexType[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.AssessmentAndPlanSectionComponent3", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:complexType[3]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.AuthenticatorPerson", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:complexType[13]/@name", Namespaces.XSD_NAMESPACE));
		
		// weird sort order issues...
		assertEquals("ConsultationNote.InFulfillmentOf", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:complexType[46]/@name", Namespaces.XSD_NAMESPACE));
	}

	@Test
	public void shouldFormatAttributes() throws Exception {
		
		Node sectionNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.ClinicalDocument']", Namespaces.XSD_NAMESPACE);
		assertEquals(3, helper.getNodes(sectionNode, "xs:attribute", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("nullFlavor", helper.getAttributeValue(sectionNode, "xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("NullFlavor", helper.getAttributeValue(sectionNode, "xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(sectionNode, "xs:attribute[1]/@use", Namespaces.XSD_NAMESPACE));

		assertEquals("classCode", helper.getAttributeValue(sectionNode, "xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ActClinicalDocument", helper.getAttributeValue(sectionNode, "xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(sectionNode, "xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("DOCCLIN", helper.getAttributeValue(sectionNode, "xs:attribute[2]/@fixed", Namespaces.XSD_NAMESPACE));
		
		assertEquals("moodCode", helper.getAttributeValue(sectionNode, "xs:attribute[3]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ActMood", helper.getAttributeValue(sectionNode, "xs:attribute[3]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(sectionNode, "xs:attribute[3]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("EVN", helper.getAttributeValue(sectionNode, "xs:attribute[3]/@fixed", Namespaces.XSD_NAMESPACE));
		
		Node assignedAuthorNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.AssignedAuthor']", Namespaces.XSD_NAMESPACE);
		assertEquals(2, helper.getNodes(assignedAuthorNode, "xs:attribute", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("nullFlavor", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("NullFlavor", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[1]/@use", Namespaces.XSD_NAMESPACE));

		assertEquals("classCode", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("RoleClassAssignedEntity", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("ASSIGNED", helper.getAttributeValue(assignedAuthorNode, "xs:attribute[2]/@fixed", Namespaces.XSD_NAMESPACE));
		
		Node criterionNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.InformationRecipient']", Namespaces.XSD_NAMESPACE);
		assertEquals(2, helper.getNodes(criterionNode, "xs:attribute", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("typeCode", helper.getAttributeValue(criterionNode, "xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("x_InformationRecipient", helper.getAttributeValue(criterionNode, "xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("optional", helper.getAttributeValue(criterionNode, "xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("PRCP", helper.getAttributeValue(criterionNode, "xs:attribute[2]/@default", Namespaces.XSD_NAMESPACE));
	}

	@Test
	public void shouldInsertNullFlavorAttributeAfterIdAttributeIfPresent() throws Exception {
		
		Schema outputSchema = new Schema();
		fixture.formatSchema(outputSchema, derivedMessageSet, "AdvanceDirectivesSectionentriesOptional");
		
		StringOutputStream stream = new StringOutputStream();
		this.serializer.write(outputSchema, stream);
		
		Document sectionDocument = new DocumentFactory().createFromString(stream.toString());

		Node actNode = helper.getSingleNode(sectionDocument, "/xs:schema/xs:complexType[@name='AdvanceDirectivesSectionentriesOptional.Section']", Namespaces.XSD_NAMESPACE);
		assertEquals(4, helper.getNodes(actNode, "xs:attribute", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("ID", helper.getAttributeValue(actNode, "xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("xs:ID", helper.getAttributeValue(actNode, "xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		
		assertEquals("nullFlavor", helper.getAttributeValue(actNode, "xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("NullFlavor", helper.getAttributeValue(actNode, "xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
	}
	
	@Test
	public void shouldFormatElements() throws Exception {
		Node actNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.ClinicalDocument']", Namespaces.XSD_NAMESPACE);
		assertEquals(24, helper.getNodes(actNode, "xs:sequence/xs:element", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("id", helper.getAttributeValue(actNode, "xs:sequence/xs:element[4]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("II", helper.getAttributeValue(actNode, "xs:sequence/xs:element[4]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[4]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[4]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("code", helper.getAttributeValue(actNode, "xs:sequence/xs:element[5]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("CE", helper.getAttributeValue(actNode, "xs:sequence/xs:element[5]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[5]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[5]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("effectiveTime", helper.getAttributeValue(actNode, "xs:sequence/xs:element[7]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("TS", helper.getAttributeValue(actNode, "xs:sequence/xs:element[7]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[7]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[7]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("setId", helper.getAttributeValue(actNode, "xs:sequence/xs:element[10]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("II", helper.getAttributeValue(actNode, "xs:sequence/xs:element[10]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(actNode, "xs:sequence/xs:element[10]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[10]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("recordTarget", helper.getAttributeValue(actNode, "xs:sequence/xs:element[13]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.RecordTarget", helper.getAttributeValue(actNode, "xs:sequence/xs:element[13]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(actNode, "xs:sequence/xs:element[13]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(actNode, "xs:sequence/xs:element[13]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("informationRecipient", helper.getAttributeValue(actNode, "xs:sequence/xs:element[17]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.InformationRecipient", helper.getAttributeValue(actNode, "xs:sequence/xs:element[17]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(actNode, "xs:sequence/xs:element[17]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(actNode, "xs:sequence/xs:element[17]/@maxOccurs", Namespaces.XSD_NAMESPACE));

		Node authorNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.AssignedAuthor']", Namespaces.XSD_NAMESPACE);

		assertEquals("id", helper.getAttributeValue(authorNode, "xs:sequence/xs:element[4]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("II", helper.getAttributeValue(authorNode, "xs:sequence/xs:element[4]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(authorNode, "xs:sequence/xs:element[4]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(authorNode, "xs:sequence/xs:element[4]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("addr", helper.getAttributeValue(authorNode, "xs:sequence/xs:element[6]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("AD", helper.getAttributeValue(authorNode, "xs:sequence/xs:element[6]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(authorNode, "xs:sequence/xs:element[6]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(authorNode, "xs:sequence/xs:element[6]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
	}
	
	@Test
	public void shouldFormatChoices() throws Exception {
		// Traditional choices
		Node authorNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.AssignedAuthor']", Namespaces.XSD_NAMESPACE);
		assertNotNull(helper.getSingleNode(authorNode, "xs:sequence/xs:choice", Namespaces.XSD_NAMESPACE));
		assertEquals(2, helper.getNodes(authorNode, "xs:sequence/xs:choice/xs:element", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("assignedPerson", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.AssignedAuthorPerson", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[1]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[1]/@maxOccurs", Namespaces.XSD_NAMESPACE));

		assertEquals("assignedAuthoringDevice", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.AuthoringDevice", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("0", helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[2]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(authorNode, "xs:sequence/xs:choice/xs:element[2]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		Node componentNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.Component2']", Namespaces.XSD_NAMESPACE);
		assertNotNull(helper.getSingleNode(componentNode, "xs:sequence/xs:choice", Namespaces.XSD_NAMESPACE));
		assertEquals(2, helper.getNodes(componentNode, "xs:sequence/xs:choice/xs:element", Namespaces.XSD_NAMESPACE).getLength());
		
		assertEquals("nonXMLBody", helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.NonXMLBody", helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[1]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[1]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[1]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("structuredBody", helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.StructuredBody", helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[2]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[2]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(componentNode, "xs:sequence/xs:choice/xs:element[2]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		// Branch choices
		Node clinicalDocumentNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.ClinicalDocument']", Namespaces.XSD_NAMESPACE);
		assertEquals(3, helper.getNodes(clinicalDocumentNode, "xs:sequence/xs:choice", Namespaces.XSD_NAMESPACE).getLength());
		assertEquals(3, helper.getNodes(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element", Namespaces.XSD_NAMESPACE).getLength());

		assertEquals("0", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/@maxOccurs", Namespaces.XSD_NAMESPACE));

		assertEquals("informant", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.AssignedEntityInformant12", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[1]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[1]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[1]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("informant", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.RelatedEntityInformant12", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[2]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[2]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[2]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		assertEquals("informant", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[3]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.Informant12", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[3]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[3]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:choice[1]/xs:element[3]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		Node structuredBodyNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.StructuredBody']", Namespaces.XSD_NAMESPACE);
		assertEquals(1, helper.getNodes(structuredBodyNode, "xs:sequence/xs:choice", Namespaces.XSD_NAMESPACE).getLength());
		assertEquals(28, helper.getNodes(structuredBodyNode, "xs:sequence/xs:choice/xs:element", Namespaces.XSD_NAMESPACE).getLength());

		assertNull(helper.getAttributeValue(structuredBodyNode, "xs:sequence/xs:choice/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertEquals("unbounded", helper.getAttributeValue(structuredBodyNode, "xs:sequence/xs:choice/@maxOccurs", Namespaces.XSD_NAMESPACE));

		assertEquals("component", helper.getAttributeValue(structuredBodyNode, "xs:sequence/xs:choice/xs:element[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.AssessmentSectionComponent3", helper.getAttributeValue(structuredBodyNode, "xs:sequence/xs:choice/xs:element[1]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(structuredBodyNode, "xs:sequence/xs:choice/xs:element[1]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(structuredBodyNode, "xs:sequence/xs:choice/xs:element[1]/@maxOccurs", Namespaces.XSD_NAMESPACE));
	}

	@Test
	public void shouldFormatConstrainedDatatypes() throws Exception {
		Node clinicalDocumentNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.ClinicalDocument']", Namespaces.XSD_NAMESPACE);

		// typeId
		assertEquals("typeId", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.ClinicalDocument.typeId", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[2]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[2]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[2]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		Node typeIdNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.ClinicalDocument.typeId']", Namespaces.XSD_NAMESPACE);
		assertNotNull(typeIdNode);
		assertNull(helper.getSingleNode(typeIdNode, "xs:complexContent/xs:extension", Namespaces.XSD_NAMESPACE));
		assertEquals("II", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/@base", Namespaces.XSD_NAMESPACE));

		assertEquals("root", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("uid", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("2.16.840.1.113883.1.3", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@fixed", Namespaces.XSD_NAMESPACE));

		assertEquals("extension", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("st", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_HD000040", helper.getAttributeValue(typeIdNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@fixed", Namespaces.XSD_NAMESPACE));
		
		assertEquals("typeId", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.ClinicalDocument.typeId", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[2]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[2]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[2]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		// templateId
		assertEquals("templateId", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[3]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.ClinicalDocument.templateId", helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[3]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[3]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(clinicalDocumentNode, "xs:sequence/xs:element[3]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		Node templateIdNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.ClinicalDocument.templateId']", Namespaces.XSD_NAMESPACE);
		assertNotNull(templateIdNode);
		assertNull(helper.getSingleNode(templateIdNode, "xs:complexContent/xs:extension", Namespaces.XSD_NAMESPACE));
		assertEquals("II", helper.getAttributeValue(templateIdNode, "xs:complexContent/xs:restriction/@base", Namespaces.XSD_NAMESPACE));

		assertEquals("root", helper.getAttributeValue(templateIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("uid", helper.getAttributeValue(templateIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(templateIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("2.16.840.1.113883.10.20.22.1.4", helper.getAttributeValue(templateIdNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@fixed", Namespaces.XSD_NAMESPACE));
		
		// filter non-applied constraints
		Node serviceEventNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.ServiceEvent']", Namespaces.XSD_NAMESPACE);

		assertEquals("effectiveTime", helper.getAttributeValue(serviceEventNode, "xs:sequence/xs:element[6]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("IVL_TS", helper.getAttributeValue(serviceEventNode, "xs:sequence/xs:element[6]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.ServiceEvent.effectiveTime']", Namespaces.XSD_NAMESPACE));
		
		Node assignedAuthorNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.AssignedAuthor']", Namespaces.XSD_NAMESPACE);
		
		assertEquals("telecom", helper.getAttributeValue(assignedAuthorNode, "xs:sequence/xs:element[7]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("TEL", helper.getAttributeValue(assignedAuthorNode, "xs:sequence/xs:element[7]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.AssignedAuthor.telecom']", Namespaces.XSD_NAMESPACE));
		
		// Inferred - CS
		Node authenticatorNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.Authenticator']", Namespaces.XSD_NAMESPACE);

		assertEquals("signatureCode", helper.getAttributeValue(authenticatorNode, "xs:sequence/xs:element[5]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.Authenticator.signatureCode", helper.getAttributeValue(authenticatorNode, "xs:sequence/xs:element[5]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(authenticatorNode, "xs:sequence/xs:element[5]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(authenticatorNode, "xs:sequence/xs:element[5]/@maxOccurs", Namespaces.XSD_NAMESPACE));
		
		Node signatureCodeNode = helper.getSingleNode(schemaDocument, "/xs:schema/xs:complexType[@name='ConsultationNote.Authenticator.signatureCode']", Namespaces.XSD_NAMESPACE);
		assertNotNull(signatureCodeNode);
		assertNull(helper.getSingleNode(signatureCodeNode, "xs:complexContent/xs:extension", Namespaces.XSD_NAMESPACE));
		assertEquals("CS", helper.getAttributeValue(signatureCodeNode, "xs:complexContent/xs:restriction/@base", Namespaces.XSD_NAMESPACE));

		assertEquals("code", helper.getAttributeValue(signatureCodeNode, "xs:complexContent/xs:restriction/xs:attribute/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("cs", helper.getAttributeValue(signatureCodeNode, "xs:complexContent/xs:restriction/xs:attribute/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(signatureCodeNode, "xs:complexContent/xs:restriction/xs:attribute/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("S", helper.getAttributeValue(signatureCodeNode, "xs:complexContent/xs:restriction/xs:attribute/@fixed", Namespaces.XSD_NAMESPACE));

		// Special handling for StrucDoc.Text
		Schema outputSchema = new Schema();
		fixture.formatSchema(outputSchema, derivedMessageSet, "AdvanceDirectivesSectionentriesOptional");
		
		StringOutputStream stream = new StringOutputStream();
		this.serializer.write(outputSchema, stream);
		
		Document sectionDocument = new DocumentFactory().createFromString(stream.toString());
		assertEquals("StrucDoc.Text", helper.getAttributeValue(sectionDocument, "//xs:complexType[@name='AdvanceDirectivesSectionentriesOptional.Section']//xs:element[@name='text']/@type", Namespaces.XSD_NAMESPACE));

		// Inferred - CE
		Node sectionNode = helper.getSingleNode(sectionDocument, "/xs:schema/xs:complexType[@name='AdvanceDirectivesSectionentriesOptional.Section']", Namespaces.XSD_NAMESPACE);

		assertEquals("code", helper.getAttributeValue(sectionNode, "xs:sequence/xs:element[5]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("AdvanceDirectivesSectionentriesOptional.Section.code", helper.getAttributeValue(sectionNode, "xs:sequence/xs:element[5]/@type", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(sectionNode, "xs:sequence/xs:element[5]/@minOccurs", Namespaces.XSD_NAMESPACE));
		assertNull(helper.getAttributeValue(sectionNode, "xs:sequence/xs:element[5]/@maxOccurs", Namespaces.XSD_NAMESPACE));

		Node sectionCodeNode = helper.getSingleNode(sectionDocument, "/xs:schema/xs:complexType[@name='AdvanceDirectivesSectionentriesOptional.Section.code']", Namespaces.XSD_NAMESPACE);
		assertNotNull(sectionCodeNode);
		assertNull(helper.getSingleNode(sectionCodeNode, "xs:complexContent/xs:extension", Namespaces.XSD_NAMESPACE));
		assertEquals("CE", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/@base", Namespaces.XSD_NAMESPACE));

		assertEquals("code", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("cs", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("42348-3", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/xs:attribute[1]/@fixed", Namespaces.XSD_NAMESPACE));
		
		assertEquals("codeSystem", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("uid", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@type", Namespaces.XSD_NAMESPACE));
		assertEquals("required", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@use", Namespaces.XSD_NAMESPACE));
		assertEquals("2.16.840.1.113883.6.1", helper.getAttributeValue(sectionCodeNode, "xs:complexContent/xs:restriction/xs:attribute[2]/@fixed", Namespaces.XSD_NAMESPACE));
	}
	
	@Test
	public void shouldFormatMetadata() throws Exception {
		assertEquals("urn:hl7-org:v3", helper.getAttributeValue(schemaDocument, "/xs:schema/@targetNamespace", Namespaces.XSD_NAMESPACE));
		assertEquals("qualified", helper.getAttributeValue(schemaDocument, "/xs:schema/@elementFormDefault", Namespaces.XSD_NAMESPACE));
		assertEquals("Generated using message builder version 2.0.", helper.getTextString(schemaDocument, "/xs:schema/xs:annotation/xs:documentation/text()", Namespaces.XSD_NAMESPACE));
		
		assertEquals(29, helper.getNodes(schemaDocument, "/xs:schema/xs:include").getLength());
		assertEquals("AllergiesSectionentriesOptional.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[1]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("AllergiesSectionentriesRequired.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[2]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("AssessmentAndPlanSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[3]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("AssessmentSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[4]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ChiefComplaintAndReasonForVisitSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[5]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ChiefComplaintSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[6]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("FamilyHistorySection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[7]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("GeneralStatusSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[8]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("HistoryOfPastIllnessSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[9]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("HistoryOfPresentIllnessSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[10]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ImmunizationsSectionentriesOptional.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[11]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ImmunizationsSectionentriesRequired.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[12]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("MedicationsSectionentriesOptional.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[13]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("MedicationsSectionentriesRequired.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[14]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("POCD_MT000040.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[15]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("PhysicalExamSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[16]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("PlanOfCareSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[17]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ProblemSectionentriesOptional.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[18]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ProblemSectionentriesRequired.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[19]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ProceduresSectionentriesOptional.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[20]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ProceduresSectionentriesRequired.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[21]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ReasonForReferralSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[22]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ReasonForVisitSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[23]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ResultsSectionentriesOptional.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[24]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ResultsSectionentriesRequired.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[25]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("ReviewOfSystemsSection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[26]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("SocialHistorySection.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[27]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("VitalSignsSectionentriesOptional.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[28]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		assertEquals("VitalSignsSectionentriesRequired.xsd", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:include[29]/@schemaLocation", Namespaces.XSD_NAMESPACE));
		
		assertEquals("ClinicalDocument", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:element/@name", Namespaces.XSD_NAMESPACE));
		assertEquals("ConsultationNote.ClinicalDocument", helper.getAttributeValue(schemaDocument, "/xs:schema/xs:element/@type", Namespaces.XSD_NAMESPACE));
		
		Schema outputSchema = new Schema();
		fixture.formatSchema(outputSchema, derivedMessageSet, "AdvanceDirectivesSectionentriesOptional");
		
		StringOutputStream stream = new StringOutputStream();
		this.serializer.write(outputSchema, stream);
		
		Document sectionDocument = new DocumentFactory().createFromString(stream.toString());
		assertNull(helper.getSingleNode(sectionDocument, "/xs:schema/xs:element", Namespaces.XSD_NAMESPACE));
	}
}
