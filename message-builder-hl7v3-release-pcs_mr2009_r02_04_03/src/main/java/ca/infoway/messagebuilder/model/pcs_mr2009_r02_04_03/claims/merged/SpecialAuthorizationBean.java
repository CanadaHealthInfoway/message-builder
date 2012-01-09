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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca.HealthcareOrganizationBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.IncludesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT400003CA.SpecialAuthorization","FICR_MT400004CA.SpecialAuthorization","FICR_MT490101CA.SpecialAuthorization"})
public class SpecialAuthorizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private HealthcareOrganizationBean authorAssignedEntity;
    private PolicyOrAccount_1Bean coveragePolicyOrAccount;
    private List<Subject3Bean> subject = new ArrayList<Subject3Bean>();
    private MaximumLimitsBean limitationMaximumLimits;
    private List<IncludesBean> subjectOf = new ArrayList<IncludesBean>();


    /**
     * <p>SpecialAuthorizationStatus</p>
     * 
     * <p>Special Authorization Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>SpecialAuthorizationEffectiveDate</p>
     * 
     * <p>Special Authorization Effective Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareOrganizationBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(HealthcareOrganizationBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }


    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public PolicyOrAccount_1Bean getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }
    public void setCoveragePolicyOrAccount(PolicyOrAccount_1Bean coveragePolicyOrAccount) {
        this.coveragePolicyOrAccount = coveragePolicyOrAccount;
    }


    @Hl7XmlMapping({"subject"})
    public List<Subject3Bean> getSubject() {
        return this.subject;
    }


    @Hl7XmlMapping({"limitation/maximumLimits"})
    public MaximumLimitsBean getLimitationMaximumLimits() {
        return this.limitationMaximumLimits;
    }
    public void setLimitationMaximumLimits(MaximumLimitsBean limitationMaximumLimits) {
        this.limitationMaximumLimits = limitationMaximumLimits;
    }


    @Hl7XmlMapping({"subjectOf"})
    public List<IncludesBean> getSubjectOf() {
        return this.subjectOf;
    }

}