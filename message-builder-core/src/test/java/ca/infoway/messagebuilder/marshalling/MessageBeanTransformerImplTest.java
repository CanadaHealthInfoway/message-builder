/**
 * Copyright 2013 Canada Health Infoway, Inc.
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.devtools.DefaultValueHolder;
import ca.infoway.messagebuilder.devtools.MessageBeanFactory;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.cr.FindCandidatesQueryMessageBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;
import ca.infoway.messagebuilder.xml.service.MockTestCaseMessageDefinitionService;

/**
 * @sharpen.ignore missing test
 */
public class MessageBeanTransformerImplTest {
	
	private MessageBeanTransformerImpl transformer;
	private DocumentFactory factory;
	
	private static final String MESSAGE = "/ca/infoway/messagebuilder/transport/mohawk/sample/findCandidatesQuery.xml";
	
	private static final String UNSUPPORTED_MESSAGE_XML =
						"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
							"<ABCD_IN123456CA ITSVersion=\"XML_1.0\">" +
						"</ABCD_IN123456CA>";

	@Before
	public void setUp() throws Exception {
		MockMessageBeanRegistry.initialize();
		CodeResolverRegistry.register(new TrivialCodeResolver());
		this.transformer = new MessageBeanTransformerImpl(new MockTestCaseMessageDefinitionService(), RenderMode.PERMISSIVE);
		this.factory = new DocumentFactory();
	}
	
	@After
	public void tearDown() {
		CodeResolverRegistry.unregisterAll();
	}
	
	@Test
	public void shouldProduceRightResultForResponse() throws Exception {
		XmlToModelResult result = this.transformer.transformFromHl7(MockVersionNumber.MOCK_NEWFOUNDLAND,
				this.factory.createFromResource(new ClasspathResource(this.getClass(), MESSAGE)));
		
		assertNotNull("result", result);
		assertNotNull("bean", result.getMessageObject());
		assertTrue("bean type", result.getMessageObject() instanceof FindCandidatesQueryMessageBean);
	}
	
	@Test
	public void shouldReportUnsupportedInteraction() throws Exception {
		XmlToModelResult result = this.transformer.transformFromHl7(MockVersionNumber.MOCK_NEWFOUNDLAND, 
				this.factory.createFromString(UNSUPPORTED_MESSAGE_XML));
		assertNotNull("result", result);
		assertFalse("bean", result.isValid());
	}
	
	@Test
	public void shouldWriteValidXml() throws Exception {
		FindCandidatesQueryMessageBean query = new FindCandidatesQueryMessageBean();
		new MessageBeanFactory(new DefaultValueHolder()).populate(query);
		String xml = this.transformer.transformToHl7(MockVersionNumber.MOCK_NEWFOUNDLAND, query).getXmlMessage();
		
		assertIsValidXml(xml);
	}

	private void assertIsValidXml(String xml) {
		try {
			this.factory.createFromString(xml);
		} catch (SAXException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void shouldCreateDefaultVersionCode() throws Exception {
		FindCandidatesQueryMessageBean query = new FindCandidatesQueryMessageBean();
		new MessageBeanFactory(new DefaultValueHolder()).populate(query);
		String xml = this.transformer.transformToHl7(MockVersionNumber.MOCK_NEWFOUNDLAND, query).getXmlMessage();
		assertTrue("version code", xml.contains("<versionCode code=\"V3-2007-05\"/>"));
	}
	
	@Test
	public void shouldCreateDefaultInteractionId() throws Exception {
		FindCandidatesQueryMessageBean query = new FindCandidatesQueryMessageBean();
		new MessageBeanFactory(new DefaultValueHolder()).populate(query);
		String xml = this.transformer.transformToHl7(MockVersionNumber.MOCK_NEWFOUNDLAND, query).getXmlMessage();
		assertTrue("interaction id", xml.contains(" extension=\"PRPA_IN101103CA\" "));
	}
}
