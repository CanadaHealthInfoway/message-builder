package ca.infoway.messagebuilder.model.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.RegistrationRequestMessageBean;

@Hl7PartTypeMapping("PRPA_IN101002CA")
public class PersonInformationRevisedMessageBean extends RegistrationRequestMessageBean<IdentifiedPersonBean> implements HasTargetReference<IdentifiedPersonBean> {

    private static final long serialVersionUID = 799707377097965612L;

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
