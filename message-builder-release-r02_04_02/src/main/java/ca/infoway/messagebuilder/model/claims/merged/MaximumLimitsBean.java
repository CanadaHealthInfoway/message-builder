/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.merged;

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



@Hl7PartTypeMapping({"FICR_MT400003CA.MaximumLimits","FICR_MT400004CA.MaximumLimits","FICR_MT490102CA.MaximumLimits"})
public class MaximumLimitsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private IVL<TS, Interval<Date>> maximumDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private PQ maximumQuantitySupply = new PQImpl();
    private INT maximumFillsPermitted = new INTImpl();


    /**
     * <p>MaximumDaysSupply</p>
     * 
     * <p>Maximum Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getMaximumDaysSupply() {
        return this.maximumDaysSupply.getValue();
    }
    public void setMaximumDaysSupply(Interval<Date> maximumDaysSupply) {
        this.maximumDaysSupply.setValue(maximumDaysSupply);
    }


    /**
     * <p>MaximumQuantitySupply</p>
     * 
     * <p>Maximum Quantity Supply</p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getMaximumQuantitySupply() {
        return this.maximumQuantitySupply.getValue();
    }
    public void setMaximumQuantitySupply(PhysicalQuantity maximumQuantitySupply) {
        this.maximumQuantitySupply.setValue(maximumQuantitySupply);
    }


    /**
     * <p>MaximumFillsPermitted</p>
     * 
     * <p>Maximum Fills Permitted</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getMaximumFillsPermitted() {
        return this.maximumFillsPermitted.getValue();
    }
    public void setMaximumFillsPermitted(Integer maximumFillsPermitted) {
        this.maximumFillsPermitted.setValue(maximumFillsPermitted);
    }

}
