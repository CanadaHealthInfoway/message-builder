package ca.infoway.messagebuilder.model.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("REPC_IN000004CA")
public class RecordAdverseReactionMessageBean extends RecordRequestMessageBean<AdverseReactionBean> implements HasTargetReference<RecordAdverseReactionMessageBean> {

    private static final long serialVersionUID = 742123649399653362L;

    public RecordAdverseReactionMessageBean getTargetReference() {
        return this;
    }
}
