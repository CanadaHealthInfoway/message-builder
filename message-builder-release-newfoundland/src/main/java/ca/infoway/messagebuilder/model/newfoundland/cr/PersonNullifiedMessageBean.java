package ca.infoway.messagebuilder.model.newfoundland.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedEntity;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;

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
