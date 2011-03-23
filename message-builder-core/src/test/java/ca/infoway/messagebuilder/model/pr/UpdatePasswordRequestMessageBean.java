package ca.infoway.messagebuilder.model.pr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.mock.RegistrationControlActEventBean;
import ca.infoway.messagebuilder.model.mock.RegistrationRequestMessageBean;

@Hl7PartTypeMapping("NLPN_IN100200CA")
public class UpdatePasswordRequestMessageBean extends RegistrationRequestMessageBean<RegistrationControlActEventBean<PasswordChangeBean>> {

    private static final long serialVersionUID = 3466536667079485448L;

}
