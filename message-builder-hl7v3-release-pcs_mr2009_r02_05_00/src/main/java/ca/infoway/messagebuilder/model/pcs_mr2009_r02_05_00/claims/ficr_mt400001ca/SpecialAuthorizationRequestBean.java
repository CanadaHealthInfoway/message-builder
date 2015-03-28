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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.ficr_mt400001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActPriority;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged.ContactPartyBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged.HealthDocumentAttachment_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged.PolicyOrAccount_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged.SpecialAuthorizationChoice_1;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged.SpecialAuthorizationCriteriaBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.claims.merged.SpecialAuthorizationRequestCrossReferenceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActSpecialAuthorizationCode;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.ActiveMedicationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"FICR_MT400001CA.SpecialAuthorizationRequest"})
@Hl7RootType
public class SpecialAuthorizationRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV priorityCode = new CVImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private FormRoleBean directTargetFormRole;
    private ContactPartyBean callBackContactContactParty;
    private SpecialAuthorizationRequestCrossReferenceBean predecessorSpecialAuthorizationRequestCrossReference;
    private List<SpecialAuthorizationCriteriaBean> supportSpecialAuthorizationCriteria = new ArrayList<SpecialAuthorizationCriteriaBean>();
    private SpecialAuthorizationChoice_1 subjectSpecialAuthorizationChoice;
    private PolicyOrAccount_1Bean coveragePolicyOrAccount;
    private List<HealthDocumentAttachment_1Bean> pertinentInformationHealthDocumentAttachment = new ArrayList<HealthDocumentAttachment_1Bean>();
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();


    /**
     * <p>Business Name: Special Authorization Request Type</p>
     * 
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.code</p>
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
     * FICR_MT400001CA.SpecialAuthorizationRequest.code</p>
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
     * FICR_MT400001CA.SpecialAuthorizationRequest.effectiveTime</p>
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
     * FICR_MT400001CA.SpecialAuthorizationRequest.effectiveTime</p>
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
     * FICR_MT400001CA.SpecialAuthorizationRequest.priorityCode</p>
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
     * FICR_MT400001CA.SpecialAuthorizationRequest.priorityCode</p>
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
     * FICR_MT400001CA.SpecialAuthorizationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Relationship: FICR_MT400001CA.DirectTarget3.formRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"directTarget/formRole"})
    public FormRoleBean getDirectTargetFormRole() {
        return this.directTargetFormRole;
    }

    /**
     * <p>Relationship: FICR_MT400001CA.DirectTarget3.formRole</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDirectTargetFormRole(FormRoleBean directTargetFormRole) {
        this.directTargetFormRole = directTargetFormRole;
    }


    /**
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
     * <p>Relationship: 
     * FICR_MT400001CA.CallBackContact.contactParty</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCallBackContactContactParty(ContactPartyBean callBackContactContactParty) {
        this.callBackContactContactParty = callBackContactContactParty;
    }


    /**
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
     * <p>Relationship: 
     * FICR_MT400001CA.Predecessor.specialAuthorizationRequestCrossReference</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPredecessorSpecialAuthorizationRequestCrossReference(SpecialAuthorizationRequestCrossReferenceBean predecessorSpecialAuthorizationRequestCrossReference) {
        this.predecessorSpecialAuthorizationRequestCrossReference = predecessorSpecialAuthorizationRequestCrossReference;
    }


    /**
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
     * <p>Relationship: 
     * FICR_MT400001CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/specialAuthorizationChoice"})
    public SpecialAuthorizationChoice_1 getSubjectSpecialAuthorizationChoice() {
        return this.subjectSpecialAuthorizationChoice;
    }

    /**
     * <p>Relationship: 
     * FICR_MT400001CA.Subject3.specialAuthorizationChoice</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectSpecialAuthorizationChoice(SpecialAuthorizationChoice_1 subjectSpecialAuthorizationChoice) {
        this.subjectSpecialAuthorizationChoice = subjectSpecialAuthorizationChoice;
    }

    public ActiveMedicationBean getSubjectSpecialAuthorizationChoiceAsSubstanceAdministration() {
        return this.subjectSpecialAuthorizationChoice instanceof ActiveMedicationBean ? (ActiveMedicationBean) this.subjectSpecialAuthorizationChoice : null;
    }
    public boolean hasSubjectSpecialAuthorizationChoiceAsSubstanceAdministration() {
        return (this.subjectSpecialAuthorizationChoice instanceof ActiveMedicationBean);
    }

    public DevicePassThruBean getSubjectSpecialAuthorizationChoiceAsDevicePassThru() {
        return this.subjectSpecialAuthorizationChoice instanceof DevicePassThruBean ? (DevicePassThruBean) this.subjectSpecialAuthorizationChoice : null;
    }
    public boolean hasSubjectSpecialAuthorizationChoiceAsDevicePassThru() {
        return (this.subjectSpecialAuthorizationChoice instanceof DevicePassThruBean);
    }


    /**
     * <p>Relationship: FICR_MT400001CA.Coverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public PolicyOrAccount_1Bean getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }

    /**
     * <p>Relationship: FICR_MT400001CA.Coverage.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setCoveragePolicyOrAccount(PolicyOrAccount_1Bean coveragePolicyOrAccount) {
        this.coveragePolicyOrAccount = coveragePolicyOrAccount;
    }


    /**
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
     * <p>Relationship: 
     * FICR_MT400001CA.SpecialAuthorizationRequest.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }

}
