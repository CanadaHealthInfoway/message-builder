/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt510201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p><p>Print form specified for EOB statement when provided 
 * to patient</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.FormRole"})
public class FormRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private FormBean playingForm;


    @Hl7XmlMapping({"playingForm"})
    public FormBean getPlayingForm() {
        return this.playingForm;
    }
    public void setPlayingForm(FormBean playingForm) {
        this.playingForm = playingForm;
    }

}