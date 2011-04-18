package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;

@Hl7PartTypeMapping("NLPN_IN100150CA")
public class SubscribeBroadcastTopicAcceptedMessageBean extends RecordResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = -1285879183997204854L;
}