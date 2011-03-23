/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt303010ca;

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
 * <p>The scoping organization for the specified role class</p>
 * 
 * <p>Supports the requirement to supply additional information 
 * regarding the assigning Organization of the specified 
 * RoleClass</p>
 */
@Hl7PartTypeMapping({"PRPM_MT303010CA.Organization"})
public class OrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II organizationId = new IIImpl();
    private ST issuingRepresentingQualificationGrantingOrganizationNameS = new STImpl();
    private AD issuingRepresentingQualificationGrantingOrganizationAddressEs = new ADImpl();
    private TerritorialAuthorityBean territorialAuthority;

    @Hl7XmlMapping({"id"})
    public Identifier getOrganizationId() {
        return this.organizationId.getValue();
    }
    public void setOrganizationId(Identifier organizationId) {
        this.organizationId.setValue(organizationId);
    }

    @Hl7XmlMapping({"name"})
    public String getIssuingRepresentingQualificationGrantingOrganizationNameS() {
        return this.issuingRepresentingQualificationGrantingOrganizationNameS.getValue();
    }
    public void setIssuingRepresentingQualificationGrantingOrganizationNameS(String issuingRepresentingQualificationGrantingOrganizationNameS) {
        this.issuingRepresentingQualificationGrantingOrganizationNameS.setValue(issuingRepresentingQualificationGrantingOrganizationNameS);
    }

    @Hl7XmlMapping({"addr"})
    public PostalAddress getIssuingRepresentingQualificationGrantingOrganizationAddressEs() {
        return this.issuingRepresentingQualificationGrantingOrganizationAddressEs.getValue();
    }
    public void setIssuingRepresentingQualificationGrantingOrganizationAddressEs(PostalAddress issuingRepresentingQualificationGrantingOrganizationAddressEs) {
        this.issuingRepresentingQualificationGrantingOrganizationAddressEs.setValue(issuingRepresentingQualificationGrantingOrganizationAddressEs);
    }

    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
