package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;

import java.math.BigDecimal;
import java.util.Date;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.IntervalFactory;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdministrationCode;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.domainvalue.x_DrugUnitsOfMeasure;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;

public class SubstanceAdministrationBeanBuilder extends BaseBeanBuilder<SubstanceAdministrationBean> {

	public SubstanceAdministrationBeanBuilder() {
		super(new SubstanceAdministrationBean());
	}

	public SubstanceAdministrationBeanBuilder populate() {
		this.bean.setActiveMedicationDoseQuantity(
				new PhysicalQuantity(
						new BigDecimal(250), 
						lookup(x_DrugUnitsOfMeasure.class, "g", CodeSystem.VOCABULARY_UNIFORM_UNIT_OF_MEASURE.getRoot())));
		this.bean.setActiveMedicationStatus(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		this.bean.setActiveMedicationTimeRange(IntervalFactory.createLow(new Date(0)));
		this.bean.setAdministrationType(lookup(ActSubstanceAdministrationCode.class, "DRUG", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		this.bean.setId(new Identifier("1.2.3", "extension"));
		this.bean.setMedication(new MedicineBeanBuilder().populate().create());
		this.bean.setOtherMedicationIndicator(lookup(x_ActMoodOrderEvent.class, "EVN", CodeSystem.VOCABULARY_ACT_MOOD.getRoot()));
		return this;
	}

	public SubstanceAdministrationBeanBuilder populatePrescription() {
		populate();
		this.bean.setOtherMedicationIndicator(lookup(x_ActMoodOrderEvent.class, "RQO", CodeSystem.VOCABULARY_ACT_MOOD.getRoot()));
		return this;
	}
	
}
