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
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.infoway.messagebuilder.generator.cda.CdaXsdProcessor;
import ca.infoway.messagebuilder.generator.cda.Schema;
import ca.infoway.messagebuilder.generator.template.CdaTemplateProcessor;
import ca.infoway.messagebuilder.generator.template.CdaTemplateProcessorTest;
import ca.infoway.messagebuilder.generator.template.TemplateExport;
import ca.infoway.messagebuilder.generator.template.ValueSetDefinition;
import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

public class TemplateApplierTest {

	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static MessageSet derivedMessageSet;
	private static Document document;
	
	private XPathHelper xpathHelper = new XPathHelper();
	
	@BeforeClass
	public static void setUp() throws Exception {
		Schema schema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		new CdaXsdProcessor().processSchema(schema, messageSet);
		
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CdaTemplateProcessorTest.class.getResourceAsStream("/Consolidation.xml"));
		ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, CdaTemplateProcessorTest.class.getResourceAsStream("/voc.xml"));
		
		TemplateSet templateSet = new TemplateSet();
		new CdaTemplateProcessor(valueSetDefinition).parseTemplate(templateExport, messageSet, templateSet);
		
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
		assertEquals("type retained", "II", xpathHelper.getAttributeValue(relationshipNode, "@type"));	// will change
		assertEquals("cardinality changed", "1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"value\"]");
		assertNotNull("non-structural attribute constrained", relationshipNode);
		assertEquals("type changed", "TS", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality changed", "1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));

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
		
		Node relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"nullFlavor\"]");
		assertNotNull("structural attribute retained", relationshipNode);
		assertEquals("type retained", "CS", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("domain type retained", "NullFlavor", xpathHelper.getAttributeValue(relationshipNode, "@domainType"));
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
		assertEquals("type retained", "II", xpathHelper.getAttributeValue(relationshipNode, "@type"));	// will change
		assertEquals("cardinality changed", "1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		
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
		assertEquals("type changed", "PregnancyObservation.EntryRelationship", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality changed", "0-1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));

		entryNode = xpathHelper.getSingleNode(packageEntryNode, "//entry[@name=\"PregnancyObservation.EntryRelationship\"]");
		assertNotNull("the entry does not exist", entryNode);
		
		messagePartNode = xpathHelper.getSingleNode(entryNode, "messagePart[@name=\"PregnancyObservation.EntryRelationship\"]");
		assertNotNull("the message part does not exist", messagePartNode);
		
		relationshipNode = xpathHelper.getSingleNode(messagePartNode, "relationship[@name=\"EntryRelationship_11\"]");
		assertNotNull("choice association exists", relationshipNode);
		assertEquals("type changed", "PregnancyObservation.EntryRelationship_11", xpathHelper.getAttributeValue(relationshipNode, "@type"));
		assertEquals("cardinality changed", "1", xpathHelper.getAttributeValue(relationshipNode, "@cardinality"));
		
		NodeList choiceList = xpathHelper.getNodes(relationshipNode, "choice");
		assertEquals("choice list has been narrowed", 1, choiceList.getLength());
		Node choice = choiceList.item(0);
		assertEquals("choice name retained", "observation", xpathHelper.getAttributeValue(choice, "@name"));
		assertEquals("choice class changed", "EstimatedDateOfDelivery.Observation", xpathHelper.getAttributeValue(choice, "@type"));

		entryNode = xpathHelper.getSingleNode(packageEntryNode, "//entry[@name=\"PregnancyObservation.EntryRelationship_11\"]");
		assertNotNull("the entry does not exist", entryNode);
		
		messagePartNode = xpathHelper.getSingleNode(entryNode, "messagePart[@name=\"PregnancyObservation.EntryRelationship_11\"]");
		assertNotNull("the message part does not exist", messagePartNode);
		assertEquals("message part should be abstract", "true", xpathHelper.getAttributeValue(messagePartNode, "@abstract"));
		
		NodeList childList = xpathHelper.getNodes(messagePartNode, "specializationChild");
		assertEquals("child list has been narrowed", 1, childList.getLength());
		Node child = childList.item(0);
		assertEquals("child name changed", "EstimatedDateOfDelivery.Observation", xpathHelper.getAttributeValue(child, "@name"));
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
}
