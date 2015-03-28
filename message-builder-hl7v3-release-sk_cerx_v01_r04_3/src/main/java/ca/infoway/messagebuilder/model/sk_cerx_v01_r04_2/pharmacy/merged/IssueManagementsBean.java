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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged;

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
 * <p>PORX_MT980030CA.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p>The processes and procedures employed by providers to 
 * resolve clinical and business issues between the action 
 * being performed and additional information already in the 
 * patient's record or system business rules.</p>
 * 
 * <p>A_DetectedMedicationIssue</p>
 * 
 * <p>It allows overriding of the detected issue</p>
 * 
 * <p>PORX_MT980010CA.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p>The processes and procedures employed by providers to 
 * resolve clinical and business issues between the action 
 * being performed and additional information already in the 
 * patient's record or system business rules.</p>
 * 
 * <p>A_DetectedMedicationIssue</p>
 * 
 * <p>It allows overriding of the detected issue</p>
 * 
 * <p>PORX_MT980020CA.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p>The processes and procedures employed by providers to 
 * resolve clinical conflicts between the action being 
 * performed and additional information already in the 
 * patient's record.</p>
 * 
 * <p>A_DetectedMedicationIssue</p>
 * 
 * <p>Presents alternatives for how the issue could be managed 
 * or has been managed in the past.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980010CA.DetectedIssueManagement","PORX_MT980020CA.DetectedIssueManagement","PORX_MT980030CA.DetectedIssueManagement"})
public class IssueManagementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private ManagedByBean author;


    /**
     * <p>Business Name: ManagementType</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the kinds of management actions that have been 
     * taken, depending on the issue type.</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the kinds of management actions that have been 
     * taken, depending on the issue type.</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><
     * ... [rest of documentation truncated due to excessive length]
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
     * PORX_MT980030CA.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the kinds of management actions that have been 
     * taken, depending on the issue type.</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p>
     * 
     * <p>Un-merged Business Name: ManagementType</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.DetectedIssueManagement.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates the kinds of management actions that have been 
     * taken, depending on the issue type.</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p>
     * 
     * <p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><
     * ... [rest of documentation truncated due to excessive length]
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
     * PORX_MT980030CA.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
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
     * PORX_MT980030CA.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     * 
     * <p>Un-merged Business Name: ManagementDescription</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.DetectedIssueManagement.text</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Additional free-text details describing the management of 
     * the issue.</p>
     * 
     * <p>Allows additional clinical detail to be conveyed that are 
     * important clinically and not conveyed by the code.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: ManagedBy</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ManagedBy</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p><div>Identifies the provider who created the</div> 
     * <p>management of the issue.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: ManagedBy</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p><div>Identifies the provider who created the</div> 
     * <p>management of the issue.&nbsp;</p></p>
     */
    @Hl7XmlMapping({"author"})
    public ManagedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Business Name: ManagedBy</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: ManagedBy</p>
     * 
     * <p>Relationship: 
     * PORX_MT980010CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p><div>Identifies the provider who created the</div> 
     * <p>management of the issue.&nbsp;</p></p>
     * 
     * <p>Un-merged Business Name: ManagedBy</p>
     * 
     * <p>Relationship: 
     * PORX_MT980020CA.DetectedIssueManagement.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p><div>Identifies the provider who created the</div> 
     * <p>management of the issue.&nbsp;</p></p>
     */
    public void setAuthor(ManagedByBean author) {
        this.author = author;
    }

}
