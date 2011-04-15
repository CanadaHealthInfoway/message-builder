package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PORX_IN060400CA")
public class MedicationProfileSummaryQueryResponseMessageBean extends NewQueryResponseMessageBean<MedicationProfileSummaryQueryCriteriaBean, MedicationProfileSummaryBean> {

    private static final long serialVersionUID = -4396100981076491414L;

    public MedicationProfileSummaryQueryResponseMessageBean(ResponseMessageAttributesBean attributes, MedicationProfileSummaryQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public MedicationProfileSummaryQueryResponseMessageBean(MedicationProfileSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }

    public MedicationProfileSummaryQueryResponseMessageBean() {
        this(new MedicationProfileSummaryQueryCriteriaBean());
    }
}
