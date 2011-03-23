/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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



@Hl7PartTypeMapping({"PORX_MT030040CA.SupplyEventFirstSummary","PORX_MT060160CA.SupplyEventFirstSummary","PORX_MT060190CA.SupplyEventFirstSummary","PORX_MT060340CA.SupplyEventFirstSummary"})
public class SupplyEventFirstSummary_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private IVL<TS, Interval<Date>> firstDispensePickupDate = new IVLImpl<TS, Interval<Date>>();
    private PQ firstQuantityDispense = new PQImpl();

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getFirstDispensePickupDate() {
        return this.firstDispensePickupDate.getValue();
    }
    public void setFirstDispensePickupDate(Interval<Date> firstDispensePickupDate) {
        this.firstDispensePickupDate.setValue(firstDispensePickupDate);
    }

    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getFirstQuantityDispense() {
        return this.firstQuantityDispense.getValue();
    }
    public void setFirstQuantityDispense(PhysicalQuantity firstQuantityDispense) {
        this.firstQuantityDispense.setValue(firstQuantityDispense);
    }

}
