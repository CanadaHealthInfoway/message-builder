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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CausedBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedByBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.ServiceLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: TriggerEvent</p>
 * 
 * <p>QUQI_MT020000CA.ControlActEvent: Trigger Event</p>
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
 * <p>QUQI_MT020002CA.ControlActEvent: Trigger Event</p>
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
@Hl7PartTypeMapping({"QUQI_MT020000CA.ControlActEvent","QUQI_MT020002CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_3Bean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20130103L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private StoredInBean recordTarget;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedByBean author;
    private ActingPerson dataEntererActingPerson;
    private CreatedAtBean location;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private List<CausedBean> subjectOf1 = new ArrayList<CausedBean>();
    private AuthorizedByBean subjectOf2;
    private List<CareCompositionsBean> componentOf = new ArrayList<CareCompositionsBean>();
    private QueryByParameterBean<PL> queryByParameter;


    /**
     * <p>Business Name: EventIdentifier</p>
     * 
     * <p>Un-merged Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * 
     * <p>Un-merged Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Business Name: EventIdentifier</p>
     * 
     * <p>Un-merged Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * 
     * <p>Un-merged Business Name: EventIdentifier</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * <p>Business Name: EventType</p>
     * 
     * <p>Un-merged Business Name: EventType</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p>Un-merged Business Name: EventType</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.code</p>
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
     * <p>Un-merged Business Name: EventType</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the trigger event that occurred.</p>
     * 
     * <p>This is mandatory because it is essential to 
     * understanding the meaning of the event.</p>
     * 
     * <p>Un-merged Business Name: EventType</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.code</p>
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
     * <p>Un-merged Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p>
     * 
     * <p>The time an event becomes effective may differ from the 
     * time the event is recorded (i.e. it may be in the future or 
     * the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Un-merged Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Business Name: EventEffectivePeriod</p>
     * 
     * <p>Un-merged Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p>
     * 
     * <p>The time an event becomes effective may differ from the 
     * time the event is recorded (i.e. it may be in the future or 
     * the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p>
     * 
     * <p>Un-merged Business Name: EventEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Business Name: EventReason</p>
     * 
     * <p>Un-merged Business Name: EventReason</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * 
     * <p>Un-merged Business Name: EventReason</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * <p>Business Name: EventReason</p>
     * 
     * <p>Un-merged Business Name: EventReason</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * 
     * <p>Un-merged Business Name: EventReason</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.recordTarget</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"recordTarget"})
    public StoredInBean getRecordTarget() {
        return this.recordTarget;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.recordTarget</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRecordTarget(StoredInBean recordTarget) {
        this.recordTarget = recordTarget;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public CreatedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAuthor(CreatedByBean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.DataEnterer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.DataEnterer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"dataEnterer/actingPerson"})
    public ActingPerson getDataEntererActingPerson() {
        return this.dataEntererActingPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.DataEnterer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.DataEnterer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDataEntererActingPerson(ActingPerson dataEntererActingPerson) {
        this.dataEntererActingPerson = dataEntererActingPerson;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.location</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.location</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.location</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.location</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.PertinentInformation.authorizationToken</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.PertinentInformation.authorizationToken</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/authorizationToken"})
    public AuthenticationTokenBean getPertinentInformationAuthorizationToken() {
        return this.pertinentInformationAuthorizationToken;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.PertinentInformation.authorizationToken</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.PertinentInformation.authorizationToken</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPertinentInformationAuthorizationToken(AuthenticationTokenBean pertinentInformationAuthorizationToken) {
        this.pertinentInformationAuthorizationToken = pertinentInformationAuthorizationToken;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-50)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.subjectOf1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-50)</p>
     */
    @Hl7XmlMapping({"subjectOf1"})
    public List<CausedBean> getSubjectOf1() {
        return this.subjectOf1;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subjectOf2"})
    public AuthorizedByBean getSubjectOf2() {
        return this.subjectOf2;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020002CA.ControlActEvent.subjectOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubjectOf2(AuthorizedByBean subjectOf2) {
        this.subjectOf2 = subjectOf2;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.componentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"componentOf"})
    public List<CareCompositionsBean> getComponentOf() {
        return this.componentOf;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"queryByParameter"})
    public QueryByParameterBean<PL> getQueryByParameter() {
        return this.queryByParameter;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * QUQI_MT020002CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setQueryByParameter(QueryByParameterBean<PL> queryByParameter) {
        this.queryByParameter = queryByParameter;
    }

}
