package ca.infoway.messagebuilder.devtools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;

public class ValueHolder {

	private Identifier messageIdentifier;
    private Date messageTimestamp;
    private String securityToken;
    private ResponseMode responseType;
    private List<Identifier> conformanceProfileIdentifiers = Collections.synchronizedList(new ArrayList<Identifier>());
    private ProcessingID processingCode;
    private ProcessingMode processingMode;
	private AcknowledgementCondition desiredAcknowledgmentType;
    private ReceiverValueHolder receiver = new ReceiverValueHolder();
    private SenderValueHolder sender = new SenderValueHolder();

    public Identifier getMessageIdentifier() {
        return this.messageIdentifier;
    }
    public void setMessageIdentifier(Identifier messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
    }

    public Date getMessageTimestamp() {
        return this.messageTimestamp;
    }
    public void setMessageTimestamp(Date messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }
    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public ResponseMode getResponseType() {
        return this.responseType;
    }
    public void setResponseType(ResponseMode responseType) {
        this.responseType = responseType;
    }

    public List<Identifier> getConformanceProfileIdentifiers() {
        return this.conformanceProfileIdentifiers;
    }

    public ProcessingID getProcessingCode() {
        return this.processingCode;
    }
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode = processingCode;
    }

    public ProcessingMode getProcessingMode() {
		return this.processingMode;
	}
	public void setProcessingMode(ProcessingMode processingMode) {
		this.processingMode = processingMode;
	}

	public AcknowledgementCondition getDesiredAcknowledgmentType() {
        return this.desiredAcknowledgmentType;
    }
    public void setDesiredAcknowledgmentType(AcknowledgementCondition desiredAcknowledgmentType) {
        this.desiredAcknowledgmentType = desiredAcknowledgmentType;
    }

    public ReceiverValueHolder getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ReceiverValueHolder receiver) {
        this.receiver = receiver;
    }

    public SenderValueHolder getSender() {
        return this.sender;
    }
    public void setSender(SenderValueHolder sender) {
        this.sender = sender;
    }
}
