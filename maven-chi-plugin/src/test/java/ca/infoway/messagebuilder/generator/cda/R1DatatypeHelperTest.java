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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.template.CdaTemplateProcessor;
import ca.infoway.messagebuilder.generator.template.CdaTemplateProcessorTest;
import ca.infoway.messagebuilder.generator.template.TemplateExport;
import ca.infoway.messagebuilder.tools.template.TemplateApplier;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinition;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

@RunWith(MockitoJUnitRunner.class)
public class R1DatatypeHelperTest {

	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private MessageSet derivedMessageSet;

	@Before
	public void setUp() throws Exception {
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
	}
	
	@Test
	public void shouldConvertR1toCDAR1() throws Exception {
		R1DatatypeHelper.convertBaseDatatypesToPolymorphic(derivedMessageSet);
		
		// In base template
		assertEquals("TSCDAR1", derivedMessageSet.getMessagePart("POCD_MT000040.Authenticator").getRelationship("time").getType());
		assertEquals("IVLTSCDAR1", derivedMessageSet.getMessagePart("POCD_MT000040.Act").getRelationship("effectiveTime").getType());
		assertEquals("LIST<SXCMTSCDAR1>", derivedMessageSet.getMessagePart("POCD_MT000040.SubstanceAdministration").getRelationship("effectiveTime").getType());
		
		// In constrained template
		assertEquals("TS.DATETIME", derivedMessageSet.getMessagePart("PanCanadianHeader.Authenticator").getRelationship("time").getType());
		assertEquals("TSCDAR1", derivedMessageSet.getMessagePart("PanCanadianHeader.ClinicalDocument").getRelationship("copyTime").getType());
		assertEquals("IVL<TS.DATETIME>", derivedMessageSet.getMessagePart("PanCanadianHeader.EncompassingEncounter").getRelationship("effectiveTime").getType());
		assertEquals("IVLTSCDAR1", derivedMessageSet.getMessagePart("PanCanadianHeader.EncounterParticipant").getRelationship("time").getType());
	}

	@Test
	public void shouldConvertCDAR1toR1() throws Exception {
		R1DatatypeHelper.convertBaseDatatypesToPolymorphic(derivedMessageSet);
		R1DatatypeHelper.convertPolymorphicDatatypesToBaseTypes(derivedMessageSet);
		
		// In base template
		assertEquals("TS", derivedMessageSet.getMessagePart("POCD_MT000040.Authenticator").getRelationship("time").getType());
		assertEquals("IVL<TS>", derivedMessageSet.getMessagePart("POCD_MT000040.Act").getRelationship("effectiveTime").getType());
		assertEquals("LIST<SXCM<TS>>", derivedMessageSet.getMessagePart("POCD_MT000040.SubstanceAdministration").getRelationship("effectiveTime").getType());
		
		// In constrained template
		assertEquals("TS.DATETIME", derivedMessageSet.getMessagePart("PanCanadianHeader.Authenticator").getRelationship("time").getType());
		assertEquals("TS", derivedMessageSet.getMessagePart("PanCanadianHeader.ClinicalDocument").getRelationship("copyTime").getType());
		assertEquals("IVL<TS.DATETIME>", derivedMessageSet.getMessagePart("PanCanadianHeader.EncompassingEncounter").getRelationship("effectiveTime").getType());
		assertEquals("IVL<TS>", derivedMessageSet.getMessagePart("PanCanadianHeader.EncounterParticipant").getRelationship("time").getType());
	}

	@Test
	public void shouldConvertSpecializedtoBase() throws Exception {
		R1DatatypeHelper.convertBaseDatatypesToPolymorphic(derivedMessageSet);
		R1DatatypeHelper.convertSpecializedDatatypesToBaseTypes(derivedMessageSet);
		
		// In base template
		assertEquals("TSCDAR1", derivedMessageSet.getMessagePart("POCD_MT000040.Authenticator").getRelationship("time").getType());
		assertEquals("IVLTSCDAR1", derivedMessageSet.getMessagePart("POCD_MT000040.Act").getRelationship("effectiveTime").getType());
		assertEquals("LIST<SXCMTSCDAR1>", derivedMessageSet.getMessagePart("POCD_MT000040.SubstanceAdministration").getRelationship("effectiveTime").getType());
		
		// In constrained template
		assertEquals("TS", derivedMessageSet.getMessagePart("PanCanadianHeader.Authenticator").getRelationship("time").getType());
		assertEquals("TSCDAR1", derivedMessageSet.getMessagePart("PanCanadianHeader.ClinicalDocument").getRelationship("copyTime").getType());
		assertEquals("IVL<TS>", derivedMessageSet.getMessagePart("PanCanadianHeader.EncompassingEncounter").getRelationship("effectiveTime").getType());
		assertEquals("IVLTSCDAR1", derivedMessageSet.getMessagePart("PanCanadianHeader.EncounterParticipant").getRelationship("time").getType());
		assertEquals("AD", derivedMessageSet.getMessagePart("PanCanadianHeader.CustodianOrganization").getRelationship("addr").getType());
		assertEquals("LIST<AD>", derivedMessageSet.getMessagePart("PanCanadianHeader.AssignedAuthor").getRelationship("addr").getType());
		assertEquals("TEL", derivedMessageSet.getMessagePart("PanCanadianHeader.CustodianOrganization").getRelationship("telecom").getType());
		assertEquals("LIST<TEL>", derivedMessageSet.getMessagePart("PanCanadianHeader.AssignedAuthor").getRelationship("telecom").getType());
		assertEquals("PN", derivedMessageSet.getMessagePart("PanCanadianHeader.Place").getRelationship("name").getType());
		assertEquals("LIST<PN>", derivedMessageSet.getMessagePart("PanCanadianHeader.AssignedAuthorPerson").getRelationship("name").getType());
		
		// don't munge the associations
		assertEquals("POCD_MT000040.OrganizationPartOf", derivedMessageSet.getMessagePart("PanCanadianHeader.AssignedAuthorOrganization").getRelationship("asOrganizationPartOf").getType());
		assertEquals("PanCanadianHeader.CustodianOrganization", derivedMessageSet.getMessagePart("PanCanadianHeader.AssignedCustodian").getRelationship("representedCustodianOrganization").getType());
		
	}
}
