/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.Component6Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.CoverageExtensions_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.Patient_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.PrescriptionPatientMeasurementsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.ProtocolsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Prescription</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Information 
 * pertaining to a prescriber's authorization for a drug to be 
 * dispensed to a patient, as well as the instruction on when 
 * and how the drug is to be consumed by the patient</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is a 
 * 'core' class of the medication model and is important for 
 * understanding what drugs the patient is intended to be 
 * receiving.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private II prescriptionNumber = new IIImpl();
    private CS statusCode = new CSImpl();
    private CV confidentialityCode = new CVImpl();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private Component2Bean component2;
    private Component6Bean component3;
    private ClassifiesBean componentOf;
    private List<CoverageExtensions_1Bean> coverageCoverage = new ArrayList<CoverageExtensions_1Bean>();
    private List<ProtocolsBean> definitionSubstanceAdministrationDefinition = new ArrayList<ProtocolsBean>();
    private DrugProductBean directTargetMedication;
    private List<PrescriptionPatientMeasurementsBean> pertinentInformationQuantityObservationEvent = new ArrayList<PrescriptionPatientMeasurementsBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private ParentPrescriptionBean predecessorPriorCombinedMedicationRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private Patient_1Bean subjectPatient;
    private AllowedSubstitutionBean subjectOf1SubstitutionPermission;
    private CommentBean subjectOf2Annotation;


    /**
     * <p>A:Prescription Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">It is created by 
     * the EHR/DIS once the prescription has passed all edits and 
     * validation.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The 
     * Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">It is created by 
     * the EHR/DIS once the prescription has passed all edits and 
     * validation.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the situations where the order is originating from the 
     * DIS.</p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * prescriptions to be uniquely referenced.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because this 
     * attribute is not used for prescriptions originating from a 
     * prescriber system, the element is optional.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the situations where the order is originating from the 
     * DIS.</p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * prescriptions to be uniquely referenced.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because this 
     * attribute is not used for prescriptions originating from a 
     * prescriber system, the element is optional.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows for 
     * the situations where the order is originating from the 
     * DIS.</p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * prescriptions to be uniquely referenced.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because this 
     * attribute is not used for prescriptions originating from a 
     * prescriber system, the element is optional.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionNumber() {
        return this.prescriptionNumber.getValue();
    }
    public void setPrescriptionNumber(Identifier prescriptionNumber) {
        this.prescriptionNumber.setValue(prescriptionNumber);
    }


    /**
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This denotes 
     * the state of the prescription in the lifecycle of the 
     * prescription. Valid statuses are: new, active, suspended, 
     * aborted, completed, obsolete and nullified. Use 'new' when 
     * submitting a clinical pre-determination. Use 'active' when 
     * registering a new prescription or converting a 
     * predetermination into a valid prescription.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * what actions are allowed to be performed against a 
     * prescription. This is a mandatory field because every 
     * prescription needs to be in some state.</p></p>
     * 
     * <p><p><strong>Any other code will cause a CODE_INVAL error 
     * issue to be returned.</strong></p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Communicates 
     * the intent of the patient to restrict access to their 
     * prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.masked</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * medication data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows the 
     * patient to have discrete control over access to their 
     * medication data.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">The attribute is 
     * optional because not all systems will support masking.</p></p>
     * 
     * <p><p><strong>As SK does not implement record-level masking, 
     * this must be "Normal" or a CODE_INVAL error issue will be 
     * returned.</strong></p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    @Hl7XmlMapping({"component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }


    @Hl7XmlMapping({"component2"})
    public Component2Bean getComponent2() {
        return this.component2;
    }
    public void setComponent2(Component2Bean component2) {
        this.component2 = component2;
    }


    @Hl7XmlMapping({"component3"})
    public Component6Bean getComponent3() {
        return this.component3;
    }
    public void setComponent3(Component6Bean component3) {
        this.component3 = component3;
    }


    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_1Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    @Hl7XmlMapping({"definition/substanceAdministrationDefinition"})
    public List<ProtocolsBean> getDefinitionSubstanceAdministrationDefinition() {
        return this.definitionSubstanceAdministrationDefinition;
    }


    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    @Hl7XmlMapping({"pertinentInformation/quantityObservationEvent"})
    public List<PrescriptionPatientMeasurementsBean> getPertinentInformationQuantityObservationEvent() {
        return this.pertinentInformationQuantityObservationEvent;
    }


    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
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


    @Hl7XmlMapping({"subject/patient"})
    public Patient_1Bean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(Patient_1Bean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"subjectOf1/substitutionPermission"})
    public AllowedSubstitutionBean getSubjectOf1SubstitutionPermission() {
        return this.subjectOf1SubstitutionPermission;
    }
    public void setSubjectOf1SubstitutionPermission(AllowedSubstitutionBean subjectOf1SubstitutionPermission) {
        this.subjectOf1SubstitutionPermission = subjectOf1SubstitutionPermission;
    }


    @Hl7XmlMapping({"subjectOf2/annotation"})
    public CommentBean getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }
    public void setSubjectOf2Annotation(CommentBean subjectOf2Annotation) {
        this.subjectOf2Annotation = subjectOf2Annotation;
    }

}
