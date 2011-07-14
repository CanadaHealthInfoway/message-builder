/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>PreviousDispenseInformation</p>
 * 
 * <p>PORX_MT060060CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Summarizes 
 * the dispenses that have happened against the prescription to 
 * date.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps in 
 * understanding the status of the prescription and evaluating 
 * compliance.</p></p>
 * 
 * <p>PORX_MT060040CA.SupplyEventPastSummary: Previous Dispense 
 * Information</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Summarizes 
 * the dispenses that have happened against the prescription to 
 * date.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Helps in 
 * understanding the status of the prescription and evaluating 
 * compliance.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventPastSummary","PORX_MT060060CA.SupplyEventPastSummary"})
public class PreviousDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private INT numberOfFillsMadeAgainstRx = new INTImpl();
    private INT totalSuppliedAmount = new INTImpl();


    /**
     * <p>NumberOfFillsMadeAgainstRx</p>
     * 
     * <p>A:Number of Fills Made Against Rx</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the number of dispense events performed against the 
     * prescription to date, including trial, partial and complete 
     * fills.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful in 
     * tracking the progress of a prescription in prescription.</p></p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getNumberOfFillsMadeAgainstRx() {
        return this.numberOfFillsMadeAgainstRx.getValue();
    }
    public void setNumberOfFillsMadeAgainstRx(Integer numberOfFillsMadeAgainstRx) {
        this.numberOfFillsMadeAgainstRx.setValue(numberOfFillsMadeAgainstRx);
    }


    /**
     * <p>TotalSuppliedAmount</p>
     * 
     * <p>B:Total Supplied Amount</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the amount of the prescribed medication that has been 
     * dispensed to-date.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful for 
     * tracking the progress of a prescription.</p></p>
     * 
     * <p>B:Total Supplied Amount</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the number of the prescribed devices that has been dispensed 
     * to-date.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Useful for 
     * tracking the progress of a prescription</p></p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getTotalSuppliedAmount() {
        return this.totalSuppliedAmount.getValue();
    }
    public void setTotalSuppliedAmount(Integer totalSuppliedAmount) {
        this.totalSuppliedAmount.setValue(totalSuppliedAmount);
    }

}
