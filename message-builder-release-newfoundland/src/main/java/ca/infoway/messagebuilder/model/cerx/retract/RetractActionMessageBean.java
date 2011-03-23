package ca.infoway.messagebuilder.model.cerx.retract;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("COMT_IN600001CA")
public class RetractActionMessageBean extends RecordRequestMessageBean<ActEventBean> implements HasTargetReference<ActEventBean> {

    private static final long serialVersionUID = 8292898501823857922L;

    public ActEventBean getTargetReference() {
        return this.getRecord();
    }
}
