package ca.infoway.messagebuilder.model;

public class ResponseMessageAttributesBean extends MessageAttributesBean {

    private static final long serialVersionUID = -2543264228802381313L;

    private AcknowledgementBean acknowledgement = new AcknowledgementBean();

    public AcknowledgementBean getAcknowledgement() {
        return this.acknowledgement;
    }

    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }
}
