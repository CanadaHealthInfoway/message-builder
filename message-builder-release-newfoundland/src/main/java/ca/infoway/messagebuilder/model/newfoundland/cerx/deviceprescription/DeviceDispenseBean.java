package ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.AssignedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.DetectedIssueBean;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.HistoricalControlActEventBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SupplyEventBean;
import ca.infoway.messagebuilder.model.newfoundland.confidentiality.VeryBasicConfidentiality;

@Hl7PartTypeMapping({ "PORX_MT060010CA.DeviceDispense", "PORX_MT060040CA.DeviceDispense" })
public class DeviceDispenseBean extends MessagePartBean implements Serializable, VeryBasicConfidentiality {

    private static final long serialVersionUID = 3289029108773055796L;

    private II prescriptionDispenseNumber = new IIImpl();

    private CD dispenseStatus = new CDImpl();

    private CD confidentialityCode = new CDImpl();

    private AssignedPersonBean responsibleParty;

    private AssignedPersonBean performer;

    private ServiceDeliveryLocationBean serviceDeliveryLocation;

    private ST usageInstructions = new STImpl();

    private SupplyEventBean supplyEvent;

    private II prescriptionOrderNumber = new IIImpl();

    private AssignedPersonBean supplyRequestResponsibleParty;

    private AssignedPersonBean supplyRequestAuthor;

    private final List<HistoricalControlActEventBean> deviceDispenseHistoryRecords = Collections.synchronizedList(new ArrayList<HistoricalControlActEventBean>());

    private final List<DetectedIssueBean> detectedIssues = Collections.synchronizedList(new ArrayList<DetectedIssueBean>());

    private final List<NoteBean> notes = Collections.synchronizedList(new ArrayList<NoteBean>());

    @Hl7XmlMapping({ "id" })
    public Identifier getPrescriptionDispenseNumber() {
        return this.prescriptionDispenseNumber.getValue();
    }

    public void setPrescriptionDispenseNumber(Identifier prescriptionDispenseNumber) {
        this.prescriptionDispenseNumber.setValue(prescriptionDispenseNumber);
    }

    @Hl7XmlMapping({ "statusCode" })
    public ActStatus getDispenseStatus() {
        return (ActStatus) this.dispenseStatus.getValue();
    }

    public void setDispenseStatus(ActStatus dispenseStatus) {
        this.dispenseStatus.setValue(dispenseStatus);
    }

    @Hl7XmlMapping({ "confidentialityCode" })
    public x_VeryBasicConfidentialityKind getConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.confidentialityCode.getValue();
    }

    public void setConfidentialityCode(x_VeryBasicConfidentialityKind confidentialityCode) {
        this.confidentialityCode.setValue(confidentialityCode);
    }

    @Hl7XmlMapping({ "responsibleParty/assignedPerson" })
    public AssignedPersonBean getResponsibleParty() {
        return responsibleParty;
    }

    public void setResponsibleParty(AssignedPersonBean responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    @Hl7XmlMapping({ "performer/assignedPerson" })
    public AssignedPersonBean getPerformer() {
        return performer;
    }

    public void setPerformer(AssignedPersonBean performer) {
        this.performer = performer;
    }

    @Hl7XmlMapping({ "location/serviceDeliveryLocation" })
    public ServiceDeliveryLocationBean getServiceDeliveryLocation() {
        return serviceDeliveryLocation;
    }

    public void setServiceDeliveryLocation(ServiceDeliveryLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

    @Hl7XmlMapping("component1/procedureRequest/text")
    public String getUsageInstructions() {
        return this.usageInstructions.getValue();
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions.setValue(usageInstructions);
    }

    @Hl7XmlMapping("component2/supplyEvent")
    public SupplyEventBean getSupplyEvent() {
        return supplyEvent;
    }

    public void setSupplyEvent(SupplyEventBean supplyEvent) {
        this.supplyEvent = supplyEvent;
    }

    @Hl7XmlMapping("fulfillment/supplyRequest/id")
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }

    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

    @Hl7XmlMapping("fulfillment/supplyRequest/responsibleParty/assignedPerson")
    public AssignedPersonBean getSupplyRequestResponsibleParty() {
        return supplyRequestResponsibleParty;
    }

    public void setSupplyRequestResponsibleParty(AssignedPersonBean supplyRequestResponsibleParty) {
        this.supplyRequestResponsibleParty = supplyRequestResponsibleParty;
    }

    @Hl7XmlMapping("fulfillment/supplyRequest/author/assignedPerson")
    public AssignedPersonBean getSupplyRequestAuthor() {
        return supplyRequestAuthor;
    }

    public void setSupplyRequestAuthor(AssignedPersonBean supplyRequestAuthor) {
        this.supplyRequestAuthor = supplyRequestAuthor;
    }

    @Hl7XmlMapping("subjectOf1/controlActEvent")
    public List<HistoricalControlActEventBean> getDeviceDispenseHistoryRecords() {
        return deviceDispenseHistoryRecords;
    }

    @Hl7XmlMapping({ "subjectOf4/detectedIssueEvent", "subjectOf2/detectedIssueEvent" })
    public List<DetectedIssueBean> getDetectedIssues() {
        return detectedIssues;
    }

    @Hl7XmlMapping("subjectOf5/annotation")
    public List<NoteBean> getNotes() {
        return notes;
    }
}
