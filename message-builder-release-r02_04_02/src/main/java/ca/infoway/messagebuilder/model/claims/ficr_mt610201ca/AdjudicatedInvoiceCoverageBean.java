/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.PolicyOrAccount_2Bean;



/**
 * <p>Allows Payor to adj & pay on different policy</p>
 * 
 * <p>Coverage must be specified for Root Adjudicated Invoice 
 * Element Group and may not be specified for any other 
 * Adjudicated Invoice Element Group.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceCoverage"})
public class AdjudicatedInvoiceCoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private INT cOBSequenceAsAdjudicated = new INTImpl();
    private PolicyOrAccount_2Bean policyOrAccount;

    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getCOBSequenceAsAdjudicated() {
        return this.cOBSequenceAsAdjudicated.getValue();
    }
    public void setCOBSequenceAsAdjudicated(Integer cOBSequenceAsAdjudicated) {
        this.cOBSequenceAsAdjudicated.setValue(cOBSequenceAsAdjudicated);
    }

    @Hl7XmlMapping({"policyOrAccount"})
    public PolicyOrAccount_2Bean getPolicyOrAccount() {
        return this.policyOrAccount;
    }
    public void setPolicyOrAccount(PolicyOrAccount_2Bean policyOrAccount) {
        this.policyOrAccount = policyOrAccount;
    }

}
