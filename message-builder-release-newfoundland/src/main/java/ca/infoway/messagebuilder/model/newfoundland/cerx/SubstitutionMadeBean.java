package ca.infoway.messagebuilder.model.newfoundland.cerx;

import java.io.Serializable;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.ActSubstanceAdminSubstitutionCode;
import ca.infoway.messagebuilder.domainvalue.SubstanceAdminSubstitutionReason;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT020070CA.SubstitutionMade", "PORX_MT060090CA.SubstitutionMade" })
public class SubstitutionMadeBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -7197802801059847461L;

    private CD code = new CDImpl();

    private CD reasonCode = new CDImpl();

    private II responsibleParty = new IIImpl();

    @Hl7XmlMapping("code")
    public ActSubstanceAdminSubstitutionCode getCode() {
        return (ActSubstanceAdminSubstitutionCode) this.code.getValue();
    }

    public void setCode(ActSubstanceAdminSubstitutionCode code) {
        this.code.setValue(code);
    }

    @Hl7XmlMapping("reasonCode")
    public SubstanceAdminSubstitutionReason getReasonCode() {
        return (SubstanceAdminSubstitutionReason) this.reasonCode.getValue();
    }

    public void setReasonCode(SubstanceAdminSubstitutionReason reasonCode) {
        this.reasonCode.setValue(reasonCode);
    }

    @Hl7XmlMapping("responsibleParty/agent/id")
    public Identifier getResponsibleParty() {
        return this.responsibleParty.getValue();
    }

    public void setResponsibleParty(Identifier responsibleParty) {
        this.responsibleParty.setValue(responsibleParty);
    }
}
