/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.merged;

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
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt911102ca.ActingPersonBean;
import ca.infoway.messagebuilder.model.common.quqi_mt000001ca.QueryContinuationBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"MCAI_MT700230CA.ControlActEvent","MCAI_MT700231CA.ControlActEvent","MCAI_MT700232CA.ControlActEvent","MCAI_MT700236CA.ControlActEvent","MCAI_MT700237CA.ControlActEvent","QUQI_MT000001CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean extends MessagePartBean {

    private II eventIdentifier = new IIImpl();
    private CV<HL7TriggerEventCode> eventType = new CVImpl<HL7TriggerEventCode>();
    private IVL<TS, Interval<Date>> eventEffectivePeriod = new IVLImpl<TS, Interval<Date>>();
    private CV<ControlActReason> eventReason = new CVImpl<ControlActReason>();
    private RecordTargetBean recordTarget = new RecordTargetBean();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedByBean author;
    private ActingPersonBean dataEntererActingPerson;
    private CreatedAtBean location;
    private DispenseShipToLocationBean dataEntryLocationServiceDeliveryLocation;
    private AuthenticationTokenBean pertinentInformation;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();
    private RecordTargetBean participant = new RecordTargetBean();
    private QueryContinuationBean queryContinuation = new QueryContinuationBean();

    @Hl7XmlMapping({"id"})
    public Identifier getEventIdentifier() {
        return this.eventIdentifier.getValue();
    }
    public void setEventIdentifier(Identifier eventIdentifier) {
        this.eventIdentifier.setValue(eventIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getEventType() {
        return this.eventType.getValue();
    }
    public void setEventType(HL7TriggerEventCode eventType) {
        this.eventType.setValue(eventType);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEventEffectivePeriod() {
        return this.eventEffectivePeriod.getValue();
    }
    public void setEventEffectivePeriod(Interval<Date> eventEffectivePeriod) {
        this.eventEffectivePeriod.setValue(eventEffectivePeriod);
    }

    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getEventReason() {
        return this.eventReason.getValue();
    }
    public void setEventReason(ControlActReason eventReason) {
        this.eventReason.setValue(eventReason);
    }

    @Hl7XmlMapping({"recordTarget"})
    public RecordTargetBean getRecordTarget() {
        return this.recordTarget;
    }
    public void setRecordTarget(RecordTargetBean recordTarget) {
        this.recordTarget = recordTarget;
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"author"})
    public CreatedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(CreatedByBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"dataEnterer/actingPerson"})
    public ActingPersonBean getDataEntererActingPerson() {
        return this.dataEntererActingPerson;
    }
    public void setDataEntererActingPerson(ActingPersonBean dataEntererActingPerson) {
        this.dataEntererActingPerson = dataEntererActingPerson;
    }

    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }
    public void setDataEntryLocationServiceDeliveryLocation(DispenseShipToLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"pertinentInformation"})
    public AuthenticationTokenBean getPertinentInformation() {
        return this.pertinentInformation;
    }
    public void setPertinentInformation(AuthenticationTokenBean pertinentInformation) {
        this.pertinentInformation = pertinentInformation;
    }

    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

    @Hl7XmlMapping({"participant"})
    public RecordTargetBean getParticipant() {
        return this.participant;
    }
    public void setParticipant(RecordTargetBean participant) {
        this.participant = participant;
    }

    @Hl7XmlMapping({"queryContinuation"})
    public QueryContinuationBean getQueryContinuation() {
        return this.queryContinuation;
    }
    public void setQueryContinuation(QueryContinuationBean queryContinuation) {
        this.queryContinuation = queryContinuation;
    }

}
