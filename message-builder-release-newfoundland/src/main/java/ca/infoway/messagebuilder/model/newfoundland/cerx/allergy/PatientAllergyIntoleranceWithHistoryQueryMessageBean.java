package ca.infoway.messagebuilder.model.newfoundland.cerx.allergy;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("REPC_IN000017CA")
public class PatientAllergyIntoleranceWithHistoryQueryMessageBean extends NewQueryMessageBean<PatientAllergyIntoleranceWithHistoryQueryCriteriaBean> {

    private static final long serialVersionUID = -8125385210455287263L;

    public PatientAllergyIntoleranceWithHistoryQueryMessageBean() {
        this(new PatientAllergyIntoleranceWithHistoryQueryCriteriaBean());
    }

    public PatientAllergyIntoleranceWithHistoryQueryMessageBean(PatientAllergyIntoleranceWithHistoryQueryCriteriaBean criteria) {
        super(criteria);
    }
}
