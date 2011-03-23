/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt010120ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.merged.TargetedToPharmacyBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Dispense Instructions</p>
 * 
 * <p>Specification of how the prescribed medication is to be 
 * dispensed to the patient. Dispensed instruction information 
 * includes the quantity to be dispensed, how often the 
 * quantity is to be dispensed, etc.</p>
 * 
 * <p>Sets the parameters within which the dispenser must 
 * operate in dispensing the medication to the patient.</p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private IVL<TS, Interval<Date>> dispensingAllowedPeriod = new IVLImpl<TS, Interval<Date>>();
    private List<RelatedPersonBean> receiverPersonalRelationship = new ArrayList<RelatedPersonBean>();
    private TargetedToPharmacyBean location;
    private List<ComponentBean> component = new ArrayList<ComponentBean>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispensingAllowedPeriod() {
        return this.dispensingAllowedPeriod.getValue();
    }
    public void setDispensingAllowedPeriod(Interval<Date> dispensingAllowedPeriod) {
        this.dispensingAllowedPeriod.setValue(dispensingAllowedPeriod);
    }

    @Hl7XmlMapping({"receiver/personalRelationship"})
    public List<RelatedPersonBean> getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }

    @Hl7XmlMapping({"location"})
    public TargetedToPharmacyBean getLocation() {
        return this.location;
    }
    public void setLocation(TargetedToPharmacyBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"component"})
    public List<ComponentBean> getComponent() {
        return this.component;
    }

    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }

}
