package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.xml.Cardinality;

public class BusinessNameDeltaCalculatorTest {
	
	@Test
	public void shouldDetectDocumentationChange() throws Exception {
		BusinessNameDeltaCalculator calculator = new BusinessNameDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createRelationship("address"), 
				createRelationship("patientAddress")); 
		assertNotNull("delta", delta);
	}

	
	@Test
	public void shouldIgnoreSameDocumentation() throws Exception {
		BusinessNameDeltaCalculator calculator = new BusinessNameDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createRelationship("address"), 
				createRelationship("address")); 
		assertNull("no delta", delta);
	}
	
	private Attribute createRelationship(String businessName) throws Exception {
		Attribute attribute = createAttribute("id", new Cardinality(0,1), "II");
		attribute.getDocumentation().setBusinessName(businessName);
		return attribute;
	}

}
