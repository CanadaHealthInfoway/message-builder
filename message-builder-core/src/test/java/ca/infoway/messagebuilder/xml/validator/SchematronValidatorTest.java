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

package ca.infoway.messagebuilder.xml.validator;

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

import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.xml.MessageSet;

public class SchematronValidatorTest {
	
	private static Serializer serializer = new Persister(new AnnotationStrategy());
	private static MessageSet derivedMessageSet;
	
	@BeforeClass
	public static void setUp() throws Exception {
		derivedMessageSet = (MessageSet) serializer.read(MessageSet.class, SchematronValidatorTest.class.getResourceAsStream("cdaMessageSet.xml"));
	}
	
	@Test
	public void shouldValidateDocument() throws Exception {
		
		SchematronValidator validator = new SchematronValidator(derivedMessageSet.getSchematronContexts());
		BufferedReader reader = new BufferedReader(new InputStreamReader(SchematronValidatorTest.class.getResourceAsStream("problems-and-medications.xml")));
		StringWriter writer = new StringWriter();
		while (reader.ready()) {
			writer.append(reader.readLine());
		}
		ModelToXmlResult result = new ModelToXmlResult();
		validator.validate(writer.toString(), result);

		assertFalse(result.isValid());
		assertEquals(5, result.getHl7Errors().size());
		
		for (Hl7Error error : result.getHl7Errors()) {
			System.out.println(error.getMessage());
		}
		
	}
	
}
