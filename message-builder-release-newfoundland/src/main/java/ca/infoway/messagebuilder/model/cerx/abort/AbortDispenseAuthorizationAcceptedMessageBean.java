package ca.infoway.messagebuilder.model.cerx.abort;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.RecordResponseMessageBean;
import ca.infoway.messagebuilder.model.cerx.ActRequestBean;

@Hl7PartTypeMapping("PORX_IN010570CA")
public class AbortDispenseAuthorizationAcceptedMessageBean extends RecordResponseMessageBean<ActRequestBean> {

    private static final long serialVersionUID = -2560235225191013715L;
}
