/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.mcci_mt002200ca;

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
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.merged.AcknowledgementBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.merged.ReceiverBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.merged.SenderBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.merged.ToBeRespondedToByBean;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: HL7 Message</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 * 
 * <p>The root class of all messages.</p>
 */
@Hl7PartTypeMapping({"MCCI_MT002200CA.Message"})
@Hl7RootType
public class HL7MessageBean extends MessagePartBean {

    private static final long serialVersionUID = 20150328L;
    private II id = new IIImpl();
    private TS creationTime = new TSImpl();
    private ST securityText = new STImpl();
    private CS responseModeCode = new CSImpl();
    private II interactionId = new IIImpl();
    private LIST<II, Identifier> profileId = new LISTImpl<II, Identifier>(IIImpl.class);
    private CS processingCode = new CSImpl();
    private CS processingModeCode = new CSImpl();
    private CS acceptAckCode = new CSImpl();
    private ReceiverBean receiver;
    private ToBeRespondedToByBean respondTo;
    private SenderBean sender;
    private AcknowledgementBean acknowledgement;


    /**
     * <p>Business Name: A:Message Identifier</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:MessageID</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     * 
     * <p>A unique identifier for the message.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Message Identifier</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:MessageID</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     * 
     * <p>A unique identifier for the message.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: G:Message Timestamp</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.creationTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows identification of how current the information in a 
     * message is. Also provides a baseline for identifying the 
     * time-zone of other times within the message. As a result, 
     * the attribute is mandatory.</p>
     * 
     * <p>Indicates the time this particular message instance was 
     * constructed.</p>
     */
    @Hl7XmlMapping({"creationTime"})
    public Date getCreationTime() {
        return this.creationTime.getValue();
    }

    /**
     * <p>Business Name: G:Message Timestamp</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.creationTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows identification of how current the information in a 
     * message is. Also provides a baseline for identifying the 
     * time-zone of other times within the message. As a result, 
     * the attribute is mandatory.</p>
     * 
     * <p>Indicates the time this particular message instance was 
     * constructed.</p>
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime.setValue(creationTime);
    }


    /**
     * <p>Business Name: H:Security Token</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.securityText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows jurisdictions and applications to communicate 
     * authentication and session information. The attribute is 
     * optional because not all jurisdictions will require this 
     * capability.</p>
     * 
     * <p>A locally-defined field used to maintain a session, 
     * identify a user, and/or perform some other function related 
     * to authenticating the message source.</p>
     */
    @Hl7XmlMapping({"securityText"})
    public String getSecurityText() {
        return this.securityText.getValue();
    }

    /**
     * <p>Business Name: H:Security Token</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.securityText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows jurisdictions and applications to communicate 
     * authentication and session information. The attribute is 
     * optional because not all jurisdictions will require this 
     * capability.</p>
     * 
     * <p>A locally-defined field used to maintain a session, 
     * identify a user, and/or perform some other function related 
     * to authenticating the message source.</p>
     */
    public void setSecurityText(String securityText) {
        this.securityText.setValue(securityText);
    }


    /**
     * <p>Business Name: DA: Response Type</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.responseModeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:Action (after the second underscore, if 
     * any, 'D' otherwise)</p>
     * 
     * <p>Essential to determining receiver behavior and therefore 
     * mandatory.</p>
     * 
     * <p>Identifies whether the response is desired immediately 
     * (as a direct acknowledgement), on a deferred basis (as a 
     * subsequent independent interaction) or via queue using 
     * polling.</p>
     */
    @Hl7XmlMapping({"responseModeCode"})
    public ResponseMode getResponseModeCode() {
        return (ResponseMode) this.responseModeCode.getValue();
    }

    /**
     * <p>Business Name: DA: Response Type</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.responseModeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:Action (after the second underscore, if 
     * any, 'D' otherwise)</p>
     * 
     * <p>Essential to determining receiver behavior and therefore 
     * mandatory.</p>
     * 
     * <p>Identifies whether the response is desired immediately 
     * (as a direct acknowledgement), on a deferred basis (as a 
     * subsequent independent interaction) or via queue using 
     * polling.</p>
     */
    public void setResponseModeCode(ResponseMode responseModeCode) {
        this.responseModeCode.setValue(responseModeCode);
    }


    /**
     * <p>Business Name: B:Interaction Type</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.interactionId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:Action (after 'urn:hl7-org:v3:' and 
     * before the second underscore, if any)</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     */
    @Hl7XmlMapping({"interactionId"})
    public Identifier getInteractionId() {
        return this.interactionId.getValue();
    }

