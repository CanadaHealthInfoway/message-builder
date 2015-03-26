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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

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

    private static final long serialVersionUID = 20150326L;
    private CS typeCode = new CSImpl();
    private INT messageWaitingNumber = new INTImpl();
    private CV messageWaitingPriorityCode = new CVImpl();
    private II targetMessageId = new IIImpl();
    private List<ErrorsOrWarningsBean> acknowledgementDetail = new ArrayList<ErrorsOrWarningsBean>();


    /**
     * <p>Business Name: AcknowledgementCode</p>
     * 
     * <p>Un-merged Business Name: AcknowledgementCode</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Acknowledgement.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Key to understanding whether the interaction has been 
     * successful and is therefore mandatory.</p>
     * 
     * <p>Indicates whether the previous interaction was 
     * successfully processed.</p>
     * 
     * <p>Un-merged Business Name: AcknowledgementCode</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Acknowledgement.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Key to understanding whether the interaction has been 
     * successful and is therefore mandatory.</p>
     * 
     * <p>Indicates whether the previous interaction was 
     * successfully processed.</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public AcknowledgementType getTypeCode() {
        return (AcknowledgementType) this.typeCode.getValue();
    }

    /**
     * <p>Business Name: AcknowledgementCode</p>
     * 
     * <p>Un-merged Business Name: AcknowledgementCode</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.Acknowledgement.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Key to understanding whether the interaction has been 
     * successful and is therefore mandatory.</p>
     * 
     * <p>Indicates whether the previous interaction was 
     * successfully processed.</p>
     * 
     * <p>Un-merged Business Name: AcknowledgementCode</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.Acknowledgement.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Key to understanding whether the interaction has been 
     * successful and is therefore mandatory.</p>
     * 
     * <p>Indicates whether the previous interaction was 
     * successfully processed.</p>
     */
    public void setTypeCode(AcknowledgementType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Business Name: NumberOfWaitingMessages</p>
     * 
     * <p>Un-merged Business Name: NumberOfWaitingMessages</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002300CA.Acknowledgement.messageWaitingNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates to a system how many polled messages are 
     * available without the need so send a separate query. The 
     * element is optional because not all systems will support 
     * polling.</p>
     * 
     * <p>For applications which support polling, indicates the 
     * total number of messages waiting to be retrieved.</p>
     * 
     * <p>Un-merged Business Name: NumberOfWaitingMessages</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002200CA.Acknowledgement.messageWaitingNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates to a system how many polled messages are 
     * available without the need so send a separate query. The 
     * element is optional because not all systems will support 
     * polling.</p>
     * 
     * <p>For applications which support polling, indicates the 
     * total number of messages waiting to be retrieved.</p>
     */
    @Hl7XmlMapping({"messageWaitingNumber"})
    public Integer getMessageWaitingNumber() {
        return this.messageWaitingNumber.getValue();
    }

    /**
     * <p>Business Name: NumberOfWaitingMessages</p>
     * 
     * <p>Un-merged Business Name: NumberOfWaitingMessages</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002300CA.Acknowledgement.messageWaitingNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates to a system how many polled messages are 
     * available without the need so send a separate query. The 
     * element is optional because not all systems will support 
     * polling.</p>
     * 
     * <p>For applications which support polling, indicates the 
     * total number of messages waiting to be retrieved.</p>
     * 
     * <p>Un-merged Business Name: NumberOfWaitingMessages</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002200CA.Acknowledgement.messageWaitingNumber</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Indicates to a system how many polled messages are 
     * available without the need so send a separate query. The 
     * element is optional because not all systems will support 
     * polling.</p>
     * 
     * <p>For applications which support polling, indicates the 
     * total number of messages waiting to be retrieved.</p>
     */
    public void setMessageWaitingNumber(Integer messageWaitingNumber) {
        this.messageWaitingNumber.setValue(messageWaitingNumber);
    }


    /**
     * <p>Business Name: MessageWaitingPriority</p>
     * 
     * <p>Un-merged Business Name: MessageWaitingPriority</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002300CA.Acknowledgement.messageWaitingPriorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The priority of the waiting message may influence how 
     * quickly the polling system may choose to download queued 
     * messages. The element is optional because not all systems 
     * will support polling.</p>
     * 
     * <p>Indicates the priority of the highest-priority message 
     * that is waiting on the poll queue for the system being 
     * responded to.</p>
     * 
     * <p>Un-merged Business Name: MessageWaitingPriority</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002200CA.Acknowledgement.messageWaitingPriorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The priority of the waiting message may influence how 
     * quickly the polling system may choose to download queued 
     * messages. The element is optional because not all systems 
     * will support polling.</p>
     * 
     * <p>Indicates the priority of the highest-priority message 
     * that is waiting on the poll queue for the system being 
     * responded to.</p>
     */
    @Hl7XmlMapping({"messageWaitingPriorityCode"})
    public MessageWaitingPriority getMessageWaitingPriorityCode() {
        return (MessageWaitingPriority) this.messageWaitingPriorityCode.getValue();
    }

    /**
     * <p>Business Name: MessageWaitingPriority</p>
     * 
     * <p>Un-merged Business Name: MessageWaitingPriority</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002300CA.Acknowledgement.messageWaitingPriorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The priority of the waiting message may influence how 
     * quickly the polling system may choose to download queued 
     * messages. The element is optional because not all systems 
     * will support polling.</p>
     * 
     * <p>Indicates the priority of the highest-priority message 
     * that is waiting on the poll queue for the system being 
     * responded to.</p>
     * 
     * <p>Un-merged Business Name: MessageWaitingPriority</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002200CA.Acknowledgement.messageWaitingPriorityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The priority of the waiting message may influence how 
     * quickly the polling system may choose to download queued 
     * messages. The element is optional because not all systems 
     * will support polling.</p>
     * 
     * <p>Indicates the priority of the highest-priority message 
     * that is waiting on the poll queue for the system being 
     * responded to.</p>
     */
    public void setMessageWaitingPriorityCode(MessageWaitingPriority messageWaitingPriorityCode) {
        this.messageWaitingPriorityCode.setValue(messageWaitingPriorityCode);
    }


    /**
     * <p>Business Name: AcknowledgedMessageId</p>
     * 
     * <p>Un-merged Business Name: AcknowledgedMessageId</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.TargetMessage.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:RelatesTo</p>
     * 
     * <p>Provides the necessary link to complete a conversation 
     * for systems using communication technologies which are not 
     * conversational. This attribute is therefore mandatory.</p>
     * 
     * <p>References the identifier of the message this current 
     * message is acknowledging.</p>
     * 
     * <p>Un-merged Business Name: AcknowledgedMessageId</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.TargetMessage.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:RelatesTo</p>
     * 
     * <p>Provides the necessary link to complete a conversation 
     * for systems using communication technologies which are not 
     * conversational. This attribute is therefore mandatory.</p>
     * 
     * <p>References the identifier of the message this current 
     * message is acknowledging.</p>
     */
    @Hl7XmlMapping({"targetMessage/id"})
    public Identifier getTargetMessageId() {
        return this.targetMessageId.getValue();
    }

    /**
     * <p>Business Name: AcknowledgedMessageId</p>
     * 
     * <p>Un-merged Business Name: AcknowledgedMessageId</p>
     * 
     * <p>Relationship: MCCI_MT002300CA.TargetMessage.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:RelatesTo</p>
     * 
     * <p>Provides the necessary link to complete a conversation 
     * for systems using communication technologies which are not 
     * conversational. This attribute is therefore mandatory.</p>
     * 
     * <p>References the identifier of the message this current 
     * message is acknowledging.</p>
     * 
     * <p>Un-merged Business Name: AcknowledgedMessageId</p>
     * 
     * <p>Relationship: MCCI_MT002200CA.TargetMessage.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>soap:Header\wsa:RelatesTo</p>
     * 
     * <p>Provides the necessary link to complete a conversation 
     * for systems using communication technologies which are not 
     * conversational. This attribute is therefore mandatory.</p>
     * 
     * <p>References the identifier of the message this current 
     * message is acknowledging.</p>
     */
    public void setTargetMessageId(Identifier targetMessageId) {
        this.targetMessageId.setValue(targetMessageId);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002300CA.Acknowledgement.acknowledgementDetail</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-50)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCCI_MT002200CA.Acknowledgement.acknowledgementDetail</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-50)</p>
     */
    @Hl7XmlMapping({"acknowledgementDetail"})
    public List<ErrorsOrWarningsBean> getAcknowledgementDetail() {
        return this.acknowledgementDetail;
    }

}
