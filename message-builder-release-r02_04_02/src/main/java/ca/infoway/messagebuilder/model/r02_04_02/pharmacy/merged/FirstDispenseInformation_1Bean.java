/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>FirstDispenseInformation</p>
 * 
 * <p>PORX_MT030040CA.SupplyEventFirstSummary: First Dispense 
 * Information</p>
 * 
 * <p><p>Provides summary information about the first dispense 
 * event on the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT060190CA.SupplyEventFirstSummary: First Dispense 
 * Information</p>
 * 
 * <p><p>Provides summary information about the first dispense 
 * event on the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT060160CA.SupplyEventFirstSummary: First Dispense 
 * Information</p>
 * 
 * <p><p>Provides summary information about the first dispense 
 * event on the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 * 
 * <p>PORX_MT060340CA.SupplyEventFirstSummary: First Dispense 
 * Information</p>
 * 
 * <p><p>Provides summary information about the first dispense 
 * event on the prescription</p></p>
 * 
 * <p><p>Useful in understanding the status of a prescription 
 * and in planning for renewals.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT030040CA.SupplyEventFirstSummary","PORX_MT060160CA.SupplyEventFirstSummary","PORX_MT060190CA.SupplyEventFirstSummary","PORX_MT060340CA.SupplyEventFirstSummary"})
public class FirstDispenseInformation_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private PQ quantity = new PQImpl();
    private IVL<TS, Interval<Date>> firstDispensePickupDate = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>B:First Quantity Dispensed</p>
     * 
     * <p><p>Indicates the amount of medication first dispensed on 
     * the prescription.</p></p>
     * 
     * <p><p>Usually establishes trial quantities for a 
     * prescription.</p><p>Because the quantity should always be 
     * known if the first dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Usually establishes trial quantities for a 
     * prescription.</p><p>Because the quantity should always be 
     * known if the first dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p>First Quantity Dispensed</p>
     * 
     * <p><p>Indicates the amount of medication first dispensed on 
     * the prescription.</p></p>
     * 
     * <p><p>Usually establishes trial quantities for a 
     * prescription.</p><p>Because the quantity should always be 
     * known if the first dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p><p>Usually establishes trial quantities for a 
     * prescription.</p><p>Because the quantity should always be 
     * known if the first dispense is known, this attribute is 
     * mandatory.</p></p>
     * 
     * <p>First Quantity Dispense</p>
     * 
     * <p><p>Indicates the amount of medication first dispensed on 
     * the prescription.</p></p>
     * 
     * <p><p>Usually establishes trial quantities for a 
     * prescription.</p><p>If the first dispense information is 
     * known, the quantity must be known and therefore is 
     * mandatory</p></p>
     * 
     * <p><p>Usually establishes trial quantities for a 
     * prescription.</p><p>If the first dispense information is 
     * known, the quantity must be known and therefore is 
     * mandatory</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }
    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }


    /**
     * <p>FirstDispensePickupDate</p>
     * 
     * <p>A:First Dispense Pickup Date</p>
     * 
     * <p><p>Indicates when the first dispense against the 
     * prescription was picked up.</p></p>
     * 
     * <p><p>Useful in establishing start of therapy.</p></p>
     * 
     * <p>First Dispense Pickup Date</p>
     * 
     * <p><p>Indicates when the first dispense against the 
     * prescription was picked up.</p></p>
     * 
     * <p><p>Useful in establishing start of 
     * therapy.</p><p>Important information for compliance</p></p>
     * 
     * <p><p>Useful in establishing start of 
     * therapy.</p><p>Important information for compliance</p></p>
     * 
     * <p>First Dispense Pickup Date</p>
     * 
     * <p><p>Indicates when the first dispense against the 
     * prescription was picked up.</p></p>
     * 
     * <p><p>Useful in establishing start of 
     * therapy.</p><p>Important information for compliance.</p></p>
     * 
     * <p><p>Useful in establishing start of 
     * therapy.</p><p>Important information for compliance.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getFirstDispensePickupDate() {
        return this.firstDispensePickupDate.getValue();
    }
    public void setFirstDispensePickupDate(Interval<Date> firstDispensePickupDate) {
        this.firstDispensePickupDate.setValue(firstDispensePickupDate);
    }

}