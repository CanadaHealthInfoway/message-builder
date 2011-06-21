/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.porx_mt020070ca;

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
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.coct_mt220200ca.DrugProductBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged.DispenseShipToLocationBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT020070CA.SupplyEvent"})
public class SupplyEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private CV dispenseType = new CVImpl();
    private IVL<TS, Interval<Date>> dispenseProcessingAndPickupDate = new IVLImpl<TS, Interval<Date>>();
    private PQ dispensedQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> dispensedDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private DrugProductBean productMedication;


    /**
     * <p>Dispense Type</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the type of dispensing event that is performed. Examples 
     * include: Trial Fill, Completion of Trial, Partial Fill, 
     * Emergency Fill, Samples, etc.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.activityType</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D52</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.2</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.403-D3</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.343-HD</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * reason for the size of dispense. Because it defines what 
     * type of dispense is occurring, the attribute is 
     * mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getDispenseType() {
        return (ActPharmacySupplyType) this.dispenseType.getValue();
    }
    public void setDispenseType(ActPharmacySupplyType dispenseType) {
        this.dispenseType.setValue(dispenseType);
    }


    /**
     * <p>Dispense Processing and Pickup Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Represents 
     * the date the dispense product was prepared and when the 
     * product was picked up by or delivered to the patient. The 
     * dispense processing date and pickup date can be back dated 
     * to reflect when the actual processing and pickup occurred. 
     * The lower-bound of the period signifies the 
     * dispense-processing date whereas the upper-bound signifies 
     * the dispense-pickup date.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.9</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.17 
     * (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=07, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=36, format=102)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispense 
     * Date</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispenseDate</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used by the 
     * system in calculating expected exhaustion time. Valuable in 
     * compliance checking. This attribute is mandatory because an 
     * existing dispense record must at least indicate the date it 
     * was processed.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Must be able 
     * to post-date a dispense (enter retroactively) e.g. system 
     * failure.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispenseProcessingAndPickupDate() {
        return this.dispenseProcessingAndPickupDate.getValue();
    }
    public void setDispenseProcessingAndPickupDate(Interval<Date> dispenseProcessingAndPickupDate) {
        this.dispenseProcessingAndPickupDate.setValue(dispenseProcessingAndPickupDate);
    }


    /**
     * <p>Dispensed Quantity</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The amount 
     * of medication that has been dispensed. Includes unit of 
     * measure.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-02 
     * (Quantity, qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-03 
     * (qualifier=38 0r 87)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.442-E7</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.460-ET</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.600-28</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Quantity</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.dispensedAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">D58</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZPB3.4</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.10.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.1</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.9.2.1 (the 
     * fact that it is package is determined by a playing 
     * entity)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.020-01 (Unit, 
     * qualifier=38 0r 87)</p><p 

     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getDispensedQuantity() {
        return this.dispensedQuantity.getValue();
    }
    public void setDispensedQuantity(PhysicalQuantity dispensedQuantity) {
        this.dispensedQuantity.setValue(dispensedQuantity);
    }


    /**
     * <p>Dispensed Days Supply</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The number 
     * of days that the dispensed quantity is expected to last.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D59(width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.11</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=ZDS, format=804)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.405-D5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Days Supply</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.daysSupply</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D59(width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.11</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=ZDS, format=804)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.405-D5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Days Supply</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.daysSupply</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D59(width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.11</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=ZDS, format=804)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.405-D5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Days Supply</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.daysSupply</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D59(width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.11</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=ZDS, format=804)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.405-D5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Days Supply</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.daysSupply</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D59(width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.11</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=ZDS, format=804)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.405-D5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Days Supply</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.daysSupply</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D59(width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.11</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=ZDS, format=804)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.405-D5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Days Supply</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.daysSupply</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">D59(width)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ZDP.11</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DRU.040-02 (low, 
     * qualifier=ZDS, format=804)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Claim.405-D5</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">A_BillablePharmacyDispense</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Days Supply</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.daysSupply</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
     * monitoring patient compliance. May also be useful in 
     * determining and managing certain contraindications 
     * ('Fill-Too-Soon', 'Fill-Too-Late', and 'Duration of 
     * Therapy'). Because 'Days Supply' may be necessary to compute 
     * total dispensed quantity, it is made a 'populated' 
     * field.</p></p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getDispensedDaysSupply() {
        return this.dispensedDaysSupply.getValue();
    }
    public void setDispensedDaysSupply(Interval<Date> dispensedDaysSupply) {
        this.dispensedDaysSupply.setValue(dispensedDaysSupply);
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"product/medication"})
    public DrugProductBean getProductMedication() {
        return this.productMedication;
    }
    public void setProductMedication(DrugProductBean productMedication) {
        this.productMedication = productMedication;
    }

}
