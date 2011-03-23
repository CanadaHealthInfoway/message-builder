package ca.infoway.messagebuilder.model.cerx.abort;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010580CA")
public class AbortDispenseAuthorizationRefusedMessageBean extends RecordResponseMessageBean<ActRequestBean> {

    private static final long serialVersionUID = 6434355930966959873L;
}
