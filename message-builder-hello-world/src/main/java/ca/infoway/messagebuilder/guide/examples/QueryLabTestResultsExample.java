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

package ca.infoway.messagebuilder.guide.examples;

import static ca.infoway.messagebuilder.SpecificationVersion.R02_04_02;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER;
import static ca.infoway.messagebuilder.datatype.lang.PersonName.createFirstNameLastName;
import static ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType.STREET_NAME;
import static ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse.HOME;
import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.ALWAYS;
import static ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION;
import static ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.IMMEDIATE;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static java.util.Calendar.JUNE;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalFactory;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode;
import ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.RenderMode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt240002ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.CreatedBy_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.SenderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_5Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.RequestQueryResultsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged.ParameterListBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.transport.Credentials;
import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.SimpleRequestMessage;
import ca.infoway.messagebuilder.transport.UsernamePasswordCredentials;
import ca.infoway.messagebuilder.transport.rest.RestTransportLayer;
import ca.infoway.messagebuilder.version.Configuration;


/**
 * <p>This class shows how to send a simple FindCandidates HL7 query to TL7, via the REST 
 * interface.
 */
public class QueryLabTestResultsExample {

	private static final String URL = "http://tl7.intelliware.ca/rest";
	
	public static void main(final String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Please enter userid and password as command-line arguments.");
		} else {
			DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
			ModelToXmlResult xmlQuery = createTransformer().transformToHl7AndReturnResult(
					R02_04_02, 
					createLabQuery());
			
			System.out.println("Here's the query:");
			System.out.println(xmlQuery.getXmlMessage());
			
			String xmlResponse = new RestTransportLayer(URL).sendRequestAndGetResponse(
					createCredentialsProvider(args[0], args[1]), 
					SimpleRequestMessage.create(xmlQuery.getXmlMessage()));

			System.out.println("Here's the response:");
			System.out.println(xmlResponse);
		}
	}

	private static RequestQueryResultsBean createLabQuery() {
		RequestQueryResultsBean messageBean = new RequestQueryResultsBean();
		messageBean.setControlActEvent(new TriggerEvent_5Bean<ParameterListBean>());
		messageBean.getControlActEvent().setQueryByParameter(new QueryByParameterBean<ParameterListBean>());
		messageBean.getControlActEvent().getQueryByParameter().setParameterList(new ParameterListBean());
		messageBean.getControlActEvent().setCode(HL7TriggerEventCode.LAB_TEST_RESULTS_QUERY);
		populateMessageAttributesStandardValues(messageBean);
		populateQueryControlActStandardValues(messageBean.getControlActEvent());
		
		messageBean.getControlActEvent().setRecordTargetPatient1(createIdentifiedPersonBean());
		
		// payload
		messageBean.getControlActEvent().getQueryByParameter().getParameterList().setPatientNameValue(createFirstNameLastName("Joel", "Houston"));
		messageBean.getControlActEvent().getQueryByParameter().getParameterList().setPatientIDValue(new Identifier("11.22.33", "55.66.77"));
		
		// add additional query filters here
		// messageBean.getControlActEvent().getQueryByParameter().getParameterList().setXXX...
		return messageBean;
	}
	
	private static void populateMessageAttributesStandardValues(HL7Message_1Bean<?> message) {
		message.setId(new Identifier(UUID.randomUUID().toString()));
		message.setCreationTime(new GregorianCalendar(2008, JUNE, 25, 14, 16, 10).getTime());
		message.getProfileId().add(new Identifier("2.16.840.1.113883.2.20.2", "R02.04.02"));
		message.setProcessingCode(PRODUCTION);
		message.setProcessingModeCode(ProcessingMode.CURRENT_PROCESSING);
		message.setAcceptAckCode(ALWAYS);
		message.setReceiver(new ReceiverBean());
		message.getReceiver().setDeviceId(new Identifier("2.16.124.113620.1.2.100", "222"));
		message.getReceiver().setTelecom(new TelecommunicationAddress(
				lookup(URLScheme.class, "http"), "123.456.789.10"));
		message.setSender(new SenderBean());
		message.getSender().setDeviceId(new Identifier("2.16.124.113620.1.2.100", "111"));
		message.getSender().setDeviceManufacturerModelName(new Configuration().getVersion());
		message.getSender().setDeviceName(new Configuration().getName());
		message.getSender().setTelecom(new TelecommunicationAddress());
		message.getSender().getTelecom().setAddress("987.654.321.0");
		message.getSender().getTelecom().setUrlScheme(
				lookup(URLScheme.class, "http"));
		message.setResponseModeCode(IMMEDIATE);
//		message.getReceiver().setDeviceAgentAgentOrganization(null);
//		message.getSender().setDeviceAgentAgentOrganization(null);
	}
	
	private static Patient_1Bean createIdentifiedPersonBean() {
		Patient_1Bean identifiedPersonBean = new Patient_1Bean();
		identifiedPersonBean.getId().add(new Identifier("3.14", "159"));
		identifiedPersonBean.setAddr(createPostalAddress());
		identifiedPersonBean.getTelecom().add(new TelecommunicationAddress(
				lookup(URLScheme.class, "http"), "123.456.789.10"));
		
		identifiedPersonBean.setPatientPersonName(PersonName.createFirstNameLastName("Alan", "Wall"));
		identifiedPersonBean.setPatientPersonBirthTime(new GregorianCalendar(1972, 2, 21).getTime());
		identifiedPersonBean.setPatientPersonAdministrativeGenderCode(
				lookup(AdministrativeGender.class, "F", VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		
		return identifiedPersonBean;
	}

	private static PostalAddress createPostalAddress() {
		return createPostalAddress("Bloor");
	}
	
	private static PostalAddress createPostalAddress(String streetName) {
		PostalAddress address1 = new PostalAddress();
		address1.addUse(HOME);
		address1.addPostalAddressPart(new PostalAddressPart(STREET_NAME, streetName));
		return address1;
	}

	private static void populateQueryControlActStandardValues(TriggerEvent_5Bean<ParameterListBean> triggerEventBean) {
		triggerEventBean.setId(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		triggerEventBean.setEffectiveTime(IntervalFactory.<Date>createLowHigh(new Date(0), new Date()));
		triggerEventBean.setSpecializationType("effectiveTime", StandardDataType.IVL_FULL_DATE_TIME);		
		triggerEventBean.setAuthor(createAuthorBean());
		triggerEventBean.setDataEntryLocationServiceDeliveryLocation(createServiceDeliveryLocationBean());
		triggerEventBean.getQueryByParameter().setQueryId(new Identifier("1ee83ff1-08ab-4fe7-b573-ea777e9bad31"));
	}
	
	private static ServiceLocationBean createServiceDeliveryLocationBean() {
		ServiceLocationBean result = new ServiceLocationBean();
		result.setId(new Identifier("2.16.124.113620.1.1.11111", "1"));
		result.setLocationName("Intelliware's Pharmacy");
		return result;
	}

//	private static OccurredAtBean createServiceDeliveryLocationBean() {
//		OccurredAtBean result = new OccurredAtBean();
//		
//		result.getServiceDeliveryLocation().setServiceLocationIdentifier(new Identifier("2.16.124.113620.1.1.11111", "1"));
//		result.getServiceDeliveryLocation().setServiceLocationName("Intelliware's Pharmacy");
//		return result;
//	}
	
	private static CreatedBy_1Bean createAuthorBean() {
		CreatedBy_1Bean authorBean = new CreatedBy_1Bean();
		authorBean.setTime(new Date());
		authorBean.setAuthorPerson(createHealthcareWorkerBean());
		return authorBean;
	}

	private static HealthcareWorkerBean createHealthcareWorkerBean() {
		HealthcareWorkerBean person = new HealthcareWorkerBean();
		person.getId().add(new Identifier("1.1.1", "1"));
		person.setAssignedPersonName(createFirstNameLastName("John", "Doe"));
		return person;
	}

	private static MessageBeanTransformerImpl createTransformer() {
		return new MessageBeanTransformerImpl(RenderMode.PERMISSIVE);
	}

	private static CredentialsProvider createCredentialsProvider(
			final String userid, final String password) {
		CredentialsProvider credentialsProvider = new CredentialsProvider() {
			public Credentials getCredentials() {
				return new UsernamePasswordCredentials(userid, password);
			}
		};
		return credentialsProvider;
	}		
}