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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.ConsentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: TriggerEvent</p>
 * 
 * <p>MCAI_MT700210CA.ControlActEvent: Trigger Event</p>
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
 * <p>MCAI_MT700211CA.ControlActEvent: Trigger Event</p>
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
@Hl7PartTypeMapping({"MCAI_MT700210CA.ControlActEvent","MCAI_MT700211CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_1Bean<ACT> extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
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
     * <p>Business Name: EventIdentifier</p>
     * 
     * <p>Other Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. The attribute is therefore 
     * mandatory.</p>
     * 
     * <p><div>&nbsp;It will be stored</div> <div>by PIN and can be 
     * used to refer to this event in</div> <p>future transactions, 
     * eg. Retract.&nbsp;</p></p>
     * 
     * <p>Other Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
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
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: EventIdentifier</p>
     * 
     * <p>Other Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
     * 
     * <p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. The attribute is therefore 
     * mandatory.</p>
     * 
     * <p><div>&nbsp;It will be stored</div> <div>by PIN and can be 
     * used to refer to this event in</div> <p>future transactions, 
     * eg. Retract.&nbsp;</p></p>
     * 
     * <p>Other Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for this particular event assigned by 
     * the system in which the event occurred.</p>
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
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: EventType</p>
     * 
     * <p>Other Business Name: EventType</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p><div>A CODE_INVAL error issue will be returned if 
     * this</div> <div>does not contain the trigger event code 
     * associated</div> <p>with this interaction.&nbsp;</p></p>
     * 
     * <p>Other Business Name: EventType</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Business Name: EventType</p>
     * 
     * <p>Other Business Name: EventType</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p><div>A CODE_INVAL error issue will be returned if 
     * this</div> <div>does not contain the trigger event code 
     * associated</div> <p>with this interaction.&nbsp;</p></p>
     * 
     * <p>Other Business Name: EventType</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Business Name: EventEffectivePeriod</p>
     * 
     * <p>Other Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700210CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>&nbsp;</p> <div>Unless specified for a specific message, 
     * the</div> <div>event start date can not be later than the 
     * date</div> <div>specified in the time of creation. If a 
     * wrong start</div> <div>date or an end date is specified, a 
     * BUS error</div> <div>issue will be returned.</div>
     * 
     * <p>Other Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700211CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p><p>Example use is to record a 
     * dispense pickup time on the Rx Pickup Notification 
     * interaction. This time may be in the past, but cannot be in 
     * the future.</p>
     * 
     * <p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p><p>Example use is to record a 
     * dispense pickup time on the Rx Pickup Notification 
     * interaction. This time may be in the past, but cannot be in 
     * the future.</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: EventEffectivePeriod</p>
     * 
     * <p>Other Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700210CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>&nbsp;</p> <div>Unless specified for a specific message, 
     * the</div> <div>event start date can not be later than the 
     * date</div> <div>specified in the time of creation. If a 
     * wrong start</div> <div>date or an end date is specified, a 
     * BUS error</div> <div>issue will be returned.</div>
     * 
     * <p>Other Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700211CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p><p>Example use is to record a 
     * dispense pickup time on the Rx Pickup Notification 
     * interaction. This time may be in the past, but cannot be in 
     * the future.</p>
     * 
     * <p>Indicates the time the change should begin (and 
     * occasionally when it should end). If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p><p>Example use is to record a 
     * dispense pickup time on the Rx Pickup Notification 
     * interaction. This time may be in the past, but cannot be in 
     * the future.</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: EventReason</p>
     * 
     * <p>Other Business Name: EventReason</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Identifies why this specific query, modification request, 
     * or modification occurred.</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold'. Also allows identifying reason for 
     * accessing information for a query.</p>
     * 
     * <p><div>This code may be used by a specific message, 
     * eg.</div> <div>Hold Prescription, Update 
     * Allergy/Intolerance</div> <div>Each message indicates the 
     * specific subdomain</div> <div>that can be sent. For messages 
     * with no</div> <div>domain, PIN will validate that no reason 
     * is being</div> <div>sent. For messages with a specified 
     * domain, if a</div> <div>code is sent, PIN will validate that 
     * the code</div> <p>comes from the specified domain.&nbsp;</p></p>
     * 
     * <p>Other Business Name: EventReason</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Identifies why this specific query, modification request, 
     * or modification occurred.</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold'. Also allows identifying reason for 
     * accessing information for a query.</p>
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
     * <p>Business Name: EventReason</p>
     * 
     * <p>Other Business Name: EventReason</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Identifies why this specific query, modification request, 
     * or modification occurred.</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold'. Also allows identifying reason for 
     * accessing information for a query.</p>
     * 
     * <p><div>This code may be used by a specific message, 
     * eg.</div> <div>Hold Prescription, Update 
     * Allergy/Intolerance</div> <div>Each message indicates the 
     * specific subdomain</div> <div>that can be sent. For messages 
     * with no</div> <div>domain, PIN will validate that no reason 
     * is being</div> <div>sent. For messages with a specified 
     * domain, if a</div> <div>code is sent, PIN will validate that 
     * the code</div> <p>comes from the specified domain.&nbsp;</p></p>
     * 
     * <p>Other Business Name: EventReason</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Identifies why this specific query, modification request, 
     * or modification occurred.</p>
     * 
     * <p>Allows identifying a reason for a specific action, such 
     * as 'reason for hold'. Also allows identifying reason for 
     * accessing information for a query.</p>
     * 
     * <p>The domain associated with this attribute will vary for 
     * each interaction and will be noted as part of the 
     * interaction description.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700210CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700210CA.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Business Name: EnteredBy</p>
     * 
     * <p>Other Business Name: EnteredBy</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.DataEnterer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Indicates the person responsible for recording 
     * the</p> <div>information into the system. This should only 
     * be</div> <div>specified if different from the author.</div>
     */
    @Hl7XmlMapping({"dataEnterer/assignedPerson"})
    public ProviderBean getDataEntererAssignedPerson() {
        return this.dataEntererAssignedPerson;
    }

    /**
     * <p>Business Name: EnteredBy</p>
     * 
     * <p>Other Business Name: EnteredBy</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.DataEnterer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Indicates the person responsible for recording 
     * the</p> <div>information into the system. This should only 
     * be</div> <div>specified if different from the author.</div>
     */
    public void setDataEntererAssignedPerson(ProviderBean dataEntererAssignedPerson) {
        this.dataEntererAssignedPerson = dataEntererAssignedPerson;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.location</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Business Name: RecordedAt</p>
     * 
     * <p>Other Business Name: RecordedAt</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700210CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Indicates the location where the record of this 
     * event</div> <div>was entered. The may be different from the 
     * location</div> <p>where the event occurred.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }

    /**
     * <p>Business Name: RecordedAt</p>
     * 
     * <p>Other Business Name: RecordedAt</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700210CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Indicates the location where the record of this 
     * event</div> <div>was entered. The may be different from the 
     * location</div> <p>where the event occurred.&nbsp;</p></p>
     */
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public RefersToBean<ACT> getSubject() {
        return this.subject;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject(RefersToBean<ACT> subject) {
        this.subject = subject;
    }


    /**
     * <p>Business Name: Caused</p>
     * 
     * <p>Other Business Name: Caused</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Identifies errors or warnings that are being 
     * managed</div> <p>as part of the current message.&nbsp;</p></p>
     * 
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700211CA.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/detectedIssueEvent","subjectOf1/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="MCAI_MT700211CA.Subject"),
        @Hl7MapByPartType(name="subjectOf/detectedIssueEvent", type="PORX_MT980020CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf1", type="MCAI_MT700210CA.Subject"),
        @Hl7MapByPartType(name="subjectOf1/detectedIssueEvent", type="PORX_MT980010CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }


    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.Subject3.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/consentEvent"})
    public ConsentBean getSubjectOf2ConsentEvent() {
        return this.subjectOf2ConsentEvent;
    }

    /**
     * <p>Other Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700210CA.Subject3.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2ConsentEvent(ConsentBean subjectOf2ConsentEvent) {
        this.subjectOf2ConsentEvent = subjectOf2ConsentEvent;
    }

}
