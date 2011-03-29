/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt500201ca.PolicyHolderBean;
import ca.infoway.messagebuilder.model.r02_04_02.merged.PolicyUnderwriterBean;



/**
 * <p>FICR_MT600201CA.PolicyOrAccount: (no business name)</p>
 * 
 * <p><p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p></p>
 * 
 * <p>FICR_MT500201CA.PolicyOrAccount: (no business name)</p>
 * 
 * <p><p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT500201CA.PolicyOrAccount","FICR_MT600201CA.PolicyOrAccount","FICR_MT610201CA.PolicyOrAccount"})
public class PolicyOrAccount_2Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CD policyType = new CDImpl();
    private CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient;
    private PolicyUnderwriterBean author;
    private II id = new IIImpl();
    private PolicyHolderBean holderPolicyHolder;


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


    @Hl7XmlMapping({"beneficiary/coveredPartyAsPatient"})
    public CoveredPartyAsPatientBean getBeneficiaryCoveredPartyAsPatient() {
        return this.beneficiaryCoveredPartyAsPatient;
    }
    public void setBeneficiaryCoveredPartyAsPatient(CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient) {
        this.beneficiaryCoveredPartyAsPatient = beneficiaryCoveredPartyAsPatient;
    }


    @Hl7XmlMapping({"author"})
    public PolicyUnderwriterBean getAuthor() {
        return this.author;
    }
    public void setAuthor(PolicyUnderwriterBean author) {
        this.author = author;
    }


    /**
     * <p>Policy ID</p>
     * 
     * <p>Policy Identifier(s</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"holder/policyHolder"})
    public PolicyHolderBean getHolderPolicyHolder() {
        return this.holderPolicyHolder;
    }
    public void setHolderPolicyHolder(PolicyHolderBean holderPolicyHolder) {
        this.holderPolicyHolder = holderPolicyHolder;
    }

}