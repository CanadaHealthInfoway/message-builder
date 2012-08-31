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

package ca.infoway.messagebuilder.marshalling.newfoundland.cerx.v01r04_3;

import static ca.infoway.messagebuilder.junit.XmlAssert.assertTreeEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.w3c.dom.Document;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.marshalling.newfoundland.BaseTransformerTestCase;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBean;
import ca.infoway.messagebuilder.model.newfoundland.MessageBeanBuilderSupport;
import ca.infoway.messagebuilder.model.newfoundland.RecordBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DetectedIssueBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ObservationCodedEventBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ObservationMeasurableEventBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.RecordDispenseProcessingRequestMessageBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SubstanceAdministrationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SupplyEventBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.DispenseRecordedConfirmationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.RecordDispenseProcessingRequestAcceptedMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.RecordDispenseProcessingRequestMessageBean;
import ca.infoway.messagebuilder.util.xml.ClasspathResource;

public class RecordDispenseProcessingTransformationTest extends BaseTransformerTestCase {
	
	private static final String REQUEST_MESSAGE_FILE =  "/ca/infoway/messagebuilder/sample/cerx/v01r04_3/recordDrugDispenseProcessingRequest.xml";

	@Test
	public void shouldProduceSomeResult() throws Exception {
		String xmlString = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, createRequestBean());
		assertNotNull("result", xmlString);
	}

	@Test
	public void shouldMatchKnownRequest() throws Exception {
		RecordDispenseProcessingRequestMessageBean model = createRequestBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document actual = this.factory.createFromString(xml);
		assertTreeEquals(this.factory.createFromResource(new ClasspathResource(getClass(), REQUEST_MESSAGE_FILE)), actual);
	}
	
	@Test
	public void shouldTransformBackAndForthWithoutLosingData() throws Exception {
		RecordDispenseProcessingRequestMessageBean requestBean = createRequestBean();
		
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, requestBean);
		Document message = this.factory.createFromString(xml);
		XmlToModelResult xmlToJavaResult = this.transformer.transformFromHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, message);
		MessageBean messageObject = (MessageBean) xmlToJavaResult.getMessageObject();
		String transformedBackToHl7Xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, messageObject);
		assertEquals(xml, transformedBackToHl7Xml);
	}

	@Test
	public void shouldFormatAcceptedResponse() throws Exception {
		RecordDispenseProcessingRequestAcceptedMessageBean model = createAcceptedResponseBean();
		String xml = this.transformer.transformToHl7(BaseTransformerTestCase.NEWFOUNDLAND_LEGACY_VERSION_HACK, model);
		Document actual = this.factory.createFromString(xml);
	}

	private RecordDispenseProcessingRequestMessageBean createRequestBean() {
		return new RecordDispenseProcessingRequestMessageBeanBuilder().populate().create();
	}

	private RecordDispenseProcessingRequestAcceptedMessageBean createAcceptedResponseBean() {
		RecordDispenseProcessingRequestAcceptedMessageBean model = new RecordDispenseProcessingRequestAcceptedMessageBean();
		model.getControlActEvent().setCode(HL7TriggerEventCode.RECORD_DISPENSE_PROCESSING_REQUEST_ACCEPTED);
		MessageBeanBuilderSupport.populateStandardValues(model.getMessageAttributes());
		model.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		MessageBeanBuilderSupport.populateStandardValues(model.getControlActEvent());
		
		DispenseRecordedConfirmationBean confirmationBean = new DispenseRecordedConfirmationBean();
		confirmationBean.setDispenseId(new Identifier("2.16.124.113620.1.1.7", "12345678"));
		confirmationBean.setPrescriptionId(new Identifier("2.16.124.113620.1.1.8", "12345678"));
		model.getControlActEvent().setRecordBean(new RecordBean<DispenseRecordedConfirmationBean>(confirmationBean));

		DetectedIssueBean issue = new DetectedIssueBeanBuilder().populate().create();
		
		SupplyEventBean dispenseCause1 = new SupplyEventBean();
		dispenseCause1.setId(new Identifier());
		issue.getCausalActs().add(dispenseCause1);

		ObservationCodedEventBean dispenseCause2 = new ObservationCodedEventBean();
		dispenseCause1.setId(new Identifier());
		issue.getCausalActs().add(dispenseCause2);
		
		SubstanceAdministrationBean dispenseCause3 = new SubstanceAdministrationBean();
		dispenseCause3.setId(new Identifier());
		issue.getCausalActs().add(dispenseCause3);
		
		ObservationMeasurableEventBean dispenseCause4 = new ObservationMeasurableEventBean();
		dispenseCause4.setId(new Identifier());
		issue.getCausalActs().add(dispenseCause4);
		
		model.getControlActEvent().getIssues().add(issue);
		return model;
	}

}
