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
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.mcai_mt700220ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.merged.RefersToBean;
import ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.porx_mt980020ca.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Trigger Event</p>
 * 
 * <p>Key to understanding what action a message 
 * represents.</p>
 * 
 * <p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p>
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent.</p>
 */
@Hl7PartTypeMapping({"MCAI_MT700220CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<ACT> extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private CV reasonCode = new CVImpl();
    private RefersToBean<ACT> subject;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the event to be referenced (for retractions) and 
     * also indicates whether multiple interactions were caused by 
     * the same triggering event. The attribute is therefore 
     * mandatory.</p>
     * 
     * <p>These identifiers should be stored for use in 
     * 'retractions'. They should be stored in such a way that they 
     * are associated with the item that was modified by this 
     * event. For example, a system should be able to show the list 
     * of trigger event identifiers for the actions that have been 
     * recorded against a particular prescription.</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the event to be referenced (for retractions) and 
     * also indicates whether multiple interactions were caused by 
     * the same triggering event. The attribute is therefore 
     * mandatory.</p>
     * 
     * <p>These identifiers should be stored for use in 
     * 'retractions'. They should be stored in such a way that they 
     * are associated with the item that was modified by this 
     * event. For example, a system should be able to show the list 
     * of trigger event identifiers for the actions that have been 
     * recorded against a particular prescription.</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Event Effective Period</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700220CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Indicates the time the change occurred. If not populated, 
     * the assumption is the same time the message was 
     * constructed.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Event Effective Period</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700220CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Indicates the time the change occurred. If not populated, 
     * the assumption is the same time the message was 
     * constructed.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Event Reason</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold'. Also allows identifying reason for 
     * accessing information for a query.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     * 
     * <p>Identifies why this specific query, modification request, 
     * or modification occurred.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: E:Event Reason</p>
     * 
     * <p>Relationship: MCAI_MT700220CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold'. Also allows identifying reason for 
     * accessing information for a query.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     * 
     * <p>Identifies why this specific query, modification request, 
     * or modification occurred.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Relationship: MCAI_MT700220CA.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public RefersToBean<ACT> getSubject() {
        return this.subject;
    }

    /**
     * <p>Relationship: MCAI_MT700220CA.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubject(RefersToBean<ACT> subject) {
        this.subject = subject;
    }


    /**
     * <p>Relationship: MCAI_MT700220CA.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

}
