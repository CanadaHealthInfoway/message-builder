/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionNotAllowedReason;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010120CA.SubstitutionPermission","PORX_MT060160CA.SubstitutionPermission","PORX_MT060340CA.SubstitutionPermission"})
public class AllowedSubstitutionBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CV substitutionAllowed = new CVImpl();
    private BL substitutionNotAllowedIndicator = new BLImpl();
    private CV notAllowedReason = new CVImpl();

    @Hl7XmlMapping({"code"})
    public ActSubstanceAdminSubstitutionCode getSubstitutionAllowed() {
        return (ActSubstanceAdminSubstitutionCode) this.substitutionAllowed.getValue();
    }
    public void setSubstitutionAllowed(ActSubstanceAdminSubstitutionCode substitutionAllowed) {
        this.substitutionAllowed.setValue(substitutionAllowed);
    }

    @Hl7XmlMapping({"negationInd"})
    public Boolean getSubstitutionNotAllowedIndicator() {
        return this.substitutionNotAllowedIndicator.getValue();
    }
    public void setSubstitutionNotAllowedIndicator(Boolean substitutionNotAllowedIndicator) {
        this.substitutionNotAllowedIndicator.setValue(substitutionNotAllowedIndicator);
    }

    @Hl7XmlMapping({"reasonCode"})
    public SubstanceAdminSubstitutionNotAllowedReason getNotAllowedReason() {
        return (SubstanceAdminSubstitutionNotAllowedReason) this.notAllowedReason.getValue();
    }
    public void setNotAllowedReason(SubstanceAdminSubstitutionNotAllowedReason notAllowedReason) {
        this.notAllowedReason.setValue(notAllowedReason);
    }

}
