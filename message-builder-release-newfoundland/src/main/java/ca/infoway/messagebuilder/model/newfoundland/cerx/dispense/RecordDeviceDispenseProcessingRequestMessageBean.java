package ca.infoway.messagebuilder.model.newfoundland.cerx.dispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DispenseRequest2Bean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN020060CA")
public class RecordDeviceDispenseProcessingRequestMessageBean extends RecordRequestMessageBean<DispenseRequest2Bean> implements HasTargetReference<RecordDeviceDispenseProcessingRequestMessageBean> {

    private static final long serialVersionUID = 9119162645267234128L;

    public RecordDeviceDispenseProcessingRequestMessageBean getTargetReference() {
        return this;
    }
}
