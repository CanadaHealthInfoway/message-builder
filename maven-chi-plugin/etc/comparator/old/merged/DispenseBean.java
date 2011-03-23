/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_NormalRestrictedTabooConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt120600ca.NotesBean;
import ca.infoway.messagebuilder.model.common.porx_mt060010ca.DispensedBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT260010CA.SupplyEvent","COCT_MT260020CA.SupplyEvent","COCT_MT260030CA.SupplyEvent","PORX_MT020060CA.DeviceDispense","PORX_MT060010CA.DeviceDispense","PORX_MT060040CA.DeviceDispense","PORX_MT060090CA.MedicationDispense","PORX_MT060100CA.MedicationDispense"})
@Hl7RootType
public class DispenseBean extends MessagePartBean implements CausalActsBean, ca.infoway.messagebuilder.model.common.coct_mt260030ca.CausalActsBean {

    private II prescriptionDispenseNumber = new IIImpl();
    private SET<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind> prescriptionMaskingIndicators = new SETImpl<CV<x_NormalRestrictedTabooConfidentialityKind>, x_NormalRestrictedTabooConfidentialityKind>(CVImpl.class);
    private DispensedForBean subject;
    private ca.infoway.messagebuilder.model.common.porx_mt020060ca.DispensedBean inFulfillmentOf = new ca.infoway.messagebuilder.model.common.porx_mt020060ca.DispensedBean();
    private ST usageInstructions = new STImpl();
    private Component2_1Bean component2 = new Component2_1Bean();
    private NotesBean subjectOfAnnotation;
    private CS<ActStatus> dispenseStatus = new CSImpl<ActStatus>();
    private HealthcareWorkerBean responsiblePartyAssignedEntity;
    private HealthcareWorkerBean performerAssignedEntity = new HealthcareWorkerBean();
    private CreatedAtBean location = new CreatedAtBean();
    private DispensedBean fulfillment;
    private List<StatusChangesBean> subjectOf1ControlActEvent = new ArrayList<StatusChangesBean>();
    private List<IssuesBean> subjectOf2DetectedIssueEvent = new ArrayList<IssuesBean>();
    private NotesIndicatorBean subjectOf3;
    private IssueIndicatorBean subjectOf4;
    private List<NotesBean> subjectOf5Annotation = new ArrayList<NotesBean>();
    private Component2_2Bean component3 = new Component2_2Bean();
    private IVL<TS, Interval<Date>> dispensedDate = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean productMedication = new DrugProductBean();

    @Hl7XmlMapping({"id"})
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }
    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_NormalRestrictedTabooConfidentialityKind> getPrescriptionMaskingIndicators() {
        return this.prescriptionMaskingIndicators.rawSet();
    }

    @Hl7XmlMapping({"subject"})
    public DispensedForBean getSubject() {
        return this.subject;
    }
    public void setSubject(DispensedForBean subject) {
        this.subject = subject;
    }

    @Hl7XmlMapping({"inFulfillmentOf"})
    public ca.infoway.messagebuilder.model.common.porx_mt020060ca.DispensedBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }
    public void setInFulfillmentOf(ca.infoway.messagebuilder.model.common.porx_mt020060ca.DispensedBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }

    @Hl7XmlMapping({"component1/procedureRequest/text"})
    public java.lang.String getUsageInstructions() {
        return this.usageInstructions.getValue();
    }
    public void setUsageInstructions(java.lang.String usageInstructions) {
        this.usageInstructions.setValue(usageInstructions);
    }

    @Hl7XmlMapping({"component2"})
    public Component2_1Bean getComponent2() {
        return this.component2;
    }
    public void setComponent2(Component2_1Bean component2) {
        this.component2 = component2;
    }

    @Hl7XmlMapping({"subjectOf/annotation"})
    public NotesBean getSubjectOfAnnotation() {
        return this.subjectOfAnnotation;
    }
    public void setSubjectOfAnnotation(NotesBean subjectOfAnnotation) {
        this.subjectOfAnnotation = subjectOfAnnotation;
    }

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getDispenseStatus() {
        return this.dispenseStatus.getValue();
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
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"fulfillment"})
    public DispensedBean getFulfillment() {
        return this.fulfillment;
    }
    public void setFulfillment(DispensedBean fulfillment) {
        this.fulfillment = fulfillment;
    }

    @Hl7XmlMapping({"subjectOf1/controlActEvent"})
    public List<StatusChangesBean> getSubjectOf1ControlActEvent() {
        return this.subjectOf1ControlActEvent;
    }

    @Hl7XmlMapping({"subjectOf2/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOf2DetectedIssueEvent() {
        return this.subjectOf2DetectedIssueEvent;
    }

    @Hl7XmlMapping({"subjectOf3"})
    public NotesIndicatorBean getSubjectOf3() {
        return this.subjectOf3;
    }
    public void setSubjectOf3(NotesIndicatorBean subjectOf3) {
        this.subjectOf3 = subjectOf3;
    }

    @Hl7XmlMapping({"subjectOf4"})
    public IssueIndicatorBean getSubjectOf4() {
        return this.subjectOf4;
    }
    public void setSubjectOf4(IssueIndicatorBean subjectOf4) {
        this.subjectOf4 = subjectOf4;
    }

    @Hl7XmlMapping({"subjectOf5/annotation"})
    public List<NotesBean> getSubjectOf5Annotation() {
        return this.subjectOf5Annotation;
    }

    @Hl7XmlMapping({"component3"})
    public Component2_2Bean getComponent3() {
        return this.component3;
    }
    public void setComponent3(Component2_2Bean component3) {
        this.component3 = component3;
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispensedDate() {
        return this.dispensedDate.getValue();
    }
    public void setDispensedDate(Interval<Date> dispensedDate) {
        this.dispensedDate.setValue(dispensedDate);
    }

    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }

}
