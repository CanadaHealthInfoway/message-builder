/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt301010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Organization</p>
 * 
 * <p><p>The scoping organization for the specified role 
 * class</p></p>
 * 
 * <p><p>Supports the requirement to supply additional 
 * information regarding the assigning Organization of the 
 * specified RoleClass</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.Organization"})
public class OrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private AD issuingRepresentingQualificationGrantingOrganizationAddress = new ADImpl();
    private ST issuingRepresentingQualificationGrantingOrganizationName = new STImpl();
    private II organizationId = new IIImpl();
    private TerritorialAuthorityBean territorialAuthority;


    /**
     * <p>(Issuing Representing Qualification Granting Organization 
     * Address</p>
     * 
     * <p><p>Address for any of the supported roles</p><p>1. 
     * Issuing Oganization</p><p>2. Representing 
     * Organization</p><p>3. Qualification Granting 
     * Organization</p></p>
     * 
     * <p><p>Address for any of the supported roles</p><p>1. 
     * Issuing Oganization</p><p>2. Representing 
     * Organization</p><p>3. Qualification Granting 
     * Organization</p></p>
     * 
     * <p><p>Address for any of the supported roles</p><p>1. 
     * Issuing Oganization</p><p>2. Representing 
     * Organization</p><p>3. Qualification Granting 
     * Organization</p></p>
     * 
     * <p><p>Address for any of the supported roles</p><p>1. 
     * Issuing Oganization</p><p>2. Representing 
     * Organization</p><p>3. Qualification Granting 
     * Organization</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getIssuingRepresentingQualificationGrantingOrganizationAddress() {
        return this.issuingRepresentingQualificationGrantingOrganizationAddress.getValue();
    }
    public void setIssuingRepresentingQualificationGrantingOrganizationAddress(PostalAddress issuingRepresentingQualificationGrantingOrganizationAddress) {
        this.issuingRepresentingQualificationGrantingOrganizationAddress.setValue(issuingRepresentingQualificationGrantingOrganizationAddress);
    }


    /**
     * <p>Issuing Representing Qualification Granting Organization 
     * Name</p>
     * 
     * <p><p>The name of the organization in support of three role 
     * classes as follows:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider'''s functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p></p>
     * 
     * <p><p>The name of the organization in support of three role 
     * classes as follows:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider'''s functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p></p>
     * 
     * <p><p>The name of the organization in support of three role 
     * classes as follows:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider'''s functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p></p>
     * 
     * <p><p>The name of the organization in support of three role 
     * classes as follows:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider'''s functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the healthcare provider.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getIssuingRepresentingQualificationGrantingOrganizationName() {
        return this.issuingRepresentingQualificationGrantingOrganizationName.getValue();
    }
    public void setIssuingRepresentingQualificationGrantingOrganizationName(String issuingRepresentingQualificationGrantingOrganizationName) {
        this.issuingRepresentingQualificationGrantingOrganizationName.setValue(issuingRepresentingQualificationGrantingOrganizationName);
    }


    /**
     * <p>Organization Id</p>
     * 
     * <p><p>Unique identifier for the organization that assigned 
     * the specified roleClass identifier.</p></p>
     * 
     * <p><p>Required attribute supports the validation and 
     * identification of the specified roleClass.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getOrganizationId() {
        return this.organizationId.getValue();
    }
    public void setOrganizationId(Identifier organizationId) {
        this.organizationId.setValue(organizationId);
    }


    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
