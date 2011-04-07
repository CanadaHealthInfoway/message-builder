/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT060040CA.SupplyEventFutureSummary","PORX_MT060060CA.SupplyEventFutureSummary"})
public class RemainingDispenseInformation_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private INT fillsRemaining = new INTImpl();
    private INT remainingTotalQuantity = new INTImpl();


    /**
     * <p>FillsRemaining</p>
     * 
     * <p>A:Fills Remaining</p>
     */
    @Hl7XmlMapping({"repeatNumber"})
    public Integer getFillsRemaining() {
        return this.fillsRemaining.getValue();
    }
    public void setFillsRemaining(Integer fillsRemaining) {
        this.fillsRemaining.setValue(fillsRemaining);
    }


    /**
     * <p>RemainingTotalQuantity</p>
     * 
     * <p>B:Remaining Total Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getRemainingTotalQuantity() {
        return this.remainingTotalQuantity.getValue();
    }
    public void setRemainingTotalQuantity(Integer remainingTotalQuantity) {
        this.remainingTotalQuantity.setValue(remainingTotalQuantity);
    }

}
