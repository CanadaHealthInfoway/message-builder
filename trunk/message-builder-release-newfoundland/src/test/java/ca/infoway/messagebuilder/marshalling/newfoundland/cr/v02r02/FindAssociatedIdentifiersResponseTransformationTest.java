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

package ca.infoway.messagebuilder.marshalling.newfoundland.cr.v02r02;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.junit.XmlAssert;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.cr.FindAssociatedPersonIdentifiersQueryResponseMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class FindAssociatedIdentifiersResponseTransformationTest extends BaseTransformerTestCase {
	
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;
	private static final Identifier QUERY_ID = new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21");

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(VERSION, createResponse());
		assertNotNull("result", xml);
		assertValidHl7Message(xml);
	}

	@Test @Ignore
	public void shouldMatchKnownResponse() throws Exception {
		FindAssociatedPersonIdentifiersQueryResponseMessageBean model = createResponse();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		
		XmlAssert.assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getClass(), "/ca/infoway/messagebuilder/sample/cr/v02r02/findAssociatedIdentifiersResponse.xml")), actual);
	}

	private FindAssociatedPersonIdentifiersQueryResponseMessageBean createResponse() {
		FindAssociatedPersonIdentifiersQueryResponseMessageBean model = new FindAssociatedPersonIdentifiersQueryResponseMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.FIND_ASSOCIATED_PERSON_IDENTIFIERS_RESPONSE);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		MessageBeanBuilderSupport.populateQuerySummary(model.getQuerySummary(), QUERY_ID);
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		model.setQueryId(QUERY_ID);
		model.getCriteria().setClientBusinessId(new Identifier("2.16.840.1.113883.1.133", "9283488"));
		return model;
	}
}
