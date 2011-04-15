package ca.infoway.messagebuilder.model.newfoundland.pr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationRequestMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.newfoundland.pr.PasswordChangeBean;
import ca.infoway.messagebuilder.model.newfoundland.pr.UpdatePasswordRequestMessageBean;

@Hl7PartTypeMapping("NLPN_IN100200CA")
public class UpdatePasswordRequestMessageBean extends RegistrationRequestMessageBean<PasswordChangeBean> implements HasTargetReference<UpdatePasswordRequestMessageBean> {

    private static final long serialVersionUID = 3466536667079485448L;

    public UpdatePasswordRequestMessageBean getTargetReference() {
        return this;
    }
}
