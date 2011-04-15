package ca.infoway.messagebuilder.model.newfoundland.cerx.retract;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("COMT_IN600001CA")
public class RetractActionMessageBean extends RecordRequestMessageBean<ActEventBean> implements HasTargetReference<ActEventBean> {

    private static final long serialVersionUID = 8292898501823857922L;

    public ActEventBean getTargetReference() {
        return this.getRecord();
    }
}
