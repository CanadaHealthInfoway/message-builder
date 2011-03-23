package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAssociation;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.TypeName;

public class ConformanceDeltaCalculatorTest {
	
	@Test
	public void shouldDetectConformanceChange() throws Exception {
		ConformanceDeltaCalculator calculator = new ConformanceDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAssociation("id", new Cardinality(0,1), new Type(new TypeName("ABCD_MT123456CA.Fred")), ConformanceLevel.MANDATORY), 
				createAssociation("id", new Cardinality(0,2), new Type(new TypeName("ABCD_MT123456CA.Fred")), ConformanceLevel.POPULATED));
		assertNotNull("delta", delta);
	}
	
	@Test
	public void shouldIgnoreSameConformance() throws Exception {
		ConformanceDeltaCalculator calculator = new ConformanceDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAssociation("id", new Cardinality(0,1), new Type(new TypeName("ABCD_MT123456CA.Fred")), ConformanceLevel.MANDATORY), 
				createAssociation("id", new Cardinality(0,2), new Type(new TypeName("ABCD_MT123456CA.Fred")), ConformanceLevel.MANDATORY));
		assertNull("no delta", delta);
	}

}
