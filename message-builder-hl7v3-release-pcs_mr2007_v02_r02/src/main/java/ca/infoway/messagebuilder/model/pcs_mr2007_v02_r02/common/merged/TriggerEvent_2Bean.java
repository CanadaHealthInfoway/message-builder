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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ServiceLocationBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>TriggerEvent</p>
 * 
 * <p>MCAI_MT700230CA.ControlActEvent: Trigger Event</p>
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
 * <p>MCAI_MT700237CA.ControlActEvent: Trigger Event</p>
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
 * <p>MCAI_MT700232CA.ControlActEvent: Trigger Event</p>
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
 * <p>MCAI_MT700231CA.ControlActEvent: Trigger Event</p>
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
 * <p>MCAI_MT700236CA.ControlActEvent: Trigger Event</p>
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
 * <p>QUQI_MT000001CA.ControlActEvent: Trigger Event</p>
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
@Hl7PartTypeMapping({"MCAI_MT700230CA.ControlActEvent","MCAI_MT700231CA.ControlActEvent","MCAI_MT700232CA.ControlActEvent","MCAI_MT700236CA.ControlActEvent","MCAI_MT700237CA.ControlActEvent","QUQI_MT000001CA.ControlActEvent"})
@Hl7RootType
public class TriggerEvent_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private StoredInBean recordTarget;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private CreatedBy_1Bean author;
    private ActingPerson dataEntererActingPerson;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private CreatedAtBean location;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();
    private II queryContinuationQueryId = new IIImpl();
    private INT queryContinuationStartResultNumber = new INTImpl();
    private INT queryContinuationContinuationQuantity = new INTImpl();


    /**
     * <p>EventIdentifier</p>
     * 
     * <p>B:Event Identifier</p>
     * 
     * <p><p>A unique identifier for this particular event assigned 
     * by the system in which the event occurred.</p></p>
     * 
     * <p><p>Allows the event to be referenced (for undos) and also 
     * indicates whether multiple interactions were caused by the 
     * same triggering event. Also used for audit purposes.</p></p>
     * 
     * <p><p>Identifier needs to be persisted by receiving 
     * applications, except for queries (queries cannot be 
     * retracted or undone).</p></p>
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
     * <p><p>Indicates the time the event (e.g. query, change, 
     * activation) should begin and occasionally when it should 
     * end.</p></p>
     * 
     * <p><p>The time an event becomes effective may differ from 
     * the time the event is recorded (i.e. it may be in the future 
     * or the past). For events such as 'suspend', an intended end 
     * date may also be indicated.</p></p>
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
     * <p><p>Identifies why this specific message interaction (e.g. 
     * query, activation request, modification request) 
     * occurred.</p></p>
     * 
     * <p><p>Allows identifying a reason for a specific action, 
     * such as 'reason for hold' or 'reason for accessing 
     * information'.</p></p>
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


    @Hl7XmlMapping({"recordTarget"})
    public StoredInBean getRecordTarget() {
        return this.recordTarget;
    }
    public void setRecordTarget(StoredInBean recordTarget) {
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
    public CreatedBy_1Bean getAuthor() {
        return this.author;
    }
    public void setAuthor(CreatedBy_1Bean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"dataEnterer/actingPerson"})
    public ActingPerson getDataEntererActingPerson() {
        return this.dataEntererActingPerson;
    }
    public void setDataEntererActingPerson(ActingPerson dataEntererActingPerson) {
        this.dataEntererActingPerson = dataEntererActingPerson;
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


    @Hl7XmlMapping({"pertinentInformation/authorizationToken"})
    public AuthenticationTokenBean getPertinentInformationAuthorizationToken() {
        return this.pertinentInformationAuthorizationToken;
    }
    public void setPertinentInformationAuthorizationToken(AuthenticationTokenBean pertinentInformationAuthorizationToken) {
        this.pertinentInformationAuthorizationToken = pertinentInformationAuthorizationToken;
    }


    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }


    /**
     * <p>QueryIdentifier</p>
     * 
     * <p>H:Query Identifier</p>
     * 
     * <p><p>Unique number for the query to be continued.</p></p>
     * 
     * <p><p>Links to the query for which continuation is desired. 
     * Needed to ensure that the query is not re-executed, as the 
     * results may have changed. As a result, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"queryContinuation/queryId"})
    public Identifier getQueryContinuationQueryId() {
        return this.queryContinuationQueryId.getValue();
    }
    public void setQueryContinuationQueryId(Identifier queryContinuationQueryId) {
        this.queryContinuationQueryId.setValue(queryContinuationQueryId);
    }


    /**
     * <p>StartPosition</p>
     * 
     * <p>I:Start Position</p>
     * 
     * <p><p>Indicates the record number at which to start the 
     * returned result set.</p></p>
     * 
     * <p><p>Indicates what point the query should continue from 
     * and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"queryContinuation/startResultNumber"})
    public Integer getQueryContinuationStartResultNumber() {
        return this.queryContinuationStartResultNumber.getValue();
    }
    public void setQueryContinuationStartResultNumber(Integer queryContinuationStartResultNumber) {
        this.queryContinuationStartResultNumber.setValue(queryContinuationStartResultNumber);
    }


    /**
     * <p>QueryLimit</p>
     * 
     * <p>J:Query Limit</p>
     * 
     * <p><p>Indicates how many records should be returned for this 
     * query.</p></p>
     * 
     * <p><p>Allows an application to control the number of 
     * returned records. If not specified, the EHR may apply a 
     * default limit.</p></p>
     */
    @Hl7XmlMapping({"queryContinuation/continuationQuantity"})
    public Integer getQueryContinuationContinuationQuantity() {
        return this.queryContinuationContinuationQuantity.getValue();
    }
    public void setQueryContinuationContinuationQuantity(Integer queryContinuationContinuationQuantity) {
        this.queryContinuationContinuationQuantity.setValue(queryContinuationContinuationQuantity);
    }

}
