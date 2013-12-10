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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.merged;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.AcknowledgementBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.ReceiverBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.RoutingInstructionLinesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.SenderBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.ToBeRespondedToByBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: HL7Message</p>
 * 
 * <p>MCCI_MT000300CA.Message: HL7 Message</p>
 * 
 * <p>The root class of all messages.</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 * 
 * <p>MCCI_MT000100CA.Message: HL7 Message</p>
 * 
 * <p>The root class of all messages.</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 */
@Hl7PartTypeMapping({"MCCI_MT000100CA.Message","MCCI_MT000300CA.Message"})
@Hl7RootType
public class HL7MessageBean<CAP> extends MessagePartBean {

    private static final long serialVersionUID = 20131210L;
    private II id = new IIImpl();
    private TS creationTime = new TSImpl();
    private ST securityText = new STImpl();
    private CS versionCode = new CSImpl();
    private II interactionId = new IIImpl();
    private SET<II, Identifier> profileId = new SETImpl<II, Identifier>(IIImpl.class);
    private CS processingCode = new CSImpl();
    private CS acceptAckCode = new CSImpl();
    private AcknowledgementBean acknowledgement;
    private List<RoutingInstructionLinesBean> attentionLine = new ArrayList<RoutingInstructionLinesBean>();
    private CAP controlActProcess;
    private ReceiverBean receiver;
    private ToBeRespondedToByBean respondTo;
    private SenderBean sender;


    /**
     * <p>Business Name: MessageIdentifier</p>
     * 
     * <p>Un-merged Business Name: MessageIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the message.</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: MessageIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the message.</p>
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
     * <p>Business Name: MessageIdentifier</p>
     * 
     * <p>Un-merged Business Name: MessageIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the message.</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: MessageIdentifier</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the message.</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: MessageTimestamp</p>
     * 
     * <p>Un-merged Business Name: MessageTimestamp</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.creationTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the time this particular message instance was 
     * constructed.</p>
     * 
     * <p>Allows identification of how current the information in a 
     * message is. Also provides a baseline for identifying the 
     * time-zone of other times within the message. As a result, 
     * the attribute is mandatory.</p>
     * 
     * <p>Un-merged Business Name: MessageTimestamp</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.creationTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Business Name: MessageTimestamp</p>
     * 
     * <p>Un-merged Business Name: MessageTimestamp</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.creationTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the time this particular message instance was 
     * constructed.</p>
     * 
     * <p>Allows identification of how current the information in a 
     * message is. Also provides a baseline for identifying the 
     * time-zone of other times within the message. As a result, 
     * the attribute is mandatory.</p>
     * 
     * <p>Un-merged Business Name: MessageTimestamp</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.creationTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Business Name: SecurityToken</p>
     * 
     * <p>Un-merged Business Name: SecurityToken</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.securityText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>A locally-defined field used to maintain a session, 
     * identify a user, and/or perform some other function related 
     * to authenticating the message source.</p>
     * 
     * <p>Allows jurisdictions and applications to communicate 
     * authentication and session information. The attribute is 
     * optional because not all jurisdictions will require this 
     * capability.</p>
     * 
     * <p>Un-merged Business Name: SecurityToken</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.securityText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
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
     * <p>Business Name: SecurityToken</p>
     * 
     * <p>Un-merged Business Name: SecurityToken</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.securityText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>A locally-defined field used to maintain a session, 
     * identify a user, and/or perform some other function related 
     * to authenticating the message source.</p>
     * 
     * <p>Allows jurisdictions and applications to communicate 
     * authentication and session information. The attribute is 
     * optional because not all jurisdictions will require this 
     * capability.</p>
     * 
     * <p>Un-merged Business Name: SecurityToken</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.securityText</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
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
     * <p>Business Name: HL7StandardVersion</p>
     * 
     * <p>Un-merged Business Name: HL7StandardVersion</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.versionCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the version of the messaging standard being 
     * referenced.</p>
     * 
     * <p>Needed to know how to validate message definition, CMET 
     * definition, vocabulary and other information and is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: HL7StandardVersion</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.versionCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the version of the messaging standard being 
     * referenced.</p>
     * 
     * <p>Needed to know how to validate message definition, CMET 
     * definition, vocabulary and other information and is 
     * therefore mandatory.</p>
     */
    @Hl7XmlMapping({"versionCode"})
    public HL7StandardVersionCode getVersionCode() {
        return (HL7StandardVersionCode) this.versionCode.getValue();
    }

