/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060160ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.model.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.merged.CareCompositionsBean;
import ca.infoway.messagebuilder.model.merged.IncludesBean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import ca.infoway.messagebuilder.model.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.CoverageExtensions_2Bean;
import ca.infoway.messagebuilder.model.pharmacy.merged.FirstDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pharmacy.merged.LastDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pharmacy.merged.MedicationDispenseBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.NotEligibleForTrialBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.PrescriptionPatientMeasurementsBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.PreviousDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pharmacy.merged.ProtocolsBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.pharmacy.merged.RemainingDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.pharmacy.merged.StatusChangesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Prescription</p>
 * 
 * <p><p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p><p>Annotation is only 
 * permitted if Detected Issue Indicator is not present and 
 * vice versa</p></p>
 * 
 * <p><p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p><p>Annotation is only 
 * permitted if Detected Issue Indicator is not present and 
 * vice versa</p></p>
 * 
 * <p><p>Information pertaining to a Prescriber's authorization 
 * for a drug to be dispensed to a patient, as well as the 
 * instruction on when and how the drug is to be administered 
 * to the patient.</p></p>
 * 
 * <p><p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060160CA.CombinedMedicationRequest"})
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pharmacy.merged.MedicationRecord {

    private static final long serialVersionUID = 20110126L;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private DrugProductBean directTargetMedication;
    private FirstDispenseInformation_1Bean fulfillment3SupplyEventFirstSummary;
    private RemainingDispenseInformation_1Bean fulfillment4SupplyEventFutureSummary;
    private BL preconditionVerificationEventCriterion = new BLImpl();
    private ClassifiesBean componentOf2;
    private OccurredAtBean location;
    private LastDispenseInformation_1Bean fulfillment2SupplyEventLastSummary;
    private BL subjectOf2DetectedIssueIndicator = new BLImpl();
    private PrescribedByBean author;
    private List<StatusChangesBean> subjectOf6ControlActEvent = new ArrayList<StatusChangesBean>();
    private AllowedSubstitutionBean subjectOf5SubstitutionPermission;
    private ParentPrescriptionBean predecessorPriorCombinedMedicationRequest;
    private CD prescriptionType = new CDImpl();
    private SET<II, Identifier> prescriptionOrderNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private List<MedicationDispenseBean> fulfillment1MedicationDispense = new ArrayList<MedicationDispenseBean>();
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private BL derivedFromSourceDispense = new BLImpl();
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private List<CoverageExtensions_2Bean> coverageCoverage = new ArrayList<CoverageExtensions_2Bean>();
    private ca.infoway.messagebuilder.model.pharmacy.porx_mt060160ca.IncludesBean component3;
    private CS prescriptionStatus = new CSImpl();
    private BL subjectOf4AnnotationIndicator = new BLImpl();
    private NotEligibleForTrialBean component2;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<IncludesBean> subjectOf3 = new ArrayList<IncludesBean>();
    private List<CareCompositionsBean> componentOf1PatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private PreviousDispenseInformation_1Bean fulfillment5SupplyEventPastSummary;
    private List<RefusalToFillsBean> subjectOf7RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private List<ProtocolsBean> definitionSubstanceAdministrationDefinition = new ArrayList<ProtocolsBean>();
    private List<PrescriptionPatientMeasurementsBean> pertinentInformationQuantityObservationEvent = new ArrayList<PrescriptionPatientMeasurementsBean>();


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    @Hl7XmlMapping({"fulfillment3/supplyEventFirstSummary"})
    public FirstDispenseInformation_1Bean getFulfillment3SupplyEventFirstSummary() {
        return this.fulfillment3SupplyEventFirstSummary;
    }
    public void setFulfillment3SupplyEventFirstSummary(FirstDispenseInformation_1Bean fulfillment3SupplyEventFirstSummary) {
        this.fulfillment3SupplyEventFirstSummary = fulfillment3SupplyEventFirstSummary;
    }


    @Hl7XmlMapping({"fulfillment4/supplyEventFutureSummary"})
    public RemainingDispenseInformation_1Bean getFulfillment4SupplyEventFutureSummary() {
        return this.fulfillment4SupplyEventFutureSummary;
    }
    public void setFulfillment4SupplyEventFutureSummary(RemainingDispenseInformation_1Bean fulfillment4SupplyEventFutureSummary) {
        this.fulfillment4SupplyEventFutureSummary = fulfillment4SupplyEventFutureSummary;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    @Hl7XmlMapping({"componentOf2"})
    public ClassifiesBean getComponentOf2() {
        return this.componentOf2;
    }
    public void setComponentOf2(ClassifiesBean componentOf2) {
        this.componentOf2 = componentOf2;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"fulfillment2/supplyEventLastSummary"})
    public LastDispenseInformation_1Bean getFulfillment2SupplyEventLastSummary() {
        return this.fulfillment2SupplyEventLastSummary;
    }
    public void setFulfillment2SupplyEventLastSummary(LastDispenseInformation_1Bean fulfillment2SupplyEventLastSummary) {
        this.fulfillment2SupplyEventLastSummary = fulfillment2SupplyEventLastSummary;
    }


    @Hl7XmlMapping({"subjectOf2/detectedIssueIndicator"})
    public Boolean getSubjectOf2DetectedIssueIndicator() {
        return this.subjectOf2DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf2DetectedIssueIndicator(Boolean subjectOf2DetectedIssueIndicator) {
        this.subjectOf2DetectedIssueIndicator.setValue(subjectOf2DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"subjectOf6/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf6ControlActEvent() {
        return this.subjectOf6ControlActEvent;
    }


    @Hl7XmlMapping({"subjectOf5/substitutionPermission"})
    public AllowedSubstitutionBean getSubjectOf5SubstitutionPermission() {
        return this.subjectOf5SubstitutionPermission;
    }
    public void setSubjectOf5SubstitutionPermission(AllowedSubstitutionBean subjectOf5SubstitutionPermission) {
        this.subjectOf5SubstitutionPermission = subjectOf5SubstitutionPermission;
    }


    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest"})
    public ParentPrescriptionBean getPredecessorPriorCombinedMedicationRequest() {
        return this.predecessorPriorCombinedMedicationRequest;
    }
    public void setPredecessorPriorCombinedMedicationRequest(ParentPrescriptionBean predecessorPriorCombinedMedicationRequest) {
        this.predecessorPriorCombinedMedicationRequest = predecessorPriorCombinedMedicationRequest;
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
    public Code getPrescriptionType() {
        return (Code) this.prescriptionType.getValue();
    }
    public void setPrescriptionType(Code prescriptionType) {
        this.prescriptionType.setValue(prescriptionType);
    }


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
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The number is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     * 
     * <p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>The number is mandatory to allow every 
     * prescription record to be uniquely identified.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.rawSet();
    }


    @Hl7XmlMapping({"fulfillment1/medicationDispense"})
    public List<MedicationDispenseBean> getFulfillment1MedicationDispense() {
        return this.fulfillment1MedicationDispense;
    }


    /**
     * <p>F:Prescription Masking Indicators</p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows a 
     * provider to request restricted access by the 
     * patient.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_2Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    @Hl7XmlMapping({"component3"})
    public ca.infoway.messagebuilder.model.pharmacy.porx_mt060160ca.IncludesBean getComponent3() {
        return this.component3;
    }
    public void setComponent3(ca.infoway.messagebuilder.model.pharmacy.porx_mt060160ca.IncludesBean component3) {
        this.component3 = component3;
    }


    /**
     * <p>C:Prescription Status</p>
     * 
     * <p><p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: NEW, 
     * ACTIVE, SUSPENDED, ABORTED, COMPLETED, OBSOLETE and 
     * NULLIFIED.</p></p>
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
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }


    @Hl7XmlMapping({"subjectOf4/annotationIndicator"})
    public Boolean getSubjectOf4AnnotationIndicator() {
        return this.subjectOf4AnnotationIndicator.getValue();
    }
    public void setSubjectOf4AnnotationIndicator(Boolean subjectOf4AnnotationIndicator) {
        this.subjectOf4AnnotationIndicator.setValue(subjectOf4AnnotationIndicator);
    }


    @Hl7XmlMapping({"component2"})
    public NotEligibleForTrialBean getComponent2() {
        return this.component2;
    }
    public void setComponent2(NotEligibleForTrialBean component2) {
        this.component2 = component2;
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf3"})
    public List<IncludesBean> getSubjectOf3() {
        return this.subjectOf3;
    }


    @Hl7XmlMapping({"componentOf1/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf1PatientCareProvisionEvent() {
        return this.componentOf1PatientCareProvisionEvent;
    }


    @Hl7XmlMapping({"fulfillment5/supplyEventPastSummary"})
    public PreviousDispenseInformation_1Bean getFulfillment5SupplyEventPastSummary() {
        return this.fulfillment5SupplyEventPastSummary;
    }
    public void setFulfillment5SupplyEventPastSummary(PreviousDispenseInformation_1Bean fulfillment5SupplyEventPastSummary) {
        this.fulfillment5SupplyEventPastSummary = fulfillment5SupplyEventPastSummary;
    }


    @Hl7XmlMapping({"subjectOf7/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf7RefusalToFill() {
        return this.subjectOf7RefusalToFill;
    }


    @Hl7XmlMapping({"component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }


    @Hl7XmlMapping({"definition/substanceAdministrationDefinition"})
    public List<ProtocolsBean> getDefinitionSubstanceAdministrationDefinition() {
        return this.definitionSubstanceAdministrationDefinition;
    }


    @Hl7XmlMapping({"pertinentInformation/quantityObservationEvent"})
    public List<PrescriptionPatientMeasurementsBean> getPertinentInformationQuantityObservationEvent() {
        return this.pertinentInformationQuantityObservationEvent;
    }

}
