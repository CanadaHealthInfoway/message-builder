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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.merged;

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
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.Author1Bean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.sessionmgmt.coct_mt090107ca.ProviderBean;
import java.util.Date;



/**
 * <p>Business Name: StatusChanges</p>
 * 
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
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.ControlActEvent","PORX_MT060340CA.ControlActEvent"})
public class StatusChangesBean extends MessagePartBean {

    private static final long serialVersionUID = 20131210L;
    private CV code = new CVImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV reasonCode = new CVImpl();
    private Author1Bean author;
    private ProviderBean responsiblePartyAssignedPerson;


    /**
     * <p>Business Name: ChangeType</p>
     * 
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Distinguishes discontinueStatus, holdStatus, 
     * reactivateStatus and releaseStatus</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Distinguishes discontinueStatus, holdStatus, 
     * reactivateStatus and releaseStatus</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     */
    @Hl7XmlMapping({"code"})
    public HL7TriggerEventCode getCode() {
        return (HL7TriggerEventCode) this.code.getValue();
    }

    /**
     * <p>Business Name: ChangeType</p>
     * 
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Distinguishes discontinueStatus, holdStatus, 
     * reactivateStatus and releaseStatus</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     * 
     * <p>Un-merged Business Name: ChangeType</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what kind of change occurred. Examples include 
     * Suspended, Superseded, Released, Aborted (stopped), etc.</p>
     * 
     * <p>Distinguishes discontinueStatus, holdStatus, 
     * reactivateStatus and releaseStatus</p>
     * 
     * <p>This attribute is mandatory to ensure that change types 
     * are distinguishable.</p>
     */
    public void setCode(HL7TriggerEventCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
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
     * <p>Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Allows applications to sort and filter by time.</p><p>The 
     * effective date can be defaulted to change date, and thus is 
     * mandatory.</p>
     * 
     * <p>Un-merged Business Name: ChangeEffectivePeriod</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ControlActEvent.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the various status changes of a 
     * prescription become valid and applicable. In the case of a 
     * suspend, may also indicate the scheduled time at which the 
     * status change will end.</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
     * 
     * <p>PrescriptionStatus.initialEndDate</p><p>PrescriptionStatus.actualEndDate</p><p>Prescription.cancelTime</p><p>Prescription.holdReleaseDate</p><p>Prescription.holdStartDate</p><p>Prescription.modificationTime</p><p>Prescription.stopDate</p><p>Prescription.reactivateDate</p><p>ZPB3.14(when 
     * code is discontinued)</p>
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
     * <p>Business Name: ChangeReason</p>
     * 
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>PrescriptionStatus.reason(mnemonic)</p><p>PrescriptionStatus.adhocReason(originalText)</p>
     * 
     * <p>PrescriptionStatus.reason(mnemonic)</p><p>PrescriptionStatus.adhocReason(originalText)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>PrescriptionStatus.reason(mnemonic)</p><p>PrescriptionStatus.adhocReason(originalText)</p>
     * 
     * <p>PrescriptionStatus.reason(mnemonic)</p><p>PrescriptionStatus.adhocReason(originalText)</p>
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
     * <p>Business Name: ChangeReason</p>
     * 
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>PrescriptionStatus.reason(mnemonic)</p><p>PrescriptionStatus.adhocReason(originalText)</p>
     * 
     * <p>PrescriptionStatus.reason(mnemonic)</p><p>PrescriptionStatus.adhocReason(originalText)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     * 
     * <p>Un-merged Business Name: ChangeReason</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.reasonCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Denotes the reason the status of the prescription was 
     * changed.</p>
     * 
     * <p>PrescriptionStatus.reason(mnemonic)</p><p>PrescriptionStatus.adhocReason(originalText)</p>
     * 
     * <p>PrescriptionStatus.reason(mnemonic)</p><p>PrescriptionStatus.adhocReason(originalText)</p>
     * 
     * <p>Ensures consistent terminology in capturing and 
     * interpreting reasons for change. Allows CWE because not all 
     * reasons will correspond to a pre-defined code.</p>
     */
    public void setReasonCode(ControlActReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public Author1Bean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060340CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060160CA.ControlActEvent.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(Author1Bean author) {
        this.author = author;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ResponsibleParty6.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty3.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060160CA.ResponsibleParty6.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }

}
