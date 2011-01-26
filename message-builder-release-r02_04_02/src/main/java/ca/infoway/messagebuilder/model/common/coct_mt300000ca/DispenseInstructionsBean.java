/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT300000CA.DispenseInstructions"})
public class DispenseInstructionsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private ExpectedStartTimeBean substanceAdministrationIntent;


    @Hl7XmlMapping({"substanceAdministrationIntent"})
    public ExpectedStartTimeBean getSubstanceAdministrationIntent() {
        return this.substanceAdministrationIntent;
    }
    public void setSubstanceAdministrationIntent(ExpectedStartTimeBean substanceAdministrationIntent) {
        this.substanceAdministrationIntent = substanceAdministrationIntent;
    }

}
