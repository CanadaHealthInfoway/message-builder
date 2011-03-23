/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Id allows for consolidating identical required acts on 1 
 * form</p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicationResultRequiredAct"})
public class AdjudicationResultRequiredActBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private CV requiredActionType = new CVImpl();
    private FormRoleBean directTargetFormRole;

    @Hl7XmlMapping({"code"})
    public Code getRequiredActionType() {
        return (Code) this.requiredActionType.getValue();
    }
    public void setRequiredActionType(Code requiredActionType) {
        this.requiredActionType.setValue(requiredActionType);
    }

    @Hl7XmlMapping({"directTarget/formRole"})
    public FormRoleBean getDirectTargetFormRole() {
        return this.directTargetFormRole;
    }
    public void setDirectTargetFormRole(FormRoleBean directTargetFormRole) {
        this.directTargetFormRole = directTargetFormRole;
    }

}
