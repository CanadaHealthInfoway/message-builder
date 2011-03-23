package ca.infoway.messagebuilder.model.cr.reviseperson;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.RegistrationRequestMessageBean;

@Hl7PartTypeMapping("PRPA_IN101204CA")
public class RevisePersonMessageBean extends RegistrationRequestMessageBean<IdentifiedPersonBean> implements HasTargetReference<IdentifiedPersonBean> {

    private static final long serialVersionUID = 742123649399653362L;

    public IdentifiedPersonBean getTargetReference() {
        if (getControlActEvent() == null) {
            return null;
        } else if (getControlActEvent().getRegistrationBean() == null) {
            return null;
        } else {
            return getControlActEvent().getRegistrationBean().getRecord();
        }
    }
}
