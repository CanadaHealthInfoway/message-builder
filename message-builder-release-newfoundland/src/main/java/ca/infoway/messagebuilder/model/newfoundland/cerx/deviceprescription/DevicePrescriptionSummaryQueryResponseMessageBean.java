package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PORX_IN060140CA")
public class DevicePrescriptionSummaryQueryResponseMessageBean extends NewQueryResponseMessageBean<DevicePrescriptionSummaryQueryCriteriaBean, DevicePrescriptionBean> {

    private static final long serialVersionUID = 8860656351279097751L;

    public DevicePrescriptionSummaryQueryResponseMessageBean(ResponseMessageAttributesBean attributes, DevicePrescriptionSummaryQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public DevicePrescriptionSummaryQueryResponseMessageBean(DevicePrescriptionSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }

    public DevicePrescriptionSummaryQueryResponseMessageBean() {
        this(new DevicePrescriptionSummaryQueryCriteriaBean());
    }
}
