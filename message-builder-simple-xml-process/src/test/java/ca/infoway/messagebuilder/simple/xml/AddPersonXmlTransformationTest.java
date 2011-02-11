package ca.infoway.messagebuilder.simple.xml;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.simple.xml.formatter.SimpleXmlFormatProcessor;
import ca.infoway.messagebuilder.simple.xml.parser.SimpleXmlParseProcessor;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public class AddPersonXmlTransformationTest {
	
	protected static final SpecificationVersion VERSION = SpecificationVersion.R02_04_02;

	private static final String REQUEST_MESSAGE_FILE = "/ca/infoway/messagebuilder/sample/cr/v02r02/addPersonRequest.xml";
//	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cr/v02r02/addPersonRequestAccepted.xml";
//	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cr/v02r02/addPersonRequestRefused.xml";

	private DocumentFactory factory;
	private MessageBeanTransformerImpl transformer;
	

	@Before
	public void setUp() {
		CodeResolverRegistry.register(new TrivialCodeResolver());
		this.factory = new DocumentFactory();
		this.transformer = new MessageBeanTransformerImpl();
	}
	
	@Test @Ignore
	public void shouldMarshallUnMarshall() throws Exception {
		Document original = factory.createFromResource(new ClasspathResource(this.getClass(), REQUEST_MESSAGE_FILE));
		String originalSimpleXml = toSimpleXmlFromHl7(original);

		System.out.println(originalSimpleXml);
		assertNotNull("simple xml", originalSimpleXml);
		
		Document marshalled = fromSimpleXmlToHl7(originalSimpleXml);
		XmlAssert.assertTreeEquals(original, marshalled);
	}

	private Document fromSimpleXmlToHl7(String simpleXmlMessage) throws SAXException, MarshallingException {
		SimpleXmlFormatProcessor processor = new SimpleXmlFormatProcessor(VERSION);
		
		MessagePartBean messageBean = processor.process(loadSchema("PRPA_IN101201CA"), this.factory.createFromString(simpleXmlMessage));
		
		String hl7Message = transformer.transformToHl7(VERSION, (InteractionBean) messageBean);
		
		return factory.createFromString(hl7Message);
	}

	private String toSimpleXmlFromHl7(Document message) throws MarshallingException, SAXException {
		XmlToModelResult result = transformer.transformFromHl7(VERSION, message);
		SimpleXmlParseProcessor processor = new SimpleXmlParseProcessor();
		return processor.process((InteractionBean) result.getMessageObject());
	}

	private Schema loadSchema(String messageId) throws SAXException {
		InputStream input = getClass().getResourceAsStream("/ca/infoway/messagebuilder/model/" + messageId + ".xsd");
		try {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language); 
			factory.setResourceResolver(new SimpleXmlSchemaResolver());
			return factory.newSchema(new StreamSource(input));
		} finally {
			IOUtils.closeQuietly(input);
		}
	}	
	
}
