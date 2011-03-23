package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.util.Calendar;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActUncertainty;
import ca.infoway.messagebuilder.domainvalue.AllergyTestValue;
import ca.infoway.messagebuilder.domainvalue.ExposureAgentEntityType;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.domainvalue.IntoleranceValue;
import ca.infoway.messagebuilder.domainvalue.ObservationAllergyTestType;
import ca.infoway.messagebuilder.domainvalue.ObservationIntoleranceType;
import ca.infoway.messagebuilder.domainvalue.ObservationValue;
import ca.infoway.messagebuilder.domainvalue.RouteOfAdministration;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.domainvalue.SubjectReaction;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.j5goodies.DateUtil;
import ca.infoway.messagebuilder.model.AssignedPersonBean;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.NoteBean;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.CausalityAssessmentBean;
import ca.infoway.messagebuilder.model.cerx.HistoricalControlActEventBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.ObservationEventBean;
import ca.infoway.messagebuilder.model.cerx.allergy.AllergyIntoleranceBean;
import ca.infoway.messagebuilder.model.cerx.allergy.AllergyIntoleranceWithHistoryBean;
import ca.infoway.messagebuilder.model.cerx.allergy.AllergyTestEventBean;

public class AllergyIntoleranceTestBeanBuilder {

	public AllergyIntoleranceBean build() {
		AllergyIntoleranceBean allergy = new AllergyIntoleranceBean();
		populateAllergyIntoleranceBean(allergy);
		return allergy;
	}

	public AllergyIntoleranceWithHistoryBean buildWithHistory(int numHistorical) {
		AllergyIntoleranceWithHistoryBean allergyOld = null;
		AllergyIntoleranceWithHistoryBean allergyNew = null;
		
		for (int i = 0; i <= numHistorical; i++) {
			allergyNew = new AllergyIntoleranceWithHistoryBean();
			populateHistoryBean(allergyNew);
			populateAllergyIntoleranceBean(allergyNew);
			if (allergyOld != null) {
				allergyNew.setReplacementOf(allergyOld);
			}
			allergyOld = allergyNew;
		}
		
		return allergyNew;
	}
	
	private void populateHistoryBean(AllergyIntoleranceWithHistoryBean allergyWithHistory) {
//		historicalControlActEventBean1.setCode(CodeResolverRegistry.lookup(HL7TriggerEventCode.class, "REPC_TE000009UV", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		allergyWithHistory.getControlActEvent().add(new HistoricalControlActEventBeanBuilder().populate().create());
	}

