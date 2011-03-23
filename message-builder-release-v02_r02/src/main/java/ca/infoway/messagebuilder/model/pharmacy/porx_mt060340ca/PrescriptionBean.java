/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060340ca;

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
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.common.coct_mt260030ca.IssuesBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.merged.AnnotationIndicatorBean;
import ca.infoway.messagebuilder.model.merged.Author4Bean;
import ca.infoway.messagebuilder.model.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.merged.CoverageExtensionsBean;
import ca.infoway.messagebuilder.model.merged.DetectedIssueIndicatorBean;
import ca.infoway.messagebuilder.model.merged.InferredIndicatorBean;
import ca.infoway.messagebuilder.model.merged.IsPartOfBean;
import ca.infoway.messagebuilder.model.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.merged.PertinentInformationBean;
import ca.infoway.messagebuilder.model.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.merged.ReferencesBean;
import ca.infoway.messagebuilder.model.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.merged.StatusChangesBean;
import ca.infoway.messagebuilder.model.merged.SupplyEventFirstSummary_1Bean;
import ca.infoway.messagebuilder.model.merged.SupplyEventFutureSummary_1Bean;
import ca.infoway.messagebuilder.model.merged.SupplyEventLastSummary_1Bean;
import ca.infoway.messagebuilder.model.merged.SupplyEventPastSummary_1Bean;
import ca.infoway.messagebuilder.model.merged.TargetedToPharmacyBean;
import ca.infoway.messagebuilder.model.merged.VerificationEventCriterionBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Prescription</p>
 * 
 * <p>Information pertaining to a Prescriber's authorization 
 * for a drug to be dispensed to a patient, as well as the 
 * instruction on when and how the drug is to be administered 
 * to the patient.</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present and vice versa</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present and vice versa</p>
 */
