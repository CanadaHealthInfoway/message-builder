package ca.infoway.messagebuilder.generator;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ca.infoway.messagebuilder.generator.util.XPathHelper;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class Mif2XPathHelperTest {
	
	@Test
	public void shouldDetectTemplateRelationship() throws Exception {
		Document mif = new DocumentFactory().createFromResource(
				new ClasspathResource(getClass(), 
						"MCCI_MT002100CA - Request Transport Wrapper.mif"));
		
		Element element = (Element) new XPathHelper().getSingleNode(mif, "//mif2:traversableConnection[@name='controlActEvent']", Namespaces.MIF2_NAMESPACE);
		assertNotNull("target connection", element);
		
		Element templateParameter = Mif2XPathHelper.getTemplateParameter(element);
		
		assertNotNull("element", templateParameter);
		
	}

}
