/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"POME_MT010040CA.SubsequentDispense"})
public class SubsequentDispenseBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private IVL<TS, Interval<Date>> refillPeriod = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>Refill period</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The interval 
     * within which subsequent dispensing can be made against a 
     * prescription, after the first/initial fill.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DrugProduct.refillPeriod 
     * (second or only occurrence)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Certain 
     * prescribers have time limitations or certain drugs must be 
     * filled in a finite period of time.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getRefillPeriod() {
        return this.refillPeriod.getValue();
    }
    public void setRefillPeriod(Interval<Date> refillPeriod) {
        this.refillPeriod.setValue(refillPeriod);
    }

}
