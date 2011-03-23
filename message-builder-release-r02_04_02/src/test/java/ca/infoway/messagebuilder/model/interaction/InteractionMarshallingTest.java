package ca.infoway.messagebuilder.model.interaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;


public class InteractionMarshallingTest {
	
	private MessageBeanTransformerImpl transformer;

	@Before
	public void setUp() throws Exception {
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
		this.transformer = new MessageBeanTransformerImpl();
	}
	
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document document = new DocumentFactory().createFromResource(
				new ClasspathResource("PRPA_EX101104CA.xml"));
		assertNotNull("document", document);
		this.transformer.transformFromHl7(
				SpecificationVersion.R02_04_02, 
				document);
	}
	
	@Test
	public void shouldMaintainInteractionId() throws Exception {
		XmlToModelResult result = this.transformer.transformFromHl7(
				SpecificationVersion.R02_04_02, 
				new DocumentFactory().createFromResource(
						new ClasspathResource("PRPA_EX101104CA.xml")));
		String xml = this.transformer.transformToHl7(SpecificationVersion.R02_04_02, (InteractionBean) result.getMessageObject());
System.out.println(xml);		
		assertTrue("interaction id", xml.contains(" root=\"2.16.840.1.113883.1.18\""));
	}
	
	@Test
	public void shouldEnsureThatLanguageCodeIsPreserved() throws Exception {
		XmlToModelResult result = this.transformer.transformFromHl7(
				SpecificationVersion.R02_04_02, 
				new DocumentFactory().createFromResource(
						new ClasspathResource("bug_13292.xml")));
		
		Object message = result.getMessageObject();
		assertTrue("type", message instanceof PatientAllergyIntoleranceQueryBean);
		PatientAllergyIntoleranceQueryBean query = (PatientAllergyIntoleranceQueryBean) message;
		
		assertNotNull("human language", query.getControlActEvent().getMessageLanguage());
		assertEquals("language", "en", query.getControlActEvent().getMessageLanguage().getCodeValue());
		
		String xml = this.transformer.transformToHl7(SpecificationVersion.R02_04_02, query);
		System.out.println(xml);
		assertTrue("langaugeCode", xml.contains("<languageCode code=\"en\""));
	}
}
