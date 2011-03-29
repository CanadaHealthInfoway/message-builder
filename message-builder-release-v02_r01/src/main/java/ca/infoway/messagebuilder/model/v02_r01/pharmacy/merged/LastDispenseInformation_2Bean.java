/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventLastSummary","PORX_MT060060CA.SupplyEventLastSummary"})
public class LastDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private INT lastQuantityDispensed = new INTImpl();
    private IVL<TS, Interval<Date>> lastDispensePickupDate = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>LastQuantityDispensed</p>
     * 
     * <p>B:Last Quantity Dispensed</p>
     * 
     * <p>Last Quantity Dispensed</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getLastQuantityDispensed() {
        return this.lastQuantityDispensed.getValue();
    }
    public void setLastQuantityDispensed(Integer lastQuantityDispensed) {
        this.lastQuantityDispensed.setValue(lastQuantityDispensed);
    }


    /**
     * <p>LastDispensePickupDate</p>
     * 
     * <p>Last Dispense Pickup Date</p>
     * 
     * <p>A:Last Dispense Pickup Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getLastDispensePickupDate() {
        return this.lastDispensePickupDate.getValue();
    }
    public void setLastDispensePickupDate(Interval<Date> lastDispensePickupDate) {
        this.lastDispensePickupDate.setValue(lastDispensePickupDate);
    }

}