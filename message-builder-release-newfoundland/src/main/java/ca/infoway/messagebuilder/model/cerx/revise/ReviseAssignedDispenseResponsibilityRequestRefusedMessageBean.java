package ca.infoway.messagebuilder.model.cerx.revise;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010120CA")
public class ReviseAssignedDispenseResponsibilityRequestRefusedMessageBean extends RecordResponseMessageBean<ActRequestBean> {

    private static final long serialVersionUID = -1357761414825825827L;
}
