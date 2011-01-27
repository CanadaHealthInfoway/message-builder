/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Playing Prescribe Person</p>
 * 
 * <p><p>ID cannot be mandatory as it may not be present on a 
 * pre-determination</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.PresriberRole"})
public class PlayingPrescribePersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private II prescriberID = new IIImpl();
    private PersonPrescribingBean playingPrescriberPerson;


    /**
     * <p>Prescriber ID</p>
     * 
     * <p><p>Prescriber ID</p></p>
     * 
     * <p><p>This is mandatory for Invoices and required with 
     * nullFlavor for Pre-Determinations.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPrescriberID() {
        return this.prescriberID.getValue();
    }
    public void setPrescriberID(Identifier prescriberID) {
        this.prescriberID.setValue(prescriberID);
    }


    @Hl7XmlMapping({"playingPrescriberPerson"})
    public PersonPrescribingBean getPlayingPrescriberPerson() {
        return this.playingPrescriberPerson;
    }
    public void setPlayingPrescriberPerson(PersonPrescribingBean playingPrescriberPerson) {
        this.playingPrescriberPerson = playingPrescriberPerson;
    }

}
