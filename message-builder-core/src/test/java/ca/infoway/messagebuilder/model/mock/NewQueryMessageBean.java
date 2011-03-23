package ca.infoway.messagebuilder.model.mock;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public abstract class NewQueryMessageBean<CAE> extends NewBaseMessageBean {

    private static final long serialVersionUID = 3941752675494132716L;

    private CAE controlActEventBean;

    public void setControlActEventBean(CAE controlActEventBean) {
		this.controlActEventBean = controlActEventBean;
	}

	@Hl7XmlMapping({ "controlActEvent", "controlActProcess" })
    public final CAE getControlActEventBean() {
        return this.controlActEventBean;
    }
}
