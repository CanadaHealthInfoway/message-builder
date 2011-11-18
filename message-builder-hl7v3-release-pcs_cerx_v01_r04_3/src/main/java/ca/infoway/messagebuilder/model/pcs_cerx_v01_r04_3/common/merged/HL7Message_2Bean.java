/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged;

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



@Hl7PartTypeMapping({"MCCI_MT000200CA.Message","MCCI_MT102001CA.Message"})
@Hl7RootType
public class HL7Message_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
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
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>MessageTimestamp</p>
     * 
     * <p>G:Message Timestamp</p>
     */
    @Hl7XmlMapping({"creationTime"})
    public Date getCreationTime() {
        return this.creationTime.getValue();
    }
    public void setCreationTime(Date creationTime) {
        this.creationTime.setValue(creationTime);
    }


    /**
     * <p>SecurityToken</p>
     * 
     * <p>H:Security Token</p>
     */
    @Hl7XmlMapping({"securityText"})
    public String getSecurityText() {
        return this.securityText.getValue();
    }
    public void setSecurityText(String securityText) {
        this.securityText.setValue(securityText);
    }


    /**
     * <p>HL7StandardVersion</p>
     * 
     * <p>C: HL7 Standard Version</p>
     */
    @Hl7XmlMapping({"versionCode"})
    public HL7StandardVersionCode getVersionCode() {
        return (HL7StandardVersionCode) this.versionCode.getValue();
    }
    public void setVersionCode(HL7StandardVersionCode versionCode) {
        this.versionCode.setValue(versionCode);
    }


    /**
     * <p>InteractionType</p>
     * 
     * <p>B:Interaction Type</p>
     */
    @Hl7XmlMapping({"interactionId"})
    public Identifier getInteractionId() {
        return this.interactionId.getValue();
    }
    public void setInteractionId(Identifier interactionId) {
        this.interactionId.setValue(interactionId);
    }


    /**
     * <p>ConformanceProfileIdentifiers</p>
     * 
     * <p>F:Conformance Profile Identifiers</p>
     */
    @Hl7XmlMapping({"profileId"})
    public Set<Identifier> getProfileId() {
        return this.profileId.rawSet();
    }


    /**
     * <p>ProcessingCode</p>
     * 
     * <p>D:Processing Code</p>
     */
    @Hl7XmlMapping({"processingCode"})
    public ProcessingID getProcessingCode() {
        return (ProcessingID) this.processingCode.getValue();
    }
    public void setProcessingCode(ProcessingID processingCode) {
        this.processingCode.setValue(processingCode);
    }


    /**
     * <p>DesiredAcknowledgmentType</p>
     * 
     * <p>E:Desired Acknowledgment Type</p>
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

}
