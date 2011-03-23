/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.qucr_mt830201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.model.merged.AdjudicatorBean;



/**
 * <p>Adjudication Result Identifier</p>
 * 
 * <p>Adjudication Result Identifier</p>
 * 
 * <p>May include data centre and sequence numbers</p>
 */
@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudicatedInvoiceElementGroup"})
public class AdjudicationResultIdentifierBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private II id = new IIImpl();
    private CV invoiceType = new CVImpl();
    private MO paidAmount = new MOImpl();
    private AdjudicatorBean author;
    private AdjudicatedResultOutcomeBean outcomeOf;

    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

    @Hl7XmlMapping({"code"})
    public Code getInvoiceType() {
        return (Code) this.invoiceType.getValue();
    }
    public void setInvoiceType(Code invoiceType) {
        this.invoiceType.setValue(invoiceType);
    }

    @Hl7XmlMapping({"netAmt"})
    public Money getPaidAmount() {
        return this.paidAmount.getValue();
    }
    public void setPaidAmount(Money paidAmount) {
        this.paidAmount.setValue(paidAmount);
    }

    @Hl7XmlMapping({"author"})
    public AdjudicatorBean getAuthor() {
        return this.author;
    }
    public void setAuthor(AdjudicatorBean author) {
        this.author = author;
    }

    @Hl7XmlMapping({"outcomeOf"})
    public AdjudicatedResultOutcomeBean getOutcomeOf() {
        return this.outcomeOf;
    }
    public void setOutcomeOf(AdjudicatedResultOutcomeBean outcomeOf) {
        this.outcomeOf = outcomeOf;
    }

}
