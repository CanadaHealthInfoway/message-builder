/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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



@Hl7PartTypeMapping({"PORX_MT060040CA.InFulfillmentOf4","PORX_MT060060CA.InFulfillmentOf5"})
public class InFulfillmentOf4_2Bean extends MessagePartBean {

    private IVL<TS, Interval<Date>> firstDispensePickupDate = new IVLImpl<TS, Interval<Date>>();
    private INT firstQuantityDispensed = new INTImpl();

    @Hl7XmlMapping({"supplyEventFirstSummary/effectiveTime"})
    public Interval<Date> getFirstDispensePickupDate() {
        return this.firstDispensePickupDate.getValue();
    }
    public void setFirstDispensePickupDate(Interval<Date> firstDispensePickupDate) {
        this.firstDispensePickupDate.setValue(firstDispensePickupDate);
    }

    @Hl7XmlMapping({"supplyEventFirstSummary/quantity"})
    public java.lang.Integer getFirstQuantityDispensed() {
        return this.firstQuantityDispensed.getValue();
    }
    public void setFirstQuantityDispensed(java.lang.Integer firstQuantityDispensed) {
        this.firstQuantityDispensed.setValue(firstQuantityDispensed);
    }

}
