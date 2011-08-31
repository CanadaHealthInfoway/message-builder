/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca;

import java.util.ArrayList;
import java.util.List;

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
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged.AllowableBean;



@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicatedInvoiceElementGroupBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20110831L;
    private AllowableBean reference1Allowable;
    private AdjudicationResultBean outcomeOfAdjudicationResult;
    private II adjudicationResultIdentifier = new IIImpl();
    private CV invoiceType = new CVImpl();
    private CS invoiceStatus = new CSImpl();
    private MO paidAmount = new MOImpl();
    private Author1Bean author;
    private ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup;
    private CoverageBean coverage;
    private List<ComponentBean> component = new ArrayList<ComponentBean>();


    @Hl7XmlMapping({"reference1/allowable"})
    public AllowableBean getReference1Allowable() {
        return this.reference1Allowable;
    }
    public void setReference1Allowable(AllowableBean reference1Allowable) {
        this.reference1Allowable = reference1Allowable;
    }


    @Hl7XmlMapping({"outcomeOf/adjudicationResult"})
    public AdjudicationResultBean getOutcomeOfAdjudicationResult() {
        return this.outcomeOfAdjudicationResult;
    }
    public void setOutcomeOfAdjudicationResult(AdjudicationResultBean outcomeOfAdjudicationResult) {
        this.outcomeOfAdjudicationResult = outcomeOfAdjudicationResult;
    }


    /**
     * <p>Adjudication Result Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicationResultIdentifier() {
        return this.adjudicationResultIdentifier.getValue();
    }
    public void setAdjudicationResultIdentifier(Identifier adjudicationResultIdentifier) {
        this.adjudicationResultIdentifier.setValue(adjudicationResultIdentifier);
    }


    /**
     * <p>Invoice Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getInvoiceType() {
        return (Code) this.invoiceType.getValue();
    }
    public void setInvoiceType(Code invoiceType) {
        this.invoiceType.setValue(invoiceType);
    }


    /**
     * <p>Invoice status</p>
     */
    @Hl7XmlMapping({"statusCode"})
    public ActStatus getInvoiceStatus() {
        return (ActStatus) this.invoiceStatus.getValue();
    }
    public void setInvoiceStatus(ActStatus invoiceStatus) {
        this.invoiceStatus.setValue(invoiceStatus);
    }


    /**
     * <p>Paid Amount</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getPaidAmount() {
        return this.paidAmount.getValue();
    }
    public void setPaidAmount(Money paidAmount) {
        this.paidAmount.setValue(paidAmount);
    }


    @Hl7XmlMapping({"author"})
    public Author1Bean getAuthor() {
        return this.author;
    }
    public void setAuthor(Author1Bean author) {
        this.author = author;
    }


    @Hl7XmlMapping({"reference/adjudicatedInvoiceElementGroup"})
    public ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AdjudicatedInvoiceElementGroupBean getReferenceAdjudicatedInvoiceElementGroup() {
        return this.referenceAdjudicatedInvoiceElementGroup;
    }
    public void setReferenceAdjudicatedInvoiceElementGroup(ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.AdjudicatedInvoiceElementGroupBean referenceAdjudicatedInvoiceElementGroup) {
        this.referenceAdjudicatedInvoiceElementGroup = referenceAdjudicatedInvoiceElementGroup;
    }


    @Hl7XmlMapping({"coverage"})
    public CoverageBean getCoverage() {
        return this.coverage;
    }
    public void setCoverage(CoverageBean coverage) {
        this.coverage = coverage;
    }


    @Hl7XmlMapping({"component"})
    public List<ComponentBean> getComponent() {
        return this.component;
    }

}
