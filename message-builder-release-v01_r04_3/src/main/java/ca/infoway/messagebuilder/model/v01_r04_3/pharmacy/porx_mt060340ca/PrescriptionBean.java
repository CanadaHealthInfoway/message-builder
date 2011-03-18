/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt060340ca;

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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.CoverageExtensions_2Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.FirstDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.IssuesBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.LastDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.MedicationDispense_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.NotEligibleForTrialBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.PrescriptionPatientMeasurementsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.PreviousDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.ProtocolsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.RemainingDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.StatusChangesBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT060340CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.Prescription_1 {

    private static final long serialVersionUID = 20110318L;
    private List<RefusalToFillsBean> subjectOf6RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private RemainingDispenseInformation_1Bean fulfillment4SupplyEventFutureSummary;
    private ParentPrescriptionBean predecessorPriorCombinedMedicationRequest;
    private FirstDispenseInformation_1Bean fulfillment3SupplyEventFirstSummary;
    private PreviousDispenseInformation_1Bean fulfillment5SupplyEventPastSummary;
    private BL preconditionVerificationEventCriterion = new BLImpl();
    private NotEligibleForTrialBean component2;
    private BL subjectOf7DetectedIssueIndicator = new BLImpl();
    private List<ProtocolsBean> definitionSubstanceAdministrationDefinition = new ArrayList<ProtocolsBean>();
    private IncludesBean component3;
    private LastDispenseInformation_1Bean fulfillment2SupplyEventLastSummary;
    private CV prescriptionMaskingIndicator = new CVImpl();
    private ClassifiesBean componentOf;
    private II prescriptionOrderNumber = new IIImpl();
    private List<CoverageExtensions_2Bean> coverageCoverage = new ArrayList<CoverageExtensions_2Bean>();
    private CS prescriptionStatus = new CSImpl();
    private AllowedSubstitutionBean subjectOf5SubstitutionPermission;
    private PrescribedByBean author;
    private BL subjectOf2AnnotationIndicator = new BLImpl();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private ProviderBean responsiblePartyAssignedPerson;
    private PatientBean subjectPatient;
    private List<PrescriptionPatientMeasurementsBean> pertinentInformationQuantityObservationEvent = new ArrayList<PrescriptionPatientMeasurementsBean>();
    private List<StatusChangesBean> subjectOf4ControlActEvent = new ArrayList<StatusChangesBean>();
    private BL derivedFromSourceDispense = new BLImpl();
    private List<MedicationDispense_1Bean> fulfillment1MedicationDispense = new ArrayList<MedicationDispense_1Bean>();
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private RecordedAtBean location;
    private DrugProductBean directTargetMedication;
    private CD prescriptionType = new CDImpl();
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<CommentBean> subjectOf3Annotation = new ArrayList<CommentBean>();


    @Hl7XmlMapping({"subjectOf6/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf6RefusalToFill() {
        return this.subjectOf6RefusalToFill;
    }


    @Hl7XmlMapping({"fulfillment4/supplyEventFutureSummary"})
    public RemainingDispenseInformation_1Bean getFulfillment4SupplyEventFutureSummary() {
        return this.fulfillment4SupplyEventFutureSummary;
    }
    public void setFulfillment4SupplyEventFutureSummary(RemainingDispenseInformation_1Bean fulfillment4SupplyEventFutureSummary) {
        this.fulfillment4SupplyEventFutureSummary = fulfillment4SupplyEventFutureSummary;
    }


    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest"})
    public ParentPrescriptionBean getPredecessorPriorCombinedMedicationRequest() {
        return this.predecessorPriorCombinedMedicationRequest;
    }
    public void setPredecessorPriorCombinedMedicationRequest(ParentPrescriptionBean predecessorPriorCombinedMedicationRequest) {
        this.predecessorPriorCombinedMedicationRequest = predecessorPriorCombinedMedicationRequest;
    }


    @Hl7XmlMapping({"fulfillment3/supplyEventFirstSummary"})
    public FirstDispenseInformation_1Bean getFulfillment3SupplyEventFirstSummary() {
        return this.fulfillment3SupplyEventFirstSummary;
    }
    public void setFulfillment3SupplyEventFirstSummary(FirstDispenseInformation_1Bean fulfillment3SupplyEventFirstSummary) {
        this.fulfillment3SupplyEventFirstSummary = fulfillment3SupplyEventFirstSummary;
    }


    @Hl7XmlMapping({"fulfillment5/supplyEventPastSummary"})
    public PreviousDispenseInformation_1Bean getFulfillment5SupplyEventPastSummary() {
        return this.fulfillment5SupplyEventPastSummary;
    }
    public void setFulfillment5SupplyEventPastSummary(PreviousDispenseInformation_1Bean fulfillment5SupplyEventPastSummary) {
        this.fulfillment5SupplyEventPastSummary = fulfillment5SupplyEventPastSummary;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    @Hl7XmlMapping({"component2"})
    public NotEligibleForTrialBean getComponent2() {
        return this.component2;
    }
    public void setComponent2(NotEligibleForTrialBean component2) {
        this.component2 = component2;
    }


    @Hl7XmlMapping({"subjectOf7/detectedIssueIndicator"})
    public Boolean getSubjectOf7DetectedIssueIndicator() {
        return this.subjectOf7DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf7DetectedIssueIndicator(Boolean subjectOf7DetectedIssueIndicator) {
        this.subjectOf7DetectedIssueIndicator.setValue(subjectOf7DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"definition/substanceAdministrationDefinition"})
    public List<ProtocolsBean> getDefinitionSubstanceAdministrationDefinition() {
        return this.definitionSubstanceAdministrationDefinition;
    }


    @Hl7XmlMapping({"component3"})
    public IncludesBean getComponent3() {
        return this.component3;
    }
    public void setComponent3(IncludesBean component3) {
        this.component3 = component3;
    }


    @Hl7XmlMapping({"fulfillment2/supplyEventLastSummary"})
    public LastDispenseInformation_1Bean getFulfillment2SupplyEventLastSummary() {
        return this.fulfillment2SupplyEventLastSummary;
    }
    public void setFulfillment2SupplyEventLastSummary(LastDispenseInformation_1Bean fulfillment2SupplyEventLastSummary) {
        this.fulfillment2SupplyEventLastSummary = fulfillment2SupplyEventLastSummary;
    }


    /**
     * <p>F:Prescription Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getPrescriptionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.prescriptionMaskingIndicator.getValue();
    }
    public void setPrescriptionMaskingIndicator(x_VeryBasicConfidentialityKind prescriptionMaskingIndicator) {
        this.prescriptionMaskingIndicator.setValue(prescriptionMaskingIndicator);
    }


    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }


    /**
     * <p>A:Prescription Order Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_2Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    /**
     * <p>C:Prescription Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }


    @Hl7XmlMapping({"subjectOf5/substitutionPermission"})
    public AllowedSubstitutionBean getSubjectOf5SubstitutionPermission() {
        return this.subjectOf5SubstitutionPermission;
    }
    public void setSubjectOf5SubstitutionPermission(AllowedSubstitutionBean subjectOf5SubstitutionPermission) {
        this.subjectOf5SubstitutionPermission = subjectOf5SubstitutionPermission;
    }


    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"pertinentInformation/quantityObservationEvent"})
    public List<PrescriptionPatientMeasurementsBean> getPertinentInformationQuantityObservationEvent() {
        return this.pertinentInformationQuantityObservationEvent;
    }


    @Hl7XmlMapping({"subjectOf4/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf4ControlActEvent() {
        return this.subjectOf4ControlActEvent;
    }


    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    @Hl7XmlMapping({"fulfillment1/medicationDispense"})
    public List<MedicationDispense_1Bean> getFulfillment1MedicationDispense() {
        return this.fulfillment1MedicationDispense;
    }


    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    /**
     * <p>Prescription Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActCode getPrescriptionType() {
        return (ActCode) this.prescriptionType.getValue();
    }
    public void setPrescriptionType(ActCode prescriptionType) {
        this.prescriptionType.setValue(prescriptionType);
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<CommentBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }

}
