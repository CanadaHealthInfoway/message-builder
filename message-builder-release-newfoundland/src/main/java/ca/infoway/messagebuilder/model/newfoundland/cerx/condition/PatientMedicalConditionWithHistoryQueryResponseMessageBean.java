package ca.infoway.messagebuilder.model.newfoundland.cerx.condition;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("REPC_IN000026CA")
public class PatientMedicalConditionWithHistoryQueryResponseMessageBean extends NewQueryResponseMessageBean<PatientMedicalConditionWithHistoryQueryCriteriaBean, MedicalConditionWithHistoryBean> {

    private static final long serialVersionUID = -4998463748557656365L;

    public PatientMedicalConditionWithHistoryQueryResponseMessageBean(ResponseMessageAttributesBean attributes, PatientMedicalConditionWithHistoryQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public PatientMedicalConditionWithHistoryQueryResponseMessageBean(PatientMedicalConditionWithHistoryQueryCriteriaBean criteria) {
        super(criteria);
    }

    public PatientMedicalConditionWithHistoryQueryResponseMessageBean() {
        this(new PatientMedicalConditionWithHistoryQueryCriteriaBean());
    }
}
