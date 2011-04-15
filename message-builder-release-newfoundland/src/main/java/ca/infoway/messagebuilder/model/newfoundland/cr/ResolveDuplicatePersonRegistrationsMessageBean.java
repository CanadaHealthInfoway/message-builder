package ca.infoway.messagebuilder.model.newfoundland.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

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
