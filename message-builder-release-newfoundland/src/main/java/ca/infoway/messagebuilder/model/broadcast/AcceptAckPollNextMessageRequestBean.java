package ca.infoway.messagebuilder.model.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.AcknowledgementBean;
import ca.infoway.messagebuilder.model.AuthorBean;
import ca.infoway.messagebuilder.model.ControlActEventBean;
import ca.infoway.messagebuilder.model.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("MCCI_IN100004CA")
public class AcceptAckPollNextMessageRequestBean extends NewBaseMessageBean {

    private static final long serialVersionUID = 7799204464775080859L;

    public AcceptAckPollNextMessageRequestBean() {
        this.messageAttributes = new ResponseMessageAttributesBean();
    }

    public AuthorBean getAuthor() {
        return null;
    }

    public ControlActEventBean getControlActEvent() {
        return null;
    }

    public ResponseMessageAttributesBean getMessageAttributes() {
        return (ResponseMessageAttributesBean) this.messageAttributes;
    }

    @Hl7XmlMapping("acknowledgement")
    public AcknowledgementBean getAcknowledgement() {
        return getMessageAttributes().getAcknowledgement();
    }

    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        getMessageAttributes().setAcknowledgement(acknowledgement);
    }
}
