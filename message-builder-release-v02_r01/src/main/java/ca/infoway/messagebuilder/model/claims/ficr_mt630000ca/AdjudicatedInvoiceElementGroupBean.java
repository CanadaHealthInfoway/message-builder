/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt630000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.PaymentIntentBean;
import ca.infoway.messagebuilder.model.merged.RunningTotalsBean;



@Hl7PartTypeMapping({"FICR_MT630000CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicatedInvoiceElementGroupBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private II adjudicationResultId = new IIImpl();
    private CV invoiceType = new CVImpl();
    private CS statusCode = new CSImpl();
    private MO paidAmount = new MOImpl();
    private PaymentIntentBean reasonPaymentIntent;
    private AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup;
    private RunningTotalsBean referencedByAdjudResultsGroup;

    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicationResultId() {
        return this.adjudicationResultId.getValue();
    }
    public void setAdjudicationResultId(Identifier adjudicationResultId) {
        this.adjudicationResultId.setValue(adjudicationResultId);
    }

    @Hl7XmlMapping({"code"})
    public Code getInvoiceType() {
        return (Code) this.invoiceType.getValue();
    }
    public void setInvoiceType(Code invoiceType) {
        this.invoiceType.setValue(invoiceType);
    }

    @Hl7XmlMapping({"statusCode"})
    public Code getStatusCode() {
        return (Code) this.statusCode.getValue();
    }
    public void setStatusCode(Code statusCode) {
        this.statusCode.setValue(statusCode);
    }

    @Hl7XmlMapping({"netAmt"})
    public Money getPaidAmount() {
        return this.paidAmount.getValue();
    }
    public void setPaidAmount(Money paidAmount) {
        this.paidAmount.setValue(paidAmount);
    }

    @Hl7XmlMapping({"reason/paymentIntent"})
    public PaymentIntentBean getReasonPaymentIntent() {
        return this.reasonPaymentIntent;
    }
    public void setReasonPaymentIntent(PaymentIntentBean reasonPaymentIntent) {
        this.reasonPaymentIntent = reasonPaymentIntent;
    }

    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public AdjudicatedInvoiceElementGroupBean getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }
    public void setReferenceAdjudicatedInvoiceElementGroup(AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup) {
        this.referenceAdjudicatedInvoiceElementGroup = referenceAdjudicatedInvoiceElementGroup;
    }

    @Hl7XmlMapping({"referencedBy/adjudResultsGroup"})
    public RunningTotalsBean getReferencedByAdjudResultsGroup() {
        return this.referencedByAdjudResultsGroup;
    }
    public void setReferencedByAdjudResultsGroup(RunningTotalsBean referencedByAdjudResultsGroup) {
        this.referencedByAdjudResultsGroup = referencedByAdjudResultsGroup;
    }

}
