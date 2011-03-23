package ca.infoway.messagebuilder.model.cr.reviseperson;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.RegistrationResponseMessageBean;

@Hl7PartTypeMapping("PRPA_IN101205CA")
public class RevisePersonAcceptedMessageBean extends RegistrationResponseMessageBean<IdentifiedPersonBean> {

    private static final long serialVersionUID = -2686254590054412749L;
}
