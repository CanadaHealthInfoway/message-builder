/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.SubscriptionStatus;
import ca.infoway.messagebuilder.domainvalue.TopicPriority;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "NLPN_MT100110CA.BroadcastTopic", "NLPN_MT100130CA.BroadcastTopic", "NLPN_MT100140CA.BroadcastTopic" })
public class BroadcastTopicBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -5749959427166704868L;

    private II id = new IIImpl();

    private ST title = new STImpl();

    private CD topicPriority = new CDImpl();

    private CD subscriptionStatus = new CDImpl();

    @Hl7XmlMapping("id")
    public Identifier getId() {
        return this.id.getValue();
    }

    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping("title")
    public String getTitle() {
        return this.title.getValue();
    }

    public void setTitle(String title) {
        this.title.setValue(title);
    }

    @Hl7XmlMapping("priorityCode")
    public TopicPriority getTopicPriority() {
        return (TopicPriority) this.topicPriority.getValue();
    }

    public void setTopicPriority(TopicPriority topicPriority) {
        this.topicPriority.setValue(topicPriority);
    }

    @Hl7XmlMapping("subject/subscription/code")
    public SubscriptionStatus getSubscriptionStatus() {
        return (SubscriptionStatus) this.subscriptionStatus.getValue();
    }

    public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus.setValue(subscriptionStatus);
    }
}
