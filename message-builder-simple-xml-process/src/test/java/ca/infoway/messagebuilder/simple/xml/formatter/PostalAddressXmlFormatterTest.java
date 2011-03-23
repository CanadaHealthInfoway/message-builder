package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressUse;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class PostalAddressXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToAddressUsingSimplfiedXml() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<address" + ns  + " use=\"H WP PST\"><addressLine>addressline1</addressLine><addressLine>addressline2</addressLine><city>myCity</city><province>ON</province><postalCode>M1L4V1</postalCode><country>CA</country></address>");
		PostalAddressXmlFormatter formatter = new PostalAddressXmlFormatter(new FormatterConfiguration());
		
		AD ad = formatter.format(new FormatterContextImpl(StandardDataType.AD, null), document.getDocumentElement());
		assertNotNull("ad", ad);
		assertEquals(3, ad.getValue().getUses().size());
		Iterator<PostalAddressUse> iterator = ad.getValue().getUses().iterator();
		assertEquals("H", iterator.next().getCodeValue());
		assertEquals("WP", iterator.next().getCodeValue());
		assertEquals("PST", iterator.next().getCodeValue());
		assertEquals(6, ad.getValue().getParts().size());
		assertEquals(PostalAddressPartType.ADDRESS_LINE, ad.getValue().getParts().get(0).getType());
		assertEquals("addressline1", ad.getValue().getParts().get(0).getValue());
		assertEquals(PostalAddressPartType.ADDRESS_LINE, ad.getValue().getParts().get(1).getType());
		assertEquals("addressline2", ad.getValue().getParts().get(1).getValue());
		assertEquals(PostalAddressPartType.CITY, ad.getValue().getParts().get(2).getType());
		assertEquals("myCity", ad.getValue().getParts().get(2).getValue());
		assertEquals(PostalAddressPartType.STATE, ad.getValue().getParts().get(3).getType());
		assertEquals("ON", ad.getValue().getParts().get(3).getValue());
		assertEquals(PostalAddressPartType.POSTAL_CODE, ad.getValue().getParts().get(4).getType());
		assertEquals("M1L4V1", ad.getValue().getParts().get(4).getValue());
		assertEquals(PostalAddressPartType.COUNTRY, ad.getValue().getParts().get(5).getType());
		assertEquals("CA", ad.getValue().getParts().get(5).getValue());
	}
	
	@Test
	public void shouldTransformXmlToAddressUsingPartBasedXml() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<address" + ns  + " use=\"H WP PST\"><addressPart type=\"AL\">addressline1</addressPart><addressPart type=\"AL\">addressline2</addressPart><addressPart type=\"CTY\">myCity</addressPart><addressPart type=\"STA\">ON</addressPart><addressPart type=\"ZIP\">M1L4V1</addressPart><addressPart type=\"CNT\">CA</addressPart></address>");
		PostalAddressXmlFormatter formatter = new PostalAddressXmlFormatter(new FormatterConfiguration());
		
		AD ad = formatter.format(new FormatterContextImpl(StandardDataType.AD, null), document.getDocumentElement());
		assertNotNull("ad", ad);
		assertEquals(3, ad.getValue().getUses().size());
		Iterator<PostalAddressUse> iterator = ad.getValue().getUses().iterator();
		assertEquals("H", iterator.next().getCodeValue());
		assertEquals("WP", iterator.next().getCodeValue());
		assertEquals("PST", iterator.next().getCodeValue());
		assertEquals(6, ad.getValue().getParts().size());
		assertEquals(PostalAddressPartType.ADDRESS_LINE, ad.getValue().getParts().get(0).getType());
		assertEquals("addressline1", ad.getValue().getParts().get(0).getValue());
		assertEquals(PostalAddressPartType.ADDRESS_LINE, ad.getValue().getParts().get(1).getType());
		assertEquals("addressline2", ad.getValue().getParts().get(1).getValue());
		assertEquals(PostalAddressPartType.CITY, ad.getValue().getParts().get(2).getType());
		assertEquals("myCity", ad.getValue().getParts().get(2).getValue());
		assertEquals(PostalAddressPartType.STATE, ad.getValue().getParts().get(3).getType());
		assertEquals("ON", ad.getValue().getParts().get(3).getValue());
		assertEquals(PostalAddressPartType.POSTAL_CODE, ad.getValue().getParts().get(4).getType());
		assertEquals("M1L4V1", ad.getValue().getParts().get(4).getValue());
		assertEquals(PostalAddressPartType.COUNTRY, ad.getValue().getParts().get(5).getType());
		assertEquals("CA", ad.getValue().getParts().get(5).getValue());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfPartTypeIsInvalid() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<address" + ns  + " use=\"H WP PST\"><addressPart type=\"invalid_part_type\">addressline1</addressPart><addressPart type=\"AL\">addressline2</addressPart><addressPart type=\"CTY\">myCity</addressPart><addressPart type=\"STA\">ON</addressPart><addressPart type=\"ZIP\">M1L4V1</addressPart><addressPart type=\"CNT\">CA</addressPart></address>");
		PostalAddressXmlFormatter formatter = new PostalAddressXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.AD, null), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidPartTypeIfConfigurationIsPermissive() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<address" + ns  + " use=\"H WP PST\"><addressPart type=\"invalid_part_type\">addressline1</addressPart><addressPart type=\"AL\">addressline2</addressPart><addressPart type=\"CTY\">myCity</addressPart><addressPart type=\"STA\">ON</addressPart><addressPart type=\"ZIP\">M1L4V1</addressPart><addressPart type=\"CNT\">CA</addressPart></address>");
		PostalAddressXmlFormatter formatter = new PostalAddressXmlFormatter(new FormatterConfiguration(true));
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.AD, null);
		AD ad = formatter.format(formatContext, document.getDocumentElement());

		assertNotNull("ad", ad);
		assertEquals(3, ad.getValue().getUses().size());
		assertEquals(6, ad.getValue().getParts().size());
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("No address part type found for [invalid_part_type]", formatContext.getErrors().get(0).getMessage());
	}
	
}
