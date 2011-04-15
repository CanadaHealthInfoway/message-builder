package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RecordRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

@Hl7PartTypeMapping("NLPN_IN100140CA")
public class SubscribeBroadcastTopicMessageBean extends RecordRequestMessageBean<TopicSubscriptionBean> implements HasTargetReference<TopicSubscriptionBean> {

    private static final long serialVersionUID = 8506329260039382068L;

    public TopicSubscriptionBean getTargetReference() {
        return this.getControlActEvent().getRecord();
    }
}
