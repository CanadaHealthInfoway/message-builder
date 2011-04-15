package ca.infoway.messagebuilder.model.newfoundland.pr;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;

public class ProviderRecord extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 1863797956467468007L;

    private HealthcareProvider provider;

    @Hl7XmlMapping("healthCareProvider/id")
    public HealthcareProvider getProvider() {
        return this.provider;
    }

    public void setProvider(HealthcareProvider provider) {
        this.provider = provider;
    }
}
