package ca.infoway.messagebuilder.generator.lang;

import static org.junit.Assert.*;

import org.junit.Test;


public class StringArrayToAnnotationDecoratorTest {
	
	@Test
	public void shouldProcessEmptyArrays() throws Exception {
		
		assertEquals("", new StringArrayToAnnotationDecorator().render());
		assertEquals("", new StringArrayToAnnotationDecorator((String[]) null).render());
	}
	
	@Test
	public void shouldProcessStandardInput() throws Exception {
		assertEquals("\"a\",\"b\",\"c\"", new StringArrayToAnnotationDecorator("a", "b", "c").render());
		assertEquals("\"a\",\"\",\"c\"", new StringArrayToAnnotationDecorator("a", "", "c").render());
		assertEquals("\"a\",\"\",\"c\"", new StringArrayToAnnotationDecorator("a", null, "c").render());
	}
	
	@Test
	public void shouldProcessSingleValueInput() throws Exception {
		assertEquals("\"a\"", new StringArrayToAnnotationDecorator("a").render());
	}
}
