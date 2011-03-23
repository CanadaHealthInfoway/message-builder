package ca.infoway.messagebuilder.model.cerx.allergy;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("REPC_IN000018CA")
public class PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean extends NewQueryResponseMessageBean<PatientAllergyIntoleranceWithHistoryQueryCriteriaBean, AllergyIntoleranceWithHistoryBean> {

    private static final long serialVersionUID = -4998463748557656365L;

    public PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean(ResponseMessageAttributesBean attributes, PatientAllergyIntoleranceWithHistoryQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean(PatientAllergyIntoleranceWithHistoryQueryCriteriaBean criteria) {
        super(criteria);
    }

    public PatientAllergyIntoleranceWithHistoryQueryResponseMessageBean() {
        this(new PatientAllergyIntoleranceWithHistoryQueryCriteriaBean());
    }
}
