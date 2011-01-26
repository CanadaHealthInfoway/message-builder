/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.cr.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>OtherIDsNonHealthcareIdentifiers</p>
 * 
 * <p>PRPA_MT101104CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p><p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p></p>
 * 
 * <p><p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p></p>
 * 
 * <p>PRPA_MT101002CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p><p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p></p>
 * 
 * <p><p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p></p>
 * 
 * <p>PRPA_MT101106CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p><p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p></p>
 * 
 * <p><p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p></p>
 * 
 * <p>PRPA_MT101102CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p><p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p></p>
 * 
 * <p><p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p></p>
 * 
 * <p>PRPA_MT101001CA.OtherIDs: Other IDs Non Healthcare 
 * Identifiers</p>
 * 
 * <p><p>Identifiers used for the focal person by other 
 * organizations are sent in the OtherIDs class. The other 
 * organization can be sent in the E_Organization Entity 
 * Class</p></p>
 * 
 * <p><p>Provides the ability to capture additional client 
 * identifiers that are not healthcare specific</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT101001CA.OtherIDs","PRPA_MT101002CA.OtherIDs","PRPA_MT101102CA.OtherIDs","PRPA_MT101104CA.OtherIDs","PRPA_MT101106CA.OtherIDs"})
public class OtherIDsNonHealthcareIdentifiersBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private CV nonHealthcareIdentificationCode = new CVImpl();
    private II nonHealthcareIdentification = new IIImpl();
    private II nonHealthcareOrganizationIdentifier = new IIImpl();
    private ST nonHealthcareOrganizationName = new STImpl();


    /**
     * <p>NonHealthcareIdentificationCode</p>
     * 
     * <p>NonHealthcare Identification Code</p>
     * 
     * <p><p>A pan Canadian code further specifying the kind of 
     * Role such as Drivers License, RCMP, DND, Social Insurance 
     * Number</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getNonHealthcareIdentificationCode() {
        return (Code) this.nonHealthcareIdentificationCode.getValue();
    }
    public void setNonHealthcareIdentificationCode(Code nonHealthcareIdentificationCode) {
        this.nonHealthcareIdentificationCode.setValue(nonHealthcareIdentificationCode);
    }


    /**
     * <p>NonHealthcareIdentification</p>
     * 
     * <p>NonHealthcare Identification</p>
     * 
     * <p><p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * client</p></p>
     * 
     * <p>NonHealthcare Identification</p>
     * 
     * <p><p>Other non-healthcare identifiers for the Client (e.g. 
     * Drivers License, RCMP, DND, Social Insurance Number)</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * client</p></p>
     * 
     * <p>NonHealthcare Identification</p>
     * 
     * <p><p>Other non-healthcare identifiers for the Client (e.g. 
     * Passport, SIN, DND, DIAND, Drivers License)</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * client</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getNonHealthcareIdentification() {
        return this.nonHealthcareIdentification.getValue();
    }
    public void setNonHealthcareIdentification(Identifier nonHealthcareIdentification) {
        this.nonHealthcareIdentification.setValue(nonHealthcareIdentification);
    }


    /**
     * <p>NonHealthcareOrganizationIdentifier</p>
     * 
     * <p>NonHealthcare Organization Identifier</p>
     * 
     * <p><p>Unique identifier for the organization that assigned 
     * the non-healthcare identifier for the client.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * organization assigning the identifier to the client</p></p>
     */
    @Hl7XmlMapping({"assigningIdOrganization/id"})
    public Identifier getNonHealthcareOrganizationIdentifier() {
        return this.nonHealthcareOrganizationIdentifier.getValue();
    }
    public void setNonHealthcareOrganizationIdentifier(Identifier nonHealthcareOrganizationIdentifier) {
        this.nonHealthcareOrganizationIdentifier.setValue(nonHealthcareOrganizationIdentifier);
    }


    /**
     * <p>NonHealthcareOrganizationName</p>
     * 
     * <p>NonHealthcare Organization Name</p>
     * 
     * <p><p>A name for the non-healthcare organization</p></p>
     * 
     * <p><p>Populated attribute supports the identification of the 
     * organization assigning the identifier to the client</p></p>
     */
    @Hl7XmlMapping({"assigningIdOrganization/name"})
    public String getNonHealthcareOrganizationName() {
        return this.nonHealthcareOrganizationName.getValue();
    }
    public void setNonHealthcareOrganizationName(String nonHealthcareOrganizationName) {
        this.nonHealthcareOrganizationName.setValue(nonHealthcareOrganizationName);
    }

}
