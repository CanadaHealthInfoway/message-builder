/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT510201CA.Reason2"})
public class Reason2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private AdjudicatedInvoiceElementGroupBean adjudicatedInvoiceElementGroup;

    @Hl7XmlMapping({"adjudicatedInvoiceElementGroup"})
    public AdjudicatedInvoiceElementGroupBean getAdjudicatedInvoiceElementGroup() {
        return this.adjudicatedInvoiceElementGroup;
    }
    public void setAdjudicatedInvoiceElementGroup(AdjudicatedInvoiceElementGroupBean adjudicatedInvoiceElementGroup) {
        this.adjudicatedInvoiceElementGroup = adjudicatedInvoiceElementGroup;
    }

}
