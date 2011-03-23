/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt303010ca;

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
import ca.infoway.messagebuilder.model.merged.PrinicpalPersonBean;
import ca.infoway.messagebuilder.model.merged.ResponsiblePartyBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Healthcare Provider</p>
 * 
 * <p>This roles the specific Healthcare provider role such as 
 * a Physician, Nurse or other type of caregivers.</p>
 * 
 * <p>Roleclass required to support the identification of 
 * person responsible for providing healthcare services</p>
 */
@Hl7PartTypeMapping({"PRPM_MT303010CA.HealthCareProvider"})
public class HealthcareProviderBean extends MessagePartBean implements RoleChoiceBean, ChoiceBean {

    private static final long serialVersionUID = 20100614L;
    private List<ResponsiblePartyBean> responsibleFor = new ArrayList<ResponsiblePartyBean>();
    private II healthcareProviderRoleIdentification = new IIImpl();
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();
    private CV healthcareProviderRoleType = new CVImpl();
    private LIST<PN, PersonName> healthcareProviderRoleName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<AD, PostalAddress> healthcareProviderRoleAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> healthcareProviderRoleTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CS healthcareProviderRoleStatusCode = new CSImpl();
    private IVL<TS, Interval<Date>> healthcareProviderRoleEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPersonBean healthCarePrincipalPerson;
    private OrganizationBean issuingOrganization;

    @Hl7XmlMapping({"responsibleFor"})
    public List<ResponsiblePartyBean> getResponsibleFor() {
        return this.responsibleFor;
    }

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

    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getHealthcareProviderRoleType() {
        return (HealthcareProviderRoleType) this.healthcareProviderRoleType.getValue();
    }
    public void setHealthcareProviderRoleType(HealthcareProviderRoleType healthcareProviderRoleType) {
        this.healthcareProviderRoleType.setValue(healthcareProviderRoleType);
    }

    @Hl7XmlMapping({"name"})
    public List<PersonName> getHealthcareProviderRoleName() {
        return this.healthcareProviderRoleName.rawList();
    }

    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getHealthcareProviderRoleAddress() {
        return this.healthcareProviderRoleAddress.rawList();
    }

    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getHealthcareProviderRoleTelecom() {
        return this.healthcareProviderRoleTelecom.rawList();
    }

    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getHealthcareProviderRoleStatusCode() {
        return (RoleStatus) this.healthcareProviderRoleStatusCode.getValue();
    }
    public void setHealthcareProviderRoleStatusCode(RoleStatus healthcareProviderRoleStatusCode) {
        this.healthcareProviderRoleStatusCode.setValue(healthcareProviderRoleStatusCode);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getHealthcareProviderRoleEffectiveDate() {
        return this.healthcareProviderRoleEffectiveDate.getValue();
    }
    public void setHealthcareProviderRoleEffectiveDate(Interval<Date> healthcareProviderRoleEffectiveDate) {
        this.healthcareProviderRoleEffectiveDate.setValue(healthcareProviderRoleEffectiveDate);
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
