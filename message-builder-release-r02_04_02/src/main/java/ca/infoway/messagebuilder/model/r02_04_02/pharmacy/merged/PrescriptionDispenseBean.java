/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
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
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt050303ca.AnimalPatientBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.IncludesBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>PORX_MT020060CA.DeviceDispense: Prescription Dispense</p>
 * 
 * <p><p>This is the detailed information about a device 
 * dispense that has been performed on behalf a patient</p></p>
 * 
 * <p><p>Dispensing is an integral part of the overall 
 * prescription process.</p></p>
 * 
 * <p>PORX_MT060020CA.DeviceDispense: Dispense</p>
 * 
 * <p><p>Represents the dispensing of a device to a 
 * patient.</p></p>
 * 
 * <p><p>Communicates an overview of a patient's dispenses.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020060CA.DeviceDispense","PORX_MT060020CA.DeviceDispense"})
@Hl7RootType
public class PrescriptionDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private IncludesBean subjectOf;
    private AnimalPatientBean subjectPatient;
    private PrescriptionReferenceBean inFulfillmentOfDeviceRequest;
    private DispenseDetailsBean componentSupplyEvent;
    private ProcedureRequestBean component1ProcedureRequest;
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private II prescriptionDispenseNumber = new IIImpl();
    private OccurredAtBean location;
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private HealthcareWorkerBean performerAssignedEntity;
    private BL subjectOf2AnnotationIndicator = new BLImpl();
    private BL subjectOf1DetectedIssueIndicator = new BLImpl();
    private SupplyOrderBean fulfillmentSupplyRequest;
    private CS dispenseStatus = new CSImpl();


    @Hl7XmlMapping({"subjectOf"})
    public IncludesBean getSubjectOf() {
        return this.subjectOf;
    }
    public void setSubjectOf(IncludesBean subjectOf) {
        this.subjectOf = subjectOf;
    }


    @Hl7XmlMapping({"subject/patient"})
    public AnimalPatientBean getSubjectPatient() {
        return this.subjectPatient;
    }
    public void setSubjectPatient(AnimalPatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }


    @Hl7XmlMapping({"inFulfillmentOf/deviceRequest"})
    public PrescriptionReferenceBean getInFulfillmentOfDeviceRequest() {
        return this.inFulfillmentOfDeviceRequest;
    }
    public void setInFulfillmentOfDeviceRequest(PrescriptionReferenceBean inFulfillmentOfDeviceRequest) {
        this.inFulfillmentOfDeviceRequest = inFulfillmentOfDeviceRequest;
    }


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


    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    /**
     * <p>PrescriptionMaskingIndicators</p>
     * 
     * <p>E:Prescription Masking Indicators</p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows 
     * providers to request restricted access by 
     * patients.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows 
     * providers to request restricted access by 
     * patients.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows 
     * providers to request restricted access by 
     * patients.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows 
     * providers to request restricted access by 
     * patients.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent of the patient to restrict 
     * access to their prescriptions.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Allows 
     * providers to request restricted access by 
     * patients.</p><p>Valid values are: 'N' (normal - denotes 'Not 
     * Masked'); 'R' (restricted - denotes 'Masked'); 'V' (very 
     * restricted - denotes very restricted access as declared by 
     * the Privacy Officer of the record holder) and 'T' (taboo - 
     * denotes 'Patient Access Restricted').</p><p>The default is 
     * 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows the patient to have discrete control over 
     * access to their medication data.</p><p>Taboo allows the 
     * provider to request restricted access to patient or their 
     * care giver.</p><p>Constraint: Can'''t have both normal and 
     * one of the other codes simultaneously.</p><p>The attribute 
     * is required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p>E:Prescription Masking Indicators</p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Communicates the intent of the patient to 
     * restrict access to their prescriptions.</p><p>Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their 
     * information.</p><p>Valid values are: 'N' (normal - denotes 
     * 'Not Masked'); 'R' (restricted - denotes 'Masked'); 'V' 
     * (very restricted - denotes very restricted access as 
     * declared by the Privacy Officer of the record holder) and 
     * 'T' (taboo - denotes 'Patient Access Restricted').</p><p>The 
     * default is 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Communicates the intent of the patient to 
     * restrict access to their prescriptions.</p><p>Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their 
     * information.</p><p>Valid values are: 'N' (normal - denotes 
     * 'Not Masked'); 'R' (restricted - denotes 'Masked'); 'V' 
     * (very restricted - denotes very restricted access as 
     * declared by the Privacy Officer of the record holder) and 
     * 'T' (taboo - denotes 'Patient Access Restricted').</p><p>The 
     * default is 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Communicates the intent of the patient to 
     * restrict access to their prescriptions.</p><p>Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their 
     * information.</p><p>Valid values are: 'N' (normal - denotes 
     * 'Not Masked'); 'R' (restricted - denotes 'Masked'); 'V' 
     * (very restricted - denotes very restricted access as 
     * declared by the Privacy Officer of the record holder) and 
     * 'T' (taboo - denotes 'Patient Access Restricted').</p><p>The 
     * default is 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Communicates the intent of the patient to 
     * restrict access to their prescriptions.</p><p>Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their 
     * information.</p><p>Valid values are: 'N' (normal - denotes 
     * 'Not Masked'); 'R' (restricted - denotes 'Masked'); 'V' 
     * (very restricted - denotes very restricted access as 
     * declared by the Privacy Officer of the record holder) and 
     * 'T' (taboo - denotes 'Patient Access Restricted').</p><p>The 
     * default is 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Communicates the intent that the dispense should be 
     * masked if it is created; If the dispense is masked, this 
     * makes the complete prescription and all dispenses 
     * masked.</p><p>Communicates the intent of the patient to 
     * restrict access to their prescriptions.</p><p>Provides 
     * support for additional confidentiality constraint, giving 
     * patients a level of control over their 
     * information.</p><p>Valid values are: 'N' (normal - denotes 
     * 'Not Masked'); 'R' (restricted - denotes 'Masked'); 'V' 
     * (very restricted - denotes very restricted access as 
     * declared by the Privacy Officer of the record holder) and 
     * 'T' (taboo - denotes 'Patient Access Restricted').</p><p>The 
     * default is 'normal' signifying 'Not Masked'.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can'''t have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can'''t have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can'''t have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can'''t have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>Can be used to set a mask for a new dispense, if 
     * present in a new dispense request.</p><p>Allows the patient 
     * to have discrete control over access to their prescription 
     * data.</p><p>Taboo allows the provider to request restricted 
     * access to patient or their care giver.</p><p>Constraint: 
     * Can'''t have both normal and one of the other codes 
     * simultaneously.</p><p>The attribute is optional because not 
     * all systems will support masking.</p></p>
     * 
     * <p><p>If a dispense is masked, it implicitly masks the 
     * prescription being dispensed. (There's no point in masking a 
     * dispense if the prescription is unmasked.)</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p></p>
     * 
     * <p><p>The Prescription Dispense Number is a globally unique 
     * number assigned to a dispense (single fill) by the EHR/DIS 
     * irrespective of the source of the dispense.</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p></p>
     * 
     * <p><p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p></p>
     * 
     * <p><p>Allows for the referencing of a specific dispense 
     * record.</p><p>Identifier for a dispensed record is needed so 
     * that dispenses may be uniquely referenced. Thus the 
     * mandatory requirement.</p></p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p>Identifier assigned by the dispensing facility.</p></p>
     * 
     * <p><p>Allows formal tracking of centrally recorded dispenses 
     * to local records for audit and related purposes.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
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


    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf1/detectedIssueIndicator"})
    public Boolean getSubjectOf1DetectedIssueIndicator() {
        return this.subjectOf1DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf1DetectedIssueIndicator(Boolean subjectOf1DetectedIssueIndicator) {
        this.subjectOf1DetectedIssueIndicator.setValue(subjectOf1DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public SupplyOrderBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(SupplyOrderBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }


    /**
     * <p>DispenseStatus</p>
     * 
     * <p>C:Dispense Status</p>
     * 
     * <p><p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the medication has been delivered to the 
     * patient.</p></p>
     * 
     * <p><p>Important in understanding what medication the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the medication.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }

}