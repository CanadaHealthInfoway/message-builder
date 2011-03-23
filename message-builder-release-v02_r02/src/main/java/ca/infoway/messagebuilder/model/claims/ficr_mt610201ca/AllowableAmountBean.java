/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Allowable Amount</p>
 * 
 * <p>Amount of payment allowed under the policy rules; 
 * eligible amount.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.Allowable"})
public class AllowableAmountBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private MO netAmt = new MOImpl();

    @Hl7XmlMapping({"netAmt"})
    public Money getNetAmt() {
        return this.netAmt.getValue();
    }
    public void setNetAmt(Money netAmt) {
        this.netAmt.setValue(netAmt);
    }

}
