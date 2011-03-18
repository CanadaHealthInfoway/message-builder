/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt141007ca.DeviceProductBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.RelatedPersonBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT020060CA.SupplyEvent","PORX_MT060010CA.SupplyEvent","PORX_MT060020CA.SupplyEvent","PORX_MT060040CA.SupplyEvent"})
public class DispenseDetailsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private INT dispensedQuantity = new INTImpl();
    private CV dispenseType = new CVImpl();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private INT numberOfRemainingFills = new INTImpl();
    private DeviceProductBean productManufacturedProduct;
    private IVL<TS, Interval<Date>> expectedUseTime = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> dispenseProcessingAndPickupDate = new IVLImpl<TS, Interval<Date>>();
    private RelatedPersonBean receiverPersonalRelationship;


    /**
     * <p>DispensedQuantity</p>
     * 
     * <p>Dispensed Quantity</p>
     * 
     * <p><p>The number of devices that have been dispensed.</p></p>
     * 
     * <p><p>Critical in understanding the patient's profile, both 
     * past and current, This is also mandatory to allow 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p></p>
     * 
     * <p>Dispensed Quantity</p>
     * 
     * <p><p>The number of devices that have been dispensed.</p></p>
     * 
     * <p><p>D58</p><p>ZPB3.4</p></p>
     * 
     * <p><p>D58</p><p>ZPB3.4</p></p>
     * 
     * <p><p>Critical in understanding the patient's profile, both 
     * past and current, This is also mandatory to allow 
     * determination of the amount that remains to be dispensed 
     * against the prescription.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getDispensedQuantity() {
        return this.dispensedQuantity.getValue();
    }
    public void setDispensedQuantity(Integer dispensedQuantity) {
        this.dispensedQuantity.setValue(dispensedQuantity);
    }


    /**
     * <p>DispenseType</p>
     * 
     * <p>Dispense Type</p>
     * 
     * <p><p>Indicates the type of dispensing event that is 
     * performed. Examples include: Trial Fill, Completion of 
     * Trial, Partial Fill, Emergency Fill, Samples, etc.</p></p>
     * 
     * <p><p>Indicates reason for the size of dispense. Because it 
     * defines what type of dispense is occurring, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getDispenseType() {
        return (ActPharmacySupplyType) this.dispenseType.getValue();
    }
    public void setDispenseType(ActPharmacySupplyType dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    /**
     * <p>NumberOfRemainingFills</p>
     * 
     * <p>Number of remaining fills</p>
     * 
     * <p><p>Stipulates the number of remaining fills for this 
     * prescription</p></p>
     * 
     * <p><p>The number of remaining fills is used to evaluate the 
     * &quot;completed&quot; status of the prescription.</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getNumberOfRemainingFills() {
        return this.numberOfRemainingFills.getValue();
    }
    public void setNumberOfRemainingFills(Integer numberOfRemainingFills) {
        this.numberOfRemainingFills.setValue(numberOfRemainingFills);
    }


    @Hl7XmlMapping({"product/manufacturedProduct"})
    public DeviceProductBean getProductManufacturedProduct() {
        return this.productManufacturedProduct;
    }
    public void setProductManufacturedProduct(DeviceProductBean productManufacturedProduct) {
        this.productManufacturedProduct = productManufacturedProduct;
    }


    /**
     * <p>Dispensed Days Supply</p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last. Cannot be mandatory as there are some 
     * situations where 'as needed' cannot be used to determine 
     * days supply.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     * 
     * <p>Dispense Days Supply</p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last.</p><p>Cannot be mandatory as there are 
     * some situations where 'as needed' cannot be used to 
     * determine days supply.</p></p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last.</p><p>Cannot be mandatory as there are 
     * some situations where 'as needed' cannot be used to 
     * determine days supply.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     * 
     * <p>Dispensed Days Supply</p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last. Cannot be mandatory as there are some 
     * situations where 'as needed' cannot be used to determine 
     * days supply.</p></p>
     * 
     * <p><p>.daysSupply</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     * 
     * <p>Dispensed Days Supply</p>
     * 
     * <p><p>The number of days that the dispensed quantity is 
     * expected to last.</p></p>
     * 
     * <p><p>Useful in monitoring patient compliance. May also be 
     * useful in determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getExpectedUseTime() {
        return this.expectedUseTime.getValue();
    }
    public void setExpectedUseTime(Interval<Date> expectedUseTime) {
        this.expectedUseTime.setValue(expectedUseTime);
    }


    /**
     * <p>DispenseProcessingAndPickupDate</p>
     * 
     * <p>Dispense Processing and Pickup Date</p>
     * 
     * <p><p>Represents the date the dispense product was prepared 
     * and when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p></p>
     * 
     * <p><p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p></p>
     * 
     * <p><p>Must be able to post-date a dispense (enter 
     * retroactively) e.g. system failure.</p></p>
     * 
     * <p>Dispense Processing and Pickup Date</p>
     * 
     * <p><p>Represents the date the dispense product was prepared 
     * and when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p></p>
     * 
     * <p><p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking.</p><p>This attribute 
     * is mandatory because an existing dispense record must at 
     * least indicate the date it was processed.</p></p>
     * 
     * <p><p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking.</p><p>This attribute 
     * is mandatory because an existing dispense record must at 
     * least indicate the date it was processed.</p></p>
     * 
     * <p>Dispense Processing and Pickup Date</p>
     * 
     * <p><p>Represents the date the dispense product was prepared 
     * and when the product was picked up by or delivered to the 
     * patient. The dispense processing date and pickup date can be 
     * back dated to reflect when the actual processing and pickup 
     * occurred. The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p></p>
     * 
     * <p><p>Used by the system in calculating expected exhaustion 
     * time. Valuable in compliance checking. This attribute is 
     * mandatory because an existing dispense record must at least 
     * indicate the date it was processed.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispenseProcessingAndPickupDate() {
        return this.dispenseProcessingAndPickupDate.getValue();
    }
    public void setDispenseProcessingAndPickupDate(Interval<Date> dispenseProcessingAndPickupDate) {
        this.dispenseProcessingAndPickupDate.setValue(dispenseProcessingAndPickupDate);
    }


    @Hl7XmlMapping({"receiver/personalRelationship"})
    public RelatedPersonBean getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }
    public void setReceiverPersonalRelationship(RelatedPersonBean receiverPersonalRelationship) {
        this.receiverPersonalRelationship = receiverPersonalRelationship;
    }

}
