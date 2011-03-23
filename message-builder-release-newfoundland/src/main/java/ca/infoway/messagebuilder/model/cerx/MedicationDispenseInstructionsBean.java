package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ServiceDeliveryLocationBean;

/**
 * 
 * @author administrator
 *
 * Business name: Dispense Instructions
 *Specification of how the prescribed medication is to be dispensed to the patient. Dispensed instruction information 
 *includes the quantity to be dispensed, how often the quantity is to be dispensed, etc.
 *Sets the parameters within which the dispenser must operate in dispensing the medication to the patient.
 * 
 * Maps to the SupplyRequest part type
 * 
 */
@Hl7PartTypeMapping({ "PORX_MT030040CA.SupplyRequest", "PORX_MT060190CA.SupplyRequest" })
public class MedicationDispenseInstructionsBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 3026470404713654076L;

    private CD actStatus = new CDImpl();

    private PQ quantity = new PQImpl();

    private ServiceDeliveryLocationBean serviceDeliveryLocation;

    @Hl7XmlMapping("statusCode")
    public ActStatus getActStatus() {
        return (ActStatus) this.actStatus.getValue();
    }

    public void setActStatus(ActStatus actStatus) {
        this.actStatus.setValue(actStatus);
    }

    @Hl7XmlMapping("quantity")
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getServiceDeliveryLocation() {
        return serviceDeliveryLocation;
    }

    public void setServiceDeliveryLocation(ServiceDeliveryLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }
}
