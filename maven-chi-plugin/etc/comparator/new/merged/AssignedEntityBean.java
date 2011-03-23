/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
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
import ca.infoway.messagebuilder.model.common.coct_mt470012ca.RecipientBean;
import ca.infoway.messagebuilder.model.common.coct_mt911108ca.ActingPersonBean;
import ca.infoway.messagebuilder.model.common.prpm_mt301010ca.PrimaryPerformer3Bean;
import ca.infoway.messagebuilder.model.common.prpm_mt306011ca.RoleChoiceBean;
import ca.infoway.messagebuilder.model.common.repc_mt000012ca.ChoiceBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT090102CA.AssignedEntity","COCT_MT090108CA.AssignedEntity","COCT_MT090502CA.AssignedEntity","COCT_MT090508CA.AssignedEntity","PORR_MT050016CA.AssignedEntity","PRPM_MT301010CA.AssignedEntity","PRPM_MT303010CA.AssignedEntity","PRPM_MT306011CA.AssignedEntity","PRPM_MT306051CA.AssignedEntity"})
@Hl7RootType
public class AssignedEntityBean extends MessagePartBean implements RecipientBean, ca.infoway.messagebuilder.model.common.coct_mt911107ca.ActingPersonBean, ca.infoway.messagebuilder.model.common.coct_mt470002ca.RecipientBean, ca.infoway.messagebuilder.model.common.rcmr_mt010001ca.RecipientBean, ca.infoway.messagebuilder.model.common.prpm_mt306051ca.RoleChoiceBean, RoleChoiceBean, ca.infoway.messagebuilder.model.common.prpm_mt303010ca.RoleChoiceBean, ChoiceBean, ca.infoway.messagebuilder.model.common.coct_mt911102ca.ActingPersonBean, ChangedByBean, EntererChoiceBean, ca.infoway.messagebuilder.model.common.prpm_mt301010ca.RoleChoiceBean, ActingPersonBean, PartyBean, AuthorPerson_2Bean {

    private II healthcareWorkerIdentifier = new IIImpl();
    private CV<HealthcareProviderRoleType> healthcareWorkerType = new CVImpl<HealthcareProviderRoleType>();
    private SET<TEL, TelecommunicationAddress> healthcareWorkerPhoneAndEmails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ca.infoway.messagebuilder.model.merged.ActingPersonBean assignedPerson = new ca.infoway.messagebuilder.model.merged.ActingPersonBean();
    private ResponsibleOrganizationBean representedOrganization;
    private LIST<PN, PersonName> functionalRoleName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private PrincipalPerson_2Bean assignedPrincipalPerson;
    private LIST<AD, PostalAddress> functionalRoleAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private CS<RoleStatus> functionalRoleStatusCode = new CSImpl<RoleStatus>();
    private IVL<TS, Interval<Date>> functionalRoleEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private List<PrimaryPerformer3Bean> performance = new ArrayList<PrimaryPerformer3Bean>();

    @Hl7XmlMapping({"id"})
    public Identifier getHealthcareWorkerIdentifier() {
        return this.healthcareWorkerIdentifier.getValue();
    }
    public void setHealthcareWorkerIdentifier(Identifier healthcareWorkerIdentifier) {
        this.healthcareWorkerIdentifier.setValue(healthcareWorkerIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getHealthcareWorkerType() {
        return this.healthcareWorkerType.getValue();
    }
    public void setHealthcareWorkerType(HealthcareProviderRoleType healthcareWorkerType) {
        this.healthcareWorkerType.setValue(healthcareWorkerType);
    }

    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getHealthcareWorkerPhoneAndEmails() {
        return this.healthcareWorkerPhoneAndEmails.rawSet();
    }

    @Hl7XmlMapping({"assignedPerson"})
    public ca.infoway.messagebuilder.model.merged.ActingPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }
    public void setAssignedPerson(ca.infoway.messagebuilder.model.merged.ActingPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

    @Hl7XmlMapping({"representedOrganization"})
    public ResponsibleOrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }
    public void setRepresentedOrganization(ResponsibleOrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

    @Hl7XmlMapping({"name"})
    public List<PersonName> getFunctionalRoleName() {
        return this.functionalRoleName.rawList();
    }

    @Hl7XmlMapping({"assignedPrincipalPerson"})
    public PrincipalPerson_2Bean getAssignedPrincipalPerson() {
        return this.assignedPrincipalPerson;
    }
    public void setAssignedPrincipalPerson(PrincipalPerson_2Bean assignedPrincipalPerson) {
        this.assignedPrincipalPerson = assignedPrincipalPerson;
    }

    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getFunctionalRoleAddress() {
        return this.functionalRoleAddress.rawList();
    }

    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getFunctionalRoleStatusCode() {
        return this.functionalRoleStatusCode.getValue();
    }
    public void setFunctionalRoleStatusCode(RoleStatus functionalRoleStatusCode) {
        this.functionalRoleStatusCode.setValue(functionalRoleStatusCode);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getFunctionalRoleEffectiveDate() {
        return this.functionalRoleEffectiveDate.getValue();
    }
    public void setFunctionalRoleEffectiveDate(Interval<Date> functionalRoleEffectiveDate) {
        this.functionalRoleEffectiveDate.setValue(functionalRoleEffectiveDate);
    }

    @Hl7XmlMapping({"performance"})
    public List<PrimaryPerformer3Bean> getPerformance() {
        return this.performance;
    }

}
