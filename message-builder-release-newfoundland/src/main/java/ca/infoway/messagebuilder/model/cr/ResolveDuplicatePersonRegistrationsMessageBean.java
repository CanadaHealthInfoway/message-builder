package ca.infoway.messagebuilder.model.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.RegistrationRequestBean;
import ca.infoway.messagebuilder.model.RegistrationRequestMessageBean;

@Hl7PartTypeMapping("PRPA_IN101004CA")
public class ResolveDuplicatePersonRegistrationsMessageBean extends RegistrationRequestMessageBean<IdentifiedPersonBean> implements HasTargetReference<RegistrationRequestBean<IdentifiedPersonBean>> {

    private static final long serialVersionUID = -5826993313428772469L;

    public RegistrationRequestBean<IdentifiedPersonBean> getTargetReference() {
        if (getControlActEventBean() == null) {
            return null;
        } else {
            return (RegistrationRequestBean<IdentifiedPersonBean>) getControlActEventBean().getRegistrationBean();
        }
    }
}
