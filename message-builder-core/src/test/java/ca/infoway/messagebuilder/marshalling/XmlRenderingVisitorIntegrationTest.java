package ca.infoway.messagebuilder.marshalling;

import org.junit.Before;
import org.junit.Test;

import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.cr.FindCandidatesCriteria;
import ca.infoway.messagebuilder.model.cr.FindCandidatesQueryMessageBean;
import ca.infoway.messagebuilder.model.mock.QueryControlActEventBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.xml.service.MessageDefinitionService;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

public class XmlRenderingVisitorIntegrationTest {
	
	private MessageDefinitionService service;

	@Before
	public void setUp() throws Exception {
		MockMessageBeanRegistry.initialize();
		this.service = new MockTestCaseMessageDefinitionService();
		DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
	}
	
	@Test
	public void shouldRenderCompleteSolution() throws Exception {
		FindCandidatesQueryMessageBean message = new FindCandidatesQueryMessageBean();
		message.setControlActEventBean(new QueryControlActEventBean<FindCandidatesCriteria>(new FindCandidatesCriteria()));
		message.getControlActEventBean().getCriteria().setBirthDate(DateUtil.getDate(1966, 0, 5));
		XmlRenderingVisitor visitor = new XmlRenderingVisitor();
		new TealBeanRenderWalker(message, MockVersionNumber.MOCK_NEWFOUNDLAND, this.service).accept(visitor);
		System.out.println(visitor.toXml().getXmlMessage());
	}

}
