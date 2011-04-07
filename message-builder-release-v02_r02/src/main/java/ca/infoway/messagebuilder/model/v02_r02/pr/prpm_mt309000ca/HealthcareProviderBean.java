/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r02.pr.merged.ResponsiblePartyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 * <p>Healthcare Provider</p>
 * 
 * <p><p>This roles the specific Healthcare provider role such 
 * as a Physician, Nurse or other type of caregivers.</p></p>
 * 
 * <p><p>Roleclass required to support the identification of 
 * person responsible for providing healthcare services</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT309000CA.HealthCareProvider"})
public class HealthcareProviderBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20110407L;
    private List<ResponsiblePartyBean> responsibleFor = new ArrayList<ResponsiblePartyBean>();
    private SET<II, Identifier> healthcareProviderRoleIdentification = new SETImpl<II, Identifier>(IIImpl.class);
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();
    private CV healthcareProviderRoleType = new CVImpl();
    private LIST<PN, PersonName> healthcareProviderRoleName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private PrinicpalPersonBean healthCarePrincipalPerson;
    private OrganizationBean issuingOrganization;


    @Hl7XmlMapping({"responsibleFor"})
    public List<ResponsiblePartyBean> getResponsibleFor() {
        return this.responsibleFor;
    }


    /**
     * <p>Healthcare Provider Role Identification</p>
     * 
     * <p><p>A unique identifier for a provider in a specific 
     * healthcare role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getHealthcareProviderRoleIdentification() {
        return this.healthcareProviderRoleIdentification.rawSet();
    }


    @Hl7XmlMapping({"relatedTo"})
    public List<RelatedToBean> getRelatedTo() {
        return this.relatedTo;
    }


    /**
     * <p>Healthcare Provider Role Type</p>
     * 
     * <p><p>The code identifying the specific healthcare provider 
     * role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getHealthcareProviderRoleType() {
        return (HealthcareProviderRoleType) this.healthcareProviderRoleType.getValue();
    }
    public void setHealthcareProviderRoleType(HealthcareProviderRoleType healthcareProviderRoleType) {
        this.healthcareProviderRoleType.setValue(healthcareProviderRoleType);
    }


    /**
     * <p>Healthcare Provider Role Name</p>
     * 
     * <p><p>The provider'''s name pertaining to the specific 
     * healthcare provider role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getHealthcareProviderRoleName() {
        return this.healthcareProviderRoleName.rawList();
    }


    @Hl7XmlMapping({"healthCarePrincipalPerson"})
    public PrinicpalPersonBean getHealthCarePrincipalPerson() {
        return this.healthCarePrincipalPerson;
    }
    public void setHealthCarePrincipalPerson(PrinicpalPersonBean healthCarePrincipalPerson) {
        this.healthCarePrincipalPerson = healthCarePrincipalPerson;
    }


    @Hl7XmlMapping({"issuingOrganization"})
    public OrganizationBean getIssuingOrganization() {
        return this.issuingOrganization;
    }
    public void setIssuingOrganization(OrganizationBean issuingOrganization) {
        this.issuingOrganization = issuingOrganization;
    }

}
