package ca.infoway.messagebuilder.model.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.Confidentiality;
import ca.infoway.messagebuilder.model.AssignedPersonBeanBuilder;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.NoteBeanBuilder;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBeanBuilder;

public class MedicationDispenseBeanBuilder extends BaseBeanBuilder<MedicationDispenseBean> {

	public MedicationDispenseBeanBuilder() {
		super(new MedicationDispenseBean());
	}

	public MedicationDispenseBeanBuilder populate() {
		this.bean.setId(new Identifier("1.2.3", "4"));
		this.bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		this.bean.setConfidentialityCode(lookup(Confidentiality.class, "N", CodeSystem.VOCABULARY_CONFIDENTIALITY.getRoot()));
		this.bean.setPerformer(new AssignedPersonBeanBuilder().populate().create());
		this.bean.setLocation(new ServiceDeliveryLocationBeanBuilder().populate().create());
		this.bean.setSupplyEvent(new SupplyEventBeanBuilder().populateMedication().create());
		this.bean.setAdministrationInstructions("administration instructions");
		this.bean.setSubstanceAdministrationRequest(new SubstanceAdministrationRequestBeanBuilder().populate().create());
		this.bean.setDetectedIssueIndicator(true);
		this.bean.setAnnotationIndicator(true);
		
		this.bean.setSubstitutionMade(new SubstitutionMadeBeanBuilder().populate().create());
		this.bean.getNotes().add(new NoteBeanBuilder().populate().create());
		this.bean.getNotes().add(new NoteBeanBuilder().populate().create());
		this.bean.getDosageInstructions().add(new DosageInstructionBeanBuilder().populate().create());
		this.bean.getDosageInstructions().add(new DosageInstructionBeanBuilder().populate().create());
		this.bean.setResponsibleParty(new AssignedPersonBeanBuilder().populate().create());
		this.bean.getDispenseHistoryRecords().add(new HistoricalControlActEventBeanBuilder().withTriggerEventCode("PORX_TE020170UV").populate().create());
		this.bean.getDispenseHistoryRecords().add(new HistoricalControlActEventBeanBuilder().withTriggerEventCode("PORX_TE020170UV").populate().create());
		this.bean.getDispenseHistoryRecords().add(new HistoricalControlActEventBeanBuilder().withTriggerEventCode("PORX_TE020170UV").populate().create());
		this.bean.getDetectedIssues().add(new DetectedIssueBeanBuilder().populate().create());
		this.bean.getDetectedIssues().add(new DetectedIssueBeanBuilder().populate().create());
		return this;
	}

}
