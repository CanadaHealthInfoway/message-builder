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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueCode;
import ca.infoway.messagebuilder.domainvalue.ActIssuePriority;
import ca.infoway.messagebuilder.domainvalue.SeverityObservation;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT030040CA.DetectedIssueEvent","PORX_MT060040CA.DetectedIssueEvent","PORX_MT060060CA.DetectedIssueEvent","PORX_MT060160CA.DetectedIssueEvent","PORX_MT060190CA.DetectedIssueEvent","PORX_MT060340CA.DetectedIssueEvent","PORX_MT980010CA.DetectedIssueEvent","PORX_MT980020CA.DetectedIssueEvent","PORX_MT980030CA.DetectedIssueEvent"})
@Hl7RootType
public class IssuesBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private CV priorityCode = new CVImpl();
    private List<CausalActs> subjectCausalActs = new ArrayList<CausalActs>();
    private IssueDescriptionBean instantiationDetectedIssueDefinition;
    private List<IssueManagementsBean> mitigatedByDetectedIssueManagement = new ArrayList<IssueManagementsBean>();
    private CV subjectOfSeverityObservationValue = new CVImpl();
    private BL triggerForActRequest = new BLImpl(false);
    private BL subjectOf1StorageIntent = new BLImpl(false);


    /**
     * <p>IssueType</p>
     * 
     * <p>Issue Type</p>
     * 
     * <p>A:Issue Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueCode getCode() {
        return (ActDetectedIssueCode) this.code.getValue();
    }
    public void setCode(ActDetectedIssueCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Issue Comment</p>
     * 
     * <p>D:Issue Details</p>
     * 
     * <p>B:Issue Comment</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>IssuePriority</p>
     * 
     * <p>C:Issue Priority</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public ActIssuePriority getPriorityCode() {
        return (ActIssuePriority) this.priorityCode.getValue();
    }
    public void setPriorityCode(ActIssuePriority priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    @Hl7XmlMapping({"subject/causalActs"})
    public List<CausalActs> getSubjectCausalActs() {
        return this.subjectCausalActs;
    }


    @Hl7XmlMapping({"instantiation/detectedIssueDefinition"})
    public IssueDescriptionBean getInstantiationDetectedIssueDefinition() {
        return this.instantiationDetectedIssueDefinition;
    }
    public void setInstantiationDetectedIssueDefinition(IssueDescriptionBean instantiationDetectedIssueDefinition) {
        this.instantiationDetectedIssueDefinition = instantiationDetectedIssueDefinition;
    }


    @Hl7XmlMapping({"mitigatedBy/detectedIssueManagement"})
    public List<IssueManagementsBean> getMitigatedByDetectedIssueManagement() {
        return this.mitigatedByDetectedIssueManagement;
    }


    /**
     * <p>SeverityCode</p>
     * 
     * <p>B:Severity Code</p>
     */
    @Hl7XmlMapping({"subjectOf/severityObservation/value","subjectOf2/severityObservation/value"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf", type="PORX_MT980010CA.Subject"),
        @Hl7MapByPartType(name="subjectOf", type="PORX_MT980030CA.Subject"),
        @Hl7MapByPartType(name="subjectOf/severityObservation", type="PORX_MT980010CA.SeverityObservation"),
        @Hl7MapByPartType(name="subjectOf/severityObservation", type="PORX_MT980030CA.SeverityObservation"),
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT980020CA.Subject"),
        @Hl7MapByPartType(name="subjectOf2/severityObservation", type="PORX_MT980020CA.SeverityObservation")})
    public SeverityObservation getSubjectOfSeverityObservationValue() {
        return (SeverityObservation) this.subjectOfSeverityObservationValue.getValue();
    }
    public void setSubjectOfSeverityObservationValue(SeverityObservation subjectOfSeverityObservationValue) {
        this.subjectOfSeverityObservationValue.setValue(subjectOfSeverityObservationValue);
    }


    @Hl7XmlMapping({"triggerFor/actRequest"})
    public Boolean getTriggerForActRequest() {
        return this.triggerForActRequest.getValue();
    }
    public void setTriggerForActRequest(Boolean triggerForActRequest) {
        this.triggerForActRequest.setValue(triggerForActRequest);
    }


    @Hl7XmlMapping({"subjectOf1/storageIntent"})
    public Boolean getSubjectOf1StorageIntent() {
        return this.subjectOf1StorageIntent.getValue();
    }
    public void setSubjectOf1StorageIntent(Boolean subjectOf1StorageIntent) {
        this.subjectOf1StorageIntent.setValue(subjectOf1StorageIntent);
    }

}
