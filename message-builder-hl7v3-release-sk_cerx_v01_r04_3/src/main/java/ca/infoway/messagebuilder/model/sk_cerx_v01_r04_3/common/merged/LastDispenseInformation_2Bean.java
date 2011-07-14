/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>LastDispenseInformation</p>
 * 
 * <p>PORX_MT060060CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * summary information about the most recent dispense event 
 * performed against the prescription</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * understanding the status of a prescription and in planning 
 * for renewals.</p></p>
 * 
 * <p>PORX_MT060040CA.SupplyEventLastSummary: Last Dispense 
 * Information</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
 * summary information about the most recent dispense event 
 * performed against the prescription</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
 * understanding the status of a prescription and in planning 
 * for renewals.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventLastSummary","PORX_MT060060CA.SupplyEventLastSummary"})
public class LastDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private IVL<TS, Interval<Date>> lastDispensePickupDate = new IVLImpl<TS, Interval<Date>>();
    private INT lastQuantityDispensed = new INTImpl();


    /**
     * <p>LastDispensePickupDate</p>
     * 
     * <p>Last Dispense Pickup Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the most recent date on which a dispense on the prescription 
     * was picked up.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
     * determining when a prescription will next need to be 
     * dispensed. Also provides an indication of compliance.</p></p>
     * 
     * <p>A:Last Dispense Pickup Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the most recent date on which a dispense on the prescription 
     * was picked up.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
     * determining when a prescription will next need to be 
     * dispensed. Also provides an indication of compliance.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getLastDispensePickupDate() {
        return this.lastDispensePickupDate.getValue();
    }
    public void setLastDispensePickupDate(Interval<Date> lastDispensePickupDate) {
        this.lastDispensePickupDate.setValue(lastDispensePickupDate);
    }


    /**
     * <p>LastQuantityDispensed</p>
     * 
     * <p>B:Last Quantity Dispensed</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the most recent quantity of the drug that was picked up for 
     * the prescription.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
     * determining number of devices that a patient should have 
     * on-hand. Also provides an indication of compliance.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because the 
     * quantity should always be known if the last dispense is 
     * known, this attribute is mandatory.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
     * determining number of devices that a patient should have 
     * on-hand. Also provides an indication of compliance.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Because the 
     * quantity should always be known if the last dispense is 
     * known, this attribute is mandatory.</p></p>
     * 
     * <p>Last Quantity Dispensed</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the most recent quantity of the drug that was picked up for 
     * the prescription.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
     * determining number of devices that a patient should have 
     * on-hand. Also provides an indication of compliance.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">If the last 
     * dispense is known, then the quantity must be known, thus the 
     * element is mandatory.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
     * determining number of devices that a patient should have 
     * on-hand. Also provides an indication of compliance.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">If the last 
     * dispense is known, then the quantity must be known, thus the 
     * element is mandatory.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getLastQuantityDispensed() {
        return this.lastQuantityDispensed.getValue();
    }
    public void setLastQuantityDispensed(Integer lastQuantityDispensed) {
        this.lastQuantityDispensed.setValue(lastQuantityDispensed);
    }

}
