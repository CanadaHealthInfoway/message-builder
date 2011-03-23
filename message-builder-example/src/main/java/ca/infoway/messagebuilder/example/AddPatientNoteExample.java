package ca.infoway.messagebuilder.example;

import static ca.infoway.messagebuilder.SpecificationVersion.R02_04_02;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ACT_CODE;
import static ca.infoway.messagebuilder.codesystem.CodeSystem.VOCABULARY_ADMINISTRATIVE_GENDER;
import static ca.infoway.messagebuilder.datatype.lang.PersonName.createFirstNameLastName;
import static ca.infoway.messagebuilder.datatype.lang.PostalAddressPartType.STREET_NAME;
import static ca.infoway.messagebuilder.datatype.lang.PostalAddressUse.HOME;
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

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.URLScheme;
import ca.infoway.messagebuilder.datatype.lang.util.IntervalUtil;
import ca.infoway.messagebuilder.domainvalue.ActPatientAnnotationCode;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.payload.Confidentiality;
import ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.model.common.mcai_mt700210ca.TriggerEventBean;
import ca.infoway.messagebuilder.model.common.mcci_mt002100ca.HL7MessageBean;
import ca.infoway.messagebuilder.model.iehr.comt_mt300001ca.CommentBean;
import ca.infoway.messagebuilder.model.interaction.AddPatientNoteRequestBean;
import ca.infoway.messagebuilder.model.merged.AssignedEntity_1Bean;
import ca.infoway.messagebuilder.model.merged.Author_1Bean;
import ca.infoway.messagebuilder.model.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.merged.ReceiverBean;
import ca.infoway.messagebuilder.model.merged.SenderBean;
import ca.infoway.messagebuilder.model.merged.ServiceDeliveryLocation_1Bean;
import ca.infoway.messagebuilder.model.merged.Subject2_1Bean;
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
		
		TriggerEventBean<CommentBean> controlActEvent = new TriggerEventBean<CommentBean>();
		messageBean.setControlActEvent(controlActEvent);
		
		controlActEvent.setEventType(ADD_PATIENT_NOTE_REQUEST);
		
		populateMessageAttributesStandardValues(messageBean);
		populateRecordControlActStandardValues(controlActEvent);

		// payload
		controlActEvent.setSubject(new Subject2_1Bean<CommentBean>());
		controlActEvent.getSubject().setAct(createCommentBean());
		
		return messageBean;
	}
	
	private static CommentBean createCommentBean() {
		CommentBean noteBean = new CommentBean();
		noteBean.setPatientNoteCategory(
				lookup(ActPatientAnnotationCode.class, "MED", VOCABULARY_ACT_CODE.getRoot()));
		noteBean.setPatientNoteText("note text");
		noteBean.getRestrictedPatientAccess().add(Confidentiality.NORMAL);
		return noteBean;
	}
	
	private static void populateMessageAttributesStandardValues(HL7MessageBean<?> message) {
		message.setMessageIdentifier(new Identifier(UUID.randomUUID().toString()));
		message.setMessageTimestamp(new GregorianCalendar(2008, JUNE, 25, 14, 16, 10).getTime());
		message.getConformanceProfileIdentifiers().add(new Identifier("1.2.3.4.5", "profileIdExtension"));
		message.setProcessingCode(PRODUCTION);
		message.setProcessingMode(ProcessingMode.CURRENT_PROCESSING);
		message.setDesiredAcknowledgmentType(ALWAYS);
		message.setReceiver(new ReceiverBean());
		message.getReceiver().setRespondToApplicationIdentifier(new Identifier("2.16.124.113620.1.2.100", "222"));
		message.getReceiver().setReceiverNetworkAddress(new TelecommunicationAddress(
				lookup(URLScheme.class, "http"), "123.456.789.10"));
		message.setSender(new SenderBean());
		message.getSender().setSendingApplicationIdentifier(new Identifier("2.16.124.113620.1.2.100", "111"));
		message.getSender().setSendingSoftwareVersionNumber(new Configuration().getVersion());
		message.getSender().setSendingApplicationName(new Configuration().getName());
		message.getSender().setSendingNetworkAddress(new TelecommunicationAddress());
		message.getSender().getSendingNetworkAddress().setAddress("987.654.321.0");
		message.getSender().getSendingNetworkAddress().setUrlScheme(
				lookup(URLScheme.class, "http"));
		message.setResponseType(IMMEDIATE);
		message.getReceiver().setDeviceAgentAgentOrganization(null);
		message.getSender().setDeviceAgentAgentOrganization(null);
	}	

	private static void populateRecordControlActStandardValues(TriggerEventBean<CommentBean> controlActEvent) {
		controlActEvent.setEventIdentifier(new Identifier("2.16.840.1.113883.1.6", "8141234"));
		controlActEvent.setEventEffectivePeriod(IntervalUtil.createInterval(new Date(0), null));
		controlActEvent.setAuthor(createAuthorBean());
		controlActEvent.setLocationServiceDeliveryLocation(createServiceDeliveryLocationBean());
		controlActEvent.setResponsiblePartyAssignedEntity(createAssignedPersonBean());
		controlActEvent.setRecordTargetPatient1(createIdentifiedPersonBean());
	}

	private static ServiceDeliveryLocation_1Bean createServiceDeliveryLocationBean() {
		ServiceDeliveryLocation_1Bean result = new ServiceDeliveryLocation_1Bean();
		result.setLocationIdReference(new Identifier("2.16.124.113620.1.1.11111", "1"));
		result.setServiceLocationName("Intelliware's Pharmacy");
		return result;
	}

	private static AssignedEntity_1Bean createAssignedPersonBean() {
		AssignedEntity_1Bean assignedPersonBean = new AssignedEntity_1Bean();
		assignedPersonBean.getHealthcareWorkerIdentifier().add(new Identifier("12.34.56", "1"));
//		assignedPersonBean.setHealthcareWorkerType(
//				lookup(HealthcareProviderRoleType.class, "ACP", VOCABULARY_ROLE_CODE.getRoot()));
		assignedPersonBean.setHealthcareWorkerName(createFirstNameLastName("John", "Doe"));
		assignedPersonBean.getHealthcareWorkerIdentifier().add(new Identifier("77.33.22.11", "1"));
		return assignedPersonBean;
	}

	private static Author_1Bean createAuthorBean() {
		Author_1Bean authorBean = new Author_1Bean();
		authorBean.setTimeOfCreation(new Date(0));
		AssignedEntity_1Bean authorPerson = createAssignedPersonBean();
		authorBean.setAuthorPerson(authorPerson);
		authorPerson.getHealthcareWorkerIdentifier().add(new Identifier("1.1.1", "1"));
		authorPerson.setHealthcareWorkerName(createFirstNameLastName("John", "Doe"));
		return authorBean;
	}

	private static Patient_1Bean createIdentifiedPersonBean() {
		Patient_1Bean identifiedPersonBean = new Patient_1Bean();
		identifiedPersonBean.getPatientIdentifier().add(new Identifier("3.14", "159"));
		identifiedPersonBean.setPatientContactAddress(createPostalAddress());
		identifiedPersonBean.getPatientContactPhoneAndEMails().add(new TelecommunicationAddress(
				lookup(URLScheme.class, "http"), "123.456.789.10"));
		identifiedPersonBean.setPatientName(PersonName.createFirstNameLastName("Alan", "Wall"));
		identifiedPersonBean.setPatientGender(
			lookup(AdministrativeGender.class, "F", VOCABULARY_ADMINISTRATIVE_GENDER.getRoot()));
		identifiedPersonBean.setPatientBirthDate(new GregorianCalendar(1972, 2, 21).getTime());
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