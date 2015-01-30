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

package ca.infoway.messagebuilder.tools.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.StringWriter;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.cda.CdaXsdProcessor;
import ca.infoway.messagebuilder.generator.cda.Schema;
import ca.infoway.messagebuilder.generator.template.CdaTemplateProcessor;
import ca.infoway.messagebuilder.generator.template.CdaTemplateProcessorTest;
import ca.infoway.messagebuilder.generator.template.TemplateExport;
import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinition;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

@RunWith(MockitoJUnitRunner.class)
public class TemplateApplierTest {

	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static MessageSet derivedMessageSet;
	private static Document document;
	
	private XPathHelper xpathHelper = new XPathHelper();
	
	@BeforeClass
	public static void setUp() throws Exception {
		OutputUI outputUI = Mockito.mock(OutputUI.class);
		
		Schema schema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/POCD_MT000040_SDTC.xsd"));
		Schema supplementalSchema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/SDTC.xsd"));
		
		MessageSet messageSet = new MessageSet();
		messageSet.setCda(true);
		messageSet.setGeneratedAsR2(true);
		new CdaXsdProcessor(outputUI).processSchema(schema, supplementalSchema, messageSet);
		
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CdaTemplateProcessorTest.class.getResourceAsStream("/Consolidation.xml"));
		ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, CdaTemplateProcessorTest.class.getResourceAsStream("/voc.xml"));
		
		TemplateSet templateSet = new TemplateSet();
		new CdaTemplateProcessor(valueSetDefinition, outputUI).parseTemplate(templateExport, messageSet, templateSet);
		
		TemplateApplier applier = new TemplateApplier();
		derivedMessageSet = applier.resolveToMessageSet(messageSet, templateSet, "");
		
		StringWriter writer = new StringWriter();
		serializer.write(derivedMessageSet, writer);
		
		DocumentFactory factory = new DocumentFactory();
		document = factory.createFromString(writer.toString());
	}
	
	@Ignore
	@Test
	public void shouldGenerateSampleOutput() throws Exception {
		File file = new File("C:\\TEMP\\outputMessageSet.xml");
		file.createNewFile();
		serializer.write(derivedMessageSet, file);
	}
	
	@Test
	public void shouldHandleMetadata() throws Exception {
		assertEquals("true", xpathHelper.getAttributeValue(document, "messageSet/@generatedAsR2"));
	}
	
	@Test
	public void shouldHandleSimpleClosedTemplate() throws Exception {
		Node packageEntryNode = xpathHelper.getSingleNode(document, "//packageEntry[@name=\"EstimatedDateOfDelivery\"]");
		assertNotNull("the package entry does not exist", packageEntryNode);
		
		assertEquals("package location name", "EstimatedDateOfDelivery", xpathHelper.getAttributeValue(packageEntryNode, "packageLocation/@name"));
		assertEquals("package location entry point", "EstimatedDateOfDelivery.Observation", xpathHelper.getAttributeValue(packageEntryNode, "packageLocation/@rootType"));

		Node entryNode = xpathHelper.getSingleNode(packageEntryNode, "//entry[@name=\"EstimatedDateOfDelivery.Observation\"]");
		assertNotNull("the entry does not exist", entryNode);
		
		Node messagePartNode = xpathHelper.getSingleNode(entryNode, "messagePart[@name=\"EstimatedDateOfDelivery.Observation\"]");
		assertNotNull("the message part does not exist", messagePartNode);
		
		assertNull("structural attribute deleted", xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"nullFlavor\"]"));

		Node relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"classCode\"]");
		assertNotNull("structural attribute constrained", relationshipNode);
		assertEquals("type retained", "CS", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("domain type retained", "ActClassObservation", xpathHelper.getAttributeValue(relationshipNode, "@domainType"));
		assertEquals("fixed value changed", "OBS", xpathHelper.getAttributeValue(relationshipNode, "@fixedValue"));

		assertNull("non-structural attribute deleted", xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"realmCode\"]"));

		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"templateId\"]");
		assertNotNull("non-structural attribute constrained", relationshipNode);
		assertEquals("type retained", "LIST<II>", xpathHelper.getAttributeValue(relationshipNode, "@type"));	// will change
		assertEquals("cardinality changed", "*", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"value\"]");
		assertNotNull("non-structural attribute constrained", relationshipNode);
		assertEquals("type changed", "TS", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality changed", "1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		assertEquals("mark for datatype output", "true", xpathHelper.getAttributeValue(relationshipNode, "@printDatatype"));

		assertNull("association deleted", xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"subject\"]"));
	}
	
	@Test
	public void shouldHandleMultipartOpenTemplate() throws Exception {
		Node packageEntryNode = xpathHelper.getSingleNode(document, "//packageEntry[@name=\"PregnancyObservation\"]");
		assertNotNull("the package entry does not exist", packageEntryNode);
		
		assertEquals("package location name", "PregnancyObservation", xpathHelper.getAttributeValue(packageEntryNode, "packageLocation/@name"));
		assertEquals("package location entry point", "PregnancyObservation.Observation", xpathHelper.getAttributeValue(packageEntryNode, "packageLocation/@rootType"));
		
		Node entryNode = xpathHelper.getSingleNode(packageEntryNode, "//entry[@name=\"PregnancyObservation.Observation\"]");
		assertNotNull("the entry does not exist", entryNode);
		
		Node messagePartNode = xpathHelper.getSingleNode(entryNode, "messagePart[@name=\"PregnancyObservation.Observation\"]");
		assertNotNull("the message part does not exist", messagePartNode);
		
		Node relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"negationInd\"]");
		assertNotNull("structural attribute retained", relationshipNode);
		assertEquals("type retained", "BL", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality retained", "0-1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"classCode\"]");
		assertNotNull("structural attribute constrained", relationshipNode);
		assertEquals("type retained", "CS", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("domain type retained", "ActClassObservation", xpathHelper.getAttributeValue(relationshipNode, "@domainType"));
		assertEquals("fixed value changed", "OBS", xpathHelper.getAttributeValue(relationshipNode, "@fixedValue"));
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"realmCode\"]");
		assertNotNull("non-structural attribute retained", relationshipNode);
		assertEquals("type retained", "LIST<CS>", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality retained", "0-*", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"templateId\"]");
		assertNotNull("non-structural attribute constrained", relationshipNode);
		assertEquals("type retained", "LIST<II>", xpathHelper.getAttributeValue(relationshipNode, "@type"));	// will change
		assertEquals("cardinality changed", "*", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"value\"]");
		assertNotNull("non-structural attribute constrained", relationshipNode);
		assertEquals("type changed", "CD", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality changed", "1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		assertEquals("fixed value changed", "77386006", xpathHelper.getAttributeValue(relationshipNode, "@fixedValue"));
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"subject\"]");
		assertNotNull("association retained", relationshipNode);
		assertEquals("type retained", "POCD_MT000040.Subject", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality retained", "0-1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"entryRelationship\"]");
		assertNotNull("association constrained", relationshipNode);
		assertEquals("type changed", "PregnancyObservation.EntryRelationshipChoice", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality changed", "0-*", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));

		Node entryChoiceNode = xpathHelper.getSingleNode(packageEntryNode, "//entry[@name=\"PregnancyObservation.EntryRelationshipChoice\"]");
		assertNotNull("the choice does not exist", entryChoiceNode);
		assertEquals(2, xpathHelper.getNodes(entryChoiceNode, "messagePart/specializationChild").getLength());
		assertEquals("PregnancyObservation.EntryRelationship", xpathHelper.getAttributeValue(entryChoiceNode, "messagePart/specializationChild[1]/@name"));
		assertEquals("POCD_MT000040.EntryRelationship", xpathHelper.getAttributeValue(entryChoiceNode, "messagePart/specializationChild[2]/@name"));
		assertEquals("true", xpathHelper.getAttributeValue(entryChoiceNode, "messagePart/specializationChild[2]/@isDefault"));
		
		entryNode = xpathHelper.getSingleNode(packageEntryNode, "//entry[@name=\"PregnancyObservation.EntryRelationship\"]");
		assertNotNull("the entry does not exist", entryNode);
		
		messagePartNode = xpathHelper.getSingleNode(entryNode, "messagePart[@name=\"PregnancyObservation.EntryRelationship\"]");
		assertNotNull("the message part does not exist", messagePartNode);
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"observation\"]");
		assertNotNull("observation association exists", relationshipNode);
		assertEquals("cardinality changed", "1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		assertEquals("observation class changed", "EstimatedDateOfDelivery.Observation", xpathHelper.getAttributeValue(relationshipNode, "@type"));
	}
	
	@Test
	public void shallHandleUSRealmHeader() throws Exception {
		Node realmCodeNode = xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.ClinicalDocument\"]/relationship[@name=\"realmCode\"]");
		assertNotNull("realm code relationship should exist", realmCodeNode);
		assertEquals("realm code fixed value", "US", xpathHelper.getAttributeValue(realmCodeNode, "@fixedValue"));
		
		// disambiguate duplicated message parts
		assertEquals("USRealmHeader.DataEntererAssignedEntity", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.DataEnterer\"]/relationship[@name=\"assignedEntity\"]/@type"));
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.DataEnterer\"]/relationship[@name=\"assignedEntity\"]/@cardinality"));
		assertEquals("USRealmHeader.DataEntererPerson", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.DataEntererAssignedEntity\"]/relationship[@name=\"assignedPerson\"]/@type"));
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.DataEntererAssignedEntity\"]/relationship[@name=\"assignedPerson\"]/@cardinality"));
		assertEquals("*", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.DataEntererPerson\"]/relationship[@name=\"name\"]/@cardinality"));

		assertEquals("USRealmHeader.Performer1AssignedEntity", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.Performer1\"]/relationship[@name=\"assignedEntity\"]/@type"));
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.Performer1\"]/relationship[@name=\"assignedEntity\"]/@cardinality"));
		assertEquals("POCD_MT000040.Person", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.Performer1AssignedEntity\"]/relationship[@name=\"assignedPerson\"]/@type"));
		assertEquals("0-1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.Performer1AssignedEntity\"]/relationship[@name=\"assignedPerson\"]/@cardinality"));
		
		assertEquals("USRealmHeader.GuardianPerson", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.Guardian\"]/relationship[@name=\"guardianPerson\"]/@type"));
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.Guardian\"]/relationship[@name=\"guardianPerson\"]/@cardinality"));
		
		// handle fancy disambiguation for informants
		assertNotNull(xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.ClinicalDocument\"]/relationship[@name=\"informant\"]/choice[@type=\"USRealmHeader.AssignedEntityInformant12\"]"));
		assertNotNull(xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.ClinicalDocument\"]/relationship[@name=\"informant\"]/choice[@type=\"USRealmHeader.RelatedEntityInformant12\"]"));
		assertNotNull(xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.Informant12Choice\"]/specializationChild[@name=\"USRealmHeader.AssignedEntityInformant12\"]"));
		assertNotNull(xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.Informant12Choice\"]/specializationChild[@name=\"USRealmHeader.RelatedEntityInformant12\"]"));
		assertNotNull(xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.AssignedEntityInformant12\"]/relationship[@name=\"assignedEntity\"]"));
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.AssignedEntityInformant12\"]/relationship[@name=\"assignedEntity\"]/@cardinality"));
		assertEquals("USRealmHeader.AssignedEntityInformant12AssignedEntity", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.AssignedEntityInformant12\"]/relationship[@name=\"assignedEntity\"]/@type"));
		assertNull(xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.AssignedEntityInformant12\"]/relationship[@name=\"relatedEntity\"]"));
		assertNotNull(xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.RelatedEntityInformant12\"]/relationship[@name=\"relatedEntity\"]"));
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.RelatedEntityInformant12\"]/relationship[@name=\"relatedEntity\"]/@cardinality"));
		assertEquals("USRealmHeader.RelatedEntityRelatedEntity", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"USRealmHeader.RelatedEntityInformant12\"]/relationship[@name=\"relatedEntity\"]/@type"));
		assertNull(xpathHelper.getSingleNode(document, "//messagePart[@name=\"USRealmHeader.RelatedEntityInformant12\"]/relationship[@name=\"assignedEntity\"]"));
		
		assertEquals("assignedPerson", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ContinuityOfCareDocumentCCD.AssignedAuthor\"]/relationship[@name=\"assignedAuthorChoice\"]/choice[1]/@name"));
		assertEquals("ContinuityOfCareDocumentCCD.AssignedAuthorPerson", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ContinuityOfCareDocumentCCD.AssignedAuthor\"]/relationship[@name=\"assignedAuthorChoice\"]/choice[1]/@type"));
		assertEquals("assignedAuthoringDevice", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ContinuityOfCareDocumentCCD.AssignedAuthor\"]/relationship[@name=\"assignedAuthorChoice\"]/choice[2]/@name"));
		assertEquals("ContinuityOfCareDocumentCCD.AuthoringDevice", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ContinuityOfCareDocumentCCD.AssignedAuthor\"]/relationship[@name=\"assignedAuthorChoice\"]/choice[2]/@type"));
	}
	
	@Test
	public void shallHandleTemplateInheritance() throws Exception {
		// Inherited from ancestor
		Node realmCodeNode = xpathHelper.getSingleNode(document, "//messagePart[@name=\"ProgressNote.ClinicalDocument\"]/relationship[@name=\"realmCode\"]");
		assertNotNull("realm code relationship should exist", realmCodeNode);
		assertEquals("realm code fixed value", "US", xpathHelper.getAttributeValue(realmCodeNode, "@fixedValue"));
		
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.ClinicalDocument\"]/relationship[@name=\"title\"]/@cardinality"));

		assertEquals("ProgressNote.DataEntererAssignedEntity", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.DataEnterer\"]/relationship[@name=\"assignedEntity\"]/@type"));
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.DataEnterer\"]/relationship[@name=\"assignedEntity\"]/@cardinality"));

		// Local to this template
		
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.ClinicalDocument\"]/relationship[@name=\"code\"]/@cardinality"));
		assertEquals("VALUE_SET", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.ClinicalDocument\"]/relationship[@name=\"code\"]/@domainSource"));
		assertEquals("ProgressNoteDocumentTypeCode", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.ClinicalDocument\"]/relationship[@name=\"code\"]/@domainType"));

		// documentationOf/serviceEvent/classCode
		assertEquals("ProgressNote.DocumentationOf", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.ClinicalDocument\"]/relationship[@name=\"documentationOf\"]/@type"));
		assertEquals("ProgressNote.ServiceEvent", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.DocumentationOf\"]/relationship[@name=\"serviceEvent\"]/@type"));
		assertEquals("1", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.ServiceEvent\"]/relationship[@name=\"classCode\"]/@cardinality"));
		assertEquals("PCPR", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.ServiceEvent\"]/relationship[@name=\"classCode\"]/@fixedValue"));
	}
	
	@Test
	public void shouldHandleConstrainedDatatypes() throws Exception {
		// Inherited from ancestor
		Node constrainedDatatypeNode = xpathHelper.getSingleNode(document, "//constrainedDatatype[@name=\"POCD_MT000040.InfrastructureRoot.typeId\"]");
		assertNotNull("constrained datatype should exist", constrainedDatatypeNode);
		assertEquals("constrained datatype base", "II", xpathHelper.getAttributeValue(constrainedDatatypeNode, "@baseType"));
		assertEquals("constrained datatype type", "RES", xpathHelper.getAttributeValue(constrainedDatatypeNode, "@constraintType"));
		assertEquals("constrained datatype fixedValue", "2.16.840.1.113883.1.3", xpathHelper.getAttributeValue(constrainedDatatypeNode, "relationship[@name=\"root\"]/@fixedValue"));
		assertEquals("constrained datatype type", "uid", xpathHelper.getAttributeValue(constrainedDatatypeNode, "relationship[@name=\"root\"]/@type"));
		
		// new one added by constraint
		assertEquals("new constrained datatype reference", "EstimatedDateOfDelivery.Observation.templateId", 
				xpathHelper.getAttributeValue(document, "//messagePart[@name=\"EstimatedDateOfDelivery.Observation\"]/relationship[@name=\"templateId\"]/@constrainedType"));
		Node newConstrainedDatatypeNode = xpathHelper.getSingleNode(document, "//constrainedDatatype[@name=\"EstimatedDateOfDelivery.Observation.templateId\"]");
		assertNotNull("new constrained datatype should exist", newConstrainedDatatypeNode);
		assertEquals("new constrained datatype base", "II", xpathHelper.getAttributeValue(newConstrainedDatatypeNode, "@baseType"));
		assertEquals("new constrained datatype type", "RES", xpathHelper.getAttributeValue(newConstrainedDatatypeNode, "@constraintType"));
		Node newRelationshipNode = xpathHelper.getSingleNode(newConstrainedDatatypeNode, "relationship[@name=\"root\"]");
		assertNotNull(newRelationshipNode);
		assertEquals("2.16.840.1.113883.10.20.15.3.1", xpathHelper.getAttributeValue(newRelationshipNode, "@fixedValue"));
		assertEquals("1", xpathHelper.getAttributeValue(newRelationshipNode, "@cardinality"));
//		assertEquals("uid", xpathHelper.getAttributeValue(newRelationshipNode, "@type"));
		
		// vocabulary binding
		assertEquals("vocabulary binding base", "TEL", xpathHelper.getAttributeValue(newConstrainedDatatypeNode, "//constrainedDatatype[@name=\"USRealmHeader.PatientRole.telecom\"]/@baseType"));
		assertEquals("new constrained datatype type", "RES", xpathHelper.getAttributeValue(newConstrainedDatatypeNode, "//constrainedDatatype[@name=\"USRealmHeader.PatientRole.telecom\"]/@constraintType"));
		assertEquals("VALUE_SET", xpathHelper.getAttributeValue(newRelationshipNode, "//constrainedDatatype[@name=\"USRealmHeader.PatientRole.telecom\"]/relationship[@name=\"use\"]/@domainSource"));
		assertEquals("TelecomUse", xpathHelper.getAttributeValue(newRelationshipNode, "//constrainedDatatype[@name=\"USRealmHeader.PatientRole.telecom\"]/relationship[@name=\"use\"]/@domainType"));
	}
	
	@Test
	public void shouldCorrectCardinalityAndConformanceBugs() throws Exception {
		assertEquals("substance administration effective time cardinality", "*", 
				xpathHelper.getAttributeValue(document, "//messagePart[@name=\"MedicationActivity.SubstanceAdministration\"]/relationship[@name=\"effectiveTime\"]/@cardinality"));
		assertEquals("substance administration effective time datatype", "LIST<SXCM<TS>>", 
				xpathHelper.getAttributeValue(document, "//messagePart[@name=\"MedicationActivity.SubstanceAdministration\"]/relationship[@name=\"effectiveTime\"]/@type"));
		
		assertNull("DI informant not allowed", 
				xpathHelper.getSingleNode(document, "//messagePart[@name=\"DiagnosticImagingReport.ClinicalDocument\"]/relationship[@name=\"informant\"]"));

		assertEquals("complications note observation conformance", "MANDATORY", 
				xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ComplicationsOpNote.Entry\"]/relationship[@name=\"observation\"]/@conformance"));

		assertEquals("service event performer assigned entity cardinality", "1", 
				xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ContinuityOfCareDocumentCCD.Performer1\"]/relationship[@name=\"assignedEntity\"]/@cardinality"));

		assertEquals("progress note component conformance", "POPULATED", 
				xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.StructuredBody\"]/relationship[@name=\"component\"]/@conformance"));
		assertEquals("progress note component cardinality", "*", 
				xpathHelper.getAttributeValue(document, "//messagePart[@name=\"ProgressNote.StructuredBody\"]/relationship[@name=\"component\"]/@cardinality"));

		assertEquals("boundary observation datatype", "LIST<INT>", 
				xpathHelper.getAttributeValue(document, "//messagePart[@name=\"BoundaryObservation.Observation\"]/relationship[@name=\"value\"]/@type"));
	}
	
	@Test
	public void shouldCreateMockInteractions() throws Exception {
		assertEquals(11, xpathHelper.getNodes(document, "//interaction").getLength());
		assertEquals("USRealmHeader.ClinicalDocument", xpathHelper.getAttributeValue(document, "//interaction[@name=\"USRealmHeader\"]/@superTypeName"));
		assertEquals("2.16.840.1.113883.10.20.22.1.1", xpathHelper.getAttributeValue(document, "//interaction[@name=\"USRealmHeader\"]/@templateId"));
		assertNull(xpathHelper.getAttributeValue(document, "//interaction[@name=\"USRealmHeader\"]/@parentTemplateId"));
		assertEquals("ProgressNote.ClinicalDocument", xpathHelper.getAttributeValue(document, "//interaction[@name=\"ProgressNote\"]/@superTypeName"));
		assertEquals("2.16.840.1.113883.10.20.22.1.9", xpathHelper.getAttributeValue(document, "//interaction[@name=\"ProgressNote\"]/@templateId"));
		assertEquals("2.16.840.1.113883.10.20.22.1.1", xpathHelper.getAttributeValue(document, "//interaction[@name=\"ProgressNote\"]/@parentTemplateId"));
	}
	
	@Test
	public void shouldHandleExtendedModel() throws Exception {
		NodeList raceCodeNodes = xpathHelper.getNodes(document, "//messagePart[@name=\"USRealmHeader.Patient\"]/relationship[@name=\"raceCode\"]");
		assertEquals(1, raceCodeNodes.getLength());
		
		Node baseNode = raceCodeNodes.item(0);
		assertNotNull(baseNode);
		assertNull(xpathHelper.getAttributeValue(baseNode, "@namespace"));
		assertEquals("CE", xpathHelper.getAttributeValue(baseNode, "@type"));
		assertEquals("0-1", xpathHelper.getAttributeValue(baseNode, "@cardinality"));
		assertEquals("Race", xpathHelper.getAttributeValue(baseNode, "@domainType"));
		
		/* 
		// Temporarily suppress production of duplicate node, will restore in a future phase
		Node extendedNode = raceCodeNodes.item(1);
		assertNotNull(extendedNode);
		assertEquals("sdtc", xpathHelper.getAttributeValue(extendedNode, "@namespace"));
		assertEquals("LIST<CE>", xpathHelper.getAttributeValue(extendedNode, "@type"));
		assertEquals("0-*", xpathHelper.getAttributeValue(extendedNode, "@cardinality"));
		assertEquals("Race", xpathHelper.getAttributeValue(extendedNode, "@domainType"));
		 */
	}
	
	@Test
	public void shouldHandleContainedTemplates() throws Exception {
		assertEquals("2.16.840.1.113883.10.20.22.1.4", xpathHelper.getAttributeValue(document, "//packageLocation[@name=\"ConsultationNote\"]/@templateOid"));
		assertEquals("2.16.840.1.113883.10.20.22.1.1", xpathHelper.getAttributeValue(document, "//packageLocation[@name=\"ConsultationNote\"]/@impliedTemplateOid"));
		NodeList documentNodes = xpathHelper.getNodes(document, "//packageLocation[@name=\"ConsultationNote\"]/containedTemplate");
		assertEquals(28, documentNodes.getLength());
		assertEquals("2.16.840.1.113883.10.20.22.2.8", xpathHelper.getAttributeValue(documentNodes.item(0), "@templateOid"));
		assertEquals("0-1", xpathHelper.getAttributeValue(documentNodes.item(0), "@cardinality"));
		assertEquals("2.16.840.1.113883.10.20.22.2.10", xpathHelper.getAttributeValue(documentNodes.item(1), "@templateOid"));
		assertEquals("0-1", xpathHelper.getAttributeValue(documentNodes.item(1), "@cardinality"));
		
		assertEquals("2.16.840.1.113883.10.20.22.2.6.1", xpathHelper.getAttributeValue(document, "//packageLocation[@name=\"AllergiesSectionentriesRequired\"]/@templateOid"));
		assertEquals("2.16.840.1.113883.10.20.22.2.6", xpathHelper.getAttributeValue(document, "//packageLocation[@name=\"AllergiesSectionentriesRequired\"]/@impliedTemplateOid"));
		NodeList sectionNodes = xpathHelper.getNodes(document, "//packageLocation[@name=\"AllergiesSectionentriesRequired\"]/containedTemplate");
		assertEquals(1, sectionNodes.getLength());
		assertEquals("2.16.840.1.113883.10.20.22.4.30", xpathHelper.getAttributeValue(sectionNodes.item(0), "@templateOid"));
		assertEquals("*", xpathHelper.getAttributeValue(sectionNodes.item(0), "@cardinality"));
		
		assertEquals("2.16.840.1.113883.10.20.22.4.36", xpathHelper.getAttributeValue(document, "//packageLocation[@name=\"AdmissionMedication\"]/@templateOid"));
		NodeList entryNodes = xpathHelper.getNodes(document, "//packageLocation[@name=\"AdmissionMedication\"]/containedTemplate");
		assertEquals(1, entryNodes.getLength());
		assertEquals("2.16.840.1.113883.10.20.22.4.16", xpathHelper.getAttributeValue(entryNodes.item(0), "@templateOid"));
		assertEquals("*", xpathHelper.getAttributeValue(entryNodes.item(0), "@cardinality"));
	}
}
