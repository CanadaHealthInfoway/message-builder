package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.infoway.messagebuilder.xml.Cardinality;

public class CardinalityDeltaCalculatorTest {
	
	@Test
	public void shouldDetectCardinalityChange() throws Exception {
		CardinalityDeltaCalculator calculator = new CardinalityDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAttribute("id", new Cardinality(0,1), "II"), 
				createAttribute("id", new Cardinality(0,2), "II"));
		assertNotNull("delta", delta);
	}
	
	@Test
	public void shouldIgnoreSameCardinality() throws Exception {
		CardinalityDeltaCalculator calculator = new CardinalityDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAttribute("id", new Cardinality(0,1), "II"), 
				createAttribute("id", new Cardinality(0,1), "II"));
		assertNull("no delta", delta);
	}

}
