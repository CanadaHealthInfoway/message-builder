package ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("REPC_IN000004CA")
public class RecordAdverseReactionMessageBean extends RecordRequestMessageBean<AdverseReactionBean> implements HasTargetReference<RecordAdverseReactionMessageBean> {

    private static final long serialVersionUID = 742123649399653362L;

    public RecordAdverseReactionMessageBean getTargetReference() {
        return this;
    }
}
