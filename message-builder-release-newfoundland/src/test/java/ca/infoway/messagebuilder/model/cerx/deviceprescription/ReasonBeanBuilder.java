package ca.infoway.messagebuilder.model.cerx.deviceprescription;

import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.model.BaseBeanBuilder;
import ca.infoway.messagebuilder.model.cerx.ObservationDiagnosisBean;
import ca.infoway.messagebuilder.model.cerx.ReasonBean;
import ca.infoway.messagebuilder.resolver.CodeResolverRegistry;

public class ReasonBeanBuilder extends BaseBeanBuilder<ReasonBean> {

	public ReasonBeanBuilder() {
		super(new ReasonBean());
	}

	public ReasonBeanBuilder populate() {
		ObservationDiagnosisBean indication = new ObservationDiagnosisBean();
		indication.setCode(CodeResolverRegistry.lookup(ActCode.class, "402261004", CodeSystem.SNOMED.getRoot()));
		indication.setText("indication text");
		this.bean.setIndication(indication);
		this.bean.setPriorityNumber(1);
		return this;
	}

}
