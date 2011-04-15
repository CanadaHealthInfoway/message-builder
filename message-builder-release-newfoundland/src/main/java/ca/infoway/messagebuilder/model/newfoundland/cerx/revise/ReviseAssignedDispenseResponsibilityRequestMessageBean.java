package ca.infoway.messagebuilder.model.newfoundland.cerx.revise;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN010100CA")
public class ReviseAssignedDispenseResponsibilityRequestMessageBean extends RecordRequestMessageBean<DispenseAuthorizationBean> implements HasTargetReference<ReviseAssignedDispenseResponsibilityRequestMessageBean> {

    private static final long serialVersionUID = -1005327753091122125L;

    public ReviseAssignedDispenseResponsibilityRequestMessageBean getTargetReference() {
        return this;
    }
}
