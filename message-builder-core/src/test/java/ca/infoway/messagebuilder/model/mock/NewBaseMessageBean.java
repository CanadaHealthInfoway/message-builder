package ca.infoway.messagebuilder.model.mock;

import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;
import ca.infoway.messagebuilder.model.InteractionBean;
import ca.infoway.messagebuilder.model.MessagePartBean;

public abstract class NewBaseMessageBean extends MessagePartBean implements InteractionBean {

    private static final long serialVersionUID = -510232459510481417L;

    private II messageIdentifier = new IIImpl();
    private TS messageTimestamp = new TSImpl();
    private ST securityToken = new STImpl();
    private CS responseType = new CSImpl();
    private II interactionType = new IIImpl();
    private LIST<II, Identifier> conformanceProfileIdentifiers = new LISTImpl<II, Identifier>(IIImpl.class);
    private CS processingCode = new CSImpl();
    private CS processingMode = new CSImpl();
    private CS desiredAcknowledgmentType = new CSImpl();
    private Receiver receiver;
    private Sender sender;

    @Hl7XmlMapping({"id"})
    public Identifier getMessageIdentifier() {
        return this.messageIdentifier.getValue();
    }
    public void setMessageIdentifier(Identifier messageIdentifier) {
        this.messageIdentifier.setValue(messageIdentifier);
    }

    @Hl7XmlMapping({"creationTime"})
    public Date getMessageTimestamp() {
        return this.messageTimestamp.getValue();
    }
    public void setMessageTimestamp(Date messageTimestamp) {
        this.messageTimestamp.setValue(messageTimestamp);
    }

    @Hl7XmlMapping({"securityText"})
    public String getSecurityToken() {
        return this.securityToken.getValue();
    }
    public void setSecurityToken(String securityToken) {
        this.securityToken.setValue(securityToken);
    }

    @Hl7XmlMapping({"responseModeCode"})
    public ResponseMode getResponseType() {
        return (ResponseMode) this.responseType.getValue();
    }
    public void setResponseType(ResponseMode responseType) {
        this.responseType.setValue(responseType);
    }

    @Hl7XmlMapping({"interactionId"})
    public Identifier getInteractionType() {
        return this.interactionType.getValue();
    }
    public void setInteractionType(Identifier interactionType) {
        this.interactionType.setValue(interactionType);
    }

    @Hl7XmlMapping({"profileId"})
    public List<Identifier> getConformanceProfileIdentifiers() {
        return this.conformanceProfileIdentifiers.rawList();
    }

    @Hl7XmlMapping({"processingCode"})
    public ProcessingID getProcessingCode() {
        return (ProcessingID) this.processingCode.getValue();
    }
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode.setValue(processingCode);
    }

    @Hl7XmlMapping({"acceptAckCode"})
    public AcknowledgementCondition getDesiredAcknowledgmentType() {
        return (AcknowledgementCondition) this.desiredAcknowledgmentType.getValue();
    }
    public void setDesiredAcknowledgmentType(AcknowledgementCondition desiredAcknowledgmentType) {
        this.desiredAcknowledgmentType.setValue(desiredAcknowledgmentType);
    }

    @Hl7XmlMapping({"receiver"})
    public Receiver getReceiver() {
        return this.receiver;
    }
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Hl7XmlMapping({"sender"})
    public Sender getSender() {
        return this.sender;
    }
    public void setSender(Sender sender) {
        this.sender = sender;
    }
    @Hl7XmlMapping({"processingModeCode"})
	public ProcessingMode getProcessingMode() {
		return (ProcessingMode) this.processingMode.getValue();
	}
	public void setProcessingMode(ProcessingMode processingMode) {
        this.processingMode.setValue(processingMode);
	}
}
