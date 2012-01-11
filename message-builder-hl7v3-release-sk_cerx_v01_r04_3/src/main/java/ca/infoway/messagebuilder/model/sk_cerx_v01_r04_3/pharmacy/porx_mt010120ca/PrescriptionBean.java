/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt010120ca;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt220100ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.AllowedSubstitutionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.CoverageExtensions_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.ParentPrescriptionBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.PrescriptionPatientMeasurementsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.ProtocolsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980040ca.AdministrationInstructionsBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT010120CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean {

    private static final long serialVersionUID = 20111121L;
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
    private List<CoverageExtensions_1Bean> coverageCoverage = new ArrayList<CoverageExtensions_1Bean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private Component2Bean component2;
    private IncludesBean component3;
    private AllowedSubstitutionBean subjectOf1SubstitutionPermission;
    private CommentBean subjectOf2Annotation;
    private ClassifiesBean componentOf;


    /**
     * <p>A:Prescription Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
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


    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }


    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"definition/substanceAdministrationDefinition"})
    public List<ProtocolsBean> getDefinitionSubstanceAdministrationDefinition() {
        return this.definitionSubstanceAdministrationDefinition;
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
    public Boolean getPreconditionVerificationEventCriterion() {
        return this.preconditionVerificationEventCriterion.getValue();
    }
    public void setPreconditionVerificationEventCriterion(Boolean preconditionVerificationEventCriterion) {
        this.preconditionVerificationEventCriterion.setValue(preconditionVerificationEventCriterion);
    }


    @Hl7XmlMapping({"pertinentInformation/quantityObservationEvent"})
    public List<PrescriptionPatientMeasurementsBean> getPertinentInformationQuantityObservationEvent() {
        return this.pertinentInformationQuantityObservationEvent;
    }


    @Hl7XmlMapping({"coverage/coverage"})
    public List<CoverageExtensions_1Bean> getCoverageCoverage() {
        return this.coverageCoverage;
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


    @Hl7XmlMapping({"subjectOf2/annotation"})
    public CommentBean getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }
    public void setSubjectOf2Annotation(CommentBean subjectOf2Annotation) {
        this.subjectOf2Annotation = subjectOf2Annotation;
    }


    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }

}
