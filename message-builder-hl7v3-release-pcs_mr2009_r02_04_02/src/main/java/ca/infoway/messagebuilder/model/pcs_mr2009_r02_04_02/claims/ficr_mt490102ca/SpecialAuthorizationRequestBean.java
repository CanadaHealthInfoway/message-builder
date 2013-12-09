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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt490102ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActPriority;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.HealthDocumentAttachment_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.SpecialAuthorizationRequestCrossReferenceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.Subject3Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.Subject5Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.domainvalue.ActSpecialAuthorizationCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT490102CA.SpecialAuthorizationRequest"})
@Hl7RootType
public class SpecialAuthorizationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV priorityCode = new CVImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private HealthcareWorkerBean authorAssignedEntity;
    private SpecialAuthorizationRequestCrossReferenceBean predecessorSpecialAuthorizationRequestCrossReference;
    private List<SpecialAuthorizationCriteriaBean> supportSpecialAuthorizationCriteria = new ArrayList<SpecialAuthorizationCriteriaBean>();
    private Subject3Bean subject1;
    private List<Subject5Bean> subject2 = new ArrayList<Subject5Bean>();
    private PolicyOrAccountBean coveragePolicyOrAccount;
    private List<HealthDocumentAttachment_1Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_1Bean>();
    private SpecialAuthorizationBean fulfillmentSpecialAuthorization;
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();


    /**
     * <p>Business Name: Special Authority Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Special Authority Request ID</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Special Authorization Request Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSpecialAuthorizationCode getCode() {
        return (ActSpecialAuthorizationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Request Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCode(ActSpecialAuthorizationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Special Authorization Request Effective 
     * Date</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Request Effective 
     * Date</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: Special Authorization Priority Code</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActPriority getPriorityCode() {
        return (ActPriority) this.priorityCode.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Priority Code</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.priorityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setPriorityCode(ActPriority priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    /**
     * <p>Business Name: Confidentiality Restriction(s</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_VeryBasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_VeryBasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Author2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.Predecessor.specialAuthorizationRequestCrossReference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/specialAuthorizationRequestCrossReference"})
    public SpecialAuthorizationRequestCrossReferenceBean getPredecessorSpecialAuthorizationRequestCrossReference() {
        return this.predecessorSpecialAuthorizationRequestCrossReference;
    }

    /**
     * <p>Relationship: 
     * FICR_MT490102CA.Predecessor.specialAuthorizationRequestCrossReference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPredecessorSpecialAuthorizationRequestCrossReference(SpecialAuthorizationRequestCrossReferenceBean predecessorSpecialAuthorizationRequestCrossReference) {
        this.predecessorSpecialAuthorizationRequestCrossReference = predecessorSpecialAuthorizationRequestCrossReference;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.Support2.specialAuthorizationCriteria</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"support/specialAuthorizationCriteria"})
    public List<SpecialAuthorizationCriteriaBean> getSupportSpecialAuthorizationCriteria() {
        return this.supportSpecialAuthorizationCriteria;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.subject1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"subject1"})
    public Subject3Bean getSubject1() {
        return this.subject1;
    }

    /**
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.subject1</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setSubject1(Subject3Bean subject1) {
        this.subject1 = subject1;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.subject2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-20)</p>
     */
    @Hl7XmlMapping({"subject2"})
    public List<Subject5Bean> getSubject2() {
        return this.subject2;
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Coverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public PolicyOrAccountBean getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Coverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCoveragePolicyOrAccount(PolicyOrAccountBean coveragePolicyOrAccount) {
        this.coveragePolicyOrAccount = coveragePolicyOrAccount;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.PertinentInformation.healthDocumentAttachment</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/healthDocumentAttachment"})
    public List<HealthDocumentAttachment_1Bean> getPertinentInformationHealthDocumentAttachment() {
        return this.pertinentInformationHealthDocumentAttachment;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment/specialAuthorization"})
    public SpecialAuthorizationBean getFulfillmentSpecialAuthorization() {
        return this.fulfillmentSpecialAuthorization;
    }

    /**
     * <p>Relationship: 
     * FICR_MT490102CA.InFulfillmentOf.specialAuthorization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillmentSpecialAuthorization(SpecialAuthorizationBean fulfillmentSpecialAuthorization) {
        this.fulfillmentSpecialAuthorization = fulfillmentSpecialAuthorization;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorizationRequest.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }

}
