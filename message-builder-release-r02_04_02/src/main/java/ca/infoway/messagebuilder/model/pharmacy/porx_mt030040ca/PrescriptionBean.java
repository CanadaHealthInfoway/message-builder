/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt030040ca;

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
import ca.infoway.messagebuilder.model.common.coct_mt011001ca.CareCompositionsBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.iehr.comt_mt111111ca.PharmacyBean;
import ca.infoway.messagebuilder.model.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.merged.Component6_2Bean;
import ca.infoway.messagebuilder.model.merged.PrescribedAdminidtrationInstructionBean;
import ca.infoway.messagebuilder.model.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.merged.SupplyEventFirstSummary_1Bean;
import ca.infoway.messagebuilder.model.merged.SupplyEventFutureSummary_1Bean;
import ca.infoway.messagebuilder.model.merged.SupplyEventLastSummary_1Bean;
import ca.infoway.messagebuilder.model.merged.SupplyEventPastSummary_1Bean;
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
 * <p>Where the prescription is for a combination of drugs 
 * (e.g. 10mg tablets + 40mg tablets) repeatNumber cannot be 
 * populated and quantity must be expressed in mg.</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pharmacy.porx_mt060300ca.PrescriptionBean, PharmacyBean {

    private static final long serialVersionUID = 20100603L;
    private SET<II, Identifier> prescriptionOrderNumber = new SETImpl<II, Identifier>(IIImpl.class);
    private CD prescriptionType = new CDImpl();
    private CS prescriptionStatus = new CSImpl();
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private DrugProductBean directTargetMedication;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private PrescribedByBean author;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private BL derivedFromSourceDispense = new BLImpl(false);
    private PrescribedAdminidtrationInstructionBean component1AdministrationInstructions;
    private Component6_2Bean component2;
    private SupplyEventFutureSummary_1Bean fulfillment1SupplyEventFutureSummary;
    private SupplyEventFirstSummary_1Bean fulfillment2SupplyEventFirstSummary;
    private SupplyEventLastSummary_1Bean fulfillment3SupplyEventLastSummary;
    private SupplyEventPastSummary_1Bean fulfillment4SupplyEventPastSummary;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<RefusalToFillsBean> subjectOf3RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private List<CareCompositionsBean> componentOf1PatientCareProvisionEvent = new ArrayList<CareCompositionsBean>();
    private ClassifiesBean componentOf2;

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.rawSet();
    }

    @Hl7XmlMapping({"code"})
    public Code getPrescriptionType() {
        return (Code) this.prescriptionType.getValue();
    }
    public void setPrescriptionType(Code prescriptionType) {
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
    public Set<x_BasicConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
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
    public PrescribedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"reason"})
    public List<BecauseOfBean> getReason() {
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

    @Hl7XmlMapping({"component1/administrationInstructions"})
    public PrescribedAdminidtrationInstructionBean getComponent1AdministrationInstructions() {
        return this.component1AdministrationInstructions;
    }
    public void setComponent1AdministrationInstructions(PrescribedAdminidtrationInstructionBean component1AdministrationInstructions) {
        this.component1AdministrationInstructions = component1AdministrationInstructions;
    }

    @Hl7XmlMapping({"component2"})
    public Component6_2Bean getComponent2() {
        return this.component2;
    }
    public void setComponent2(Component6_2Bean component2) {
        this.component2 = component2;
    }

    @Hl7XmlMapping({"fulfillment1/supplyEventFutureSummary"})
    public SupplyEventFutureSummary_1Bean getFulfillment1SupplyEventFutureSummary() {
        return this.fulfillment1SupplyEventFutureSummary;
    }
    public void setFulfillment1SupplyEventFutureSummary(SupplyEventFutureSummary_1Bean fulfillment1SupplyEventFutureSummary) {
        this.fulfillment1SupplyEventFutureSummary = fulfillment1SupplyEventFutureSummary;
    }

    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public SupplyEventFirstSummary_1Bean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }
    public void setFulfillment2SupplyEventFirstSummary(SupplyEventFirstSummary_1Bean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }

    @Hl7XmlMapping({"fulfillment3/supplyEventLastSummary"})
    public SupplyEventLastSummary_1Bean getFulfillment3SupplyEventLastSummary() {
        return this.fulfillment3SupplyEventLastSummary;
    }
    public void setFulfillment3SupplyEventLastSummary(SupplyEventLastSummary_1Bean fulfillment3SupplyEventLastSummary) {
        this.fulfillment3SupplyEventLastSummary = fulfillment3SupplyEventLastSummary;
    }

    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public SupplyEventPastSummary_1Bean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }
    public void setFulfillment4SupplyEventPastSummary(SupplyEventPastSummary_1Bean fulfillment4SupplyEventPastSummary) {
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

    @Hl7XmlMapping({"componentOf1/patientCareProvisionEvent"})
    public List<CareCompositionsBean> getComponentOf1PatientCareProvisionEvent() {
        return this.componentOf1PatientCareProvisionEvent;
    }

    @Hl7XmlMapping({"componentOf2"})
    public ClassifiesBean getComponentOf2() {
        return this.componentOf2;
    }
    public void setComponentOf2(ClassifiesBean componentOf2) {
        this.componentOf2 = componentOf2;
    }

}
