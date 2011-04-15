package ca.infoway.messagebuilder.model.newfoundland.cr.reviseperson;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.RegistrationResponseMessageBean;

@Hl7PartTypeMapping("PRPA_IN101206CA")
public class RevisePersonRefusedMessageBean extends RegistrationResponseMessageBean<IdentifiedPersonBean> {

    private static final long serialVersionUID = 2857198710382160108L;
}
