package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class NameHelperTest {

	@Test
	public void shouldConcatenate() throws Exception {
		assertEquals("name", "ABCD_MT123456CA.Patient", NameHelper.createName("ABCD_MT123456CA", "Patient"));
	}
	
	@Test
	public void shouldDetermineRootName() throws Exception {
		Document document = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), "COCT_MT011001CA - Care Event identified.mif"));
		assertEquals("name", "COCT_MT011001CA", NameHelper.getOwnedEntryPoint(document.getDocumentElement()));
	}
}
