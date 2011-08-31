/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt306051ca;

import java.util.Set;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.QualifiedRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged.PrinicpalPerson_2Bean;



/**
 * <p>Qualified Entity</p>
 * 
 * <p><p>This role describes specific qualifications that may 
 * be held the provider as a result of training or experience, 
 * but having no legal force. Example: a medical degree or 
 * diploma. The current model does not include role attributes 
 * such as name, addr and telecom because there are no known 
 * use cases in this domain where this role is contactable.</p></p>
 * 
 * <p><p>Roleclass required to provide additional information 
 * for the person responsible for providing healthcare 
 * services</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306051CA.QualifiedEntity"})
public class QualifiedEntityBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.RoleChoice {

    private static final long serialVersionUID = 20110831L;
    private SET<II, Identifier> expertiseOrCredentialsRoleIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private CV expertiseOrCredentialsRoleType = new CVImpl();
    private PrinicpalPerson_2Bean qualifiedPrincipalPerson;
    private OrganizationBean qualificationGrantingOrganization;


    /**
     * <p>Expertise or Credentials Role Identifier</p>
     * 
     * <p><p>Unique identifier for the Expertise or Credential.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getExpertiseOrCredentialsRoleIdentifier() {
        return this.expertiseOrCredentialsRoleIdentifier.rawSet();
    }


    /**
     * <p>Expertise or Credentials Role Type</p>
     * 
     * <p><p>A code for the degree or educational rank that the 
     * credential specifies. May also apply to an Expertise 
     * type.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     * 
     * <p><p>If Expertise or Credentials are included in the 
     * message, then Role Type Must Exist.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public QualifiedRoleType getExpertiseOrCredentialsRoleType() {
        return (QualifiedRoleType) this.expertiseOrCredentialsRoleType.getValue();
    }
    public void setExpertiseOrCredentialsRoleType(QualifiedRoleType expertiseOrCredentialsRoleType) {
        this.expertiseOrCredentialsRoleType.setValue(expertiseOrCredentialsRoleType);
    }


    @Hl7XmlMapping({"qualifiedPrincipalPerson"})
    public PrinicpalPerson_2Bean getQualifiedPrincipalPerson() {
        return this.qualifiedPrincipalPerson;
    }
    public void setQualifiedPrincipalPerson(PrinicpalPerson_2Bean qualifiedPrincipalPerson) {
        this.qualifiedPrincipalPerson = qualifiedPrincipalPerson;
    }


    @Hl7XmlMapping({"qualificationGrantingOrganization"})
    public OrganizationBean getQualificationGrantingOrganization() {
        return this.qualificationGrantingOrganization;
    }
    public void setQualificationGrantingOrganization(OrganizationBean qualificationGrantingOrganization) {
        this.qualificationGrantingOrganization = qualificationGrantingOrganization;
    }

}
