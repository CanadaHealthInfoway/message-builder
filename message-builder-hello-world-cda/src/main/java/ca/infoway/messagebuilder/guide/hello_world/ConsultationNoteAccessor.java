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
import java.util.List;

import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.MbDate;
import ca.infoway.messagebuilder.datatype.lang.NameFormatter;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.PostalAddressPart;
import ca.infoway.messagebuilder.datatype.lang.util.DateWithPattern;
import ca.infoway.messagebuilder.model.ccda_r1_1.allergiessectionentriesoptional.SectionBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.basemodel.NonXMLBodyBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.consultationnote.Component2Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.consultationnote.Component3Choice;
import ca.infoway.messagebuilder.model.ccda_r1_1.consultationnote.ConsultationNote;
import ca.infoway.messagebuilder.model.ccda_r1_1.consultationnote.ReasonForReferralSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.consultationnote.StructuredBodyBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.AllergiesSectionentriesOptionalComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.AllergiesSectionentriesRequiredComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.AssessmentAndPlanSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.AssessmentSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.Author_2Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ChiefComplaintAndReasonForVisitSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ChiefComplaintSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.FamilyHistorySectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.GeneralStatusSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.HistoryOfPastIllnessSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.HistoryOfPresentIllnessSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ImmunizationsSectionentriesOptionalComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ImmunizationsSectionentriesRequiredComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.MedicationsSectionentriesOptionalComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.MedicationsSectionentriesRequiredComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PatientBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PatientRoleBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PhysicalExamSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PlanOfCareSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ProblemSectionentriesOptionalComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ProblemSectionentriesRequiredComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ProceduresSectionentriesOptionalComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ProceduresSectionentriesRequiredComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ReasonForVisitSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ResultsSectionentriesOptionalComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ResultsSectionentriesRequiredComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.ReviewOfSystemsSectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.SocialHistorySectionComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.VitalSignsSectionentriesOptionalComponent3Bean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.VitalSignsSectionentriesRequiredComponent3Bean;
import ca.infoway.messagebuilder.platform.DateFormatUtil;


public class ConsultationNoteAccessor {

	/*
	 * This class shows how to walk through a MB CDA Document object (ConsultationNote, in this case) and
	 * access various fields. 
	 * 
	 */
	
	public void processConsultationNote(ConsultationNote consultationNote) {
		System.out.println("\n\nWriting out various values from ConsultationNote objects:\n");
		
		System.out.println("Title: " + consultationNote.getTitle());
		System.out.println("Template Id: " + consultationNote.getTemplateId());
		renderAuthor(consultationNote.getAuthor().isEmpty() ? null : consultationNote.getAuthor().get(0));
		renderPatient(consultationNote.getRecordTarget().isEmpty() ? null : consultationNote.getRecordTarget().get(0).getPatientRole());
		
		renderSections(consultationNote);
		
	}

	private void renderSections(ConsultationNote consultationNote) {
		if (consultationNote.getComponent() != null) {
			Component2Bean component = consultationNote.getComponent();
			if (component.hasComponent2ChoiceAsNonXMLBody()) {
				// not much to render in this case
				NonXMLBodyBean nonXmlBody = component.getComponent2ChoiceAsNonXMLBody();
				System.out.println("Non-XML Body Text: ");
				renderText(nonXmlBody.getText());
			} else if (component.hasComponent2ChoiceAsStructuredBody()) {
				StructuredBodyBean structuredBody = component.getComponent2ChoiceAsStructuredBody();
				for (Component3Choice section : structuredBody.getComponent()) {
					renderSection(section);
				}
			}
		}
		
	}

