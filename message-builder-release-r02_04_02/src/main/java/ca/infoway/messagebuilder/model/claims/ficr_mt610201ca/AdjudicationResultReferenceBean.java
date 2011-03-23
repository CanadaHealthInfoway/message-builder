/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.InvoiceTypeBean;



/**
 * <p>Multiple references to submitted invoice elements 
 * provides support for code substitution where the number of 
 * submitted fee items is consolidated on the adjudication 
 * results (e.g. 3 items to 1)</p>
 * 
 * <p>Each submitted invoice element must have 1 
 * AdjudicationResults instance unless its parent is 
 * adjudicated as submitted</p>
 * 
 * <p>Association mandatory for Root 
 * AdjudicatedInvoiceElementGroup and all associations that 
 * point to submitted invoice elements.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicationResultReference"})
public class AdjudicationResultReferenceBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private InvoiceElementChoiceBean invoiceElementChoice;

    @Hl7XmlMapping({"invoiceElementChoice"})
    public InvoiceElementChoiceBean getInvoiceElementChoice() {
        return this.invoiceElementChoice;
    }
    public void setInvoiceElementChoice(InvoiceElementChoiceBean invoiceElementChoice) {
        this.invoiceElementChoice = invoiceElementChoice;
    }

    public InvoiceTypeBean getInvoiceElementChoiceAsInvoiceElementGroup() {
        return this.invoiceElementChoice instanceof InvoiceTypeBean ? (InvoiceTypeBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementGroup() {
        return (this.invoiceElementChoice instanceof InvoiceTypeBean);
    }

    public InvoiceElementDetailBean getInvoiceElementChoiceAsInvoiceElementDetail() {
        return this.invoiceElementChoice instanceof InvoiceElementDetailBean ? (InvoiceElementDetailBean) this.invoiceElementChoice : null;
    }
    public boolean hasInvoiceElementChoiceAsInvoiceElementDetail() {
        return (this.invoiceElementChoice instanceof InvoiceElementDetailBean);
    }

}
