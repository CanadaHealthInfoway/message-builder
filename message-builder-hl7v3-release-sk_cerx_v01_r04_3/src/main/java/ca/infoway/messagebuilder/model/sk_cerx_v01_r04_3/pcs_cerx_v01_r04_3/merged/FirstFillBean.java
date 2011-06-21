/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

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
 * <p>FirstFill</p>
 * 
 * <p>PORX_MT060160CA.InitialSupplyRequest: First Fill</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Special 
 * instructions regarding the very first supply of medication 
 * to a patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows a 
 * different amount to be dispensed on an initial fill, either 
 * as a trial or to synchronize refill dates across multiple 
 * patient prescriptions</p></p>
 * 
 * <p>PORX_MT010120CA.InitialSupplyRequest: First Fill</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Special 
 * instructions regarding the very first supply of medication 
 * to a patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows a 
 * different amount to be dispensed on an initial fill, either 
 * as a trial or to synchronize refill dates across multiple 
 * patient prescriptions.</p></p>
 * 
 * <p>PORX_MT060340CA.InitialSupplyRequest: First Fill</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Special 
 * instructions regarding the very first supply of medication 
 * to a patient.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows a 
 * different amount to be dispensed on an initial fill, either 
 * as a trial or to synchronize refill dates across multiple 
 * patient prescriptions</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010120CA.InitialSupplyRequest","PORX_MT060160CA.InitialSupplyRequest","PORX_MT060340CA.InitialSupplyRequest"})
public class FirstFillBean extends MessagePartBean {

    private static final long serialVersionUID = 20110621L;
    private IVL<TS, Interval<Date>> firstFillExpiryDate = new IVLImpl<TS, Interval<Date>>();
    private PQ firstFillQuantity = new PQImpl();
    private IVL<TS, Interval<Date>> firstFillDaysSupply = new IVLImpl<TS, Interval<Date>>();


    /**
     * <p>FirstFillExpiryDate</p>
     * 
     * <p>First Fill Expiry Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date 
     * before which an initial dispense can be made against the 
     * prescription. If an initial fill has not been made against 
     * the prescription in this time-period, it may not be 
     * dispensed.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Some 
     * jurisdictions have distinct stale-date periods for the 
     * initial fill of a prescription from the overall dispensing 
     * of the prescription. E.g. 'The first fill must be made 
     * within 1 year, all fills must be complete within 1.5 years'. 
     * (This attribute would be used for the '1 year'.)</p></p>
     * 
     * <p>First Fill Expiry Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The last 
     * date before which an initial dispense can be made against 
     * the prescription. If an initial fill has not been made 
     * against the prescription in this time-period, then the 
     * prescription is no longer deemed valid and it may not be 
     * dispensed.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Some 
     * jurisdictions have distinct stale-date periods for the 
     * initial fill of a prescription from the overall dispensing 
     * of the prescription. E.g. &quot;The first fill must be made 
     * within 1 year, all fills must be complete within 1.5 
     * years&quot;. (This attribute would be used for the &quot;1 
     * year&quot;).</p></p>
     * 
     * <p>First Fill Expiry Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The date 
     * before which an initial dispense can be made against the 
     * prescription. If an initial fill has not been made against 
     * the prescription in this time-period, it may not be 
     * dispensed.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Some 
     * jurisdictions have distinct stale-date periods for the 
     * initial fill of a prescription from the overall dispensing 
     * of the prescription. E.g. &quot;The first fill must be made 
     * within 1 year, all fills must be complete within 1.5 
     * years&quot;. (This attribute would be used for the &quot;1 
     * year&quot;.)</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getFirstFillExpiryDate() {
        return this.firstFillExpiryDate.getValue();
    }
    public void setFirstFillExpiryDate(Interval<Date> firstFillExpiryDate) {
        this.firstFillExpiryDate.setValue(firstFillExpiryDate);
    }


    /**
     * <p>FirstFillQuantity</p>
     * 
     * <p>First Fill Quantity</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The quantity 
     * of medication to be dispensed the first time the 
     * prescription is dispensed against.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Prescription.coordinatingAmount</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows a 
     * limited quantity to be dispensed for a trial or for a 
     * synchronizing dose.</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getFirstFillQuantity() {
        return this.firstFillQuantity.getValue();
    }
    public void setFirstFillQuantity(PhysicalQuantity firstFillQuantity) {
        this.firstFillQuantity.setValue(firstFillQuantity);
    }


    /**
     * <p>FirstFillDaysSupply</p>
     * 
     * <p>First Fill Days Supply</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The number 
     * of days that the first fill is expected to last, if the 
     * patient is compliant with the dispensing of the first fill 
     * and with administration of the prescription.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used when 
     * the prescriber cannot or does not wish to calculate the 
     * quantity necessary to last for the trial or synchronization 
     * time.</p></p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getFirstFillDaysSupply() {
        return this.firstFillDaysSupply.getValue();
    }
    public void setFirstFillDaysSupply(Interval<Date> firstFillDaysSupply) {
        this.firstFillDaysSupply.setValue(firstFillDaysSupply);
    }

}
