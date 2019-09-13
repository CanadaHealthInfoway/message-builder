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

package ca.infoway.messagebuilder.generator.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.generator.OutputUI;
import ca.infoway.messagebuilder.generator.cda.CdaXsdProcessor;
import ca.infoway.messagebuilder.generator.cda.Schema;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.cda.vocabulary.ValueSetDefinition;
import ca.infoway.messagebuilder.xml.delta.ConformanceConstraint;
import ca.infoway.messagebuilder.xml.delta.Constraint;
import ca.infoway.messagebuilder.xml.delta.ConstraintChangeType;
import ca.infoway.messagebuilder.xml.delta.Delta;
import ca.infoway.messagebuilder.xml.delta.DeltaChangeType;
import ca.infoway.messagebuilder.xml.template.Template;
import ca.infoway.messagebuilder.xml.template.TemplateSet;

@RunWith(MockitoJUnitRunner.class)
public class CanadianHeaderTemplateProcessorTest {
	
	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static TemplateSet templateSet = new TemplateSet();
	
	@BeforeClass
	public static void setUp() throws Exception {
		OutputUI outputUI = Mockito.mock(OutputUI.class);
		
		Schema schema = (Schema) serializer.read(Schema.class, CanadianHeaderTemplateProcessorTest.class.getResourceAsStream("/POCD_MT000040.xsd"));
		
		MessageSet messageSet = new MessageSet();
		new CdaXsdProcessor(outputUI).processSchema(schema, null, messageSet);
		
		TemplateExport templateExport = (TemplateExport) serializer.read(TemplateExport.class, CanadianHeaderTemplateProcessorTest.class.getResourceAsStream("/pCS-header.xml"));
		ValueSetDefinition valueSetDefinition = (ValueSetDefinition) serializer.read(ValueSetDefinition.class, CanadianHeaderTemplateProcessorTest.class.getResourceAsStream("/pCS-voc.xml"));
		
		new CdaTemplateProcessor(valueSetDefinition, outputUI).parseTemplate(templateExport, messageSet, templateSet);
	}
	
	@Test
	public void shouldCreateTemplates() throws Exception {
		assertNotNull(templateSet);
		
		Template template = templateSet.getByOid("2.16.840.1.113883.2.20.4.1.1");
		assertNotNull(template);
		assertTrue(template.isOpen());
		assertEquals("ClinicalDocument", template.getContextType());
		assertEquals("document", template.getTemplateType());
		assertEquals("ClinicalDocument", template.getContext());
		assertEquals("PanCanadianHeader", template.getPackageName());
		assertEquals("PanCanadianHeader.ClinicalDocument", template.getEntryClassName());
		
	}
	
	@Test
	public void shouldHandleCanadianConformanceRules() throws Exception {
		Template template = templateSet.getByOid("2.16.840.1.113883.2.20.4.1.1");
		assertNotNull(template);
		List<Delta> deltas = template.getDeltas();
		
		boolean foundClassCode = false;
		boolean foundId = false;
		boolean foundPatientRole = false;
		for (Delta delta : deltas) {
			if (delta.getClassName().equals("PanCanadianHeader.ClinicalDocument") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("PanCanadianHeader.ClinicalDocument") && delta.getRelationshipName().equals("classCode")) {
				foundClassCode = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.MANDATORY, ((ConformanceConstraint) conformanceConstraint).getNewValue());
			} else if (delta.getClassName().equals("PanCanadianHeader.ClinicalDocument") && delta.getRelationshipName().equals("id")) {
				foundId = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.MANDATORY, ((ConformanceConstraint) conformanceConstraint).getNewValue());
			}
			
			if (delta.getClassName().equals("PanCanadianHeader.RecordTarget") && delta.getRelationshipName() == null) {
				assertEquals(DeltaChangeType.CLONE, delta.getDeltaChangeType());
			} else if (delta.getClassName().equals("PanCanadianHeader.RecordTarget") && delta.getRelationshipName().equals("patientRole")) {
				foundPatientRole = true;
				
				assertEquals(DeltaChangeType.DEFINITION, delta.getDeltaChangeType());
				
				Constraint conformanceConstraint = delta.getConstraint(ConstraintChangeType.CHANGE_CONFORMANCE);
				assertNotNull(conformanceConstraint);
				assertEquals(ConformanceLevel.MANDATORY, ((ConformanceConstraint) conformanceConstraint).getNewValue());
			}
			
		}
		assertTrue(foundClassCode);
		assertTrue(foundId);
		assertTrue(foundPatientRole);
	}

}