    /**
     * <p>Business Name: B:Interaction Type</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.interactionId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:Action (after 'urn:hl7-org:v3:' and 
     * before the second underscore, if any)</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     */
    public void setInteractionId(Identifier interactionId) {
        this.interactionId.setValue(interactionId);
    }


    /**
     * <p>Business Name: F:Conformance Profile Identifiers</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.profileId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     * 
     * <p>Indicates any additional validation that may be 
     * appropriate. Also influences what extensions can be 
     * processed.</p>
     * 
     * <p>Identifies the conformance profile(s) this message 
     * complies with.</p>
     */
    @Hl7XmlMapping({"profileId"})
    public List<Identifier> getProfileId() {
        return this.profileId.rawList();
    }


    /**
     * <p>Business Name: DB:Processing Code</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.processingCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:To\(portion between second-last '\' and 
     * third-last '\')</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     */
    @Hl7XmlMapping({"processingCode"})
    public ProcessingID getProcessingCode() {
        return (ProcessingID) this.processingCode.getValue();
    }

    /**
     * <p>Business Name: DB:Processing Code</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.processingCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:To\(portion between second-last '\' and 
     * third-last '\')</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     */
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode.setValue(processingCode);
    }


    /**
     * <p>Business Name: Processing Mode</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.processingModeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes the mode of processing. For example current 
     * processing, archive mode, initial load mode, restore from 
     * archive mode.</p>
     * 
     * <p>This attribute defines whether the message is being sent 
     * in current processing, archive mode, initial load mode, 
     * restore from archive mode,</p>
     */
    @Hl7XmlMapping({"processingModeCode"})
    public ProcessingMode getProcessingModeCode() {
        return (ProcessingMode) this.processingModeCode.getValue();
    }

    /**
     * <p>Business Name: Processing Mode</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.processingModeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes the mode of processing. For example current 
     * processing, archive mode, initial load mode, restore from 
     * archive mode.</p>
     * 
     * <p>This attribute defines whether the message is being sent 
     * in current processing, archive mode, initial load mode, 
     * restore from archive mode,</p>
     */
    public void setProcessingModeCode(ProcessingMode processingModeCode) {
        this.processingModeCode.setValue(processingModeCode);
    }


    /**
     * <p>Business Name: E:Desired Acknowledgment Type</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.acceptAckCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for immediate, deferred and polling mode 
     * and distinguishes which mode is desired. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>When using SOAP, this attribute MUST be set to NE 
     * (Never). (Accept acknowledgements are handled via the 
     * transport protocol, not HL7.)</p>
     * 
     * <p>Indicates how the message is expected to be 
     * acknowledged.</p>
     */
    @Hl7XmlMapping({"acceptAckCode"})
    public AcknowledgementCondition getAcceptAckCode() {
        return (AcknowledgementCondition) this.acceptAckCode.getValue();
    }

    /**
     * <p>Business Name: E:Desired Acknowledgment Type</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Message.acceptAckCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides support for immediate, deferred and polling mode 
     * and distinguishes which mode is desired. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>When using SOAP, this attribute MUST be set to NE 
     * (Never). (Accept acknowledgements are handled via the 
     * transport protocol, not HL7.)</p>
     * 
     * <p>Indicates how the message is expected to be 
     * acknowledged.</p>
     */
    public void setAcceptAckCode(AcknowledgementCondition acceptAckCode) {
        this.acceptAckCode.setValue(acceptAckCode);
    }


    /**
     * <p>Relationship: MCCI_MT002200CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"receiver"})
    public ReceiverBean getReceiver() {
        return this.receiver;
    }

    /**
     * <p>Relationship: MCCI_MT002200CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setReceiver(ReceiverBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>Relationship: MCCI_MT002200CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"respondTo"})
    public ToBeRespondedToByBean getRespondTo() {
        return this.respondTo;
    }

    /**
     * <p>Relationship: MCCI_MT002200CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRespondTo(ToBeRespondedToByBean respondTo) {
        this.respondTo = respondTo;
    }


    /**
     * <p>Relationship: MCCI_MT002200CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"sender"})
    public SenderBean getSender() {
        return this.sender;
    }

    /**
     * <p>Relationship: MCCI_MT002200CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSender(SenderBean sender) {
        this.sender = sender;
    }


    /**
     * <p>Relationship: MCCI_MT002200CA.Message.acknowledgement</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"acknowledgement"})
    public AcknowledgementBean getAcknowledgement() {
        return this.acknowledgement;
    }

    /**
     * <p>Relationship: MCCI_MT002200CA.Message.acknowledgement</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

}
