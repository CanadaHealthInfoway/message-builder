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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt060340ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt240003ca.ServiceLocationBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.CoverageExtensions_2Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.FirstDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.LastDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.MedicationDispense_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.NotEligibleForTrialBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.PrescriptionPatientMeasurementsBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.PreviousDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.RemainingDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.StatusChangesBean;
import ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Prescription</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p>
 * 
 * <p>Information pertaining to a Prescriber's authorization 
 * for a drug to be dispensed to a patient, as well as the 
 * instruction on when and how the drug is to be administered 
 * to the patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060340CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.Prescription_1 {

    private static final long serialVersionUID = 20130613L;
    private II id = new IIImpl();
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private CV confidentialityCode = new CVImpl();
    private PatientBean subjectPatient;
    private DrugProductBean directTargetMedication;
    private ProviderBean responsiblePartyAssignedPerson;
    private PrescribedByBean author;
    private ServiceLocationBean locationServiceDeliveryLocation;
    private List<II> definitionSubstanceAdministrationDefinitionId = new ArrayList<II>();
    private II predecessorPriorCombinedMedicationRequestId = new IIImpl();
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private BL derivedFromSourceDispense = new BLImpl(false);
    private List<CoverageExtensions_2Bean> coverageCoverage = new ArrayList<CoverageExtensions_2Bean>();
    private List<PrescriptionPatientMeasurementsBean> pertinentInformationQuantityObservationEvent = new ArrayList<PrescriptionPatientMeasurementsBean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private NotEligibleForTrialBean component2;
    private DispenseInstructionsBean component3SupplyRequest;
    private List<MedicationDispense_1Bean> fulfillment1MedicationDispense = new ArrayList<MedicationDispense_1Bean>();
    private LastDispenseInformation_1Bean fulfillment2SupplyEventLastSummary;
    private FirstDispenseInformation_1Bean fulfillment3SupplyEventFirstSummary;
    private RemainingDispenseInformation_1Bean fulfillment4SupplyEventFutureSummary;
    private PreviousDispenseInformation_1Bean fulfillment5SupplyEventPastSummary;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<CommentBean> subjectOf3Annotation = new ArrayList<CommentBean>();
    private List<StatusChangesBean> subjectOf4ControlActEvent = new ArrayList<StatusChangesBean>();
    private AllowedSubstitutionBean subjectOf5SubstitutionPermission;
    private List<RefusalToFillsBean> subjectOf6RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private BL subjectOf7DetectedIssueIndicator = new BLImpl(false);
    private CV componentOfWorkingListEventCode = new CVImpl();


    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.prescriptionNumber</p>
     * 
     * <p>Prescription.prescriptionExternalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
     * 
     * <p>X0101(id for prescription)</p>
     * 
     * <p>ZDP.5</p>
     * 
     * <p>ZDP.6</p>
     * 
     * <p>ZDP.22</p>
     * 
     * <p>ZRV.5</p>
     * 
     * <p>DRU.080-01(extension)</p>
     * 
     * <p>DRU.080-02(route)</p>
     * 
     * <p>Claim.455-EM (route)</p>
     * 
     * <p>Claim.402-D2 (extension)</p>
     * 
     * <p>Claim.456-EN</p>
     * 
     * <p>Claim.454-EK</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     * 
     * <p>Local systems may assign their own internal number to a 
     * prescription, and MAY display and print that number on the 
     * printed prescription, bottle labels, etc. However, the 
     * globally-unique DIS-assigned number MUST be displayed and 
     * printed.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.prescriptionNumber</p>
     * 
     * <p>Prescription.prescriptionExternalKey</p>
     * 
     * <p>D53(ID for the prescription assigned by pharmacy)</p>
     * 
     * <p>D55(ID for the dispense event)</p>
     * 
     * <p>D99.01</p>
     * 
     * <p>X0101(id for prescription)</p>
     * 
     * <p>ZDP.5</p>
     * 
     * <p>ZDP.6</p>
     * 
     * <p>ZDP.22</p>
     * 
     * <p>ZRV.5</p>
     * 
     * <p>DRU.080-01(extension)</p>
     * 
     * <p>DRU.080-02(route)</p>
     * 
     * <p>Claim.455-EM (route)</p>
     * 
     * <p>Claim.402-D2 (extension)</p>
     * 
     * <p>Claim.456-EN</p>
     * 
     * <p>Claim.454-EK</p>
     * 
     * <p>A_BillablePharmacyDispense</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced.</p><p>The 
     * number is mandatory to allow every prescription record to be 
     * uniquely identified.</p>
     * 
     * <p>Local systems may assign their own internal number to a 
     * prescription, and MAY display and print that number on the 
     * printed prescription, bottle labels, etc. However, the 
     * globally-unique DIS-assigned number MUST be displayed and 
     * printed.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Prescription Type</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Indicates that this is a prescription for a drug as 
     * opposed to an immunization. For SNOMED, may also contain 
     * information regarding drug and route.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getCode() {
        return (ActCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Prescription Type</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p><p>The element allows 'CD' to 
     * provide support for SNOMED.</p>
     * 
     * <p>Indicates that this is a prescription for a drug as 
     * opposed to an immunization. For SNOMED, may also contain 
     * information regarding drug and route.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.state (cannot distinguish between 'Filled' 
     * and 'Unfilled', must look at amounts dispensed to 
     * distniguish between those; and also cannot distinguish 
     * modified, need to look at event history).</p>
     * 
     * <p>Prescription Status</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription.state (cannot distinguish between 'Filled' 
     * and 'Unfilled', must look at amounts dispensed to 
     * distniguish between those; and also cannot distinguish 
     * modified, need to look at event history).</p>
     * 
     * <p>Prescription Status</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription.</p><p>This is a mandatory field 
     * because every prescription needs to be in some state.</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: F:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Prescription.masked</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' 
     * (denotes 'Masked').</p><p>The default is 'NORMAL' signifying 
     * 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: F:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Prescription.masked</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'NORMAL' (denotes 'Not Masked'); and 'RESTRICTED' 
     * (denotes 'Masked').</p><p>The default is 'NORMAL' signifying 
     * 'Not Masked'.</p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Subject5.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: PORX_MT060340CA.Subject5.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.DirectTarget.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }

    /**
     * <p>Relationship: PORX_MT060340CA.DirectTarget.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty2.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location/serviceDeliveryLocation"})
    public ServiceLocationBean getLocationServiceDeliveryLocation() {
        return this.locationServiceDeliveryLocation;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocationServiceDeliveryLocation(ServiceLocationBean locationServiceDeliveryLocation) {
        this.locationServiceDeliveryLocation = locationServiceDeliveryLocation;
    }


    /**
     * <p>Business Name: Protocol Identifiers</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.SubstanceAdministrationDefinition.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Enables the communication of a reference to a protocol, 
     * study or guideline id, specific to the 
     * jurisdiction;</p><p>Allows providers to reference a 
     * protocol/guideline for prescribing to specific situations. 
     * This could also be used for justification for prescribing a 
     * medication from a particular formulary. E.g., 'Limited' 
     * Use''' medications in Ontario require physicians to use a 
     * code indicating that a patient is eligible for this 
     * particular medication.</p>
     * 
     * <p>A unique identifier for a specific protocol or guideline 
     * which the prescription has been written in accordance 
     * with.</p>
     */
    @Hl7XmlMapping({"definition/substanceAdministrationDefinition/id"})
    public List<Identifier> getDefinitionSubstanceAdministrationDefinitionId() {
        return new RawListWrapper<II, Identifier>(definitionSubstanceAdministrationDefinitionId, IIImpl.class);
    }


    /**
     * <p>Business Name: B:Previous Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.PriorCombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>New or Repeat (if present, then Repeat)</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p>
     * 
     * <p>A reference to a previous prescription which the current 
     * prescription replaces.</p>
     */
    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest/id"})
    public Identifier getPredecessorPriorCombinedMedicationRequestId() {
        return this.predecessorPriorCombinedMedicationRequestId.getValue();
    }

    /**
     * <p>Business Name: B:Previous Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.PriorCombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>New or Repeat (if present, then Repeat)</p>
     * 
     * <p>Allows a prescription renewal (this prescription) to note 
     * the previous prescription id that was renewed;</p><p>Allows 
     * tracking a therapy across multiple renewal 
     * prescriptions.</p>
     * 
     * <p>A reference to a previous prescription which the current 
     * prescription replaces.</p>
     */
    public void setPredecessorPriorCombinedMedicationRequestId(Identifier predecessorPriorCombinedMedicationRequestId) {
        this.predecessorPriorCombinedMedicationRequestId.setValue(predecessorPriorCombinedMedicationRequestId);
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    /**
     * <p>Relationship: PORX_MT060340CA.DerivedFrom.sourceDispense</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }

    /**
     * <p>Relationship: PORX_MT060340CA.DerivedFrom.sourceDispense</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Coverage2.coverage</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_2Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.PertinentInformation.quantityObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"pertinentInformation/quantityObservationEvent"})
    public List<PrescriptionPatientMeasurementsBean> getPertinentInformationQuantityObservationEvent() {
        return this.pertinentInformationQuantityObservationEvent;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Component1.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.component2</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2"})
    public NotEligibleForTrialBean getComponent2() {
        return this.component2;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.component2</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent2(NotEligibleForTrialBean component2) {
        this.component2 = component2;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component3/supplyRequest"})
    public DispenseInstructionsBean getComponent3SupplyRequest() {
        return this.component3SupplyRequest;
    }

    /**
     * <p>Relationship: PORX_MT060340CA.Component6.supplyRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3SupplyRequest(DispenseInstructionsBean component3SupplyRequest) {
        this.component3SupplyRequest = component3SupplyRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf1.medicationDispense</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment1/medicationDispense"})
    public List<MedicationDispense_1Bean> getFulfillment1MedicationDispense() {
        return this.fulfillment1MedicationDispense;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf5.supplyEventLastSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment2/supplyEventLastSummary"})
    public LastDispenseInformation_1Bean getFulfillment2SupplyEventLastSummary() {
        return this.fulfillment2SupplyEventLastSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf5.supplyEventLastSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillment2SupplyEventLastSummary(LastDispenseInformation_1Bean fulfillment2SupplyEventLastSummary) {
        this.fulfillment2SupplyEventLastSummary = fulfillment2SupplyEventLastSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf4.supplyEventFirstSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment3/supplyEventFirstSummary"})
    public FirstDispenseInformation_1Bean getFulfillment3SupplyEventFirstSummary() {
        return this.fulfillment3SupplyEventFirstSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf4.supplyEventFirstSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillment3SupplyEventFirstSummary(FirstDispenseInformation_1Bean fulfillment3SupplyEventFirstSummary) {
        this.fulfillment3SupplyEventFirstSummary = fulfillment3SupplyEventFirstSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf3.supplyEventFutureSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment4/supplyEventFutureSummary"})
    public RemainingDispenseInformation_1Bean getFulfillment4SupplyEventFutureSummary() {
        return this.fulfillment4SupplyEventFutureSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf3.supplyEventFutureSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillment4SupplyEventFutureSummary(RemainingDispenseInformation_1Bean fulfillment4SupplyEventFutureSummary) {
        this.fulfillment4SupplyEventFutureSummary = fulfillment4SupplyEventFutureSummary;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf2.supplyEventPastSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment5/supplyEventPastSummary"})
    public PreviousDispenseInformation_1Bean getFulfillment5SupplyEventPastSummary() {
        return this.fulfillment5SupplyEventPastSummary;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf2.supplyEventPastSummary</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setFulfillment5SupplyEventPastSummary(PreviousDispenseInformation_1Bean fulfillment5SupplyEventPastSummary) {
        this.fulfillment5SupplyEventPastSummary = fulfillment5SupplyEventPastSummary;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Subject3.detectedIssueEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }

    /**
     * <p>Relationship: PORX_MT060340CA.Subject.annotationIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<CommentBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Subject2.controlActEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf4/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf4ControlActEvent() {
        return this.subjectOf4ControlActEvent;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Subject8.substitutionPermission</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf5/substitutionPermission"})
    public AllowedSubstitutionBean getSubjectOf5SubstitutionPermission() {
        return this.subjectOf5SubstitutionPermission;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Subject8.substitutionPermission</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf5SubstitutionPermission(AllowedSubstitutionBean subjectOf5SubstitutionPermission) {
        this.subjectOf5SubstitutionPermission = subjectOf5SubstitutionPermission;
    }


    /**
     * <p>Relationship: PORX_MT060340CA.Subject9.refusalToFill</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf6/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf6RefusalToFill() {
        return this.subjectOf6RefusalToFill;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Subject11.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf7/detectedIssueIndicator"})
    public Boolean getSubjectOf7DetectedIssueIndicator() {
        return this.subjectOf7DetectedIssueIndicator.getValue();
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Subject11.detectedIssueIndicator</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf7DetectedIssueIndicator(Boolean subjectOf7DetectedIssueIndicator) {
        this.subjectOf7DetectedIssueIndicator.setValue(subjectOf7DetectedIssueIndicator);
    }


    /**
     * <p>Business Name: D:Treatment Type</p>
     * 
     * <p>Relationship: PORX_MT060340CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription type</p>
     * 
     * <p>Prescription.drugUseIndicator</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed.</p><p>The field 
     * is marked as &quot;populated&quot; because the intended 
     * duration of the therapy should generally be known at 
     * prescribe time. However in some circumstances, it may not be 
     * known whether a therapy will be short-term or long-term.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     */
    @Hl7XmlMapping({"componentOf/workingListEvent/code"})
    public ActTherapyDurationWorkingListCode getComponentOfWorkingListEventCode() {
        return (ActTherapyDurationWorkingListCode) this.componentOfWorkingListEventCode.getValue();
    }

    /**
     * <p>Business Name: D:Treatment Type</p>
     * 
     * <p>Relationship: PORX_MT060340CA.WorkingListEvent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Prescription type</p>
     * 
     * <p>Prescription.drugUseIndicator</p>
     * 
     * <p>Allows categorizing prescription for presentation. May 
     * influence detection of duplicate therapy. May also be used 
     * to affect how DUR processing is completed.</p><p>The field 
     * is marked as &quot;populated&quot; because the intended 
     * duration of the therapy should generally be known at 
     * prescribe time. However in some circumstances, it may not be 
     * known whether a therapy will be short-term or long-term.</p>
     * 
     * <p>Describes the categorization of the therapy envisioned by 
     * this prescription (e.g Continuous/Chronic, Short-Term/Acute 
     * and &quot;As-Needed).</p>
     */
    public void setComponentOfWorkingListEventCode(ActTherapyDurationWorkingListCode componentOfWorkingListEventCode) {
        this.componentOfWorkingListEventCode.setValue(componentOfWorkingListEventCode);
    }

}
