package ca.infoway.messagebuilder.model.newfoundland.cerx.revise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.IdentifiedPersonBean;
import ca.infoway.messagebuilder.model.newfoundland.OfPatient;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SupplyRequestBean;

@Hl7PartTypeMapping({ "PORX_MT010140CA.SupplyRequest" })
public class DispenseAuthorizationBean extends MessagePartBean implements OfPatient, Serializable {

    private static final long serialVersionUID = -2756594107165201690L;

    IdentifiedPersonBean patient;

    ServiceDeliveryLocationBean location;

    List<SupplyRequestBean> supplyEvents = new ArrayList<SupplyRequestBean>();

    II prescriptionIdentifier = new IIImpl();

    @Hl7XmlMapping("subject/patient")
    public IdentifiedPersonBean getPatient() {
        return patient;
    }

    public void setPatient(IdentifiedPersonBean patient) {
        this.patient = patient;
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getLocation() {
        return location;
    }

    public void setLocation(ServiceDeliveryLocationBean location) {
        this.location = location;
    }

    @Hl7XmlMapping("fullfillment/supplyEvent")
    public List<SupplyRequestBean> getSupplyEvents() {
        return supplyEvents;
    }

    public void setSupplyEvents(List<SupplyRequestBean> supplyEvents) {
        this.supplyEvents = supplyEvents;
    }

    @Hl7XmlMapping("componentOf/actRequest/id")
    public Identifier getPrescriptionIdentifier() {
        return this.prescriptionIdentifier.getValue();
    }

    public void setPrescriptionIdentifier(Identifier prescriptionIdentifier) {
        this.prescriptionIdentifier.setValue(prescriptionIdentifier);
    }

    public Identifier getId() {
        return this.getPrescriptionIdentifier();
    }

    public void setId(Identifier id) {
        this.setPrescriptionIdentifier(id);
    }
}