@Hl7PartTypeMapping({"PORX_MT060340CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pharmacy.porx_mt060350ca.PrescriptionBean {

    private static final long serialVersionUID = 20100614L;
    private II prescriptionOrderNumber = new IIImpl();
    private CD prescriptionType = new CDImpl();
    private CS prescriptionStatus = new CSImpl();
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private DrugProductBean directTargetMedication;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private Author4Bean author;
    private TargetedToPharmacyBean location;
    private List<ReferencesBean> definition = new ArrayList<ReferencesBean>();
    private ParentPrescriptionBean predecessorPriorCombinedMedicationRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private VerificationEventCriterionBean preconditionVerificationEventCriterion;
    private List<PertinentInformationBean> pertinentInformation = new ArrayList<PertinentInformationBean>();
    private InferredIndicatorBean derivedFromSourceDispense;
    private List<CoverageExtensionsBean> coverageCoverage = new ArrayList<CoverageExtensionsBean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private BL notEligibleForTrial = new BLImpl();
    private Component6Bean component3;
    private List<PrescriptionDispensesBean> fulfillment1MedicationDispense = new ArrayList<PrescriptionDispensesBean>();
    private SupplyEventLastSummary_1Bean fulfillment2SupplyEventLastSummary;
    private SupplyEventFirstSummary_1Bean fulfillment3SupplyEventFirstSummary;
    private SupplyEventFutureSummary_1Bean fulfillment4SupplyEventFutureSummary;
    private SupplyEventPastSummary_1Bean fulfillment5SupplyEventPastSummary;
    private List<IssuesBean> subjectOf1DetectedIssueEvent = new ArrayList<IssuesBean>();
    private AnnotationIndicatorBean subjectOf2AnnotationIndicator;
    private List<NotesBean> subjectOf3Annotation = new ArrayList<NotesBean>();
    private List<StatusChangesBean> subjectOf4ControlActEvent = new ArrayList<StatusChangesBean>();
    private AllowedSubstitutionBean subjectOf5SubstitutionPermission;
    private List<RefusalToFillsBean> subjectOf6RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private DetectedIssueIndicatorBean subjectOf7DetectedIssueIndicator;
    private List<IsPartOfBean> componentOf1 = new ArrayList<IsPartOfBean>();
    private ClassifiesBean componentOf2;

    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

    @Hl7XmlMapping({"code"})
    public ActCode getPrescriptionType() {
        return (ActCode) this.prescriptionType.getValue();
    }
    public void setPrescriptionType(ActCode prescriptionType) {
        this.prescriptionType.setValue(prescriptionType);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }

    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"author"})
    public Author4Bean getAuthor() {
        return this.author;
    }
    public void setAuthor(Author4Bean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"definition"})
    public List<ReferencesBean> getDefinition() {
        return this.definition;
    }

    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest"})
    public ParentPrescriptionBean getPredecessorPriorCombinedMedicationRequest() {
        return this.predecessorPriorCombinedMedicationRequest;
    }
    public void setPredecessorPriorCombinedMedicationRequest(ParentPrescriptionBean predecessorPriorCombinedMedicationRequest) {
        this.predecessorPriorCombinedMedicationRequest = predecessorPriorCombinedMedicationRequest;
    }

    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }

    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public VerificationEventCriterionBean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion;
    }
    public void setPreconditionVerificationEventCriterion(VerificationEventCriterionBean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion = preconditionVerificationEventCriterion;
    }

    @Hl7XmlMapping({"pertinentInformation"})
    public List<PertinentInformationBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public InferredIndicatorBean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense;
    }
    public void setDerivedFromSourceDispense(InferredIndicatorBean derivedFromSourceDispense) {
        this.derivedFromSourceDispense = derivedFromSourceDispense;
    }

    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensionsBean> getCoverageCoverage() {
        return this.coverageCoverage;
    }

    @Hl7XmlMapping({"component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }

    @Hl7XmlMapping({"component2/negationInd"})
    public Boolean getNotEligibleForTrial() {
        return this.notEligibleForTrial.getValue();
    }
    public void setNotEligibleForTrial(Boolean notEligibleForTrial) {
        this.notEligibleForTrial.setValue(notEligibleForTrial);
    }

    @Hl7XmlMapping({"component3"})
    public Component6Bean getComponent3() {
        return this.component3;
    }
    public void setComponent3(Component6Bean component3) {
        this.component3 = component3;
    }

    @Hl7XmlMapping({"fulfillment1/medicationDispense"})
    public List<PrescriptionDispensesBean> getFulfillment1MedicationDispense() {
        return this.fulfillment1MedicationDispense;
    }

    @Hl7XmlMapping({"fulfillment2/supplyEventLastSummary"})
    public SupplyEventLastSummary_1Bean getFulfillment2SupplyEventLastSummary() {
        return this.fulfillment2SupplyEventLastSummary;
    }
    public void setFulfillment2SupplyEventLastSummary(SupplyEventLastSummary_1Bean fulfillment2SupplyEventLastSummary) {
        this.fulfillment2SupplyEventLastSummary = fulfillment2SupplyEventLastSummary;
    }

    @Hl7XmlMapping({"fulfillment3/supplyEventFirstSummary"})
    public SupplyEventFirstSummary_1Bean getFulfillment3SupplyEventFirstSummary() {
        return this.fulfillment3SupplyEventFirstSummary;
    }
    public void setFulfillment3SupplyEventFirstSummary(SupplyEventFirstSummary_1Bean fulfillment3SupplyEventFirstSummary) {
        this.fulfillment3SupplyEventFirstSummary = fulfillment3SupplyEventFirstSummary;
    }

    @Hl7XmlMapping({"fulfillment4/supplyEventFutureSummary"})
    public SupplyEventFutureSummary_1Bean getFulfillment4SupplyEventFutureSummary() {
        return this.fulfillment4SupplyEventFutureSummary;
    }
    public void setFulfillment4SupplyEventFutureSummary(SupplyEventFutureSummary_1Bean fulfillment4SupplyEventFutureSummary) {
        this.fulfillment4SupplyEventFutureSummary = fulfillment4SupplyEventFutureSummary;
    }

    @Hl7XmlMapping({"fulfillment5/supplyEventPastSummary"})
    public SupplyEventPastSummary_1Bean getFulfillment5SupplyEventPastSummary() {
        return this.fulfillment5SupplyEventPastSummary;
    }
    public void setFulfillment5SupplyEventPastSummary(SupplyEventPastSummary_1Bean fulfillment5SupplyEventPastSummary) {
        this.fulfillment5SupplyEventPastSummary = fulfillment5SupplyEventPastSummary;
    }

    @Hl7XmlMapping({"subjectOf1/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf1DetectedIssueEvent() {
        return this.subjectOf1DetectedIssueEvent;
    }

    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public AnnotationIndicatorBean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator;
    }
    public void setSubjectOf2AnnotationIndicator(AnnotationIndicatorBean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator = subjectOf2AnnotationIndicator;
    }

    @Hl7XmlMapping({"subjectOf3/annotation"})
    public List<NotesBean> getSubjectOf3Annotation() {
        return this.subjectOf3Annotation;
    }

    @Hl7XmlMapping({"subjectOf4/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf4ControlActEvent() {
        return this.subjectOf4ControlActEvent;
    }

    @Hl7XmlMapping({"subjectOf5/substitutionPermission"})
    public AllowedSubstitutionBean getSubjectOf5SubstitutionPermission() {
        return this.subjectOf5SubstitutionPermission;
    }
    public void setSubjectOf5SubstitutionPermission(AllowedSubstitutionBean subjectOf5SubstitutionPermission) {
        this.subjectOf5SubstitutionPermission = subjectOf5SubstitutionPermission;
    }

    @Hl7XmlMapping({"subjectOf6/refusalToFill"})
    public List<RefusalToFillsBean> getSubjectOf6RefusalToFill() {
        return this.subjectOf6RefusalToFill;
    }

    @Hl7XmlMapping({"subjectOf7/detectedIssueIndicator"})
    public DetectedIssueIndicatorBean getSubjectOf7DetectedIssueIndicator() {
        return this.subjectOf7DetectedIssueIndicator;
    }
    public void setSubjectOf7DetectedIssueIndicator(DetectedIssueIndicatorBean subjectOf7DetectedIssueIndicator) {
        this.subjectOf7DetectedIssueIndicator = subjectOf7DetectedIssueIndicator;
    }

    @Hl7XmlMapping({"componentOf1"})
    public List<IsPartOfBean> getComponentOf1() {
        return this.componentOf1;
    }

    @Hl7XmlMapping({"componentOf2"})
    public ClassifiesBean getComponentOf2() {
        return this.componentOf2;
    }
    public void setComponentOf2(ClassifiesBean componentOf2) {
        this.componentOf2 = componentOf2;
    }

}
