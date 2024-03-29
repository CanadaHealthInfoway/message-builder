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

package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.AddIssueManagementRequestMessageBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.issuemanagement.AddIssueManagementRequestMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class AddIssueManagementTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE =  "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/addIssueManagementRequest.xml";

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xmlString = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createRequestBean()).getXmlMessage();
		assertNotNull("result", xmlString);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		AddIssueManagementRequestMessageBean model = createRequestBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model).getXmlMessage();
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createRequestBean()).getXmlMessage();
		Document message = this.factory.createFromString(xml);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
		String transformedBackToHl7Xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, messageObject).getXmlMessage();
		assertEquals(xml, transformedBackToHl7Xml);
	}

	private AddIssueManagementRequestMessageBean createRequestBean() {
		return new AddIssueManagementRequestMessageBeanBuilder().populate().create();
	}

}
