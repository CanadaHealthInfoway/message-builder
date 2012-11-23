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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt400001ca.FormRoleBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActSpecialAuthorizationCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT400001CA.SpecialAuthorizationRequest","FICR_MT400003CA.SpecialAuthorizationRequest","FICR_MT400004CA.SpecialAuthorizationRequest","FICR_MT490003CA.SpecialAuthorizationRequest","FICR_MT490101CA.SpecialAuthorizationRequest"})
@Hl7RootType
public class SpecialAuthorizationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private HealthcareWorkerBean authorAssignedEntity;
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
     * <p>SpecialAuthorizationRequestID</p>
     * 
     * <p>Special Authorization Request ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>SpecialAuthorizationRequestID</p>
     * 
     * <p>Special Authorization Request ID</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>SpecialAuthorizationRequestType</p>
     * 
     * <p>Special Authorization Request Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSpecialAuthorizationCode getCode() {
        return (ActSpecialAuthorizationCode) this.code.getValue();
    }

    /**
     * <p>SpecialAuthorizationRequestType</p>
     * 
     * <p>Special Authorization Request Type</p>
     */
    public void setCode(ActSpecialAuthorizationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>RequestStatus</p>
     * 
     * <p>Request Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>RequestStatus</p>
     * 
     * <p>Request Status</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    @Hl7XmlMapping({"subject","subject2"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subject", type="FICR_MT400001CA.Subject3"),
        @Hl7MapByPartType(name="subject", type="FICR_MT400003CA.Subject3"),
        @Hl7MapByPartType(name="subject", type="FICR_MT400004CA.Subject3"),
        @Hl7MapByPartType(name="subject2", type="FICR_MT490101CA.Subject3")})
    public Subject3Bean getSubject() {
        return this.subject;
    }

    public void setSubject(Subject3Bean subject) {
        this.subject = subject;
    }


    @Hl7XmlMapping({"fulfillment/specialAuthorization"})
    public SpecialAuthorizationBean getFulfillmentSpecialAuthorization() {
        return this.fulfillmentSpecialAuthorization;
    }

    public void setFulfillmentSpecialAuthorization(SpecialAuthorizationBean fulfillmentSpecialAuthorization) {
        this.fulfillmentSpecialAuthorization = fulfillmentSpecialAuthorization;
    }


    /**
     * <p>SpecialAuthorizationRequestEffectiveDate</p>
     * 
     * <p>Special Authorization Request Effective Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>SpecialAuthorizationRequestEffectiveDate</p>
     * 
     * <p>Special Authorization Request Effective Date</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>SpecialAuthorizationPriorityCode</p>
     * 
     * <p>Special Authorization Priority Code</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActPriority getPriorityCode() {
        return (ActPriority) this.priorityCode.getValue();
    }

    /**
     * <p>SpecialAuthorizationPriorityCode</p>
     * 
     * <p>Special Authorization Priority Code</p>
     */
    public void setPriorityCode(ActPriority priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>ConfidentialityRestrictionS</p>
     * 
     * <p>Confidentiality Restriction(s</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"directTarget/formRole"})
    public FormRoleBean getDirectTargetFormRole() {
        return this.directTargetFormRole;
    }

    public void setDirectTargetFormRole(FormRoleBean directTargetFormRole) {
        this.directTargetFormRole = directTargetFormRole;
    }


    @Hl7XmlMapping({"callBackContact/contactParty"})
    public ContactPartyBean getCallBackContactContactParty() {
        return this.callBackContactContactParty;
    }

    public void setCallBackContactContactParty(ContactPartyBean callBackContactContactParty) {
        this.callBackContactContactParty = callBackContactContactParty;
    }


    @Hl7XmlMapping({"predecessor/specialAuthorizationRequestCrossReference"})
    public SpecialAuthorizationRequestCrossReferenceBean getPredecessorSpecialAuthorizationRequestCrossReference() {
        return this.predecessorSpecialAuthorizationRequestCrossReference;
    }

    public void setPredecessorSpecialAuthorizationRequestCrossReference(SpecialAuthorizationRequestCrossReferenceBean predecessorSpecialAuthorizationRequestCrossReference) {
        this.predecessorSpecialAuthorizationRequestCrossReference = predecessorSpecialAuthorizationRequestCrossReference;
    }


    @Hl7XmlMapping({"support/specialAuthorizationCriteria"})
    public List<SpecialAuthorizationCriteriaBean> getSupportSpecialAuthorizationCriteria() {
        return this.supportSpecialAuthorizationCriteria;
    }


    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public PolicyOrAccount_1Bean getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }

    public void setCoveragePolicyOrAccount(PolicyOrAccount_1Bean coveragePolicyOrAccount) {
        this.coveragePolicyOrAccount = coveragePolicyOrAccount;
    }


    @Hl7XmlMapping({"pertinentInformation/healthDocumentAttachment"})
    public List<HealthDocumentAttachment_1Bean> getPertinentInformationHealthDocumentAttachment() {
        return this.pertinentInformationHealthDocumentAttachment;
    }


    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }


    @Hl7XmlMapping({"subject1"})
    public List<Subject5Bean> getSubject1() {
        return this.subject1;
    }


    @Hl7XmlMapping({"reference/specialAuthorizationAdditionalInformationRequest"})
    public SpecialAuthorizationAdditionalInformationRequestBean getReferenceSpecialAuthorizationAdditionalInformationRequest() {
        return this.referenceSpecialAuthorizationAdditionalInformationRequest;
    }

    public void setReferenceSpecialAuthorizationAdditionalInformationRequest(SpecialAuthorizationAdditionalInformationRequestBean referenceSpecialAuthorizationAdditionalInformationRequest) {
        this.referenceSpecialAuthorizationAdditionalInformationRequest = referenceSpecialAuthorizationAdditionalInformationRequest;
    }

}
