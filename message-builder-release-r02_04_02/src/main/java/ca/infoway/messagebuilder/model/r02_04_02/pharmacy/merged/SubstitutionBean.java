/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Substitution</p>
 * 
 * <p>PORX_MT060160CA.SubstitutionMade: Substitution</p>
 * 
 * <p><p>An indication of what kind of substitution made, if 
 * any.</p></p>
 * 
 * <p><p>May explain why prescribed and dispensed medications 
 * differ.</p></p>
 * 
 * <p>PORX_MT060090CA.SubstitutionMade: Substitution</p>
 * 
 * <p><p>An indication of what kind of substitution made, if 
 * any.</p></p>
 * 
 * <p><p>May explain why prescribed and dispensed medications 
 * differ.</p></p>
 * 
 * <p>PORX_MT060340CA.SubstitutionMade: Substitution</p>
 * 
 * <p><p>An indication of what kind of substitution made, if 
 * any.</p></p>
 * 
 * <p><p>May explain why prescribed and dispensed medications 
 * differ.</p></p>
 * 
 * <p>PORX_MT020070CA.SubstitutionMade: Substitution</p>
 * 
 * <p><p>An indication of what kind of substitution was made, 
 * if any.</p></p>
 * 
 * <p><p>May explain why prescribed and dispensed medications 
 * may differ.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT020070CA.SubstitutionMade","PORX_MT060090CA.SubstitutionMade","PORX_MT060160CA.SubstitutionMade","PORX_MT060340CA.SubstitutionMade"})
public class SubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private CV substitutionCode = new CVImpl();
    private CV reasonCode = new CVImpl();
    private AgentBean responsiblePartyAgent;


    /**
     * <p>SubstitutionCode</p>
     * 
     * <p>Substitution Code</p>
     * 
     * <p><p>A code signifying whether a different drug was 
     * dispensed from what was prescribed.</p></p>
     * 
     * <p><p>Indicates that substitution was done (or not). This 
     * attribute is mandatory because it is essential to 
     * understanding the substitution.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getSubstitutionCode() {
        return (ActSubstanceAdminSubstitutionCode) this.substitutionCode.getValue();
    }
    public void setSubstitutionCode(ActSubstanceAdminSubstitutionCode substitutionCode) {
        this.substitutionCode.setValue(substitutionCode);
    }


    /**
     * <p>Product Selection Reason Code</p>
     * 
     * <p><p>Indicates the reason for the substitution of (or 
     * failure to substitute) the medication from what was 
     * prescribed.</p></p>
     * 
     * <p><p>Standardized reasons for substitution performed (or 
     * not performed). Useful in analysis of dispensing 
     * patterns.</p></p>
     * 
     * <p>Product Selection Code</p>
     * 
     * <p><p>Indicates the reason for the substitution of (or 
     * failure to substitute) the medication from what was 
     * prescribed.</p></p>
     * 
     * <p><p>Standardized reasons for substitution performed (or 
     * not performed). Useful in analysis of dispensing 
     * patterns.</p></p>
     * 
     * <p>Product Selection Reason Code</p>
     * 
     * <p><p>Indicates the reason for the substitution of (or lack 
     * of substitution) from what was prescribed.</p></p>
     * 
     * <p><p>Standardized reasons for substitution performed (or 
     * not performed). Useful in analysis of dispensing 
     * patterns.</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionReason getReasonCode() {
        return (SubstanceAdminSubstitutionReason) this.reasonCode.getValue();
    }
    public void setReasonCode(SubstanceAdminSubstitutionReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }


    @Hl7XmlMapping({"responsibleParty/agent"})
    public AgentBean getResponsiblePartyAgent() {
        return this.responsiblePartyAgent;
    }
    public void setResponsiblePartyAgent(AgentBean responsiblePartyAgent) {
        this.responsiblePartyAgent = responsiblePartyAgent;
    }

}
