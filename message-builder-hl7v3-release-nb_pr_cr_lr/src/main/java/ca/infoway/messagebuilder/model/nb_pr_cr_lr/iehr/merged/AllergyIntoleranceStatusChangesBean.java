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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.nb_pr_cr_lr.merged.ChangedByBean;
import java.util.Date;



/**
 * <p>REPC_MT000010CA.ControlActEvent: Amendment Summary</p>
 * 
 * <p> <i>Provides context information about the record.</i> 
 * </p>
 * 
 * <p> <i>Identifies information about the most recent change 
 * to the Health Condition including when it was made, by whom 
 * and why.</i> </p>
 * 
 * <p>REPC_MT000007CA.ControlActEvent: Amendment Summary</p>
 * 
 * <p> <i>Provides context information about the record.</i> 
 * </p>
 * 
 * <p> <i>Identifies information about the most recent change 
 * to the Health Condition including when it was made, by whom 
 * and why.</i> </p>
 * 
 * <p>REPC_MT000009CA.ControlActEvent: Allergy/Intolerance 
 * Status Changes</p>
 * 
 * <p>Provides a record of a patient's allergy changes, 
 * providing deeper clinical understanding, particularly of 
 * past clinical decisions.</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the allergy/intolerance, including why the changes were 
 * made, who made them and when.</p>
 */
@Hl7PartTypeMapping({"REPC_MT000007CA.ControlActEvent","REPC_MT000009CA.ControlActEvent","REPC_MT000010CA.ControlActEvent"})
public class AllergyIntoleranceStatusChangesBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private CV reasonCode = new CVImpl();
    private ChangedByBean author;
    private CV code = new CVImpl();
    private TS effectiveTime = new TSImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;


    /**
     * <p>Un-merged Business Name: AmendReason</p>
     * 
     * <p>Relationship: REPC_MT000010CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Understanding the reason for the most recent 
     * amendment provides context for the current state of the 
     * record.</i> </p><p> <i> <i>The element uses CWE to allow for 
     * the capture of Amend Reason concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </i> </p>
     * 
     * <p> <i>This indicates the reason for most recent amendment 
     * to the record as indicated by the person who made the 
     * change.</i> </p>
     * 
     * <p>Un-merged Business Name: AmendReason</p>
     * 
     * <p>Relationship: REPC_MT000007CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Understanding the reason for the most recent 
     * amendment provides context for the current state of the 
     * record.</i> </p><p> <i> <i>The element uses CWE to allow for 
     * the capture of Amend Reason concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </i> </p>
     * 
     * <p> <i>This indicates the reason for most recent amendment 
     * to the record as indicated by the person who made the 
     * change.</i> </p>
     * 
     * <p>Un-merged Business Name: 
     * AllergyIntoleranceStatusChangeReason</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the the allergy/intolerance was 
     * changed.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: AmendReason</p>
     * 
     * <p>Relationship: REPC_MT000010CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Understanding the reason for the most recent 
     * amendment provides context for the current state of the 
     * record.</i> </p><p> <i> <i>The element uses CWE to allow for 
     * the capture of Amend Reason concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </i> </p>
     * 
     * <p> <i>This indicates the reason for most recent amendment 
     * to the record as indicated by the person who made the 
     * change.</i> </p>
     * 
     * <p>Un-merged Business Name: AmendReason</p>
     * 
     * <p>Relationship: REPC_MT000007CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p> <i>Understanding the reason for the most recent 
     * amendment provides context for the current state of the 
     * record.</i> </p><p> <i> <i>The element uses CWE to allow for 
     * the capture of Amend Reason concepts not presently supported 
     * by the approved code system(s). In this case, the 
     * human-to-human benefit of capturing additional non-coded 
     * values outweighs the penalties of capturing some information 
     * that will not be amenable to searching or categorizing.</i> 
     * </i> </p>
     * 
     * <p> <i>This indicates the reason for most recent amendment 
     * to the record as indicated by the person who made the 
     * change.</i> </p>
     * 
     * <p>Un-merged Business Name: 
     * AllergyIntoleranceStatusChangeReason</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the the allergy/intolerance was 
     * changed.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000010CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000007CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000010CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000007CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }


    /**
     * <p>Business Name: AllergyIntoleranceStatusChangeType</p>
     * 
     * <p>Un-merged Business Name: 
     * AllergyIntoleranceStatusChangeType</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. 
     * Allergy/Intolerance change types are Revise, Reactivate and 
     * Complete.</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>Business Name: AllergyIntoleranceStatusChangeType</p>
     * 
     * <p>Un-merged Business Name: 
     * AllergyIntoleranceStatusChangeType</p>
     * 
     * <p>Relationship: REPC_MT000009CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. 
     * Allergy/Intolerance change types are Revise, Reactivate and 
     * Complete.</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: 
     * AllergyIntoleranceStatusChangeEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: 
     * AllergyIntoleranceStatusChangeEffectiveDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time. The date 
     * on which a change is effective should always be known and 
     * thus is mandatory.</p>
     * 
     * <p>The date on which the various changes of an 
     * allergy/intolerance become valid and applicable.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: 
     * AllergyIntoleranceStatusChangeEffectiveDate</p>
     * 
     * <p>Un-merged Business Name: 
     * AllergyIntoleranceStatusChangeEffectiveDate</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time. The date 
     * on which a change is effective should always be known and 
     * thus is mandatory.</p>
     * 
     * <p>The date on which the various changes of an 
     * allergy/intolerance become valid and applicable.</p>
     */
    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT000009CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

}
