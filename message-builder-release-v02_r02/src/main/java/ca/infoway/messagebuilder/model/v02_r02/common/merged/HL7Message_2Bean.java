/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
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
import ca.infoway.messagebuilder.domainvalue.HL7StandardVersionCode;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>HL7Message</p>
 * 
 * <p>MCCI_MT102001CA.Message: HL7 Message</p>
 * 
 * <p><p>The root class of all messages.</p></p>
 * 
 * <p><p>Conveys information about the interaction and how it 
 * is to be processed</p></p>
 * 
 * <p>MCCI_MT002200CA.Message: HL7 Message</p>
 * 
 * <p><p>The root class of all messages.</p></p>
 * 
 * <p><p>Conveys information about the interaction and how it 
 * is to be processed</p></p>
 */
@Hl7PartTypeMapping({"MCCI_MT002200CA.Message","MCCI_MT102001CA.Message"})
@Hl7RootType
public class HL7Message_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ST securityToken = new STImpl();
    private LIST<II, Identifier> conformanceProfileIdentifiers = new LISTImpl<II, Identifier>(IIImpl.class);
    private CS desiredAcknowledgmentType = new CSImpl();
    private SenderBean sender;
    private ToBeRespondedToByBean respondTo;
    private CS hL7StandardVersion = new CSImpl();
    private List<RoutingInstructionLinesBean> attentionLine = new ArrayList<RoutingInstructionLinesBean>();
    private II messageIdentifier = new IIImpl();
    private II interactionType = new IIImpl();
    private CS responseType = new CSImpl();
    private TS messageTimestamp = new TSImpl();
    private ReceiverBean receiver;
    private CS processingCode = new CSImpl();
    private AcknowledgementBean acknowledgement;


    /**
     * <p>SecurityToken</p>
     * 
     * <p>H:Security Token</p>
     * 
     * <p><p>A locally-defined field used to maintain a session, 
     * identify a user, and/or perform some other function related 
     * to authenticating the message source.</p></p>
     * 
     * <p><p>Allows jurisdictions and applications to communicate 
     * authentication and session information. The attribute is 
     * optional because not all jurisdictions will require this 
     * capability.</p></p>
     */
    @Hl7XmlMapping({"securityText"})
    public String getSecurityToken() {
        return this.securityToken.getValue();
    }
    public void setSecurityToken(String securityToken) {
        this.securityToken.setValue(securityToken);
    }


    /**
     * <p>ConformanceProfileIdentifiers</p>
     * 
     * <p>F:Conformance Profile Identifiers</p>
     * 
     * <p><p>Identifies the conformance profile(s) this message 
     * complies with.</p></p>
     * 
     * <p><p>Indicates any additional validation that may be 
     * appropriate. Also influences what extensions can be 
     * processed.</p></p>
     */
    @Hl7XmlMapping({"profileId"})
    public List<Identifier> getConformanceProfileIdentifiers() {
        return this.conformanceProfileIdentifiers.rawList();
    }


    /**
     * <p>DesiredAcknowledgmentType</p>
     * 
     * <p>E:Desired Acknowledgment Type</p>
     * 
     * <p><p>Indicates how the message is expected to be 
     * acknowledged.</p></p>
     * 
     * <p><p>Provides support for immediate, deferred and polling 
     * mode and distinguishes which mode is desired. The attribute 
     * is therefore mandatory.</p></p>
     * 
     * <p><p>When using SOAP, this attribute MUST be set to NE 
     * (Never). (Accept acknowledgements are handled via the 
     * transport protocol, not HL7.)</p></p>
     */
    @Hl7XmlMapping({"acceptAckCode"})
    public AcknowledgementCondition getDesiredAcknowledgmentType() {
        return (AcknowledgementCondition) this.desiredAcknowledgmentType.getValue();
    }
    public void setDesiredAcknowledgmentType(AcknowledgementCondition desiredAcknowledgmentType) {
        this.desiredAcknowledgmentType.setValue(desiredAcknowledgmentType);
    }


    @Hl7XmlMapping({"sender"})
    public SenderBean getSender() {
        return this.sender;
    }
    public void setSender(SenderBean sender) {
        this.sender = sender;
    }


    @Hl7XmlMapping({"respondTo"})
    public ToBeRespondedToByBean getRespondTo() {
        return this.respondTo;
    }
    public void setRespondTo(ToBeRespondedToByBean respondTo) {
        this.respondTo = respondTo;
    }


    /**
     * <p>HL7StandardVersion</p>
     * 
     * <p>C: HL7 Standard Version</p>
     * 
     * <p><p>Indicates the version of the messaging standard being 
     * referenced.</p></p>
     * 
     * <p><p>soap:Header\wsa:To\ (portion between last '''\''' and 
     * second-last '''\''')</p></p>
     * 
     * <p><p>Needed to know how to validate message definition, 
     * CMET definition, vocabulary and other information and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"versionCode"})
    public HL7StandardVersionCode getHL7StandardVersion() {
        return (HL7StandardVersionCode) this.hL7StandardVersion.getValue();
    }
    public void setHL7StandardVersion(HL7StandardVersionCode hL7StandardVersion) {
        this.hL7StandardVersion.setValue(hL7StandardVersion);
    }


    @Hl7XmlMapping({"attentionLine"})
    public List<RoutingInstructionLinesBean> getAttentionLine() {
        return this.attentionLine;
    }


    /**
     * <p>MessageIdentifier</p>
     * 
     * <p>A:Message Identifier</p>
     * 
     * <p><p>A unique identifier for the message.</p></p>
     * 
     * <p><p>soap:Header\wsa:MessageID</p></p>
     * 
     * <p><p>Allows detection of duplicate messages, and allows 
     * tying acknowledgments to the message they are acknowledging. 
     * The attribute is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getMessageIdentifier() {
        return this.messageIdentifier.getValue();
    }
    public void setMessageIdentifier(Identifier messageIdentifier) {
        this.messageIdentifier.setValue(messageIdentifier);
    }


    /**
     * <p>InteractionType</p>
     * 
     * <p>B:Interaction Type</p>
     * 
     * <p><p>Indicates the interaction conveyed by this 
     * message.</p></p>
     * 
     * <p><p>soap:Header\wsa:Action (after '''urn:hl7-org:v3:''' 
     * and before the second underscore, if any)</p></p>
     * 
     * <p><p>Identifies what the receiving application should do, 
     * and how the message should be validated. The attribute is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"interactionId"})
    public Identifier getInteractionType() {
        return this.interactionType.getValue();
    }
    public void setInteractionType(Identifier interactionType) {
        this.interactionType.setValue(interactionType);
    }


    /**
     * <p>ResponseType</p>
     * 
     * <p>DA: Response Type</p>
     * 
     * <p><p>Identifies whether the response is desired immediately 
     * (as a direct acknowledgement), on a deferred basis (as a 
     * subsequent independent interaction) or via queue using 
     * polling.</p></p>
     * 
     * <p><p>soap:Header\wsa:Action (after the second underscore, 
     * if any, '''D''' otherwise)</p></p>
     * 
     * <p><p>Essential to determining receiver behavior and 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"responseModeCode"})
    public ResponseMode getResponseType() {
        return (ResponseMode) this.responseType.getValue();
    }
    public void setResponseType(ResponseMode responseType) {
        this.responseType.setValue(responseType);
    }


    /**
     * <p>MessageTimestamp</p>
     * 
     * <p>G:Message Timestamp</p>
     * 
     * <p><p>Indicates the time this particular message instance 
     * was constructed.</p></p>
     * 
     * <p><p>Allows identification of how current the information 
     * in a message is. Also provides a baseline for identifying 
     * the time-zone of other times within the message. As a 
     * result, the attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"creationTime"})
    public Date getMessageTimestamp() {
        return this.messageTimestamp.getValue();
    }
    public void setMessageTimestamp(Date messageTimestamp) {
        this.messageTimestamp.setValue(messageTimestamp);
    }


    @Hl7XmlMapping({"receiver"})
    public ReceiverBean getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ReceiverBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>ProcessingCode</p>
     * 
     * <p>DB:Processing Code</p>
     * 
     * <p><p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p></p>
     * 
     * <p><p>soap:Header\wsa:To\(portion between second-last 
     * '''\''' and third-last '''\''')</p></p>
     * 
     * <p><p>Indicates how the message should be handled and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"processingCode"})
    public ProcessingID getProcessingCode() {
        return (ProcessingID) this.processingCode.getValue();
    }
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode.setValue(processingCode);
    }


    @Hl7XmlMapping({"acknowledgement"})
    public AcknowledgementBean getAcknowledgement() {
        return this.acknowledgement;
    }
    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

}
