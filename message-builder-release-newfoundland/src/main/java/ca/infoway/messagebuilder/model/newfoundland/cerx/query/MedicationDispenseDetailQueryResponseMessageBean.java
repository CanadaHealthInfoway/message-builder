package ca.infoway.messagebuilder.model.newfoundland.cerx.query;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.MedicationDispenseBean;

@Hl7PartTypeMapping("PORX_IN060220CA")
public class MedicationDispenseDetailQueryResponseMessageBean extends NewQueryResponseMessageBean<MedicationDispenseDetailQueryCriteriaBean, MedicationDispenseBean> {

    private static final long serialVersionUID = -4922568009722942773L;

    public MedicationDispenseDetailQueryResponseMessageBean(ResponseMessageAttributesBean attributes, MedicationDispenseDetailQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public MedicationDispenseDetailQueryResponseMessageBean(MedicationDispenseDetailQueryCriteriaBean criteria) {
        super(criteria);
    }

    public MedicationDispenseDetailQueryResponseMessageBean() {
        this(new MedicationDispenseDetailQueryCriteriaBean());
    }

    @Override
    public MedicationDispenseDetailQueryCriteriaBean getCriteria() {
        return super.getCriteria();
    }
}
