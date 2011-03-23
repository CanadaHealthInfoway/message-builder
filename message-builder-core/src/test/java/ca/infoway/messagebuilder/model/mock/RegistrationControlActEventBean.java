package ca.infoway.messagebuilder.model.mock;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping({"MFMI_MT700711CA.ControlActEvent"})
public class RegistrationControlActEventBean<RR> extends ControlActEventBean {

    private static final long serialVersionUID = 6512047519951312670L;

    private RegistrationRequestBean<RR> registrationBean;

    @Hl7XmlMapping("subject")
    public RegistrationRequestBean<RR> getRegistrationBean() {
        return registrationBean;
    }

    public void setRegistrationBean(RegistrationRequestBean<RR> registrationBean) {
        this.registrationBean = registrationBean;
    }
}
