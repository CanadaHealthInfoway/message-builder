package ca.infoway.messagebuilder.model.mock;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public abstract class RegistrationRequestMessageBean<CAE> extends NewBaseMessageBean {

    private static final long serialVersionUID = -4171299182341789015L;

    private CAE controlActEventBean;

    public void setControlActEventBean(CAE controlActEventBean) {
		this.controlActEventBean = controlActEventBean;
	}

    @Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public CAE getControlActEventBean() {
        return this.controlActEventBean;
    }
}
