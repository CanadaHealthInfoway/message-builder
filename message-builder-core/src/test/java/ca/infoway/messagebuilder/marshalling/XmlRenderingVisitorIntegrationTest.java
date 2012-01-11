/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

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
		new TealBeanRenderWalker(message, MockVersionNumber.MOCK_NEWFOUNDLAND, null, null, this.service).accept(visitor);
		System.out.println(visitor.toXml().getXmlMessage());
	}

}
