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
package ca.infoway.messagebuilder.model.ab_r02_05_00_pa.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActPriority;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.claims.ficr_mt400001ca.FormRoleBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.common.merged.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.domainvalue.ActSpecialAuthorizationCode;
import ca.infoway.messagebuilder.model.ab_r02_05_00_pa.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT400001CA.SpecialAuthorizationRequest","FICR_MT400003CA.SpecialAuthorizationRequest","FICR_MT400004CA.SpecialAuthorizationRequest","FICR_MT490003CA.SpecialAuthorizationRequest","FICR_MT490101CA.SpecialAuthorizationRequest"})
@Hl7RootType
public class SpecialAuthorizationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20140501L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private HealthcareOrganizationBean authorAssignedEntity;
    private Subject3Bean subject;
    private SpecialAuthorizationBean fulfillmentSpecialAuthorization;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV priorityCode = new CVImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private FormRoleBean directTargetFormRole;
    private ContactPartyBean callBackContactContactParty;
    private SpecialAuthorizationRequestCrossReferenceBean predecessorSpecialAuthorizationRequestCrossReference;
    private List<SpecialAuthorizationCriteriaBean> supportSpecialAuthorizationCriteria = new ArrayList<SpecialAuthorizationCriteriaBean>();
    private PolicyOrAccount_1Bean coveragePolicyOrAccount;
    private List<HealthDocumentAttachment_1Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_1Bean>();
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();
    private List<Subject5Bean> subject1 = new ArrayList<Subject5Bean>();
    private SpecialAuthorizationAdditionalInformationRequestBean referenceSpecialAuthorizationAdditionalInformationRequest;


    /**
     * <p>Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestID</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSpecialAuthorizationCode getCode() {
        return (ActSpecialAuthorizationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationRequestType</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActSpecialAuthorizationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: RequestStatus</p>
     * 
     * <p>Un-merged Business Name: RequestStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RequestStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RequestStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: RequestStatus</p>
     * 
     * <p>Un-merged Business Name: RequestStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RequestStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT490003CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: RequestStatus</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareOrganizationBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400003CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT490101CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400004CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntity(HealthcareOrganizationBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.subject2</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject","subject2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subject", type="FICR_MT400001CA.Subject3"),
        @Hl7MapByPartType(name="subject", type="FICR_MT400003CA.Subject3"),
        @Hl7MapByPartType(name="subject", type="FICR_MT400004CA.Subject3"),
        @Hl7MapByPartType(name="subject2", type="FICR_MT490101CA.Subject3")})
    public Subject3Bean getSubject() {
        return this.subject;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.SpecialAuthorizationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.subject2</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.SpecialAuthorizationRequest.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubject(Subject3Bean subject) {
        this.subject = subject;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/specialAuthorization"})
    public SpecialAuthorizationBean getFulfillmentSpecialAuthorization() {
        return this.fulfillmentSpecialAuthorization;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400003CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillmentSpecialAuthorization(SpecialAuthorizationBean fulfillmentSpecialAuthorization) {
        this.fulfillmentSpecialAuthorization = fulfillmentSpecialAuthorization;
    }


    /**
     * <p>Business Name: SpecialAuthorizationRequestEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: 
     * SpecialAuthorizationRequestEffectiveDate</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: SpecialAuthorizationRequestEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: 
     * SpecialAuthorizationRequestEffectiveDate</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: SpecialAuthorizationPriorityCode</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationPriorityCode</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActPriority getPriorityCode() {
        return (ActPriority) this.priorityCode.getValue();
    }

    /**
     * <p>Business Name: SpecialAuthorizationPriorityCode</p>
     * 
     * <p>Un-merged Business Name: SpecialAuthorizationPriorityCode</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPriorityCode(ActPriority priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Business Name: ConfidentialityRestrictionS</p>
     * 
     * <p>Un-merged Business Name: ConfidentialityRestrictionS</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400001CA.DirectTarget3.formRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"directTarget/formRole"})
    public FormRoleBean getDirectTargetFormRole() {
        return this.directTargetFormRole;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400001CA.DirectTarget3.formRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDirectTargetFormRole(FormRoleBean directTargetFormRole) {
        this.directTargetFormRole = directTargetFormRole;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CallBackContact.contactParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"callBackContact/contactParty"})
    public ContactPartyBean getCallBackContactContactParty() {
        return this.callBackContactContactParty;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.CallBackContact.contactParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCallBackContactContactParty(ContactPartyBean callBackContactContactParty) {
        this.callBackContactContactParty = callBackContactContactParty;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.Predecessor.specialAuthorizationRequestCrossReference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/specialAuthorizationRequestCrossReference"})
    public SpecialAuthorizationRequestCrossReferenceBean getPredecessorSpecialAuthorizationRequestCrossReference() {
        return this.predecessorSpecialAuthorizationRequestCrossReference;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.Predecessor.specialAuthorizationRequestCrossReference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPredecessorSpecialAuthorizationRequestCrossReference(SpecialAuthorizationRequestCrossReferenceBean predecessorSpecialAuthorizationRequestCrossReference) {
        this.predecessorSpecialAuthorizationRequestCrossReference = predecessorSpecialAuthorizationRequestCrossReference;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.Support2.specialAuthorizationCriteria</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"support/specialAuthorizationCriteria"})
    public List<SpecialAuthorizationCriteriaBean> getSupportSpecialAuthorizationCriteria() {
        return this.supportSpecialAuthorizationCriteria;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Coverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public PolicyOrAccount_1Bean getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: FICR_MT400001CA.Coverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCoveragePolicyOrAccount(PolicyOrAccount_1Bean coveragePolicyOrAccount) {
        this.coveragePolicyOrAccount = coveragePolicyOrAccount;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.PertinentInformation.healthDocumentAttachment</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/healthDocumentAttachment"})
    public List<HealthDocumentAttachment_1Bean> getPertinentInformationHealthDocumentAttachment() {
        return this.pertinentInformationHealthDocumentAttachment;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT490101CA.SpecialAuthorizationRequest.subject1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    @Hl7XmlMapping({"subject1"})
    public List<Subject5Bean> getSubject1() {
        return this.subject1;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.Reference.specialAuthorizationAdditionalInformationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"reference/specialAuthorizationAdditionalInformationRequest"})
    public SpecialAuthorizationAdditionalInformationRequestBean getReferenceSpecialAuthorizationAdditionalInformationRequest() {
        return this.referenceSpecialAuthorizationAdditionalInformationRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * FICR_MT400004CA.Reference.specialAuthorizationAdditionalInformationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setReferenceSpecialAuthorizationAdditionalInformationRequest(SpecialAuthorizationAdditionalInformationRequestBean referenceSpecialAuthorizationAdditionalInformationRequest) {
        this.referenceSpecialAuthorizationAdditionalInformationRequest = referenceSpecialAuthorizationAdditionalInformationRequest;
    }

}