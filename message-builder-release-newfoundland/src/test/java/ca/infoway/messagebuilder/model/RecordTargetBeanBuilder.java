package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.model.newfoundland.PatientIdentifierBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordTargetBean;

public class RecordTargetBeanBuilder extends BaseBeanBuilder<RecordTargetBean> {
	
	public RecordTargetBeanBuilder() {
		super(new RecordTargetBean());
	}

	public RecordTargetBeanBuilder withPatientIdentifierBean(PatientIdentifierBean patientIdentifierBean) {
		this.bean.setPatient(patientIdentifierBean);
		return this;
	}

}
