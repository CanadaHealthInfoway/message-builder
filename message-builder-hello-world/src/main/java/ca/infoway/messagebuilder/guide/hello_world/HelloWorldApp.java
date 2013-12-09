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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
package ca.infoway.messagebuilder.guide.hello_world;

import static ca.infoway.messagebuilder.SpecificationVersion.R02_04_02;
import static ca.infoway.messagebuilder.domainvalue.transport.AcknowledgementCondition.ALWAYS;
import static ca.infoway.messagebuilder.domainvalue.transport.ProcessingID.PRODUCTION;
import static ca.infoway.messagebuilder.domainvalue.transport.ResponseMode.IMMEDIATE;
import static ca.infoway.messagebuilder.resolver.configurator.DefaultCodeResolutionConfigurator.configureCodeResolversWithTrivialDefault;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.VersionNumber;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.domainvalue.basic.X_BasicPostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.transport.ProcessingMode;
import ca.infoway.messagebuilder.guide.validation.MessageValidator;
import ca.infoway.messagebuilder.marshalling.MessageBeanTransformerImpl;
import ca.infoway.messagebuilder.marshalling.RenderMode;
import ca.infoway.messagebuilder.marshalling.hl7.ModelToXmlResult;
import ca.infoway.messagebuilder.marshalling.hl7.XmlToModelResult;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt240002ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.CreatedBy_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.CreatedBy_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HL7Message_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.Patient_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.ReceiverBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.SenderBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ActingPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.transport.Credentials;
import ca.infoway.messagebuilder.transport.CredentialsProvider;
import ca.infoway.messagebuilder.transport.RequestMessage;
import ca.infoway.messagebuilder.transport.SimpleRequestMessage;
import ca.infoway.messagebuilder.transport.TransportLayerException;
import ca.infoway.messagebuilder.transport.UsernamePasswordCredentials;
import ca.infoway.messagebuilder.transport.mohawk.MohawkTransportLayer;
import ca.infoway.messagebuilder.transport.rest.RestTransportLayer;
import ca.infoway.messagebuilder.util.xml.DocumentFactory;

public abstract class HelloWorldApp {
	
	protected abstract InteractionBean createRequestInteraction();
	protected abstract void processResponseInteraction(InteractionBean interactionBean);
	
	protected boolean isSimulatedMode = false;
	protected String responseExampleResourceFile = null;
	
	public static final VersionNumber MBSpecificationVersion = R02_04_02;
	
	public final void run(final String args[]) {
		
		String username = "";
		String passwd = "";
		String serviceType = "";
				
		if (args.length == 0) {
			isSimulatedMode = true;
			serviceType = "simulated";
		} else if (args.length == 3) {
			username = args[0];
			passwd = args[1];
			serviceType = args[2];
		} else {
			System.out
					.println("Please use no argument for simulated mode. Or enter userid and " +
							"password and serviceType as arguments for REST or SOAP mode.");
			System.out.println("Exited");
			System.exit(1);
		}
		
		configureCodeResolversWithTrivialDefault(); // Relaxes code vocabulary code checks.
		
		InteractionBean msg = this.createRequestInteraction();
		CredentialsProvider credentials = this.createCredentialsProvider(username, passwd);

		String xmlResponse = this.submitRequest(msg, credentials, this.serviceTypeFor(serviceType));
		
		System.out.println("\n\nHere's the response (XML):\n");
		System.out.println(xmlResponse);
		
		InteractionBean interactionBean = this.convertXMLToBean(xmlResponse);
		
		this.processResponseInteraction(interactionBean);
		System.out.println("Done");
	}
	
    private final ServiceType serviceTypeFor(String value) {
    	if (value.startsWith("simulated")) {
    		System.out.println("INFO: Simulated transport is used.");
    		return ServiceType.SIMULATED;
    	}else if (value.startsWith("soap")) {
    		System.out.println("INFO: SOAP transport is used.");
    		return ServiceType.SOAP;
    	}
    	else if (value.startsWith("rest")) {
    		System.out.println("INFO: REST transport is used.");
    		return ServiceType.REST;
    	}
    	else return ServiceType.UNKNOWN;
    }
	
