package ca.infoway.messagebuilder.model.broadcast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "NLPN_MT100140CA.TopicSubscription" })
public class TopicSubscriptionBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 6001937279366036127L;

    private final List<BroadcastTopicBean> broadcastTopics = Collections.synchronizedList(new ArrayList<BroadcastTopicBean>());

    @Hl7XmlMapping("subject/broadcastTopic")
    public List<BroadcastTopicBean> getBroadcastTopics() {
        return this.broadcastTopics;
    }
}
