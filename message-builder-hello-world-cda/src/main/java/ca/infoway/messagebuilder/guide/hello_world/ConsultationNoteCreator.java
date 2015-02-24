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

import java.util.Date;

import org.xml.sax.SAXException;

import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.DateInterval;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.IntervalUtil;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.OrganizationName;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.datatype.lang.util.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.util.PostalAddressPartType;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.basic.EntityNameUse;
import ca.infoway.messagebuilder.domainvalue.basic.PostalAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.TelecommunicationAddressUse;
import ca.infoway.messagebuilder.domainvalue.basic.URLScheme;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.ccda_r1_1.chiefcomplaintandreasonforvisitsection.SectionBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.consultationnote.Component2Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.consultationnote.StructuredBodyBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.domainvalue.BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.ccda_r1_1.domainvalue.ConsultDocumentType;
import ca.infoway.messagebuilder.model.ccda_r1_1.domainvalue.Language;
import ca.infoway.messagebuilder.model.ccda_r1_1.interaction.ConsultationNote;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.AssignedAuthorBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.AssignedCustodianBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Author_2Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ChiefComplaintAndReasonForVisitSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Component1_2Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.CustodianBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.CustodianOrganizationBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.EncompassingEncounter_2Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.GeneralStatusSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.HistoryOfPresentIllnessSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.InFulfillmentOfBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.OrderBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PatientBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PatientRoleBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.RecordTargetBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ConsultationNoteCreator {

	/*
	 * Note that many of these methods could be placed in a central location for reuse (if a group of Authors was always the same, they could be cached, etc.)
	 */
		
	public ConsultationNote createConsultationNoteBean() {

		// Community Health and Hospitals: Consultation Note
		// templateId 2.16.840.1.113883.10.20.22.1.4

		ConsultationNote consultationNote = new ConsultationNote();
		consultationNote.setTypeId(new Identifier("2.16.840.1.113883.1.3", "POCD_HD000040"));
		consultationNote.getTemplateId().add(new Identifier("2.16.840.1.113883.10.20.22.1.4"));
		consultationNote.setId(new Identifier("2.16.840.1.113883.19.5.99999.1", "TT988"));
		consultationNote.setCode(getLoincCode());
		consultationNote.setTitle("Community Health and Hospitals: Consultation Note");
		consultationNote.setEffectiveTime(new MbDate(DateUtil.getDate(2012, 8, 16)));
		consultationNote.setConfidentialityCode(getConfidentialityCode());
		consultationNote.setLanguageCode(getLanguageCode());
		consultationNote.getRecordTarget().add(createRecordTarget());
		consultationNote.getAuthor().add(createAuthor());
		consultationNote.setCustodian(createCustodian());
		consultationNote.getInFulfillmentOf().add(createInFulfillmentOf());
		consultationNote.setComponentOf(createComponentOf());
		consultationNote.setComponent(createComponent());
		
		return consultationNote;
	}

	// used to add more information to the document object after initially creating it
	public void addHistoryOfPresentIllness(ConsultationNote consultationNote) {
		ca.infoway.messagebuilder.model.ccda_r1_1.historyofpresentillnesssection.SectionBean historyOfPresentIllnessSection = new ca.infoway.messagebuilder.model.ccda_r1_1.historyofpresentillnesssection.SectionBean();
		historyOfPresentIllnessSection.setTitle("HISTORY OF PRESENT ILLNESS");
		historyOfPresentIllnessSection.setText(createIllnessHistoryText());
		
		HistoryOfPresentIllnessSectionComponent3Bean historyOfPresentIllness = new HistoryOfPresentIllnessSectionComponent3Bean();
		historyOfPresentIllness.setSection(historyOfPresentIllnessSection);
		
		consultationNote.getComponent().getComponent2ChoiceAsStructuredBody().getComponent().add(historyOfPresentIllness);
	}

	private EncapsulatedData createIllnessHistoryText() {
		EncapsulatedData text = new EncapsulatedData();
		try {
			text.addDocumentContentFromString("<paragraph>This patient was only recently discharged for a recurrent GI" +
					"bleed as described below.</paragraph>");
			text.addDocumentContentFromString("<paragraph>He presented to the ER today c/o a dark stool yesterday but a" +
					"normal brown stool today. On exam he was hypotensive in the 80?s" +
					"resolved after .... .... .... </paragraph>");
			text.addDocumentContentFromString("<paragraph>Lab at discharge: Glucose 112, BUN 16, creatinine 1.1," +
					"electrolytes normal. H. pylori antibody pending. Admission hematocrit" +
					"16%, discharge hematocrit 29%. WBC 7300, platelet count 256,000." +
					"Urinalysis normal. Urine culture: No growth. INR 1.1, PTT" +
					"40.</paragraph>");
			text.addDocumentContentFromString("<paragraph>He was transfused with 6 units of packed red blood cells with" +
					".... .... ....</paragraph>");
			text.addDocumentContentFromString("<paragraph>GI evaluation 12 September: Colonoscopy showed single red clot in" +
					".... .... ....</paragraph>");
		} catch (SAXException e) {
			// nothing to do here, though generally you would need to handle malformed input here
		}
		return text;
	}

	private Component2Bean createComponent() {
		StructuredBodyBean body = new StructuredBodyBean();
		body.getComponent().add(createReasonForVisit());
		body.getComponent().add(createGeneralStatus());
		
		Component2Bean component = new Component2Bean();
		component.setComponent2Choice(body);
		return component;
	}

	private GeneralStatusSectionComponent3Bean createGeneralStatus() {
		EncapsulatedData text = new EncapsulatedData();
		try {
			text.addDocumentContentFromString("<paragraph>Alert and in good spirits, no acute distress. </paragraph>");
		} catch (SAXException e) {
			// nothing to do here
		}
		
		ca.infoway.messagebuilder.model.ccda_r1_1.generalstatussection.SectionBean section = new ca.infoway.messagebuilder.model.ccda_r1_1.generalstatussection.SectionBean();
		section.setTitle("GENERAL STATUS");
		section.setText(text);
		
		GeneralStatusSectionComponent3Bean generalStatus = new GeneralStatusSectionComponent3Bean();
		generalStatus.setSection(section);
		return generalStatus;
	}

	private ChiefComplaintAndReasonForVisitSectionComponent3Bean createReasonForVisit() {
		EncapsulatedData text = new EncapsulatedData();
		try {
			text.addDocumentContentFromString("<paragraph>Dark stools.</paragraph>");
		} catch (SAXException e) {
			// nothing to do here
		}
		
		SectionBean section = new SectionBean();
		section.setTitle("REASON FOR VISIT/CHIEF COMPLAINT");
		section.setText(text);
		
		ChiefComplaintAndReasonForVisitSectionComponent3Bean reasonForVisit = new ChiefComplaintAndReasonForVisitSectionComponent3Bean();
		reasonForVisit.setSection(section);
		
		return reasonForVisit;
	}

	private Component1_2Bean createComponentOf() {
		// setting low only - currently (2015/01/28) the Schematron validation will report an error if high is provided (outside of MB's control)
		Interval<Date> interval = IntervalUtil.createInterval(DateUtil.getDate(2009, 01, 27), null);
		DateInterval dateInterval = new DateInterval(interval);
		
		EncompassingEncounter_2Bean encompassingEncounter = new EncompassingEncounter_2Bean();
		encompassingEncounter.setId(new Identifier("2.16.840.1.113883.19", "9937012"));
		encompassingEncounter.setEffectiveTime(dateInterval);		
		
		Component1_2Bean componentOf = new Component1_2Bean();
		componentOf.setEncompassingEncounter(encompassingEncounter);
		return componentOf;
	}

	private InFulfillmentOfBean createInFulfillmentOf() {
		OrderBean order = new OrderBean();
		order.getId().add(new Identifier("2.16.840.1.113883.19", "12345-67890"));
		
 		InFulfillmentOfBean inFulfillmentOf = new InFulfillmentOfBean();
		inFulfillmentOf.setOrder(order);
		
		return inFulfillmentOf;
	}

	private CustodianBean createCustodian() {
		EntityNamePart namePart = new EntityNamePart("Community Health and Hospitals");
		
		OrganizationName name = new OrganizationName();
		name.addNamePart(namePart);
		
		CustodianOrganizationBean organization = new CustodianOrganizationBean();
		organization.getId().add(new Identifier("2.16.840.1.113883.4.6", "99999999"));
		organization.setName(name);
		organization.setTelecom(createTelecom("555-555-1002", TelecommunicationAddressUse.WORKPLACE));
		organization.setAddr(createAddress("1002 Healthcare Drive", "Portland", "OR", "99123", "US"));
		
		AssignedCustodianBean assignedCustodian = new AssignedCustodianBean();
		assignedCustodian.setRepresentedCustodianOrganization(organization);
		
		CustodianBean custodian = new CustodianBean();
		custodian.setAssignedCustodian(assignedCustodian);
		
		return custodian;
	}

	private Author_2Bean createAuthor() {
		AssignedAuthorBean assignedAuthor = new AssignedAuthorBean();
		assignedAuthor.getId().add(new Identifier("2.16.840.1.113883.4.6", "99999999"));
		assignedAuthor.getAddr().add(createAddress("1002 Healthcare Drive", "Portland", "OR", "99123", "US"));
		assignedAuthor.getTelecom().add(createTelecom("555-555-1002", TelecommunicationAddressUse.WORKPLACE));
		
		Author_2Bean author = new Author_2Bean();
		author.setTime(createDate(2005, 02, 29));
		author.setAssignedAuthor(assignedAuthor);
		
		return author;
	}

	private RecordTargetBean createRecordTarget() {
		RecordTargetBean recordTargetBean = new RecordTargetBean();
		recordTargetBean.setPatientRole(createPatientRole());
		return recordTargetBean;
	}

	private PatientRoleBean createPatientRole() {
		PatientRoleBean patientRole = new PatientRoleBean();
		patientRole.getId().add(new Identifier("2.16.840.1.113883.19.5.99999.2", "998991"));
		patientRole.getAddr().add(createAddress("1357 Amber Drive", "Beaverton", "OR", "97867", "US"));
		patientRole.getTelecom().add(createTelecom("(816)276-6909", TelecommunicationAddressUse.PRIMARY_HOME));
		patientRole.setPatient(createPatient());
		return patientRole;
	}

	private PatientBean createPatient() {
		PatientBean patient = new PatientBean();
		patient.getName().add(createName());
		patient.setAdministrativeGenderCode(new CodedTypeR2<AdministrativeGender>(ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender.FEMALE));
		patient.setBirthTime(createDate(2005, 4, 1));
		return patient;
	}

	private MbDate createDate(int year, int month, int day) {
		return new MbDate(new DateWithPattern(DateUtil.getDate(year, month, day), "yyyyMMdd"));
	}

	private PersonName createName() {
		PersonName name = new PersonName();
		name.getParts().add(new EntityNamePart("Isabella", PersonNamePartType.GIVEN));
		name.getParts().add(new EntityNamePart("Isa", PersonNamePartType.GIVEN));
		name.getParts().add(new EntityNamePart("Jones", PersonNamePartType.FAMILY));
		name.getUses().add(EntityNameUse.LEGAL);
		return name;
	}

	private TelecommunicationAddress createTelecom(String number, TelecommunicationAddressUse use) {
		return new TelecommunicationAddress(URLScheme.TEL, number, use);
	}

	private PostalAddress createAddress(String streetAddress, String city, String state, String postalCode, String country) {
		PostalAddress address = new PostalAddress();
		address.getUses().add(PostalAddressUse.PRIMARY_HOME);
		address.getParts().add(new PostalAddressPart(PostalAddressPartType.STREET_ADDRESS_LINE, streetAddress));
		address.getParts().add(new PostalAddressPart(PostalAddressPartType.CITY, city));
		address.getParts().add(new PostalAddressPart(PostalAddressPartType.STATE, state));
		address.getParts().add(new PostalAddressPart(PostalAddressPartType.POSTAL_CODE, postalCode));
		address.getParts().add(new PostalAddressPart(PostalAddressPartType.COUNTRY, country));
		return address;
	}

	private CodedTypeR2<Language> getLanguageCode() {
		Language code = CodeResolverRegistry.lookup(Language.class, "en-US");
		return new CodedTypeR2<Language>(code);
	}

	private CodedTypeR2<BasicConfidentialityKind> getConfidentialityCode() {
		BasicConfidentialityKind code = CodeResolverRegistry.lookup(BasicConfidentialityKind.class, "11488-4", "2.16.840.1.113883.6.1");
		return new CodedTypeR2<BasicConfidentialityKind>(code);
	}

	private CodedTypeR2<ConsultDocumentType> getLoincCode() {
		ConsultDocumentType code = CodeResolverRegistry.lookup(ConsultDocumentType.class, "11488-4", "2.16.840.1.113883.6.1");
		
		CodedTypeR2<ConsultDocumentType> loincCode = new CodedTypeR2<ConsultDocumentType>();
		loincCode.setCode(code);
		loincCode.setCodeSystemName("LOINC");
		loincCode.setDisplayName("ConsultationNote");
		
		return loincCode;
	}

}
