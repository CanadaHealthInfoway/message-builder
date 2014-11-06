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

import ca.infoway.messagebuilder.generator.OutputUI;
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

@RunWith(MockitoJUnitRunner.class)
public class CanadianHeaderTemplateApplierTest {

	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static MessageSet derivedMessageSet;
	private static Document document;
	
	private XPathHelper xpathHelper = new XPathHelper();
	
	
	@BeforeClass
	public static void setUp() throws Exception {
		OutputUI outputUI = Mockito.mock(OutputUI.class);
		
		Schema schema = (Schema) serializer.read(Schema.class, CdaTemplateProcessorTest.class.getResourceAsStream("/POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		new CdaXsdProcessor(outputUI).processSchema(schema, messageSet);
		
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CdaTemplateProcessorTest.class.getResourceAsStream("/pCS-header.xml"));
		ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, CdaTemplateProcessorTest.class.getResourceAsStream("/pCS-voc.xml"));
		
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
		File file = new File("C:\\TEMP\\outputCanadianMessageSet.xml");
		file.createNewFile();
		serializer.write(derivedMessageSet, file);
	}
	
	@Test
	public void shouldHandleCanadianConformanceRules() throws Exception {
		assertEquals("MANDATORY", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.ClinicalDocument\"]/relationship[@name=\"classCode\"]/@conformance"));
		assertEquals("MANDATORY", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.ClinicalDocument\"]/relationship[@name=\"realmCode\"]/@conformance"));
		assertEquals("MANDATORY", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.ClinicalDocument\"]/relationship[@name=\"id\"]/@conformance"));
		assertEquals("OPTIONAL", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.ClinicalDocument\"]/relationship[@name=\"title\"]/@conformance"));
		assertEquals("POPULATED", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.ClinicalDocument\"]/relationship[@name=\"recordTarget\"]/@conformance"));
		assertEquals("MANDATORY", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.RecordTarget\"]/relationship[@name=\"patientRole\"]/@conformance"));
		assertEquals("POPULATED", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.Author\"]/relationship[@name=\"time\"]/@conformance"));
		assertEquals("POPULATED", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.Author\"]/relationship[@name=\"assignedAuthor\"]/@conformance"));
		assertEquals("MANDATORY", xpathHelper.getAttributeValue(document, "//messagePart[@name=\"PanCanadianHeader.Authenticator\"]/relationship[@name=\"signatureCode\"]/@conformance"));
	}
}
