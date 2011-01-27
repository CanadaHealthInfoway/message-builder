/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt220210ca.DrugProductBean;
import ca.infoway.messagebuilder.model.merged.RelatedPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT060090CA.SupplyEvent","PORX_MT060100CA.SupplyEvent","PORX_MT060160CA.SupplyEvent","PORX_MT060340CA.SupplyEvent"})
public class SupplyEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private RelatedPersonBean receiverPersonalRelationship;
    private DrugProductBean productMedication;
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private PQ dispensedQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private CV dispenseType = new CVImpl();


    @Hl7XmlMapping({"receiver/personalRelationship"})
    public RelatedPersonBean getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }
    public void setReceiverPersonalRelationship(RelatedPersonBean receiverPersonalRelationship) {
        this.receiverPersonalRelationship = receiverPersonalRelationship;
    }


    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }


    /**
     * <p>Dispense Processing and Pickup Date</p>
     * 
     * <p>D:Dispensed Processing and Pickup Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>DispensedQuantity</p>
     * 
     * <p>Dispensed Quantity</p>
     * 
     * <p>F:Dispensed Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getDispensedQuantity() {
        return this.dispensedQuantity.getValue();
    }
    public void setDispensedQuantity(PhysicalQuantity dispensedQuantity) {
        this.dispensedQuantity.setValue(dispensedQuantity);
    }


    /**
     * <p>Dispense Days Supply</p>
     * 
     * <p>Dispensed Days Supply</p>
     * 
     * <p>G:Dispensed Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>DispenseType</p>
     * 
     * <p>Dispense Type</p>
     * 
     * <p>B:Dispense Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getDispenseType() {
        return (ActPharmacySupplyType) this.dispenseType.getValue();
    }
    public void setDispenseType(ActPharmacySupplyType dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }

}
