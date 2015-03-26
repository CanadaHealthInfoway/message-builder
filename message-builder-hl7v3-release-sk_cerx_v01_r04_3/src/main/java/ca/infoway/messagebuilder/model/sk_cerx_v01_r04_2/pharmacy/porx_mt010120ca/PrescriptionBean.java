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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt010120ca;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt050203ca.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.common.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.CoverageExtensionsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.PrescriptionPatientMeasurementsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.merged.ProtocolsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_2.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Business Name: Prescription</p>
 * 
 * <p>Id should not be specified if the order is being sent by 
 * prescriber; Id is mandatory if the order is being sent by 
 * the DIS</p>
 * 
 * <p>Information pertaining to a prescriber's authorization 
 * for a drug to be dispensed to a patient, as well as the 
 * instruction on when and how the drug is to be consumed by 
 * the patient</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();
    private CS statusCode = new CSImpl();
    private CV confidentialityCode = new CVImpl();
    private DrugProductBean directTargetMedication;
    private PatientBean subjectPatient;
    private List<ProtocolsBean> definitionSubstanceAdministrationDefinition = new ArrayList<ProtocolsBean>();
    private ParentPrescriptionBean predecessorPriorCombinedMedicationRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private List<PrescriptionPatientMeasurementsBean> pertinentInformationQuantityObservationEvent = new ArrayList<PrescriptionPatientMeasurementsBean>();
    private List<CoverageExtensionsBean> coverageCoverage = new ArrayList<CoverageExtensionsBean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private Component2Bean component2;
    private IncludesBean component3;
    private AllowedSubstitutionBean subjectOf1SubstitutionPermission;
    private NotesBean subjectOf2Annotation;
    private ClassifiesBean componentOf;


    /**
     * <p>Business Name: A:Prescription Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Prescription Number</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: new, 
     * active, suspended, aborted, completed, obsolete and 
     * nullified. Use 'new' when submitting a clinical 
     * pre-determination. Use 'active' when registering a new 
     * prescription or converting a predetermination into a valid 
     * prescription.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription. This is a mandatory field because 
     * every prescription needs to be in some state.</p>
     * 
     * <p>This denotes the state of the prescription. This will be 
     * "active" when submitting a new prescription and "new" when 
     * submitting a clinical pre-determination.</p> <p><strong>Any 
     * other code will cause a CODE_INVAL error issue to be 
     * returned.</strong></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: C:Prescription Status</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: new, 
     * active, suspended, aborted, completed, obsolete and 
     * nullified. Use 'new' when submitting a clinical 
     * pre-determination. Use 'active' when registering a new 
     * prescription or converting a predetermination into a valid 
     * prescription.</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription. This is a mandatory field because 
     * every prescription needs to be in some state.</p>
     * 
     * <p>This denotes the state of the prescription. This will be 
     * "active" when submitting a new prescription and "new" when 
     * submitting a clinical pre-determination.</p> <p><strong>Any 
     * other code will cause a CODE_INVAL error issue to be 
     * returned.</strong></p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: F:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p>
     * 
     * <p>Prescription.masked</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p><strong>As SK does not implement record-level masking, 
     * this must be "Normal" or a CODE_INVAL error issue will be 
     * returned.</strong></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    /**
     * <p>Business Name: F:Prescription Masking Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information. Valid values are: 'NORMAL' 
     * (denotes 'Not Masked'); and 'RESTRICTED' (denotes 'Masked'). 
     * The default is 'NORMAL' signifying 'Not Masked'.</p>
     * 
     * <p>Prescription.masked</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their medication data.</p><p>The attribute is optional 
     * because not all systems will support masking.</p>
     * 
     * <p><strong>As SK does not implement record-level masking, 
     * this must be "Normal" or a CODE_INVAL error issue will be 
     * returned.</strong></p>
     */
    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }


    /**
     * <p>Relationship: PORX_MT010120CA.DirectTarget.medication</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }

    /**
     * <p>Relationship: PORX_MT010120CA.DirectTarget.medication</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    /**
     * <p>Relationship: PORX_MT010120CA.Subject5.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: PORX_MT010120CA.Subject5.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Definition.substanceAdministrationDefinition</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p><div>Documentation of why a prescriber has chosen 
     * to&nbsp;prescribe the drug in the manner they 
     * have.&nbsp;</div></p>
     */
    @Hl7XmlMapping({"definition/substanceAdministrationDefinition"})
    public List<ProtocolsBean> getDefinitionSubstanceAdministrationDefinition() {
        return this.definitionSubstanceAdministrationDefinition;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Predecessor.priorCombinedMedicationRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest"})
    public ParentPrescriptionBean getPredecessorPriorCombinedMedicationRequest() {
        return this.predecessorPriorCombinedMedicationRequest;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Predecessor.priorCombinedMedicationRequest</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setPredecessorPriorCombinedMedicationRequest(ParentPrescriptionBean predecessorPriorCombinedMedicationRequest) {
        this.predecessorPriorCombinedMedicationRequest = predecessorPriorCombinedMedicationRequest;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.reason</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-5)</p>
     * 
     * <p><div>Denotes the reason(s) for this 
     * specific&nbsp;prescription; it must not be interpreted as 
     * a</div> <div>permanent diagnosis.</div> <div>NOTE: Although 
     * at least one repetition must be&nbsp;PIN CeRx Business 
     * Requirements</div> <div>sent, &ldquo;Nulls&rdquo; are 
     * allowed if there are no indications&nbsp;recorded against a 
     * prescription.&nbsp;</div></p>
     */
    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Business Name: Non-authoritative Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;If present, indicates that the prescription is 
     * nonauthoritative.I.e. A paper copy must be viewed</p> 
     * <div>before the prescription can be dispensed.</div>
     */
    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    /**
     * <p>Business Name: Non-authoritative Indicator</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;If present, indicates that the prescription is 
     * nonauthoritative.I.e. A paper copy must be viewed</p> 
     * <div>before the prescription can be dispensed.</div>
     */
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    /**
     * <p>Business Name: Includes</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.PertinentInformation.quantityObservationEvent</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;This comprises the height and/or weight of 
     * a&nbsp;patient as measured/observed/known by 
     * the&nbsp;prescriber at the time of prescribing.</p>
     */
    @Hl7XmlMapping({"pertinentInformation/quantityObservationEvent"})
    public List<PrescriptionPatientMeasurementsBean> getPertinentInformationQuantityObservationEvent() {
        return this.pertinentInformationQuantityObservationEvent;
    }


    /**
     * <p>Relationship: PORX_MT010120CA.Coverage2.coverage</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensionsBean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Component1.dosageInstruction</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.component2</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p><div>Indicates that a prescription is part of a 
     * Trial&nbsp;Program.&nbsp;</div></p>
     */
    @Hl7XmlMapping({"component2"})
    public Component2Bean getComponent2() {
        return this.component2;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.component2</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p><div>Indicates that a prescription is part of a 
     * Trial&nbsp;Program.&nbsp;</div></p>
     */
    public void setComponent2(Component2Bean component2) {
        this.component2 = component2;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.component3</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Identifies the instructions for how the 
     * prescribed&nbsp;medication should be dispensed to the 
     * patient.</p>
     */
    @Hl7XmlMapping({"component3"})
    public IncludesBean getComponent3() {
        return this.component3;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.component3</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Identifies the instructions for how the 
     * prescribed&nbsp;medication should be dispensed to the 
     * patient.</p>
     */
    public void setComponent3(IncludesBean component3) {
        this.component3 = component3;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Subject.substitutionPermission</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/substitutionPermission"})
    public AllowedSubstitutionBean getSubjectOf1SubstitutionPermission() {
        return this.subjectOf1SubstitutionPermission;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.Subject.substitutionPermission</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf1SubstitutionPermission(AllowedSubstitutionBean subjectOf1SubstitutionPermission) {
        this.subjectOf1SubstitutionPermission = subjectOf1SubstitutionPermission;
    }


    /**
     * <p>Relationship: PORX_MT010120CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotation"})
    public NotesBean getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }

    /**
     * <p>Relationship: PORX_MT010120CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setSubjectOf2Annotation(NotesBean subjectOf2Annotation) {
        this.subjectOf2Annotation = subjectOf2Annotation;
    }


    /**
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.componentOf</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Indicates the clinical use category in which 
     * the</p> <div>prescription has been put.</div>
     */
    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }

    /**
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.componentOf</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>&nbsp;Indicates the clinical use category in which 
     * the</p> <div>prescription has been put.</div>
     */
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }

}
