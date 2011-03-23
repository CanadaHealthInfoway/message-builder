/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060100ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.AnnotationIndicatorBean;
import ca.infoway.messagebuilder.model.merged.DetectedIssueIndicatorBean;
import ca.infoway.messagebuilder.model.merged.TargetedToPharmacyBean;
import java.util.Set;



/**
 * <p>Dispense</p>
 * 
 * <p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p>
 * 
 * <p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060100CA.MedicationDispense"})
@Hl7RootType
public class DispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private II prescriptionDispenseNumber = new IIImpl();
    private CS dispenseStatus = new CSImpl();
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private HealthcareWorkerBean performerAssignedEntity;
    private TargetedToPharmacyBean location;
    private IncludesBean component1;
    private ST renderedDosageInstruction = new STImpl();
    private PrescriptionBean fulfillmentSubstanceAdministrationRequest;
    private DetectedIssueIndicatorBean subjectOf1DetectedIssueIndicator;
    private AnnotationIndicatorBean subjectOf2AnnotationIndicator;

    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_NormalRestrictedTabooConfidentialityKind.class);
    }

    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }

    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareWorkerBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(HealthcareWorkerBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }

    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"component1"})
    public IncludesBean getComponent1() {
        return this.component1;
    }
    public void setComponent1(IncludesBean component1) {
        this.component1 = component1;
    }

    @Hl7XmlMapping({"component2/administrationInstructions/text"})
    public String getRenderedDosageInstruction() {
        return this.renderedDosageInstruction.getValue();
    }
    public void setRenderedDosageInstruction(String renderedDosageInstruction) {
        this.renderedDosageInstruction.setValue(renderedDosageInstruction);
    }

    @Hl7XmlMapping({"fulfillment/substanceAdministrationRequest"})
    public PrescriptionBean getFulfillmentSubstanceAdministrationRequest() {
        return this.fulfillmentSubstanceAdministrationRequest;
    }
    public void setFulfillmentSubstanceAdministrationRequest(PrescriptionBean fulfillmentSubstanceAdministrationRequest) {
        this.fulfillmentSubstanceAdministrationRequest = fulfillmentSubstanceAdministrationRequest;
    }

    @Hl7XmlMapping({"subjectOf1/detectedIssueIndicator"})
    public DetectedIssueIndicatorBean getSubjectOf1DetectedIssueIndicator() {
        return this.subjectOf1DetectedIssueIndicator;
    }
    public void setSubjectOf1DetectedIssueIndicator(DetectedIssueIndicatorBean subjectOf1DetectedIssueIndicator) {
        this.subjectOf1DetectedIssueIndicator = subjectOf1DetectedIssueIndicator;
    }

    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public AnnotationIndicatorBean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator;
    }
    public void setSubjectOf2AnnotationIndicator(AnnotationIndicatorBean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator = subjectOf2AnnotationIndicator;
    }

}
