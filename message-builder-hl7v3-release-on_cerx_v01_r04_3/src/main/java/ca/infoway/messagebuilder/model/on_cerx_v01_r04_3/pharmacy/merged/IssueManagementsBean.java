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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt090107on.ProviderBean;
import java.util.Date;



/**
 * <p>Business Name: IssueManagements</p>
 * 
 * <p>PORX_MT980020ON.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p>A_DetectedMedicationIssue</p>
 * 
 * <p>Presents alternatives for how the issue could be managed 
 * or has been managed in the past.</p>
 * 
 * <p>The processes and procedures employed by providers to 
 * resolve clinical conflicts between the action being 
 * performed and additional information already in the 
 * patient's record.</p>
 * 
 * <p>PORX_MT980010ON.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p>A_DetectedMedicationIssue</p>
 * 
 * <p>It allows overriding of the detected issue</p>
 * 
 * <p>The processes and procedures employed by providers to 
 * resolve clinical and business issues between the action 
 * being performed and additional information already in the 
 * patient's record or system business rules.</p>
 * 
 * <p>PORX_MT980030ON.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p>A_DetectedMedicationIssue</p>
 * 
 * <p>It allows overriding of the detected issue</p>
 * 
 * <p>The processes and procedures employed by providers to 
 * resolve clinical and business issues between the action 
 * being performed and additional information already in the 
 * patient's record or system business rules.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980010ON.DetectedIssueManagement","PORX_MT980020ON.DetectedIssueManagement","PORX_MT980030ON.DetectedIssueManagement"})
public class IssueManagementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20130614L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private TS authorTime = new TSImpl();
    private ProviderBean authorAssignedPerson;


    /**
     * <p>Business Name: ManagementType</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010ON.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ManagedContraindication.State</p>
     * 
     * <p>OverrideReason.reason</p>
     * 
     * <p>D65(when dealing with clinical indication overrides, 
     * otherwise use overrides in ControlAct wrapper.</p>
     * 
     * <p>ZPB3.10</p>
     * 
     * <p>Intervention Codes</p>
     * 
     * <p>ZPS.8</p>
     * 
     * <p>ZPS.15</p>
     * 
     * <p>ZDP.21.1</p>
     * 
     * <p>DRU.100-02</p>
     * 
     * <p>DRU.100-03</p>
     * 
     * <p>DUR/PPS.440-E6</p>
     * 
     * <p>DUR/PPS.441-E6</p>
     * 
     * <p>Claim.420-DK</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Indicates the kinds of management actions that have been 
     * taken, depending on the issue type.</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020ON.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ManagedContraindication.State</p>
     * 
     * <p>OverrideReason.reason</p>
     * 
     * <p>D65(when dealing with clinical indication overrides, 
     * otherwise use overrides in ControlAct wrapper.</p>
     * 
     * <p>ZPB3.10</p>
     * 
     * <p>Intervention Codes</p>
     * 
     * <p>ZPS.8</p>
     * 
     * <p>ZPS.15</p>
     * 
     * <p>ZDP.21.1</p>
     * 
     * <p>DRU.100-02</p>
     * 
     * <p>DRU.100-03</p>
     * 
     * <p>DUR/PPS.440-E6</p>
     * 
     * <p>DUR/PPS.441-E6</p>
     * 
     * <p>Claim.420-DK</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Indicates the kinds of management actions that can be 
     * taken, based on the issue type.</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030ON.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ManagedContraindication.State</p>
     * 
     * <p>OverrideReason.reason</p>
     * 
     * <p>D65(when dealing with clinical indication overrides, 
     * otherwise use overrides in ControlAct wrapper.</p>
     * 
     * <p>ZPB3.10</p>
     * 
     * <p>Intervention Codes</p>
     * 
     * <p>ZPS.8</p>
     * 
     * <p>ZPS.15</p>
     * 
     * <p>ZDP.21.1</p>
     * 
     * <p>DRU.100-02</p>
     * 
     * <p>DRU.100-03</p>
     * 
     * <p>DUR/PPS.440-E6</p>
     * 
     * <p>DUR/PPS.441-E6</p>
     * 
     * <p>Claim.420-DK</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Indicates the kinds of management actions that have been 
     * taken, depending on the issue type.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueManagementCode getCode() {
        return (ActDetectedIssueManagementCode) this.code.getValue();
    }

    /**
     * <p>Business Name: ManagementType</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010ON.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ManagedContraindication.State</p>
     * 
     * <p>OverrideReason.reason</p>
     * 
     * <p>D65(when dealing with clinical indication overrides, 
     * otherwise use overrides in ControlAct wrapper.</p>
     * 
     * <p>ZPB3.10</p>
     * 
     * <p>Intervention Codes</p>
     * 
     * <p>ZPS.8</p>
     * 
     * <p>ZPS.15</p>
     * 
     * <p>ZDP.21.1</p>
     * 
     * <p>DRU.100-02</p>
     * 
     * <p>DRU.100-03</p>
     * 
     * <p>DUR/PPS.440-E6</p>
     * 
     * <p>DUR/PPS.441-E6</p>
     * 
     * <p>Claim.420-DK</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Indicates the kinds of management actions that have been 
     * taken, depending on the issue type.</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020ON.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ManagedContraindication.State</p>
     * 
     * <p>OverrideReason.reason</p>
     * 
     * <p>D65(when dealing with clinical indication overrides, 
     * otherwise use overrides in ControlAct wrapper.</p>
     * 
     * <p>ZPB3.10</p>
     * 
     * <p>Intervention Codes</p>
     * 
     * <p>ZPS.8</p>
     * 
     * <p>ZPS.15</p>
     * 
     * <p>ZDP.21.1</p>
     * 
     * <p>DRU.100-02</p>
     * 
     * <p>DRU.100-03</p>
     * 
     * <p>DUR/PPS.440-E6</p>
     * 
     * <p>DUR/PPS.441-E6</p>
     * 
     * <p>Claim.420-DK</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Indicates the kinds of management actions that can be 
     * taken, based on the issue type.</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030ON.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ManagedContraindication.State</p>
     * 
     * <p>OverrideReason.reason</p>
     * 
     * <p>D65(when dealing with clinical indication overrides, 
     * otherwise use overrides in ControlAct wrapper.</p>
     * 
     * <p>ZPB3.10</p>
     * 
     * <p>Intervention Codes</p>
     * 
     * <p>ZPS.8</p>
     * 
     * <p>ZPS.15</p>
     * 
     * <p>ZDP.21.1</p>
     * 
     * <p>DRU.100-02</p>
     * 
     * <p>DRU.100-03</p>
     * 
     * <p>DUR/PPS.440-E6</p>
     * 
     * <p>DUR/PPS.441-E6</p>
     * 
     * <p>Claim.420-DK</p>
     * 
     * <p>A_DetectedMedicationIssue</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Indicates the kinds of management actions that have been 
     * taken, depending on the issue type.</p>
     */
    public void setCode(ActDetectedIssueManagementCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ManagementDescription</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010ON.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020ON.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030ON.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: ManagementDescription</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010ON.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020ON.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030ON.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: ManagementDate</p>
     * 
     * <p>Un-merged Business Name: ManagementDate</p>
     * 
     * <p>Relationship: PORX_MT980010ON.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ManagedContraindication.CreationDate</p>
     * 
     * <p>Part of the audit record, but not always available and 
     * therefore 'populated'.</p>
     * 
     * <p>The date and time on which the provider managed the 
     * issue.</p>
     * 
     * <p>Un-merged Business Name: ManagementDate</p>
     * 
     * <p>Relationship: PORX_MT980020ON.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ManagedContraindication.CreationDate</p>
     * 
     * <p>Part of the audit record but not always available and 
     * therefore only marked as 'populated'.</p>
     * 
     * <p>The date and time on which the provider used this 
     * management for the issue in the past.</p>
     * 
     * <p>Un-merged Business Name: ManagementDate</p>
     * 
     * <p>Relationship: PORX_MT980030ON.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ManagedContraindication.CreationDate</p>
     * 
     * <p>Part of the audit record, but not always available and 
     * therefore 'populated'.</p>
     * 
     * <p>The date and time on which the provider managed the 
     * issue.</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }

    /**
     * <p>Business Name: ManagementDate</p>
     * 
     * <p>Un-merged Business Name: ManagementDate</p>
     * 
     * <p>Relationship: PORX_MT980010ON.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ManagedContraindication.CreationDate</p>
     * 
     * <p>Part of the audit record, but not always available and 
     * therefore 'populated'.</p>
     * 
     * <p>The date and time on which the provider managed the 
     * issue.</p>
     * 
     * <p>Un-merged Business Name: ManagementDate</p>
     * 
     * <p>Relationship: PORX_MT980020ON.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ManagedContraindication.CreationDate</p>
     * 
     * <p>Part of the audit record but not always available and 
     * therefore only marked as 'populated'.</p>
     * 
     * <p>The date and time on which the provider used this 
     * management for the issue in the past.</p>
     * 
     * <p>Un-merged Business Name: ManagementDate</p>
     * 
     * <p>Relationship: PORX_MT980030ON.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>ManagedContraindication.CreationDate</p>
     * 
     * <p>Part of the audit record, but not always available and 
     * therefore 'populated'.</p>
     * 
     * <p>The date and time on which the provider managed the 
     * issue.</p>
     */
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980010ON.Author1.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980020ON.Author1.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980030ON.Author1.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author/assignedPerson"})
    public ProviderBean getAuthorAssignedPerson() {
        return this.authorAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980010ON.Author1.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980020ON.Author1.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT980030ON.Author1.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthorAssignedPerson(ProviderBean authorAssignedPerson) {
        this.authorAssignedPerson = authorAssignedPerson;
    }

}
