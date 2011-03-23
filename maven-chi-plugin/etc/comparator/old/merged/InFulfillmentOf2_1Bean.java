/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT030040CA.InFulfillmentOf2","PORX_MT060160CA.InFulfillmentOf2","PORX_MT060190CA.InFulfillmentOf2","PORX_MT060340CA.InFulfillmentOf2"})
public class InFulfillmentOf2_1Bean extends MessagePartBean {

    private INT numberOfFillsMadeAgainstRx = new INTImpl();
    private PQ totalSuppliedAmount = new PQImpl();

    @Hl7XmlMapping({"supplyEventPastSummary/repeatNumber"})
    public java.lang.Integer getNumberOfFillsMadeAgainstRx() {
        return this.numberOfFillsMadeAgainstRx.getValue();
    }
    public void setNumberOfFillsMadeAgainstRx(java.lang.Integer numberOfFillsMadeAgainstRx) {
        this.numberOfFillsMadeAgainstRx.setValue(numberOfFillsMadeAgainstRx);
    }

    @Hl7XmlMapping({"supplyEventPastSummary/quantity"})
    public PhysicalQuantity getTotalSuppliedAmount() {
        return this.totalSuppliedAmount.getValue();
    }
    public void setTotalSuppliedAmount(PhysicalQuantity totalSuppliedAmount) {
        this.totalSuppliedAmount.setValue(totalSuppliedAmount);
    }

}
