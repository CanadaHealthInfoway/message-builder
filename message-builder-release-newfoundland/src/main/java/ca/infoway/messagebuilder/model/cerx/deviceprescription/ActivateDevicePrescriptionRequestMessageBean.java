package ca.infoway.messagebuilder.model.cerx.deviceprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.cerx.DeviceRequestBean;

@Hl7PartTypeMapping("PORX_IN010300CA")
public class ActivateDevicePrescriptionRequestMessageBean extends RecordRequestMessageBean<DeviceRequestBean> implements HasTargetReference<ActivateDevicePrescriptionRequestMessageBean> {

    private static final long serialVersionUID = -5526940017941869299L;

    public ActivateDevicePrescriptionRequestMessageBean getTargetReference() {
        return this;
    }
}
