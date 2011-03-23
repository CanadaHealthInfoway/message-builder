/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.porx_mt020070ca;

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
import ca.infoway.messagebuilder.model.common.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.merged.DispenseShipToLocationBean;
import java.util.Date;



/**
 * <p>includes</p>
 * 
 * <p>Indicates the days supply and quantity of medication 
 * dispensed.</p>
 * 
 * <p>Dispense is not complete without specifying quantity 
 * dispensed, and thus this association is mandatory.</p>
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.Component"})
public class IncludesBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private CV dispenseType = new CVImpl();
    private IVL<TS, Interval<Date>> dispenseProcessingAndPickupDate = new IVLImpl<TS, Interval<Date>>();
    private PQ dispensedQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> dispensedDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private DrugProductBean supplyEventProductMedication;
    private DispenseShipToLocationBean supplyEventDestinationServiceDeliveryLocation;

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
    public PhysicalQuantity getDispensedQuantity() {
        return this.dispensedQuantity.getValue();
    }
    public void setDispensedQuantity(PhysicalQuantity dispensedQuantity) {
        this.dispensedQuantity.setValue(dispensedQuantity);
    }

    @Hl7XmlMapping({"supplyEvent/expectedUseTime"})
    public Interval<Date> getDispensedDaysSupply() {
        return this.dispensedDaysSupply.getValue();
    }
    public void setDispensedDaysSupply(Interval<Date> dispensedDaysSupply) {
        this.dispensedDaysSupply.setValue(dispensedDaysSupply);
    }

    @Hl7XmlMapping({"supplyEvent/product/medication"})
    public DrugProductBean getSupplyEventProductMedication() {
        return this.supplyEventProductMedication;
    }
    public void setSupplyEventProductMedication(DrugProductBean supplyEventProductMedication) {
        this.supplyEventProductMedication = supplyEventProductMedication;
    }

    @Hl7XmlMapping({"supplyEvent/destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getSupplyEventDestinationServiceDeliveryLocation() {
        return this.supplyEventDestinationServiceDeliveryLocation;
    }
    public void setSupplyEventDestinationServiceDeliveryLocation(DispenseShipToLocationBean supplyEventDestinationServiceDeliveryLocation) {
        this.supplyEventDestinationServiceDeliveryLocation = supplyEventDestinationServiceDeliveryLocation;
    }

}
