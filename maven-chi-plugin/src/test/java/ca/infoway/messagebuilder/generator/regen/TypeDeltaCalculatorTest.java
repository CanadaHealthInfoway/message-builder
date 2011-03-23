package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAssociation;
import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Type;
import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.TypeName;

public class TypeDeltaCalculatorTest {
	
	@Test
	public void shouldIgnoreAttributeTypeChangeForSameBaseType() throws Exception {
		TypeDeltaCalculator calculator = new TypeDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAttribute("id", new Cardinality(0,1), "II"), 
				createAttribute("id", new Cardinality(0,1), "II.PUBLIC"));
		assertNull("delta", delta);
	}

	@Test
	public void shouldDetectAttributeTypeChange() throws Exception {
		TypeDeltaCalculator calculator = new TypeDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAttribute("id", new Cardinality(0,1), "INT"), 
				createAttribute("id", new Cardinality(0,1), "REAL"));
		assertNotNull("delta", delta);
	}

	@Test
	public void shouldDetectAttributeTypeChangeForDifferentParameters() throws Exception {
		TypeDeltaCalculator calculator = new TypeDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAttribute("id", new Cardinality(0,1), "IVL<TS>"), 
				createAttribute("id", new Cardinality(0,1), "IVL<INT>"));
		assertNotNull("delta", delta);
	}
	
	@Test
	public void shouldDetectAttributeTypeChangeForDifferentDomainType() throws Exception {
		TypeDeltaCalculator calculator = new TypeDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAttribute("id", new Cardinality(0,1), "CD", "ActStatus"), 
				createAttribute("id", new Cardinality(0,1), "CD", "AdministrativeGender"));
		assertNotNull("delta", delta);
	}
	
	@Test
	public void shouldIgnoreSameAttributeType() throws Exception {
		TypeDeltaCalculator calculator = new TypeDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAttribute("id", new Cardinality(0,1), "INT"), 
				createAttribute("id", new Cardinality(0,1), "INT"));
		assertNull("no delta", delta);
	}

	@Test
	public void shouldDetectAttributeToAssociationTypeChange() throws Exception {
		TypeDeltaCalculator calculator = new TypeDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAttribute("id", new Cardinality(0,1), "B"), 
				createAssociation("id", new Cardinality(0,1), new Type(new TypeName("B")), ConformanceLevel.MANDATORY));
		assertNotNull("delta", delta);
	}
	
	@Test
	public void shouldDetectAssociationTypeChange() throws Exception {
		TypeDeltaCalculator calculator = new TypeDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createAssociation("id", new Cardinality(0,1), new Type(new TypeName("A")), ConformanceLevel.MANDATORY), 
				createAssociation("id", new Cardinality(0,1), new Type(new TypeName("B")), ConformanceLevel.MANDATORY));
		assertNotNull("delta", delta);
	}
	
}

