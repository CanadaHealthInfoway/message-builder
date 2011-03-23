package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class IntegerXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Test
	public void shouldTransformXmlToIntegerIfINT() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">-123</value>");
		IntegerXmlFormatter formatter = new IntegerXmlFormatter(new FormatterConfiguration());
		
		INT integer = formatter.format(new FormatterContextImpl(StandardDataType.INT, null), document.getDocumentElement());
		assertNotNull("int", integer);
		assertEquals(new Integer(-123), integer.getValue());
	}

	// duplicated in anticipation of behaviour changing for different INT representations
	@Test
	public void shouldTransformXmlToIntegerIfINT_NONNEG() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">-123</value>");
		IntegerXmlFormatter formatter = new IntegerXmlFormatter(new FormatterConfiguration());
		
		INT integer = formatter.format(new FormatterContextImpl(StandardDataType.INT_NONNEG, null), document.getDocumentElement());
		assertNotNull("int", integer);
		assertEquals(new Integer(-123), integer.getValue());
	}
	
	// duplicated in anticipation of behaviour changing for different INT representations
	@Test
	public void shouldTransformXmlToIntegerIfINT_POS() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">-123</value>");
		IntegerXmlFormatter formatter = new IntegerXmlFormatter(new FormatterConfiguration());
		
		INT integer = formatter.format(new FormatterContextImpl(StandardDataType.INT_POS, null), document.getDocumentElement());
		assertNotNull("int", integer);
		assertEquals(new Integer(-123), integer.getValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNumberIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + "></value>");
		IntegerXmlFormatter formatter = new IntegerXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.INT, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNotAnInteger() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">123.4</value>");
		IntegerXmlFormatter formatter = new IntegerXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.INT, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfNotAnNumber() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">123.4zxfred</value>");
		IntegerXmlFormatter formatter = new IntegerXmlFormatter(new FormatterConfiguration());
		
		formatter.format(new FormatterContextImpl(StandardDataType.INT, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidIntegerIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<value" + ns  + ">a string</value>");
		FormatterConfiguration configuration = new FormatterConfiguration();
		configuration.setPermissive(true);
		IntegerXmlFormatter formatter = new IntegerXmlFormatter(configuration);
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.INT, null);
		INT integer = formatter.format(formatContext, document.getDocumentElement());
		assertNull("integer", integer);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Value not an integer", formatContext.getErrors().get(0).getMessage());
	}
}
