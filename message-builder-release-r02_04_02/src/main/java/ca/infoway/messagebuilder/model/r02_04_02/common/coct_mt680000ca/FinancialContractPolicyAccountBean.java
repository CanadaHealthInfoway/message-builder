/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt680000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.PolicyUnderwriterBean;



/**
 * <p>Financial contract Policy/Account</p>
 * 
 * <p><p>Account or policy used for determining elibility in 
 * adjudication process.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT680000CA.PolicyOrAccount"})
public class FinancialContractPolicyAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV policyAccountCode = new CVImpl();
    private PolicyUnderwriterBean author;


    /**
     * <p>policy/account code</p>
     * 
     * <p><p>Code Set denoting policy type</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getPolicyAccountCode() {
        return (Code) this.policyAccountCode.getValue();
    }
    public void setPolicyAccountCode(Code policyAccountCode) {
        this.policyAccountCode.setValue(policyAccountCode);
    }


    @Hl7XmlMapping({"author"})
    public PolicyUnderwriterBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PolicyUnderwriterBean author) {
        this.author = author;
    }

}