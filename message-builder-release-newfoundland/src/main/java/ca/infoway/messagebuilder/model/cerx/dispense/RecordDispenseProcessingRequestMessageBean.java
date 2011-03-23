package ca.infoway.messagebuilder.model.cerx.dispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.cerx.DispenseRequest1Bean;

@Hl7PartTypeMapping("PORX_IN020190CA")
public class RecordDispenseProcessingRequestMessageBean extends RecordRequestMessageBean<DispenseRequest1Bean> implements HasTargetReference<RecordDispenseProcessingRequestMessageBean> {

    private static final long serialVersionUID = -6285495099388770893L;

    public RecordDispenseProcessingRequestMessageBean getTargetReference() {
        return this;
    }
}
