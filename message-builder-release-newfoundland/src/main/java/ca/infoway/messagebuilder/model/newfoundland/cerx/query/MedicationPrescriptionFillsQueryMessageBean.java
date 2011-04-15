package ca.infoway.messagebuilder.model.newfoundland.cerx.query;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060270CA")
public class MedicationPrescriptionFillsQueryMessageBean extends NewQueryMessageBean<MedicationPrescriptionFillsQueryCriteriaBean> {

    private static final long serialVersionUID = 6567883546388299218L;

    public MedicationPrescriptionFillsQueryMessageBean() {
        this(new MedicationPrescriptionFillsQueryCriteriaBean());
    }

    public MedicationPrescriptionFillsQueryMessageBean(MedicationPrescriptionFillsQueryCriteriaBean criteria) {
        super(criteria);
    }
}
