package ca.infoway.messagebuilder.model.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.RegistrationResponseMessageBean;

@Hl7PartTypeMapping("PRPA_IN101202CA")
public class AddPersonAcceptedMessageBean extends RegistrationResponseMessageBean<IdentifiedPersonBean> {

    private static final long serialVersionUID = 5562254727752208267L;
}
