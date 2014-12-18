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
import static ca.infoway.messagebuilder.codesystem.CodeSystem.ICD10;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.LOINC;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.SNOMED;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ACT_CODE;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ACT_STATUS;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ACT_UNCERTAINTY;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ALLERGY_TEST_VALUE;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_CONFIDENTIALITY;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ENTITY_CODE;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ROLE_CODE;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ROUTE_OF_ADMINISTRATION;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_SEVERITY_OBSERVATION;
import static ca.infoway.messagebuilder.datatype.lang.PersonName.createFirstNameLastName;
import static ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType.STREET_NAME;
import static ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse.HOME;
import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.ALWAYS;
import static ca.infoway.messagebuilder.domainvalue.transport.HL7TriggerEventCode.ADD_ALLERGY_INTOLERANCE_REQUEST;
import static ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION;
import static ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.IMMEDIATE;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.registerResolver;
import static ca.infoway.messagebuilder.transport.SimpleRequestMessage.create;
import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.JUNE;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.IntervalUtil;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.AllergyTestValue;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationAllergyTestType;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.domainvalue.controlact.ActStatus;
import ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode;
import ca.infoway.messagebuilder.error.Hl7Error;
import ca.infoway.messagebuilder.lang.EnumPattern;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.RenderMode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt240002ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.CreatedBy_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.RefersTo_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.SenderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.TriggerEvent_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActDiagnosisCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.AgentCategoryBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.AllergyIntoleranceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.AllergyTestsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ExposuresBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ReportedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ReportedReactionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.interaction.AddAllergyIntoleranceRequestBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ActingPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AllergyIntoleranceSeverityLevelBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.resolver.CompositeCodeResolver;
import ca.infoway.messagebuilder.resolver.EnumBasedCodeResolver;
import ca.infoway.messagebuilder.resolver.TrivialCodeResolver;
import ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator;
import ca.infoway.messagebuilder.transport.Credentials;
import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.UsernamePasswordCredentials;
import ca.infoway.messagebuilder.transport.rest.RestTransportLayer;
import ca.infoway.messagebuilder.version.Configuration;

/**
 * <p>
 * This class shows how to send a simple AddAllergyIntolerance HL7 request to
 * TL7, via the REST interface.
 */
public class AddAllergyIntoleranceExample {

	private static final String URL = "http://tl7.intelliware.ca/rest";

	public static void main(final String[] args) throws Exception {
		if (args.length != 2) {
			System.out
					.println("Please enter userid and password as command-line arguments.");
		} else {
			registerResolvers();
			ModelToXmlResult xmlRequest = createTransformer()
					.transformToHl7(R02_04_02,
							createAddAllergyIntoleranceRequest());

			System.out.println("Here's the request:");
			System.out.println(xmlRequest.getXmlMessage());
			
			for (Hl7Error hl7Error : xmlRequest.getHl7Errors()) {
				System.out.println(hl7Error);
			}
			

			String xmlResponse = new RestTransportLayer(URL)
					.sendRequestAndGetResponse(createCredentialsProvider(
							args[0], args[1]), create(xmlRequest
							.getXmlMessage()));

			System.out.println("Here's the response:");
			System.out.println(xmlResponse);
		}
	}

	private static AddAllergyIntoleranceRequestBean createAddAllergyIntoleranceRequest() {
		AddAllergyIntoleranceRequestBean messageBean = new AddAllergyIntoleranceRequestBean();

		TriggerEvent_1Bean<AllergyIntoleranceBean> controlActEvent = new TriggerEvent_1Bean<AllergyIntoleranceBean>();
		messageBean.setControlActEvent(controlActEvent);

		controlActEvent.setCode(ADD_ALLERGY_INTOLERANCE_REQUEST);
		populateMessageAttributesStandardValues(messageBean);
		messageBean.getProfileId().add(new Identifier("2.16.840.1.113883.2.20.2", "R02.04.02"));
		populateRecordControlActStandardValues(controlActEvent);

		// payload
		controlActEvent
				.setSubject(new RefersTo_1Bean<AllergyIntoleranceBean>());
		controlActEvent.getSubject().setAct(createAllergyIntoleranceBean());
		controlActEvent.getSubject().setContextConductionInd(true);

		return messageBean;
	}

