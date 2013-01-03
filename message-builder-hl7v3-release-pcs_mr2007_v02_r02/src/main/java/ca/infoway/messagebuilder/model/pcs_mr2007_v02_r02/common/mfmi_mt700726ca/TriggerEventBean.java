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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.mfmi_mt700726ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.EHRRepositoryBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.RegisteredItemBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.ReplacesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.IssuesBean;
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
@Hl7PartTypeMapping({"MFMI_MT700726CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private BL subjectContextConductionInd = new BLImpl();
    private RegisteredItemBean<RR> subjectRegistrationEventSubject;
    private EHRRepositoryBean subjectRegistrationEventCustodianAssignedDevice;
    private List<ReplacesBean> subjectRegistrationEventReplacementOf = new ArrayList<ReplacesBean>();
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Business Name: B:Event Identifier</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p>
     * 
     * <p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone).</p>
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
     * <p>Relationship: MFMI_MT700726CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p>
     * 
     * <p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone).</p>
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
     * <p>Relationship: MFMI_MT700726CA.ControlActEvent.code</p>
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
     * <p>Relationship: MFMI_MT700726CA.ControlActEvent.code</p>
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
     * MFMI_MT700726CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The time an event becomes effective may differ from the 
     * time the event is recorded (i.e. it may be in the future or 
     * the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Event Effective Period</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The time an event becomes effective may differ from the 
     * time the event is recorded (i.e. it may be in the future or 
     * the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Event Reason</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold' or 'reason for accessing 
     * information'.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     * 
     * <p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: E:Event Reason</p>
     * 
     * <p>Relationship: MFMI_MT700726CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold' or 'reason for accessing 
     * information'.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     * 
     * <p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Business Name: Cascade Responsibility Indicator</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p>
     */
    @Hl7XmlMapping({"subject/contextConductionInd"})
    public Boolean getSubjectContextConductionInd() {
        return this.subjectContextConductionInd.getValue();
    }

    /**
     * <p>Business Name: Cascade Responsibility Indicator</p>
     * 
     * <p>Relationship: 
     * MFMI_MT700726CA.Subject2.contextConductionInd</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Cascading of trigger event objects allows different 
     * messages to employ consistent and common 
     * objects.</p><p>Attribute is mandatory to ensure that 
     * cascading will be specified one way or another.</p>
     * 
     * <p>Indicates whether or not objects of the trigger event are 
     * to be cascaded to the payload.</p><p>If true, associations 
     * in the parent act are conducted across the ActRelationship 
     * to the message payload (act). Conduction for each 
     * association is specifically indicated by each associations' 
     * contextControlCode value.</p><p>In other words, if the 
     * &quot;subject&quot; act relationship has 
     * contextConductionInd=true; THEN the subjectOf association is 
     * carried (to the regsitrationEvent act) according to the 
     * subjectOf.contextControlCode (AP = propogate to the reg 
     * event and add to any subject(s) (issues) already 
     * present).</p>
     */
    public void setSubjectContextConductionInd(Boolean subjectContextConductionInd) {
        this.subjectContextConductionInd.setValue(subjectContextConductionInd);
    }


    /**
     * <p>Relationship: MFMI_MT700726CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/registrationEvent/subject"})
    public RegisteredItemBean<RR> getSubjectRegistrationEventSubject() {
        return this.subjectRegistrationEventSubject;
    }

    /**
     * <p>Relationship: MFMI_MT700726CA.RegistrationEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectRegistrationEventSubject(RegisteredItemBean<RR> subjectRegistrationEventSubject) {
        this.subjectRegistrationEventSubject = subjectRegistrationEventSubject;
    }


    /**
     * <p>Relationship: MFMI_MT700726CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/registrationEvent/custodian/assignedDevice"})
    public EHRRepositoryBean getSubjectRegistrationEventCustodianAssignedDevice() {
        return this.subjectRegistrationEventCustodianAssignedDevice;
    }

    /**
     * <p>Relationship: MFMI_MT700726CA.Custodian.assignedDevice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectRegistrationEventCustodianAssignedDevice(EHRRepositoryBean subjectRegistrationEventCustodianAssignedDevice) {
        this.subjectRegistrationEventCustodianAssignedDevice = subjectRegistrationEventCustodianAssignedDevice;
    }


    /**
     * <p>Relationship: 
     * MFMI_MT700726CA.RegistrationEvent.replacementOf</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-10)</p>
     */
    @Hl7XmlMapping({"subject/registrationEvent/replacementOf"})
    public List<ReplacesBean> getSubjectRegistrationEventReplacementOf() {
        return this.subjectRegistrationEventReplacementOf;
    }


    /**
     * <p>Relationship: MFMI_MT700726CA.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

}
