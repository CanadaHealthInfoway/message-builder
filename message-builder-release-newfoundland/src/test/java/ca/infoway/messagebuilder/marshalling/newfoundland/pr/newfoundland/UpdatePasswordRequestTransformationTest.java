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

package ca.infoway.messagebuilder.marshalling.newfoundland.pr.newfoundland;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.SpecificationVersion;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.BaseTealMlTransformerTestCase;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.newfoundland.AcknowledgementBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedDeviceBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.pr.PasswordChangeBean;
import ca.infoway.messagebuilder.model.newfoundland.pr.UpdatePasswordRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.pr.UpdatePasswordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.pr.UpdatePasswordRequestRefusedMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class UpdatePasswordRequestTransformationTest extends BaseTealMlTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/provider/newfoundland/updatePasswordRequest.xml";
	private static final String ACCEPTED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/provider/newfoundland/updatePasswordRequestAccepted.xml";
	private static final String REFUSED_MESSAGE_FILE = "ca/infoway/messagebuilder/sample/provider/newfoundland/updatePasswordRequestRefused.xml";
	
	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xml = this.transformer.transformToHl7(
				SpecificationVersion.NEWFOUNDLAND,
				createRequest());
		assertNotNull("result", xml);
	}

	@Test
	public void shouldMatchKnownMessage() throws Exception {
		UpdatePasswordRequestMessageBean model = createRequest();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldParseMessage() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
		Assert.assertTrue("type", xmlToJavaResult.getMessageObject() instanceof UpdatePasswordRequestMessageBean);		
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		Document message = this.factory.createFromResource(new ClasspathResource(REQUEST_MESSAGE_FILE));
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(SpecificationVersion.NEWFOUNDLAND, message);
		String xmlString = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, (NewBaseMessageBean) xmlToJavaResult.getMessageObject());
		assertTreeEquals(message, this.factory.createFromString(xmlString));
	}

	private UpdatePasswordRequestMessageBean createRequest() {
		UpdatePasswordRequestMessageBean model = new UpdatePasswordRequestMessageBean();
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.UPDATE_PASSWORD_REQUEST);
		model.getControlActEvent().setRegistrationBean(new RegistrationRequestBean<PasswordChangeBean>());
		model.getControlActEvent().getRegistrationBean().setRecord(new PasswordChangeBean());
		model.getControlActEvent().getRegistrationBean().getRecord().setText("newPassw0rd");

		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		model.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
		
		return model;
	}

	@Test
	public void shouldMatchKnownAcceptedResponse() throws Exception {
		UpdatePasswordRequestAcceptedMessageBean model = createAcceptedBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				ACCEPTED_MESSAGE_FILE)), actual);
	}

	private UpdatePasswordRequestAcceptedMessageBean createAcceptedBean() {
		UpdatePasswordRequestAcceptedMessageBean model = new UpdatePasswordRequestAcceptedMessageBean();
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.UPDATE_PASSWORD_REQUEST_ACCEPTED);
		model.getControlActEvent().setRegistrationBean(new RegistrationEventBean<ActEventBean>());
		model.getControlActEvent().getRegistrationBean().setRecord(new ActEventBean());
		model.getControlActEvent().getRegistrationBean().getRecord().setId(new Identifier("1.2.3.4.5", "555"));		
		
		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		model.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
		
		model.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		
		return model;
	}

	@Test
	public void shouldMatchKnownRefusedResponse() throws Exception {
		UpdatePasswordRequestRefusedMessageBean model = createRefusedBean();
		String xml = this.transformer.transformToHl7(SpecificationVersion.NEWFOUNDLAND, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(
				REFUSED_MESSAGE_FILE)), actual);
	}

	private UpdatePasswordRequestRefusedMessageBean createRefusedBean() {
		UpdatePasswordRequestRefusedMessageBean model = new UpdatePasswordRequestRefusedMessageBean();
		MessageBeanBuilderSupport.populateStandardValuesV02(model.getMessageAttributes());
		model.getMessageAttributes().setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		model.getControlActEvent().setCode(HL7TriggerEventCode.UPDATE_PASSWORD_REQUEST_REFUSED);
		model.getControlActEvent().setRegistrationBean(new RegistrationEventBean<ActEventBean>());
		model.getControlActEvent().getRegistrationBean().setRecord(new ActEventBean());
		model.getControlActEvent().getRegistrationBean().getRecord().setId(new Identifier("1.2.3.4.5", "555"));
		
		AssignedDeviceBean custodian = new AssignedDeviceBean();
		custodian.setId(new Identifier("1.2.3.4.5", "444"));
		custodian.setAssignedRepository("Panacea");
		custodian.setRepresentedRepositoryJurisdiction("somewhere");
		model.getControlActEvent().getRegistrationBean().setAssignedDevice(custodian);
		
		model.setAcknowledgement(new AcknowledgementBeanBuilder().populate().create());
		
		return model;

	}
	
}
