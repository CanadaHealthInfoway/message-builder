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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt260020ca.Subject3Bean;
import ca.infoway.messagebuilder.model.common.coct_mt260030ca.CausalActsBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT260010CA.DetectedIssueEvent","COCT_MT260012CA.DetectedIssueEvent","COCT_MT260020CA.DetectedIssueEvent","COCT_MT260022CA.DetectedIssueEvent","COCT_MT260030CA.DetectedIssueEvent","PORX_MT030040CA.DetectedIssueEvent","PORX_MT060040CA.DetectedIssueEvent","PORX_MT060060CA.DetectedIssueEvent","PORX_MT060160CA.DetectedIssueEvent","PORX_MT060190CA.DetectedIssueEvent","PORX_MT060340CA.DetectedIssueEvent"})
@Hl7RootType
public class IssuesBean extends MessagePartBean {

    private CV<ActDetectedIssueCode> issueType = new CVImpl<ActDetectedIssueCode>();
    private ST issueDetails = new STImpl();
    private CV<ActIssuePriority> issuePriority = new CVImpl<ActIssuePriority>();
    private List<CausalActsBean> subjectCausalActs = new ArrayList<CausalActsBean>();
    private IsDefinedByBean instantiation;
    private List<ManagedByBean> mitigatedBy = new ArrayList<ManagedByBean>();
    private CV<SeverityObservation> severityLevel = new CVImpl<SeverityObservation>();
    private ManagementRequiredBean triggerFor;
    private Subject3Bean subjectOf1;
    private CV<SeverityObservation> subjectOf2SeverityObservationValue = new CVImpl<SeverityObservation>();

    @Hl7XmlMapping({"code"})
    public ActDetectedIssueCode getIssueType() {
        return this.issueType.getValue();
    }
    public void setIssueType(ActDetectedIssueCode issueType) {
        this.issueType.setValue(issueType);
    }

    @Hl7XmlMapping({"text"})
    public java.lang.String getIssueDetails() {
        return this.issueDetails.getValue();
    }
    public void setIssueDetails(java.lang.String issueDetails) {
        this.issueDetails.setValue(issueDetails);
    }

    @Hl7XmlMapping({"priorityCode"})
    public ActIssuePriority getIssuePriority() {
        return this.issuePriority.getValue();
    }
    public void setIssuePriority(ActIssuePriority issuePriority) {
        this.issuePriority.setValue(issuePriority);
    }

    @Hl7XmlMapping({"subject/causalActs"})
    public List<CausalActsBean> getSubjectCausalActs() {
        return this.subjectCausalActs;
    }

    @Hl7XmlMapping({"instantiation"})
    public IsDefinedByBean getInstantiation() {
        return this.instantiation;
    }
    public void setInstantiation(IsDefinedByBean instantiation) {
        this.instantiation = instantiation;
    }

    @Hl7XmlMapping({"mitigatedBy"})
    public List<ManagedByBean> getMitigatedBy() {
        return this.mitigatedBy;
    }

    @Hl7XmlMapping({"subjectOf/severityObservation/value"})
    public SeverityObservation getSeverityLevel() {
        return this.severityLevel.getValue();
    }
    public void setSeverityLevel(SeverityObservation severityLevel) {
        this.severityLevel.setValue(severityLevel);
    }

    @Hl7XmlMapping({"triggerFor"})
    public ManagementRequiredBean getTriggerFor() {
        return this.triggerFor;
    }
    public void setTriggerFor(ManagementRequiredBean triggerFor) {
        this.triggerFor = triggerFor;
    }

    @Hl7XmlMapping({"subjectOf1"})
    public Subject3Bean getSubjectOf1() {
        return this.subjectOf1;
    }
    public void setSubjectOf1(Subject3Bean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }

    @Hl7XmlMapping({"subjectOf2/severityObservation/value"})
    public SeverityObservation getSubjectOf2SeverityObservationValue() {
        return this.subjectOf2SeverityObservationValue.getValue();
    }
    public void setSubjectOf2SeverityObservationValue(SeverityObservation subjectOf2SeverityObservationValue) {
        this.subjectOf2SeverityObservationValue.setValue(subjectOf2SeverityObservationValue);
    }

}
