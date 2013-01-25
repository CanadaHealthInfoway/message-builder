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
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ACT_CODE;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER;
import static ca.infoway.messagebuilder.datatype.lang.PersonName.createFirstNameLastName;
import static ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType.STREET_NAME;
import static ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse.HOME;
import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.ALWAYS;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_PATIENT_NOTE_REQUEST;
import static ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION;
import static ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.IMMEDIATE;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static ca.infoway.messagebuilder.transport.SimpleRequestMessage.create;
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
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.domainvalue.payload.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt240002ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.CreatedBy_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.RefersTo_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.SenderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.AddPatientNoteRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ActingPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.CommentBean;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.transport.Credentials;
import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.UsernamePasswordCredentials;
import ca.infoway.messagebuilder.transport.rest.RestTransportLayer;
import ca.infoway.messagebuilder.version.Configuration;


/**
 * <p>This class shows how to send a simple AddPatientNote HL7 request to TL7, via the REST 
 * interface.
 */
public class AddPatientNoteExample {
	
	private static final String URL = "http://tl7.intelliware.ca/rest";

	public static void main(final String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Please enter userid and password as command-line arguments.");
		} else {
			DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault();
			ModelToXmlResult xmlRequest = createTransformer().transformToHl7AndReturnResult(
					R02_04_02, 
					createAddPatientNoteRequest());

			System.out.println("Here's the request:");
			System.out.println(xmlRequest.getXmlMessage());
			
			String xmlResponse = new RestTransportLayer(URL).sendRequestAndGetResponse(
					createCredentialsProvider(args[0], args[1]), 
					create(xmlRequest.getXmlMessage()));
			
			System.out.println("Here's the response:");
			System.out.println(xmlResponse);
		}
	}
	
	private static AddPatientNoteRequestBean createAddPatientNoteRequest() {
		AddPatientNoteRequestBean messageBean = new AddPatientNoteRequestBean();
		
		TriggerEvent_1Bean<CommentBean> controlActEvent = new TriggerEvent_1Bean<CommentBean>();
		messageBean.setControlActEvent(controlActEvent);
		
		controlActEvent.setCode(ADD_PATIENT_NOTE_REQUEST);
		
		populateMessageAttributesStandardValues(messageBean);
		populateRecordControlActStandardValues(controlActEvent);

		// payload
		controlActEvent.setSubject(new RefersTo_1Bean<CommentBean>());
		controlActEvent.getSubject().setAct(createCommentBean());
		controlActEvent.getSubject().setContextConductionInd(true);
		
		return messageBean;
	}
	
	private static CommentBean createCommentBean() {
		CommentBean noteBean = new CommentBean();
		noteBean.setCode(
				lookup(ActPatientAnnotationCode.class, "MED", VOCABULARY_ACT_CODE.getRoot()));
		noteBean.setText("note text");
		noteBean.getConfidentialityCode().add(Confidentiality.NORMAL);
		return noteBean;
	}
	
	private static void populateMessageAttributesStandardValues(HL7Message_1Bean<?> message) {
		message.setId(new Identifier(UUID.randomUUID().toString()));
		message.setCreationTime(new GregorianCalendar(2008, JUNE, 25, 14, 16, 10).getTime());
		message.getProfileId().add(new Identifier("1.2.3.4.5", "profileIdExtension"));
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

	private static void populateRecordControlActStandardValues(TriggerEvent_1Bean<CommentBean> controlActEvent) {
		controlActEvent.setId(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		controlActEvent.setEffectiveTime(IntervalUtil.createInterval(new Date(0), new Date()));
		controlActEvent.setSpecializationType("effectiveTime", StandardDataType.IVL_FULL_DATE_TIME);		
		controlActEvent.setAuthor(createAuthorBean());
		controlActEvent.setLocationServiceDeliveryLocation(createServiceDeliveryLocationBean());
		controlActEvent.setResponsiblePartyAssignedEntity(createHealthcareWorkerBean());
		controlActEvent.setRecordTargetPatient1(createIdentifiedPersonBean());
	}

	private static ServiceLocationBean createServiceDeliveryLocationBean() {
		ServiceLocationBean result = new ServiceLocationBean();
		result.setId(new Identifier("2.16.124.113620.1.1.11111", "1"));
		result.setLocationName("Intelliware's Pharmacy");
		return result;
	}

	private static ActingPersonBean createAssignedPersonBean() {
		ActingPersonBean assignedPersonBean = new ActingPersonBean();
		assignedPersonBean.setName(createFirstNameLastName("John", "Doe"));
		return assignedPersonBean;
	}

	private static CreatedBy_1Bean createAuthorBean() {
		CreatedBy_1Bean authorBean = new CreatedBy_1Bean();
		authorBean.setTime(new Date(0));
		authorBean.setAuthorPerson(createHealthcareWorkerBean());
		return authorBean;
	}

	private static HealthcareWorkerBean createHealthcareWorkerBean() {
		HealthcareWorkerBean healthcareWorkerBean = new HealthcareWorkerBean();
		healthcareWorkerBean.getId().add(new Identifier("1.1.1", "1"));
		healthcareWorkerBean.setAssignedPerson(createAssignedPersonBean());
		return healthcareWorkerBean;
	}

	private static Patient_1Bean createIdentifiedPersonBean() {
		Patient_1Bean identifiedPersonBean = new Patient_1Bean();
		identifiedPersonBean.getId().add(new Identifier("3.14", "159"));
		identifiedPersonBean.setAddr(createPostalAddress());
		identifiedPersonBean.getTelecom().add(new TelecommunicationAddress(
				lookup(URLScheme.class, "http"), "123.456.789.10"));
		ActingPersonBean patientPerson = new ActingPersonBean();
		patientPerson.setName(PersonName.createFirstNameLastName("Alan", "Wall"));
		patientPerson.setAdministrativeGenderCode(
				lookup(AdministrativeGender.class, "F", VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		patientPerson.setBirthTime(new GregorianCalendar(1972, 2, 21).getTime());
		identifiedPersonBean.setPatientPerson(patientPerson);
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

	private static MessageBeanTransformerImpl createTransformer() {
		return new MessageBeanTransformerImpl();
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