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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt010120ca.Component2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt010120ca.Includes_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt010120ca.Includes_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pharmacy.porx_mt010120ca.ReferencesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Prescription</p>
 * 
 * <p>PORX_MT010120CA.CombinedMedicationRequest: Prescription</p>
 * 
 * <p>Id should not be specified if the order is being sent by 
 * prescriber; Id is mandatory if the order is being sent by 
 * the DIS</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p>
 * 
 * <p>Information pertaining to a prescriber's authorization 
 * for a drug to be dispensed to a patient, as well as the 
 * instruction on when and how the drug is to be consumed by 
 * the patient</p>
 * 
 * <p>PORX_MT060100CA.SubstanceAdministrationRequest: 
 * Prescription</p>
 * 
 * <p>Provides a drill-down link from the prescription to its 
 * corresponding order.</p>
 * 
 * <p>Indicates the order being dispensed</p>
 * 
 * <p>PORX_MT020030CA.ActRequest: Prescription</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving. Also needed for e-prescribing.</p>
 * 
 * <p>Information pertaining to a prescriber's authorization 
 * for a drug to be dispensed to a patient, as well as the 
 * instruction on when and how the drug is to be administered 
 * to the patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.CombinedMedicationRequest","PORX_MT010140CA.ActRequest","PORX_MT020030CA.ActRequest","PORX_MT060100CA.SubstanceAdministrationRequest"})