	/*
	 * A number of transformation tests depend on the values below. Please change carefully...
	 */
	private void populateAllergyIntoleranceBean(AllergyIntoleranceBean allergy) {
		allergy.setId(new Identifier("2.16.840.1.113883.1.13", "7"));
		
		allergy.getPatient().setId(new Identifier("2.16.840.1.113883.1.133", "9283488"));
		allergy.getPatient().getIndeterminatePerson().setAdministrativeGenderCode(AdministrativeGender.FEMALE);
		allergy.getPatient().getIndeterminatePerson().setName(PersonName.createFirstNameLastName("Mabel", "Hauptman"));
		allergy.getPatient().getIndeterminatePerson().setBirthTime(DateUtil.getDate(1932, Calendar.DECEMBER, 28));
		
		allergy.setStatus(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		allergy.setCode(lookup(ObservationIntoleranceType.class, "OINT", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		allergy.getConfidentiality().add(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		allergy.setSeverityObservation(lookup(SeverityObservation.class, "H", CodeSystem.VOCABULARY_SEVERITY_OBSERVATION.getRoot()));
		allergy.setEffectiveTime(DateUtil.getDate(2009, 3, 22));
		allergy.setNegationInd(Boolean.TRUE);
		allergy.setUncertainty(lookup(ActUncertainty.class, "N", CodeSystem.VOCABULARY_ACT_UNCERTAINTY.getRoot()));
		allergy.setValue(lookup(IntoleranceValue.class, "NDA02", CodeSystem.VOCABULARY_ENTITY_CODE.getRoot()));
		
		allergy.getAllergyRecords().add(createAllergyTestEvent());
		allergy.getAllergyRecords().add(createAssessment());
		
		AssignedPersonBean assignedPersonBean = new AssignedPersonBean();
		assignedPersonBean.setId(new Identifier("2.16.840.1.113883.1.133", "665544"));
		assignedPersonBean.setName(PersonName.createFirstNameLastName("George", "Jungle"));
		
		allergy.setInformant(assignedPersonBean);
		allergy.setInformantTime(DateUtil.getDate(1999, Calendar.DECEMBER, 28));
		
		allergy.getNotes().add(createNote());
		
		allergy.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		allergy.setAuthor(new AuthorBeanBuilder().populate().create());
	}
	
	private AllergyTestEventBean createAllergyTestEvent() {
		AllergyTestEventBean allergyTestEvent = new AllergyTestEventBean();
		allergyTestEvent.setId(new Identifier("2.16.840.1.113883.1.13", "995"));
		allergyTestEvent.setCode(lookup(ObservationAllergyTestType.class, "10921-5", CodeSystem.LOINC.getRoot()));
		allergyTestEvent.setValue(lookup(AllergyTestValue.class, "A3", CodeSystem.VOCABULARY_ALLERGY_TEST_VALUE.getRoot()));
		allergyTestEvent.setEffectiveTime(DateUtil.getDate(2009, 3, 10));
		return allergyTestEvent;
	}
	
	private CausalityAssessmentBean createAssessment() {
		CausalityAssessmentBean assessment = new CausalityAssessmentBean();
		assessment.setId(new Identifier("2.16.840.1.113883.1.133", "12"));
		assessment.setCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		assessment.setObservationValue(lookup(ObservationValue.class, "371627004", CodeSystem.SNOMED.getRoot()));
		assessment.setRouteCode(lookup(RouteOfAdministration.class, "CHEW", CodeSystem.VOCABULARY_ROUTE_OF_ADMINISTRATION.getRoot()));
		assessment.setMaterialCode(lookup(ExposureAgentEntityType.class, "NDA05", CodeSystem.VOCABULARY_ENTITY_CODE.getRoot()));
		assessment.setName("a name");  // not used for this message
		assessment.setObservationEventBean(createObservationEventBean());
		return assessment;
	}
	
	private ObservationEventBean createObservationEventBean() {
		ObservationEventBean observationEventBean = new ObservationEventBean();
		observationEventBean.setCode(lookup(ActCode.class, "DX", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		observationEventBean.setEffectiveTime(IntervalFactory.createLow(DateUtil.getDate(2008, 3, 17)));
		observationEventBean.setId(new Identifier("2.16.840.1.113883.1.133", "1456"));
		observationEventBean.setNegationInd(true);
		observationEventBean.setSeverityObservation(lookup(SeverityObservation.class, "H", CodeSystem.VOCABULARY_SEVERITY_OBSERVATION.getRoot()));
		observationEventBean.setText("text goes here");
		observationEventBean.setValue(lookup(SubjectReaction.class, "Y45.1", CodeSystem.ICD10.getRoot()));
		return observationEventBean;
	}
	
	private NoteBean createNote() {
		NoteBean noteBean = new NoteBean(); 
		noteBean.setText("condition note");
		noteBean.setLanguageCode(lookup(HumanLanguage.class, "en", CodeSystem.VOCABULARY_HUMAN_LANGUAGE.getRoot()));
		noteBean.getAuthor().setId(new Identifier("2.16.840.1.113883.1.133", "112233"));
		noteBean.getAuthor().setLicenseNumber(new Identifier("2.16.840.1.113883.1.133", "332211"));
		noteBean.getAuthor().setTime(DateUtil.getDate(2008, 8, 20));
		noteBean.getAuthor().setName(new PersonName());
		noteBean.getAuthor().getName().addNamePart(new EntityNamePart("Michelle", PersonNamePartType.GIVEN));
		noteBean.getAuthor().getName().addNamePart(new EntityNamePart("Obama", PersonNamePartType.FAMILY));
		return noteBean;
	}
	
}
