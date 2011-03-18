/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
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
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt050303ca.AnimalPatientBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090107ca.ProviderBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.merged.PatientBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.CommentBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.RecordedAtBean;



@Hl7PartTypeMapping({"PORX_MT020060CA.DeviceDispense","PORX_MT060020CA.DeviceDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private DispenseDetailsBean componentSupplyEvent;
    private PatientBean recordTargetPatient;
    private ProcedureRequestBean component1ProcedureRequest;
    private Patient subjectPatient1;
    private CV prescriptionMaskingIndicator = new CVImpl();
    private II prescriptionDispenseNumber = new IIImpl();
    private DeviceRequest_1Bean inFulfillmentOfDeviceRequest;
    private CommentBean subjectOfAnnotation;
    private ProviderBean responsiblePartyAssignedPerson;
    private SupplyOrderBean fulfillmentSupplyRequest;
    private RecordedAtBean location;
    private ProviderBean performerAssignedPerson;
    private CS dispenseStatus = new CSImpl();
    private BL subjectOf1DetectedIssueIndicator = new BLImpl();
    private BL subjectOf2AnnotationIndicator = new BLImpl();


    @Hl7XmlMapping({"component/supplyEvent","component2/supplyEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="component", type="PORX_MT060020CA.Component2"),
        @Hl7MapByPartType(name="component/supplyEvent", type="PORX_MT060020CA.SupplyEvent"),
        @Hl7MapByPartType(name="component2", type="PORX_MT020060CA.Component"),
        @Hl7MapByPartType(name="component2/supplyEvent", type="PORX_MT020060CA.SupplyEvent")})
    public DispenseDetailsBean getComponentSupplyEvent() {
        return this.componentSupplyEvent;
    }
    public void setComponentSupplyEvent(DispenseDetailsBean componentSupplyEvent) {
        this.componentSupplyEvent = componentSupplyEvent;
    }


    @Hl7XmlMapping({"recordTarget/patient"})
    public PatientBean getRecordTargetPatient() {
        return this.recordTargetPatient;
    }
    public void setRecordTargetPatient(PatientBean recordTargetPatient) {
        this.recordTargetPatient = recordTargetPatient;
    }


    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    @Hl7XmlMapping({"subject/patient1"})
    public Patient getSubjectPatient1() {
        return this.subjectPatient1;
    }
    public void setSubjectPatient1(Patient subjectPatient1) {
        this.subjectPatient1 = subjectPatient1;
    }

    public PatientBean getSubjectPatient1AsPatient1() {
        return this.subjectPatient1 instanceof PatientBean ? (PatientBean) this.subjectPatient1 : null;
    }
    public boolean hasSubjectPatient1AsPatient1() {
        return (this.subjectPatient1 instanceof PatientBean);
    }

    public AnimalPatientBean getSubjectPatient1AsPatient2() {
        return this.subjectPatient1 instanceof AnimalPatientBean ? (AnimalPatientBean) this.subjectPatient1 : null;
    }
    public boolean hasSubjectPatient1AsPatient2() {
        return (this.subjectPatient1 instanceof AnimalPatientBean);
    }


    /**
     * <p>PrescriptionMaskingIndicator</p>
     * 
     * <p>E:Prescription Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getPrescriptionMaskingIndicator() {
        return (x_VeryBasicConfidentialityKind) this.prescriptionMaskingIndicator.getValue();
    }
    public void setPrescriptionMaskingIndicator(x_VeryBasicConfidentialityKind prescriptionMaskingIndicator) {
        this.prescriptionMaskingIndicator.setValue(prescriptionMaskingIndicator);
    }


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }


    @Hl7XmlMapping({"inFulfillmentOf/deviceRequest"})
    public DeviceRequest_1Bean getInFulfillmentOfDeviceRequest() {
        return this.inFulfillmentOfDeviceRequest;
    }
    public void setInFulfillmentOfDeviceRequest(DeviceRequest_1Bean inFulfillmentOfDeviceRequest) {
        this.inFulfillmentOfDeviceRequest = inFulfillmentOfDeviceRequest;
    }


    @Hl7XmlMapping({"subjectOf/annotation"})
    public CommentBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(CommentBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }


    @Hl7XmlMapping({"responsibleParty/assignedPerson"})
    public ProviderBean getResponsiblePartyAssignedPerson() {
        return this.responsiblePartyAssignedPerson;
    }
    public void setResponsiblePartyAssignedPerson(ProviderBean responsiblePartyAssignedPerson) {
        this.responsiblePartyAssignedPerson = responsiblePartyAssignedPerson;
    }


    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    @Hl7XmlMapping({"location"})
    public RecordedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(RecordedAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"performer/assignedPerson"})
    public ProviderBean getPerformerAssignedPerson() {
        return this.performerAssignedPerson;
    }
    public void setPerformerAssignedPerson(ProviderBean performerAssignedPerson) {
        this.performerAssignedPerson = performerAssignedPerson;
    }


    /**
     * <p>DispenseStatus</p>
     * 
     * <p>C:Dispense Status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueIndicator"})
    public Boolean getSubjectOf1DetectedIssueIndicator() {
        return this.subjectOf1DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf1DetectedIssueIndicator(Boolean subjectOf1DetectedIssueIndicator) {
        this.subjectOf1DetectedIssueIndicator.setValue(subjectOf1DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }

}
