package ca.infoway.messagebuilder.model.cerx.allergy;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("REPC_IN000016CA")
public class PatientAllergyIntoleranceQueryResponseMessageBean extends NewQueryResponseMessageBean<AllergyIntoleranceQueryCriteriaBean, AllergyIntoleranceBean> {

    private static final long serialVersionUID = 8860656351279097751L;

    public PatientAllergyIntoleranceQueryResponseMessageBean(ResponseMessageAttributesBean attributes, AllergyIntoleranceQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public PatientAllergyIntoleranceQueryResponseMessageBean(AllergyIntoleranceQueryCriteriaBean criteria) {
        super(criteria);
    }

    public PatientAllergyIntoleranceQueryResponseMessageBean() {
        this(new AllergyIntoleranceQueryCriteriaBean());
    }
}
