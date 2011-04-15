package ca.infoway.messagebuilder.model.newfoundland.cerx.condition;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("REPC_IN000024CA")
public class PatientMedicalConditionsQueryResponseMessageBean extends NewQueryResponseMessageBean<PatientMedicalConditionsQueryCriteriaBean, MedicalConditionBean> {

    private static final long serialVersionUID = 8860656351279097751L;

    public PatientMedicalConditionsQueryResponseMessageBean(ResponseMessageAttributesBean attributes, PatientMedicalConditionsQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public PatientMedicalConditionsQueryResponseMessageBean(PatientMedicalConditionsQueryCriteriaBean criteria) {
        super(criteria);
    }

    public PatientMedicalConditionsQueryResponseMessageBean() {
        this(new PatientMedicalConditionsQueryCriteriaBean());
    }
}
