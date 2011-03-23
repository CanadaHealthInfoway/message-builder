package ca.infoway.messagebuilder.model.cerx.medicationdispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;
import ca.infoway.messagebuilder.model.cerx.MedicationDispenseBean;

@Hl7PartTypeMapping("PORX_IN060240CA")
public class NewMedicationDispenseSummaryQueryResponseMessageBean extends NewQueryResponseMessageBean<MedicationDispenseSummaryQueryCriteriaBean, MedicationDispenseBean> {

    private static final long serialVersionUID = -4396100981076491414L;

    public NewMedicationDispenseSummaryQueryResponseMessageBean(ResponseMessageAttributesBean attributes, MedicationDispenseSummaryQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public NewMedicationDispenseSummaryQueryResponseMessageBean(MedicationDispenseSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }

    public NewMedicationDispenseSummaryQueryResponseMessageBean() {
        this(new MedicationDispenseSummaryQueryCriteriaBean());
    }
}
