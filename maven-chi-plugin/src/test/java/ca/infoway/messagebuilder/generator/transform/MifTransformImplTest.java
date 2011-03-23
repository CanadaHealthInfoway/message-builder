package ca.infoway.messagebuilder.generator.transform;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.generator.GeneratorException;
import ca.infoway.messagebuilder.generator.Mif2XPathHelper;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class MifTransformImplTest {

	private String transformerFactory;

	@Before
	public void initialize() {
		 this.transformerFactory = System.getProperty("javax.xml.transform.TransformerFactory");		
		 System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");		
	}
	
	@After
	public void teardown() {
		if (this.transformerFactory == null) {
			System.clearProperty("javax.xml.transform.TransformerFactory");
		} else {
			System.setProperty("javax.xml.transform.TransformerFactory", transformerFactory);
		}
	}
	
	@Test
	public void shouldTransformDocumentWithValidVersion() throws Exception {
		ClasspathResource xsltResource = new ClasspathResource(getClass(), "ConvertMifVersion.xslt");
		Document xsltDoc = new DocumentFactory().createFromStream(xsltResource.getInputStream());
		
		ClasspathResource mifResource = new ClasspathResource(getClass(), "PRPA_MT000041CA - Patient.mif");
		Document mifDoc = new DocumentFactory().createFromStream(mifResource.getInputStream());
		
		MifTransform mifTransform = new MifTransformImpl(xsltDoc);
		
		// confirm that the mif version is 2.1.x where x = 4, 5, 6 (in this case, 2.1.6)
		Assert.assertTrue(mifTransform.shouldBeTransformed(mifDoc));
		Assert.assertEquals("2.1.6", Mif2XPathHelper.getMifVersion(mifDoc));
		
		Document resultDoc = mifTransform.transform(mifDoc);

		Assert.assertEquals("correct converted version", "2.1.3", Mif2XPathHelper.getMifVersion(resultDoc));
		
		ClasspathResource expectedResource = new ClasspathResource(getClass(), "convertedFromCHI_PRPA_MT000041CA - Patient.mif");
		Document expectedDoc = new DocumentFactory().createFromStream(expectedResource.getInputStream());
		
		// should match the doc CHI converted for us
		XmlAssert.assertTreeEquals(expectedDoc, resultDoc);
	}
	
	@Test(expected=GeneratorException.class)
	public void shouldNotTransformDocumentWithInvalidVersion() throws Exception {
		ClasspathResource xsltResource = new ClasspathResource(getClass(), "ConvertMifVersion.xslt");
		Document xsltDoc = new DocumentFactory().createFromStream(xsltResource.getInputStream());
		
		ClasspathResource mifResource = new ClasspathResource(getClass(), "COCT_MT011001CA - Care Event identified.mif");
		Document mifDoc = new DocumentFactory().createFromStream(mifResource.getInputStream());
		
		MifTransform mifTransform = new MifTransformImpl(xsltDoc);
		
		// confirm that the mif version is 2.1.x where x = 4, 5, 6 (in this case, 2.1.6)
		Assert.assertFalse(mifTransform.shouldBeTransformed(mifDoc));
		Assert.assertEquals("2.1.3", Mif2XPathHelper.getMifVersion(mifDoc));
		
		@SuppressWarnings("unused")
		Document resultDoc = mifTransform.transform(mifDoc);
	}

}
