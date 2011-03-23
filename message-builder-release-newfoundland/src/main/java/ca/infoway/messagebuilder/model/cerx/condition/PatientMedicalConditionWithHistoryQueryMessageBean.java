package ca.infoway.messagebuilder.model.cerx.condition;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryMessageBean;

@Hl7PartTypeMapping("REPC_IN000025CA")
public class PatientMedicalConditionWithHistoryQueryMessageBean extends NewQueryMessageBean<PatientMedicalConditionWithHistoryQueryCriteriaBean> {

    private static final long serialVersionUID = -8125385210455287263L;

    public PatientMedicalConditionWithHistoryQueryMessageBean() {
        this(new PatientMedicalConditionWithHistoryQueryCriteriaBean());
    }

    public PatientMedicalConditionWithHistoryQueryMessageBean(PatientMedicalConditionWithHistoryQueryCriteriaBean criteria) {
        super(criteria);
    }
}
