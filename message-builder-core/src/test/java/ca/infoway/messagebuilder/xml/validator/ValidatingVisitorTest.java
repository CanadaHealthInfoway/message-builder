package ca.infoway.messagebuilder.xml.validator;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;

public class ValidatingVisitorTest {

	public static final ConformanceLevel MANDATORY = ConformanceLevel.MANDATORY;
	public static final ConformanceLevel POPULATED = ConformanceLevel.POPULATED;

	@Test
	public void shouldHaveValidationErrors() throws Exception {
		assertShouldHaveValidationErrorsFor(MANDATORY);
		assertShouldHaveValidationErrorsFor(POPULATED);
	}
	
	public void assertShouldHaveValidationErrorsFor(ConformanceLevel conformanceLevel) throws Exception {
		ValidatingVisitor validatingVisitor = new ValidatingVisitor(SpecificationVersion.R02_04_02.getVersionLiteral());
		Relationship relationship = new Relationship();
		relationship.setName("value");
		relationship.setConformance(conformanceLevel);
		
		validatingVisitor.visitNonStructuralAttribute(createElement("<node/>"), new ArrayList<Element>(), relationship);
		
		List<Hl7Error> hl7Errors = validatingVisitor.getResult().getHl7Errors();
		assertFalse(hl7Errors.isEmpty());
	}
	
	private Element createElement(String xml) throws SAXException {
		return new DocumentFactory().createFromString(xml).getDocumentElement();
	}
	
}
