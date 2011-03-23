package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class MoneyXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToMoneyFor_MO() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<money" + ns  + " value=\"123.45\" currency=\"USD\" />");
		MoneyXmlFormatter formatter = new MoneyXmlFormatter(new FormatterConfiguration());
		
		MO mo = formatter.format(new FormatterContextImpl(StandardDataType.MO, null), document.getDocumentElement());
		assertNotNull("mo", mo);
		Assert.assertEquals("123.45", mo.getValue().getAmount().toPlainString());
		Assert.assertEquals("USD", mo.getValue().getCurrency().getCodeValue());
	}
	
	@Test
	public void shouldTransformXmlToMoneyFor_MO_CAD() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<money" + ns  + " value=\"123.45\" currency=\"CAD\" />");
		MoneyXmlFormatter formatter = new MoneyXmlFormatter(new FormatterConfiguration());
		
		MO mo = formatter.format(new FormatterContextImpl(StandardDataType.MO_CAD, null), document.getDocumentElement());
		assertNotNull("mo", mo);
		Assert.assertEquals("123.45", mo.getValue().getAmount().toPlainString());
		Assert.assertEquals("CAD", mo.getValue().getCurrency().getCodeValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfValueIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<money" + ns  + " currency=\"CAD\" />");
		MoneyXmlFormatter formatter = new MoneyXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.MO, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfValueNotANumber() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<money" + ns  + " value=\"123.45zsedw\" currency=\"CAD\" />");
		MoneyXmlFormatter formatter = new MoneyXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.MO, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidMoneyIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<money" + ns  + " value=\"123.45xsxsde\" currency=\"CAD\" />");
		MoneyXmlFormatter formatter = new MoneyXmlFormatter(new FormatterConfiguration(true));
		
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.MO, null);
		MO mo = formatter.format(formatContext, document.getDocumentElement());

		assertNull("mo", mo);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Currency amount is not a number", formatContext.getErrors().get(0).getMessage());
	}
	
}
