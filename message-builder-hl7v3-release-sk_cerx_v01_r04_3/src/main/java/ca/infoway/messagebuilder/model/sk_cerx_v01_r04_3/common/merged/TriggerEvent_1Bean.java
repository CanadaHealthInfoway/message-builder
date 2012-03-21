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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.ConsentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>TriggerEvent</p>
 * 
 * <p>MCAI_MT700210CA.ControlActEvent: Trigger Event</p>
 * 
 * <p><p>Identifies the action that resulted in this message 
 * being sent.</p></p>
 * 
 * <p><p>Key to understanding what action a message 
 * represents.</p></p>
 * 
 * <p><p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p></p>
 * 
 * <p>MCAI_MT700211CA.ControlActEvent: Trigger Event</p>
 * 
 * <p><p>Identifies the action that resulted in this message 
 * being sent.</p></p>
 * 
 * <p><p>Key to understanding what action a message 
 * represents.</p></p>
 * 
 * <p><p>There may be constraints on the usage of the 
 * effectiveTime and reasonCode attributes in the definition of 
 * the interaction or the trigger events which are conveyed 
 * with this wrapper.</p></p>
 */
@Hl7PartTypeMapping({"MCAI_MT700210CA.ControlActEvent","MCAI_MT700211CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_1Bean<ACT> extends MessagePartBean {

    private static final long serialVersionUID = 20120320L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ProviderBean dataEntererAssignedPerson;
    private RecordedAtBean location;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private RefersToBean<ACT> subject;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();
    private ConsentBean subjectOf2ConsentEvent;


    /**
     * <p>EventIdentifier</p>
     * 
     * <p>B:Event Identifier</p>
     * 
     * <p><p>A unique identifier for this particular event assigned 
     * by the system in which the event occurred.</p></p>
     * 
     * <p><p>Allows the event to be referenced (for retractions) 
     * and also indicates whether multiple interactions were caused 
     * by the same triggering event. The attribute is therefore 
     * mandatory.</p></p>
     * 
     * <p><p>These identifiers should be stored for use in 
     * 'retractions'. They should be stored in such a way that they 
     * are associated with the item that was modified by this 
     * event. For example, a system should be able to show the list 
     * of trigger event identifiers for the actions that have been 
     * recorded against a particular prescription.</p></p>
     * 
     * <p>B:Event Identifier</p>
     * 
     * <p><p>A unique identifier for this particular event assigned 
     * by the system in which the event occurred.</p></p>
     * 
     * <p><p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. The attribute is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>EventType</p>
     * 
     * <p>A:Event Type</p>
     * 
     * <p><p>Identifies the trigger event that occurred.</p></p>
     * 
     * <p><p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>EventEffectivePeriod</p>
     * 
     * <p>C:Event Effective Period</p>
     * 
     * <p><p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p></p>
     * 
     * <p><p>The time a change becomes effective may differ from 
     * the time the event is recorded. (I.e. it may be in the 
     * future or the past). For changes such as 'suspend', an 
     * intended end date may also be indicated.</p></p>
     * 
     * <p>C:Event Effective Period</p>
     * 
     * <p><p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p><p>Example use is to record a 
     * dispense pickup time on the Rx Pickup Notification 
     * interaction. This time may be in the past, but cannot be in 
     * the future.</p></p>
     * 
     * <p><p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p><p>Example use is to record a 
     * dispense pickup time on the Rx Pickup Notification 
     * interaction. This time may be in the past, but cannot be in 
     * the future.</p></p>
     * 
     * <p><p>The time a change becomes effective may differ from 
     * the time the event is recorded. (I.e. it may be in the 
     * future or the past). For changes such as 'suspend', an 
     * intended end date may also be indicated.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>EventReason</p>
     * 
     * <p>E:Event Reason</p>
     * 
     * <p><p>Identifies why this specific query, modification 
     * request, or modification occurred.</p></p>
     * 
     * <p><p>Allows identifying a reason for a specific action, 
     * such as 'reason for hold'. Also allows identifying reason 
     * for accessing information for a query.</p></p>
     * 
     * <p>E:Event Reason</p>
     * 
     * <p><p>Identifies why this specific query, modification 
     * request, or modification occurred.</p></p>
     * 
     * <p><p>Allows identifying a reason for a specific action, 
     * such as 'reason for hold'. Also allows identifying reason 
     * for accessing information for a query.</p></p>
     * 
     * <p><p>The domain associated with this attribute will vary 
     * for each interaction and will be noted as part of the 
     * interaction description.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"dataEnterer/assignedPerson"})
    public ProviderBean getDataEntererAssignedPerson() {
        return this.dataEntererAssignedPerson;
    }
    public void setDataEntererAssignedPerson(ProviderBean dataEntererAssignedPerson) {
        this.dataEntererAssignedPerson = dataEntererAssignedPerson;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"subject"})
    public RefersToBean<ACT> getSubject() {
        return this.subject;
    }
    public void setSubject(RefersToBean<ACT> subject) {
        this.subject = subject;
    }


    @Hl7XmlMapping({"subjectOf/detectedIssueEvent","subjectOf1/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="MCAI_MT700211CA.Subject"),
        @Hl7MapByPartType(name="subjectOf/detectedIssueEvent", type="PORX_MT980020CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf1", type="MCAI_MT700210CA.Subject"),
        @Hl7MapByPartType(name="subjectOf1/detectedIssueEvent", type="PORX_MT980010CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf2/consentEvent"})
    public ConsentBean getSubjectOf2ConsentEvent() {
        return this.subjectOf2ConsentEvent;
    }
    public void setSubjectOf2ConsentEvent(ConsentBean subjectOf2ConsentEvent) {
        this.subjectOf2ConsentEvent = subjectOf2ConsentEvent;
    }

}
