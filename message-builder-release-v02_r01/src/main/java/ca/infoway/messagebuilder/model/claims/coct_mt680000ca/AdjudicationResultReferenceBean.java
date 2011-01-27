/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicationResultReference"})
public class AdjudicationResultReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private InvoiceElementChoice invoiceElementChoice;


    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoice getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }
    public void setInvoiceElementChoice(InvoiceElementChoice invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

    public InvoiceElementIntentBean getInvoiceElementChoiceAsInvoiceElementIntent1() {
        return this.invoiceElementChoice instanceof InvoiceElementIntentBean ? (InvoiceElementIntentBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementIntent1() {
        return (this.invoiceElementChoice instanceof InvoiceElementIntentBean);
    }

    public InvoiceElementIntent2Bean getInvoiceElementChoiceAsInvoiceElementIntent2() {
        return this.invoiceElementChoice instanceof InvoiceElementIntent2Bean ? (InvoiceElementIntent2Bean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementIntent2() {
        return (this.invoiceElementChoice instanceof InvoiceElementIntent2Bean);
    }

}
