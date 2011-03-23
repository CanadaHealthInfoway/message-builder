package ca.infoway.messagebuilder.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7BusinessName;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.HL7StandardVersionCode;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;

public class MessageAttributesBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -7095729172039748695L;

    @Hl7BusinessName("messageIdentifier")
    private II messageId = new IIImpl();

    @Hl7BusinessName("messageTimestamp")
    private TS creationDate = new TSImpl();

    @Hl7BusinessName("processingCode")
    private CD processingId = new CDImpl();

    @Hl7BusinessName("responseType")
    private CD responseModeCode = new CDImpl();

    private CD processingMode = new CDImpl();

    @Hl7BusinessName("desiredAcknowledgmentType")
    private CD acknowledgementCondition = new CDImpl();

    private Receiver receiver;

    private Sender sender;

    private CD versionCode = new CDImpl();

    @Hl7BusinessName("interactionType")
    private II interactionId = new IIImpl();

    @Hl7BusinessName("conformanceProfileIdentifiers")
    private LIST<II, Identifier> profileId = new LISTImpl<II, Identifier>(IIImpl.class);

    @Hl7XmlMapping("id")
    public Identifier getMessageId() {
        return this.messageId.getValue();
    }

    public void setMessageId(Identifier messageId) {
        this.messageId.setValue(messageId);
    }

    @Hl7XmlMapping("creationTime")
    public Date getCreationDate() {
        return this.creationDate.getValue();
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate.setValue(creationDate);
    }

    @Hl7XmlMapping("processingCode")
    public ProcessingID getProcessingId() {
        return (ProcessingID) this.processingId.getValue();
    }

    public void setProcessingId(ProcessingID processingId) {
        this.processingId.setValue(processingId);
    }

    @Hl7XmlMapping("processingModeCode")
    public ProcessingMode getProcessingMode() {
        return (ProcessingMode) this.processingMode.getValue();
    }

    public void setProcessingMode(ProcessingMode processingMode) {
        this.processingMode.setValue(processingMode);
    }

    @Hl7XmlMapping("acceptAckCode")
    public AcknowledgementCondition getAcknowledgementCondition() {
        return (AcknowledgementCondition) this.acknowledgementCondition.getValue();
    }

    public void setAcknowledgementCondition(AcknowledgementCondition acknowledgementCondition) {
        this.acknowledgementCondition.setValue(acknowledgementCondition);
    }

    @Hl7XmlMapping("receiver")
    public Receiver getReceiver() {
        return this.receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Hl7XmlMapping("sender")
    public Sender getSender() {
        return this.sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @Hl7XmlMapping("responseModeCode")
    public ResponseMode getResponseModeCode() {
        return (ResponseMode) this.responseModeCode.getValue();
    }

    public void setResponseModeCode(ResponseMode responseModeCode) {
        this.responseModeCode.setValue(responseModeCode);
    }

    public List<Identifier> getProfileId() {
        return this.profileId.rawList();
    }

    public HL7StandardVersionCode getVersionCode() {
        return (HL7StandardVersionCode) this.versionCode.getValue();
    }

    public void setVersionCode(HL7StandardVersionCode versionCode) {
        this.versionCode.setValue(versionCode);
    }

    public Identifier getInteractionId() {
        return this.interactionId.getValue();
    }

    public void setInteractionId(Identifier interactionId) {
        this.interactionId.setValue(interactionId);
    }
}
