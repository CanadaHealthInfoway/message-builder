package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile.CombinedMedication3Bean;

@Hl7PartTypeMapping("PORX_IN060180CA")
public class MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean extends NewQueryResponseMessageBean<MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean, CombinedMedication3Bean> {

    private static final long serialVersionUID = -4581248172585519902L;

    public MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean(ResponseMessageAttributesBean attributes, MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean(MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean criteria) {
        super(criteria);
    }

    public MedPrescriptionWithHistoryAndDispensesQueryResponseMessageBean() {
        this(new MedPrescriptionWithHistoryAndDispensesQueryCriteriaBean());
    }
}