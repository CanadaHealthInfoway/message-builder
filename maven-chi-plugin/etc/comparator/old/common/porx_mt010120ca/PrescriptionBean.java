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
package ca.infoway.messagebuilder.model.common.porx_mt010120ca;

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
import ca.infoway.messagebuilder.domainvalue.ActTherapyDurationWorkingListCode;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.common.coct_mt270010ca.AdministrationInstructionsBean;
import ca.infoway.messagebuilder.model.merged.AuthorizesBean;
import ca.infoway.messagebuilder.model.merged.DefinitionBean;
import ca.infoway.messagebuilder.model.merged.DispenseInstructionsBean;
import ca.infoway.messagebuilder.model.merged.DrugProductBean;
import ca.infoway.messagebuilder.model.merged.NonAuthoritativeIndicatorBean;
import ca.infoway.messagebuilder.model.merged.PertinentInformationBean;
import ca.infoway.messagebuilder.model.merged.PrescribedBecauseOfBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



/**
 * <p>Prescription 
 * 
 * <p>Information pertaining to a prescriber's authorization 
 * for a drug to be dispensed to a patient, as well as the 
 * instruction on when and how the drug is to be consumed by 
 * the patient 
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * intended to be receiving. 
 * 
 * <p>Id should not be specified if the order is being sent by 
 * prescriber; Id is mandatory if the order is being sent by 
 * the DIS 
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.CombinedMedicationRequest"})
@Hl7RootType
public class PrescriptionBean extends MessagePartBean {

    private II prescriptionNumber = new IIImpl();
    private CV<ActCode> prescriptionType = new CVImpl<ActCode>();
    private CS<ActStatus> prescriptionStatus = new CSImpl<ActStatus>();
    private SET<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind> prescriptionMaskingIndicators = new SETImpl<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind>(CVImpl.class);
    private DrugProductBean directTargetMedication;
    private List<DefinitionBean> definition = new ArrayList<DefinitionBean>();
    private II previousPrescriptionOrderNumber = new IIImpl();
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private NonAuthoritativeIndicatorBean precondition;
    private List<PertinentInformationBean> pertinentInformation = new ArrayList<PertinentInformationBean>();
    private List<Coverage2Bean> coverage = new ArrayList<Coverage2Bean>();
    private List<AdministrationInstructionsBean> component1DosageInstruction = new ArrayList<AdministrationInstructionsBean>();
    private BL notEligibleForTrial = new BLImpl();
    private DispenseInstructionsBean component3SupplyRequest = new DispenseInstructionsBean();
    private AuthorizesBean subjectOf1;
    private NotesBean subjectOf2Annotation;
    private CV<ActTherapyDurationWorkingListCode> treatmentType = new CVImpl<ActTherapyDurationWorkingListCode>();

    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionNumber() {
        return this.prescriptionNumber.getValue();
    }
    public void setPrescriptionNumber(Identifier prescriptionNumber) {
        this.prescriptionNumber.setValue(prescriptionNumber);
    }

    @Hl7XmlMapping({"code"})
    public ActCode getPrescriptionType() {
        return this.prescriptionType.getValue();
    }
    public void setPrescriptionType(ActCode prescriptionType) {
        this.prescriptionType.setValue(prescriptionType);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionStatus() {
        return this.prescriptionStatus.getValue();
    }
    public void setPrescriptionStatus(ActStatus prescriptionStatus) {
        this.prescriptionStatus.setValue(prescriptionStatus);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet();
    }

    @Hl7XmlMapping({"directTarget/medication"})
    public DrugProductBean getDirectTargetMedication() {
        return this.directTargetMedication;
    }
    public void setDirectTargetMedication(DrugProductBean directTargetMedication) {
        this.directTargetMedication = directTargetMedication;
    }

    @Hl7XmlMapping({"definition"})
    public List<DefinitionBean> getDefinition() {
        return this.definition;
    }

    @Hl7XmlMapping({"predecessor/priorCombinedMedicationRequest/id"})
    public Identifier getPreviousPrescriptionOrderNumber() {
        return this.previousPrescriptionOrderNumber.getValue();
    }
    public void setPreviousPrescriptionOrderNumber(Identifier previousPrescriptionOrderNumber) {
        this.previousPrescriptionOrderNumber.setValue(previousPrescriptionOrderNumber);
    }

    @Hl7XmlMapping({"reason"})
    public List<PrescribedBecauseOfBean> getReason() {
        return this.reason;
    }

    @Hl7XmlMapping({"precondition"})
    public NonAuthoritativeIndicatorBean getPrecondition() {
        return this.precondition;
    }
    public void setPrecondition(NonAuthoritativeIndicatorBean precondition) {
        this.precondition = precondition;
    }

    @Hl7XmlMapping({"pertinentInformation"})
    public List<PertinentInformationBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

    @Hl7XmlMapping({"coverage"})
    public List<Coverage2Bean> getCoverage() {
        return this.coverage;
    }

    @Hl7XmlMapping({"component1/dosageInstruction"})
    public List<AdministrationInstructionsBean> getComponent1DosageInstruction() {
        return this.component1DosageInstruction;
    }

    @Hl7XmlMapping({"component2/negationInd"})
    public java.lang.Boolean getNotEligibleForTrial() {
        return this.notEligibleForTrial.getValue();
    }
    public void setNotEligibleForTrial(java.lang.Boolean notEligibleForTrial) {
        this.notEligibleForTrial.setValue(notEligibleForTrial);
    }

    @Hl7XmlMapping({"component3/supplyRequest"})
    public DispenseInstructionsBean getComponent3SupplyRequest() {
        return this.component3SupplyRequest;
    }
    public void setComponent3SupplyRequest(DispenseInstructionsBean component3SupplyRequest) {
        this.component3SupplyRequest = component3SupplyRequest;
    }

    @Hl7XmlMapping({"subjectOf1"})
    public AuthorizesBean getSubjectOf1() {
        return this.subjectOf1;
    }
    public void setSubjectOf1(AuthorizesBean subjectOf1) {
        this.subjectOf1 = subjectOf1;
    }

    @Hl7XmlMapping({"subjectOf2/annotation"})
    public NotesBean getSubjectOf2Annotation() {
        return this.subjectOf2Annotation;
    }
    public void setSubjectOf2Annotation(NotesBean subjectOf2Annotation) {
        this.subjectOf2Annotation = subjectOf2Annotation;
    }

    @Hl7XmlMapping({"componentOf/workingListEvent/code"})
    public ActTherapyDurationWorkingListCode getTreatmentType() {
        return this.treatmentType.getValue();
    }
    public void setTreatmentType(ActTherapyDurationWorkingListCode treatmentType) {
        this.treatmentType.setValue(treatmentType);
    }

}
