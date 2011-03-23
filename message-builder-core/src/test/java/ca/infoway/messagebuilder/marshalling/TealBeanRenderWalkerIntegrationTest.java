package ca.infoway.messagebuilder.marshalling;

import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailCode.SYNTAX_ERROR;
import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailCode.UNKNOWN_SENDER;
import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailType.ERROR;
import static ca.infoway.messagebuilder.marshalling.MockVersionNumber.MOCK;
import static org.junit.Assert.fail;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailCode;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementDetailType;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.model.common.GenericResponseMessageBean;
import ca.infoway.messagebuilder.model.cr.FindCandidatesCriteria;
import ca.infoway.messagebuilder.model.cr.FindCandidatesQueryMessageBean;
import ca.infoway.messagebuilder.model.mock.AcknowledgementDetailBean;
import ca.infoway.messagebuilder.model.mock.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.mock.QueryControlActEventBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;
import ca.infoway.messagebuilder.xml.validator.MessageValidatorImpl;
import ca.infoway.messagebuilder.xml.validator.MessageValidatorResult;

/**
 * @sharpen.ignore missing test.
 */
public class TealBeanRenderWalkerIntegrationTest {

	private TealBeanRenderWalker walker;

	@Before
	public void setUp() throws Exception {
		CodeResolverRegistry.register(new TrivialCodeResolver());
	}
	
	@Test
	public void shouldRenderASimpleHl7Message() throws Exception {
		GenericResponseMessageBean tealBean = new GenericResponseMessageBean();
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(tealBean);
		tealBean.getAcknowledgement().getAcknowledgementDetails().add(createDetail(SYNTAX_ERROR, "I hate you", ERROR));
		tealBean.getAcknowledgement().getAcknowledgementDetails().add(createDetail(UNKNOWN_SENDER, "Unauthorized user", ERROR));
		
		XmlRenderingVisitor visitor = new XmlRenderingVisitor();
		
		this.walker = new TealBeanRenderWalker(tealBean, MOCK, new MockTestCaseMessageDefinitionService());
		this.walker.accept(visitor);

		String xml = visitor.toXml().getXmlMessage();
		System.out.println(xml);
		assertValidHl7Message(xml);
	}

	@Test
	public void shouldRenderASimpleMessageWithTemplates() throws Exception {
		FindCandidatesQueryMessageBean tealBean = new FindCandidatesQueryMessageBean();
		tealBean.setControlActEventBean(new QueryControlActEventBean<FindCandidatesCriteria>());
		tealBean.getControlActEventBean().getQueryByParameter().setParameterList(new FindCandidatesCriteria());
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(tealBean);
		tealBean.getControlActEventBean().setCode(HL7TriggerEventCode.FIND_CANDIDATES_QUERY);
		
		this.walker = new TealBeanRenderWalker(tealBean, MOCK, new MockTestCaseMessageDefinitionService());
		
		tealBean.getControlActEventBean().setQueryId(new Identifier(UUID.randomUUID().toString()));
		tealBean.getControlActEventBean().setEventId(new Identifier(UUID.randomUUID().toString()));
		tealBean.getControlActEventBean().getCriteria().setGender(AdministrativeGender.MALE);
		XmlRenderingVisitor visitor = new XmlRenderingVisitor();
		this.walker.accept(visitor);
		
		String xml = visitor.toXml().getXmlMessage();
		assertValidHl7Message(xml);
	}
	
	private AcknowledgementDetailBean createDetail(AcknowledgementDetailCode code, String text, AcknowledgementDetailType type) {
		return new AcknowledgementDetailBean(type, code, text);
	}

	private void assertValidHl7Message(String xml) throws SAXException {
		Document document = new DocumentFactory().createFromString(xml);
		MessageValidatorResult result = new MessageValidatorImpl(new MockTestCaseMessageDefinitionService()).validate(document, MOCK.getVersionLiteral());
		for (Hl7Error error : result.getHl7Errors()) {
			fail(error.toString());
		}
	}
}
