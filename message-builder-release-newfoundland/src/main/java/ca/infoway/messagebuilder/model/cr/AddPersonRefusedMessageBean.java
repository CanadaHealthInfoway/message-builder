package ca.infoway.messagebuilder.model.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.RegistrationResponseMessageBean;

@Hl7PartTypeMapping("PRPA_IN101203CA")
public class AddPersonRefusedMessageBean extends RegistrationResponseMessageBean<IdentifiedPersonBean> {

    private static final long serialVersionUID = -858176775502413615L;
}
