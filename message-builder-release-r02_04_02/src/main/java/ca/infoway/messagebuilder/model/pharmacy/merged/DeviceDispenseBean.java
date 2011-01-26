/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.merged;

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
import ca.infoway.messagebuilder.model.common.merged.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.merged.IncludesBean;
import ca.infoway.messagebuilder.model.merged.IssuesBean;
import ca.infoway.messagebuilder.model.merged.OccurredAtBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>PORX_MT060010CA.DeviceDispense: Dispense</p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present</p><p>Reported Issue is only permitted if 
 * Issue Indicator is not present</p><p>One of 
 * DetectedIssueIndicator or Reported Issues detailed info must 
 * be returned, but not both</p><p>One of AnnotationIndicator 
 * or Annotation detail info must be returned, but not 
 * both.</p></p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present</p><p>Reported Issue is only permitted if 
 * Issue Indicator is not present</p><p>One of 
 * DetectedIssueIndicator or Reported Issues detailed info must 
 * be returned, but not both</p><p>One of AnnotationIndicator 
 * or Annotation detail info must be returned, but not 
 * both.</p></p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present</p><p>Reported Issue is only permitted if 
 * Issue Indicator is not present</p><p>One of 
 * DetectedIssueIndicator or Reported Issues detailed info must 
 * be returned, but not both</p><p>One of AnnotationIndicator 
 * or Annotation detail info must be returned, but not 
 * both.</p></p>
 * 
 * <p><p>Annotation is only permitted if Annotation Indicator 
 * is not present</p><p>Reported Issue is only permitted if 
 * Issue Indicator is not present</p><p>One of 
 * DetectedIssueIndicator or Reported Issues detailed info must 
 * be returned, but not both</p><p>One of AnnotationIndicator 
 * or Annotation detail info must be returned, but not 
 * both.</p></p>
 * 
 * <p><p>Describes the issuing of a drug in response to an 
 * authorizing prescription.</p></p>
 * 
 * <p><p>This is a 'core' class of the medication model and is 
 * important for understanding what drugs the patient is 
 * actually receiving.</p></p>
 * 
 * <p>PORX_MT060040CA.DeviceDispense: Prescription Dispenses</p>
 * 
 * <p><p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p><p>Annotation is only permitted if Annotation 
 * Indicator is not present</p></p>
 * 
 * <p><p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p><p>Annotation is only permitted if Annotation 
 * Indicator is not present</p></p>
 * 
 * <p><p>This is the detailed information about a device 
 * dispense that has been performed on behalf of a patient.</p></p>
 * 
 * <p><p>Dispensing is an integral part of the overall 
 * prescription process.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060010CA.DeviceDispense","PORX_MT060040CA.DeviceDispense"})
