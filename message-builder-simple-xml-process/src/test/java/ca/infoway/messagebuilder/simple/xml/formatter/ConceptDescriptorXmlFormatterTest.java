package ca.infoway.messagebuilder.simple.xml.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.FormatterConfiguration;
import ca.infoway.messagebuilder.simple.xml.FormatterContextImpl;
import ca.infoway.messagebuilder.simple.xml.FormatterException;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class ConceptDescriptorXmlFormatterTest {

	private String ns = " xmlns=\"" + AbstractSimpleXmlFormatter.NAMESPACE + "\"";
	
	@Before
	public void initialize() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldTransformXmlToCDNoOriginalText() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"M\" codeSystem=\"1.2.3.4\"/>");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration());
		
		CD cd = formatter.format(new FormatterContextImpl(StandardDataType.CD, AdministrativeGender.class), document.getDocumentElement());
		assertNotNull("cd", cd);
		Assert.assertEquals("M", cd.getValue().getCodeValue());
		Assert.assertEquals("1.2.3.4", cd.getValue().getCodeSystem());
		Assert.assertTrue(cd.getValue() instanceof AdministrativeGender);
	}
	
	@Test
	public void shouldTransformXmlToCDWithOriginalText() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"M\" codeSystem=\"1.2.3.4\"><originalText>Some original text</originalText></code>");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration());
		
		CD cd = formatter.format(new FormatterContextImpl(StandardDataType.CD, AdministrativeGender.class), document.getDocumentElement());
		assertNotNull("cd", cd);
		Assert.assertEquals("M", cd.getValue().getCodeValue());
		Assert.assertEquals("1.2.3.4", cd.getValue().getCodeSystem());
		Assert.assertTrue(cd.getValue() instanceof AdministrativeGender);
		Assert.assertEquals("Some original text", cd.getOriginalText());
	}
	
	@Test
	public void shouldTransformXmlToCDWithTranslations() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"M\" codeSystem=\"1.2.3.4\"><originalText>Some original text</originalText><translation code=\"M_translation1\" codeSystem=\"1.2.3.4_translation1\"><originalText>Some original text_translation1</originalText></translation><translation code=\"M_translation2\" codeSystem=\"1.2.3.4_translation2\"><originalText>Some original text_translation2</originalText></translation></code>");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration());
		
		CDImpl cd = (CDImpl) formatter.format(new FormatterContextImpl(StandardDataType.CD, AdministrativeGender.class), document.getDocumentElement());
		assertNotNull("cd", cd);
		Assert.assertEquals("M", cd.getValue().getCodeValue());
		Assert.assertEquals("1.2.3.4", cd.getValue().getCodeSystem());
		Assert.assertTrue(cd.getValue() instanceof AdministrativeGender);
		Assert.assertEquals("Some original text", cd.getOriginalText());
		
		Assert.assertEquals(2, cd.getTranslations().size());
		
		Assert.assertEquals("M_translation1", cd.getTranslations().get(0).getValue().getCodeValue());
		Assert.assertEquals("1.2.3.4_translation1", cd.getTranslations().get(0).getValue().getCodeSystem());
		Assert.assertTrue(cd.getTranslations().get(0).getValue() instanceof AdministrativeGender);
		Assert.assertEquals("Some original text_translation1", cd.getTranslations().get(0).getOriginalText());
		
		Assert.assertEquals("M_translation2", cd.getTranslations().get(1).getValue().getCodeValue());
		Assert.assertEquals("1.2.3.4_translation2", cd.getTranslations().get(1).getValue().getCodeSystem());
		Assert.assertTrue(cd.getTranslations().get(1).getValue() instanceof AdministrativeGender);
		Assert.assertEquals("Some original text_translation2", cd.getTranslations().get(1).getOriginalText());
	}
	
	@Test
	public void shouldTransformXmlToCDLabWithDisplayName() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"M\" codeSystem=\"1.2.3.4\" displayName=\"This is a display name\"/>");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration());
		
		CD cd = formatter.format(new FormatterContextImpl(StandardDataType.CD_LAB, AdministrativeGender.class), document.getDocumentElement());
		assertNotNull("cd", cd);
		Assert.assertEquals("M", cd.getValue().getCodeValue());
		Assert.assertEquals("This is a display name", cd.getDisplayName());
		Assert.assertEquals("1.2.3.4", cd.getValue().getCodeSystem());
		Assert.assertTrue(cd.getValue() instanceof AdministrativeGender);
	}
	
	@Test
	public void shouldTransformXmlToCDWithNoCode() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " codeSystem=\"1.2.3.4\"><originalText>Some original text</originalText></code>");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration());
		
		CD cd = formatter.format(new FormatterContextImpl(StandardDataType.CD, AdministrativeGender.class), document.getDocumentElement());
		assertNotNull("cd", cd);
		Assert.assertNull(cd.getValue().getCodeValue());
		Assert.assertEquals("1.2.3.4", cd.getValue().getCodeSystem());
		Assert.assertTrue(cd.getValue() instanceof AdministrativeGender);
		Assert.assertEquals("Some original text", cd.getOriginalText());
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfTransformXmlToCDLabWithOriginalText() throws Exception {
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"M\" codeSystem=\"1.2.3.4\" displayName=\"This is a display name\"><originalText>Some original text</originalText></code>");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.CD_LAB, AdministrativeGender.class), document.getDocumentElement());
	}
	
	@Test
	public void shouldReturnNullTypeIfValueIsMissing() throws Exception {
		
		// should this case throw an exception instead?
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " />");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration());
		CD cd = formatter.format(new FormatterContextImpl(StandardDataType.CD, AdministrativeGender.class), document.getDocumentElement());
		assertNull(cd);
	}
	
	@Test(expected=FormatterException.class)
	public void shouldThrowExceptionIfValueNotAValidCode() throws Exception {
		
		CodeResolverRegistry.register(new TrivialCodeResolver() {
			@Override
			public <T extends Code> T lookup(Class<? extends T> interfaceType, String codeValue, String codeSystemOid) {
				return null;
			}
		});
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"ABCDEFGHinvalid\"/>");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration());
		formatter.format(new FormatterContextImpl(StandardDataType.CD, AdministrativeGender.class), document.getDocumentElement());
	}
	
	@Test
	public void shouldAllowInvalidCodeIfConfigurationIsPermissive() throws Exception {
		
		CodeResolverRegistry.register(new TrivialCodeResolver() {
			@Override
			public <T extends Code> T lookup(Class<? extends T> interfaceType, String codeValue, String codeSystemOid) {
				return null;
			}
		});
		
		Document document = new DocumentFactory().createFromString("<code" + ns  + " code=\"Minvalid\"><originalText>Some original text</originalText></code>");
		ConceptDescriptorXmlFormatter formatter = new ConceptDescriptorXmlFormatter(new FormatterConfiguration(true));
		FormatterContextImpl formatContext = new FormatterContextImpl(StandardDataType.CD, AdministrativeGender.class);
		CD cd = formatter.format(formatContext, document.getDocumentElement());

		assertNotNull("cd", cd);
		assertEquals(1, formatContext.getErrors().size());
		assertEquals("Could not find code [Minvalid]", formatContext.getErrors().get(0).getMessage());
	}
	
}
