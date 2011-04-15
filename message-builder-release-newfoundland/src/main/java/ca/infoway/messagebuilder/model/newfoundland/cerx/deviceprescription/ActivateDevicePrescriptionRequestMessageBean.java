package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DeviceRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN010300CA")
public class ActivateDevicePrescriptionRequestMessageBean extends RecordRequestMessageBean<DeviceRequestBean> implements HasTargetReference<ActivateDevicePrescriptionRequestMessageBean> {

    private static final long serialVersionUID = -5526940017941869299L;

    public ActivateDevicePrescriptionRequestMessageBean getTargetReference() {
        return this;
    }
}
