package ca.infoway.messagebuilder.model.newfoundland.cerx.consent;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("RCMR_IN010003CA")
public class RecordConsentOrOverrideRequestMessageBean extends RecordRequestMessageBean<ConsentBean> implements HasTargetReference<ConsentBean> {

    private static final long serialVersionUID = -4220204570227699696L;

    public ConsentBean getTargetReference() {
        return this.getRecord();
    }
}
