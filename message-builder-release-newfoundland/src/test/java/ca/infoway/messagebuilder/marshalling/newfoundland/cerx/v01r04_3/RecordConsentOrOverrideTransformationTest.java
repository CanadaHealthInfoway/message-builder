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
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActConsentInformationAccessReason;
import ca.infoway.messagebuilder.domainvalue.x_PhysicalVerbalParticipationMode;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.consent.RecordConsentOrOverrideRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.consent.RecordConsentOrOverrideRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.consent.RecordConsentOrOverrideRequestMessageBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.consent.RecordConsentOrOverrideRequestRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RecordConsentOrOverrideTransformationTest extends BaseTransformerTestCase {
	
	private static final String RESPONSE_REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordConsentOrOverrideRequestRefused.xml";
	private static final String RESPONSE_ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordConsentOrOverrideRequestAccepted.xml";
	private static final String CONSENT_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordConsentOrOverrideRequest_consent.xml";
	private static final String OVERRIDE_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordConsentOrOverrideRequest_override.xml";

	@Test
	public void consentShouldProduceSomeResult() throws Exception {
		assertNotNull("result", this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createConsentRequestBean()));
	}

	@Test
	public void overrideShouldProduceSomeResult() throws Exception {
		assertNotNull("result", this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createOverrideRequestBean()));
	}

	@Test
	public void shouldMatchKnownConsentRequest() throws Exception {
		RecordConsentOrOverrideRequestMessageBean model = createConsentRequestBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(CONSENT_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldMatchKnownOverrideRequest() throws Exception {
		RecordConsentOrOverrideRequestMessageBean model = createOverrideRequestBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(OVERRIDE_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		RecordConsentOrOverrideRequestAcceptedMessageBean model = createAcceptedResponseBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(RESPONSE_ACCEPTED_MESSAGE_FILE)), actual);
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		RecordConsentOrOverrideRequestRefusedMessageBean model = createRefusedResponseBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(RESPONSE_REFUSED_MESSAGE_FILE)), actual);
	}

	@Test @Ignore
	public void shouldParseConsentMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(CONSENT_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (NewBaseMessageBean) xmlToJavaResult.getMessageObject();
		assertTrue("type", messageObject instanceof RecordConsentOrOverrideRequestMessageBean);
	}

	@Test @Ignore
	public void shouldParseOverrideMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(OVERRIDE_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (NewBaseMessageBean) xmlToJavaResult.getMessageObject();
		assertTrue("type", messageObject instanceof RecordConsentOrOverrideRequestMessageBean);
	}

	@Test @Ignore
	public void consentShouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(CONSENT_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (NewBaseMessageBean) xmlToJavaResult.getMessageObject();
		assertTreeEquals(
				this.factory.createFromResource(new ClasspathResource(CONSENT_MESSAGE_FILE)), 
				this.factory.createFromString(this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, messageObject)));
	}
	
	@Test @Ignore
	public void overrideShouldTransformBackAndForthWithoutLosingData() throws Exception {
		RecordConsentOrOverrideRequestMessageBean model = createOverrideRequestBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document message = this.factory.createFromString(xml);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (NewBaseMessageBean) xmlToJavaResult.getMessageObject();
		assertEquals(this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, messageObject), xml);
	}
	
	private RecordConsentOrOverrideRequestMessageBean createConsentRequestBean() {
		RecordConsentOrOverrideRequestMessageBean model = createRequestBean();
		model.getControlActEvent().getRecord().setId(new Identifier("consentFormRoot", "consentFormId"));
		model.getControlActEvent().getRecord().setModeCode(lookup(x_PhysicalVerbalParticipationMode.class, "PHYSICAL", CodeSystem.VOCABULARY_PROCESSING_MODE.getRoot()));
		return model;
	}

	private RecordConsentOrOverrideRequestMessageBean createOverrideRequestBean() {
		RecordConsentOrOverrideRequestMessageBean model = createRequestBean();
		model.getControlActEvent().getRecord().setReasonCode(lookup(ActConsentInformationAccessReason.class, "EMERG", CodeSystem.VOCABULARY_ACT_REASON.getRoot()));
		model.getControlActEvent().getRecord().setProvider(new AssignedPersonBeanBuilder().populate().create());
		return model;
	}

	private RecordConsentOrOverrideRequestMessageBean createRequestBean() {
		return new RecordConsentOrOverrideRequestMessageBeanBuilder().populate().create();
	}

	private RecordConsentOrOverrideRequestAcceptedMessageBean createAcceptedResponseBean() {
		RecordConsentOrOverrideRequestAcceptedMessageBean model = new RecordConsentOrOverrideRequestAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_CONSENT_OR_OVERRIDE_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		
		RecordBean<ActEventBean> recordBean = new RecordBean<ActEventBean>();
		ActEventBean record = new ActEventBean();
		record.setPatient(new IdentifiedPersonBeanBuilder().populate().create());
		record.setId(new Identifier("2.16.124.113620.1.1.5", "consentId"));
		recordBean.setRecord(record);
		model.getControlActEvent().setRecordBean(recordBean);
		return model;
	}

	private RecordConsentOrOverrideRequestRefusedMessageBean createRefusedResponseBean() {
		RecordConsentOrOverrideRequestRefusedMessageBean model = new RecordConsentOrOverrideRequestRefusedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_CONSENT_OR_OVERRIDE_REQUEST_REFUSED);
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		MessageBeanBuilderSupport.populateAcknowledgement(model.getAcknowledgement());
		return model;
	}
	
}
