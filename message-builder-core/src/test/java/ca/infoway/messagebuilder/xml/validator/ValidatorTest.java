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
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionServiceFactory;

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
		MessageValidatorResult result = createValidator("PRPA_IN101101CA.xml").validate();
		assertNoErrors("result", result.getHl7Errors());
	}
	
	@Test
	public void testValidateCaseWhereTemplateTypeIsAlsoChoiceType() throws Exception {
		MessageValidatorResult result = createValidator("PRPM_IN306011CA.xml").validate();
		assertNoErrors("result", result.getHl7Errors());
	}
	
	@Test
	public void testValidateMessageWithLocalExtensions() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_with_additional_namespace.xml").validate();
		assertNoErrors("result", result.getHl7Errors());
	}
	
	private void assertNoErrors(String string, List<Hl7Error> hl7Errors) {
		for (Hl7Error hl7Error : hl7Errors) {
			fail(hl7Error.getMessage());
		}
	}

	@Test
	public void testValidationFailureOnAttribute() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_invalid.xml").validate();

		for (Hl7Error error : result.getHl7Errors()) {
			System.out.println(error);
		}
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/receiver/device/id", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureOnFixedValue() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_with_fixed_value_error.xml").validate();
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/controlActEvent/@classCode", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureWithExtraAttributed() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_with_extra_structural_attribute.xml").validate();
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/controlActEvent/@fred", result.getHl7Errors().get(0).getPath());
	}

	@Test
	public void testValidationFailureWithMissingAssociation() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_with_missing_association.xml").validate();
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/sender", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureWithTooManyInstancesOfAssociation() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_with_too_many_associations.xml").validate();
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/sender", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureWithMissingNamespace() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_missing_namespace.xml").validate();
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationFailureWithExtraElements() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_with_extra_elements.xml").validate();
		
		assertEquals("result", 1, result.getHl7Errors().size());
		assertEquals("message", "/PRPA_IN101101CA/fred", result.getHl7Errors().get(0).getPath());
	}
	
	@Test
	public void testValidationNoFailureDueToSchemaLocation() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_with_schema_location.xml").validate();
		
		assertNoErrors("result", result.getHl7Errors());
	}
	
	@Test
	public void testValidationOfUnknownType() throws Exception {
		MessageValidatorResult result = createValidator("COMT_IN700001CA.xml").validate();
		
		assertEquals("result", 1, result.getHl7Errors().size());
	}
	
	@Test
	public void testValidationWithNullFlavor() throws Exception {
		MessageValidatorResult result = createValidator("PRPA_IN101101CA_with_nullFlavor.xml").validate();
		assertNoErrors("result", result.getHl7Errors());
	}
	
	private Validator createValidator(String resourceName) throws IOException, SAXException {
		Document document = new DocumentFactory().createFromResource(new ClasspathResource(resourceName));
		return new Validator(new Service(), document, SpecificationVersion.V02R02.getVersionLiteral());
	}
	
	// SPD: the sample xmls are not interactions defined in MR2009
	@Test @Ignore
	public void testChiSampleXml1() throws Exception {
		Validator validator = createNewValidator("Test 1 PORX_IN000001CA.xml");
		MessageValidatorResult result = validator.validate();
		assertNoErrors("result", result.getHl7Errors());
	}
	// SPD: the sample xmls are not interactions defined in MR2009
	@Test @Ignore
	public void testChiSampleXml2() throws Exception {
		Validator validator = createNewValidator("Test 2 PORX_IN000003CA.xml");
		MessageValidatorResult result = validator.validate();
		assertNoErrors("result", result.getHl7Errors());
	}
	@Test @Ignore
	public void testIntelliwareSampleXml() throws Exception {
		Validator validator = createNewValidator("findCandidatesMr2009Sample.xml");
		MessageValidatorResult result = validator.validate();
		assertNoErrors("result", result.getHl7Errors());
	}

	private Validator createNewValidator(String resourceName) throws IOException, SAXException {
		Document document = new DocumentFactory().createFromResource(new ClasspathResource(resourceName));
		MessageDefinitionService messageDefinitionService = new MessageDefinitionServiceFactory().create();
		return new Validator(messageDefinitionService, document, SpecificationVersion.R02_04_02.getVersionLiteral());
	}
}
