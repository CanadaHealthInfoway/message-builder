/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.AdministrativeGender;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT080100CA.IdentifiedEntity","PRPA_MT101003CA.IdentifiedEntity"})
@Hl7RootType
public class OtherSpecimenIdentificationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II id = new IIImpl();
    private CV otherSpecimenIdentifierType = new CVImpl();
    private II organizationIdentifier = new IIImpl();
    private ST organizationName = new STImpl();
    private LIST<PN, PersonName> clientName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CV clientGender = new CVImpl();
    private TS clientDateOfBirth = new TSImpl();


    /**
     * <p>Other Specimen Identifiers</p>
     * 
     * <p>Client Healthcare Identification Number</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>OtherSpecimenIdentifierType</p>
     * 
     * <p>Other Specimen Identifier Type</p>
     */
    @Hl7XmlMapping({"code"})
    public Code getOtherSpecimenIdentifierType() {
        return (Code) this.otherSpecimenIdentifierType.getValue();
    }
    public void setOtherSpecimenIdentifierType(Code otherSpecimenIdentifierType) {
        this.otherSpecimenIdentifierType.setValue(otherSpecimenIdentifierType);
    }


    /**
     * <p>OrganizationIdentifier</p>
     * 
     * <p>Organization Identifier</p>
     */
    @Hl7XmlMapping({"assigningOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }


    /**
     * <p>OrganizationName</p>
     * 
     * <p>Organization Name</p>
     */
    @Hl7XmlMapping({"assigningOrganization/name"})
    public String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName.setValue(organizationName);
    }


    /**
     * <p>ClientName</p>
     * 
     * <p>Client Name</p>
     */
    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getClientName() {
        return this.clientName.rawList();
    }


    /**
     * <p>ClientGender</p>
     * 
     * <p>Client Gender</p>
     */
    @Hl7XmlMapping({"identifiedPerson/administrativeGenderCode"})
    public AdministrativeGender getClientGender() {
        return (AdministrativeGender) this.clientGender.getValue();
    }
    public void setClientGender(AdministrativeGender clientGender) {
        this.clientGender.setValue(clientGender);
    }


    /**
     * <p>ClientDateOfBirth</p>
     * 
     * <p>Client Date of Birth</p>
     */
    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getClientDateOfBirth() {
        return this.clientDateOfBirth.getValue();
    }
    public void setClientDateOfBirth(Date clientDateOfBirth) {
        this.clientDateOfBirth.setValue(clientDateOfBirth);
    }

}
