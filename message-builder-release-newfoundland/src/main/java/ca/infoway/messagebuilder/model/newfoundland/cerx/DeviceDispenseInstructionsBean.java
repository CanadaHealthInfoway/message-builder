package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.x_SubstitutionConditionNoneOrUnconditional;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.newfoundland.ServiceDeliveryLocationBean;

/**
 * 
 * @author administrator
 *
 * Business name: Dispense Instructions
 * Specification of how the prescribed device is to be dispensed to the patient. Dispensed instruction 
 * information includes the quantity to be dispensed, how often the quantity is to be dispensed, etc.
 * Sets the parameters within which the dispenser must operate in dispensing the device to the patient.
 * 
 * Maps to the SupplyRequest part type
 * 
 */
@Hl7PartTypeMapping({ "PORX_MT010110CA.SupplyRequest", "PORX_MT060040CA.SupplyRequest", "PORX_MT060060CA.SupplyRequest", "PORX_MT020060CA.SupplyRequest" })
public class DeviceDispenseInstructionsBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = 7909385234707845638L;

    private final INT quantity = new INTImpl();

    private final IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();

    private final CD dispenseFacilityNotAssignableIndicator = new CDImpl();

    private ServiceDeliveryLocationBean serviceDeliveryLocation;

    private final IVL<TS, Interval<Date>> toBePickedUpOn = new IVLImpl<TS, Interval<Date>>();

    private ServiceDeliveryLocationBean destination;

    private SupplementalFillInformationBean supplementalFillInformation;

    @Hl7XmlMapping("quantity")
    public Integer getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(Integer quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("location/substitutionConditionCode")
    public x_SubstitutionConditionNoneOrUnconditional getDispenseFacilityNotAssignableIndicator() {
        return (x_SubstitutionConditionNoneOrUnconditional) this.dispenseFacilityNotAssignableIndicator.getValue();
    }

    public void setDispenseFacilityNotAssignableIndicator(x_SubstitutionConditionNoneOrUnconditional dispenseFacilityNotAssignableIndicato) {
        this.dispenseFacilityNotAssignableIndicator.setValue(dispenseFacilityNotAssignableIndicato);
    }

    @Hl7XmlMapping("location/serviceDeliveryLocation")
    public ServiceDeliveryLocationBean getServiceDeliveryLocation() {
        return serviceDeliveryLocation;
    }

    public void setServiceDeliveryLocation(ServiceDeliveryLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

    @Hl7XmlMapping("expectedUseTime")
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }

    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }

    @Hl7XmlMapping("location/time")
    public Interval<Date> getToBePickedUpOn() {
        return this.toBePickedUpOn.getValue();
    }

    public void setToBePickedUpOn(Interval<Date> toBePickedUpOn) {
        this.toBePickedUpOn.setValue(toBePickedUpOn);
    }

    @Hl7XmlMapping("destination")
    public ServiceDeliveryLocationBean getDestination() {
        return destination;
    }

    public void setDestination(ServiceDeliveryLocationBean destination) {
        this.destination = destination;
    }

    @Hl7XmlMapping("component/supplementalFillInformation")
    public SupplementalFillInformationBean getSupplementalFillInformation() {
        return supplementalFillInformation;
    }

    public void setSupplementalFillInformation(SupplementalFillInformationBean supplementalFillInformation) {
        this.supplementalFillInformation = supplementalFillInformation;
    }
}
