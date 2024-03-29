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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.porx_mt060340ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt260030ca.IssuesBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.domainvalue.SubstanceAdministrationType;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.TargetedToPharmacyBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.CoverageExtensions_2Bean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.FirstDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.LastDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.NotEligibleForTrialBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.PrescriptionDispensesBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.PrescriptionPatientMeasurementsBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.PreviousDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.ProtocolsBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.RemainingDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.merged.StatusChangesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



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
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.pharmacy.porx_mt060350ca.Prescription {

    private static final long serialVersionUID = 20190801L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CD code = new CDImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private DrugProductBean directTargetMedication;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private PrescribedByBean author;
    private TargetedToPharmacyBean location;
    private List<ProtocolsBean> definitionSubstanceAdministrationDefinition = new ArrayList<ProtocolsBean>();
    private ParentPrescriptionBean predecessorPriorCombinedMedicationRequest;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private List<PrescriptionPatientMeasurementsBean> pertinentInformationQuantityObservationEvent = new ArrayList<PrescriptionPatientMeasurementsBean>();
    private BL derivedFromSourceDispense = new BLImpl(false);
    private List<CoverageExtensions_2Bean> coverageCoverage = new ArrayList<CoverageExtensions_2Bean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private NotEligibleForTrialBean component2;
    private IncludesBean component3;
    private List<PrescriptionDispensesBean> fulfillment1MedicationDispense = new ArrayList<PrescriptionDispensesBean>();
    private LastDispenseInformation_1Bean fulfillment2SupplyEventLastSummary;
    private FirstDispenseInformation_1Bean fulfillment3SupplyEventFirstSummary;
    private RemainingDispenseInformation_1Bean fulfillment4SupplyEventFutureSummary;
    private PreviousDispenseInformation_1Bean fulfillment5SupplyEventPastSummary;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private List<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.IncludesBean> subjectOf3 = new ArrayList<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.IncludesBean>();
    private List<StatusChangesBean> subjectOf4ControlActEvent = new ArrayList<StatusChangesBean>();
    private AllowedSubstitutionBean subjectOf5SubstitutionPermission;
    private List<RefusalToFillsBean> subjectOf6RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private BL subjectOf7DetectedIssueIndicator = new BLImpl(false);
    private List<CareCompositionsBean> componentOf1PatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private ClassifiesBean componentOf2;


    /**
     * <p>Business Name: A:Prescription Order Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
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
    public Set<Identifier> getId() {
        return this.id.rawSet();
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
    public SubstanceAdministrationType getCode() {
        return (SubstanceAdministrationType) this.code.getValue();
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
    public void setCode(SubstanceAdministrationType code) {
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
     * <p>Business Name: F:Prescription Masking Indicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-2)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>Taboo allows the provider to 
     * request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can't have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_BasicConfidentialityKind.class);
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
     * PORX_MT060340CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
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
     * PORX_MT060340CA.CombinedMedicationRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.location</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Definition.substanceAdministrationDefinition</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"definition/substanceAdministrationDefinition"})
    public List<ProtocolsBean> getDefinitionSubstanceAdministrationDefinition() {
        return this.definitionSubstanceAdministrationDefinition;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Predecessor.priorCombinedMedicationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest"})
    public ParentPrescriptionBean getPredecessorPriorCombinedMedicationRequest() {
        return this.predecessorPriorCombinedMedicationRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.Predecessor.priorCombinedMedicationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPredecessorPriorCombinedMedicationRequest(ParentPrescriptionBean predecessorPriorCombinedMedicationRequest) {
        this.predecessorPriorCombinedMedicationRequest = predecessorPriorCombinedMedicationRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
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
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.component3</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component3"})
    public IncludesBean getComponent3() {
        return this.component3;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.component3</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3(IncludesBean component3) {
        this.component3 = component3;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.InFulfillmentOf1.medicationDispense</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"fulfillment1/medicationDispense"})
    public List<PrescriptionDispensesBean> getFulfillment1MedicationDispense() {
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
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.subjectOf3</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-99)</p>
     */
    @Hl7XmlMapping({"subjectOf3"})
    public List<ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged.IncludesBean> getSubjectOf3() {
        return this.subjectOf3;
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
     * <p>Relationship: 
     * PORX_MT060340CA.Component5.patientCareProvisionEvent</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf1/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf1PatientCareProvisionEvent() {
        return this.componentOf1PatientCareProvisionEvent;
    }


    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.componentOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf2"})
    public ClassifiesBean getComponentOf2() {
        return this.componentOf2;
    }

    /**
     * <p>Relationship: 
     * PORX_MT060340CA.CombinedMedicationRequest.componentOf2</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOf2(ClassifiesBean componentOf2) {
        this.componentOf2 = componentOf2;
    }

}
