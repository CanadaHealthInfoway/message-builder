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

import ca.infoway.messagebuilder.Code;
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
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AcknowledgementType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.ErrorsOrWarningsBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"MCCI_MT002300CA.Acknowledgement"})
public class AcknowledgementBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private CS typeCode = new CSImpl();
    private List<INT> messageWaitingNumber = new ArrayList<INT>();
    private List<CV> messageWaitingPriorityCode = new ArrayList<CV>();
    private II targetMessageId = new IIImpl();
    private List<ErrorsOrWarningsBean> acknowledgementDetail = new ArrayList<ErrorsOrWarningsBean>();


    /**
     * <p>GA:Acknowledgement Code</p>
     * 
     * <p><p>Indicates whether the previous interaction was 
     * successfully processed.</p></p>
     * 
     * <p><p>Key to understanding whether the interaction has been 
     * successful and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"typeCode"})
    public AcknowledgementType getTypeCode() {
        return (AcknowledgementType) this.typeCode.getValue();
    }
    public void setTypeCode(AcknowledgementType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>GC:Number of Waiting Messages</p>
     * 
     * <p><p>For applications which support polling, indicates the 
     * total number of messages waiting to be retrieved.</p></p>
     * 
     * <p><p>Indicates to a system how many polled messages are 
     * available without the need so send a separate query. The 
     * element is optional because not all systems will support 
     * polling.</p></p>
     */
    @Hl7XmlMapping({"messageWaitingNumber"})
    public List<Integer> getMessageWaitingNumber() {
        return new RawListWrapper<INT, Integer>(messageWaitingNumber, INTImpl.class);
    }


    /**
     * <p>GD:Message Waiting Priority</p>
     * 
     * <p><p>Indicates the priority of the highest-priority message 
     * that is waiting on the poll queue for the system being 
     * responded to.</p></p>
     * 
     * <p><p>The priority of the waiting message may influence how 
     * quickly the polling system may choose to download queued 
     * messages. The element is optional because not all systems 
     * will support polling.</p></p>
     */
    @Hl7XmlMapping({"messageWaitingPriorityCode"})
    public List<Code> getMessageWaitingPriorityCode() {
        return new RawListWrapper<CV, Code>(messageWaitingPriorityCode, CVImpl.class);
    }


    /**
     * <p>BA:Acknowledged Message Id</p>
     * 
     * <p><p>References the identifier of the message this current 
     * message is acknowledging.</p></p>
     * 
     * <p><p>soap:Header\wsa:RelatesTo</p></p>
     * 
     * <p><p>Provides the necessary link to complete a conversation 
     * for systems using communication technologies which are not 
     * conversational. This attribute is therefore mandatory.</p></p>
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
