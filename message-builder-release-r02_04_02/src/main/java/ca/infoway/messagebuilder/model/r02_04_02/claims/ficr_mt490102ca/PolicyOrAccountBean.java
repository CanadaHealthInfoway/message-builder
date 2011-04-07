/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt490102ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.CoveredPartyBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.merged.PolicyHolderBean;



@Hl7PartTypeMapping({"FICR_MT490102CA.PolicyOrAccount"})
public class PolicyOrAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II policyIdentifier = new IIImpl();
    private CV policyType = new CVImpl();
    private CoveredPartyBean beneficiaryCoveredParty;
    private PolicyHolderBean holderPolicyHolder;
    private II carrierIdentifier = new IIImpl();


    /**
     * <p>Policy Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPolicyIdentifier() {
        return this.policyIdentifier.getValue();
    }
    public void setPolicyIdentifier(Identifier policyIdentifier) {
        this.policyIdentifier.setValue(policyIdentifier);
    }


    /**
     * <p>Policy Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getPolicyType() {
        return (Code) this.policyType.getValue();
    }
    public void setPolicyType(Code policyType) {
        this.policyType.setValue(policyType);
    }


    @Hl7XmlMapping({"beneficiary/coveredParty"})
    public CoveredPartyBean getBeneficiaryCoveredParty() {
        return this.beneficiaryCoveredParty;
    }
    public void setBeneficiaryCoveredParty(CoveredPartyBean beneficiaryCoveredParty) {
        this.beneficiaryCoveredParty = beneficiaryCoveredParty;
    }


    @Hl7XmlMapping({"holder/policyHolder"})
    public PolicyHolderBean getHolderPolicyHolder() {
        return this.holderPolicyHolder;
    }
    public void setHolderPolicyHolder(PolicyHolderBean holderPolicyHolder) {
        this.holderPolicyHolder = holderPolicyHolder;
    }


    /**
     * <p>Carrier Identifier</p>
     */
    @Hl7XmlMapping({"author/underwriter/id"})
    public Identifier getCarrierIdentifier() {
        return this.carrierIdentifier.getValue();
    }
    public void setCarrierIdentifier(Identifier carrierIdentifier) {
        this.carrierIdentifier.setValue(carrierIdentifier);
    }

}
