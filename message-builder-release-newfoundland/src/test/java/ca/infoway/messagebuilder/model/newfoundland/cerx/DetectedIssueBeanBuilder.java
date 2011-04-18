package ca.infoway.messagebuilder.model.newfoundland.cerx;

import static ca.infoway.messagebuilder.resolver.CodeResolverRegistry.lookup;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.newfoundland.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.SeverityObservationBeanBuilder;

public class DetectedIssueBeanBuilder extends BaseBeanBuilder<DetectedIssueBean> {

	public DetectedIssueBeanBuilder() {
		super(new DetectedIssueBean());
	}

	public DetectedIssueBeanBuilder populate() {
		this.bean.setCode(lookup(ActDetectedIssueCode.class, "VALIDAT", CodeSystem.VOCABULARY_ACT_CODE.getRoot()));
		this.bean.setPriorityCode(lookup(ActIssuePriority.class, "W", CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_DETAIL_TYPE.getRoot()));
		this.bean.setText("some detected issue text");
		this.bean.setSeverityObservation(new SeverityObservationBeanBuilder().populate().create());
		
		this.bean.getCausalActs().add(new SupplyEventBeanBuilder().populateMedication().create());
		this.bean.getCausalActs().add(new SubstanceAdministrationBeanBuilder().populatePrescription().create()); // prescription
		this.bean.getCausalActs().add(new SubstanceAdministrationBeanBuilder().populate().create()); // otherSupply
//		this.bean.getIssueCausedBy();
//		this.bean.getIssueDescription();
		this.bean.getIssueManagements().add(new DetectedIssueManagementBeanBuilder().populate().create());
		this.bean.setStatusCode(lookup(ActStatus.class, "active", CodeSystem.VOCABULARY_ACT_STATUS.getRoot()));
		return this;
	}

}
