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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.merged;

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
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt090107on.ProviderBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt240003on.ServiceLocationBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.merged.RefusedByBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: TriggerEvent</p>
 * 
 * <p>MCAI_MT700220ON.ControlActEvent: Trigger Event</p>
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
 * 
 * <p>MCAI_MT700221ON.ControlActEvent: Trigger Event</p>
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
@Hl7PartTypeMapping({"MCAI_MT700220ON.ControlActEvent","MCAI_MT700221ON.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_2Bean<ACT> extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private CV reasonCode = new CVImpl();
    private RefersToBean<ACT> subject;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();
    private ProviderBean responsiblePartyAssignedPerson;
    private RefusedByBean author;
    private ProviderBean dataEntererAssignedPerson;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private ServiceLocationBean locationServiceDeliveryLocation;


    /**
     * <p>Business Name: EventIdentifier</p>
     * 
     * <p>Un-merged Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.ControlActEvent.id</p>
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
     * 
     * <p>Un-merged Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.id</p>
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
     * <p>Business Name: EventIdentifier</p>
     * 
     * <p>Un-merged Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.ControlActEvent.id</p>
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
     * 
     * <p>Un-merged Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.id</p>
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
     * <p>Business Name: EventType</p>
     * 
     * <p>Un-merged Business Name: EventType</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>Un-merged Business Name: EventType</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.code</p>
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
     * <p>Business Name: EventType</p>
     * 
     * <p>Un-merged Business Name: EventType</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>Un-merged Business Name: EventType</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.code</p>
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
     * <p>Business Name: EventEffectivePeriod</p>
     * 
     * <p>Un-merged Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700220ON.ControlActEvent.effectiveTime</p>
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
     * 
     * <p>Un-merged Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221ON.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Indicates the time the occurred. If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: EventEffectivePeriod</p>
     * 
     * <p>Un-merged Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700220ON.ControlActEvent.effectiveTime</p>
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
     * 
     * <p>Un-merged Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221ON.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The time a change becomes effective may differ from the 
     * time the event is recorded. (I.e. it may be in the future or 
     * the past). For changes such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Indicates the time the occurred. If not specified, 
     * assumption is that the event occurred at the same time the 
     * message was constructed.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: EventReason</p>
     * 
     * <p>Un-merged Business Name: EventReason</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.ControlActEvent.reasonCode</p>
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
     * 
     * <p>Un-merged Business Name: EventReason</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.reasonCode</p>
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
     * <p>Business Name: EventReason</p>
     * 
     * <p>Un-merged Business Name: EventReason</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.ControlActEvent.reasonCode</p>
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
     * 
     * <p>Un-merged Business Name: EventReason</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.reasonCode</p>
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subject"})
    public RefersToBean<ACT> getSubject() {
        return this.subject;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.subject</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubject(RefersToBean<ACT> subject) {
        this.subject = subject;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700220ON.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221ON.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221ON.ResponsibleParty.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.DataEnterer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"dataEnterer/assignedPerson"})
    public ProviderBean getDataEntererAssignedPerson() {
        return this.dataEntererAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: MCAI_MT700221ON.DataEnterer.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDataEntererAssignedPerson(ProviderBean dataEntererAssignedPerson) {
        this.dataEntererAssignedPerson = dataEntererAssignedPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221ON.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221ON.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * MCAI_MT700221ON.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }

}