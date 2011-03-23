package ca.infoway.messagebuilder.model.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("REPC_IN000008CA")
public class UpdateAdverseReactionMessageBean extends RecordRequestMessageBean<AdverseReactionBean> implements HasTargetReference<UpdateAdverseReactionMessageBean> {

    private static final long serialVersionUID = 6300318163031306907L;

    public UpdateAdverseReactionMessageBean getTargetReference() {
        return this;
    }
}