    /**
     * <p>Business Name: HL7StandardVersion</p>
     * 
     * <p>Un-merged Business Name: HL7StandardVersion</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.versionCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the version of the messaging standard being 
     * referenced.</p>
     * 
     * <p>Needed to know how to validate message definition, CMET 
     * definition, vocabulary and other information and is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: HL7StandardVersion</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.versionCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the version of the messaging standard being 
     * referenced.</p>
     * 
     * <p>Needed to know how to validate message definition, CMET 
     * definition, vocabulary and other information and is 
     * therefore mandatory.</p>
     */
    public void setVersionCode(HL7StandardVersionCode versionCode) {
        this.versionCode.setValue(versionCode);
    }


    /**
     * <p>Business Name: InteractionType</p>
     * 
     * <p>Un-merged Business Name: InteractionType</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.interactionId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: InteractionType</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.interactionId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
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
     * <p>Business Name: InteractionType</p>
     * 
     * <p>Un-merged Business Name: InteractionType</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.interactionId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: InteractionType</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.interactionId</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     */
    public void setInteractionId(Identifier interactionId) {
        this.interactionId.setValue(interactionId);
    }


    /**
     * <p>Business Name: ConformanceProfileIdentifiers</p>
     * 
     * <p>Un-merged Business Name: ConformanceProfileIdentifiers</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.profileId</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     * 
     * <p>Identifies the conformance profile(s) this message 
     * complies with.</p>
     * 
     * <p>Indicates any additional validation that may be 
     * appropriate. Also influences what extensions can be 
     * processed.</p>
     * 
     * <p>Un-merged Business Name: ConformanceProfileIdentifiers</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.profileId</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-10)</p>
     * 
     * <p>Identifies the conformance profile(s) this message 
     * complies with.</p>
     * 
     * <p>Indicates any additional validation that may be 
     * appropriate. Also influences what extensions can be 
     * processed.</p>
     */
    @Hl7XmlMapping({"profileId"})
    public Set<Identifier> getProfileId() {
        return this.profileId.rawSet();
    }


    /**
     * <p>Business Name: ProcessingCode</p>
     * 
     * <p>Un-merged Business Name: ProcessingCode</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.processingCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: ProcessingCode</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.processingCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
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
     * <p>Relationship: MCCI_MT000300CA.Message.processingCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: ProcessingCode</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.processingCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     */
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode.setValue(processingCode);
    }


    /**
     * <p>Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Un-merged Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.acceptAckCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates how the message is expected to be 
     * acknowledged.</p>
     * 
     * <p>Provides support for immediate, deferred and polling mode 
     * and distinguishes which mode is desired. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.acceptAckCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates how the message is expected to be 
     * acknowledged.</p>
     * 
     * <p>Provides support for immediate, deferred and polling mode 
     * and distinguishes which mode is desired. The attribute is 
     * therefore mandatory.</p>
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
     * <p>Relationship: MCCI_MT000300CA.Message.acceptAckCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates how the message is expected to be 
     * acknowledged.</p>
     * 
     * <p>Provides support for immediate, deferred and polling mode 
     * and distinguishes which mode is desired. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>Un-merged Business Name: DesiredAcknowledgmentType</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.acceptAckCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates how the message is expected to be 
     * acknowledged.</p>
     * 
     * <p>Provides support for immediate, deferred and polling mode 
     * and distinguishes which mode is desired. The attribute is 
     * therefore mandatory.</p>
     */
    public void setAcceptAckCode(AcknowledgementCondition acceptAckCode) {
        this.acceptAckCode.setValue(acceptAckCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.acknowledgement</p>
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
     * <p>Relationship: MCCI_MT000300CA.Message.acknowledgement</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.attentionLine</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.attentionLine</p>
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
     * <p>Relationship: MCCI_MT000300CA.Message.controlActProcess</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.controlActProcess</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"controlActProcess"})
    public CAP getControlActProcess() {
        return this.controlActProcess;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.controlActProcess</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.controlActProcess</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setControlActProcess(CAP controlActProcess) {
        this.controlActProcess = controlActProcess;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.receiver</p>
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
     * <p>Relationship: MCCI_MT000300CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.receiver</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setReceiver(ReceiverBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.respondTo</p>
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
     * <p>Relationship: MCCI_MT000300CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.respondTo</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setRespondTo(ToBeRespondedToByBean respondTo) {
        this.respondTo = respondTo;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000300CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.sender</p>
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
     * <p>Relationship: MCCI_MT000300CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCCI_MT000100CA.Message.sender</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSender(SenderBean sender) {
        this.sender = sender;
    }

}