	private void renderSection(Component3Choice section) {
		// At some point in every CDA document we get to this...
		// We have a section that could one of any number of section types (in this case one of 28 sections(!)).
		// There is no "good" way to model this that would allow us to avoid having to query each section to see what it is.
		// Fortunately, MB can *usually* merge many similar sections into a single model class, so in many cases this code can be reused for some/all document types.
		
		if (section instanceof AllergiesSectionentriesOptionalComponent3Bean) {
			AllergiesSectionentriesOptionalComponent3Bean optionalAllergies = (AllergiesSectionentriesOptionalComponent3Bean) section;
			SectionBean allergies = optionalAllergies.getSection();
			processOptionalAlergies(allergies);
			
		} else if (section instanceof AllergiesSectionentriesRequiredComponent3Bean) {
			// no required allergies section for this sample CDA document
			AllergiesSectionentriesRequiredComponent3Bean optionalAllergies = (AllergiesSectionentriesRequiredComponent3Bean) section;
			ca.infoway.messagebuilder.model.ccda_r1_1.allergiessectionentriesrequired.SectionBean allergies = optionalAllergies.getSection();
			processRequiredAlergies(allergies);
			
		} else if (section instanceof AssessmentAndPlanSectionComponent3Bean) {
			// etc.
			
		} else if (section instanceof AssessmentSectionComponent3Bean) {
		} else if (section instanceof ChiefComplaintAndReasonForVisitSectionComponent3Bean) {
		} else if (section instanceof ChiefComplaintSectionComponent3Bean) {
			
		} else if (section instanceof FamilyHistorySectionComponent3Bean) {
			FamilyHistorySectionComponent3Bean familyHistoryBean = (FamilyHistorySectionComponent3Bean) section;
			ca.infoway.messagebuilder.model.ccda_r1_1.familyhistorysection.SectionBean familyHistory = familyHistoryBean.getSection();
			processFamilyHistory(familyHistory);
			
		} else if (section instanceof GeneralStatusSectionComponent3Bean) {
		} else if (section instanceof HistoryOfPastIllnessSectionComponent3Bean) {
		} else if (section instanceof HistoryOfPresentIllnessSectionComponent3Bean) {
		} else if (section instanceof ImmunizationsSectionentriesOptionalComponent3Bean) {
		} else if (section instanceof ImmunizationsSectionentriesRequiredComponent3Bean) {
		} else if (section instanceof MedicationsSectionentriesOptionalComponent3Bean) {
		} else if (section instanceof MedicationsSectionentriesRequiredComponent3Bean) {
		} else if (section instanceof PhysicalExamSectionComponent3Bean) {
		} else if (section instanceof PlanOfCareSectionComponent3Bean) {
		} else if (section instanceof ProblemSectionentriesOptionalComponent3Bean) {
		} else if (section instanceof ProblemSectionentriesRequiredComponent3Bean) {
		} else if (section instanceof ProceduresSectionentriesOptionalComponent3Bean) {
		} else if (section instanceof ProceduresSectionentriesRequiredComponent3Bean) {
		} else if (section instanceof ReasonForReferralSectionComponent3Bean) {
		} else if (section instanceof ReasonForVisitSectionComponent3Bean) {
		} else if (section instanceof ResultsSectionentriesOptionalComponent3Bean) {
		} else if (section instanceof ResultsSectionentriesRequiredComponent3Bean) {
		} else if (section instanceof ReviewOfSystemsSectionComponent3Bean) {
		} else if (section instanceof SocialHistorySectionComponent3Bean) {
		} else if (section instanceof VitalSignsSectionentriesOptionalComponent3Bean) {
		} else if (section instanceof VitalSignsSectionentriesRequiredComponent3Bean) {
		} else {
			if (section != null) { 
				System.out.println("Unexpected section type encountered: " + section.getClass());
			}
		}
		
	}

	private void processFamilyHistory(
			ca.infoway.messagebuilder.model.ccda_r1_1.familyhistorysection.SectionBean familyHistory) {
		System.out.println(familyHistory.getTitle());
		System.out.println("Text: ");
		renderText(familyHistory.getText());
		
	}

	private void processRequiredAlergies(
			ca.infoway.messagebuilder.model.ccda_r1_1.allergiessectionentriesrequired.SectionBean allergies) {
		// TODO fill in as appropriate
		
	}

	private void processOptionalAlergies(SectionBean allergies) {
		System.out.println(allergies.getTitle());
		System.out.println("Text: ");
		renderText(allergies.getText());
	}

	private void renderAuthor(Author_2Bean author_2Bean) {
		if (author_2Bean == null) return;
		
		List<Identifier> ids = author_2Bean.getAssignedAuthor().getId();
		System.out.println("Author id: " + (ids.isEmpty() ? "(none)" : ids.get(0)));
		
		List<PostalAddress> addrs = author_2Bean.getAssignedAuthor().getAddr();
		System.out.println("Author address: " + (addrs.isEmpty() ? "(none)" : renderAddress(addrs.get(0))));
	}

	private void renderPatient(PatientRoleBean patientRoleBean) {
		if (patientRoleBean == null) return;
		
		PatientBean patient = patientRoleBean.getPatient();
		if (patient != null) {
			System.out.println("Patient Name: " + (patient.getName().isEmpty() ? "(none)" : renderName(patient.getName().get(0))));
			System.out.println("Patient Birth Date: " + (patient.getName().isEmpty() ? "(none)" : renderDate(patient.getBirthTime())));
		}
	}

	private void renderText(EncapsulatedData text) {
		if (text == null) {
			System.out.println("(none)");
		} else {
			System.out.println(text.getContent());
		}
	}

	private String renderName(PersonName personName) {
		return NameFormatter.getSimpleNameFormatter().format(personName);
	}

	private String renderDate(MbDate birthTime) {
		String result = "";
		if (birthTime != null && birthTime.getValue() != null) {
			Date date = birthTime.getValue();
			String dateFormat = "yyyyMMdd hh:mm:ss";
			if (date instanceof DateWithPattern) {
				dateFormat = ((DateWithPattern) date).getDatePattern();
			}
			result = DateFormatUtil.format(date, dateFormat);
		}
		return result;
	}

	private String renderAddress(PostalAddress postalAddress) {
		String result = "";
		if (postalAddress != null) {
			for (PostalAddressPart postalAddressPart : postalAddress.getParts()) {
				result += (" " + postalAddressPart.getValue());
			}
		}
		return result;
	}
	
}
