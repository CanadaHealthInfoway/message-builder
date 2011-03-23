package ca.infoway.messagebuilder.model;

import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.HL7StandardVersionCode;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;

public abstract class NewBaseMessageBean extends MessagePartBean implements MessageBean {

    private static final long serialVersionUID = -510232459510481417L;

    protected MessageAttributesBean messageAttributes;

    public NewBaseMessageBean() {
        this.messageAttributes = new MessageAttributesBean();
    }

    public MessageAttributesBean getMessageAttributes() {
        return this.messageAttributes;
    }

    /**
	 * <p>Desired Acknowledgment Type.</p>
	 * 
	 * <p>Indicates how the message is expected to be acknowledged.</p>
	 * 
	 * <p>When using SOAP, this attribute MUST be set to NE (Never). (Accept 
	 * acknowledgements are handled via the transport protocol, not HL7.)</p>
	 * 
	 * <p>Provides support for immediate, deferred and polling mode and distinguishes 
	 * which mode is desired. The attribute is therefore mandatory.
	 */
    @Hl7XmlMapping("acceptAckCode")
    public AcknowledgementCondition getAcknowledgementCondition() {
        return messageAttributes.getAcknowledgementCondition();
    }

    public void setAcknowledgementCondition(AcknowledgementCondition acknowledgementCondition) {
        messageAttributes.setAcknowledgementCondition(acknowledgementCondition);
    }

    /**
	 * <p>Message Timestamp.</p>
	 * 
	 * <p>Indicates the time this particular message instance was constructed.</p>
	 * 
	 * <p>Allows identification of how current the information in a message is. Also 
	 * provides a baseline for identifying the time-zone of other times within the 
	 * message. As a result, the attribute is mandatory.</p>
	 * 
	 * @return
	 */
    @Hl7XmlMapping("creationTime")
    public Date getCreationDate() {
        return messageAttributes.getCreationDate();
    }

    public void setCreationDate(Date creationDate) {
        messageAttributes.setCreationDate(creationDate);
    }

    /**
	 * <p>A unique identifier for the message.
	 * 
	 * <p>Allows detection of duplicate messages, and allows tying acknowledgments to 
	 * the message they are acknowledging. The attribute is therefore mandatory.</p>
	 */
    @Hl7XmlMapping("id")
    public Identifier getMessageId() {
        return messageAttributes.getMessageId();
    }

    public void setMessageId(Identifier messageId) {
        messageAttributes.setMessageId(messageId);
    }

    /**
	 * <p>Processing Code.</p>
	 * 
	 * <p>Indicates whether this message is intended to be processed as production, 
	 * test or debug message.</p>
	 * 
	 * <p>Indicates how the message should be handled and is therefore mandatory.</p>
	 */
    @Hl7XmlMapping("processingCode")
    public ProcessingID getProcessingId() {
        return messageAttributes.getProcessingId();
    }

    public void setProcessingId(ProcessingID processingId) {
        messageAttributes.setProcessingId(processingId);
    }

    @Hl7XmlMapping("processingModeCode")
    public ProcessingMode getProcessingMode() {
        return messageAttributes.getProcessingMode();
    }

    public void setProcessingMode(ProcessingMode processingMode) {
        messageAttributes.setProcessingMode(processingMode);
    }

    @Hl7XmlMapping("receiver")
    public Receiver getMessageReceiver() {
        return messageAttributes.getReceiver();
    }

    public void setMessageReceiver(Receiver receiver) {
        messageAttributes.setReceiver(receiver);
    }

    /**
	 * <p>Response Type.</p>
	 * 
	 * <p>Identifies whether the application level response is desired immediately (as a 
	 * direct acknowledgement), on a deferred basis (as a subsequent independent 
	 * interaction) or via queue using polling.</p>
	 * 
	 * <p>Essential to determining receiver behavior and therefore mandatory.</p>
	 */
    @Hl7XmlMapping("responseModeCode")
    public ResponseMode getResponseModeCode() {
        return messageAttributes.getResponseModeCode();
    }

    public void setResponseModeCode(ResponseMode responseModeCode) {
        messageAttributes.setResponseModeCode(responseModeCode);
    }

    @Hl7XmlMapping("sender")
    public Sender getSender() {
        return messageAttributes.getSender();
    }

    public void setSender(Sender sender) {
        messageAttributes.setSender(sender);
    }

    /**
	 * <p>HL7 Standard Version.</p>
	 * 
	 * <p>Indicates the version of the messaging standard being referenced.</p>
	 * 
	 * <p>Needed to know how to validate message definition, CMET definition, vocabulary 
	 * and other information and is therefore mandatory.</p>
	 */
    @Hl7XmlMapping("versionCode")
    public HL7StandardVersionCode getVersionCode() {
        return messageAttributes.getVersionCode();
    }

    public void setVersionCode(HL7StandardVersionCode versionCode) {
        messageAttributes.setVersionCode(versionCode);
    }

    @Hl7XmlMapping("interactionId")
    public Identifier getInteractionId() {
        return messageAttributes.getInteractionId();
    }

    public void setInteractionId(Identifier interactionId) {
        this.messageAttributes.setInteractionId(interactionId);
    }

    @Hl7XmlMapping("profileId")
    public List<Identifier> getProfileId() {
        return this.messageAttributes.getProfileId();
    }
    
    public abstract ControlActEventBean getControlActEvent();
    public abstract AuthorBean getAuthor();
}
