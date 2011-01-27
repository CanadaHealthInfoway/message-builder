/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.List;



/**
 * <p>Person Prescribing</p>
 * 
 * <p><p>Person Prescribing</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.PrescriberPerson"})
public class PersonPrescribingBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private PN prescriberName = new PNImpl();
    private LIST<TEL, TelecommunicationAddress> prescriberTelephoneNumber = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>Prescriber Name</p>
     * 
     * <p><p>Name of person prescribing</p></p>
     */
    @Hl7XmlMapping({"name"})
    public PersonName getPrescriberName() {
        return this.prescriberName.getValue();
    }
    public void setPrescriberName(PersonName prescriberName) {
        this.prescriberName.setValue(prescriberName);
    }


    /**
     * <p>Prescriber Telephone Number</p>
     * 
     * <p><p>Telephone no. of the prescriber</p></p>
     * 
     * <p><p>used for Coverage Extension to contact prescriber</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getPrescriberTelephoneNumber() {
        return this.prescriberTelephoneNumber.rawList();
    }

}
