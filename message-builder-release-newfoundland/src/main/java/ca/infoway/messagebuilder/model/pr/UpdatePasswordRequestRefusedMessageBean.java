package ca.infoway.messagebuilder.model.pr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.ActEventBean;
import ca.infoway.messagebuilder.model.RegistrationResponseMessageBean;

@Hl7PartTypeMapping("NLPN_IN100220CA")
public class UpdatePasswordRequestRefusedMessageBean extends RegistrationResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 8249650530911805877L;
}
