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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.merged;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



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
 * <p>MCCI_MT000200CA.Message: HL7 Message</p>
 * 
 * <p>The root class of all messages.</p>
 * 
 * <p>Conveys information about the interaction and how it is 
 * to be processed</p>
 */
@Hl7PartTypeMapping({"MCCI_MT000200CA.Message","MCCI_MT102001CA.Message"})
@Hl7RootType
public class HL7Message_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private TS creationTime = new TSImpl();
    private ST securityText = new STImpl();
    private CS versionCode = new CSImpl();
    private II interactionId = new IIImpl();
    private SET<II, Identifier> profileId = new SETImpl<II, Identifier>(IIImpl.class);
    private CS processingCode = new CSImpl();
    private CS acceptAckCode = new CSImpl();
    private ReceiverBean receiver;
    private ToBeRespondedToByBean respondTo;
    private SenderBean sender;
    private List<RoutingInstructionLinesBean> attentionLine = new ArrayList<RoutingInstructionLinesBean>();
    private AcknowledgementBean acknowledgement;


    /**
     * <p>MessageIdentifier</p>
     * 
     * <p>A:Message Identifier</p>
     * 
     * <p>A unique identifier for the message.</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     * 
     * <p>PIN&rsquo;s unique identifier for this message.&nbsp;</p>
     * 
     * <p>A:Message Identifier</p>
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
     * <p>MessageIdentifier</p>
     * 
     * <p>A:Message Identifier</p>
     * 
     * <p>A unique identifier for the message.</p>
     * 
     * <p>Allows detection of duplicate messages, and allows tying 
     * acknowledgments to the message they are acknowledging. The 
     * attribute is therefore mandatory.</p>
     * 
     * <p>PIN&rsquo;s unique identifier for this message.&nbsp;</p>
     * 
     * <p>A:Message Identifier</p>
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
     * 
     * <p>PIN does not require this field so it will not be 
     * sent.&nbsp;</p>
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
     * 
     * <p>PIN does not require this field so it will not be 
     * sent.&nbsp;</p>
     */
    public void setSecurityText(String securityText) {
        this.securityText.setValue(securityText);
    }


    /**
     * <p>HL7StandardVersion</p>
     * 
     * <p>C: HL7 Standard Version</p>
     * 
     * <p>Indicates the version of the messaging standard being 
     * referenced.</p>
     * 
     * <p>Needed to know how to validate message definition, CMET 
     * definition, vocabulary and other information and is 
     * therefore mandatory.</p>
     * 
     * <p>C: HL7 Standard Version</p>
     * 
     * <p>Indicates the version of the messaging standard being 
     * referenced.</p>
     * 
     * <p>Needed to know how to validate message definition, CMET 
     * definition, vocabulary and other information and is 
     * therefore mandatory.</p>
     * 
     * <p>Fixed to &lsquo;V3-2005-12&rsquo;.&nbsp;</p>
     */
    @Hl7XmlMapping({"versionCode"})
    public HL7StandardVersionCode getVersionCode() {
        return (HL7StandardVersionCode) this.versionCode.getValue();
    }

    /**
     * <p>HL7StandardVersion</p>
     * 
     * <p>C: HL7 Standard Version</p>
     * 
     * <p>Indicates the version of the messaging standard being 
     * referenced.</p>
     * 
     * <p>Needed to know how to validate message definition, CMET 
     * definition, vocabulary and other information and is 
     * therefore mandatory.</p>
     * 
     * <p>C: HL7 Standard Version</p>
     * 
     * <p>Indicates the version of the messaging standard being 
     * referenced.</p>
     * 
     * <p>Needed to know how to validate message definition, CMET 
     * definition, vocabulary and other information and is 
     * therefore mandatory.</p>
     * 
     * <p>Fixed to &lsquo;V3-2005-12&rsquo;.&nbsp;</p>
     */
    public void setVersionCode(HL7StandardVersionCode versionCode) {
        this.versionCode.setValue(versionCode);
    }


    /**
     * <p>InteractionType</p>
     * 
     * <p>B:Interaction Type</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>B:Interaction Type</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>Will match the XML root element.&nbsp;</p>
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
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>B:Interaction Type</p>
     * 
     * <p>Indicates the interaction conveyed by this message.</p>
     * 
     * <p>Identifies what the receiving application should do, and 
     * how the message should be validated. The attribute is 
     * therefore mandatory.</p>
     * 
     * <p>Will match the XML root element.&nbsp;</p>
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
     * 
     * <p>F:Conformance Profile Identifiers</p>
     * 
     * <p>Identifies the conformance profile(s) this message 
     * complies with.</p>
     * 
     * <p>Indicates any additional validation that may be 
     * appropriate. Also influences what extensions can be 
     * processed.</p>
     * 
     * <p>PIN does not require this field so it will not be 
     * sent.&nbsp;</p>
     */
    @Hl7XmlMapping({"profileId"})
    public Set<Identifier> getProfileId() {
        return this.profileId.rawSet();
    }


    /**
     * <p>ProcessingCode</p>
     * 
     * <p>D:Processing Code</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     * 
     * <p>D:Processing Code</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     * 
     * <p><div>Fixed to &lsquo;D&rsquo; for Development and System 
     * Test, &lsquo;T&rsquo;</div> <div>for Training and Vendor 
     * Testing, &lsquo;P&rsquo; for</div> <p>Production.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"processingCode"})
    public ProcessingID getProcessingCode() {
        return (ProcessingID) this.processingCode.getValue();
    }

    /**
     * <p>ProcessingCode</p>
     * 
     * <p>D:Processing Code</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     * 
     * <p>D:Processing Code</p>
     * 
     * <p>Indicates whether this message is intended to be 
     * processed as production, test or debug message.</p>
     * 
     * <p>Indicates how the message should be handled and is 
     * therefore mandatory.</p>
     * 
     * <p><div>Fixed to &lsquo;D&rsquo; for Development and System 
     * Test, &lsquo;T&rsquo;</div> <div>for Training and Vendor 
     * Testing, &lsquo;P&rsquo; for</div> <p>Production.&nbsp;</p></p>
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
     * <p><strong>Fixed to "NE".</strong></p>
     * 
     * <p>E:Desired Acknowledgment Type</p>
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
     * <p><strong>Fixed to "NE".</strong></p>
     * 
     * <p>E:Desired Acknowledgment Type</p>
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
     * <p>(no business name)</p>
     * 
     * <p><div>This will echo the Sender section of the 
     * original</div> <p>message.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"receiver"})
    public ReceiverBean getReceiver() {
        return this.receiver;
    }

    /**
     * <p>(no business name)</p>
     * 
     * <p><div>This will echo the Sender section of the 
     * original</div> <p>message.&nbsp;</p></p>
     */
    public void setReceiver(ReceiverBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>RespondToSystem</p>
     * 
     * <p>Respond to system</p>
     * 
     * <p>PIN does not require this field so it will not be 
     * sent.&nbsp;</p>
     */
    @Hl7XmlMapping({"respondTo"})
    public ToBeRespondedToByBean getRespondTo() {
        return this.respondTo;
    }

    /**
     * <p>RespondToSystem</p>
     * 
     * <p>Respond to system</p>
     * 
     * <p>PIN does not require this field so it will not be 
     * sent.&nbsp;</p>
     */
    public void setRespondTo(ToBeRespondedToByBean respondTo) {
        this.respondTo = respondTo;
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><div>This will echo the Receiver section of the 
     * original</div> <div>message.&nbsp;</div></p>
     */
    @Hl7XmlMapping({"sender"})
    public SenderBean getSender() {
        return this.sender;
    }

    /**
     * <p>(no business name)</p>
     * 
     * <p><div>This will echo the Receiver section of the 
     * original</div> <div>message.&nbsp;</div></p>
     */
    public void setSender(SenderBean sender) {
        this.sender = sender;
    }


    /**
     * <p>RoutingInstructionLine</p>
     * 
     * <p>Routing Instruction Line</p>
     * 
     * <p>PIN does not require this field so it will not be 
     * sent.&nbsp;</p>
     */
    @Hl7XmlMapping({"attentionLine"})
    public List<RoutingInstructionLinesBean> getAttentionLine() {
        return this.attentionLine;
    }


    /**
     * <p>(no business name)</p>
     * 
     * <p><div>Indicates whether the previous interaction was</div> 
     * <p>successfully processed.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"acknowledgement"})
    public AcknowledgementBean getAcknowledgement() {
        return this.acknowledgement;
    }

    /**
     * <p>(no business name)</p>
     * 
     * <p><div>Indicates whether the previous interaction was</div> 
     * <p>successfully processed.&nbsp;</p></p>
     */
    public void setAcknowledgement(AcknowledgementBean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

}
