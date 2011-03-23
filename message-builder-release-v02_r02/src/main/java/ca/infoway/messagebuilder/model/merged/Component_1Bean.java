/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import ca.infoway.messagebuilder.model.common.coct_mt141007ca.DeviceProductBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT020060CA.Component","PORX_MT060010CA.Component","PORX_MT060040CA.Component"})
public class Component_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private CV dispenseType = new CVImpl();
    private IVL<TS, Interval<Date>> dispenseProcessingAndPickupDate = new IVLImpl<TS, Interval<Date>>();
    private INT dispensedQuantity = new INTImpl();
    private IVL<TS, Interval<Date>> dispensedDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private DispenseShipToLocationBean supplyEventDestinationServiceDeliveryLocation;
    private RelatedPersonBean supplyEventReceiverPersonalRelationship;
    private DeviceProductBean supplyEventProductManufacturedProduct;

    @Hl7XmlMapping({"supplyEvent/code"})
    public ActPharmacySupplyType getDispenseType() {
        return (ActPharmacySupplyType) this.dispenseType.getValue();
    }
    public void setDispenseType(ActPharmacySupplyType dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }

    @Hl7XmlMapping({"supplyEvent/effectiveTime"})
    public Interval<Date> getDispenseProcessingAndPickupDate() {
        return this.dispenseProcessingAndPickupDate.getValue();
    }
    public void setDispenseProcessingAndPickupDate(Interval<Date> dispenseProcessingAndPickupDate) {
        this.dispenseProcessingAndPickupDate.setValue(dispenseProcessingAndPickupDate);
    }

    @Hl7XmlMapping({"supplyEvent/quantity"})
    public Integer getDispensedQuantity() {
        return this.dispensedQuantity.getValue();
    }
    public void setDispensedQuantity(Integer dispensedQuantity) {
        this.dispensedQuantity.setValue(dispensedQuantity);
    }

    @Hl7XmlMapping({"supplyEvent/expectedUseTime"})
    public Interval<Date> getDispensedDaysSupply() {
        return this.dispensedDaysSupply.getValue();
    }
    public void setDispensedDaysSupply(Interval<Date> dispensedDaysSupply) {
        this.dispensedDaysSupply.setValue(dispensedDaysSupply);
    }

    @Hl7XmlMapping({"supplyEvent/destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getSupplyEventDestinationServiceDeliveryLocation() {
        return this.supplyEventDestinationServiceDeliveryLocation;
    }
    public void setSupplyEventDestinationServiceDeliveryLocation(DispenseShipToLocationBean supplyEventDestinationServiceDeliveryLocation) {
        this.supplyEventDestinationServiceDeliveryLocation = supplyEventDestinationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"supplyEvent/receiver/personalRelationship"})
    public RelatedPersonBean getSupplyEventReceiverPersonalRelationship() {
        return this.supplyEventReceiverPersonalRelationship;
    }
    public void setSupplyEventReceiverPersonalRelationship(RelatedPersonBean supplyEventReceiverPersonalRelationship) {
        this.supplyEventReceiverPersonalRelationship = supplyEventReceiverPersonalRelationship;
    }

    @Hl7XmlMapping({"supplyEvent/product/manufacturedProduct"})
    public DeviceProductBean getSupplyEventProductManufacturedProduct() {
        return this.supplyEventProductManufacturedProduct;
    }
    public void setSupplyEventProductManufacturedProduct(DeviceProductBean supplyEventProductManufacturedProduct) {
        this.supplyEventProductManufacturedProduct = supplyEventProductManufacturedProduct;
    }

}
