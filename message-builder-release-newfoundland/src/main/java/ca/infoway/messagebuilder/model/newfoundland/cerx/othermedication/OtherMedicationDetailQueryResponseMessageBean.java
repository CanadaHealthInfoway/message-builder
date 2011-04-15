package ca.infoway.messagebuilder.model.newfoundland.cerx.othermedication;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PORX_IN060460CA")
public class OtherMedicationDetailQueryResponseMessageBean extends NewQueryResponseMessageBean<OtherMedicationQueryCriteriaBean, OtherMedicationBean> {

    private static final long serialVersionUID = 2516717676904273113L;

    public OtherMedicationDetailQueryResponseMessageBean() {
        super(new OtherMedicationQueryCriteriaBean());
    }

    public OtherMedicationDetailQueryResponseMessageBean(OtherMedicationQueryCriteriaBean criteria) {
        super(criteria);
    }

    public OtherMedicationDetailQueryResponseMessageBean(ResponseMessageAttributesBean attributes, OtherMedicationQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }
}
