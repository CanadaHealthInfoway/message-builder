package ca.infoway.messagebuilder.model.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;

@Hl7PartTypeMapping("REPC_IN000006CA")
public class RecordAdverseReactionRefusedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 2857198710382160108L;
}
