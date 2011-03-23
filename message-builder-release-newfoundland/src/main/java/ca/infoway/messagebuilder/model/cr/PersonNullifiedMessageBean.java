package ca.infoway.messagebuilder.model.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.IdentifiedEntity;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.RegistrationRequestMessageBean;

@Hl7PartTypeMapping("PRPA_IN101999CA")
public class PersonNullifiedMessageBean extends RegistrationRequestMessageBean<IdentifiedPersonBean> implements HasTargetReference<IdentifiedEntity> {

    private static final long serialVersionUID = 3066705196417392272L;

    public IdentifiedEntity getTargetReference() {
        if (getControlActEvent() == null) {
            return null;
        } else if (getControlActEvent().getRegistrationBean() == null) {
            return null;
        } else {
            return getControlActEvent().getRegistrationBean().getRecord();
        }
    }
}
