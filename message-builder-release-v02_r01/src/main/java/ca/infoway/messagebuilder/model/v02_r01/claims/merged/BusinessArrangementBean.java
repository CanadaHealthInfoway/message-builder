/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT600201CA.FinancialContract","QUCR_MT810201CA.AdjudResultsFinancialContract"})
public class BusinessArrangementBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II id = new IIImpl();
    private CV billingArrangementType = new CVImpl();


    /**
     * <p>Financial Contract ID</p>
     * 
     * <p>Business Arrangement ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>BillingArrangementType</p>
     * 
     * <p>Billing Arrangement Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getBillingArrangementType() {
        return (Code) this.billingArrangementType.getValue();
    }
    public void setBillingArrangementType(Code billingArrangementType) {
        this.billingArrangementType.setValue(billingArrangementType);
    }

}