package ca.infoway.messagebuilder.model.newfoundland.pr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationResponseMessageBean;

@Hl7PartTypeMapping("NLPN_IN100210CA")
public class UpdatePasswordRequestAcceptedMessageBean extends RegistrationResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = -8759527325837072164L;
}
