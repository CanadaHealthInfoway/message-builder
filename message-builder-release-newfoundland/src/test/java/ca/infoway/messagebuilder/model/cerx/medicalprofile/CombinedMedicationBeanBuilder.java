package ca.infoway.messagebuilder.model.cerx.medicalprofile;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.AuthorBeanBuilder;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.IdentifiedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.DetectedIssueBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.DispenseInstructionsBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.DosageInstructionBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.MedicationDispenseBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.MedicineBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.QuantityObservationEventBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.RefusalToFillBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.SubstitutionPermissionBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.deviceprescription.ReasonBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CombinedMedication1Bean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CombinedMedication2Bean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CombinedMedication3Bean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CombinedMedicationBaseBean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.CombinedMedicationInnerBaseBean;
import ca.infoway.messagebuilder.model.cerx.medicationprofile.DerivedFromBean;

public class CombinedMedicationBeanBuilder extends BaseBeanBuilder<CombinedMedicationBaseBean> {
	
	private final CombinedMedicationBeanType type;

	public enum CombinedMedicationBeanType {
		PORX_MT010120CA,PORX_MT060160CA,PORX_MT060340CA
	}
	
	public CombinedMedicationBeanBuilder(CombinedMedicationBeanType type) {
		super(createBean(type));
		this.type = type;
	}

	private static CombinedMedicationBaseBean createBean(CombinedMedicationBeanType type) {
		switch (type) {
			case PORX_MT010120CA:
				return new CombinedMedication1Bean();
			case PORX_MT060160CA:
				return new CombinedMedication2Bean();
			case PORX_MT060340CA:
				return new CombinedMedication3Bean();
		}
		throw new IllegalStateException("CombinedMedicationBean type not recognized");
	}

	public CombinedMedicationBeanBuilder populate() {
		this.bean.setAuthor(new AuthorBeanBuilder().populate().create());
		this.bean.setCode(lookup(ActCode.class, "DRUG", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setConfidentialityCode(lookup(x_VeryBasicConfidentialityKind.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		this.bean.getCoverages().add(new CoverageBeanBuilder().populate().create());
		this.bean.setDerivedFrom(new DerivedFromBean());
		this.bean.setId(new Identifier("1.2.3", "extension-1"));
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setMedication(new MedicineBeanBuilder().populate().create());
		this.bean.setPatient(new IdentifiedPersonBeanBuilder().populate().create());		
		this.bean.setPredecessorId(new Identifier("predecessor-root", "ext"));
		this.bean.setStatusCode(lookup(ActStatus.class, "normal", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		this.bean.setSupplyEventFirstSummary(new SupplySummaryBeanBuilder().populate().create());
		this.bean.setSupplyEventLastSummary(new SupplySummaryBeanBuilder().populate().create());
		this.bean.setSupplyEventPastSummary(new CumulativeSupplySummaryBeanBuilder().populate().create());
		this.bean.setSupplyEventFutureSummary(new CumulativeSupplySummaryBeanBuilder().populate().create());
		// SPD: this bean uses a significantly different supply request (not like the bean created by the builder below)
		// this.bean.setSupplyRequest(new SupplyRequestBeanBuilder().populate().create());
		this.bean.setEligibleForTrial(true);
		
		this.bean.getMedicationDispenses().add(new MedicationDispenseBeanBuilder().populate().create());
		this.bean.getDosageInstructions().add(new DosageInstructionBeanBuilder().populate().create());
		this.bean.getReasons().add(new ReasonBeanBuilder().populate().create());
		this.bean.setSupplyRequest(new DispenseInstructionsBeanBuilder().populate().create());
		this.bean.setWorkingListCode(lookup(ActTherapyDurationWorkingListCode.class, "ACU", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		
		this.bean.getQuantityObservationEvents().add(new QuantityObservationEventBeanBuilder().populate().create());
		this.bean.getQuantityObservationEvents().add(new QuantityObservationEventBeanBuilder().populate().create());

		switch(this.type) {
			case PORX_MT010120CA:
				((CombinedMedication1Bean) this.bean).getAnnotations().add(new NoteBeanBuilder().populate().create());
				((CombinedMedication1Bean) this.bean).setSubstitutionPermission(new SubstitutionPermissionBeanBuilder().populate().create());
				break;
			case PORX_MT060160CA:
			case PORX_MT060340CA:
				((CombinedMedicationInnerBaseBean) this.bean).setAnnotationIndicator(true);
				((CombinedMedicationInnerBaseBean) this.bean).getAnnotations().add(new NoteBeanBuilder().populate().create());
				((CombinedMedicationInnerBaseBean) this.bean).setDetectedIssueIndicator(true);
				((CombinedMedicationInnerBaseBean) this.bean).getDetectedIssues().add(new DetectedIssueBeanBuilder().populate().create());
				((CombinedMedicationInnerBaseBean) this.bean).setSubstitutionPermission(new SubstitutionPermissionBeanBuilder().populate().create());
				((CombinedMedicationInnerBaseBean) this.bean).getRefusalToFills().add(new RefusalToFillBeanBuilder().populate().create());
				break;
		}
		
		return this;
	}

}
