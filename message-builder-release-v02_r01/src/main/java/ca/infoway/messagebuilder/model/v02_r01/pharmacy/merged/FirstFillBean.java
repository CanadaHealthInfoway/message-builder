/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged;

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



@Hl7PartTypeMapping({"PORX_MT010120CA.InitialSupplyRequest","PORX_MT060160CA.InitialSupplyRequest","PORX_MT060340CA.InitialSupplyRequest"})
public class FirstFillBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private PQ firstFillQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> firstFillExpiryDate = new IVLImpl<TS, Interval<Date>>();
    private IVL<TS, Interval<Date>> firstFillDaysSupply = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>FirstFillQuantity</p>
     * 
     * <p>First Fill Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getFirstFillQuantity() {
        return this.firstFillQuantity.getValue();
    }
    public void setFirstFillQuantity(PhysicalQuantity firstFillQuantity) {
        this.firstFillQuantity.setValue(firstFillQuantity);
    }


    /**
     * <p>FirstFillExpiryDate</p>
     * 
     * <p>First Fill Expiry Date</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getFirstFillExpiryDate() {
        return this.firstFillExpiryDate.getValue();
    }
    public void setFirstFillExpiryDate(Interval<Date> firstFillExpiryDate) {
        this.firstFillExpiryDate.setValue(firstFillExpiryDate);
    }


    /**
     * <p>FirstFillDaysSupply</p>
     * 
     * <p>First Fill Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getFirstFillDaysSupply() {
        return this.firstFillDaysSupply.getValue();
    }
    public void setFirstFillDaysSupply(Interval<Date> firstFillDaysSupply) {
        this.firstFillDaysSupply.setValue(firstFillDaysSupply);
    }

}
