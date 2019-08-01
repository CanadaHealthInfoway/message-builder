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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03_imm.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: IssueManagements</p>
 * 
 * <p>COCT_MT260022CA.DetectedIssueManagement: Issue 
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
 * <p>COCT_MT260030CA.DetectedIssueManagement: Issue 
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
@Hl7PartTypeMapping({"COCT_MT260020CA.DetectedIssueManagement","COCT_MT260022CA.DetectedIssueManagement","COCT_MT260030CA.DetectedIssueManagement"})
public class IssueManagements_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private CreatedByBean author;


    /**
     * <p>Business Name: ManagementType</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * COCT_MT260022CA.DetectedIssueManagement.code</p>
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
     * COCT_MT260030CA.DetectedIssueManagement.code</p>
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
     * COCT_MT260020CA.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * COCT_MT260022CA.DetectedIssueManagement.code</p>
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
     * COCT_MT260030CA.DetectedIssueManagement.code</p>
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
     * COCT_MT260020CA.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
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
     * COCT_MT260022CA.DetectedIssueManagement.text</p>
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
     * COCT_MT260030CA.DetectedIssueManagement.text</p>
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
     * COCT_MT260020CA.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
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
     * COCT_MT260022CA.DetectedIssueManagement.text</p>
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
     * COCT_MT260030CA.DetectedIssueManagement.text</p>
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
     * COCT_MT260020CA.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260022CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"author"})
    public CreatedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260022CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260030CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * COCT_MT260020CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAuthor(CreatedByBean author) {
        this.author = author;
    }

}
