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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt060190ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActCode;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt220110ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.PrescribedByBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.merged.RecordedAtBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.ClassifiesBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.Component2_2Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.FirstDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.LastDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.PrescribedBecauseOfBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.PreviousDispenseInformation_1Bean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.RefusalToFillsBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.RemainingDispenseInformation_1Bean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT060190CA.CombinedMedicationRequest"})
public class PrescriptionBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.merged.MedicationRecord {

    private static final long serialVersionUID = 20110831L;
    private II prescriptionOrderNumber = new IIImpl();
    private CD prescriptionType = new CDImpl();
    private CS prescriptionStatus = new CSImpl();
    private CV prescriptionMaskingIndicator = new CVImpl();
    private DrugProductBean directTargetMedication;
    private PatientBean subjectPatient;
    private ProviderBean responsiblePartyAssignedPerson;
    private PrescribedByBean author;
    private RecordedAtBean location;
    private List<PrescribedBecauseOfBean> reason = new ArrayList<PrescribedBecauseOfBean>();
    private BL preconditionVerificationEventCriterion = new BLImpl(false);
    private BL derivedFromSourceDispense = new BLImpl(false);
    private ST renderedDosageInstruction = new STImpl();
    private Component2_2Bean component2;
    private RemainingDispenseInformation_1Bean fulfillment1SupplyEventFutureSummary;
    private FirstDispenseInformation_1Bean fulfillment2SupplyEventFirstSummary;
    private LastDispenseInformation_1Bean fulfillment3SupplyEventLastSummary;
    private PreviousDispenseInformation_1Bean fulfillment4SupplyEventPastSummary;
    private BL subjectOf1AnnotationIndicator = new BLImpl(false);
    private BL subjectOf2DetectedIssueIndicator = new BLImpl(false);
    private List<RefusalToFillsBean> subjectOf3RefusalToFill = new ArrayList<RefusalToFillsBean>();
    private ClassifiesBean componentOf;


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


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"author"})
    public PrescribedByBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PrescribedByBean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
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


    @Hl7XmlMapping({"derivedFrom/sourceDispense"})
    public Boolean getDerivedFromSourceDispense() {
        return this.derivedFromSourceDispense.getValue();
    }
    public void setDerivedFromSourceDispense(Boolean derivedFromSourceDispense) {
        this.derivedFromSourceDispense.setValue(derivedFromSourceDispense);
    }


    /**
     * <p>Rendered Dosage Instruction</p>
     */
    @Hl7XmlMapping({"component1/administrationInstructions/text"})
    public String getRenderedDosageInstruction() {
        return this.renderedDosageInstruction.getValue();
    }
    public void setRenderedDosageInstruction(String renderedDosageInstruction) {
        this.renderedDosageInstruction.setValue(renderedDosageInstruction);
    }


    @Hl7XmlMapping({"component2"})
    public Component2_2Bean getComponent2() {
        return this.component2;
    }
    public void setComponent2(Component2_2Bean component2) {
        this.component2 = component2;
    }


    @Hl7XmlMapping({"fulfillment1/supplyEventFutureSummary"})
    public RemainingDispenseInformation_1Bean getFulfillment1SupplyEventFutureSummary() {
        return this.fulfillment1SupplyEventFutureSummary;
    }
    public void setFulfillment1SupplyEventFutureSummary(RemainingDispenseInformation_1Bean fulfillment1SupplyEventFutureSummary) {
        this.fulfillment1SupplyEventFutureSummary = fulfillment1SupplyEventFutureSummary;
    }


    @Hl7XmlMapping({"fulfillment2/supplyEventFirstSummary"})
    public FirstDispenseInformation_1Bean getFulfillment2SupplyEventFirstSummary() {
        return this.fulfillment2SupplyEventFirstSummary;
    }
    public void setFulfillment2SupplyEventFirstSummary(FirstDispenseInformation_1Bean fulfillment2SupplyEventFirstSummary) {
        this.fulfillment2SupplyEventFirstSummary = fulfillment2SupplyEventFirstSummary;
    }


    @Hl7XmlMapping({"fulfillment3/supplyEventLastSummary"})
    public LastDispenseInformation_1Bean getFulfillment3SupplyEventLastSummary() {
        return this.fulfillment3SupplyEventLastSummary;
    }
    public void setFulfillment3SupplyEventLastSummary(LastDispenseInformation_1Bean fulfillment3SupplyEventLastSummary) {
        this.fulfillment3SupplyEventLastSummary = fulfillment3SupplyEventLastSummary;
    }


    @Hl7XmlMapping({"fulfillment4/supplyEventPastSummary"})
    public PreviousDispenseInformation_1Bean getFulfillment4SupplyEventPastSummary() {
        return this.fulfillment4SupplyEventPastSummary;
    }
    public void setFulfillment4SupplyEventPastSummary(PreviousDispenseInformation_1Bean fulfillment4SupplyEventPastSummary) {
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


    @Hl7XmlMapping({"componentOf"})
    public ClassifiesBean getComponentOf() {
        return this.componentOf;
    }
    public void setComponentOf(ClassifiesBean componentOf) {
        this.componentOf = componentOf;
    }

}
