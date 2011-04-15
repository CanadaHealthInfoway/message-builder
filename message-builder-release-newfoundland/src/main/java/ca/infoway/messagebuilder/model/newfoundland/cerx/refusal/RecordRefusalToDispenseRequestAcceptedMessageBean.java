package ca.infoway.messagebuilder.model.newfoundland.cerx.refusal;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010070CA")
public class RecordRefusalToDispenseRequestAcceptedMessageBean extends RecordResponseMessageBean<ActRequestBean> {

    private static final long serialVersionUID = 2601395497583423875L;
}
