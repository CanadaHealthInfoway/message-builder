package ca.infoway.messagebuilder.model.cerx.refusal;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010080CA")
public class RecordRefusalToDispenseRequestRefusedMessageBean extends RecordResponseMessageBean<ActRequestBean> {

    private static final long serialVersionUID = 2601395497583423875L;
}
