package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.domainvalue.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class TelecomAddressXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToTelFromUri() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<uri" + ns  + " value=\"https://www.i-proving.ca\" />");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		
		TEL tel = formatter.format(new FormatterContextImpl(StandardDataType.TEL_URI, null), document.getDocumentElement());
		assertNotNull("tel", tel);
		assertTrue(tel.getValue().getAddressUses().isEmpty());
		assertEquals("www.i-proving.ca", tel.getValue().getAddress());
		assertEquals("https", tel.getValue().getUrlScheme().getCodeValue());
	}
	
	@Test
	public void shouldTransformXmlToTelFromEmail() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<email" + ns  + "><use>H</use><use>WP</use><mailto>dev@intware.org</mailto></email>");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		
		TEL tel = formatter.format(new FormatterContextImpl(StandardDataType.TEL_EMAIL, null), document.getDocumentElement());
		assertNotNull("tel", tel);
		assertEquals(2, tel.getValue().getAddressUses().size());
		Iterator<TelecommunicationAddressUse> iterator = tel.getValue().getAddressUses().iterator();
		assertEquals("H", iterator.next().getCodeValue());
		assertEquals("WP", iterator.next().getCodeValue());
		assertEquals("dev@intware.org", tel.getValue().getAddress());
		assertEquals("mailto", tel.getValue().getUrlScheme().getCodeValue());
	}
	
	@Test
	public void shouldTransformXmlToTelFromPhone() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<phone" + ns  + " type=\"FAX\"><use>H</use><use>WP</use><use>AS</use><areaCode>+1416</areaCode><phoneNumber>7620032</phoneNumber><extension>4321</extension></phone>");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		
		TEL tel = formatter.format(new FormatterContextImpl(StandardDataType.TEL_PHONE, null), document.getDocumentElement());
		assertNotNull("tel", tel);
		assertEquals(3, tel.getValue().getAddressUses().size());
		Iterator<TelecommunicationAddressUse> iterator = tel.getValue().getAddressUses().iterator();
		assertEquals("AS", iterator.next().getCodeValue());
		assertEquals("H", iterator.next().getCodeValue());
		assertEquals("WP", iterator.next().getCodeValue());
		assertEquals("+14167620032;ext=4321", tel.getValue().getAddress());
		assertEquals("fax", tel.getValue().getUrlScheme().getCodeValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfUriSchemeIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<uri" + ns  + " value=\"www.i-proving.ca\" />");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.TEL_URI, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfUriAddressIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<uri" + ns  + " value=\"https://\" />");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.TEL_URI, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfPhoneTypeIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<phone" + ns  + "><use>H</use><use>WP</use><use>AS</use><areaCode>+1416</areaCode><phoneNumber>7620032</phoneNumber><extension>4321</extension></phone>");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.TEL_PHONE, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfPhoneNumberIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<phone" + ns  + " type=\"FAX\"><use>H</use><use>WP</use><use>AS</use><areaCode>+1416</areaCode><phoneNumber></phoneNumber><extension>4321</extension></phone>");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.TEL_PHONE, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfPhoneAreaCodeIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<phone" + ns  + " type=\"FAX\"><use>H</use><use>WP</use><use>AS</use><areaCode></areaCode><phoneNumber>7620032</phoneNumber><extension>4321</extension></phone>");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.TEL_PHONE, null), document.getDocumentElement());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfEmailAddressIsMissing() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<email" + ns  + "><use>H</use><use>WP</use><mailto></mailto></email>");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.TEL_EMAIL, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidEmailAddressIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<email" + ns  + "><use>H</use><use>WP</use><mailto></mailto></email>");
		TelecomAddressXmlFormatter formatter = new TelecomAddressXmlFormatter(new FormatterConfiguration(true));
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.TEL_EMAIL, null);
		TEL tel = formatter.format(formatContext, document.getDocumentElement());

		assertNull("tel", tel);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Email requires mailto address", formatContext.getErrors().get(0).getMessage());
	}
	
}
