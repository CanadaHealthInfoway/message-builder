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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.quqi_mt020000ca;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt090502ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt240002ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt260012ca.IssuesBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt470002ca.ConsentBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt910102ca.RelatedPersonBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt911102ca.ActingPerson;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.AuthenticationTokenBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.Patient;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged.QueryByParameterBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CreatedByBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.IsPartOfBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt050202ca.PatientBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt090102ca.AssignedPersonBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Business Name: Trigger Event</p>
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
@Hl7PartTypeMapping({"QUQI_MT020000CA.ControlActEvent"})
@Hl7RootType
public class TriggerEventBean<PL> extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private Patient recordTargetPatient1;
    private AssignedPersonBean responsiblePartyAssignedEntity;
    private CreatedByBean author;
    private ActingPerson dataEntererActingPerson;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private ServiceLocationBean dataEntryLocationServiceDeliveryLocation;
    private AuthenticationTokenBean pertinentInformationAuthorizationToken;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private ConsentBean subjectOf2ConsentEvent;
    private List<IsPartOfBean> componentOf = new ArrayList<IsPartOfBean>();
    private QueryByParameterBean<PL> queryByParameter;


    /**
     * <p>Business Name: B:Event Identifier</p>
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
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Event Identifier</p>
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
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.code</p>
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
     * <p>Business Name: A:Event Type</p>
     * 
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.code</p>
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
     * <p>Business Name: C:Event Effective Period</p>
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
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Event Effective Period</p>
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
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Event Reason</p>
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
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Business Name: E:Event Reason</p>
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
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"recordTarget/patient1"})
    public Patient getRecordTargetPatient1() {
        return this.recordTargetPatient1;
    }

    /**
     * <p>Relationship: QUQI_MT020000CA.RecordTarget.patient1</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRecordTargetPatient1(Patient recordTargetPatient1) {
        this.recordTargetPatient1 = recordTargetPatient1;
    }

    public PatientBean getRecordTargetPatient1AsPatient1() {
        return this.recordTargetPatient1 instanceof PatientBean ? (PatientBean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient1() {
        return (this.recordTargetPatient1 instanceof PatientBean);
    }

    public ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050207ca.PatientBean getRecordTargetPatient1AsPatient2() {
        return this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050207ca.PatientBean ? (ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050207ca.PatientBean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient2() {
        return (this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050207ca.PatientBean);
    }

    public ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050201ca.PatientBean getRecordTargetPatient1AsPatient3() {
        return this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050201ca.PatientBean ? (ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050201ca.PatientBean) this.recordTargetPatient1 : null;
    }
    public boolean hasRecordTargetPatient1AsPatient3() {
        return (this.recordTargetPatient1 instanceof ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt050201ca.PatientBean);
    }


    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public AssignedPersonBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.ResponsibleParty.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(AssignedPersonBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public CreatedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setAuthor(CreatedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.DataEnterer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"dataEnterer/actingPerson"})
    public ActingPerson getDataEntererActingPerson() {
        return this.dataEntererActingPerson;
    }

    /**
     * <p>Relationship: QUQI_MT020000CA.DataEnterer.actingPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDataEntererActingPerson(ActingPerson dataEntererActingPerson) {
        this.dataEntererActingPerson = dataEntererActingPerson;
    }

    public AssignedPersonBean getDataEntererActingPersonAsAssignedEntity1() {
        return this.dataEntererActingPerson instanceof AssignedPersonBean ? (AssignedPersonBean) this.dataEntererActingPerson : null;
    }
    public boolean hasDataEntererActingPersonAsAssignedEntity1() {
        return (this.dataEntererActingPerson instanceof AssignedPersonBean);
    }

    public HealthcareOrganizationBean getDataEntererActingPersonAsAssignedEntity2() {
        return this.dataEntererActingPerson instanceof HealthcareOrganizationBean ? (HealthcareOrganizationBean) this.dataEntererActingPerson : null;
    }
    public boolean hasDataEntererActingPersonAsAssignedEntity2() {
        return (this.dataEntererActingPerson instanceof HealthcareOrganizationBean);
    }

    public RelatedPersonBean getDataEntererActingPersonAsPersonalRelationship() {
        return this.dataEntererActingPerson instanceof RelatedPersonBean ? (RelatedPersonBean) this.dataEntererActingPerson : null;
    }
    public boolean hasDataEntererActingPersonAsPersonalRelationship() {
        return (this.dataEntererActingPerson instanceof RelatedPersonBean);
    }


    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"dataEntryLocation/serviceDeliveryLocation"})
    public ServiceLocationBean getDataEntryLocationServiceDeliveryLocation() {
        return this.dataEntryLocationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.DataEntryLocation.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDataEntryLocationServiceDeliveryLocation(ServiceLocationBean dataEntryLocationServiceDeliveryLocation) {
        this.dataEntryLocationServiceDeliveryLocation = dataEntryLocationServiceDeliveryLocation;
    }


    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.PertinentInformation.authorizationToken</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/authorizationToken"})
    public AuthenticationTokenBean getPertinentInformationAuthorizationToken() {
        return this.pertinentInformationAuthorizationToken;
    }

    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.PertinentInformation.authorizationToken</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPertinentInformationAuthorizationToken(AuthenticationTokenBean pertinentInformationAuthorizationToken) {
        this.pertinentInformationAuthorizationToken = pertinentInformationAuthorizationToken;
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.Subject.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.Subject3.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/consentEvent"})
    public ConsentBean getSubjectOf2ConsentEvent() {
        return this.subjectOf2ConsentEvent;
    }

    /**
     * <p>Relationship: QUQI_MT020000CA.Subject3.consentEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2ConsentEvent(ConsentBean subjectOf2ConsentEvent) {
        this.subjectOf2ConsentEvent = subjectOf2ConsentEvent;
    }


    /**
     * <p>Relationship: QUQI_MT020000CA.ControlActEvent.componentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"componentOf"})
    public List<IsPartOfBean> getComponentOf() {
        return this.componentOf;
    }


    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"queryByParameter"})
    public QueryByParameterBean<PL> getQueryByParameter() {
        return this.queryByParameter;
    }

    /**
     * <p>Relationship: 
     * QUQI_MT020000CA.ControlActEvent.queryByParameter</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setQueryByParameter(QueryByParameterBean<PL> queryByParameter) {
        this.queryByParameter = queryByParameter;
    }

}
