/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

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
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ProcessingMode;
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
 * <p>The root class of all messages.</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 * 
 * <p>MCCI_MT002200CA.Message: HL7 Message</p>
 * 
 * <p>The root class of all messages.</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 */
@Hl7PartTypeMapping({"MCCI_MT002200CA.Message","MCCI_MT102001CA.Message"})
@Hl7RootType
public class HL7Message_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private TS creationTime = new TSImpl();
    private ST securityText = new STImpl();
    private CS responseModeCode = new CSImpl();
    private II interactionId = new IIImpl();
    private LIST<II, Identifier> profileId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CS processingCode = new CSImpl();
    private CS acceptAckCode = new CSImpl();
    private ReceiverBean receiver;
    private ToBeRespondedToByBean respondTo;
    private SenderBean sender;
    private List<RoutingInstructionLinesBean> attentionLine = new ArrayList<RoutingInstructionLinesBean>();
    private CS processingModeCode = new CSImpl();
    private AcknowledgementBean acknowledgement;


    /**
     * <p>MessageIdentifier</p>
     * 
     * <p>A:Message Identifier</p>
     * 
     * <p>A unique identifier for the message.</p>
     * 
     * <p>soap:Header\wsa:MessageID</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>MessageIdentifier</p>
     * 
     * <p>A:Message Identifier</p>
     * 
     * <p>A unique identifier for the message.</p>
     * 
     * <p>soap:Header\wsa:MessageID</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>MessageTimestamp</p>
     * 
     * <p>G:Message Timestamp</p>
     * 
     * <p>Indicates the time this particular message instance was 
     * constructed.</p>
     * 
     * <p>Allows identification of how current the information in a 
     * message is. Also provides a baseline for identifying the 
     * time-zone of other times within the message. As a result, 
     * the attribute is mandatory.</p>
     */
    @Hl7XmlMapping({"creationTime"})
    public Date getCreationTime() {
        return this.creationTime.getValue();
    }

    /**
     * <p>MessageTimestamp</p>
     * 
     * <p>G:Message Timestamp</p>
     * 
     * <p>Indicates the time this particular message instance was 
     * constructed.</p>
     * 
     * <p>Allows identification of how current the information in a 
     * message is. Also provides a baseline for identifying the 
     * time-zone of other times within the message. As a result, 
     * the attribute is mandatory.</p>
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime.setValue(creationTime);
    }


    /**
     * <p>SecurityToken</p>
     * 
     * <p>H:Security Token</p>
     * 
     * <p>A locally-defined field used to maintain a session, 
     * identify a user, and/or perform some other function related 
     * to authenticating the message source.</p>
     * 
     * <p>Allows jurisdictions and applications to communicate 
     * authentication and session information. The attribute is 
     * optional because not all jurisdictions will require this 
     * capability.</p>
     */
    @Hl7XmlMapping({"securityText"})
    public String getSecurityText() {
        return this.securityText.getValue();
    }

    /**
     * <p>SecurityToken</p>
     * 
     * <p>H:Security Token</p>
     * 
     * <p>A locally-defined field used to maintain a session, 
     * identify a user, and/or perform some other function related 
     * to authenticating the message source.</p>
     * 
     * <p>Allows jurisdictions and applications to communicate 
     * authentication and session information. The attribute is 
     * optional because not all jurisdictions will require this 
     * capability.</p>
     */
    public void setSecurityText(String securityText) {
        this.securityText.setValue(securityText);
    }


    /**
     * <p>ResponseType</p>
     * 
     * <p>DA: Response Type</p>
     * 
     * <p>Identifies whether the response is desired immediately 
     * (as a direct acknowledgement), on a deferred basis (as a 
     * subsequent independent interaction) or via queue using 
     * polling.</p>
     * 
     * <p>soap:Header\wsa:Action (after the second underscore, if 
     * any, D otherwise)</p>
     * 
     * <p>Essential to determining receiver behavior and therefore 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"responseModeCode"})
    public ResponseMode getResponseModeCode() {
        return (ResponseMode) this.responseModeCode.getValue();
    }

    /**
     * <p>ResponseType</p>
     * 
     * <p>DA: Response Type</p>
     * 
     * <p>Identifies whether the response is desired immediately 
     * (as a direct acknowledgement), on a deferred basis (as a 
     * subsequent independent interaction) or via queue using 
     * polling.</p>
     * 
     * <p>soap:Header\wsa:Action (after the second underscore, if 
     * any, D otherwise)</p>
     * 
     * <p>Essential to determining receiver behavior and therefore 
     * mandatory.</p>
     */
    public void setResponseModeCode(ResponseMode responseModeCode) {
        this.responseModeCode.setValue(responseModeCode);
    }


    /**
     * <p>InteractionType</p>
     * 
     * <p>B:Interaction Type</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     * 
     * <p>soap:Header\wsa:Action (after urn:hl7-org:v3: and before 
     * the second underscore, if any)</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     */
    @Hl7XmlMapping({"interactionId"})
    public Identifier getInteractionId() {
        return this.interactionId.getValue();
    }

    /**
     * <p>InteractionType</p>
     * 
     * <p>B:Interaction Type</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     * 
     * <p>soap:Header\wsa:Action (after urn:hl7-org:v3: and before 
     * the second underscore, if any)</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     */
    public void setInteractionId(Identifier interactionId) {
        this.interactionId.setValue(interactionId);
    }


    /**
     * <p>ConformanceProfileIdentifiers</p>
     * 
     * <p>F:Conformance Profile Identifiers</p>
     * 
     * <p>Identifies the conformance profile(s) this message 
     * complies with.</p>
     * 
     * <p>Indicates any additional validation that may be 
     * appropriate. Also influences what extensions can be 
     * processed.</p>
     */
    @Hl7XmlMapping({"profileId"})
    public List<Identifier> getProfileId() {
        return this.profileId.rawList();
    }


    /**
     * <p>ProcessingCode</p>
     * 
     * <p>DB:Processing Code</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>soap:Header\wsa:To\(portion between second-last \ and 
     * third-last \)</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     */
    @Hl7XmlMapping({"processingCode"})
    public ProcessingID getProcessingCode() {
        return (ProcessingID) this.processingCode.getValue();
    }

    /**
     * <p>ProcessingCode</p>
     * 
     * <p>DB:Processing Code</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>soap:Header\wsa:To\(portion between second-last \ and 
     * third-last \)</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     */
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode.setValue(processingCode);
    }


    /**
     * <p>DesiredAcknowledgmentType</p>
     * 
     * <p>E:Desired Acknowledgment Type</p>
     * 
     * <p>Indicates how the message is expected to be 
     * acknowledged.</p>
     * 
     * <p>Provides support for immediate, deferred and polling mode 
     * and distinguishes which mode is desired. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>When using SOAP, this attribute MUST be set to NE 
     * (Never). (Accept acknowledgements are handled via the 
     * transport protocol, not HL7.)</p>
     */
    @Hl7XmlMapping({"acceptAckCode"})
    public AcknowledgementCondition getAcceptAckCode() {
        return (AcknowledgementCondition) this.acceptAckCode.getValue();
    }

    /**
     * <p>DesiredAcknowledgmentType</p>
     * 
     * <p>E:Desired Acknowledgment Type</p>
     * 
     * <p>Indicates how the message is expected to be 
     * acknowledged.</p>
     * 
     * <p>Provides support for immediate, deferred and polling mode 
     * and distinguishes which mode is desired. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>When using SOAP, this attribute MUST be set to NE 
     * (Never). (Accept acknowledgements are handled via the 
     * transport protocol, not HL7.)</p>
     */
    public void setAcceptAckCode(AcknowledgementCondition acceptAckCode) {
        this.acceptAckCode.setValue(acceptAckCode);
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


    /**
     * <p>ProcessingMode</p>
     * 
     * <p>Processing Mode</p>
     * 
     * <p>This attribute defines whether the message is being sent 
     * in current processing, archive mode, initial load mode, 
     * restore from archive mode,</p>
     * 
     * <p>Describes the mode of processing. For example current 
     * processing, archive mode, initial load mode, restore from 
     * archive mode.</p>
     */
    @Hl7XmlMapping({"processingModeCode"})
    public ProcessingMode getProcessingModeCode() {
        return (ProcessingMode) this.processingModeCode.getValue();
    }

    /**
     * <p>ProcessingMode</p>
     * 
     * <p>Processing Mode</p>
     * 
     * <p>This attribute defines whether the message is being sent 
     * in current processing, archive mode, initial load mode, 
     * restore from archive mode,</p>
     * 
     * <p>Describes the mode of processing. For example current 
     * processing, archive mode, initial load mode, restore from 
     * archive mode.</p>
     */
    public void setProcessingModeCode(ProcessingMode processingModeCode) {
        this.processingModeCode.setValue(processingModeCode);
    }


    @Hl7XmlMapping({"acknowledgement"})
    public AcknowledgementBean getAcknowledgement() {
        return this.acknowledgement;
    }

    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

}
