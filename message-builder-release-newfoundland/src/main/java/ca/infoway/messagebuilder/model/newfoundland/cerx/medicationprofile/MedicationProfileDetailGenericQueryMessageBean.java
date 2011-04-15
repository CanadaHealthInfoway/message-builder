package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060350CA")
public class MedicationProfileDetailGenericQueryMessageBean extends NewQueryMessageBean<MedicationProfileDetailGenericQueryCriteriaBean> {

    private static final long serialVersionUID = -4094894276026166937L;

    public MedicationProfileDetailGenericQueryMessageBean() {
        this(new MedicationProfileDetailGenericQueryCriteriaBean());
    }

    public MedicationProfileDetailGenericQueryMessageBean(MedicationProfileDetailGenericQueryCriteriaBean criteria) {
        super(criteria);
    }
}
