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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090102ca.HealthcareWorkerBean;
import java.util.Date;



/**
 * <p>IssueManagements</p>
 * 
 * <p>COCT_MT260012CA.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p><p>The processes and procedures employed by providers to 
 * resolve clinical and business issues between the action 
 * being performed and additional information already in the 
 * patient's record or system business rules.</p></p>
 * 
 * <p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>It allows overriding of the detected issue</p></p>
 * 
 * <p>COCT_MT260010CA.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p><p>The processes and procedures employed by providers to 
 * resolve clinical and business issues between the action 
 * being performed and additional information already in the 
 * patient's record or system business rules.</p></p>
 * 
 * <p><p>A_DetectedMedicationIssue</p></p>
 * 
 * <p><p>It allows overriding of the detected issue</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.DetectedIssueManagement","COCT_MT260012CA.DetectedIssueManagement"})
public class IssueManagements_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();
    private ST text = new STImpl();
    private TS authorTime = new TSImpl();
    private HealthcareWorkerBean authorAssignedEntity;


    /**
     * <p>ManagementType</p>
     * 
     * <p>A:Management Type</p>
     * 
     * <p><p>Indicates the kinds of management actions that have 
     * been taken, depending on the issue type.</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>ManagedContraindication.State</p><p>OverrideReason.reason</p><p>D65(when 
     * dealing with clinical indication overrides, otherwise use 
     * overrides in ControlAct 
     * wrapper.</p><p>ZPB3.10</p><p>Intervention 
     * Codes</p><p>ZPS.8</p><p>ZPS.15</p><p>ZDP.21.1</p><p>DRU.100-02</p><p>DRU.100-03</p><p>DUR/PPS.440-E6</p><p>DUR/PPS.441-E6</p><p>Claim.420-DK</p><p>A_DetectedMedicationIssue</p></p>
     * 
     * <p><p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p></p>
     * 
     * <p><p>Ensures consistency in description of management 
     * actions.</p><p>This is mandatory so as to ensure distinction 
     * between different kinds of management.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueManagementCode getCode() {
        return (ActDetectedIssueManagementCode) this.code.getValue();
    }
    public void setCode(ActDetectedIssueManagementCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>ManagementDescription</p>
     * 
     * <p>C:Management Description</p>
     * 
     * <p><p>Additional free-text details describing the management 
     * of the issue.</p></p>
     * 
     * <p><p>Allows additional clinical detail to be conveyed that 
     * are important clinically and not conveyed by the code.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>ManagementDate</p>
     * 
     * <p>B:Management Date</p>
     * 
     * <p><p>The date and time on which the provider managed the 
     * issue.</p></p>
     * 
     * <p><p>ManagedContraindication.CreationDate</p></p>
     * 
     * <p><p>Part of the audit record, but not always available and 
     * therefore 'populated'.</p></p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getAuthorTime() {
        return this.authorTime.getValue();
    }
    public void setAuthorTime(Date authorTime) {
        this.authorTime.setValue(authorTime);
    }


    @Hl7XmlMapping({"author/assignedEntity"})
    public HealthcareWorkerBean getAuthorAssignedEntity() {
        return this.authorAssignedEntity;
    }
    public void setAuthorAssignedEntity(HealthcareWorkerBean authorAssignedEntity) {
        this.authorAssignedEntity = authorAssignedEntity;
    }

}
