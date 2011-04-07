/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT010120CA.SubsequentSupplyRequest","PORX_MT060160CA.SubsequentSupplyRequest","PORX_MT060340CA.SubsequentSupplyRequest"})
public class SubsequentSupplyRequestBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private IVL<TS, Interval<Date>> dispenseInterval = new IVLImpl<TS, Interval<Date>>();
    private INT numberOfFills = new INTImpl();
    private PQ fillQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> daysSupply = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>DispenseInterval</p>
     * 
     * <p>F:Dispense Interval</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispenseInterval() {
        return this.dispenseInterval.getValue();
    }
    public void setDispenseInterval(Interval<Date> dispenseInterval) {
        this.dispenseInterval.setValue(dispenseInterval);
    }


    /**
     * <p>NumberOfFills</p>
     * 
     * <p>G:Number of Fills</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getNumberOfFills() {
        return this.numberOfFills.getValue();
    }
    public void setNumberOfFills(Integer numberOfFills) {
        this.numberOfFills.setValue(numberOfFills);
    }


    /**
     * <p>FillQuantity</p>
     * 
     * <p>D:Fill Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getFillQuantity() {
        return this.fillQuantity.getValue();
    }
    public void setFillQuantity(PhysicalQuantity fillQuantity) {
        this.fillQuantity.setValue(fillQuantity);
    }


    /**
     * <p>DaysSupply</p>
     * 
     * <p>E:Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getDaysSupply() {
        return this.daysSupply.getValue();
    }
    public void setDaysSupply(Interval<Date> daysSupply) {
        this.daysSupply.setValue(daysSupply);
    }

}
