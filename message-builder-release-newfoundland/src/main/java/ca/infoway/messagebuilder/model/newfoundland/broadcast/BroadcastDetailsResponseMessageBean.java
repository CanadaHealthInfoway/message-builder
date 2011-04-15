package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordResponseMessageBean;

@Hl7PartTypeMapping("NLPN_IN100110CA")
public class BroadcastDetailsResponseMessageBean extends RecordResponseMessageBean<BroadcastMessageBean> {

    private static final long serialVersionUID = -4357385829017303741L;
}
