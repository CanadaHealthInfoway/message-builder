package ca.infoway.messagebuilder.model.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("REPC_IN000009CA")
public class UpdateAdverseReactionAcceptedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 2503913045283046066L;
}
