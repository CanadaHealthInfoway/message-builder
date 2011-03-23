/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt060340ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.DispenseShipToLocationBean;
import ca.infoway.messagebuilder.model.merged.OccurredAtBean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;
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
@Hl7PartTypeMapping({"PORX_MT060340CA.SupplyRequest"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CS prescriptionDispensableIndicator = new CSImpl();
    private IVL<TS, Interval<Date>> dispensingAllowedPeriod = new IVLImpl<TS, Interval<Date>>();
    private List<RelatedPersonBean> receiverPersonalRelationship = new ArrayList<RelatedPersonBean>();
    private OccurredAtBean location;
    private List<Component3Bean> component = new ArrayList<Component3Bean>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;

    @Hl7XmlMapping({"statusCode"})
    public ActStatus getPrescriptionDispensableIndicator() {
        return (ActStatus) this.prescriptionDispensableIndicator.getValue();
    }
    public void setPrescriptionDispensableIndicator(ActStatus prescriptionDispensableIndicator) {
        this.prescriptionDispensableIndicator.setValue(prescriptionDispensableIndicator);
    }

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
    public OccurredAtBean getLocation() {
        return this.location;
    }
    public void setLocation(OccurredAtBean location) {
        this.location = location;
    }

    @Hl7XmlMapping({"component"})
    public List<Component3Bean> getComponent() {
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
