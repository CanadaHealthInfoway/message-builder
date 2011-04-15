package ca.infoway.messagebuilder.model.newfoundland;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public abstract class RegistrationRequestMessageBean<T> extends NewBaseMessageBean {

    private static final long serialVersionUID = -4171299182341789015L;

    private final RegistrationControlActEventBean<T> controlActEventBean;

    public RegistrationRequestMessageBean() {
        this.controlActEventBean = new RegistrationControlActEventBean<T>();
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
}
