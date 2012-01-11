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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged;

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



@Hl7PartTypeMapping({"MCCI_MT000200CA.Acknowledgement","MCCI_MT000300CA.Acknowledgement"})
public class AcknowledgementBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CS typeCode = new CSImpl();
    private INT messageWaitingNumber = new INTImpl();
    private CV messageWaitingPriorityCode = new CVImpl();
    private II targetMessageId = new IIImpl();
    private List<ErrorsOrWarningsBean> acknowledgementDetail = new ArrayList<ErrorsOrWarningsBean>();


    /**
     * <p>AcknowledgementCode</p>
     * 
     * <p>GA:Acknowledgement Code</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public AcknowledgementType getTypeCode() {
        return (AcknowledgementType) this.typeCode.getValue();
    }
    public void setTypeCode(AcknowledgementType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>NumberOfWaitingMessages</p>
     * 
     * <p>GC:Number of Waiting Messages</p>
     */
    @Hl7XmlMapping({"messageWaitingNumber"})
    public Integer getMessageWaitingNumber() {
        return this.messageWaitingNumber.getValue();
    }
    public void setMessageWaitingNumber(Integer messageWaitingNumber) {
        this.messageWaitingNumber.setValue(messageWaitingNumber);
    }


    /**
     * <p>MessageWaitingPriority</p>
     * 
     * <p>GD:Message Waiting Priority</p>
     */
    @Hl7XmlMapping({"messageWaitingPriorityCode"})
    public MessageWaitingPriority getMessageWaitingPriorityCode() {
        return (MessageWaitingPriority) this.messageWaitingPriorityCode.getValue();
    }
    public void setMessageWaitingPriorityCode(MessageWaitingPriority messageWaitingPriorityCode) {
        this.messageWaitingPriorityCode.setValue(messageWaitingPriorityCode);
    }


    /**
     * <p>AcknowledgedMessageId</p>
     * 
     * <p>BA:Acknowledged Message Id</p>
     */
    @Hl7XmlMapping({"targetMessage/id"})
    public Identifier getTargetMessageId() {
        return this.targetMessageId.getValue();
    }
    public void setTargetMessageId(Identifier targetMessageId) {
        this.targetMessageId.setValue(targetMessageId);
    }


    @Hl7XmlMapping({"acknowledgementDetail"})
    public List<ErrorsOrWarningsBean> getAcknowledgementDetail() {
        return this.acknowledgementDetail;
    }

}
