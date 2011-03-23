package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public abstract class RegistrationResponseMessageBean<T> extends NewBaseMessageBean implements ResponseMessageBean {

    private static final long serialVersionUID = -6699640829502753027L;

    private RegistrationControlActEventBean<T> controlActEventBean;

    public RegistrationResponseMessageBean() {
        this.messageAttributes = new ResponseMessageAttributesBean();
        this.controlActEventBean = new RegistrationControlActEventBean<T>();
    }

    @Override
    public ResponseMessageAttributesBean getMessageAttributes() {
        return (ResponseMessageAttributesBean) this.messageAttributes;
    }

    public void setMessageAttributes(ResponseMessageAttributesBean responseMessageAttributesBean) {
        this.messageAttributes = responseMessageAttributesBean;
    }

    public RegistrationControlActEventBean<T> getControlActEvent() {
        return controlActEventBean;
    }

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public final RegistrationControlActEventBean<T> getControlActEventBean() {
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