	private static AllergyIntoleranceBean createAllergyIntoleranceBean() {
		AllergyIntoleranceBean allergyIntoleranceBean = new AllergyIntoleranceBean();
		allergyIntoleranceBean.setStatusCode(lookup(
				ActStatus.class, "active", VOCABULARY_ACT_STATUS.getRoot()));
		allergyIntoleranceBean.setCode(lookup(
				ObservationIntoleranceType.class, "OINT", VOCABULARY_ACT_CODE
						.getRoot()));
		allergyIntoleranceBean.getConfidentialityCode().add(
				lookup(x_BasicConfidentialityKind.class, "N",
						VOCABULARY_CONFIDENTIALITY.getRoot()));

		AllergyIntoleranceSeverityLevelBean severityLevelBean = new AllergyIntoleranceSeverityLevelBean();
		severityLevelBean.setValue(lookup(SeverityObservation.class,
				"H", VOCABULARY_SEVERITY_OBSERVATION.getRoot()));
		allergyIntoleranceBean
				.setSubjectOfSeverityObservation(severityLevelBean);

		allergyIntoleranceBean.setEffectiveTime(new GregorianCalendar(
				2009, 3, 22).getTime());
		allergyIntoleranceBean.setNegationInd(Boolean.TRUE);
		allergyIntoleranceBean
				.setUncertaintyCode(lookup(ActUncertainty.class, "N",
						VOCABULARY_ACT_UNCERTAINTY.getRoot()));
		allergyIntoleranceBean.setValue(lookup(IntoleranceValue.class, "NDA02",
				VOCABULARY_ENTITY_CODE.getRoot()));
		allergyIntoleranceBean
				.setSubjectOfSeverityObservation(severityLevelBean);
		allergyIntoleranceBean.setInformant(createInformant());
		allergyIntoleranceBean.setSubjectOf1(createNote());
		allergyIntoleranceBean.getSupportRecords()
				.add(createAllergyTestEvent());
		allergyIntoleranceBean.getSupportRecords().add(createAssessment());

		return allergyIntoleranceBean;
	}

	private static IncludesBean createNote() {
		NotesBean annotation = new NotesBean();
		annotation.setText("some allergy/intolerance note text");
		// annotation.setNoteTimestamp(new GregorianCalendar(2007, 6,
		// 21).getTime());
		annotation.setAuthorAssignedPerson(createHealthcareWorkerBean());

		IncludesBean notesBean = new IncludesBean();
		notesBean.setAnnotation(annotation);
		return notesBean;
	}

	private static HealthcareWorkerBean createHealthcareWorkerBean() {
		HealthcareWorkerBean noteAuthor = new HealthcareWorkerBean();
		noteAuthor.getId().add(
				new Identifier("12.34.56", "1"));
		ActingPersonBean assignedPerson = new ActingPersonBean();
		assignedPerson.setName(createFirstNameLastName("John", "Doe"));
		noteAuthor.setAssignedPerson(assignedPerson );
		return noteAuthor;
	}

	private static ReportedByBean createInformant() {
		ReportedByBean informant = new ReportedByBean();
		informant.setTime(new GregorianCalendar(1999, DECEMBER, 28).getTime());
		informant.setParty(createParty());
		return informant;
	}

	private static HealthcareWorkerBean createParty() {
		HealthcareWorkerBean assignedPersonBean = new HealthcareWorkerBean();
		assignedPersonBean.getId().add(
				new Identifier("12.34.56", "1"));
		ActingPersonBean person = new ActingPersonBean();
		person.setName(createFirstNameLastName("John", "Doe"));
		assignedPersonBean.setAssignedPerson(person);
		assignedPersonBean.setCode(lookup(
				HealthcareProviderRoleType.class, "ACP", VOCABULARY_ROLE_CODE
						.getRoot()));
		return assignedPersonBean;
	}

