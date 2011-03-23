package ca.infoway.messagebuilder.model.pr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.marker.HasTargetReference;
import ca.infoway.messagebuilder.model.RegistrationRequestMessageBean;

@Hl7PartTypeMapping("NLPN_IN100200CA")
public class UpdatePasswordRequestMessageBean extends RegistrationRequestMessageBean<PasswordChangeBean> implements HasTargetReference<UpdatePasswordRequestMessageBean> {

    private static final long serialVersionUID = 3466536667079485448L;

    public UpdatePasswordRequestMessageBean getTargetReference() {
        return this;
    }
}
