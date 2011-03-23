package ca.infoway.messagebuilder.model;

public interface ResponseMessageBean extends MessageBean {

    public ResponseMessageAttributesBean getMessageAttributes();
    public void setMessageAttributes(ResponseMessageAttributesBean responseMessageAttributesBean);
    public AcknowledgementBean getAcknowledgement();
    public void setAcknowledgement(AcknowledgementBean acknowledgementBean);
    public void clearControlActEvent();
    public abstract ControlActEventBean getControlActEvent();
    public abstract AuthorBean getAuthor();
}
