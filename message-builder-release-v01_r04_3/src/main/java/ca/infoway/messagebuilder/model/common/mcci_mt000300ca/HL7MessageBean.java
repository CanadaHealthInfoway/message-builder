/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.mcci_mt000300ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.HL7StandardVersionCode;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.AcknowledgementBean;
import ca.infoway.messagebuilder.model.merged.ReceiverBean;
import ca.infoway.messagebuilder.model.merged.RoutingInstructionLinesBean;
import ca.infoway.messagebuilder.model.merged.SenderBean;
import ca.infoway.messagebuilder.model.merged.ToBeRespondedToByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>HL7 Message</p>
 * 
 * <p>The root class of all messages.</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 */
@Hl7PartTypeMapping({"MCCI_MT000300CA.Message"})
@Hl7RootType
public class HL7MessageBean<CAP> extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II messageIdentifier = new IIImpl();
    private TS messageTimestamp = new TSImpl();
    private ST securityToken = new STImpl();
    private CS hL7StandardVersion = new CSImpl();
    private II interactionType = new IIImpl();
    private SET<II, Identifier> conformanceProfileIdentifiers = new SETImpl<II, Identifier>(IIImpl.class);
    private CS processingCode = new CSImpl();
    private CS desiredAcknowledgmentType = new CSImpl();
    private ReceiverBean receiver;
    private ToBeRespondedToByBean respondTo;
    private SenderBean sender;
    private List<RoutingInstructionLinesBean> attentionLine = new ArrayList<RoutingInstructionLinesBean>();
    private AcknowledgementBean acknowledgement;
    private CAP controlActProcess;

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

    @Hl7XmlMapping({"versionCode"})
    public HL7StandardVersionCode getHL7StandardVersion() {
        return (HL7StandardVersionCode) this.hL7StandardVersion.getValue();
    }
    public void setHL7StandardVersion(HL7StandardVersionCode hL7StandardVersion) {
        this.hL7StandardVersion.setValue(hL7StandardVersion);
    }

    @Hl7XmlMapping({"interactionId"})
    public Identifier getInteractionType() {
        return this.interactionType.getValue();
    }
    public void setInteractionType(Identifier interactionType) {
        this.interactionType.setValue(interactionType);
    }

    @Hl7XmlMapping({"profileId"})
    public Set<Identifier> getConformanceProfileIdentifiers() {
        return this.conformanceProfileIdentifiers.rawSet();
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
    public ReceiverBean getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ReceiverBean receiver) {
        this.receiver = receiver;
    }

    @Hl7XmlMapping({"respondTo"})
    public ToBeRespondedToByBean getRespondTo() {
        return this.respondTo;
    }
    public void setRespondTo(ToBeRespondedToByBean respondTo) {
        this.respondTo = respondTo;
    }

    @Hl7XmlMapping({"sender"})
    public SenderBean getSender() {
        return this.sender;
    }
    public void setSender(SenderBean sender) {
        this.sender = sender;
    }

    @Hl7XmlMapping({"attentionLine"})
    public List<RoutingInstructionLinesBean> getAttentionLine() {
        return this.attentionLine;
    }

    @Hl7XmlMapping({"acknowledgement"})
    public AcknowledgementBean getAcknowledgement() {
        return this.acknowledgement;
    }
    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

    @Hl7XmlMapping({"controlActProcess"})
    public CAP getControlActProcess() {
        return this.controlActProcess;
    }
    public void setControlActProcess(CAP controlActProcess) {
        this.controlActProcess = controlActProcess;
    }

}
