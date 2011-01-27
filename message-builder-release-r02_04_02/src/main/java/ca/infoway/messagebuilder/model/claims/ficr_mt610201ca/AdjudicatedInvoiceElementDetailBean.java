/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.REAL;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.REALImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.claims.merged.AllowableBean;
import ca.infoway.messagebuilder.model.merged.AdjudicatedResultOutcomeBean;
import java.math.BigDecimal;



@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceElementDetail"})
public class AdjudicatedInvoiceElementDetailBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20110127L;
    private CV adjudicatedProductServiceCode = new CVImpl();
    private RTO<Money, PhysicalQuantity> adjudicatedUnitPrice = new RTOImpl<Money, PhysicalQuantity>();
    private PQ adjudicatedUnitQuantity = new PQImpl();
    private II adjudicatedInvoiceElementIdentifier = new IIImpl();
    private AllowableBean reference1Allowable;
    private MO adjudicatedInvoiceLineAmount = new MOImpl();
    private REAL multiplierEG007 = new REALImpl();
    private AdjudicatedResultOutcomeBean outcomeOf;


    /**
     * <p>Adjudicated Product/Service Code</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getAdjudicatedProductServiceCode() {
        return (Code) this.adjudicatedProductServiceCode.getValue();
    }
    public void setAdjudicatedProductServiceCode(Code adjudicatedProductServiceCode) {
        this.adjudicatedProductServiceCode.setValue(adjudicatedProductServiceCode);
    }


    /**
     * <p>Adjudicated Unit Price</p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getAdjudicatedUnitPrice() {
        return this.adjudicatedUnitPrice.getValue();
    }
    public void setAdjudicatedUnitPrice(Ratio<Money, PhysicalQuantity> adjudicatedUnitPrice) {
        this.adjudicatedUnitPrice.setValue(adjudicatedUnitPrice);
    }


    /**
     * <p>Adjudicated Unit Quantity</p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getAdjudicatedUnitQuantity() {
        return this.adjudicatedUnitQuantity.getValue();
    }
    public void setAdjudicatedUnitQuantity(PhysicalQuantity adjudicatedUnitQuantity) {
        this.adjudicatedUnitQuantity.setValue(adjudicatedUnitQuantity);
    }


    /**
     * <p>Adjudicated Invoice Element Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicatedInvoiceElementIdentifier() {
        return this.adjudicatedInvoiceElementIdentifier.getValue();
    }
    public void setAdjudicatedInvoiceElementIdentifier(Identifier adjudicatedInvoiceElementIdentifier) {
        this.adjudicatedInvoiceElementIdentifier.setValue(adjudicatedInvoiceElementIdentifier);
    }


    @Hl7XmlMapping({"reference1/allowable"})
    public AllowableBean getReference1Allowable() {
        return this.reference1Allowable;
    }
    public void setReference1Allowable(AllowableBean reference1Allowable) {
        this.reference1Allowable = reference1Allowable;
    }


    /**
     * <p>Adjudicated Invoice Line Amount</p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getAdjudicatedInvoiceLineAmount() {
        return this.adjudicatedInvoiceLineAmount.getValue();
    }
    public void setAdjudicatedInvoiceLineAmount(Money adjudicatedInvoiceLineAmount) {
        this.adjudicatedInvoiceLineAmount.setValue(adjudicatedInvoiceLineAmount);
    }


    /**
     * <p>Multiplier, e.g. 0.07</p>
     */
    @Hl7XmlMapping({"factorNumber"})
    public BigDecimal getMultiplierEG007() {
        return this.multiplierEG007.getValue();
    }


    @Hl7XmlMapping({"outcomeOf"})
    public AdjudicatedResultOutcomeBean getOutcomeOf() {
        return this.outcomeOf;
    }
    public void setOutcomeOf(AdjudicatedResultOutcomeBean outcomeOf) {
        this.outcomeOf = outcomeOf;
    }

}
