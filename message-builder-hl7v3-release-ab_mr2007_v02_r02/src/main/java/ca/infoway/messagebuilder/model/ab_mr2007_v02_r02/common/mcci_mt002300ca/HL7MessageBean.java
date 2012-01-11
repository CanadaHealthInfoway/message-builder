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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.mcci_mt002300ca;

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
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementCondition;
import ca.infoway.messagebuilder.domainvalue.ProcessingID;
import ca.infoway.messagebuilder.domainvalue.ResponseMode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.RoutingInstructionLinesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.ToBeRespondedToByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>HL7 Message</p>
 * 
 * <p><p>The root class of all messages.</p></p>
 * 
 * <p><p>Conveys information about the interaction and how it 
 * is to be processed</p></p>
 */
@Hl7PartTypeMapping({"MCCI_MT002300CA.Message"})
@Hl7RootType
public class HL7MessageBean<CAE> extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private II id = new IIImpl();
    private TS creationTime = new TSImpl();
    private List<ST> securityText = new ArrayList<ST>();
    private CS responseModeCode = new CSImpl();
    private II interactionId = new IIImpl();
    private LIST<II, Identifier> profileId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CS processingCode = new CSImpl();
    private CS acceptAckCode = new CSImpl();
    private ReceiverBean receiver;
    private ToBeRespondedToByBean respondTo;
    private SenderBean sender;
    private List<RoutingInstructionLinesBean> attentionLine = new ArrayList<RoutingInstructionLinesBean>();
    private AcknowledgementBean acknowledgement;
    private CAE controlActEvent;


    /**
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
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
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
    public Date getCreationTime() {
        return this.creationTime.getValue();
    }
    public void setCreationTime(Date creationTime) {
        this.creationTime.setValue(creationTime);
    }


    /**
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
    public List<String> getSecurityText() {
        return new RawListWrapper<ST, String>(securityText, STImpl.class);
    }


    /**
     * <p>DA: Response Type</p>
     * 
     * <p><p>Identifies whether the response is desired immediately 
     * (as a direct acknowledgement), on a deferred basis (as a 
     * subsequent independent interaction) or via queue using 
     * polling.</p></p>
     * 
     * <p><p>soap:Header\wsa:Action (after the second underscore, 
     * if any, &#226;&#128;&#156;D&#226;&#128;&#157; otherwise)</p></p>
     * 
     * <p><p>Essential to determining receiver behavior and 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"responseModeCode"})
    public ResponseMode getResponseModeCode() {
        return (ResponseMode) this.responseModeCode.getValue();
    }
    public void setResponseModeCode(ResponseMode responseModeCode) {
        this.responseModeCode.setValue(responseModeCode);
    }


    /**
     * <p>B:Interaction Type</p>
     * 
     * <p><p>Indicates the interaction conveyed by this 
     * message.</p></p>
     * 
     * <p><p>soap:Header\wsa:Action (after 
     * &#226;&#128;&#156;urn:hl7-org:v3:&#226;&#128;&#157; and 
     * before the second underscore, if any)</p></p>
     * 
     * <p><p>Identifies what the receiving application should do, 
     * and how the message should be validated. The attribute is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"interactionId"})
    public Identifier getInteractionId() {
        return this.interactionId.getValue();
    }
    public void setInteractionId(Identifier interactionId) {
        this.interactionId.setValue(interactionId);
    }


    /**
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
    public List<Identifier> getProfileId() {
        return this.profileId.rawList();
    }


    /**
     * <p>DB:Processing Code</p>
     * 
     * <p><p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p></p>
     * 
     * <p><p>soap:Header\wsa:To\(portion between second-last 
     * &#226;&#128;&#156;\&#226;&#128;&#157; and third-last 
     * &#226;&#128;&#156;\&#226;&#128;&#157;)</p></p>
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


    /**
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
    public AcknowledgementCondition getAcceptAckCode() {
        return (AcknowledgementCondition) this.acceptAckCode.getValue();
    }
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


    @Hl7XmlMapping({"acknowledgement"})
    public AcknowledgementBean getAcknowledgement() {
        return this.acknowledgement;
    }
    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }


    @Hl7XmlMapping({"controlActEvent"})
    public CAE getControlActEvent() {
        return this.controlActEvent;
    }
    public void setControlActEvent(CAE controlActEvent) {
        this.controlActEvent = controlActEvent;
    }

}
