/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Invoice Component</p>
 * 
 * <p>This allows for an Invoice Grouping to be composed of one 
 * or more invoice element groups and/or details. There must be 
 * one leaf detail.Sequence number used to sequence invoice 
 * elements in an Invoice Grouping and will not be included in 
 * Adjudication Results.</p>
 * 
 * <p>At most 5 levels of recursion, with '''n''' children at 
 * each level. Root level counts as level 1.</p>
 * 
 * <p>The number of children for each group cannot and should 
 * not be limited.</p>
 * 
 * <p>At most 5 levels of recursion, with '''n''' children at 
 * each level. Root level counts as level 1.</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementComponent"})
public class InvoiceComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private INT sequenceNumber = new INTImpl();
    private InvoiceElementChoiceBean invoiceElementChoice;

    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSequenceNumber() {
        return this.sequenceNumber.getValue();
    }
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber.setValue(sequenceNumber);
    }

    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoiceBean getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }
    public void setInvoiceElementChoice(InvoiceElementChoiceBean invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

}
