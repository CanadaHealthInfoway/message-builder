/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

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
import java.util.Date;
import java.util.List;



/**
 * <p>COCT_MT080100CA.IdentifiedEntity: Other Specimen 
 * Identifications</p>
 * 
 * <p><p>Associated specimen identifiers.</p></p>
 * 
 * <p><p>For referral and redirected orders, this information 
 * helps keep track of the different id's assigned during each 
 * phase of processing.</p></p>
 * 
 * <p>PRPA_MT101003CA.IdentifiedEntity: Identified Person</p>
 * 
 * <p><p>The IdentifiedEntity class is the entry point to the 
 * R-MIM and contains one or more identifiers (for example an 
 * &quot;internal&quot; id used only by computer systems and an 
 * &quot;external&quot; id for display to users) for the Person 
 * in the Client Registry. The statusCode is set to 
 * &quot;active&quot;. The beginning of the effectiveTime is 
 * when the record was added to the registry.</p></p>
 * 
 * <p><p>Provides the message entry point required to add a 
 * person to the Client Registry</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.IdentifiedEntity","PRPA_MT101003CA.IdentifiedEntity"})
@Hl7RootType
public class OtherSpecimenIdentificationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private II id = new IIImpl();
    private CV otherSpecimenIdentifierType = new CVImpl();
    private ST organizationName = new STImpl();
    private II organizationIdentifier = new IIImpl();
    private LIST<PN, PersonName> clientName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private CV clientGender = new CVImpl();
    private TS clientDateOfBirth = new TSImpl();


    /**
     * <p>Client Healthcare Identification Number</p>
     * 
     * <p><p>This identification attribute supports capture of a 
     * healthcare identifier specific to the client. This 
     * identifier may be assigned jurisdictionally or by care 
     * facility.</p></p>
     * 
     * <p><p>Mandatory attribute supports unique identification of 
     * the client.</p></p>
     * 
     * <p>Other Specimen Identifiers</p>
     * 
     * <p><p>Associated specimen identifiers.</p></p>
     * 
     * <p><p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p></p>
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
     * 
     * <p><p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p></p>
     * 
     * <p><p>Categorized the type of role identifier.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getOtherSpecimenIdentifierType() {
        return (Code) this.otherSpecimenIdentifierType.getValue();
    }
    public void setOtherSpecimenIdentifierType(Code otherSpecimenIdentifierType) {
        this.otherSpecimenIdentifierType.setValue(otherSpecimenIdentifierType);
    }


    /**
     * <p>OrganizationName</p>
     * 
     * <p>Organization Name</p>
     * 
     * <p><p>Identifies the name of the organization</p></p>
     * 
     * <p><p>Allows for human recognition of the organization as 
     * well as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"assigningOrganization/name"})
    public String getOrganizationName() {
        return this.organizationName.getValue();
    }
    public void setOrganizationName(String organizationName) {
        this.organizationName.setValue(organizationName);
    }


    /**
     * <p>OrganizationIdentifier</p>
     * 
     * <p>Organization Identifier</p>
     * 
     * <p><p>A unique identifier for the organization</p></p>
     * 
     * <p><p>Allows the organization to be referenced when 
     * determining privileges and for drill-downs to retrieve 
     * additional information. Because of its importance, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"assigningOrganization/id"})
    public Identifier getOrganizationIdentifier() {
        return this.organizationIdentifier.getValue();
    }
    public void setOrganizationIdentifier(Identifier organizationIdentifier) {
        this.organizationIdentifier.setValue(organizationIdentifier);
    }


    /**
     * <p>ClientName</p>
     * 
     * <p>Client Name</p>
     * 
     * <p><p>Name(s) for the Client</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/name"})
    public List<PersonName> getClientName() {
        return this.clientName.rawList();
    }


    /**
     * <p>ClientGender</p>
     * 
     * <p>Client Gender</p>
     * 
     * <p><p>Gender of the Client, this is not to be confused with 
     * Clinical Gender of a client. Administrative Gender is 
     * typically restricted to Male (M), Female (F) or Unknown 
     * (U)</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
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
     * 
     * <p><p>Date of birth of the Client</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"identifiedPerson/birthTime"})
    public Date getClientDateOfBirth() {
        return this.clientDateOfBirth.getValue();
    }
    public void setClientDateOfBirth(Date clientDateOfBirth) {
        this.clientDateOfBirth.setValue(clientDateOfBirth);
    }

}
