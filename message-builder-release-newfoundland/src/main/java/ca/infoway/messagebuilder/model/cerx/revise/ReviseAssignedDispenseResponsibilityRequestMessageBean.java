package ca.infoway.messagebuilder.model.cerx.revise;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("PORX_IN010100CA")
public class ReviseAssignedDispenseResponsibilityRequestMessageBean extends RecordRequestMessageBean<DispenseAuthorizationBean> implements HasTargetReference<ReviseAssignedDispenseResponsibilityRequestMessageBean> {

    private static final long serialVersionUID = -1005327753091122125L;

    public ReviseAssignedDispenseResponsibilityRequestMessageBean getTargetReference() {
        return this;
    }
}
