/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.marshalling.newfoundland.pr.v02r02;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.pr.ProviderDetailsCriteria;
import ca.infoway.messagebuilder.model.newfoundland.pr.ProviderDetailsQueryMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class ProviderDetailsQueryTransformationTest extends BaseTransformerTestCase {
	
	private static final SpecificationVersion VERSION = SpecificationVersion.NEWFOUNDLAND;

	@Test
	public void testShouldProduceSomeResult() throws Exception {
		assertNotNull("result", this.transformer.transformToHl7(VERSION, createProviderDetails()));
	}

	@Test
	public void testShouldMatchKnownMessage() throws Exception {
		ProviderDetailsQueryMessageBean model = createProviderDetails();
		String xml = this.transformer.transformToHl7(VERSION, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				getClass(), "/ca/infoway/messagebuilder/sample/pr/v02r02/providerDetailsQuery.xml")), actual);
	}

	@Test
	public void testShouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(getClass(), "/ca/infoway/messagebuilder/sample/pr/v02r02/providerDetailsQuery.xml"));
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, message);
		assertTrue("type", result.getMessageObject() instanceof ProviderDetailsQueryMessageBean);
		
		ProviderDetailsQueryMessageBean bean = (ProviderDetailsQueryMessageBean) result.getMessageObject();
		assertNotNull("id", bean.getMessageAttributes().getMessageId());
	}

	private ProviderDetailsQueryMessageBean createProviderDetails() {
		ProviderDetailsCriteria criteria = new ProviderDetailsCriteria();
		criteria.setName(PersonName.createFirstNameLastName("J", "Smith"));
		criteria.setGender(AdministrativeGender.FEMALE);
		
		ProviderDetailsQueryMessageBean model = new ProviderDetailsQueryMessageBean(criteria);
		model.getControlActEvent().setCode(HL7TriggerEventCode.PROVIDER_DETAILS_QUERY);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		model.getMessageAttributes().getReceiver().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		model.getMessageAttributes().getSender().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad21"));
		
		return model;
	}
}
