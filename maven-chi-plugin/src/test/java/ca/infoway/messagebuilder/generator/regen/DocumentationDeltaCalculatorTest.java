package ca.infoway.messagebuilder.generator.regen;

import static ca.infoway.messagebuilder.generator.java.TypeAndRelationshipBuilder.createAttribute;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ca.infoway.messagebuilder.generator.java.Attribute;
import ca.infoway.messagebuilder.xml.Cardinality;

public class DocumentationDeltaCalculatorTest {
	
	@Test
	public void shouldDetectDocumentationChange() throws Exception {
		DocumentationDeltaCalculator calculator = new DocumentationDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createRelationship(Arrays.asList("line1", "line2")), 
				createRelationship(Arrays.asList("line1", "line3"))); 
		assertNotNull("delta", delta);
	}

	private Attribute createRelationship(List<String> lines) throws Exception {
		Attribute attribute = createAttribute("id", new Cardinality(0,1), "II");
		attribute.getDocumentation().getParagraphs().addAll(lines);
		
		return attribute;
	}
	
	@Test
	public void shouldIgnoreSameDocumentation() throws Exception {
		DocumentationDeltaCalculator calculator = new DocumentationDeltaCalculator();
		Delta delta = calculator.doFindDelta(null, 
				createRelationship(Arrays.asList("line1", "line2")), 
				createRelationship(Arrays.asList("line1", "line2"))); 
		assertNull("no delta", delta);
	}

}