	protected String submitRequest(InteractionBean msg, 
			CredentialsProvider credentials,
			ServiceType serviceType) {
		
		String xmlRequest = this.convertBeanToXML(msg);
		
		System.out.println("\nRequest Message (in XML):\n");
		System.out.println(xmlRequest);

		// Use Message Builder validator to validate the message
		MessageValidator.validate(xmlRequest, MBSpecificationVersion);
				
		String xmlResponse = new String("<null/>");
		switch(serviceType) {
		case SIMULATED:
			if (responseExampleResourceFile!=null) {
				System.out.printf("\nDeserializing example XML response from resource bundle: %s\n", responseExampleResourceFile);
				xmlResponse = this.readResourceFile(responseExampleResourceFile);
				return xmlResponse;
			}else {
				System.out.print("No example XML response is specified");
				System.exit(1);
			}			
		case SOAP:
			xmlResponse = this.submitSoapServiceRequest(xmlRequest, credentials);
			break;
		case REST:
			xmlResponse = this.submitRestServiceRequest(xmlRequest, credentials);
			break;
		default:
			System.out.print("No service type specified in command-line");
		    System.exit(1);
		}
		return xmlResponse;
	}
	
	
	private final String submitRestServiceRequest(String xmlRequest, CredentialsProvider credentials) {
		
		/* NOTE: 
		 * This code is intended to be used for reference only and it 
		 * may not return any response or meaningful response during 
		 * the execution of the program.  Appropriate code change needs 
		 * to be made to work with your specific REST based service provider.
		 */
		
		final String serviceURL = "http://tl7.intelliware.ca/rest";
		
		
		String xmlResponse = new RestTransportLayer(serviceURL).sendRequestAndGetResponse(
				credentials,
				SimpleRequestMessage.create(xmlRequest));

		return xmlResponse;
	} 
	
