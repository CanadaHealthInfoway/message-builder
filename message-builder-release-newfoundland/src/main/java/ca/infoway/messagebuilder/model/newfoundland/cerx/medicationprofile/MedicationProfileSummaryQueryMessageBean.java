package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060390CA")
public class MedicationProfileSummaryQueryMessageBean extends NewQueryMessageBean<MedicationProfileSummaryQueryCriteriaBean> {

    private static final long serialVersionUID = -1529723287636359486L;

    public MedicationProfileSummaryQueryMessageBean() {
        this(new MedicationProfileSummaryQueryCriteriaBean());
    }

    public MedicationProfileSummaryQueryMessageBean(MedicationProfileSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }
}
