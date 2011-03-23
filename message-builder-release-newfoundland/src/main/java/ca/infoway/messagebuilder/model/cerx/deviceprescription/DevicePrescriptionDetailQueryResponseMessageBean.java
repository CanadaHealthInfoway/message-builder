package ca.infoway.messagebuilder.model.cerx.deviceprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PORX_IN060100CA")
public class DevicePrescriptionDetailQueryResponseMessageBean extends NewQueryResponseMessageBean<DevicePrescriptionDetailQueryCriteriaBean, DevicePrescriptionDetailsBean> {

    private static final long serialVersionUID = 8860656351279097751L;

    public DevicePrescriptionDetailQueryResponseMessageBean(ResponseMessageAttributesBean attributes, DevicePrescriptionDetailQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public DevicePrescriptionDetailQueryResponseMessageBean(DevicePrescriptionDetailQueryCriteriaBean criteria) {
        super(criteria);
    }

    public DevicePrescriptionDetailQueryResponseMessageBean() {
        this(new DevicePrescriptionDetailQueryCriteriaBean());
    }
}
