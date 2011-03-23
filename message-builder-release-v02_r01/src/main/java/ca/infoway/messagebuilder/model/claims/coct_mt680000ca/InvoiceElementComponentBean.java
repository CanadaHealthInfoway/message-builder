/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.InvoiceElementComponent"})
public class InvoiceElementComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private InvoiceElementChoiceBean invoiceElementChoice;

    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoiceBean getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }
    public void setInvoiceElementChoice(InvoiceElementChoiceBean invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

}
