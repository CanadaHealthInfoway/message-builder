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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ConsentBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ServiceLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>TriggerEvent</p>
 * 
 * <p>MFMI_MT700711CA.ControlActEvent: Trigger Event</p>
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent.</p>
 * 
 * <p>Key to understanding what action a message 
 * represents.</p>
 * 
 * <p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p>
 * 
 * <p>MFMI_MT700716CA.ControlActEvent: Trigger Event</p>
 * 
 * <p>Identifies the action that resulted in this message being 
 * sent.</p>
 * 
 * <p>Key to understanding what action a message 
 * represents.</p>
 * 
 * <p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p>
 */
@Hl7PartTypeMapping({"MFMI_MT700711CA.ControlActEvent","MFMI_MT700716CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_3Bean<RR> extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedBy_2Bean author;
    private EntererChoice dataEntererEntererChoice;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private CreatedAtBean location;
    private RefersTo_2Bean<RR> subject;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private ConsentBean subjectOf1ConsentEvent;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>EventIdentifier</p>
     * 
     * <p>B:Event Identifier</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p>
     * 
     * <p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone).</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>EventIdentifier</p>
     * 
     * <p>B:Event Identifier</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p>
     * 
     * <p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone).</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>EventType</p>
     * 
     * <p>A:Event Type</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>EventType</p>
     * 
     * <p>A:Event Type</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>EventEffectivePeriod</p>
     * 
     * <p>C:Event Effective Period</p>
     * 
     * <p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p>
     * 
     * <p>The time an event becomes effective may differ from the 
     * time the event is recorded (i.e. it may be in the future or 
     * the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>EventEffectivePeriod</p>
     * 
     * <p>C:Event Effective Period</p>
     * 
     * <p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p>
     * 
     * <p>The time an event becomes effective may differ from the 
     * time the event is recorded (i.e. it may be in the future or 
     * the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>EventReason</p>
     * 
     * <p>E:Event Reason</p>
     * 
     * <p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold' or 'reason for accessing 
     * information'.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>EventReason</p>
     * 
     * <p>E:Event Reason</p>
     * 
     * <p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold' or 'reason for accessing 
     * information'.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public CreatedBy_2Bean getAuthor() {
        return this.author;
    }

    public void setAuthor(CreatedBy_2Bean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"dataEnterer/entererChoice"})
    public EntererChoice getDataEntererEntererChoice() {
        return this.dataEntererEntererChoice;
    }

    public void setDataEntererEntererChoice(EntererChoice dataEntererEntererChoice) {
        this.dataEntererEntererChoice = dataEntererEntererChoice;
    }


    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }

    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"subject"})
    public RefersTo_2Bean<RR> getSubject() {
        return this.subject;
    }

    public void setSubject(RefersTo_2Bean<RR> subject) {
        this.subject = subject;
    }


    @Hl7XmlMapping({"pertinentInformation/authorizationToken"})
    public AuthenticationTokenBean getPertinentInformationAuthorizationToken() {
        return this.pertinentInformationAuthorizationToken;
    }

    public void setPertinentInformationAuthorizationToken(AuthenticationTokenBean pertinentInformationAuthorizationToken) {
        this.pertinentInformationAuthorizationToken = pertinentInformationAuthorizationToken;
    }


    @Hl7XmlMapping({"subjectOf1/consentEvent"})
    public ConsentBean getSubjectOf1ConsentEvent() {
        return this.subjectOf1ConsentEvent;
    }

    public void setSubjectOf1ConsentEvent(ConsentBean subjectOf1ConsentEvent) {
        this.subjectOf1ConsentEvent = subjectOf1ConsentEvent;
    }


    @Hl7XmlMapping({"subjectOf/detectedIssueEvent","subjectOf2/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="MFMI_MT700716CA.Subject"),
        @Hl7MapByPartType(name="subjectOf/detectedIssueEvent", type="COCT_MT260012CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf2", type="MFMI_MT700711CA.Subject"),
        @Hl7MapByPartType(name="subjectOf2/detectedIssueEvent", type="COCT_MT260012CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

}
