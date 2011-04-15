package ca.infoway.messagebuilder.model.newfoundland.cerx.abort;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("PORX_IN020370CA")
public class RecordDispenseReversalMessageBean extends RecordRequestMessageBean<ActEventBean> implements HasTargetReference<ActEventBean> {

    private static final long serialVersionUID = 8292898501823857922L;

    public ActEventBean getTargetReference() {
        return this.getRecord();
    }
}
