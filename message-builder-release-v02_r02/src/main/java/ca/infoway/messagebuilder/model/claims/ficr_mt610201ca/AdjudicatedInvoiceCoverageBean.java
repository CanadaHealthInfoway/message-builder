/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.PolicyIdentifierBean;



/**
 * <p>Allows Payor to adj & pay on different policy</p>
 * 
 * <p>For Adjudication Results: On net new policies (i.e. 
 * adjudicated policies for which the provider did not request 
 * adjudication on the Invoice), any policy holder information 
 * will be communicated to the provider with adjudication 
 * information codes. A required action could be used to 
 * instruct the provider s/w to communicate this information to 
 * the patient.</p>
 * 
 * <p>Coverage must be specified for Root Adjudicated Invoice 
 * Element Group and may not be specified for any other 
 * Adjudicated Invoice Element Group.</p>
 */
@Hl7PartTypeMapping({"FICR_MT610201CA.AdjudicatedInvoiceCoverage"})
public class AdjudicatedInvoiceCoverageBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private INT cOBSequenceAsAdjudicated = new INTImpl();
    private PolicyIdentifierBean policyOrAccount;

    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getCOBSequenceAsAdjudicated() {
        return this.cOBSequenceAsAdjudicated.getValue();
    }
    public void setCOBSequenceAsAdjudicated(Integer cOBSequenceAsAdjudicated) {
        this.cOBSequenceAsAdjudicated.setValue(cOBSequenceAsAdjudicated);
    }

    @Hl7XmlMapping({"policyOrAccount"})
    public PolicyIdentifierBean getPolicyOrAccount() {
        return this.policyOrAccount;
    }
    public void setPolicyOrAccount(PolicyIdentifierBean policyOrAccount) {
        this.policyOrAccount = policyOrAccount;
    }

}
