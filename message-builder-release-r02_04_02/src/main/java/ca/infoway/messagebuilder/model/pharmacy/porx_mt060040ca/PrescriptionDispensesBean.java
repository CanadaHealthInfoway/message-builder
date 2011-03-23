/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt090108ca.HealthcareWorkerBean;
import ca.infoway.messagebuilder.model.common.coct_mt260030ca.IssuesBean;
import ca.infoway.messagebuilder.model.merged.DispenseDetailsBean;
import ca.infoway.messagebuilder.model.merged.HasNotesBean;
import ca.infoway.messagebuilder.model.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.merged.ProcedureRequestBean;
import ca.infoway.messagebuilder.model.merged.StatusChangesBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Prescription Dispenses</p>
 * 
 * <p>This is the detailed information about a device dispense 
 * that has been performed on behalf of a patient.</p>
 * 
 * <p>Dispensing is an integral part of the overall 
 * prescription process.</p>
 * 
 * <p>Reported Issue is only permitted if Issue Indicator is 
 * not present</p>
 * 
 * <p>Annotation is only permitted if Annotation Indicator is 
 * not present</p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.DeviceDispense"})
public class PrescriptionDispensesBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II prescriptionDispenseNumber = new IIImpl();
    private CS dispenseStatus = new CSImpl();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private HealthcareWorkerBean performerAssignedEntity;
    private OccurredAtBean location;
    private ProcedureRequestBean component1ProcedureRequest;
    private DispenseDetailsBean component2SupplyEvent;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private BL subjectOf2AnnotationIndicator = new BLImpl(false);
    private BL subjectOf3DetectedIssueIndicator = new BLImpl(false);
    private List<IssuesBean> subjectOf4DetectedIssueEvent = new ArrayList<IssuesBean>();
    private List<HasNotesBean> subjectOf5 = new ArrayList<HasNotesBean>();

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
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"component1/procedureRequest"})
    public ProcedureRequestBean getComponent1ProcedureRequest() {
        return this.component1ProcedureRequest;
    }
    public void setComponent1ProcedureRequest(ProcedureRequestBean component1ProcedureRequest) {
        this.component1ProcedureRequest = component1ProcedureRequest;
    }

    @Hl7XmlMapping({"component2/supplyEvent"})
    public DispenseDetailsBean getComponent2SupplyEvent() {
        return this.component2SupplyEvent;
    }
    public void setComponent2SupplyEvent(DispenseDetailsBean component2SupplyEvent) {
        this.component2SupplyEvent = component2SupplyEvent;
    }

    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    @Hl7XmlMapping({"subjectOf2/annotationIndicator"})
    public Boolean getSubjectOf2AnnotationIndicator() {
        return this.subjectOf2AnnotationIndicator.getValue();
    }
    public void setSubjectOf2AnnotationIndicator(Boolean subjectOf2AnnotationIndicator) {
        this.subjectOf2AnnotationIndicator.setValue(subjectOf2AnnotationIndicator);
    }

    @Hl7XmlMapping({"subjectOf3/detectedIssueIndicator"})
    public Boolean getSubjectOf3DetectedIssueIndicator() {
        return this.subjectOf3DetectedIssueIndicator.getValue();
    }
    public void setSubjectOf3DetectedIssueIndicator(Boolean subjectOf3DetectedIssueIndicator) {
        this.subjectOf3DetectedIssueIndicator.setValue(subjectOf3DetectedIssueIndicator);
    }

    @Hl7XmlMapping({"subjectOf4/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf4DetectedIssueEvent() {
        return this.subjectOf4DetectedIssueEvent;
    }

    @Hl7XmlMapping({"subjectOf5"})
    public List<HasNotesBean> getSubjectOf5() {
        return this.subjectOf5;
    }

}
