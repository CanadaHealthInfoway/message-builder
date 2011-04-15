package ca.infoway.messagebuilder.model.newfoundland.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.AuthorBean;
import ca.infoway.messagebuilder.model.newfoundland.ControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.NewBaseMessageBean;

@Hl7PartTypeMapping("MCCI_IN100001CA")
public class SendPollRequestMessageBean extends NewBaseMessageBean {

    private static final long serialVersionUID = 3253724113739040741L;

    public AuthorBean getAuthor() {
        return null;
    }

    public ControlActEventBean getControlActEvent() {
        return null;
    }
}
