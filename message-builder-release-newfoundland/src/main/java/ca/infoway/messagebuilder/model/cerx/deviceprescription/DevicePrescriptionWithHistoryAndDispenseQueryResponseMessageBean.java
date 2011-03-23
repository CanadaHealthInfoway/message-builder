package ca.infoway.messagebuilder.model.cerx.deviceprescription;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PORX_IN060020CA")
public class DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean extends NewQueryResponseMessageBean<DevicePrescriptionDetailQueryCriteriaBean, DeviceDispenseBean> implements Serializable {

    private static final long serialVersionUID = -4593192243372026019L;

    public DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean(ResponseMessageAttributesBean attributes, DevicePrescriptionDetailQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean() {
        this(new DevicePrescriptionDetailQueryCriteriaBean());
    }

    public DevicePrescriptionWithHistoryAndDispenseQueryResponseMessageBean(DevicePrescriptionDetailQueryCriteriaBean criteria) {
        super(criteria);
    }
}
