/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pharmacy.merged;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ChangedByBean;
import java.util.Date;



/**
 * <p>PORX_MT060340CA.ControlActEvent: Status Changes</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription, including why the changes were made, 
 * who made them and when.</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>PORX_MT060160CA.ControlActEvent: Status Changes</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription, including why the changes were made, 
 * who made them and when.</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>PORX_MT060210CA.ControlActEvent: Other Medication Status 
 * Changes</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the other medication record, including why the changes 
 * were made, who made them and when.</p>
 * 
 * <p>Provides an audit trail of a patient's use of other 
 * medications.</p>
 * 
 * <p>PORX_MT060040CA.ControlActEvent: Status Changes</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription, including why the changes were made, 
 * who made them and when.</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>PORX_MT060090CA.ControlActEvent: Dispense Status Changes</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription dispense, including why the changes were 
 * made, who made them and when.</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 * 
 * <p>PORX_MT060010CA.ControlActEvent: Dispense Status Changes</p>
 * 
 * <p>This records the history of changes that have been made 
 * to the prescription dispense, including why the changes were 
 * made, who made them and when.</p>
 * 
 * <p>Provides an audit trail of a patient's therapy 
 * adjustments. Status changes may affect evaluations of 
 * compliance.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060010CA.ControlActEvent","PORX_MT060040CA.ControlActEvent","PORX_MT060090CA.ControlActEvent","PORX_MT060160CA.ControlActEvent","PORX_MT060210CA.ControlActEvent","PORX_MT060340CA.ControlActEvent"})
public class StatusChangesBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private ChangedByBean author;


    /**
     * <p>Dispense Status Change Type</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Aborted, etc.</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Change Type</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Other Medication Status Change Type</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Completed, Aborted, etc.</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>Dispense Status Change Type</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Aborted, etc.</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Change Type</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Other Medication Status Change Type</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Completed, Aborted, etc.</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Change Effective Period</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Dispense Status Change Effective Date</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription dispense become valid and applicable. In the 
     * case of a suspend, may also indicate the scheduled time at 
     * which the status change will end.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Other Medication Status Change Effective Period</p>
     * 
     * <p>The date on which the various status changes of an other 
     * medication record become valid and applicable. In the case 
     * of a suspend, may also indicate the scheduled time at which 
     * the status change will end.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Change Effective Period</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Dispense Status Change Effective Date</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription dispense become valid and applicable. In the 
     * case of a suspend, may also indicate the scheduled time at 
     * which the status change will end.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Other Medication Status Change Effective Period</p>
     * 
     * <p>The date on which the various status changes of an other 
     * medication record become valid and applicable. In the case 
     * of a suspend, may also indicate the scheduled time at which 
     * the status change will end.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Dispense Status Change Reason</p>
     * 
     * <p>Denotes the reason the status of the prescription 
     * dispense was changed.</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Other Medication Status Change Reason</p>
     * 
     * <p>Denotes the reason the status of the other medication was 
     * changed.</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Change Reason</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public ControlActReason getReasonCode() {
        return (ControlActReason) this.reasonCode.getValue();
    }

    /**
     * <p>Dispense Status Change Reason</p>
     * 
     * <p>Denotes the reason the status of the prescription 
     * dispense was changed.</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Other Medication Status Change Reason</p>
     * 
     * <p>Denotes the reason the status of the other medication was 
     * changed.</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Change Reason</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"author"})
    public ChangedByBean getAuthor() {
        return this.author;
    }

    public void setAuthor(ChangedByBean author) {
        this.author = author;
    }

}
