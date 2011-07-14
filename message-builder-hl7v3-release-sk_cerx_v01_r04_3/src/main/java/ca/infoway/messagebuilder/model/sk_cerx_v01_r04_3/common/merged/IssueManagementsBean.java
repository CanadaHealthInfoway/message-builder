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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>IssueManagements</p>
 * 
 * <p>PORX_MT980030CA.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
 * processes and procedures employed by providers to resolve 
 * clinical and business issues between the action being 
 * performed and additional information already in the 
 * patient's record or system business rules.</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">It allows 
 * overriding of the detected issue</p></p>
 * 
 * <p>PORX_MT980010CA.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
 * processes and procedures employed by providers to resolve 
 * clinical and business issues between the action being 
 * performed and additional information already in the 
 * patient's record or system business rules.</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">It allows 
 * overriding of the detected issue</p></p>
 * 
 * <p>PORX_MT980020CA.DetectedIssueManagement: Issue 
 * Managements</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
 * processes and procedures employed by providers to resolve 
 * clinical conflicts between the action being performed and 
 * additional information already in the patient's record.</p></p>
 * 
 * <p><p 
 * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Presents 
 * alternatives for how the issue could be managed or has been 
 * managed in the past.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980010CA.DetectedIssueManagement","PORX_MT980020CA.DetectedIssueManagement","PORX_MT980030CA.DetectedIssueManagement"})
public class IssueManagementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private CV managementType = new CVImpl();
    private ST managementDescription = new STImpl();
    private ManagedByBean author;


    /**
     * <p>ManagementType</p>
     * 
     * <p>A:Management Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the kinds of management actions that have been taken, 
     * depending on the issue type.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-03</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.440-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.441-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.420-DK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-03</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.440-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.441-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.420-DK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-03</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.440-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.441-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.420-DK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-03</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.440-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.441-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.420-DK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-03</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.440-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.441-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.420-DK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-03</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.440-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.441-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.420-DK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-03</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.440-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.441-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.420-DK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-03</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.440-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DUR/PPS.441-E6</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.420-DK</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_DetectedMedicationIssue</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ManagedContraindication.State</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">OverrideReason.reason</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D65(when dealing 
     * with clinical indication overrides, otherwise use overrides 
     * in ControlAct wrapper.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.10</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Intervention 
     * Codes</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.8</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPS.15</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.21.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.100-02</p><
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueManagementCode getManagementType() {
        return (ActDetectedIssueManagementCode) this.managementType.getValue();
    }
    public void setManagementType(ActDetectedIssueManagementCode managementType) {
        this.managementType.setValue(managementType);
    }


    /**
     * <p>ManagementDescription</p>
     * 
     * <p>C:Management Description</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Additional 
     * free-text details describing the management of the 
     * issue.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * additional clinical detail to be conveyed that are important 
     * clinically and not conveyed by the code.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getManagementDescription() {
        return this.managementDescription.getValue();
    }
    public void setManagementDescription(String managementDescription) {
        this.managementDescription.setValue(managementDescription);
    }


    @Hl7XmlMapping({"author"})
    public ManagedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(ManagedByBean author) {
        this.author = author;
    }

}
