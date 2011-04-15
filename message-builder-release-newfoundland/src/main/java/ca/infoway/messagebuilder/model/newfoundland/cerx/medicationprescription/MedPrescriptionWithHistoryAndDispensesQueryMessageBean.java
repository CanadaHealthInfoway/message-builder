package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060170CA")
public class MedPrescriptionWithHistoryAndDispensesQueryMessageBean extends NewQueryMessageBean<MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean> {

    private static final long serialVersionUID = -448522063266714407L;

    public MedPrescriptionWithHistoryAndDispensesQueryMessageBean() {
        this(new MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean());
    }

    public MedPrescriptionWithHistoryAndDispensesQueryMessageBean(MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean criteria) {
        super(criteria);
    }
}
