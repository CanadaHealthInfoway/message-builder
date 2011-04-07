/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



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
     * <p>Product Selection Code</p>
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
