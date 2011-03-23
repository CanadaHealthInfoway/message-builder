package ca.infoway.messagebuilder.model.cerx.query;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;
import ca.infoway.messagebuilder.model.cerx.MedicationDispenseBean;

@Hl7PartTypeMapping("PORX_IN060280CA")
public class MedicationPrescriptionFillsQueryResponseMessageBean extends NewQueryResponseMessageBean<MedicationPrescriptionFillsQueryCriteriaBean, MedicationDispenseBean> {

    private static final long serialVersionUID = 6567883546388299218L;

    public MedicationPrescriptionFillsQueryResponseMessageBean(ResponseMessageAttributesBean attributes, MedicationPrescriptionFillsQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public MedicationPrescriptionFillsQueryResponseMessageBean(MedicationPrescriptionFillsQueryCriteriaBean criteria) {
        super(criteria);
    }

    public MedicationPrescriptionFillsQueryResponseMessageBean() {
        this(new MedicationPrescriptionFillsQueryCriteriaBean());
    }

    @Override
    public MedicationPrescriptionFillsQueryCriteriaBean getCriteria() {
        return super.getCriteria();
    }
}
