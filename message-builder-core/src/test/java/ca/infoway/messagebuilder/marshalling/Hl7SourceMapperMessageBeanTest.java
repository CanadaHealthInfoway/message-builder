package ca.infoway.messagebuilder.marshalling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.cr.FindCandidatesQueryMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

public class Hl7SourceMapperMessageBeanTest {
	
	private static final String QUERY_RESPONSE_MESSAGE_FILE = "/ca/infoway/messagebuilder/transport/mohawk/sample/findCandidatesQuery.xml";
	private Document document;
	private MessageDefinitionService service;
	private Hl7MessageSource messageSource;
	
	@Before
	public void setUp() throws Exception {
		MockMessageBeanRegistry.initialize();
		CodeResolverRegistry.register(new TrivialCodeResolver());
		this.document = getSourceDocument();
		this.service = new MockTestCaseMessageDefinitionService();
		this.messageSource = new Hl7MessageSource(MockVersionNumber.MOCK_NEWFOUNDLAND.getVersionLiteral(), this.document, service);
	}
	
	@Test
	public void shouldMapPatientReferralSummariesQueryResponseMessageBean() throws Exception {
		XmlToModelResult xmlToJavaResult = new Hl7SourceMapper().mapToTeal(this.messageSource);
		FindCandidatesQueryMessageBean teal = (FindCandidatesQueryMessageBean) xmlToJavaResult.getMessageObject(); 
		assertNotNull("message Bean", teal);
		assertEquals("id", "1ee83ff1-08ab-4fe7-b573-ea777e9bad51", teal.getMessageIdentifier().getRoot());
		assertEquals("processingId", "P", teal.getProcessingCode().getCodeValue());
		assertEquals("sender.softwareName", "Panacea Pharmacy", teal.getSender().getSoftwareName());
		assertEquals("sender.telecommunicationAddress", "987.654.321.0", teal.getSender().getTelecommunicationAddress().getAddress());
		assertNotNull("receiver.deviceId", teal.getReceiver().getDeviceId());
		assertEquals("receiver.telecommunicationAddress", "123.255.255.10", teal.getReceiver().getTelecommunicationAddress().getAddress());

		assertEquals("controlActEvent.code", "PRPA_TE101103CA", teal.getControlActEventBean().getCode().getCodeValue());
		assertEquals("criteria first name", "J",  teal.getControlActEventBean().getQueryByParameter().getParameterList().getPersonNames().get(0).getGivenName());
		assertEquals("criteria last name", "Smith",  teal.getControlActEventBean().getQueryByParameter().getParameterList().getPersonNames().get(0).getFamilyName());
	}

	private Document getSourceDocument() throws Exception {
		return new DocumentFactory().createFromResource(new ClasspathResource(this.getClass(), QUERY_RESPONSE_MESSAGE_FILE));
	}
}
