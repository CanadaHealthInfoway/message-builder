package ca.infoway.messagebuilder.generator;

import static ca.infoway.messagebuilder.generator.Namespaces.MIF2_NAMESPACE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class EntryPointAssemblerTest {
	
	@Test
	public void shouldFindInteractionName() throws Exception {
		Document document = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), 
						"PRPA_IN101205CA - Person Revise Event Accept.mif"));
		assertEquals("interaction name", "PRPA_IN101205CA", 
				EntryPointAssembler.getEntryPoint((Element) new XPathHelper().getSingleNode(
				document, "/mif2:interaction/mif2:packageLocation", MIF2_NAMESPACE)));
	}

}
