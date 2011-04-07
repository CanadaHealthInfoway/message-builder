/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.qucr_mt810201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"QUCR_MT810201CA.AdjudResultsSendingAppRole"})
public class AdjudResultsSendingAppRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II playingAdjudResultsSendingAppDeviceId = new IIImpl();


    @Hl7XmlMapping({"playingAdjudResultsSendingAppDevice/id"})
    public Identifier getPlayingAdjudResultsSendingAppDeviceId() {
        return this.playingAdjudResultsSendingAppDeviceId.getValue();
    }
    public void setPlayingAdjudResultsSendingAppDeviceId(Identifier playingAdjudResultsSendingAppDeviceId) {
        this.playingAdjudResultsSendingAppDeviceId.setValue(playingAdjudResultsSendingAppDeviceId);
    }

}
