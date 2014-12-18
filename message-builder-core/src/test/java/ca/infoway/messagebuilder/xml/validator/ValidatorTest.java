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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.xml.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

@Ignore  // TM - FIXME - CDA -  need to determine if these can be adjusted to work with new validator
public class ValidatorTest {
	
	@Before
	public void setUp() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}

	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
	public void testValidate() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA.xml");
		assertNoErrors("result", result.getHl7Errors());
	}
	
	@Test
	public void testValidateCaseWhereTemplateTypeIsAlsoChoiceType() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPM_IN306011CA.xml");
		assertNoErrors("result", result.getHl7Errors());
	}
	
	@Test
	public void testValidateMessageWithLocalExtensions() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_with_additional_namespace.xml");
		assertNoErrors("result", result.getHl7Errors());
	}
	
	private void assertNoErrors(String string, List<Hl7Error> hl7Errors) {
		for (Hl7Error hl7Error : hl7Errors) {
			fail(hl7Error.getMessage());
		}
	}

	@Test
	public void testValidationFailureOnAttribute() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_invalid.xml");

		for (Hl7Error error : result.getHl7Errors()) {
			System.out.println(error);
		}
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/receiver/device/id", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureOnFixedValue() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_with_fixed_value_error.xml");
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/controlActEvent/@classCode", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureWithExtraAttributed() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_with_extra_structural_attribute.xml");
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/controlActEvent/@fred", result.getHl7Errors().get(0).getPath());
	}

	@Test
	public void testValidationFailureWithMissingAssociation() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_with_missing_association.xml");
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/sender", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureWithTooManyInstancesOfAssociation() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_with_too_many_associations.xml");
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/sender", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureWithMissingNamespace() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_missing_namespace.xml");
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureWithExtraElements() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_with_extra_elements.xml");
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/fred", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationNoFailureDueToSchemaLocation() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_with_schema_location.xml");
		
		assertNoErrors("result", result.getHl7Errors());
	}
	
	@Test
	public void testValidationOfUnknownType() throws Exception {
		MessageValidatorResult result = validateWithMockService("COMT_IN700001CA.xml");
		
		assertEquals("result", 1, result.getHl7Errors().size());
	}
	
	@Test
	public void testValidationWithNullFlavor() throws Exception {
		MessageValidatorResult result = validateWithMockService("PRPA_IN101101CA_with_nullFlavor.xml");
		assertNoErrors("result", result.getHl7Errors());
	}
	
	private MessageValidatorResult validateWithMockService(String resourceName) throws IOException, SAXException {
		if (!resourceName.startsWith("/")) {
			resourceName = "/" + resourceName;
		}
		Document document = new DocumentFactory().createFromResource(new ClasspathResource(this.getClass(), resourceName));
		MessageDefinitionService messageDefinitionService = new MessageDefinitionServiceFactory().create();
		return new MessageValidatorImpl(messageDefinitionService).validate(document, SpecificationVersion.V02R02);
	}
	
	private MessageValidatorResult validateWithActualService(String resourceName) throws IOException, SAXException {
		Document document = new DocumentFactory().createFromResource(new ClasspathResource(this.getClass(), resourceName));
		MessageDefinitionService messageDefinitionService = new MessageDefinitionServiceFactory().create();
		return new MessageValidatorImpl(messageDefinitionService).validate(document, SpecificationVersion.R02_04_02);
	}

	// SPD: the sample xmls are not interactions defined in MR2009
	@Test @Ignore
	public void testChiSampleXml1() throws Exception {
		MessageValidatorResult result = validateWithActualService("Test 1 PORX_IN000001CA.xml");
		assertNoErrors("result", result.getHl7Errors());
	}
	// SPD: the sample xmls are not interactions defined in MR2009
	@Test @Ignore
	public void testChiSampleXml2() throws Exception {
		MessageValidatorResult result = validateWithActualService("Test 2 PORX_IN000003CA.xml");
		assertNoErrors("result", result.getHl7Errors());
	}
	@Test @Ignore
	public void testIntelliwareSampleXml() throws Exception {
		MessageValidatorResult result = validateWithActualService("findCandidatesMr2009Sample.xml");
		assertNoErrors("result", result.getHl7Errors());
	}

}
