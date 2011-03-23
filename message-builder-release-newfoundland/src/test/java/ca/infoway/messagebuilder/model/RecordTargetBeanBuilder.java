package ca.infoway.messagebuilder.model;

public class RecordTargetBeanBuilder extends BaseBeanBuilder<RecordTargetBean> {
	
	public RecordTargetBeanBuilder() {
		super(new RecordTargetBean());
	}

	public RecordTargetBeanBuilder withPatientIdentifierBean(PatientIdentifierBean patientIdentifierBean) {
		this.bean.setPatient(patientIdentifierBean);
		return this;
	}

}
