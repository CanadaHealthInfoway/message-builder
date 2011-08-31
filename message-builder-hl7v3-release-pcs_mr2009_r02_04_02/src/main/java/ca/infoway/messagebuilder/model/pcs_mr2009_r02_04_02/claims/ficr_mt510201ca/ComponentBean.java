/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT510201CA.Component"})
public class ComponentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private AdjudicatedInvoiceElementChoice adjudicatedInvoiceElementChoice;


    @Hl7XmlMapping({"adjudicatedInvoiceElementChoice"})
    public AdjudicatedInvoiceElementChoice getAdjudicatedInvoiceElementChoice() {
        return this.adjudicatedInvoiceElementChoice;
    }
    public void setAdjudicatedInvoiceElementChoice(AdjudicatedInvoiceElementChoice adjudicatedInvoiceElementChoice) {
        this.adjudicatedInvoiceElementChoice = adjudicatedInvoiceElementChoice;
    }

    public FinancialTransactionIntentBean getAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementGroup() {
        return this.adjudicatedInvoiceElementChoice instanceof FinancialTransactionIntentBean ? (FinancialTransactionIntentBean) this.adjudicatedInvoiceElementChoice : null;
    }
    public boolean hasAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementGroup() {
        return (this.adjudicatedInvoiceElementChoice instanceof FinancialTransactionIntentBean);
    }

    public AdjudicatedInvoiceElementDetailBean getAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementDetail() {
        return this.adjudicatedInvoiceElementChoice instanceof AdjudicatedInvoiceElementDetailBean ? (AdjudicatedInvoiceElementDetailBean) this.adjudicatedInvoiceElementChoice : null;
    }
    public boolean hasAdjudicatedInvoiceElementChoiceAsAdjudicatedInvoiceElementDetail() {
        return (this.adjudicatedInvoiceElementChoice instanceof AdjudicatedInvoiceElementDetailBean);
    }

}