@Hl7RootType
public class ActRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private II id = new IIImpl();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private CV code = new CVImpl();
    private CS statusCode = new CSImpl();
    private SET<CV, Code> confidentialityCode = new SETImpl<CV, Code>(CVImpl.class);
    private DrugProductBean directTargetMedication;
    private List<ReferencesBean> definition = new ArrayList<ReferencesBean>();
    private ParentPrescriptionBean predecessorPriorCombinedMedicationRequest;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private List<CoverageExtensions_1Bean> coverageCoverage = new ArrayList<CoverageExtensions_1Bean>();
    private List<Includes_2Bean> pertinentInformation = new ArrayList<Includes_2Bean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private Component2Bean component2;
    private Includes_1Bean component3;
    private AllowedSubstitutionBean subjectOf1SubstitutionPermission;
    private NotesBean subjectOf2Annotation;
    private ClassifiesBean componentOf;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private PrescribedByBean author;


    /**
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT010140CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT020030CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionIdentifier</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Links the dispense to the prescription it fulfilled.</p>
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
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT010140CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionNumber</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     * 
     * <p>Allows for the situations where the order is originating 
     * from the DIS.</p><p>Allows prescriptions to be uniquely 
     * referenced.</p><p>Because this attribute is not used for 
     * prescriptions originating from a prescriber system, the 
     * element is optional.</p>
     * 
     * <p>The Prescription Order Number is a globally unique number 
     * assigned to a prescription by the EHR/DIS irrespective of 
     * the source of the order</p><p>It is created by the EHR/DIS 
     * once the prescription has passed all edits and 
     * validation.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionOrderNumber</p>
     * 
     * <p>Relationship: PORX_MT020030CA.ActRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows prescriptions to be uniquely referenced. Multiple 
     * identifiers are allowed to support assigning of prescription 
     * ids by the prescriber, EHR, and potentially by 
     * pharmacies.</p><p>The ID is mandatory to allow every 
     * prescription record to be uniquely identified.</p>
     * 
     * <p>This is an identifier assigned to a specific medication 
     * order. The number remains constant across the lifetime of 
     * the order, regardless of the number of providers or 
     * pharmacies involved in fulfilling the order.</p>
     * 
     * <p>Un-merged Business Name: PrescriptionIdentifier</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Links the dispense to the prescription it fulfilled.</p>
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010140CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"precondition/verificationEventCriterion"})
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010140CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Precondition.verificationEventCriterion</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    /**
     * <p>Business Name: PrescriptionType</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p>
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
     * <p>Business Name: PrescriptionType</p>
     * 
     * <p>Un-merged Business Name: PrescriptionType</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p>
     * 
     * <p>Indicates that this is a prescription for a drug as 
     * opposed to an immunization. For SNOMED, may also contain 
     * information regarding drug and route.</p>
     */
    public void setCode(ActCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: PrescriptionStatus</p>
     * 
     * <p>Un-merged Business Name: PrescriptionStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription. This is a mandatory field because 
     * every prescription needs to be in some state.</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: new, 
     * active, suspended, aborted, completed, obsolete and 
     * nullified. Use 'new' when submitting a clinical 
     * pre-determination. Use 'active' when registering a new 
     * prescription or converting a predetermination into a valid 
     * prescription.</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getStatusCode() {
        return (ActStatus) this.statusCode.getValue();
    }

    /**
     * <p>Business Name: PrescriptionStatus</p>
     * 
     * <p>Un-merged Business Name: PrescriptionStatus</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.statusCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Indicates what actions are allowed to be performed 
     * against a prescription. This is a mandatory field because 
     * every prescription needs to be in some state.</p>
     * 
     * <p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: new, 
     * active, suspended, aborted, completed, obsolete and 
     * nullified. Use 'new' when submitting a clinical 
     * pre-determination. Use 'active' when registering a new 
     * prescription or converting a predetermination into a valid 
     * prescription.</p>
     */
    public void setStatusCode(ActStatus statusCode) {
        this.statusCode.setValue(statusCode);
    }


    /**
     * <p>Business Name: PrescriptionMaskingIndicators</p>
     * 
     * <p>Un-merged Business Name: PrescriptionMaskingIndicators</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.confidentialityCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-2)</p>
     * 
     * <p>Allows the patient to have discrete control over access 
     * to their prescription data.</p><p>Taboo allows the provider 
     * to request restricted access to patient or their care 
     * giver.</p><p>Constraint: Can't have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * optional because not all systems will support masking.</p>
     * 
     * <p>Communicates the intent of the patient to restrict access 
     * to their prescriptions. Provides support for additional 
     * confidentiality constraint, giving patients a level of 
     * control over their information.</p><p>Valid values are: 'N' 
     * (normal - denotes 'Not Masked'); 'R' (restricted - denotes 
     * 'Masked') and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getConfidentialityCode() {
        return this.confidentialityCode.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.DirectTarget.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.DirectTarget.medication</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.definition</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    @Hl7XmlMapping({"definition"})
    public List<ReferencesBean> getDefinition() {
        return this.definition;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Predecessor.priorCombinedMedicationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest"})
    public ParentPrescriptionBean getPredecessorPriorCombinedMedicationRequest() {
        return this.predecessorPriorCombinedMedicationRequest;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Predecessor.priorCombinedMedicationRequest</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPredecessorPriorCombinedMedicationRequest(ParentPrescriptionBean predecessorPriorCombinedMedicationRequest) {
        this.predecessorPriorCombinedMedicationRequest = predecessorPriorCombinedMedicationRequest;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1-5)</p>
     */
    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Coverage2.coverage</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_1Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.pertinentInformation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-6)</p>
     */
    @Hl7XmlMapping({"pertinentInformation"})
    public List<Includes_2Bean> getPertinentInformation() {
        return this.pertinentInformation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
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
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.component2</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component2"})
    public Component2Bean getComponent2() {
        return this.component2;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.component2</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent2(Component2Bean component2) {
        this.component2 = component2;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.component3</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"component3"})
    public Includes_1Bean getComponent3() {
        return this.component3;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.component3</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponent3(Includes_1Bean component3) {
        this.component3 = component3;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Subject.substitutionPermission</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf1/substitutionPermission"})
    public AllowedSubstitutionBean getSubjectOf1SubstitutionPermission() {
        return this.subjectOf1SubstitutionPermission;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.Subject.substitutionPermission</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf1SubstitutionPermission(AllowedSubstitutionBean subjectOf1SubstitutionPermission) {
        this.subjectOf1SubstitutionPermission = subjectOf1SubstitutionPermission;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"subjectOf2/annotation"})
    public NotesBean getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Subject4.annotation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setSubjectOf2Annotation(NotesBean subjectOf2Annotation) {
        this.subjectOf2Annotation = subjectOf2Annotation;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.componentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT010120CA.CombinedMedicationRequest.componentOf</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.ResponsibleParty2.assignedEntity</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PORX_MT060100CA.SubstanceAdministrationRequest.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }

}
