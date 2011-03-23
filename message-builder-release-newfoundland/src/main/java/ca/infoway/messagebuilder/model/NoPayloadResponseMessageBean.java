package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public abstract class NoPayloadResponseMessageBean extends NewBaseMessageBean implements ResponseMessageBean {

    private static final long serialVersionUID = 2456058924792026404L;

    private ControlActEventBean controlActEventBean;

    public NoPayloadResponseMessageBean() {
        this.messageAttributes = new ResponseMessageAttributesBean();
        this.controlActEventBean = new ControlActEventBean();
    }

    public ResponseMessageAttributesBean getMessageAttributes() {
        return (ResponseMessageAttributesBean) this.messageAttributes;
    }

    public void setMessageAttributes(ResponseMessageAttributesBean responseMessageAttributesBean) {
        this.messageAttributes = responseMessageAttributesBean;
    }

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public ControlActEventBean getControlActEvent() {
        return this.controlActEventBean;
    }

    public AuthorBean getAuthor() {
        return getControlActEvent().getAuthor();
    }

    @Hl7XmlMapping("acknowledgement")
    public AcknowledgementBean getAcknowledgement() {
        return getMessageAttributes().getAcknowledgement();
    }

    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        getMessageAttributes().setAcknowledgement(acknowledgement);
    }

    public void clearControlActEvent() {
        this.controlActEventBean = null;
    }
}
