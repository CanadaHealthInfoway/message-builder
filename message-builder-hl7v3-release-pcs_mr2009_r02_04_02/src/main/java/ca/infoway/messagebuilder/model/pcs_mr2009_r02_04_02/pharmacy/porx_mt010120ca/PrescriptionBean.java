/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.porx_mt010120ca;

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
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.BecauseOfBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.CoverageExtensions_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.PrescriptionPatientMeasurementsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pharmacy.merged.ProtocolsBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Prescription</p>
 * 
 * <p><p>Information pertaining to a prescriber's authorization 
 * for a drug to be dispensed to a patient, as well as the 
 * instruction on when and how the drug is to be consumed by 
 * the patient</p></p>
 * 
 * <p><p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110729L;
    private II prescriptionNumber = new IIImpl();
    private CV prescriptionType = new CVImpl();
    private CS prescriptionStatus = new CSImpl();
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private DrugProductBean directTargetMedication;
    private List<ProtocolsBean> definitionSubstanceAdministrationDefinition = new ArrayList<ProtocolsBean>();
    private PriorCombinedMedicationRequestBean predecessorPriorCombinedMedicationRequest;
    private List<BecauseOfBean> reason = new ArrayList<BecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private List<CoverageExtensions_1Bean> coverageCoverage = new ArrayList<CoverageExtensions_1Bean>();
    private List<PrescriptionPatientMeasurementsBean> pertinentInformationQuantityObservationEvent = new ArrayList<PrescriptionPatientMeasurementsBean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private Component2Bean component2;
    private IncludesBean component3;
    private AllowedSubstitutionBean subjectOf1SubstitutionPermission;
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean subjectOf2;
    private ClassifiesBean componentOf;


    /**
     * <p>A:Prescription Number</p>
     * 
     * <p><p>Id should not be specified if the order is being sent 
     * by prescriber; Id is mandatory if the order is being sent by 
     * the DIS</p></p>
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
     * <p><p>Allows for the situations where the order is 
     * originating from the DIS.</p><p>Allows prescriptions to be 
     * uniquely referenced.</p><p>Because this attribute is not 
     * used for prescriptions originating from a prescriber system, 
     * the element is optional.</p></p>
     * 
     * <p><p>Allows for the situations where the order is 
     * originating from the DIS.</p><p>Allows prescriptions to be 
     * uniquely referenced.</p><p>Because this attribute is not 
     * used for prescriptions originating from a prescriber system, 
     * the element is optional.</p></p>
     * 
     * <p><p>Allows for the situations where the order is 
     * originating from the DIS.</p><p>Allows prescriptions to be 
     * uniquely referenced.</p><p>Because this attribute is not 
     * used for prescriptions originating from a prescriber system, 
     * the element is optional.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionNumber() {
        return this.prescriptionNumber.getValue();
    }
    public void setPrescriptionNumber(Identifier prescriptionNumber) {
        this.prescriptionNumber.setValue(prescriptionNumber);
    }


    /**
     * <p>Prescription Type</p>
     * 
     * <p><p>Indicates that this is a prescription for a drug as 
     * opposed to an immunization. For SNOMED, may also contain 
     * information regarding drug and route.</p></p>
     * 
     * <p><p>Needed to convey the meaning of this class and is 
     * therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getPrescriptionType() {
        return (Code) this.prescriptionType.getValue();
    }
    public void setPrescriptionType(Code prescriptionType) {
        this.prescriptionType.setValue(prescriptionType);
    }


    /**
     * <p>C:Prescription Status</p>
     * 
     * <p><p>This denotes the state of the prescription in the 
     * lifecycle of the prescription. Valid statuses are: new, 
     * active, suspended, aborted, completed, obsolete and 
     * nullified. Use 'new' when submitting a clinical 
     * pre-determination. Use 'active' when registering a new 
     * prescription or converting a predetermination into a valid 
     * prescription.</p></p>
     * 
     * <p><p>Indicates what actions are allowed to be performed 
     * against a prescription. This is a mandatory field because 
     * every prescription needs to be in some state.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionStatus() {
        return (ActStatus) this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }


    /**
     * <p>F:Prescription Masking Indicators</p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions. Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their prescription data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their prescription data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their prescription data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is optional because not all systems will support 
     * masking.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their prescription data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is optional because not all systems will support 
     * masking.</p></p>
     */
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


    @Hl7XmlMapping({"definition/substanceAdministrationDefinition"})
    public List<ProtocolsBean> getDefinitionSubstanceAdministrationDefinition() {
        return this.definitionSubstanceAdministrationDefinition;
    }


    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest"})
    public PriorCombinedMedicationRequestBean getPredecessorPriorCombinedMedicationRequest() {
        return this.predecessorPriorCombinedMedicationRequest;
    }
    public void setPredecessorPriorCombinedMedicationRequest(PriorCombinedMedicationRequestBean predecessorPriorCombinedMedicationRequest) {
        this.predecessorPriorCombinedMedicationRequest = predecessorPriorCombinedMedicationRequest;
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


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_1Bean> getCoverageCoverage() {
        return this.coverageCoverage;
    }


    @Hl7XmlMapping({"pertinentInformation/quantityObservationEvent"})
    public List<PrescriptionPatientMeasurementsBean> getPertinentInformationQuantityObservationEvent() {
        return this.pertinentInformationQuantityObservationEvent;
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
    public IncludesBean getComponent3() {
        return this.component3;
    }
    public void setComponent3(IncludesBean component3) {
        this.component3 = component3;
    }


    @Hl7XmlMapping({"subjectOf1/substitutionPermission"})
    public AllowedSubstitutionBean getSubjectOf1SubstitutionPermission() {
        return this.subjectOf1SubstitutionPermission;
    }
    public void setSubjectOf1SubstitutionPermission(AllowedSubstitutionBean subjectOf1SubstitutionPermission) {
        this.subjectOf1SubstitutionPermission = subjectOf1SubstitutionPermission;
    }


    @Hl7XmlMapping({"subjectOf2"})
    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean getSubjectOf2() {
        return this.subjectOf2;
    }
    public void setSubjectOf2(ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IncludesBean subjectOf2) {
        this.subjectOf2 = subjectOf2;
    }


    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }

}
