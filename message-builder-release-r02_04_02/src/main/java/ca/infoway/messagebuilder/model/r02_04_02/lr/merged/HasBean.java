/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.LocationIdentifiedEntityRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Has</p>
 * 
 * <p>PRPA_MT202303CA.IdentifiedLocation: *k:has</p>
 * 
 * <p><p>Provides additional identifiers by which the location 
 * may be known.</p></p>
 * 
 * <p><p>In a registry, it is often necessary to link a 
 * location record to other registries or to commonly used 
 * jurisdictional identifiers.</p></p>
 * 
 * <p>PRPA_MT202302CA.IdentifiedLocation: *k:has</p>
 * 
 * <p><p>Provides additional identifiers by which the location 
 * may be known.</p></p>
 * 
 * <p><p>In a registry, it is often necessary to link a 
 * location record to other registries or to commonly used 
 * jurisdictional identifiers.</p></p>
 * 
 * <p>PRPA_MT202301CA.IdentifiedLocation: *k:has</p>
 * 
 * <p><p>Provides additional identifiers by which the location 
 * may be known.</p></p>
 * 
 * <p><p>In a registry, it is often necessary to link a 
 * location record to other registries or to commonly used 
 * jurisdictional identifiers.</p></p>
 */
@Hl7PartTypeMapping({"PRPA_MT202301CA.IdentifiedLocation","PRPA_MT202302CA.IdentifiedLocation","PRPA_MT202303CA.IdentifiedLocation"})
public class HasBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II identifier = new IIImpl();
    private CV identifierType = new CVImpl();
    private ST identifyingOrganization = new STImpl();


    /**
     * <p>Identifier</p>
     * 
     * <p>A: Identifier</p>
     * 
     * <p><p>An identifier by which the location is known.</p></p>
     * 
     * <p><p>Specifies the actual identifier that can be used for 
     * searching or linking. The attribute is mandatory because 
     * there is no point specifying an &quot;Other 
     * Identifiers&quot; class if you are not going to specify an 
     * identifier.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getIdentifier() {
        return this.identifier.getValue();
    }
    public void setIdentifier(Identifier identifier) {
        this.identifier.setValue(identifier);
    }


    /**
     * <p>IdentifierType</p>
     * 
     * <p>B:Identifier Type</p>
     * 
     * <p><p>Specifies the kind of identifier being communicated. 
     * For example, billing identifier, regional identifier, public 
     * health identifier, etc.</p></p>
     * 
     * <p><p>Provides context around the appropriate use for the 
     * identifier and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public LocationIdentifiedEntityRoleType getIdentifierType() {
        return (LocationIdentifiedEntityRoleType) this.identifierType.getValue();
    }
    public void setIdentifierType(LocationIdentifiedEntityRoleType identifierType) {
        this.identifierType.setValue(identifierType);
    }


    /**
     * <p>IdentifyingOrganization</p>
     * 
     * <p>C: Identifying Organization</p>
     * 
     * <p><p>This is the name of the organization which issued 
     * and/or uses the identifier for the location.</p></p>
     * 
     * <p><p>Further qualifies how the identifier is intended to be 
     * used. For example distinguishing a health-region assigned 
     * identifier from a provincially-assigned identifier. Because 
     * it is important to understanding the identifier, the 
     * attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"assigningIdentifierOrganization/name"})
    public String getIdentifyingOrganization() {
        return this.identifyingOrganization.getValue();
    }
    public void setIdentifyingOrganization(String identifyingOrganization) {
        this.identifyingOrganization.setValue(identifyingOrganization);
    }

}
