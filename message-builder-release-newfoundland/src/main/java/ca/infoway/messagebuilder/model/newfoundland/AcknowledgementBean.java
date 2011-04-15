package ca.infoway.messagebuilder.model.newfoundland;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.MessageWaitingPriority;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "MCCI_MT002300CA.Acknowledgement", "MCCI_MT002200CA.Acknowledgement" })
public class AcknowledgementBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -4392983646493404789L;

    @Hl7BusinessName("acknowledgedMessageId")
    private II targetMessage = new IIImpl();
    @Hl7BusinessName("acknowledgementCode")
    private CD acknowledgementType = new CDImpl();
    @Hl7BusinessName("numberOfWaitingMessages")
    private INT messageWaitingNumber = new INTImpl();
    @Hl7BusinessName("messageWaitingPriority")
    private CD messageWaitingPriorityCode = new CDImpl();
    @Hl7BusinessName("acknowledgementDetail")
    private final List<AcknowledgementDetailBean> acknowledgementDetails = Collections.synchronizedList(new ArrayList<AcknowledgementDetailBean>());

    @Hl7XmlMapping("messageWaitingNumber")
    public Integer getMessageWaitingNumber() {
        return this.messageWaitingNumber.getValue();
    }

    public void setMessageWaitingNumber(Integer messageWaitingNumber) {
        this.messageWaitingNumber.setValue(messageWaitingNumber);
    }

    @Hl7XmlMapping("messageWaitingPriorityCode")
    public MessageWaitingPriority getMessageWaitingPriorityCode() {
        return (MessageWaitingPriority) this.messageWaitingPriorityCode.getValue();
    }

    public void setMessageWaitingPriorityCode(MessageWaitingPriority messageWaitingPriorityCode) {
        this.messageWaitingPriorityCode.setValue(messageWaitingPriorityCode);
    }

    @Hl7XmlMapping("acknowledgementDetail")
    public List<AcknowledgementDetailBean> getAcknowledgementDetails() {
        return this.acknowledgementDetails;
    }

    @Hl7XmlMapping("targetMessage/id")
    public Identifier getTargetMessage() {
        return this.targetMessage.getValue();
    }

    public void setTargetMessage(Identifier targetMessage) {
        this.targetMessage.setValue(targetMessage);
    }

    @Hl7XmlMapping("typeCode")
    public AcknowledgementType getAcknowledgementType() {
        return (AcknowledgementType) this.acknowledgementType.getValue();
    }

    public void setAcknowledgementType(AcknowledgementType acknowledgementType) {
        this.acknowledgementType.setValue(acknowledgementType);
    }
}
