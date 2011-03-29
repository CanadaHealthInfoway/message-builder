/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.qucr_mt810201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Device playing the Sending Application Role</p>
 * 
 * <p><p>Device playing the Sending Application Role</p></p>
 */
@Hl7PartTypeMapping({"QUCR_MT810201CA.AdjudResultsSendingAppRole"})
public class DevicePlayingTheSendingApplicationRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II sendingApplicationIdentifier = new IIImpl();


    /**
     * <p>Sending application identifier</p>
     * 
     * <p><p>Sending application identifier</p></p>
     */
    @Hl7XmlMapping({"playingAdjudResultsSendingAppDevice/id"})
    public Identifier getSendingApplicationIdentifier() {
        return this.sendingApplicationIdentifier.getValue();
    }
    public void setSendingApplicationIdentifier(Identifier sendingApplicationIdentifier) {
        this.sendingApplicationIdentifier.setValue(sendingApplicationIdentifier);
    }

}