/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt680000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.RTO;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.RTOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.Ratio;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.AdjudicatedResultOutcomeBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceElementDetail"})
public class InvoiceElementDetailBean extends MessagePartBean implements AdjudicatedInvoiceElementChoice {

    private static final long serialVersionUID = 20110318L;
    private CV productServiceCode = new CVImpl();
    private MO invoiceElementAmountBilled = new MOImpl();
    private INT multiplierForTaxes = new INTImpl();
    private RTO<Money, PhysicalQuantity> pricePerUnit = new RTOImpl<Money, PhysicalQuantity>();
    private PQ quantityPerUnit = new PQImpl();
    private AdjudicatedResultOutcomeBean outcomeOf;


    /**
     * <p>Product/service Code</p>
     * 
     * <p><p>Domain for AdjudicatedInvoiceElementDetail.code is 
     * GenericBillableItemModifier</p></p>
     * 
     * <p><p>Product/Service Code e.g. Office Visit ,Taxes, Markup, 
     * Dispense, including Product/Service Code Modifier e.g. 
     * northern isolation, off hours specialty, on call</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getProductServiceCode() {
        return (Code) this.productServiceCode.getValue();
    }
    public void setProductServiceCode(Code productServiceCode) {
        this.productServiceCode.setValue(productServiceCode);
    }


    /**
     * <p>Invoice Element Amount billed</p>
     * 
     * <p><p>= unit_qty * unit_price_amt * factor_nbr * points_nbr. 
     * E.g. $150 CAD</p></p>
     */
    @Hl7XmlMapping({"netAmt"})
    public Money getInvoiceElementAmountBilled() {
        return this.invoiceElementAmountBilled.getValue();
    }
    public void setInvoiceElementAmountBilled(Money invoiceElementAmountBilled) {
        this.invoiceElementAmountBilled.setValue(invoiceElementAmountBilled);
    }


    /**
     * <p>Multiplier for Taxes.</p>
     * 
     * <p><p>multiplier, can be used for tax percentages such as 
     * 0.07</p></p>
     */
    @Hl7XmlMapping({"factorNumber"})
    public Integer getMultiplierForTaxes() {
        return this.multiplierForTaxes.getValue();
    }
    public void setMultiplierForTaxes(Integer multiplierForTaxes) {
        this.multiplierForTaxes.setValue(multiplierForTaxes);
    }


    /**
     * <p>Price Per Unit</p>
     * 
     * <p><p>e.g. $50 CAD/ 1 {box}</p></p>
     */
    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getPricePerUnit() {
        return this.pricePerUnit.getValue();
    }
    public void setPricePerUnit(Ratio<Money, PhysicalQuantity> pricePerUnit) {
        this.pricePerUnit.setValue(pricePerUnit);
    }


    /**
     * <p>Quantity per Unit</p>
     * 
     * <p><p>e.g. 3 {boxes}</p></p>
     */
    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getQuantityPerUnit() {
        return this.quantityPerUnit.getValue();
    }
    public void setQuantityPerUnit(PhysicalQuantity quantityPerUnit) {
        this.quantityPerUnit.setValue(quantityPerUnit);
    }


    @Hl7XmlMapping({"outcomeOf"})
    public AdjudicatedResultOutcomeBean getOutcomeOf() {
        return this.outcomeOf;
    }
    public void setOutcomeOf(AdjudicatedResultOutcomeBean outcomeOf) {
        this.outcomeOf = outcomeOf;
    }

}