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

package ca.infoway.messagebuilder.xml.cdavalidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.junit.BeforeClass;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.MessageSet;
import ca.infoway.messagebuilder.xml.cdavalidator.ContainedTemplateValidator;

public class ContainedTemplateValidatorTest {
	
	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static MessageSet derivedMessageSet;
	
	@BeforeClass
	public static void setUp() throws Exception {
		derivedMessageSet = (MessageSet) serializer.read(MessageSet.class, ContainedTemplateValidatorTest.class.getResourceAsStream("cdaMessageSet.xml"));
	}
	
	@Test
	public void shouldValidateDocument() throws Exception {
		
		ContainedTemplateValidator validator = new ContainedTemplateValidator(derivedMessageSet.getPackageLocations().values());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(SchematronValidatorTest.class.getResourceAsStream("contained-template-test.xml")));
		StringWriter writer = new StringWriter();
		while (reader.ready()) {
			writer.append(reader.readLine());
		}

		ModelToXmlResult result = new ModelToXmlResult();
		validator.validate(writer.toString(), result);

		assertFalse(result.isValid());
		
		assertEquals(5, result.getHl7Errors().size());
		assertEquals("Missing section at document level - message", "Expected [1] instances of template 2.16.840.1.113883.10.20.22.2.6.1, but found 0", result.getHl7Errors().get(0).getMessage());
		assertEquals("Missing section at document level - path", "/ClinicalDocument", result.getHl7Errors().get(0).getPath());
		assertEquals("Extra section at document level - message", "Expected [1] instances of template 2.16.840.1.113883.10.20.22.2.1.1, but found 2", result.getHl7Errors().get(1).getMessage());
		assertEquals("Extra section at document level - path", "/ClinicalDocument", result.getHl7Errors().get(1).getPath());
		assertEquals("Missing entry at section level - message", "Expected [*] instances of template 2.16.840.1.113883.10.20.22.4.16, but found 0", result.getHl7Errors().get(3).getMessage());
		assertEquals("Missing entry at section level - path", "/ClinicalDocument/component/structuredBody/component[3]/section", result.getHl7Errors().get(3).getPath());
		assertEquals("Missing entryRelationship at entry level - message", "Expected [*] instances of template 2.16.840.1.113883.10.20.22.4.4, but found 0", result.getHl7Errors().get(4).getMessage());
		assertEquals("Missing entryRelationship at entry level - path", "/ClinicalDocument/component/structuredBody/component[1]/section/entry[2]/act", result.getHl7Errors().get(4).getPath());
	}
	
}
