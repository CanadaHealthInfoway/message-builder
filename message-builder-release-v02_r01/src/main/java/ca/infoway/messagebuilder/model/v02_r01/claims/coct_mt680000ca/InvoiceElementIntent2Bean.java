/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt680000ca;

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



@Hl7PartTypeMapping({"COCT_MT680000CA.InvoiceElementIntent2"})
public class InvoiceElementIntent2Bean extends MessagePartBean implements InvoiceElementChoice {

    private static final long serialVersionUID = 20110318L;
    private MO netAmt = new MOImpl();
    private INT factorNumber = new INTImpl();
    private CV code = new CVImpl();
    private PQ unitQuantity = new PQImpl();
    private RTO<Money, PhysicalQuantity> unitPriceAmt = new RTOImpl<Money, PhysicalQuantity>();


    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }


    @Hl7XmlMapping({"factorNumber"})
    public Integer getFactorNumber() {
        return this.factorNumber.getValue();
    }
    public void setFactorNumber(Integer factorNumber) {
        this.factorNumber.setValue(factorNumber);
    }


    @Hl7XmlMapping({"code"})
    public Code getCode() {
        return (Code) this.code.getValue();
    }
    public void setCode(Code code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"unitQuantity"})
    public PhysicalQuantity getUnitQuantity() {
        return this.unitQuantity.getValue();
    }
    public void setUnitQuantity(PhysicalQuantity unitQuantity) {
        this.unitQuantity.setValue(unitQuantity);
    }


    @Hl7XmlMapping({"unitPriceAmt"})
    public Ratio<Money, PhysicalQuantity> getUnitPriceAmt() {
        return this.unitPriceAmt.getValue();
    }
    public void setUnitPriceAmt(Ratio<Money, PhysicalQuantity> unitPriceAmt) {
        this.unitPriceAmt.setValue(unitPriceAmt);
    }

}