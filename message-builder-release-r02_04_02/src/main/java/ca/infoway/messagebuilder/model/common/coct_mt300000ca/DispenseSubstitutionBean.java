/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT300000CA.Substitution"})
public class DispenseSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private CV substitutionType = new CVImpl();
    private SubstitutionRoleBean performerSubstitutionRole;
    private CV substitutionReason = new CVImpl();


    /**
     * <p>Substitution Type</p>
     * 
     * <p><p>type of substitution</p></p>
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


    /**
     * <p>Substitution Reason</p>
     * 
     * <p><p>Reason why the substitution occurred.</p></p>
     * 
     * <p><p>Reason for substituting or not substituting, e.g. 
     * because prescriber requested</p></p>
     */
    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionReason getSubstitutionReason() {
        return (SubstanceAdminSubstitutionReason) this.substitutionReason.getValue();
    }
    public void setSubstitutionReason(SubstanceAdminSubstitutionReason substitutionReason) {
        this.substitutionReason.setValue(substitutionReason);
    }

}
