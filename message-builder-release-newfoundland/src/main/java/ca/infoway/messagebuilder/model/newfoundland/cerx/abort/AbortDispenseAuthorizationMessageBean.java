package ca.infoway.messagebuilder.model.newfoundland.cerx.abort;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN010560CA")
public class AbortDispenseAuthorizationMessageBean extends RecordRequestMessageBean<ActRequestBean> implements HasTargetReference<ActRequestBean> {

    private static final long serialVersionUID = 8292898501823857922L;

    public ActRequestBean getTargetReference() {
        return this.getRecord();
    }
}
