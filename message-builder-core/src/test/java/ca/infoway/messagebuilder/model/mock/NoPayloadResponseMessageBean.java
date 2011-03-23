package ca.infoway.messagebuilder.model.mock;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public abstract class NoPayloadResponseMessageBean extends NewBaseMessageBean {

    private static final long serialVersionUID = 2456058924792026404L;

    private ControlActEventBean controlActEventBean;
    private AcknowledgementBean acknowledgement;

    public NoPayloadResponseMessageBean() {
        this.controlActEventBean = new ControlActEventBean();
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
    	return this.acknowledgement;
    }

    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

    public void clearControlActEvent() {
        this.controlActEventBean = null;
    }
}
