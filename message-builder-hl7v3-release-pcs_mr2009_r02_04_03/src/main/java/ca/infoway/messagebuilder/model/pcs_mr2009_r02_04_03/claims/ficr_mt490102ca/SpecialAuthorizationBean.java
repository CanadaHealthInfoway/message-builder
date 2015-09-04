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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.ficr_mt490102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.MaximumLimitsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged.Subject4Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT490102CA.SpecialAuthorization"})
public class SpecialAuthorizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150903L;
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private HealthcareOrganizationBean authorAssignedEntity;
    private List<Subject4Bean> subject = new ArrayList<Subject4Bean>();
    private PolicyOrAccountBean coveragePolicyOrAccount;
    private RemainingLimitsBean limitation1RemainingLimits;
    private MaximumLimitsBean limitation2MaximumLimits;
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();


    /**
     * <p>Business Name: Special Authorization Status</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorization.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Status</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorization.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: Special Authorization Effective Date</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: Special Authorization Effective Date</p>
     * 
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorization.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Author3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareOrganizationBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Author3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedEntity(HealthcareOrganizationBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorization.subject</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-100)</p>
     */
    @Hl7XmlMapping({"subject"})
    public List<Subject4Bean> getSubject() {
        return this.subject;
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Coverage2.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public PolicyOrAccountBean getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Coverage2.policyOrAccount</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setCoveragePolicyOrAccount(PolicyOrAccountBean coveragePolicyOrAccount) {
        this.coveragePolicyOrAccount = coveragePolicyOrAccount;
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Limitation2.remainingLimits</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"limitation1/remainingLimits"})
    public RemainingLimitsBean getLimitation1RemainingLimits() {
        return this.limitation1RemainingLimits;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Limitation2.remainingLimits</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLimitation1RemainingLimits(RemainingLimitsBean limitation1RemainingLimits) {
        this.limitation1RemainingLimits = limitation1RemainingLimits;
    }


    /**
     * <p>Relationship: FICR_MT490102CA.Limitation.maximumLimits</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"limitation2/maximumLimits"})
    public MaximumLimitsBean getLimitation2MaximumLimits() {
        return this.limitation2MaximumLimits;
    }

    /**
     * <p>Relationship: FICR_MT490102CA.Limitation.maximumLimits</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLimitation2MaximumLimits(MaximumLimitsBean limitation2MaximumLimits) {
        this.limitation2MaximumLimits = limitation2MaximumLimits;
    }


    /**
     * <p>Relationship: 
     * FICR_MT490102CA.SpecialAuthorization.subjectOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-100)</p>
     */
    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }

}
