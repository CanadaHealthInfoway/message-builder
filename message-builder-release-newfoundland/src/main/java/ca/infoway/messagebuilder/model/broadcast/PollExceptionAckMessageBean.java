package ca.infoway.messagebuilder.model.broadcast;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.AcknowledgementBean;
import ca.infoway.messagebuilder.model.AuthorBean;
import ca.infoway.messagebuilder.model.ControlActEventBean;
import ca.infoway.messagebuilder.model.NewBaseMessageBean;
import ca.infoway.messagebuilder.model.ResponseMessageAttributesBean;
import ca.infoway.messagebuilder.model.ResponseMessageBean;

@Hl7PartTypeMapping("MCCI_IN100005CA")
public class PollExceptionAckMessageBean extends NewBaseMessageBean implements ResponseMessageBean {

    private static final long serialVersionUID = -5244167476294123243L;

    public PollExceptionAckMessageBean() {
        this.messageAttributes = new ResponseMessageAttributesBean();
    }

    public AuthorBean getAuthor() {
        return null;
    }

    public ControlActEventBean getControlActEvent() {
        return null;
    }

    @Override
    public ResponseMessageAttributesBean getMessageAttributes() {
        return (ResponseMessageAttributesBean) this.messageAttributes;
    }

    public void setMessageAttributes(ResponseMessageAttributesBean responseMessageAttributesBean) {
        this.messageAttributes = responseMessageAttributesBean;
    }

    @Hl7XmlMapping("acknowledgement")
    public AcknowledgementBean getAcknowledgement() {
        return getMessageAttributes().getAcknowledgement();
    }

    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        getMessageAttributes().setAcknowledgement(acknowledgement);
    }

    public void clearControlActEvent() {
    }
}
