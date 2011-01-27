/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.claims.coct_mt280001ca.A_BillableActChoice;
import ca.infoway.messagebuilder.model.claims.coct_mt280001ca.CrossReferenceBean;
import ca.infoway.messagebuilder.model.claims.coct_mt290000ca.BillableClinicalServiceBean;
import ca.infoway.messagebuilder.model.claims.coct_mt300000ca.PharmacyDispenseBean;
import ca.infoway.messagebuilder.model.claims.coct_mt490000ca.BillableClinicalProductBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt600201ca.AttachmentsBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt600201ca.CrossReferenceIdentifierBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt600201ca.InvoiceComponentBean;
import ca.infoway.messagebuilder.model.claims.ficr_mt600201ca.InvoiceOverrideDetailsBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementGroup","FICR_MT620000CA.InvoiceElementGroup","QUCR_MT830201CA.InvoiceElementGroup"})
@Hl7RootType
public class InvoiceTypeBean extends MessagePartBean implements ca.infoway.messagebuilder.model.claims.ficr_mt600201ca.InvoiceElementChoice {

    private static final long serialVersionUID = 20110127L;
    private II id = new IIImpl();
    private MO invoiceSubTotal = new MOImpl();
    private CV invoiceType = new CVImpl();
    private List<A_BillableActChoice> reasonOfBillableActChoice = new ArrayList<A_BillableActChoice>();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private BusinessArrangementBean inFulfillmentOfFinancialContract;
    private List<InvoiceOverrideDetailsBean> triggerForInvoiceElementOverride = new ArrayList<InvoiceOverrideDetailsBean>();
    private IVL<TS, Interval<Date>> timePeriodForInvoice = new IVLImpl<TS, Interval<Date>>();
    private List<InvoiceComponentBean> component = new ArrayList<InvoiceComponentBean>();
    private List<PolicyIdentifierBean> coveragePolicyOrAccount = new ArrayList<PolicyIdentifierBean>();
    private List<CrossReferenceIdentifierBean> predecessorInvoiceElementCrossReference = new ArrayList<CrossReferenceIdentifierBean>();
    private List<AttachmentsBean> pertinentInformation = new ArrayList<AttachmentsBean>();


    /**
     * <p>Invoice Grouping Identifiers</p>
     * 
     * <p>Invoice Grouping Identifier(s</p>
     * 
     * <p>Invoice Group ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>InvoiceSubTotal</p>
     * 
     * <p>Invoice Sub-total</p>
     * 
     * <p>Invoice sub-total</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getInvoiceSubTotal() {
        return this.invoiceSubTotal.getValue();
    }
    public void setInvoiceSubTotal(Money invoiceSubTotal) {
        this.invoiceSubTotal.setValue(invoiceSubTotal);
    }


    /**
     * <p>InvoiceType</p>
     * 
     * <p>Invoice Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getInvoiceType() {
        return (Code) this.invoiceType.getValue();
    }
    public void setInvoiceType(Code invoiceType) {
        this.invoiceType.setValue(invoiceType);
    }


    @Hl7XmlMapping({"reasonOf/billableActChoice"})
    public List<A_BillableActChoice> getReasonOfBillableActChoice() {
        return this.reasonOfBillableActChoice;
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public List<AdjudicatedInvoiceElementGroupBean> getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }


    @Hl7XmlMapping({"inFulfillmentOf/financialContract"})
    public BusinessArrangementBean getInFulfillmentOfFinancialContract() {
        return this.inFulfillmentOfFinancialContract;
    }
    public void setInFulfillmentOfFinancialContract(BusinessArrangementBean inFulfillmentOfFinancialContract) {
        this.inFulfillmentOfFinancialContract = inFulfillmentOfFinancialContract;
    }


    @Hl7XmlMapping({"triggerFor/invoiceElementOverride"})
    public List<InvoiceOverrideDetailsBean> getTriggerForInvoiceElementOverride() {
        return this.triggerForInvoiceElementOverride;
    }


    /**
     * <p>TimePeriodForInvoice</p>
     * 
     * <p>Time period for invoice</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getTimePeriodForInvoice() {
        return this.timePeriodForInvoice.getValue();
    }
    public void setTimePeriodForInvoice(Interval<Date> timePeriodForInvoice) {
        this.timePeriodForInvoice.setValue(timePeriodForInvoice);
    }


    @Hl7XmlMapping({"component"})
    public List<InvoiceComponentBean> getComponent() {
        return this.component;
    }


    @Hl7XmlMapping({"coverage/policyOrAccount"})
    public List<PolicyIdentifierBean> getCoveragePolicyOrAccount() {
        return this.coveragePolicyOrAccount;
    }


    @Hl7XmlMapping({"predecessor/invoiceElementCrossReference"})
    public List<CrossReferenceIdentifierBean> getPredecessorInvoiceElementCrossReference() {
        return this.predecessorInvoiceElementCrossReference;
    }


    @Hl7XmlMapping({"pertinentInformation"})
    public List<AttachmentsBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

}