	private final String submitSoapServiceRequest(String xmlRequest, CredentialsProvider credentials) {

		/* NOTE: 
		 * This code is intended to be used for reference only and it 
		 * may not return any response or meaningful response during 
		 * the execution of the program.  Appropriate code change needs 
		 * to be made to work with your specific SOAP based service provider.
		 */
		
		MohawkTransportLayer transportLayer = new MohawkTransportLayer();
	
	
		RequestMessage requestMessage = null;
		try {
			requestMessage = SimpleRequestMessage.create(new DocumentFactory().createFromString(xmlRequest));
		} catch (TransportLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xmlResponse = transportLayer.sendRequestAndGetResponse(credentials, requestMessage);
		return xmlResponse;	
	}
	protected MessageBeanTransformerImpl createTransformer() {
		
		return new MessageBeanTransformerImpl(RenderMode.PERMISSIVE);
	}
	
	protected String convertBeanToXML(InteractionBean msgBean) {
		 ModelToXmlResult xmlQuery = this.createTransformer().transformToHl7(
				 MBSpecificationVersion, msgBean);
		return xmlQuery.getXmlMessage();
	}
	
	protected InteractionBean convertXMLToBean(String xml) {
		
		InteractionBean msgBean = null;
		
		MessageBeanTransformerImpl transformer = this.createTransformer();
		try {
			XmlToModelResult result = transformer.transformFromHl7(MBSpecificationVersion, new DocumentFactory().createFromString(xml));
			msgBean = (InteractionBean)result.getMessageObject();
		} catch (SAXException e) {
			System.err.print("SAXException in HelloWorldApp.deserialize() method");
			e.printStackTrace();
		} catch (Exception ex) {
			System.err.print("Exception in HelloWorldApp.deserialize() method");
			ex.printStackTrace();
		}
		return msgBean;
	}

	protected CredentialsProvider createCredentialsProvider(
			final String userid, final String password) {
		CredentialsProvider credentialsProvider = new CredentialsProvider() {
			public Credentials getCredentials() {
				return new UsernamePasswordCredentials(userid, password);
			}
		};
		return credentialsProvider;
	}
	
	// -- Helper Methods
	
	protected void setTransportWrapperValues(HL7Message_1Bean<?> messageBean) {
		// Fill in transport wrapper portion

		Identifier ii = new Identifier(UUID.randomUUID().toString());
		messageBean.setId(ii);
		messageBean.setCreationTime(new Date());
		messageBean.setProcessingModeCode(ProcessingMode.CURRENT_PROCESSING);

		Identifier profileId = new Identifier("2.16.840.1.113883.2.20.2",
				"R02.04.02");
		Identifier abProfileId = new Identifier(
				"2.16.840.1.113883.3.19.3.163.8", "AB-EHR");
		messageBean.getProfileId().add(profileId);
		messageBean.getProfileId().add(abProfileId);

		messageBean.setProcessingCode(PRODUCTION);
		messageBean.setAcceptAckCode(ALWAYS);
		messageBean.setResponseModeCode(IMMEDIATE);

		// Set Receiver (system that this query is addressed to)
		ReceiverBean receiver = new ReceiverBean();
		messageBean.setReceiver(receiver);
		receiver.setDeviceId(new Identifier(
				"2.16.840.1.113883.3.19.3.163.8", "EHR"));
		receiver.setTelecom(new TelecommunicationAddress(ca.infoway.messagebuilder.domainvalue.basic.URLScheme.HTTP,
				"www.ehr.ca/ehr"));
		receiver.setDeviceAgentAgentOrganizationId(null);

		// Set Sender
		SenderBean sender = new SenderBean();
		messageBean.setSender(sender);
		sender.setDeviceId(new Identifier(
				"2.16.840.1.113883.3.19.3.163.8", "DR-BLACK-EMR"));
		sender.setDeviceManufacturerModelName("5.0");
		sender.setDeviceSoftwareName("Infoway EMR");
		TelecommunicationAddress tel = new TelecommunicationAddress();
		tel.setAddress("www.infoway-inforoute.ca/emr");
		tel.setUrlScheme(URLScheme.HTTP);
		sender.setTelecom(tel);
		sender.setDeviceAgentAgentOrganizationId(null);
	}
	
	protected ServiceLocationBean createServiceLocationBean() {
		ServiceLocationBean locationBean = new ServiceLocationBean();
		locationBean.setId(new Identifier(
				"2.16.840.1.113883.19.3.163.9", "DR-BLACK-CLINIC"));

		locationBean.setLocationName("Dr. Black Family Physician Offices");
		return locationBean;
	}
	
	protected ServiceDeliveryLocationBean createServiceDeliveryLocationBean() {
		ServiceDeliveryLocationBean sdl = new ServiceDeliveryLocationBean();
		sdl.setId(new Identifier(
				"2.16.840.1.113883.19.3.163.9", "DR-BLACK-CLINIC"));

		sdl.setLocationName("Dr. Black Family Physician Offices");
		return sdl;
	}

	protected CreatedBy_2Bean createAuthor_2Bean() {
		CreatedBy_2Bean authorBean = new CreatedBy_2Bean();
		authorBean.setTime(new Date());
		
		ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean authorPerson = new ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean();
		
		Identifier healthcareProviderId = new Identifier(
				"2.16.840.1.113883.3.19.3.163.1.2", "200202888");

		PersonName pn = PersonName.createFirstNameLastName("Samantha", "Black");
		EntityNamePart prefix = new EntityNamePart("Dr.", PersonNamePartType.PREFIX);
		pn.getUses().add(EntityNameUse.LEGAL);
		pn.addNamePart(prefix);

		
		Identifier id = new Identifier("2.16.840.1.113883.3.19.3.163.77.1",
		"samantha.black");
		
		authorPerson.getId().add(id);
		
		ActingPersonBean assignedPerson = new ActingPersonBean();
		assignedPerson.setAsHealthCareProviderId(healthcareProviderId);
		assignedPerson.setName(pn);
		
		authorPerson.setAssignedPerson(assignedPerson);

		authorBean.setAuthorPerson(authorPerson);

		return authorBean;
	}
	
	protected CreatedBy_1Bean createAuthor_1Bean() {
		CreatedBy_1Bean authorBean = new CreatedBy_1Bean();
		authorBean.setTime(new Date());
		
		ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean authorPerson = new ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean();
		
		Identifier healthcareProviderId = new Identifier(
				"2.16.840.1.113883.3.19.3.163.1.2", "200202888");

		PersonName pn = PersonName.createFirstNameLastName("Samantha", "Black");
		EntityNamePart prefix = new EntityNamePart("Dr.",
				PersonNamePartType.PREFIX);
		pn.getUses().add(EntityNameUse.LEGAL);
		pn.addNamePart(prefix);
		
		Identifier id = new Identifier("2.16.840.1.113883.3.19.3.163.77.1",
		"samantha.black");
		
		ActingPersonBean assignedPerson = new ActingPersonBean();
		assignedPerson.setAsHealthCareProviderId(healthcareProviderId);
		assignedPerson.setName(pn);
		
		authorPerson.setAssignedPerson(assignedPerson);

		
		authorPerson.getId().add(id);
		authorBean.setAuthorPerson(authorPerson);

		return authorBean;
	}
	
	
	// Record Target Set up
	protected Patient_2Bean createRecordTarget() {

		// Set the Patient we're querying against
		Patient_2Bean patient = new Patient_2Bean();

		// Set patient identifier(s)d
		patient.getId().add(new Identifier("2.16.840.1.113883.3.19.3.163.1", "9880897949"));

		// Set Patient Name
		PersonName patientName = PersonName.createFirstNameLastName("Cyril", "Lambert");
		EntityNamePart prefix = new EntityNamePart("Mr.", PersonNamePartType.PREFIX);
		patientName.getUses().add(EntityNameUse.LEGAL);
		patientName.addNamePart(prefix);
		
		ActingPersonBean patientPerson = new ActingPersonBean();
		patientPerson.setName(patientName);
		
		// Now set the patient's birthdate
		java.util.Date birthDate = (new GregorianCalendar(1949, java.util.Calendar.NOVEMBER, 05)).getTime();
		patientPerson.setBirthTime(birthDate);
		
		// Set Gender
		patientPerson.setAdministrativeGenderCode(AdministrativeGender.MALE);
		
		patient.setPatientPerson(patientPerson);
		
		
		// Set the address for this patient
		PostalAddress addr = new PostalAddress();

		addr.getUses().add(X_BasicPostalAddressUse.HOME);
		addr.getUses().add(X_BasicPostalAddressUse.PHYSICAL);
		addr.getUses().add(X_BasicPostalAddressUse.POSTAL);

		PostalAddressPart part = new PostalAddressPart();
		part.setType(null);
		part.setValue("1234 Main Street");
		addr.addPostalAddressPart(part);

		part = new PostalAddressPart();
		part.setType(PostalAddressPartType.CITY);
		part.setValue("Calgary");
		addr.addPostalAddressPart(part);

		part = new PostalAddressPart();
		part.setType(PostalAddressPartType.STATE);
		part.setValue("Alberta");
		addr.addPostalAddressPart(part);

		part = new PostalAddressPart();
		part.setType(PostalAddressPartType.COUNTRY);
		part.setValue("Canada");
		addr.addPostalAddressPart(part);

		patient.setAddr(addr);

		return patient;
	}		
	
	
	protected String readResourceFile(String resourceName) {
		InputStream is = getClass().getResourceAsStream(resourceName);
		String contents = null;
		try {
			contents = convertStreamToString(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;

	}
	
	
	public String convertStreamToString(InputStream is) throws  IOException {
		/*
		 * To convert the InputStream to String we use the BufferedReader.readLine()
		 * method. We iterate until the BufferedReader return null which means
		 * there's no more data to read. Each line will appended to a StringBuilder
		 * and returned as String.
		 */
		if (is != null) {
			StringBuilder sb = new StringBuilder();
			String line;

			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
			} finally {
				is.close();
			}
			return sb.toString();
		} else {       
			return null;
		}
	}

	

}
