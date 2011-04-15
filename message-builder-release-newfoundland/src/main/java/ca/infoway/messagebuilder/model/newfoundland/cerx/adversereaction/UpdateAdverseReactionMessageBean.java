package ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("REPC_IN000008CA")
public class UpdateAdverseReactionMessageBean extends RecordRequestMessageBean<AdverseReactionBean> implements HasTargetReference<UpdateAdverseReactionMessageBean> {

    private static final long serialVersionUID = 6300318163031306907L;

    public UpdateAdverseReactionMessageBean getTargetReference() {
        return this;
    }
}
