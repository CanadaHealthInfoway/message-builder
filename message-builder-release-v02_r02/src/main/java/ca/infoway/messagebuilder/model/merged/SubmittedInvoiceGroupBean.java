/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt610201ca.InvoiceElementChoiceBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt630000ca.AdjudicatedInvoiceElementGroupBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT610201CA.InvoiceElementGroup","FICR_MT620000CA.InvoiceElementGroup","FICR_MT630000CA.InvoiceElementGroup"})
@Hl7RootType
public class SubmittedInvoiceGroupBean extends MessagePartBean implements InvoiceElementChoiceBean {

    private static final long serialVersionUID = 20100614L;
    private II invoiceGroupingIdentifiers = new IIImpl();
    private CV code = new CVImpl();
    private MO invoiceSubTotal = new MOImpl();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();

    @Hl7XmlMapping({"id"})
    public Identifier getInvoiceGroupingIdentifiers() {
        return this.invoiceGroupingIdentifiers.getValue();
    }
    public void setInvoiceGroupingIdentifiers(Identifier invoiceGroupingIdentifiers) {
        this.invoiceGroupingIdentifiers.setValue(invoiceGroupingIdentifiers);
    }

    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping({"netAmt"})
    public Money getInvoiceSubTotal() {
        return this.invoiceSubTotal.getValue();
    }
    public void setInvoiceSubTotal(Money invoiceSubTotal) {
        this.invoiceSubTotal.setValue(invoiceSubTotal);
    }

    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }

}
