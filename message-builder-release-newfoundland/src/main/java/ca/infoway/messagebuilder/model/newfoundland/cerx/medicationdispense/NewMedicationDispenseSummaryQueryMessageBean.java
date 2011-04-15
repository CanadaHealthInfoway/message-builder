package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationdispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060230CA")
public class NewMedicationDispenseSummaryQueryMessageBean extends NewQueryMessageBean<MedicationDispenseSummaryQueryCriteriaBean> {

    private static final long serialVersionUID = -1529723287636359486L;

    public NewMedicationDispenseSummaryQueryMessageBean() {
        this(new MedicationDispenseSummaryQueryCriteriaBean());
    }

    public NewMedicationDispenseSummaryQueryMessageBean(MedicationDispenseSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }
}
