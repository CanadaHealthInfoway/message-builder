package ca.infoway.messagebuilder.model.newfoundland.cerx.dispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.cerx.dispense.RecordDispenseProcessingRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.DispenseRequest1Bean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN020190CA")
public class RecordDispenseProcessingRequestMessageBean extends RecordRequestMessageBean<DispenseRequest1Bean> implements HasTargetReference<RecordDispenseProcessingRequestMessageBean> {

    private static final long serialVersionUID = -6285495099388770893L;

    public RecordDispenseProcessingRequestMessageBean getTargetReference() {
        return this;
    }
}
