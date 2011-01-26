/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt500201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.claims.merged.InvoiceElementDetailBean;
import ca.infoway.messagebuilder.model.claims.merged.InvoiceElementGroupBean;



/**
 * <p><p>At most 5 levels of recursion, with n children at each 
 * level. Root level counts as level 1.</p></p>
 * 
 * <p><p>This allows for an Invoice Grouping to be composed of 
 * one or more invoice element groups and/or details. There 
 * must be one leaf detail.</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.InvoiceElementComponent"})
public class InvoiceElementComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private INT invoiceElementSequenceNumber = new INTImpl();
    private InvoiceElementChoice invoiceElementChoice;


    /**
     * <p>Invoice Element Sequence Number</p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getInvoiceElementSequenceNumber() {
        return this.invoiceElementSequenceNumber.getValue();
    }
    public void setInvoiceElementSequenceNumber(Integer invoiceElementSequenceNumber) {
        this.invoiceElementSequenceNumber.setValue(invoiceElementSequenceNumber);
    }


    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoice getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }
    public void setInvoiceElementChoice(InvoiceElementChoice invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

    public InvoiceElementGroupBean getInvoiceElementChoiceAsInvoiceElementGroup() {
        return this.invoiceElementChoice instanceof InvoiceElementGroupBean ? (InvoiceElementGroupBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementGroup() {
        return (this.invoiceElementChoice instanceof InvoiceElementGroupBean);
    }

    public InvoiceElementDetailBean getInvoiceElementChoiceAsInvoiceElementDetail() {
        return this.invoiceElementChoice instanceof InvoiceElementDetailBean ? (InvoiceElementDetailBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementDetail() {
        return (this.invoiceElementChoice instanceof InvoiceElementDetailBean);
    }

}
