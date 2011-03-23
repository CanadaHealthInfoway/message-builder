package ca.infoway.messagebuilder.model.cerx.medicationprofile;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PORX_IN060360CA")
public class MedicationProfileDetailGenericQueryResponseMessageBean extends NewQueryResponseMessageBean<MedicationProfileDetailGenericQueryCriteriaBean, MedicationRecordBean> {

    private static final long serialVersionUID = -4581248172585519902L;

    public MedicationProfileDetailGenericQueryResponseMessageBean(ResponseMessageAttributesBean attributes, MedicationProfileDetailGenericQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public MedicationProfileDetailGenericQueryResponseMessageBean(MedicationProfileDetailGenericQueryCriteriaBean criteria) {
        super(criteria);
    }

    public MedicationProfileDetailGenericQueryResponseMessageBean() {
        this(new MedicationProfileDetailGenericQueryCriteriaBean());
    }
}
