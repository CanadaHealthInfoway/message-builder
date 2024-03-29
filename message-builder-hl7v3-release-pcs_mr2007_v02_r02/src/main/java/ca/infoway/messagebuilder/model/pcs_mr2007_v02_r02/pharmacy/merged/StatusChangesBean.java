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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ControlActReason;
import ca.infoway.messagebuilder.domainvalue.HL7TriggerEventCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.ChangedByBean;
import java.util.Date;



/**
 * <p>PORX_MT060160CA.ControlActEvent: Status Changes</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription, including why the changes were made, 
 * who made them and when.</p>
 * 
 * <p>PORX_MT060010CA.ControlActEvent: Dispense Status Changes</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription dispense, including why the changes were 
 * made, who made them and when.</p>
 * 
 * <p>PORX_MT060040CA.ControlActEvent: Status Changes</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription, including why the changes were made, 
 * who made them and when.</p>
 * 
 * <p>PORX_MT060340CA.ControlActEvent: Status Changes</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription, including why the changes were made, 
 * who made them and when.</p>
 * 
 * <p>PORX_MT060210CA.ControlActEvent: Other Medication Status 
 * Changes</p>
 * 
 * <p>Provides an audit trail of a patient's use of other 
 * medications.</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the other medication record, including why the changes 
 * were made, who made them and when.</p>
 * 
 * <p>PORX_MT060090CA.ControlActEvent: Dispense Status Changes</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription dispense, including why the changes were 
 * made, who made them and when.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060010CA.ControlActEvent","PORX_MT060040CA.ControlActEvent","PORX_MT060090CA.ControlActEvent","PORX_MT060160CA.ControlActEvent","PORX_MT060210CA.ControlActEvent","PORX_MT060340CA.ControlActEvent"})
public class StatusChangesBean extends MessagePartBean {

    private static final long serialVersionUID = 20190730L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private ChangedByBean author;


    /**
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatusChangeType</p>
     * 
     * <p>Relationship: PORX_MT060010CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Aborted, etc.</p>
     * 
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060040CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Un-merged Business Name: OtherMedicationStatusChangeType</p>
     * 
     * <p>Relationship: PORX_MT060210CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Completed, Aborted, etc.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatusChangeType</p>
     * 
     * <p>Relationship: PORX_MT060090CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Aborted, etc.</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatusChangeType</p>
     * 
     * <p>Relationship: PORX_MT060010CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Aborted, etc.</p>
     * 
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060040CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Un-merged Business Name: OtherMedicationStatusChangeType</p>
     * 
     * <p>Relationship: PORX_MT060210CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Completed, Aborted, etc.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatusChangeType</p>
     * 
     * <p>Relationship: PORX_MT060090CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Aborted, etc.</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseStatusChangeEffectiveDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription dispense become valid and applicable. In the 
     * case of a suspend, may also indicate the scheduled time at 
     * which the status change will end.</p>
     * 
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>Un-merged Business Name: 
     * OtherMedicationStatusChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060210CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of an other 
     * medication record become valid and applicable. In the case 
     * of a suspend, may also indicate the scheduled time at which 
     * the status change will end.</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseStatusChangeEffectiveDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription dispense become valid and applicable. In the 
     * case of a suspend, may also indicate the scheduled time at 
     * which the status change will end.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseStatusChangeEffectiveDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription dispense become valid and applicable. In the 
     * case of a suspend, may also indicate the scheduled time at 
     * which the status change will end.</p>
     * 
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>Un-merged Business Name: 
     * OtherMedicationStatusChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060210CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of an other 
     * medication record become valid and applicable. In the case 
     * of a suspend, may also indicate the scheduled time at which 
     * the status change will end.</p>
     * 
     * <p>Un-merged Business Name: 
     * DispenseStatusChangeEffectiveDate</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription dispense become valid and applicable. In the 
     * case of a suspend, may also indicate the scheduled time at 
     * which the status change will end.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatusChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060010CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription 
     * dispense was changed.</p>
     * 
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060040CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>Un-merged Business Name: 
     * OtherMedicationStatusChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060210CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the other medication was 
     * changed.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatusChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060090CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription 
     * dispense was changed.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatusChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060010CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription 
     * dispense was changed.</p>
     * 
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060040CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>Un-merged Business Name: 
     * OtherMedicationStatusChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060210CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the other medication was 
     * changed.</p>
     * 
     * <p>Un-merged Business Name: DispenseStatusChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060090CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Denotes the reason the status of the prescription 
     * dispense was changed.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ResponsibleParty6.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ResponsibleParty4.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060210CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty4.assignedEntity</p>
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
     * PORX_MT060160CA.ResponsibleParty6.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060010CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060040CA.ResponsibleParty4.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty3.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060210CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060090CA.ResponsibleParty4.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060210CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.ControlActEvent.author</p>
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
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060210CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }

}
