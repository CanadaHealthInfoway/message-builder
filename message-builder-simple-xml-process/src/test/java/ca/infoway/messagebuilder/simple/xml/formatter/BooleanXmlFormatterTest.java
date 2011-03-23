package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class BooleanXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToBoolean() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">true</value>");
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(new FormatterConfiguration());
		
		BL bool = formatter.format(new FormatterContextImpl(StandardDataType.BL, null), document.getDocumentElement());
		assertNotNull("boolean", bool);
		assertEquals(Boolean.TRUE, bool.getValue());
	}

	// duplicated in anticipation of behaviour changing for different BL representations
	@Test
	public void shouldTransformXmlToBooleanIfMixedCase() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">FaLsE</value>");
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(new FormatterConfiguration());
		
		BL bool = formatter.format(new FormatterContextImpl(StandardDataType.BL, null), document.getDocumentElement());
		assertNotNull("boolean", bool);
		assertEquals(Boolean.FALSE, bool.getValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfValueIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "></value>");
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.BL, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNotABoolean() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">123.4</value>");
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.BL, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidBooleanIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">a string</value>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		BooleanXmlFormatter formatter = new BooleanXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.BL, null);
		BL bool = formatter.format(formatContext, document.getDocumentElement());
		assertNull("boolean", bool);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Invalid value provided for boolean", formatContext.getErrors().get(0).getMessage());
	}
}
