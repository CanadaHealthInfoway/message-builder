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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060190ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.Component2_2Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.FirstDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.LastDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.PreviousDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.RemainingDispenseInformation_1Bean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Prescription</p>
 * 
 * <p><p>Where the prescription is for a combination of drugs 
 * (e.g. 10mg tablets + 40mg tablets) repeatNumber cannot be 
 * populated and quantity must be expressed in mg.</p></p>
 * 
 * <p><p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060190CA.CombinedMedicationRequest"})
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.MedicationRecord {

    private static final long serialVersionUID = 20120215L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private CV confidentialityCode = new CVImpl();
    private DrugProductBean directTargetMedication;
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private PrescribedByBean author;
    private RecordedAtBean location;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private BL derivedFromSourceDispense = new BLImpl(false);
    private ST component1AdministrationInstructionsText = new STImpl();
    private Component2_2Bean component2;
    private RemainingDispenseInformation_1Bean fulfillment1SupplyEventFutureSummary;
    private FirstDispenseInformation_1Bean fulfillment2SupplyEventFirstSummary;
    private LastDispenseInformation_1Bean fulfillment3SupplyEventLastSummary;
    private PreviousDispenseInformation_1Bean fulfillment4SupplyEventPastSummary;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<RefusalToFillsBean> subjectOf3RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private ClassifiesBean componentOf;


    /**
     * <p>A:Prescription Order Number</p>
     * 
     * <p><p>The Prescription Order Number is a globally unique 
     * number assigned to a prescription by the EHR/DIS 
     * irrespective of the source of the order</p><p>It is created 
     * by the EHR/DIS once the prescription has passed all edits 
     * and validation.</p></p>
     * 
     * <p><p>The Prescription Order Number is a globally unique 
     * number assigned to a prescription by the EHR/DIS 
     * irrespective of the source of the order</p><p>It is created 
     * by the EHR/DIS once the prescription has passed all edits 
     * and validation.</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Prescription.prescriptionNumber</p><p>Prescription.prescriptionExternalKey</p><p>D53(ID 
     * for the prescription assigned by pharmacy)</p><p>D55(ID for 
     * the dispense event)</p><p>D99.01</p><p>X0101(id for 
     * prescription)</p><p>ZDP.5</p><p>ZDP.6</p><p>ZDP.22</p><p>ZRV.5</p><p>DRU.080-01(extension)</p><p>DRU.080-02(route)</p><p>Claim.455-EM 
     * (route)</p><p>Claim.402-D2 
     * (extension)</p><p>Claim.456-EN</p><p>Claim.454-EK</p><p>A_BillablePharmacyDispense</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The number is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The number is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Prescription Type</p>
     * 
     * <p><p>Indicates that this is a prescription for a drug as 
     * opposed to an immunization. For SNOMED, may also contain 
     * information regarding drug and route.</p></p>
     * 
     * <p><p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p></p>
     * 
     * <p><p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>C:Prescription Status</p>
     * 
     * <p><p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p></p>
     * 
     * <p><p>Prescription.state (cannot distinguish between 
     * 'Filled' and 'Unfilled', must look at amounts dispensed to 
     * distniguish between those; and also cannot distinguish 
     * modified, need to look at event history).</p><p>Prescription 
     * Status</p></p>
     * 
     * <p><p>Prescription.state (cannot distinguish between 
     * 'Filled' and 'Unfilled', must look at amounts dispensed to 
     * distniguish between those; and also cannot distinguish 
     * modified, need to look at event history).</p><p>Prescription 
     * Status</p></p>
     * 
     * <p><p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p></p>
     * 
     * <p><p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>F:Prescription Masking Indicator</p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' 
     * (denotes 'Masked').</p><p>The default is 'NORMAL' signifying 
     * 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' 
     * (denotes 'Masked').</p><p>The default is 'NORMAL' signifying 
     * 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' 
     * (denotes 'Masked').</p><p>The default is 'NORMAL' signifying 
     * 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' 
     * (denotes 'Masked').</p><p>The default is 'NORMAL' signifying 
     * 'Not Masked'.</p></p>
     * 
     * <p><p>Prescription.masked</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>The attribute is 
     * optional because not all systems will support masking.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    /**
     * <p>Rendered Dosage Instruction</p>
     * 
     * <p><p>A textual rendition of structured (or non-structure) 
     * original dosage instruction specified by the prescriber.</p></p>
     * 
     * <p><p>Allows the prescriber to verify the structured dosage 
     * instruction.</p><p>Attribute is marked as 
     * &quot;mandatory&quot; as the rendition of the dosage 
     * instruction must always be made available to the 
     * prescriber.</p></p>
     * 
     * <p><p>Allows the prescriber to verify the structured dosage 
     * instruction.</p><p>Attribute is marked as 
     * &quot;mandatory&quot; as the rendition of the dosage 
     * instruction must always be made available to the 
     * prescriber.</p></p>
     */
    @Hl7XmlMapping({"component1/administrationInstructions/text"})
    public String getComponent1AdministrationInstructionsText() {
        return this.component1AdministrationInstructionsText.getValue();
    }
    public void setComponent1AdministrationInstructionsText(String component1AdministrationInstructionsText) {
        this.component1AdministrationInstructionsText.setValue(component1AdministrationInstructionsText);
    }


    @Hl7XmlMapping({"component2"})
    public Component2_2Bean getComponent2() {
        return this.component2;
    }
    public void setComponent2(Component2_2Bean component2) {
        this.component2 = component2;
    }


    @Hl7XmlMapping({"fulfillment1/supplyEventFutureSummary"})
    public RemainingDispenseInformation_1Bean getFulfillment1SupplyEventFutureSummary() {
        return this.fulfillment1SupplyEventFutureSummary;
    }
    public void setFulfillment1SupplyEventFutureSummary(RemainingDispenseInformation_1Bean fulfillment1SupplyEventFutureSummary) {
        this.fulfillment1SupplyEventFutureSummary = fulfillment1SupplyEventFutureSummary;
    }


    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public FirstDispenseInformation_1Bean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }
    public void setFulfillment2SupplyEventFirstSummary(FirstDispenseInformation_1Bean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }


    @Hl7XmlMapping({"fulfillment3/supplyEventLastSummary"})
    public LastDispenseInformation_1Bean getFulfillment3SupplyEventLastSummary() {
        return this.fulfillment3SupplyEventLastSummary;
    }
    public void setFulfillment3SupplyEventLastSummary(LastDispenseInformation_1Bean fulfillment3SupplyEventLastSummary) {
        this.fulfillment3SupplyEventLastSummary = fulfillment3SupplyEventLastSummary;
    }


    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public PreviousDispenseInformation_1Bean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }
    public void setFulfillment4SupplyEventPastSummary(PreviousDispenseInformation_1Bean fulfillment4SupplyEventPastSummary) {
        this.fulfillment4SupplyEventPastSummary = fulfillment4SupplyEventPastSummary;
    }


    @Hl7XmlMapping({"subjectOf1/annotationIndicator"})
    public Boolean getSubjectOf1AnnotationIndicator() {
        return this.subjectOf1AnnotationIndicator.getValue();
    }
    public void setSubjectOf1AnnotationIndicator(Boolean subjectOf1AnnotationIndicator) {
        this.subjectOf1AnnotationIndicator.setValue(subjectOf1AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf3/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf3RefusalToFill() {
        return this.subjectOf3RefusalToFill;
    }


    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }

}
