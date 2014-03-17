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

package ca.infoway.messagebuilder.model.mock;

import static ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType.FAMILY;
import static ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType.GIVEN;
import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.ALWAYS;
import static ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION;
import static ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode.CURRENT_PROCESSING;

import java.util.Date;

import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.transport.ResponseMode;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class MessageBeanBuilderSupport {

	public static final Date EFFECTIVE_TIME = DateUtil.getDate(2008, 8, 18);

	public static void populateStandardValues(NoPayloadResponseMessageBean bean) {
		populateStandardValuesV02(bean);
		populateAcknowledgement(bean);
	}

	public static void populateStandardValuesV01(NoPayloadResponseMessageBean bean) {
		populateStandardValuesV01(bean);
		populateAcknowledgement(bean);
	}
	
	public static void populateStandardValuesV01(NewBaseMessageBean bean) {
		bean.setMessageIdentifier(new Identifier("2.16.124.113620.1.1.1.1.2", "293844"));
		bean.setMessageTimestamp(DateUtil.getDate(2008, 5, 25, 14, 16, 10, 0));
		bean.setProcessingCode(PRODUCTION);
		bean.setProcessingMode(CURRENT_PROCESSING);
		bean.setResponseType(ResponseMode.IMMEDIATE);
		bean.setDesiredAcknowledgmentType(ALWAYS);
		bean.setReceiver(new Receiver());
		bean.getReceiver().setDeviceId(new Identifier("1.2.3", "123"));
		bean.getReceiver().setTelecommunicationAddress(new TelecommunicationAddress(
				CodeResolverRegistry.lookup(URLScheme.class, "http"), "123.456.789.10"));
		bean.setSender(new Sender());
		bean.getSender().setDeviceId(new Identifier("1.2.3", "123"));
		bean.getSender().setManufacturerModelNumber("1.0");
		bean.getSender().setSoftwareName("Panacea Pharmacy");
		bean.getSender().setTelecommunicationAddress(new TelecommunicationAddress());
		bean.getSender().getTelecommunicationAddress().setAddress("987.654.321.0");
		bean.getSender().getTelecommunicationAddress().setUrlScheme(CodeResolverRegistry.lookup(URLScheme.class, "http"));
	}
	public static void populateStandardValuesV02(NewBaseMessageBean bean) {
		populateStandardValuesV01(bean);
	}

	public static void populateStandardValues(ControlActEventBean controlActEvent) {
		controlActEvent.setEventId(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		controlActEvent.setStatusCode(CodeResolverRegistry.lookup(ActStatus.class, "new"));
		controlActEvent.setEffectiveTime(EFFECTIVE_TIME);
		controlActEvent.setAuthor(createAuthorV01());
		ServiceDeliveryLocationBean location = new ServiceDeliveryLocationBean();
		populateLocation(location);
		controlActEvent.setLocation(location);
	}
	
	public static void populateAcknowledgement(AcknowledgementBean acknowledgement) {
		acknowledgement.setAcknowledgementType(AcknowledgementType.ACCEPT_ACKNOWLEDGEMENT_COMMIT_ACCEPT);
		acknowledgement.setTargetMessage(new Identifier("11.22.33.44", "1234"));
	}

	private static void populateAcknowledgement(NoPayloadResponseMessageBean bean) {
		bean.setDesiredAcknowledgmentType(AcknowledgementCondition.NEVER);
		
		// TM - OLDTEAL - any need to preserve these lines? 
		bean.getAcknowledgement().setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);		
		bean.getAcknowledgement().setTargetMessage(new Identifier("2.16.124.113620.1.1.1.1.2", "293844"));		
	}
	
	private static AuthorBean createAuthorV01() {
		AuthorBean result = new AuthorBean();
		result.setTime(DateUtil.getDate(2008, 8, 18, 18, 18, 0, 0));
		result.setId(new Identifier("2.16.840.1.113883.4.267", "EHR ID EXT"));
		result.setLicenseNumber(new Identifier("2.16.840.1.113883.4.268", "55555"));
		
		// I'm a little unhappy about this. The data setup seems too HL7-y. Would it be better to retain the PersonNameBean and the adaptor?
		PersonName name = new PersonName();
		name.addNamePart(new EntityNamePart("Jane", GIVEN));
		name.addNamePart(new EntityNamePart("Doe", FAMILY));
		result.setName(name);
		
		return result;
	}
	
	private static void populateLocation(ServiceDeliveryLocationBean location) {
		location.setIdentifier(new Identifier("2.16.124.113620.1.1.11111", "1"));
		location.setName("Intelliware's Pharmacy");
	}

	public static void populateStandardValuesV01(QueryControlActEventBean<? extends QueryCriteria> controlActEvent) {
		populateStandardValuesV01((ControlActEventBean) controlActEvent);
		ServiceDeliveryLocationBean location = new ServiceDeliveryLocationBean();
		populateLocation(location);
		controlActEvent.setLocation(location);		
	}
	
	private static void populateStandardValuesV01(ControlActEventBean controlActEvent) {
		controlActEvent.setEventId(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		controlActEvent.setStatusCode(CodeResolverRegistry.lookup(ActStatus.class, "new"));
		controlActEvent.setEffectiveTime(EFFECTIVE_TIME);
		controlActEvent.setAuthor(createAuthorV01());
	}

	public static void populateDetectedIssue(DetectedIssueBean detectedIssue) {
		detectedIssue.setCode(CodeResolverRegistry.lookup(ActDetectedIssueCode.class, "VALIDAT"));
		detectedIssue.setPriorityCode(CodeResolverRegistry.lookup(ActIssuePriority.class, "I"));
		detectedIssue.setStatusCode(CodeResolverRegistry.lookup(ActStatus.class, "NORMAL"));
		detectedIssue.setText("patient not found");
		detectedIssue.setSeverityObservation(createSeverityObservation());
	}
	
	private static SeverityObservationBean createSeverityObservation() {
		SeverityObservationBean severityObservation = new SeverityObservationBean();
		
		severityObservation.setCode(CodeResolverRegistry.lookup(ActCode.class, "DX"));
		severityObservation.setStatusCode(CodeResolverRegistry.lookup(ActStatus.class, "NORMAL"));
		
		return severityObservation;
	}
	
	
	public static final IndeterminatePersonBean createPersonBean() {
		IndeterminatePersonBean personBean = new IndeterminatePersonBean();
		personBean.setAdministrativeGenderCode(AdministrativeGender.FEMALE);
		personBean.setBirthTime(new Date());
		personBean.setName(new PersonName());
		personBean.getName().addNamePart(new EntityNamePart("Jane", PersonNamePartType.GIVEN));
		personBean.getName().addNamePart(new EntityNamePart("Doe", PersonNamePartType.FAMILY));
		return personBean;
	}

	// TM - OLDTEAL - can this be removed?
	
	@Deprecated
	public static void populateBetterStandardValuesV02(NewBaseMessageBean messageAttributes) {
		populateStandardValuesV02(messageAttributes);
		messageAttributes.getReceiver().getTelecommunicationAddress().setUrlScheme(ca.infoway.messagebuilder.domainvalue.basic.URLScheme.HTTP);
		messageAttributes.getReceiver().getTelecommunicationAddress().setAddress("123.255.255.10");
	}
	public static void populateMoreBetterStandardValues(NewBaseMessageBean messageAttributes) {
		populateBetterStandardValuesV02(messageAttributes);
		messageAttributes.getSender().setDeviceId(new Identifier("2.16.124.113620.1.2.100", "111"));
		messageAttributes.getReceiver().setDeviceId(new Identifier("2.16.124.113620.1.2.100", "222"));
		messageAttributes.setMessageIdentifier(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		messageAttributes.getConformanceProfileIdentifiers().add(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad52"));
		
		if (messageAttributes instanceof NoPayloadResponseMessageBean) {
			((NoPayloadResponseMessageBean) messageAttributes).setAcknowledgement(new AcknowledgementBean());
			((NoPayloadResponseMessageBean) messageAttributes).getAcknowledgement().setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);
			((NoPayloadResponseMessageBean) messageAttributes).getAcknowledgement().setTargetMessage(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad41"));
		}
	}
}
