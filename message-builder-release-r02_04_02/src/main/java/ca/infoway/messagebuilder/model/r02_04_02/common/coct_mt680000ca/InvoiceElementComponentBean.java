/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.InvoiceElementChoice;



@Hl7PartTypeMapping({"COCT_MT680000CA.InvoiceElementComponent"})
public class InvoiceElementComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private InvoiceElementChoice invoiceElementChoice;


    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoice getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }
    public void setInvoiceElementChoice(InvoiceElementChoice invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

    public InventElementChoiceBean getInvoiceElementChoiceAsInvoiceElementIntent1() {
        return this.invoiceElementChoice instanceof InventElementChoiceBean ? (InventElementChoiceBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementIntent1() {
        return (this.invoiceElementChoice instanceof InventElementChoiceBean);
    }

    public InvoiceElementIntent2Bean getInvoiceElementChoiceAsInvoiceElementIntent2() {
        return this.invoiceElementChoice instanceof InvoiceElementIntent2Bean ? (InvoiceElementIntent2Bean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementIntent2() {
        return (this.invoiceElementChoice instanceof InvoiceElementIntent2Bean);
    }

}
