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

package ca.infoway.messagebuilder.model.newfoundland;

import static ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType.FAMILY;
import static ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType.GIVEN;
import static ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse.LEGAL;
import static ca.infoway.messagebuilder.domainvalue.payload.QueryResponse.DATA_FOUND;
import static ca.infoway.messagebuilder.domainvalue.payload.QueryResponse.NO_DATA_FOUND;
import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.ALWAYS;
import static ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION;
import static ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode.CURRENT_PROCESSING;
import static ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.IMMEDIATE;
import static java.util.Calendar.JUNE;
import static java.util.Calendar.SEPTEMBER;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.URLScheme;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementType;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class MessageBeanBuilderSupport {

	public static final Date EFFECTIVE_TIME = new GregorianCalendar(2008, SEPTEMBER, 18).getTime();

	public static final Interval<Date> EFFECTIVE_TIME_IVL = IntervalFactory.createLowHigh(
			new GregorianCalendar(2008, SEPTEMBER, 18).getTime(), 
			new GregorianCalendar(2008, SEPTEMBER, 20).getTime()); 

	public static void populateStandardValues(ResponseMessageAttributesBean bean) {
		populateStandardValuesV02(bean);
		populateAcknowledgement(bean);
	}

	public static void populateStandardValuesV01(ResponseMessageAttributesBean bean) {
		populateStandardValuesV01((MessageAttributesBean) bean);
		populateAcknowledgement(bean);
	}
	
	public static void populateStandardValuesV01(MessageAttributesBean bean) {
		bean.setMessageId(new Identifier("2.16.124.113620.1.1.1.1.2", "293844"));
		bean.setCreationDate(new GregorianCalendar(2008, JUNE, 25, 14, 16, 10).getTime());
//		bean.getProfileId().add(new Identifier("2.16.840.1.113883.3.133.3.100", "EHR-0008"));
		bean.setProcessingId(PRODUCTION);
		bean.setProcessingMode(CURRENT_PROCESSING);
		bean.setAcknowledgementCondition(ALWAYS);
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
	public static void populateStandardValuesV02(MessageAttributesBean bean) {
		populateStandardValuesV01(bean);
		bean.setResponseModeCode(IMMEDIATE);
	}

	public static void populateStandardValues(ControlActEventBean controlActEvent) {
		controlActEvent.setEventId(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		controlActEvent.setStatusCode(CodeResolverRegistry.lookup(ActStatus.class, "new"));
		controlActEvent.setEffectiveTime(EFFECTIVE_TIME);
		controlActEvent.setAuthor(createAuthorV01());
//		controlActEvent.setDataEnterer(new AssignedPersonBeanBuilder().populate().create());
		ServiceDeliveryLocationBean location = new ServiceDeliveryLocationBean();
		populateLocation(location);
		controlActEvent.setLocation(location);
	}
	
	public static void populateAcknowledgement(AcknowledgementBean acknowledgement) {
		acknowledgement.setAcknowledgementType(AcknowledgementType.ACCEPT_ACKNOWLEDGEMENT_COMMIT_ACCEPT);
		acknowledgement.setTargetMessage(new Identifier("11.22.33.44", "1234"));
	}

	private static void populateAcknowledgement(ResponseMessageAttributesBean bean) {
		bean.setAcknowledgementCondition(AcknowledgementCondition.NEVER);
		
		// TODO - TM - OLDTEAL - any need to preserve these lines? 
		bean.getAcknowledgement().setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);		
		bean.getAcknowledgement().setTargetMessage(new Identifier("2.16.124.113620.1.1.1.1.2", "293844"));		
	}
	
	private static AuthorBean createAuthorV01() {
		AuthorBean result = new AuthorBean();
		result.setTime(new GregorianCalendar(2008, SEPTEMBER, 18, 18, 18).getTime());
		result.setId(new Identifier("2.16.840.1.113883.4.267", "EHR ID EXT"));
		result.setLicenseNumber(new Identifier("2.16.840.1.113883.4.268", "55555"));
		
		// TODO: I'm a little unhappy about this. The data setup seems too HL7-y. Would it be better to retain the PersonNameBean and the adaptor?
		PersonName name = new PersonName();
		name.addNamePart(new EntityNamePart("Jane", GIVEN));
		name.addNamePart(new EntityNamePart("Doe", FAMILY));
		name.addUse(LEGAL);
		result.setName(name);
		
		return result;
	}
	
	private static void populateLocation(ServiceDeliveryLocationBean location) {
		location.setIdentifier(new Identifier("2.16.124.113620.1.1.11111", "1"));
		location.setName("Intelliware's Pharmacy");
	}

	public static void populateStandardValues(QueryResponseControlActEventBean<? extends QueryCriteria, ?> controlActEvent) {
		populateStandardValuesV01((ControlActEventBean) controlActEvent);
		populateQuerySummary(controlActEvent.getQueryResultsSummary(), new Identifier("1.2.3", "4"));
		controlActEvent.getIssues().add(createDetectedIssue());
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

	public static void populateQuerySummary(QueryResultsSummaryBean querySummary, Identifier queryId, List<?> records) {
		querySummary.setQueryResponseCode(records.isEmpty() ? NO_DATA_FOUND :  DATA_FOUND);
		querySummary.setResultTotalQuantity(records.size());
		querySummary.setResultCurrentQuantity(records.size());
		querySummary.setResultRemainingQuantity(0);
		querySummary.setQueryId(queryId);
	}
	public static void populateQuerySummary(QueryResultsSummaryBean querySummary, Identifier queryId) {
		querySummary.setQueryResponseCode(DATA_FOUND);
		querySummary.setResultTotalQuantity(1);
		querySummary.setResultCurrentQuantity(1);
		querySummary.setResultRemainingQuantity(0);
		querySummary.setQueryId(queryId);
	}
	
	private static DetectedIssueBean createDetectedIssue() {
		DetectedIssueBean detectedIssue = new DetectedIssueBean();
		populateDetectedIssue(detectedIssue);
		return detectedIssue;
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

	// TODO - TM - OLDTEAL - can this be removed?
	
	@Deprecated
	public static void populateBetterStandardValuesV02(MessageAttributesBean messageAttributes) {
		populateStandardValuesV02(messageAttributes);
		messageAttributes.getReceiver().getTelecommunicationAddress().setUrlScheme(ca.infoway.messagebuilder.domainvalue.basic.URLScheme.HTTP);
		messageAttributes.getReceiver().getTelecommunicationAddress().setAddress("123.255.255.10");
	}
	public static void populateMoreBetterStandardValues(MessageAttributesBean messageAttributes) {
		populateBetterStandardValuesV02(messageAttributes);
		messageAttributes.getSender().setDeviceId(new Identifier("2.16.124.113620.1.2.100", "111"));
		messageAttributes.getReceiver().setDeviceId(new Identifier("2.16.124.113620.1.2.100", "222"));
		messageAttributes.setMessageId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad51"));
		
		if (messageAttributes instanceof ResponseMessageAttributesBean) {
			((ResponseMessageAttributesBean) messageAttributes).getAcknowledgement().setAcknowledgementType(AcknowledgementType.APPLICATION_ACKNOWLEDGEMENT_ACCEPT);
//			((ResponseMessageAttributesBean) messageAttributes).getAcknowledgement().setMessageWaitingNumber(0);
			((ResponseMessageAttributesBean) messageAttributes).getAcknowledgement().setTargetMessage(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad41"));
		}
	}

	public static void populateQuerySummary(NewQueryResponseMessageBean<?, ?> responseBean) {
		populateQuerySummary(responseBean.getQuerySummary(), responseBean.getQueryId(), responseBean.getQueryRecords());
	}
}
