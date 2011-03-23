package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

public class RegistrationControlActEventBean<T> extends ControlActEventBean {

    private static final long serialVersionUID = 6512047519951312670L;

    private RegistrationBean<T> registrationBean;

    @Hl7XmlMapping("subject")
    public RegistrationBean<T> getRegistrationBean() {
        return registrationBean;
    }

    public void setRegistrationBean(RegistrationBean<T> registrationBean) {
        this.registrationBean = registrationBean;
    }
}
