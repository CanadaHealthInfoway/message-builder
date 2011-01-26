/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.QualifiedRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pr.merged.PrivilegeBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



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
@Hl7PartTypeMapping({"PRPM_MT309000CA.QualifiedEntity"})
public class QualifiedEntityBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20110126L;
    private CV expertiseOrCredentialsRoleType = new CVImpl();
    private SET<II, Identifier> expertiseOrCredentialsRoleIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private List<PrivilegeBean> responsibleForPrivilege = new ArrayList<PrivilegeBean>();
    private IVL<TS, Interval<Date>> expertiseOrCredentialsRoleEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private List<RoleChoice> relatedToRoleChoice = new ArrayList<RoleChoice>();
    private OrganizationBean qualificationGrantingOrganization;
    private PrinicpalPersonBean qualifiedPrincipalPerson;


    /**
     * <p>Expertise or Credentials Role Type</p>
     * 
     * <p><p>A code for the degree or educational rank that the 
     * credential specifies. May also apply to an Expertise 
     * type.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider credentials</p></p>
     */
    @Hl7XmlMapping({"code"})
    public QualifiedRoleType getExpertiseOrCredentialsRoleType() {
        return (QualifiedRoleType) this.expertiseOrCredentialsRoleType.getValue();
    }
    public void setExpertiseOrCredentialsRoleType(QualifiedRoleType expertiseOrCredentialsRoleType) {
        this.expertiseOrCredentialsRoleType.setValue(expertiseOrCredentialsRoleType);
    }


    /**
     * <p>Expertise or Credentials Role Identifier</p>
     * 
     * <p><p>Unique identifier for the Expertise or Credential.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider credentials</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getExpertiseOrCredentialsRoleIdentifier() {
        return this.expertiseOrCredentialsRoleIdentifier.rawSet();
    }


    @Hl7XmlMapping({"responsibleFor/privilege"})
    public List<PrivilegeBean> getResponsibleForPrivilege() {
        return this.responsibleForPrivilege;
    }


    /**
     * <p>Expertise or Credentials Role Effective Date</p>
     * 
     * <p><p>The effective date of the provider expertise or 
     * credentials in the healthcare provider role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider credentials</p></p>
     * 
     * <p><p>If Expertise or Credentials are included in the 
     * message, then Role Effective Date Must Exist</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getExpertiseOrCredentialsRoleEffectiveDate() {
        return this.expertiseOrCredentialsRoleEffectiveDate.getValue();
    }
    public void setExpertiseOrCredentialsRoleEffectiveDate(Interval<Date> expertiseOrCredentialsRoleEffectiveDate) {
        this.expertiseOrCredentialsRoleEffectiveDate.setValue(expertiseOrCredentialsRoleEffectiveDate);
    }


    @Hl7XmlMapping({"relatedTo/roleChoice"})
    public List<RoleChoice> getRelatedToRoleChoice() {
        return this.relatedToRoleChoice;
    }


    @Hl7XmlMapping({"qualificationGrantingOrganization"})
    public OrganizationBean getQualificationGrantingOrganization() {
        return this.qualificationGrantingOrganization;
    }
    public void setQualificationGrantingOrganization(OrganizationBean qualificationGrantingOrganization) {
        this.qualificationGrantingOrganization = qualificationGrantingOrganization;
    }


    @Hl7XmlMapping({"qualifiedPrincipalPerson"})
    public PrinicpalPersonBean getQualifiedPrincipalPerson() {
        return this.qualifiedPrincipalPerson;
    }
    public void setQualifiedPrincipalPerson(PrinicpalPersonBean qualifiedPrincipalPerson) {
        this.qualifiedPrincipalPerson = qualifiedPrincipalPerson;
    }

}
