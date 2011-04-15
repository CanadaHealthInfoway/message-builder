package ca.infoway.messagebuilder.model.newfoundland.pr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.ActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationResponseMessageBean;

@Hl7PartTypeMapping("NLPN_IN100220CA")
public class UpdatePasswordRequestRefusedMessageBean extends RegistrationResponseMessageBean<ActEventBean> {

    private static final long serialVersionUID = 8249650530911805877L;
}