	private static void populateMessageAttributesStandardValues(
			HL7Message_1Bean<?> message) {
		message.setId(new Identifier(UUID.randomUUID()
				.toString()));
		message.setCreationTime(new GregorianCalendar(2008, JUNE, 25, 14,
				16, 10).getTime());
		message.getProfileId().add(
				new Identifier("1.2.3.4.5", "profileIdExtension"));
		message.setProcessingCode(PRODUCTION);
		message.setProcessingModeCode(ProcessingMode.CURRENT_PROCESSING);
		message.setAcceptAckCode(ALWAYS);
		message.setReceiver(new ReceiverBean());
		message.getReceiver().setDeviceId(
				new Identifier("2.16.124.113620.1.2.100", "222"));
		message.getReceiver().setTelecom(
				new TelecommunicationAddress(lookup(URLScheme.class, "http"),
						"123.456.789.10"));
		message.setSender(new SenderBean());
		message.getSender().setDeviceId(
				new Identifier("2.16.124.113620.1.2.100", "111"));
		message.getSender().setDeviceManufacturerModelName(
				new Configuration().getVersion());
		message.getSender().setDeviceName(
				new Configuration().getName());
		message.getSender().setTelecom(
				new TelecommunicationAddress());
		message.getSender().getTelecom().setAddress(
				"987.654.321.0");
		message.getSender().getTelecom().setUrlScheme(
				lookup(URLScheme.class, "http"));
		message.setResponseModeCode(IMMEDIATE);
		// message.getReceiver().setDeviceAgentAgentOrganization(null);
		// message.getSender().setDeviceAgentAgentOrganization(null);
	}

	private static void populateRecordControlActStandardValues(
			TriggerEvent_1Bean<AllergyIntoleranceBean> controlActEvent) {
		controlActEvent.setId(new Identifier(
				"2.16.840.1.113883.1.6", "8141234"));
		controlActEvent.setEffectiveTime(IntervalUtil.createInterval(
				new Date(0), new Date(0)));
		controlActEvent.setSpecializationType("effectiveTime", StandardDataType.IVL_FULL_DATE_TIME);		

		controlActEvent.setAuthor(createAuthorBean());
		controlActEvent
				.setLocationServiceDeliveryLocation(createServiceDeliveryLocationBean());
		controlActEvent
				.setResponsiblePartyAssignedEntity(createHealthcareWorkerBean());
		controlActEvent.setRecordTargetPatient1(createIdentifiedPersonBean());

	}

	private static ServiceLocationBean createServiceDeliveryLocationBean() {
		ServiceLocationBean result = new ServiceLocationBean();
		result.setId(new Identifier(
				"2.16.124.113620.1.1.11111", "1"));
		result.setLocationName("Intelliware's Pharmacy");
		return result;
	}

	private static CreatedBy_1Bean createAuthorBean() {
		CreatedBy_1Bean authorBean = new CreatedBy_1Bean();
		authorBean.setTime(new Date(0));
		authorBean.setAuthorPerson(createHealthcareWorkerBean());
		return authorBean;
	}

