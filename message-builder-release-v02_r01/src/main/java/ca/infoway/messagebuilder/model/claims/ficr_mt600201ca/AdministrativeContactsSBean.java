/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AdministrativeContactRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT600201CA.ContactParty"})
public class AdministrativeContactsSBean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private II administrativeContactID = new IIImpl();
    private CV administrativeContactType = new CVImpl();
    private PN ownerName = new PNImpl();
    private TEL contactPersonTelephoneOrEmailDetails = new TELImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getAdministrativeContactID() {
        return this.administrativeContactID.getValue();
    }
    public void setAdministrativeContactID(Identifier administrativeContactID) {
        this.administrativeContactID.setValue(administrativeContactID);
    }

    @Hl7XmlMapping({"code"})
    public AdministrativeContactRoleType getAdministrativeContactType() {
        return (AdministrativeContactRoleType) this.administrativeContactType.getValue();
    }
    public void setAdministrativeContactType(AdministrativeContactRoleType administrativeContactType) {
        this.administrativeContactType.setValue(administrativeContactType);
    }

    @Hl7XmlMapping({"contactPerson/name"})
    public PersonName getOwnerName() {
        return this.ownerName.getValue();
    }
    public void setOwnerName(PersonName ownerName) {
        this.ownerName.setValue(ownerName);
    }

    @Hl7XmlMapping({"contactPerson/telecom"})
    public TelecommunicationAddress getContactPersonTelephoneOrEmailDetails() {
        return this.contactPersonTelephoneOrEmailDetails.getValue();
    }
    public void setContactPersonTelephoneOrEmailDetails(TelecommunicationAddress contactPersonTelephoneOrEmailDetails) {
        this.contactPersonTelephoneOrEmailDetails.setValue(contactPersonTelephoneOrEmailDetails);
    }

}
