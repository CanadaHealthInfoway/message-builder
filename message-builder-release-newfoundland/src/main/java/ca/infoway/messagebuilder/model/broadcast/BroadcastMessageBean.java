package ca.infoway.messagebuilder.model.broadcast;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping("NLPN_MT100110CA.BroadcastMessage")
public class BroadcastMessageBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 4703543973683941997L;

    private ST title = new STImpl();

    private ST text = new STImpl();

    private TS effectiveTime = new TSImpl();

    private BroadcastTopicBean broadcastTopicBean;

    private ST broadcastSource = new STImpl();

    @Hl7XmlMapping("title")
    public String getTitle() {
        return this.title.getValue();
    }

    public void setTitle(String title) {
        this.title.setValue(title);
    }

    @Hl7XmlMapping("text")
    public String getText() {
        return this.text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    @Hl7XmlMapping("effectiveTime")
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }

    @Hl7XmlMapping("author/broadcastSource/name")
    public String getBroadcastSource() {
        return this.broadcastSource.getValue();
    }

    public void setBroadcastSource(String broadcastSource) {
        this.broadcastSource.setValue(broadcastSource);
    }

    @Hl7XmlMapping("subject/broadcastTopic")
    public BroadcastTopicBean getBroadcastTopic() {
        return broadcastTopicBean;
    }

    public void setBroadcastTopic(BroadcastTopicBean broadcastTopicBean) {
        this.broadcastTopicBean = broadcastTopicBean;
    }
}
