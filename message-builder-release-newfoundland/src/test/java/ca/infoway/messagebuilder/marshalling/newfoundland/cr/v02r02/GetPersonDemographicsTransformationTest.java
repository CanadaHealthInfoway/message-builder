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

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.Hl7Error;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationEventRecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.DemographicsQueryCriteria;
import ca.infoway.messagebuilder.model.newfoundland.cr.GetPersonDemographicsQueryMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cr.GetPersonDemographicsQueryResponseMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class GetPersonDemographicsTransformationTest extends BaseTransformerTestCase {
	
	private static final VersionNumber VERSION = BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK;

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = toHl7UsingNewRenderer(createRequest(), VERSION);
		assertNotNull("result", xml);
	}

	@Test
	public void shouldIgnoreLocalExtensions() throws Exception {
		Document actual = this.factory.createFromResource(new ClasspathResource("PRPA_IN101101CA_with_additional_namespace.xml"));
		InteractionBean bean = fromHl7(actual, VERSION);
		assertTrue("type", bean instanceof InteractionBean);
	}
	
	@Test
	public void shouldMatchKnownRequest() throws Exception {
		String xml = toHl7UsingNewRenderer(createRequest(), VERSION);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				"ca/infoway/messagebuilder/sample/cr/v02r02/getPersonDemographicsQuery.xml")), actual);
	}

	private GetPersonDemographicsQueryMessageBean createRequest() {
		GetPersonDemographicsQueryMessageBean model = new GetPersonDemographicsQueryMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.GET_PERSON_DEMOGRAPHICS_QUERY);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		model.getMessageReceiver().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		model.getSender().setDeviceId(new Identifier("2.16.840.1.113883.4.262.12", "123"));
		model.getControlActEvent().setEventId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad11"));
		model.getControlActEvent().setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
		model.getControlActEvent().getCriteria().setClientIDBus(new Identifier("1.2.3.4.5.6", "clientId"));
		return model;
	}
	
	@Test
	public void shouldCreateAMeaningfulResponse() throws Exception {
//      FIXME - TM/BC - using the new renderer, this test will fail (detected issue not written)		

//		GetPersonDemographicsQueryResponseMessageBean model = createResponseBean();
//		String xml = toHl7UsingNewRenderer(model, VERSION);
//		assertValidHl7Message(xml);
		
		GetPersonDemographicsQueryResponseMessageBean model = createResponseBean();
		ModelToXmlResult result = this.transformer.transformToHl7AndReturnResult(VERSION, model);
		System.out.println(result.getXmlMessage());
		assertValidHl7Message(result.getXmlMessage());
		Assert.assertTrue("Response should not have warnings", result.getHl7Errors().isEmpty());
	}
	
	private GetPersonDemographicsQueryResponseMessageBean createResponseBean() {
		DemographicsQueryCriteria criteria = new DemographicsQueryCriteria();
		criteria.setClientIDPub(new Identifier("1.2.3.4.5.6", "987654"));
		
		GetPersonDemographicsQueryResponseMessageBean model = new GetPersonDemographicsQueryResponseMessageBean(criteria);
		MessageBeanBuilderSupport.populateMoreBetterStandardValues(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.GET_PERSON_DEMOGRAPHICS_RESPONSE);
		model.setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));

		IdentifiedPersonBean patient = new IdentifiedPersonBeanBuilder().populate().create();

		RegistrationEventRecordBean<IdentifiedPersonBean> record = new RegistrationEventRecordBean<IdentifiedPersonBean>(patient, ActStatus.ACTIVE);
		record.getCustodian().setId(new Identifier("1.2.3.4.5.6.7", "deviceId"));
		record.getCustodian().setRepositoryName("Panacea");
		record.getCustodian().setJurisdictionName("Ontario");
		model.getControlActEventBean().getQueryRecords().add(record);
		
		return model;
	}
	
	@Override // we want to use v01r04_3 hotfix 2 rather than NEWFOUNDLAND
	protected void assertValidHl7Message(Document actual) {
		XmlToModelResult result = this.transformer.transformFromHl7(VERSION, actual);
		Hl7Error found = null;
		for (Hl7Error error : result.getHl7Errors()) {
			found = error;
		}
		assertNull(ObjectUtils.toString(found), found);
	}
}
