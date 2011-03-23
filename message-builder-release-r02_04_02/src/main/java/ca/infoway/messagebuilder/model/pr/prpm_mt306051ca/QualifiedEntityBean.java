/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt306051ca;

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
import ca.infoway.messagebuilder.model.merged.ResponsibleOrganizationBean;
import java.util.Set;



/**
 * <p>Qualified Entity</p>
 * 
 * <p>This role describes specific qualifications that may be 
 * held the provider as a result of training or experience, but 
 * having no legal force. Example: a medical degree or diploma. 
 * The current model does not include role attributes such as 
 * name, addr and telecom because there are no known use cases 
 * in this domain where this role is contactable.</p>
 * 
 * <p>Roleclass required to provide additional information for 
 * the person responsible for providing healthcare services</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306051CA.QualifiedEntity"})
public class QualifiedEntityBean extends MessagePartBean implements RoleChoiceBean {

    private static final long serialVersionUID = 20100603L;
    private SET<II, Identifier> expertiseOrCredentialsRoleIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private CV expertiseOrCredentialsRoleType = new CVImpl();
    private PrinicpalPersonBean qualifiedPrincipalPerson;
    private ResponsibleOrganizationBean qualificationGrantingOrganization;

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getExpertiseOrCredentialsRoleIdentifier() {
        return this.expertiseOrCredentialsRoleIdentifier.rawSet();
    }

    @Hl7XmlMapping({"code"})
    public QualifiedRoleType getExpertiseOrCredentialsRoleType() {
        return (QualifiedRoleType) this.expertiseOrCredentialsRoleType.getValue();
    }
    public void setExpertiseOrCredentialsRoleType(QualifiedRoleType expertiseOrCredentialsRoleType) {
        this.expertiseOrCredentialsRoleType.setValue(expertiseOrCredentialsRoleType);
    }

    @Hl7XmlMapping({"qualifiedPrincipalPerson"})
    public PrinicpalPersonBean getQualifiedPrincipalPerson() {
        return this.qualifiedPrincipalPerson;
    }
    public void setQualifiedPrincipalPerson(PrinicpalPersonBean qualifiedPrincipalPerson) {
        this.qualifiedPrincipalPerson = qualifiedPrincipalPerson;
    }

    @Hl7XmlMapping({"qualificationGrantingOrganization"})
    public ResponsibleOrganizationBean getQualificationGrantingOrganization() {
        return this.qualificationGrantingOrganization;
    }
    public void setQualificationGrantingOrganization(ResponsibleOrganizationBean qualificationGrantingOrganization) {
        this.qualificationGrantingOrganization = qualificationGrantingOrganization;
    }

}
