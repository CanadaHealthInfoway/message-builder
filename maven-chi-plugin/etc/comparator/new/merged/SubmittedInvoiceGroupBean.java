/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import ca.infoway.messagebuilder.datatype.util.CollapsedToDataTypeListHelper;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.ficr_mt600201ca.AttachmentsBean;
import ca.infoway.messagebuilder.model.common.ficr_mt600201ca.BilledUnderContractBean;
import ca.infoway.messagebuilder.model.common.ficr_mt600201ca.CoveringInsuranceBean;
import ca.infoway.messagebuilder.model.common.ficr_mt600201ca.InvoiceComponentBean;
import ca.infoway.messagebuilder.model.common.ficr_mt610201ca.InvoiceElementChoiceBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"FICR_MT600201CA.InvoiceElementGroup","FICR_MT610201CA.InvoiceElementGroup","FICR_MT620000CA.InvoiceElementGroup","FICR_MT630000CA.InvoiceElementGroup","QUCR_MT830201CA.InvoiceElementGroup"})
@Hl7RootType
public class SubmittedInvoiceGroupBean extends MessagePartBean implements InvoiceElementChoiceBean, ca.infoway.messagebuilder.model.common.ficr_mt600201ca.InvoiceElementChoiceBean {

    private II invoiceGroupID = new IIImpl();
    private CV<Code> code = new CVImpl<Code>();
    private MO invoiceSubTotal = new MOImpl();
    private List<AdjudicatedInvoiceElementGroupBean> referenceAdjudicatedInvoiceElementGroup = new ArrayList<AdjudicatedInvoiceElementGroupBean>();
    private IVL<TS, Interval<Date>> timePeriodForInvoice = new IVLImpl<TS, Interval<Date>>();
    private BilledUnderContractBean inFulfillmentOf;
    private List<II> crossReferenceIdentifier = new ArrayList<II>();
    private List<CoveringInsuranceBean> coverage = new ArrayList<CoveringInsuranceBean>();
    private List<AttachmentsBean> pertinentInformation = new ArrayList<AttachmentsBean>();
    private List<InvoiceComponentBean> component = new ArrayList<InvoiceComponentBean>();
    private List<CV<Code>> invoiceOverrideCode = new ArrayList<CV<Code>>();

    @Hl7XmlMapping({"id"})
    public Identifier getInvoiceGroupID() {
        return this.invoiceGroupID.getValue();
    }
    public void setInvoiceGroupID(Identifier invoiceGroupID) {
        this.invoiceGroupID.setValue(invoiceGroupID);
    }

    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return this.code.getValue();
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

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getTimePeriodForInvoice() {
        return this.timePeriodForInvoice.getValue();
    }
    public void setTimePeriodForInvoice(Interval<Date> timePeriodForInvoice) {
        this.timePeriodForInvoice.setValue(timePeriodForInvoice);
    }

    @Hl7XmlMapping({"inFulfillmentOf"})
    public BilledUnderContractBean getInFulfillmentOf() {
        return this.inFulfillmentOf;
    }
    public void setInFulfillmentOf(BilledUnderContractBean inFulfillmentOf) {
        this.inFulfillmentOf = inFulfillmentOf;
    }

    @Hl7XmlMapping({"predecessor/invoiceElementCrossReference/id"})
    public List<Identifier> getCrossReferenceIdentifier() {
        return new CollapsedToDataTypeListHelper(IIImpl.class, this.crossReferenceIdentifier).rawList();
    }

    @Hl7XmlMapping({"coverage"})
    public List<CoveringInsuranceBean> getCoverage() {
        return this.coverage;
    }

    @Hl7XmlMapping({"pertinentInformation"})
    public List<AttachmentsBean> getPertinentInformation() {
        return this.pertinentInformation;
    }

    @Hl7XmlMapping({"component"})
    public List<InvoiceComponentBean> getComponent() {
        return this.component;
    }

    @Hl7XmlMapping({"triggerFor/invoiceElementOverride/code"})
    public List<Code> getInvoiceOverrideCode() {
        return new CollapsedToDataTypeListHelper(CVImpl.class, this.invoiceOverrideCode).rawList();
    }

}
