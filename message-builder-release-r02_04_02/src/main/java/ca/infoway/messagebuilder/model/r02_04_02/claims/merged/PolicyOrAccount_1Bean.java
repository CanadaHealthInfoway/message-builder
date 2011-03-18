/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.PolicyOrAccount","FICR_MT400003CA.PolicyOrAccount","FICR_MT400004CA.PolicyOrAccount","FICR_MT490101CA.PolicyOrAccount"})
public class PolicyOrAccount_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV policyType = new CVImpl();
    private PolicyHolderBean holderPolicyHolder;
    private CoveredPartyBean beneficiaryCoveredParty;
    private II id = new IIImpl();
    private II carrierIdentifier = new IIImpl();


    /**
     * <p>PolicyType</p>
     * 
     * <p>Policy Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getPolicyType() {
        return (Code) this.policyType.getValue();
    }
    public void setPolicyType(Code policyType) {
        this.policyType.setValue(policyType);
    }


    @Hl7XmlMapping({"holder/policyHolder"})
    public PolicyHolderBean getHolderPolicyHolder() {
        return this.holderPolicyHolder;
    }
    public void setHolderPolicyHolder(PolicyHolderBean holderPolicyHolder) {
        this.holderPolicyHolder = holderPolicyHolder;
    }


    @Hl7XmlMapping({"beneficiary/coveredParty"})
    public CoveredPartyBean getBeneficiaryCoveredParty() {
        return this.beneficiaryCoveredParty;
    }
    public void setBeneficiaryCoveredParty(CoveredPartyBean beneficiaryCoveredParty) {
        this.beneficiaryCoveredParty = beneficiaryCoveredParty;
    }


    /**
     * <p>Policy Identifier(s</p>
     * 
     * <p>Policy Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>CarrierIdentifier</p>
     * 
     * <p>Carrier Identifier</p>
     */
    @Hl7XmlMapping({"author/carrierRole/id"})
    public Identifier getCarrierIdentifier() {
        return this.carrierIdentifier.getValue();
    }
    public void setCarrierIdentifier(Identifier carrierIdentifier) {
        this.carrierIdentifier.setValue(carrierIdentifier);
    }

}
