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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged;

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
 * <p>Business Name: HL7Message</p>
 * 
 * <p>MCCI_MT002300CA.Message: HL7 Message</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 * 
 * <p>The root class of all messages.</p>
 * 
 * <p>MCCI_MT002100CA.Message: HL7 Message</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 * 
 * <p>The root class of all messages.</p>
 */
@Hl7PartTypeMapping({"MCCI_MT002100CA.Message","MCCI_MT002300CA.Message"})
@Hl7RootType
public class HL7Message_1Bean<CAE> extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
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
    private AcknowledgementBean acknowledgement;
    private CAE controlActEvent;
    private CS processingModeCode = new CSImpl();


    /**
     * <p>Business Name: MessageIdentifier</p>
     * 
     * <p>Un-merged Business Name: MessageIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.id</p>
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
     * 
     * <p>Un-merged Business Name: MessageIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.id</p>
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
     * <p>Business Name: MessageIdentifier</p>
     * 
     * <p>Un-merged Business Name: MessageIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.id</p>
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
     * 
     * <p>Un-merged Business Name: MessageIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.id</p>
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
     * <p>Business Name: MessageTimestamp</p>
     * 
     * <p>Un-merged Business Name: MessageTimestamp</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.creationTime</p>
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
     * 
     * <p>Un-merged Business Name: MessageTimestamp</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.creationTime</p>
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
     * <p>Business Name: MessageTimestamp</p>
     * 
     * <p>Un-merged Business Name: MessageTimestamp</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.creationTime</p>
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
     * 
     * <p>Un-merged Business Name: MessageTimestamp</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.creationTime</p>
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
     * <p>Business Name: SecurityToken</p>
     * 
     * <p>Un-merged Business Name: SecurityToken</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.securityText</p>
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
     * 
     * <p>Un-merged Business Name: SecurityToken</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.securityText</p>
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
     * <p>Business Name: SecurityToken</p>
     * 
     * <p>Un-merged Business Name: SecurityToken</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.securityText</p>
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
     * 
     * <p>Un-merged Business Name: SecurityToken</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.securityText</p>
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
     * <p>Business Name: ResponseType</p>
     * 
     * <p>Un-merged Business Name: ResponseType</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.responseModeCode</p>
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
     * 
     * <p>Un-merged Business Name: ResponseType</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.responseModeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:Action (after the second underscore, if 
     * any, 'D' otherwise)</p>
     * 
     * <p>Essential to determining receiver behavior and therefore 
     * mandatory.</p>
     * 
     * <p>Identifies whether the application level response is 
     * desired immediately (as a direct acknowledgement), on a 
     * deferred basis (as a subsequent independent interaction) or 
     * via queue using polling.</p>
     */
    @Hl7XmlMapping({"responseModeCode"})
    public ResponseMode getResponseModeCode() {
        return (ResponseMode) this.responseModeCode.getValue();
    }

    /**
     * <p>Business Name: ResponseType</p>
     * 
     * <p>Un-merged Business Name: ResponseType</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.responseModeCode</p>
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
     * 
     * <p>Un-merged Business Name: ResponseType</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.responseModeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:Action (after the second underscore, if 
     * any, 'D' otherwise)</p>
     * 
     * <p>Essential to determining receiver behavior and therefore 
     * mandatory.</p>
     * 
     * <p>Identifies whether the application level response is 
     * desired immediately (as a direct acknowledgement), on a 
     * deferred basis (as a subsequent independent interaction) or 
     * via queue using polling.</p>
     */
    public void setResponseModeCode(ResponseMode responseModeCode) {
        this.responseModeCode.setValue(responseModeCode);
    }


    /**
     * <p>Business Name: InteractionType</p>
     * 
     * <p>Un-merged Business Name: InteractionType</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.interactionId</p>
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
     * 
     * <p>Un-merged Business Name: InteractionType</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.interactionId</p>
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
     * <p>Business Name: InteractionType</p>
     * 
     * <p>Un-merged Business Name: InteractionType</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.interactionId</p>
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
     * 
     * <p>Un-merged Business Name: InteractionType</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.interactionId</p>
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
     * <p>Business Name: ConformanceProfileIdentifiers</p>
     * 
     * <p>Un-merged Business Name: ConformanceProfileIdentifiers</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.profileId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     * 
     * <p>Indicates any additional validation that may be 
     * appropriate. Also influences what extensions can be 
     * processed.</p>
     * 
     * <p>Identifies the conformance profile(s) this message 
     * complies with.</p>
     * 
     * <p>Un-merged Business Name: ConformanceProfileIdentifiers</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.profileId</p>
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
     * <p>Business Name: ProcessingCode</p>
     * 
     * <p>Un-merged Business Name: ProcessingCode</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.processingCode</p>
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
     * 
     * <p>Un-merged Business Name: ProcessingCode</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.processingCode</p>
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
     * <p>Business Name: ProcessingCode</p>
     * 
     * <p>Un-merged Business Name: ProcessingCode</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.processingCode</p>
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
     * 
     * <p>Un-merged Business Name: ProcessingCode</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.processingCode</p>
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
     * <p>Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Un-merged Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.acceptAckCode</p>
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
     * 
     * <p>Un-merged Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.acceptAckCode</p>
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
     * <p>Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Un-merged Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.acceptAckCode</p>
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
     * 
     * <p>Un-merged Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.acceptAckCode</p>
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"receiver"})
    public ReceiverBean getReceiver() {
        return this.receiver;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setReceiver(ReceiverBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"respondTo"})
    public ToBeRespondedToByBean getRespondTo() {
        return this.respondTo;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRespondTo(ToBeRespondedToByBean respondTo) {
        this.respondTo = respondTo;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"sender"})
    public SenderBean getSender() {
        return this.sender;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSender(SenderBean sender) {
        this.sender = sender;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.attentionLine</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.attentionLine</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-5)</p>
     */
    @Hl7XmlMapping({"attentionLine"})
    public List<RoutingInstructionLinesBean> getAttentionLine() {
        return this.attentionLine;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.acknowledgement</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"acknowledgement"})
    public AcknowledgementBean getAcknowledgement() {
        return this.acknowledgement;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.acknowledgement</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"controlActEvent"})
    public CAE getControlActEvent() {
        return this.controlActEvent;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Message.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setControlActEvent(CAE controlActEvent) {
        this.controlActEvent = controlActEvent;
    }


    /**
     * <p>Business Name: ProcessingMode</p>
     * 
     * <p>Un-merged Business Name: ProcessingMode</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.processingModeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes the mode of processing. For example current 
     * processing, archive mode, initial load mode, restore from 
     * archive mode.</p>
     * 
     * <p>This attribute defines whether the message is being sent 
     * in current processing, archive mode, initial load mode, 
     * restore from archive mode</p>
     */
    @Hl7XmlMapping({"processingModeCode"})
    public ProcessingMode getProcessingModeCode() {
        return (ProcessingMode) this.processingModeCode.getValue();
    }

    /**
     * <p>Business Name: ProcessingMode</p>
     * 
     * <p>Un-merged Business Name: ProcessingMode</p>
     * 
     * <p>Relationship: MCCI_MT002100CA.Message.processingModeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes the mode of processing. For example current 
     * processing, archive mode, initial load mode, restore from 
     * archive mode.</p>
     * 
     * <p>This attribute defines whether the message is being sent 
     * in current processing, archive mode, initial load mode, 
     * restore from archive mode</p>
     */
    public void setProcessingModeCode(ProcessingMode processingModeCode) {
        this.processingModeCode.setValue(processingModeCode);
    }

}