	private static Patient_1Bean createIdentifiedPersonBean() {
		Patient_1Bean identifiedPersonBean = new Patient_1Bean();
		identifiedPersonBean.getId().add(new Identifier("3.14", "159"));
		identifiedPersonBean.setAddr(createPostalAddress());
		identifiedPersonBean.getTelecom().add(new TelecommunicationAddress(
				lookup(URLScheme.class, "http"), "123.456.789.10"));
		
		ActingPersonBean patientPerson = new ActingPersonBean();
		patientPerson.setName(PersonName.createFirstNameLastName("Alan", "Wall"));
		patientPerson.setBirthTime(new GregorianCalendar(1972, 2, 21).getTime());
		patientPerson.setAdministrativeGenderCode(
				lookup(AdministrativeGender.class, "F", VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		
		identifiedPersonBean.setPatientPerson(patientPerson );
		
		return identifiedPersonBean;
	}

	private static PostalAddress createPostalAddress() {
		return createPostalAddress("Bloor");
	}

	private static PostalAddress createPostalAddress(String streetName) {
		PostalAddress address1 = new PostalAddress();
		address1.addUse(HOME);
		address1.addPostalAddressPart(new PostalAddressPart(STREET_NAME,
				streetName));
		return address1;
	}

	private static AllergyTestsBean createAllergyTestEvent() {
		AllergyTestsBean allergyTestEvent = new AllergyTestsBean();
		allergyTestEvent.setId(new Identifier(
				"2.16.840.1.113883.1.13", "995"));
		allergyTestEvent.setCode(lookup(
				ObservationAllergyTestType.class, "10921-5", LOINC.getRoot()));
		allergyTestEvent.setValue(lookup(AllergyTestValue.class,
				"A3", VOCABULARY_ALLERGY_TEST_VALUE.getRoot()));
		allergyTestEvent.setEffectiveTime(new GregorianCalendar(2009, 3, 10)
				.getTime());
		return allergyTestEvent;
	}

	private static ReportedReactionsBean createAssessment() {

		// nothing in this "kindBean" will show up in the example, as this bean does not apply in the message context
		AgentCategoryBean kindBean = new AgentCategoryBean();
		kindBean.setName("material name");
		kindBean.setCode(lookup(ExposureAgentEntityType.class,
				"NDA05", VOCABULARY_ENTITY_CODE.getRoot()));
		
		ExposuresBean exposureEvent = new ExposuresBean();
		exposureEvent.setId(new Identifier(
				"2.16.840.1.113883.1.133", "12"));
		exposureEvent
				.setConsumableAdministrableMaterialAdministerableMaterialKind(kindBean);
		exposureEvent.setRouteCode(lookup(RouteOfAdministration.class,
				"CHEW", VOCABULARY_ROUTE_OF_ADMINISTRATION.getRoot()));
		
		// the code below is actually the correct way to have specified the code that isn't showing up, above
//		exposureEvent.setConsumableAdministrableMaterialAdministerableMaterialKindCode(
//				lookup(ExposureAgentEntityType.class, "NDA05", VOCABULARY_ENTITY_CODE.getRoot()));

		AllergyIntoleranceSeverityLevelBean severityLevelBean = new AllergyIntoleranceSeverityLevelBean();
		severityLevelBean.setValue(lookup(SeverityObservation.class,
				"H", VOCABULARY_SEVERITY_OBSERVATION.getRoot()));

		ReportedReactionsBean subjectObservationEvent = new ReportedReactionsBean();
		subjectObservationEvent.setId(new Identifier(
				"2.16.840.1.113883.1.133", "15"));
		subjectObservationEvent.setCode(lookup(ActDiagnosisCode.class, "371627004",
				SNOMED.getRoot()));
		subjectObservationEvent.setNegationInd(Boolean.FALSE);
		subjectObservationEvent.setText("description of assessment");
		subjectObservationEvent
				.setEffectiveTime(IntervalFactory
						.<Date> createLow(new GregorianCalendar(2008, 3, 17)
								.getTime()));
		subjectObservationEvent.setValue(lookup(SubjectReaction.class, "Y45.1",
				ICD10.getRoot()));
		subjectObservationEvent
				.setSubjectOfSeverityObservation(severityLevelBean);

		ReportedReactionsBean assessmentBean = new ReportedReactionsBean();
		// assessmentBean.setAssessmentType(lookup(ObservationCausalityAssessmentType.class,
		// "RXNASSESS", VOCABULARY_ACT_CODE.getRoot()));
		assessmentBean.setCode(lookup(ActDiagnosisCode.class, "371627004", SNOMED
				.getRoot()));
		assessmentBean.setStartsAfterStartOfExposureEvent(exposureEvent);
		assessmentBean.setSubjectObservationEvent(subjectObservationEvent);

		return assessmentBean;
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

	static class TrivialSeverityObservation extends EnumPattern implements Code {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
		private static final long serialVersionUID = 6727127928910765846L;
		public static final TrivialSeverityObservation SEV = new TrivialSeverityObservation(
				"SEV");

		private TrivialSeverityObservation(String name) {
			super(name);
		}

		public String getCodeSystem() {
			return VOCABULARY_ACT_CODE.getRoot();
		}

		public String getCodeValue() {
			return name();
		}
	}

	private static void registerResolvers() {
		DefaultCodeResolutionConfigurator
				.configureCodeResolversWithTrivialDefault();
		registerResolver(ActCode.class, new CompositeCodeResolver(
				new EnumBasedCodeResolver(TrivialSeverityObservation.class),
				new TrivialCodeResolver()));
	}
}