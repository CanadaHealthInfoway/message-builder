/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeContactRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ContactPersonBean;



@Hl7PartTypeMapping({"FICR_MT400001CA.ContactParty","FICR_MT500201CA.ContactParty","FICR_MT600201CA.ContactParty"})
public class ContactPartyBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II administrativeContactID = new IIImpl();
    private CV code = new CVImpl();
    private ContactPersonBean contactPerson;
    private PN callBackContactPersonName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> callBackContactPersonTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>AdministrativeContactID</p>
     * 
     * <p>Administrative Contact ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdministrativeContactID() {
        return this.administrativeContactID.getValue();
    }
    public void setAdministrativeContactID(Identifier administrativeContactID) {
        this.administrativeContactID.setValue(administrativeContactID);
    }


    /**
     * <p>Call Back Contact Type</p>
     * 
     * <p>Administrative Contact Type</p>
     */
    @Hl7XmlMapping({"code"})
    public AdministrativeContactRoleType getCode() {
        return (AdministrativeContactRoleType) this.code.getValue();
    }
    public void setCode(AdministrativeContactRoleType code) {
        this.code.setValue(code);
    }


    @Hl7XmlMapping({"contactPerson"})
    public ContactPersonBean getContactPerson() {
        return this.contactPerson;
    }
    public void setContactPerson(ContactPersonBean contactPerson) {
        this.contactPerson = contactPerson;
    }


    /**
     * <p>CallBackContactPersonName</p>
     * 
     * <p>Call Back Contact Person Name</p>
     */
    @Hl7XmlMapping({"contactCallBackPerson/name"})
    public PersonName getCallBackContactPersonName() {
        return this.callBackContactPersonName.getValue();
    }
    public void setCallBackContactPersonName(PersonName callBackContactPersonName) {
        this.callBackContactPersonName.setValue(callBackContactPersonName);
    }


    /**
     * <p>CallBackContactPersonTelecom</p>
     * 
     * <p>Call Back Contact Person Telecom</p>
     */
    @Hl7XmlMapping({"contactCallBackPerson/telecom"})
    public Set<TelecommunicationAddress> getCallBackContactPersonTelecom() {
        return this.callBackContactPersonTelecom.rawSet();
    }

}
