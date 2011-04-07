/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.si.comt_mt500001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Broadcast Message</p>
 * 
 * <p><p>Information being transmitted to proviers as a 'mass 
 * broadcast'</p></p>
 * 
 * <p><p>Allows conveying information such as stolen 
 * prescription pads, system availability information, etc.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT500001CA.InformEvent"})
@Hl7RootType
public class BroadcastMessageBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ST broadcastMessage = new STImpl();


    /**
     * <p>Broadcast Message</p>
     * 
     * <p><p>Contains the text to be displayed to the user of the 
     * system.</p></p>
     * 
     * <p><p>Allows conveying of system messages and other types of 
     * alerts. E.g. Planned outages, stolen prescription pads, 
     * etc.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getBroadcastMessage() {
        return this.broadcastMessage.getValue();
    }
    public void setBroadcastMessage(String broadcastMessage) {
        this.broadcastMessage.setValue(broadcastMessage);
    }

}
