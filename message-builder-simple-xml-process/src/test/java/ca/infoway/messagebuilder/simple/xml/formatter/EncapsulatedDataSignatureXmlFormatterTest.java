package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class EncapsulatedDataSignatureXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToSignature() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">this is a signature</value>");
		EncapsulatedDataSignatureXmlFormatter formatter = new EncapsulatedDataSignatureXmlFormatter(new FormatterConfiguration());
		
		ED<String> st = formatter.format(new FormatterContextImpl(StandardDataType.ED_SIGNATURE, null), document.getDocumentElement());
		assertNotNull("st", st);
		assertEquals("this is a signature", st.getValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfSignatureIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + " />");
		EncapsulatedDataSignatureXmlFormatter formatter = new EncapsulatedDataSignatureXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_SIGNATURE, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfSignatureIsEmpty() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "></value>");
		EncapsulatedDataSignatureXmlFormatter formatter = new EncapsulatedDataSignatureXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.ED_SIGNATURE, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidSignatureIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "/>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		EncapsulatedDataSignatureXmlFormatter formatter = new EncapsulatedDataSignatureXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.ED_SIGNATURE, null);
		ED<String> st = formatter.format(formatContext, document.getDocumentElement());
		assertNull("st", st);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("No signature value provided", formatContext.getErrors().get(0).getMessage());
	}
}
