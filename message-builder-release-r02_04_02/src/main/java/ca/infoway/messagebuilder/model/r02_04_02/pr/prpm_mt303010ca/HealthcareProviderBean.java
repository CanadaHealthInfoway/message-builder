/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.pr.prpm_mt303010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.pr.merged.PrinicpalPerson_1Bean;
import ca.infoway.messagebuilder.model.r02_04_02.pr.merged.PrivilegeBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Healthcare Provider</p>
 * 
 * <p><p>This roles the specific Healthcare provider role such 
 * as a Physician, Nurse or other type of caregivers.</p></p>
 * 
 * <p><p>Roleclass required to support the identification of 
 * person responsible for providing healthcare services</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT303010CA.HealthCareProvider"})
public class HealthcareProviderBean extends MessagePartBean implements ca.infoway.messagebuilder.model.r02_04_02.merged.Choice, RoleChoice {

    private static final long serialVersionUID = 20110407L;
    private List<PrivilegeBean> responsibleForPrivilege = new ArrayList<PrivilegeBean>();
    private II healthcareProviderRoleIdentification = new IIImpl();
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();
    private CV healthcareProviderRoleType = new CVImpl();
    private LIST<PN, PersonName> healthcareProviderRoleName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<AD, PostalAddress> healthcareProviderRoleAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> healthcareProviderRoleTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CS healthcareProviderRoleStatusCode = new CSImpl();
    private IVL<TS, Interval<Date>> healthcareProviderRoleEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPerson_1Bean healthCarePrincipalPerson;
    private OrganizationBean issuingOrganization;


    @Hl7XmlMapping({"responsibleFor/privilege"})
    public List<PrivilegeBean> getResponsibleForPrivilege() {
        return this.responsibleForPrivilege;
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
    public Identifier getHealthcareProviderRoleIdentification() {
        return this.healthcareProviderRoleIdentification.getValue();
    }
    public void setHealthcareProviderRoleIdentification(Identifier healthcareProviderRoleIdentification) {
        this.healthcareProviderRoleIdentification.setValue(healthcareProviderRoleIdentification);
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


    /**
     * <p>Healthcare Provider Role Address</p>
     * 
     * <p><p>The address for the provider when playing the role of 
     * healthcare provider.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getHealthcareProviderRoleAddress() {
        return this.healthcareProviderRoleAddress.rawList();
    }


    /**
     * <p>Healthcare Provider Role Telecom</p>
     * 
     * <p><p>The telecom for the provider when playing the role of 
     * healthcare provider.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getHealthcareProviderRoleTelecom() {
        return this.healthcareProviderRoleTelecom.rawList();
    }


    /**
     * <p>Healthcare Provider Role Status Code</p>
     * 
     * <p><p>The status of the provider in the healthcare provider 
     * role i.e. Active</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getHealthcareProviderRoleStatusCode() {
        return (RoleStatus) this.healthcareProviderRoleStatusCode.getValue();
    }
    public void setHealthcareProviderRoleStatusCode(RoleStatus healthcareProviderRoleStatusCode) {
        this.healthcareProviderRoleStatusCode.setValue(healthcareProviderRoleStatusCode);
    }


    /**
     * <p>Healthcare Provider Role Effective Date</p>
     * 
     * <p><p>The effective date of the provider in the healthcare 
     * provider role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getHealthcareProviderRoleEffectiveDate() {
        return this.healthcareProviderRoleEffectiveDate.getValue();
    }
    public void setHealthcareProviderRoleEffectiveDate(Interval<Date> healthcareProviderRoleEffectiveDate) {
        this.healthcareProviderRoleEffectiveDate.setValue(healthcareProviderRoleEffectiveDate);
    }


    @Hl7XmlMapping({"healthCarePrincipalPerson"})
    public PrinicpalPerson_1Bean getHealthCarePrincipalPerson() {
        return this.healthCarePrincipalPerson;
    }
    public void setHealthCarePrincipalPerson(PrinicpalPerson_1Bean healthCarePrincipalPerson) {
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
