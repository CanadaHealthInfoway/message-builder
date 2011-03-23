package ca.infoway.messagebuilder.generator.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TemplateVariableGeneratorTest {
	
	@Test
	public void shouldFindVariableNameBasedOnTemplateParameterName() throws Exception {
		TemplateVariableGenerator generator = new TemplateVariableGenerator();
		TemplateVariable v1 = generator.getNext("RegisteredRole");
		assertEquals("v1", "RR", v1.getType());
		
		TemplateVariable v2 = generator.getNext("Act");
		assertEquals("v2", "ACT", v2.getType());
		
		TemplateVariable v3 = generator.getNext("RamblingRoomba");
		assertEquals("v3", "T", v3.getType());
		
		TemplateVariable v4 = generator.getNext("ReversibleRobe");
		assertEquals("v4", "U", v4.getType());
	}
	
	@Test
	public void shouldNotCollideWithStandardDataTypeName() throws Exception {
		TemplateVariableGenerator generator = new TemplateVariableGenerator();
		TemplateVariable v1 = generator.getNext("CorrectiveDiscussion");
		assertEquals("v1", "T", v1.getType());
	}
}
