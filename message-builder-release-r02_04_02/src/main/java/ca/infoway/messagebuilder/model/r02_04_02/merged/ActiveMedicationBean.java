/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdministrationCode;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodRequestEvent;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt490102ca.MedicationBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt220100ca.DrugProductBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>ActiveMedication</p>
 * 
 * <p>COCT_MT260010CA.SubstanceAdministration: Active 
 * Medication</p>
 * 
 * <p><p>Indicates an active medication (prescription or 
 * non-prescription medication) that is recorded in the 
 * patient'''s record and which contributed to triggering the 
 * issue.</p></p>
 * 
 * <p><p>Allows providers to identify the offending drugs when 
 * determining their management approach.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.SubstanceAdministration","COCT_MT260020CA.SubstanceAdministration","FICR_MT400001CA.SubstanceAdministration","FICR_MT400003CA.SubstanceAdministration","FICR_MT400004CA.SubstanceAdministration","FICR_MT490101CA.SubstanceAdministration","FICR_MT490102CA.SubstanceAdministration"})
public class ActiveMedicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.r02_04_02.common.merged.CausalActs, ca.infoway.messagebuilder.model.r02_04_02.claims.merged.SpecialAuthorizationChoice {

    private static final long serialVersionUID = 20110318L;
    private PQ doseQuantity = new PQImpl();
    private MedicationBean directTargetMedication;
    private MedicineBean directTargetMedicationAdministerableMedicine;
    private CD administrationType = new CDImpl();
    private CS otherMedicationIndicator = new CSImpl();
    private DrugProductBean consumableMedication;
    private SET<CV, Code> activeMedicationMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private CS activeMedicationStatus = new CSImpl();
    private II activeMedicationRecordNumber = new IIImpl();
    private IVL<TS, Interval<Date>> activeMedicationTimeRange = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Drug Dose Strength</p>
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
     * 
     * <p>D:Active Medication Dose Quantity</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getDoseQuantity() {
        return this.doseQuantity.getValue();
    }
    public void setDoseQuantity(PhysicalQuantity doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    @Hl7XmlMapping({"directTarget/medication"})
    public MedicationBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(MedicationBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    @Hl7XmlMapping({"directTarget/medication/administerableMedicine"})
    public MedicineBean getDirectTargetMedicationAdministerableMedicine() {
        return this.directTargetMedicationAdministerableMedicine;
    }
    public void setDirectTargetMedicationAdministerableMedicine(MedicineBean directTargetMedicationAdministerableMedicine) {
        this.directTargetMedicationAdministerableMedicine = directTargetMedicationAdministerableMedicine;
    }


    /**
     * <p>AdministrationType</p>
     * 
     * <p>Administration Type</p>
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
    public ActSubstanceAdministrationCode getAdministrationType() {
        return (ActSubstanceAdministrationCode) this.administrationType.getValue();
    }
    public void setAdministrationType(ActSubstanceAdministrationCode administrationType) {
        this.administrationType.setValue(administrationType);
    }


    /**
     * <p>OtherMedicationIndicator</p>
     * 
     * <p>Other Medication Indicator</p>
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
    public x_ActMoodRequestEvent getOtherMedicationIndicator() {
        return (x_ActMoodRequestEvent) this.otherMedicationIndicator.getValue();
    }
    public void setOtherMedicationIndicator(x_ActMoodRequestEvent otherMedicationIndicator) {
        this.otherMedicationIndicator.setValue(otherMedicationIndicator);
    }


    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
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
     * <p><p>Conveys the patient'''s wishes relating to the 
     * sensitivity of the drug information.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p>Conveys the patient'''s wishes relating to the 
     * sensitivity of the drug information.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p>E:Active Medication Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getActiveMedicationMaskingIndicator() {
        return this.activeMedicationMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>ActiveMedicationStatus</p>
     * 
     * <p>B:Active Medication Status</p>
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
    public ActStatus getActiveMedicationStatus() {
        return (ActStatus) this.activeMedicationStatus.getValue();
    }
    public void setActiveMedicationStatus(ActStatus activeMedicationStatus) {
        this.activeMedicationStatus.setValue(activeMedicationStatus);
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
     * determining their management approach for the issue.</p></p>
     * 
     * <p>A:Active Medication Record Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getActiveMedicationRecordNumber() {
        return this.activeMedicationRecordNumber.getValue();
    }
    public void setActiveMedicationRecordNumber(Identifier activeMedicationRecordNumber) {
        this.activeMedicationRecordNumber.setValue(activeMedicationRecordNumber);
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
     * <p><p>Allows the provider to evaluate '''duplicate 
     * therapy''' and similar timing-based issues.</p></p>
     * 
     * <p>C:Active Medication Time-range</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getActiveMedicationTimeRange() {
        return this.activeMedicationTimeRange.getValue();
    }
    public void setActiveMedicationTimeRange(Interval<Date> activeMedicationTimeRange) {
        this.activeMedicationTimeRange.setValue(activeMedicationTimeRange);
    }

}
