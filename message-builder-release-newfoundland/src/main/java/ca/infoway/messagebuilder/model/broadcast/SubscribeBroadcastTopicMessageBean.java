package ca.infoway.messagebuilder.model.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RecordRequestMessageBean;

@Hl7PartTypeMapping("NLPN_IN100140CA")
public class SubscribeBroadcastTopicMessageBean extends RecordRequestMessageBean<TopicSubscriptionBean> implements HasTargetReference<TopicSubscriptionBean> {

    private static final long serialVersionUID = 8506329260039382068L;

    public TopicSubscriptionBean getTargetReference() {
        return this.getControlActEvent().getRecord();
    }
}
