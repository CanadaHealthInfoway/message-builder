package ca.infoway.messagebuilder.marshalling.cerx.v01r04_3;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.EntityNamePart;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PersonNamePartType;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.CommonClinicalObservationType;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.UnitsOfMeasureCaseSensitive;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.payload.AdministrativeGender;
import ca.infoway.messagebuilder.domainvalue.payload.Confidentiality;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.observation.ObservationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.observation.ObservationValueBean;

public class ObservationTestBeanBuilder {

	protected ObservationBean buildObservationBeanWithOneValue() {
		ObservationBean observation = createBasicObservationBean();
		observation.setType(lookup(CommonClinicalObservationType.class, "3137-7", CodeSystem.LOINC.getRoot()));
		observation.setValuePhysicalQuantity(new PhysicalQuantity(BigDecimal.ONE, lookup(x_DrugUnitsOfMeasure.class, "mg", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot())));
		observation.setAuthor(new AuthorBeanBuilder().populate().create());
		
		return observation;
	}

	protected ObservationBean buildObservationBeanWithTwoValues() {
		ObservationBean observation = createBasicObservationBean();
		observation.setValues(new ArrayList<ObservationValueBean>());
		observation.getValues().add(createObservationValue(
				lookup(CommonClinicalObservationType.class, "3138-5", CodeSystem.LOINC.getRoot()),
				new PhysicalQuantity(BigDecimal.ONE, lookup(UnitsOfMeasureCaseSensitive.class, "bar"))));
		observation.getValues().add(createObservationValue(
				lookup(CommonClinicalObservationType.class, "11377-9", CodeSystem.LOINC.getRoot()),
				new PhysicalQuantity(BigDecimal.ONE, lookup(UnitsOfMeasureCaseSensitive.class, "bar"))));
		observation.setAuthor(new AuthorBeanBuilder().populate().create());
		observation.setType(lookup(CommonClinicalObservationType.class, "3137-7", CodeSystem.LOINC.getRoot()));
		return observation;
	}
	
	private ObservationBean createBasicObservationBean() {
		ObservationBean observationBean = new ObservationBean();
		observationBean.setId(new Identifier("1.2.3.4.5.6", "11.22.33"));
		observationBean.setEffectiveTime(new GregorianCalendar(2008, Calendar.DECEMBER, 12, 15, 30, 22).getTime());
		observationBean.setConfidentiality(Confidentiality.NORMAL);
		observationBean.setPatient(createPatient());
		observationBean.setResponsibleParty(createResponsibleParty());
		observationBean.setLocation(createLocationBean());
		observationBean.getNotes().add(createNoteBean());
		return observationBean;
	}

	private ServiceDeliveryLocationBean createLocationBean() {
		ServiceDeliveryLocationBean locationBean = new ServiceDeliveryLocationBean();
		locationBean.setIdentifier(new Identifier("1.2.3.4", "4"));
		locationBean.setName("intelliware's Pharmacy");
		return locationBean;
	}

	private AssignedPersonBean createResponsibleParty() {
		AssignedPersonBean assignedPersonBean = new AssignedPersonBean();
		assignedPersonBean.setId(new Identifier("3.16.840.1.113883.1.133", "223344"));
		assignedPersonBean.setName(new PersonName());
		assignedPersonBean.getName().addNamePart(new EntityNamePart("Laura", PersonNamePartType.GIVEN));
		assignedPersonBean.getName().addNamePart(new EntityNamePart("Bush", PersonNamePartType.FAMILY));
		assignedPersonBean.setLicenseNumber(new Identifier("3.21.456.1.113883.1.133", "445566"));
		assignedPersonBean.setCode(lookup(HealthcareProviderRoleType.class, "ACP", CodeSystem.VOCABULARY_ROLE_CODE.getRoot()));
		return assignedPersonBean;
	}

	private IdentifiedPersonBean createPatient() {
		IdentifiedPersonBean personBean = new IdentifiedPersonBean();
		personBean.setId(new Identifier("1.2.49472.29.34.1", "patientId"));
		personBean.getIndeterminatePerson().setAdministrativeGenderCode(AdministrativeGender.FEMALE);
		personBean.getIndeterminatePerson().setName(new PersonName());
		personBean.getIndeterminatePerson().getName().addNamePart(new EntityNamePart("Michelle", PersonNamePartType.GIVEN));
		personBean.getIndeterminatePerson().getName().addNamePart(new EntityNamePart("Obama", PersonNamePartType.FAMILY));
		personBean.getIndeterminatePerson().setBirthTime(new GregorianCalendar(1964, Calendar.JANUARY, 17).getTime());
		return personBean;
	}

	private NoteBean createNoteBean() {
		NoteBean note = new NoteBean();
		note.setText("super note");
		note.getAuthor().setTime(new GregorianCalendar(2008, Calendar.DECEMBER, 12, 15, 30, 22).getTime());
		note.getAuthor().setName(new PersonName());
		note.getAuthor().getName().addNamePart(new EntityNamePart("Michelle", PersonNamePartType.GIVEN));
		note.getAuthor().getName().addNamePart(new EntityNamePart("Obama", PersonNamePartType.FAMILY));
		return note;
	}
	
	private ObservationValueBean createObservationValue(CommonClinicalObservationType type, PhysicalQuantity value) {
		ObservationValueBean valueBean = new ObservationValueBean();
		valueBean.setType(type);
		valueBean.setValue(value);
		return valueBean;
	}
	
}