@Hl7RootType
public class DeviceDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private II prescriptionDispenseNumber = new IIImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private SET<CV, Code> prescriptionMaskingIndicators = new SETImpl<CV, Code>(CVImpl.class);
    private HealthcareWorkerBean performerAssignedEntity;
    private DispenseDetailsBean component2SupplyEvent;
    private CS dispenseStatus = new CSImpl();
    private BL subjectOf2AnnotationIndicator = new BLImpl();
    private List<IssuesBean> subjectOf4DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<IncludesBean> subjectOf5 = new ArrayList<IncludesBean>();
    private OccurredAtBean location;
    private BL subjectOf3DetectedIssueIndicator = new BLImpl();
    private ProcedureRequestBean component1ProcedureRequest;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private PrescriptionReferenceBean fulfillmentSupplyRequest;


    /**
     * <p>PrescriptionDispenseNumber</p>
     * 
     * <p>A:Prescription Dispense Number</p>
     * 
     * <p><p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p></p>
     * 
     * <p><p>The Prescription Dispense Number is a globally unique 
     * number assigned to a prescription dispense by the EHR/DIS 
     * irrespective of the source of the supply event</p><p>It is 
     * created by the EHR/DIS once the dispense has passed all 
     * edits and validation.</p></p>
     * 
     * <p><p>Allows dispense events to be uniquely referenced and 
     * is therefore mandatory.</p></p>
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
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }


    @Hl7XmlMapping({"responsibleParty/assignedEntity"})
    public HealthcareWorkerBean getResponsiblePartyAssignedEntity() {
        return this.responsiblePartyAssignedEntity;
    }
    public void setResponsiblePartyAssignedEntity(HealthcareWorkerBean responsiblePartyAssignedEntity) {
        this.responsiblePartyAssignedEntity = responsiblePartyAssignedEntity;
    }


    /**
     * <p>PrescriptionMaskingIndicators</p>
     * 
     * <p>E:Prescription Masking Indicators</p>
     * 
     * <p><p>Indicates whether the dispense (and associated 
     * prescription) is masked.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'. .</p></p>
     * 
     * <p><p>Indicates whether the dispense (and associated 
     * prescription) is masked.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'. .</p></p>
     * 
     * <p><p>Indicates whether the dispense (and associated 
     * prescription) is masked.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'. .</p></p>
     * 
     * <p><p>Indicates whether the dispense (and associated 
     * prescription) is masked.</p><p>Provides support for 
     * additional confidentiality constraint, giving patients a 
     * level of control over their information.</p><p>Valid values 
     * are: 'N' (normal - denotes 'Not Masked'); 'R' (restricted - 
     * denotes 'Masked'); 'V' (very restricted - denotes very 
     * restricted access as declared by the Privacy Officer of the 
     * record holder) and 'T' (taboo - denotes 'Patient Access 
     * Restricted').</p><p>The default is 'normal' signifying 'Not 
     * Masked'. .</p></p>
     * 
     * <p><p>Allows a patient to control access to 'sensitive' 
     * prescriptions.</p><p>Taboo allows the provider to request 
     * restricted access to patient or their care 
     * giver.</p><p>Constraint: Can'''t have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows a patient to control access to 'sensitive' 
     * prescriptions.</p><p>Taboo allows the provider to request 
     * restricted access to patient or their care 
     * giver.</p><p>Constraint: Can'''t have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows a patient to control access to 'sensitive' 
     * prescriptions.</p><p>Taboo allows the provider to request 
     * restricted access to patient or their care 
     * giver.</p><p>Constraint: Can'''t have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     * 
     * <p><p>Allows a patient to control access to 'sensitive' 
     * prescriptions.</p><p>Taboo allows the provider to request 
     * restricted access to patient or their care 
     * giver.</p><p>Constraint: Can'''t have both normal and one of 
     * the other codes simultaneously.</p><p>The attribute is 
     * required because even if a jurisdiction doesn't support 
     * masking on the way in, it will need to need to communicate 
     * masked data returned from other jurisdictions.</p></p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet(x_BasicConfidentialityKind.class);
    }


    @Hl7XmlMapping({"performer/assignedEntity"})
    public HealthcareWorkerBean getPerformerAssignedEntity() {
        return this.performerAssignedEntity;
    }
    public void setPerformerAssignedEntity(HealthcareWorkerBean performerAssignedEntity) {
        this.performerAssignedEntity = performerAssignedEntity;
    }


    @Hl7XmlMapping({"component2/supplyEvent"})
    public DispenseDetailsBean getComponent2SupplyEvent() {
        return this.component2SupplyEvent;
    }
    public void setComponent2SupplyEvent(DispenseDetailsBean component2SupplyEvent) {
        this.component2SupplyEvent = component2SupplyEvent;
    }


    /**
     * <p>DispenseStatus</p>
     * 
     * <p>Dispense Status</p>
     * 
     * <p><p>Indicates the status of the dispense record created on 
     * the EHR/DIS. If 'Active' it means that the dispense has been 
     * processed but not yet given to the patient. If 'Complete', 
     * it indicates that the device has been delivered to the 
     * patient.</p></p>
     * 
     * <p><p>Important in understanding what devices the patient 
     * actually has on hand, thus the attribute is mandatory. May 
     * also influence the ability of a different pharmacy to 
     * dispense the device.</p></p>
     * 
     * <p>B:Dispense Status</p>
     * 
     * <p><p>Indicates whether the dispense has been picked up 
     * ('complete') or has just been processed ('active').</p></p>
     * 
     * <p><p>Indicates how far along the process the dispense event 
     * is. It should always be known and is therefore 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }
    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }


    @Hl7XmlMapping({"subjectOf2/annotationIndicator","subjectOf3/annotationIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060040CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf2/annotationIndicator", type="PORX_MT060040CA.AnnotationIndicator"),
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060010CA.Subject12"),
        @Hl7MapByPartType(name="subjectOf3/annotationIndicator", type="PORX_MT060010CA.AnnotationIndicator")})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }


    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent","subjectOf4/detectedIssueEvent"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf2", type="PORX_MT060010CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf2/detectedIssueEvent", type="COCT_MT260030CA.DetectedIssueEvent"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060040CA.Subject6"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueEvent", type="COCT_MT260030CA.DetectedIssueEvent")})
    public List<IssuesBean> getSubjectOf4DetectedIssueEvent() {
        return this.subjectOf4DetectedIssueEvent;
    }


    @Hl7XmlMapping({"subjectOf5"})
    public List<IncludesBean> getSubjectOf5() {
        return this.subjectOf5;
    }


    @Hl7XmlMapping({"location"})
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }


    @Hl7XmlMapping({"subjectOf3/detectedIssueIndicator","subjectOf4/detectedIssueIndicator"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="subjectOf3", type="PORX_MT060040CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf3/detectedIssueIndicator", type="PORX_MT060040CA.DetectedIssueIndicator"),
        @Hl7MapByPartType(name="subjectOf4", type="PORX_MT060010CA.Subject13"),
        @Hl7MapByPartType(name="subjectOf4/detectedIssueIndicator", type="PORX_MT060010CA.DetectedIssueIndicator")})
    public Boolean getSubjectOf3DetectedIssueIndicator() {
        return this.subjectOf3DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf3DetectedIssueIndicator(Boolean subjectOf3DetectedIssueIndicator) {
        this.subjectOf3DetectedIssueIndicator.setValue(subjectOf3DetectedIssueIndicator);
    }


    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }


    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }


    @Hl7XmlMapping({"fulfillment/supplyRequest"})
    public PrescriptionReferenceBean getFulfillmentSupplyRequest() {
        return this.fulfillmentSupplyRequest;
    }
    public void setFulfillmentSupplyRequest(PrescriptionReferenceBean fulfillmentSupplyRequest) {
        this.fulfillmentSupplyRequest = fulfillmentSupplyRequest;
    }

}
