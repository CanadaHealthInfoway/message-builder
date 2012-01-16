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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdministrationCode;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodRequestEvent;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt220100ca.DrugProductBean;
import java.util.Date;



/**
 * <p>ActiveMedication</p>
 * 
 * <p>COCT_MT260010CA.SubstanceAdministration: Active 
 * Medication</p>
 * 
 * <p><p>Indicates an active medication (prescription or 
 * non-prescription medication) that is recorded in the 
 * patient&#226;&#128;&#153;s record and which contributed to 
 * triggering the issue.</p></p>
 * 
 * <p><p>Allows providers to identify the offending drugs when 
 * determining their management approach.</p></p>
 * 
 * <p>COCT_MT260020CA.SubstanceAdministration: Active 
 * Medication</p>
 * 
 * <p><p>Indicates an active medication (prescription or 
 * non-prescription medication) that is recorded in the 
 * patient's record and which contributed to triggering the 
 * issue.</p></p>
 * 
 * <p><p>Allows providers to identify the implicated drugs when 
 * determining their management approach.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.SubstanceAdministration","COCT_MT260020CA.SubstanceAdministration"})
public class ActiveMedicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.merged.CausalActs {

    private static final long serialVersionUID = 20120116L;
    private CS moodCode = new CSImpl();
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private PQ doseQuantity = new PQImpl();
    private DrugProductBean consumableMedication;


    /**
     * <p>OtherMedicationIndicator</p>
     * 
     * <p>Other Medication Indicator</p>
     * 
     * <p><p>If the attribute is 'RQO', represents a prescription 
     * or dispense record. Otherwise if 'EVN', it represents an 
     * 'Other Medication' record.</p></p>
     * 
     * <p><p>Knowing whether a drug is prescribed or not can 
     * influence actions taken to mitigate an issue. The element is 
     * therefore mandatory.</p></p>
     * 
     * <p>Other Medication Indicator</p>
     * 
     * <p><p>If the attribute is 'RQO', represents a prescription 
     * or dispense record. Otherwise if 'EVN', it represents an 
     * 'Other Medication' record.</p></p>
     * 
     * <p><p>Knowing whether a drug is prescribed or not can 
     * influence actions taken to mitigate an issue. This attribute 
     * is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodRequestEvent getMoodCode() {
        return (x_ActMoodRequestEvent) this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodRequestEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>ActiveMedicationRecordNumber</p>
     * 
     * <p>A:Active Medication Record Number</p>
     * 
     * <p><p>Unique identifier of the prescription or other 
     * medication drug record that triggered the issue.</p></p>
     * 
     * <p><p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p><p>InteractingPrescription.PrescriptionExternalKey</p><p>InteractingPrescription.PrescriptionNumber</p><p>DDI/Dosage/Duplicate 
     * Therapy.SourceNumber (All senders must uniquely identify 
     * prescriptions on request)</p></p>
     * 
     * <p><p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p><p>InteractingPrescription.PrescriptionExternalKey</p><p>InteractingPrescription.PrescriptionNumber</p><p>DDI/Dosage/Duplicate 
     * Therapy.SourceNumber (All senders must uniquely identify 
     * prescriptions on request)</p></p>
     * 
     * <p><p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p><p>InteractingPrescription.PrescriptionExternalKey</p><p>InteractingPrescription.PrescriptionNumber</p><p>DDI/Dosage/Duplicate 
     * Therapy.SourceNumber (All senders must uniquely identify 
     * prescriptions on request)</p></p>
     * 
     * <p><p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p><p>InteractingPrescription.PrescriptionExternalKey</p><p>InteractingPrescription.PrescriptionNumber</p><p>DDI/Dosage/Duplicate 
     * Therapy.SourceNumber (All senders must uniquely identify 
     * prescriptions on request)</p></p>
     * 
     * <p><p>Allows provider to drill-down and retrieve additional 
     * information about the implicated drug therapy to either 
     * modify the therapy or to learn more information in 
     * determining their management approach for the issue</p></p>
     * 
     * <p>A:Active Medication Record Number</p>
     * 
     * <p><p>Unique identifier of the prescription or other 
     * medication drug record that triggered the issue.</p></p>
     * 
     * <p><p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p><p>InteractingPrescription.PrescriptionExternalKey</p><p>InteractingPrescription.PrescriptionNumber</p><p>DDI/Dosage/Duplicate 
     * Therapy.SourceNumber (All senders must uniquely identify 
     * prescriptions on request)</p></p>
     * 
     * <p><p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p><p>InteractingPrescription.PrescriptionExternalKey</p><p>InteractingPrescription.PrescriptionNumber</p><p>DDI/Dosage/Duplicate 
     * Therapy.SourceNumber (All senders must uniquely identify 
     * prescriptions on request)</p></p>
     * 
     * <p><p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p><p>InteractingPrescription.PrescriptionExternalKey</p><p>InteractingPrescription.PrescriptionNumber</p><p>DDI/Dosage/Duplicate 
     * Therapy.SourceNumber (All senders must uniquely identify 
     * prescriptions on request)</p></p>
     * 
     * <p><p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p><p>InteractingPrescription.PrescriptionExternalKey</p><p>InteractingPrescription.PrescriptionNumber</p><p>DDI/Dosage/Duplicate 
     * Therapy.SourceNumber (All senders must uniquely identify 
     * prescriptions on request)</p></p>
     * 
     * <p><p>Allows provider to drill-down and retrieve additional 
     * information about the implicated drug therapy to either 
     * modify the therapy or to learn more information in 
     * determining their management approach for the issue.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>AdministrationType</p>
     * 
     * <p>Administration Type</p>
     * 
     * <p><p>Identifies whether the interaction is with a drug or a 
     * vaccine. For SNOMED, may also indicate the specific drug or 
     * vaccine at issue.</p></p>
     * 
     * <p><p>Needed to determine what to do about the issue. 
     * Because the medication can be masked, this element is only 
     * marked as 'populated'.</p><p>The element allows a full 'CD' 
     * type to support SNOMED implementations.</p></p>
     * 
     * <p><p>Needed to determine what to do about the issue. 
     * Because the medication can be masked, this element is only 
     * marked as 'populated'.</p><p>The element allows a full 'CD' 
     * type to support SNOMED implementations.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdministrationCode getCode() {
        return (ActSubstanceAdministrationCode) this.code.getValue();
    }
    public void setCode(ActSubstanceAdministrationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>ActiveMedicationStatus</p>
     * 
     * <p>B:Active Medication Status</p>
     * 
     * <p><p>Indicates the status of the medication record at the 
     * time of the issue.</p></p>
     * 
     * <p><p>ZPB3.8 (aborted = discontinued; nullified = 
     * reversed/system reversed; active=filled/not-filled)</p></p>
     * 
     * <p><p>Used to determine the relevance of the issue and the 
     * need to manage it. For example, if the medication is on 
     * hold, it may be less of an issue than if it is being 
     * actively taken.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>ActiveMedicationTimeRange</p>
     * 
     * <p>C:Active Medication Time-range</p>
     * 
     * <p><p>The date and time during which the patient is expected 
     * to be taking the drug which triggered the issue.</p></p>
     * 
     * <p><p>Requested Duration</p></p>
     * 
     * <p><p>Allows the provider to evaluate 'duplicate therapy' 
     * and similar timing-based issues.</p></p>
     * 
     * <p>C:Active Medication Time-range</p>
     * 
     * <p><p>The date and time during which the patient is expected 
     * to be taking the drug which triggered the issue.</p></p>
     * 
     * <p><p>Requested Duration</p></p>
     * 
     * <p><p>Allows the provider to evaluate 
     * &#226;&#128;&#152;duplicate therapy&#226;&#128;&#153; and 
     * similar timing-based issues.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>ActiveMedicationMaskingIndicator</p>
     * 
     * <p>E:Active Medication Masking Indicator</p>
     * 
     * <p><p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p></p>
     * 
     * <p><p>Conveys the patient&#226;&#128;&#153;s wishes relating 
     * to the sensitivity of the drug information.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Conveys the patient&#226;&#128;&#153;s wishes relating 
     * to the sensitivity of the drug information.</p><p>The 
     * attribute is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p>E:Active Medication Masking Indicator</p>
     * 
     * <p><p>An indication of sensitivity surrounding the 
     * implicated drug, and thus defines the required sensitivity 
     * for the detected issue.</p></p>
     * 
     * <p><p>Conveys the patient's wishes relating to the 
     * sensitivity of the drug.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     * 
     * <p><p>Conveys the patient's wishes relating to the 
     * sensitivity of the drug.</p><p>The attribute is optional 
     * because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>ActiveMedicationDoseQuantity</p>
     * 
     * <p>D:Active Medication Dose Quantity</p>
     * 
     * <p><p>The amount of medication administered to the 
     * patient</p></p>
     * 
     * <p><p>Requested Dosage 
     * Level</p><p>ZPS.12</p><p>ZDU.4.4</p><p>Contraindication.dosageAmount</p></p>
     * 
     * <p><p>Requested Dosage 
     * Level</p><p>ZPS.12</p><p>ZDU.4.4</p><p>Contraindication.dosageAmount</p></p>
     * 
     * <p><p>Requested Dosage 
     * Level</p><p>ZPS.12</p><p>ZDU.4.4</p><p>Contraindication.dosageAmount</p></p>
     * 
     * <p><p>Requested Dosage 
     * Level</p><p>ZPS.12</p><p>ZDU.4.4</p><p>Contraindication.dosageAmount</p></p>
     * 
     * <p><p>Used in Low Dose/High Dose issues.</p></p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getDoseQuantity() {
        return this.doseQuantity.getValue();
    }
    public void setDoseQuantity(PhysicalQuantity doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }

}
