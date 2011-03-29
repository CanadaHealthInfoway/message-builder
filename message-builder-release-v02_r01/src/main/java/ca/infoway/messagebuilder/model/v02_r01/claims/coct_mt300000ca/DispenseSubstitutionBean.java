/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT300000CA.Substitution"})
public class DispenseSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV substitutionReason = new CVImpl();
    private CV substitutionType = new CVImpl();
    private SubstitutionRoleBean performerSubstitutionRole;


    /**
     * <p>Substitution Reason</p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionReason getSubstitutionReason() {
        return (SubstanceAdminSubstitutionReason) this.substitutionReason.getValue();
    }
    public void setSubstitutionReason(SubstanceAdminSubstitutionReason substitutionReason) {
        this.substitutionReason.setValue(substitutionReason);
    }


    /**
     * <p>Substitution Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getSubstitutionType() {
        return (ActSubstanceAdminSubstitutionCode) this.substitutionType.getValue();
    }
    public void setSubstitutionType(ActSubstanceAdminSubstitutionCode substitutionType) {
        this.substitutionType.setValue(substitutionType);
    }


    @Hl7XmlMapping({"performer/substitutionRole"})
    public SubstitutionRoleBean getPerformerSubstitutionRole() {
        return this.performerSubstitutionRole;
    }
    public void setPerformerSubstitutionRole(SubstitutionRoleBean performerSubstitutionRole) {
        this.performerSubstitutionRole = performerSubstitutionRole;
    }

}