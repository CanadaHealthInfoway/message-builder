package ca.infoway.messagebuilder.model.cerx.abort;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010560CA")
public class AbortDispenseAuthorizationMessageBean extends RecordRequestMessageBean<ActRequestBean> implements HasTargetReference<ActRequestBean> {

    private static final long serialVersionUID = 8292898501823857922L;

    public ActRequestBean getTargetReference() {
        return this.getRecord();
    }
}
