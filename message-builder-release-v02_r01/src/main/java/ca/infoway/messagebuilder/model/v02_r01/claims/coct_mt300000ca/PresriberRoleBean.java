/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT300000CA.PresriberRole"})
public class PresriberRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II prescriberID = new IIImpl();
    private PersonPrescribingBean playingPrescriberPerson;


    /**
     * <p>Prescriber ID</p>
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