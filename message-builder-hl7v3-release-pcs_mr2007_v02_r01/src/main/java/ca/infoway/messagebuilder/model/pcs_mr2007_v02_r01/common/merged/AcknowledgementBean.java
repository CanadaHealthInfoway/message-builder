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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementType;
import ca.infoway.messagebuilder.domainvalue.MessageWaitingPriority;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"MCCI_MT002200CA.Acknowledgement","MCCI_MT002300CA.Acknowledgement"})
public class AcknowledgementBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CS acknowledgementCode = new CSImpl();
    private INT numberOfWaitingMessages = new INTImpl();
    private CV messageWaitingPriority = new CVImpl();
    private II acknowledgedMessageId = new IIImpl();
    private List<ErrorsOrWarningsBean> acknowledgementDetail = new ArrayList<ErrorsOrWarningsBean>();


    /**
     * <p>AcknowledgementCode</p>
     * 
     * <p>GA:Acknowledgement Code</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public AcknowledgementType getAcknowledgementCode() {
        return (AcknowledgementType) this.acknowledgementCode.getValue();
    }
    public void setAcknowledgementCode(AcknowledgementType acknowledgementCode) {
        this.acknowledgementCode.setValue(acknowledgementCode);
    }


    /**
     * <p>NumberOfWaitingMessages</p>
     * 
     * <p>GC:Number of Waiting Messages</p>
     */
    @Hl7XmlMapping({"messageWaitingNumber"})
    public Integer getNumberOfWaitingMessages() {
        return this.numberOfWaitingMessages.getValue();
    }
    public void setNumberOfWaitingMessages(Integer numberOfWaitingMessages) {
        this.numberOfWaitingMessages.setValue(numberOfWaitingMessages);
    }


    /**
     * <p>MessageWaitingPriority</p>
     * 
     * <p>GD:Message Waiting Priority</p>
     */
    @Hl7XmlMapping({"messageWaitingPriorityCode"})
    public MessageWaitingPriority getMessageWaitingPriority() {
        return (MessageWaitingPriority) this.messageWaitingPriority.getValue();
    }
    public void setMessageWaitingPriority(MessageWaitingPriority messageWaitingPriority) {
        this.messageWaitingPriority.setValue(messageWaitingPriority);
    }


    /**
     * <p>AcknowledgedMessageId</p>
     * 
     * <p>BA:Acknowledged Message Id</p>
     */
    @Hl7XmlMapping({"targetMessage/id"})
    public Identifier getAcknowledgedMessageId() {
        return this.acknowledgedMessageId.getValue();
    }
    public void setAcknowledgedMessageId(Identifier acknowledgedMessageId) {
        this.acknowledgedMessageId.setValue(acknowledgedMessageId);
    }


    @Hl7XmlMapping({"acknowledgementDetail"})
    public List<ErrorsOrWarningsBean> getAcknowledgementDetail() {
        return this.acknowledgementDetail;
    }

}
