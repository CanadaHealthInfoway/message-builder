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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt980030ca;

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
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import java.util.Date;



/**
 * <p>Business Name: Active Medication</p>
 * 
 * <p>Allows providers to identify the offending drugs when 
 * determining their management approach.</p>
 * 
 * <p>Indicates an active medication (prescription or 
 * non-prescription medication) that is recorded in the 
 * patient's record and which contributed to triggering the 
 * issue.</p>
 */
@Hl7PartTypeMapping({"PORX_MT980030CA.SubstanceAdministration"})
public class ActiveMedicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.CausalActs {

    private static final long serialVersionUID = 20131209L;
    private CS moodCode = new CSImpl();
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV confidentialityCode = new CVImpl();
    private PQ doseQuantity = new PQImpl();
    private DrugProductBean consumableMedication;


    /**
     * <p>Business Name: Other Medication Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Knowing whether a drug is prescribed or not can influence 
     * actions taken to mitigate an issue. The element is therefore 
     * mandatory</p>
     * 
     * <p>If the attribute is 'RQO', represents a prescription or 
     * dispense record. Otherwise if 'EVN', it represents an 'Other 
     * Medication' record.</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodOrderEvent getMoodCode() {
        return (x_ActMoodOrderEvent) this.moodCode.getValue();
    }

    /**
     * <p>Business Name: Other Medication Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.moodCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Knowing whether a drug is prescribed or not can influence 
     * actions taken to mitigate an issue. The element is therefore 
     * mandatory</p>
     * 
     * <p>If the attribute is 'RQO', represents a prescription or 
     * dispense record. Otherwise if 'EVN', it represents an 'Other 
     * Medication' record.</p>
     */
    public void setMoodCode(x_ActMoodOrderEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }


    /**
     * <p>Business Name: A:Active Medication Record Number</p>
     * 
     * <p>Relationship: PORX_MT980030CA.SubstanceAdministration.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p>
     * 
     * <p>InteractingPrescription.PrescriptionExternalKey</p>
     * 
     * <p>InteractingPrescription.PrescriptionNumber</p>
     * 
     * <p>DDI/Dosage/Duplicate Therapy.SourceNumber (All senders 
     * must uniquely identify prescriptions on request)</p>
     * 
     * <p>Allows provider to drill-down and retrieve additional 
     * information about the implicated drug therapy to either 
     * modify the therapy or to learn more information in 
     * determining their management approach for the 
     * issue.</p><p>The attribute is marked as populated because it 
     * may be masked.</p>
     * 
     * <p>Unique identifier of the prescription or other medication 
     * drug record that triggered the issue.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Active Medication Record Number</p>
     * 
     * <p>Relationship: PORX_MT980030CA.SubstanceAdministration.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>DDI/DuplicateTherapy.InteractingPrescriptionNumber</p>
     * 
     * <p>InteractingPrescription.PrescriptionExternalKey</p>
     * 
     * <p>InteractingPrescription.PrescriptionNumber</p>
     * 
     * <p>DDI/Dosage/Duplicate Therapy.SourceNumber (All senders 
     * must uniquely identify prescriptions on request)</p>
     * 
     * <p>Allows provider to drill-down and retrieve additional 
     * information about the implicated drug therapy to either 
     * modify the therapy or to learn more information in 
     * determining their management approach for the 
     * issue.</p><p>The attribute is marked as populated because it 
     * may be masked.</p>
     * 
     * <p>Unique identifier of the prescription or other medication 
     * drug record that triggered the issue.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Administration Type</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Needed to determine what to do about the issue. Because 
     * the medication can be masked, this element is only marked as 
     * 'populated'.</p><p>The element allows a full 'CD' type to 
     * support SNOMED implementations.</p>
     * 
     * <p>Identifies whether the interaction is with a drug or a 
     * vaccine. For SNOMED, may also indicate the specific drug or 
     * vaccine at issue.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdministrationCode getCode() {
        return (ActSubstanceAdministrationCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Administration Type</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Needed to determine what to do about the issue. Because 
     * the medication can be masked, this element is only marked as 
     * 'populated'.</p><p>The element allows a full 'CD' type to 
     * support SNOMED implementations.</p>
     * 
     * <p>Identifies whether the interaction is with a drug or a 
     * vaccine. For SNOMED, may also indicate the specific drug or 
     * vaccine at issue.</p>
     */
    public void setCode(ActSubstanceAdministrationCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: B:Active Medication Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPB3.8 (aborted = discontinued; nullified = 
     * reversed/system reversed; active=filled/not-filled)</p>
     * 
     * <p>Used to determine the relevance of the issue and the need 
     * to manage it. For example, if the medication is on hold, it 
     * may be less of an issue than if it is being actively 
     * taken.</p>
     * 
     * <p>Indicates the status of the medication record at the time 
     * of the issue.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: B:Active Medication Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.statusCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPB3.8 (aborted = discontinued; nullified = 
     * reversed/system reversed; active=filled/not-filled)</p>
     * 
     * <p>Used to determine the relevance of the issue and the need 
     * to manage it. For example, if the medication is on hold, it 
     * may be less of an issue than if it is being actively 
     * taken.</p>
     * 
     * <p>Indicates the status of the medication record at the time 
     * of the issue.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: C:Active Medication Time-range</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Requested Duration</p>
     * 
     * <p>Allows the provider to evaluate 'duplicate therapy' and 
     * similar timing-based issues.</p>
     * 
     * <p>The date and time during which the patient is expected to 
     * be taking the drug which triggered the issue.</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Business Name: C:Active Medication Time-range</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.effectiveTime</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Requested Duration</p>
     * 
     * <p>Allows the provider to evaluate 'duplicate therapy' and 
     * similar timing-based issues.</p>
     * 
     * <p>The date and time during which the patient is expected to 
     * be taking the drug which triggered the issue.</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>Business Name: E:Active Medication Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: E:Active Medication Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Conveys the patient's wishes relating to the sensitivity 
     * of the drug information.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>An indication of sensitivity surrounding the related 
     * drug, and thus defines the required sensitivity for the 
     * detected issue.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Business Name: D:Active Medication Dose Quantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Requested Dosage Level</p>
     * 
     * <p>ZPS.12</p>
     * 
     * <p>ZDU.4.4</p>
     * 
     * <p>Contraindication.dosageAmount</p>
     * 
     * <p>Used in Low Dose/High Dose issues.</p>
     * 
     * <p>The amount of medication administered to the patient</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public PhysicalQuantity getDoseQuantity() {
        return this.doseQuantity.getValue();
    }

    /**
     * <p>Business Name: D:Active Medication Dose Quantity</p>
     * 
     * <p>Relationship: 
     * PORX_MT980030CA.SubstanceAdministration.doseQuantity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Requested Dosage Level</p>
     * 
     * <p>ZPS.12</p>
     * 
     * <p>ZDU.4.4</p>
     * 
     * <p>Contraindication.dosageAmount</p>
     * 
     * <p>Used in Low Dose/High Dose issues.</p>
     * 
     * <p>The amount of medication administered to the patient</p>
     */
    public void setDoseQuantity(PhysicalQuantity doseQuantity) {
        this.doseQuantity.setValue(doseQuantity);
    }


    /**
     * <p>Relationship: PORX_MT980030CA.Consumable.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"consumable/medication"})
    public DrugProductBean getConsumableMedication() {
        return this.consumableMedication;
    }

    /**
     * <p>Relationship: PORX_MT980030CA.Consumable.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setConsumableMedication(DrugProductBean consumableMedication) {
        this.consumableMedication = consumableMedication;
    }

}
