package ca.infoway.messagebuilder.generator.lang;

import static ca.infoway.messagebuilder.generator.lang.ProgrammingLanguage.C_SHARP;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.xml.Documentation;


public class TypeDocumentationTest {
	
	private StringWriter writer;

	@Before
	public void setUp() throws Exception {
		this.writer = new StringWriter();
	}
	
	@Test
	public void shouldWriteDocumentationWithBusinessNameInCSharp() throws Exception {
		Documentation documentation = new Documentation();
		documentation.setBusinessName("The Business Name");
		String output = write(documentation);	
		assertTrue("business name", output.contains("<summary>The Business Name</summary>"));
		
	}
	@Test
	public void shouldWriteVeryBasicDocumentationInCSharp() throws Exception {
		Documentation documentation = new Documentation();
		documentation.getParagraphs().add("I am the very model of a modern markup paragraph.");
		String output = write(documentation);	
		assertTrue("business name", output.contains("<summary>I am the very model of a modern markup paragraph.</summary>"));
		assertFalse("business name", output.contains("<remarks>"));
	}
	@Test
	public void shouldWriteMultipleParagraphDocumentationInCSharp() throws Exception {
		Documentation documentation = new Documentation();
		documentation.getParagraphs().add("Antimony arsenic aluminum selenium.");
		documentation.getParagraphs().add("And hydrogen and oxygen and nitrogen and rhenium.");
		documentation.getParagraphs().add("And nickel, neodymium, neptunium, germanium.");
		String output = write(documentation);	
		assertTrue("summary", output.contains("<summary>Antimony arsenic aluminum selenium.</summary>"));
		assertTrue("remarks", output.contains("<remarks>"));
	}

	private String write(Documentation documentation) throws IOException {
		new TypeDocumentation(documentation).write(C_SHARP, writer, 0);
		
		String output = writer.toString();
		System.out.println(output);
		return output;
	}
}
