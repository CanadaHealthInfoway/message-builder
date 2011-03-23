/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt306011ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import ca.infoway.messagebuilder.domainvalue.AssignedRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.PrivilegeBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;



/**
 * <p>Assigned Entity</p>
 * 
 * <p>The role class, assigned entity, captures the critical 
 * information of the provider playing the role of interest. 
 * This includes an identifier for the role, mailing address, 
 * phone number, and the time within which the role is played 
 * (may be open ended). The scooping organization, which may be 
 * omitted if not needed, provides the organizational context 
 * for the entity that actually plays the role. For example, 
 * the role scoper will normally be the party that assigns the 
 * identifier for the role.</p>
 * 
 * <p>Roleclass required to provide additional information for 
 * the person responsible for providing healthcare services 
 * within a specific healthcare setting</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306011CA.AssignedEntity"})
public class AssignedEntityBean extends MessagePartBean implements RoleChoiceBean {

    private static final long serialVersionUID = 20100603L;
    private List<PrivilegeBean> responsibleForPrivilege = new ArrayList<PrivilegeBean>();
    private SET<II, Identifier> functionalRoleIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();
    private CV functionalRoleType = new CVImpl();
    private LIST<PN, PersonName> functionalRoleName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<AD, PostalAddress> functionalRoleAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> functionalRoleTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CS functionalRoleStatusCode = new CSImpl();
    private IVL<TS, Interval<Date>> functionalRoleEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPersonBean assignedPrincipalPerson;
    private OrganizationBean representedOrganization;
    private List<ActDefinitionOrEventNameBean> performanceActDefinitionOrEvent = new ArrayList<ActDefinitionOrEventNameBean>();

    @Hl7XmlMapping({"responsibleFor/privilege"})
    public List<PrivilegeBean> getResponsibleForPrivilege() {
        return this.responsibleForPrivilege;
    }

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getFunctionalRoleIdentifier() {
        return this.functionalRoleIdentifier.rawSet();
    }

    @Hl7XmlMapping({"relatedTo"})
    public List<RelatedToBean> getRelatedTo() {
        return this.relatedTo;
    }

    @Hl7XmlMapping({"code"})
    public AssignedRoleType getFunctionalRoleType() {
        return (AssignedRoleType) this.functionalRoleType.getValue();
    }
    public void setFunctionalRoleType(AssignedRoleType functionalRoleType) {
        this.functionalRoleType.setValue(functionalRoleType);
    }

    @Hl7XmlMapping({"name"})
    public List<PersonName> getFunctionalRoleName() {
        return this.functionalRoleName.rawList();
    }

    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getFunctionalRoleAddress() {
        return this.functionalRoleAddress.rawList();
    }

    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getFunctionalRoleTelecom() {
        return this.functionalRoleTelecom.rawList();
    }

    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getFunctionalRoleStatusCode() {
        return (RoleStatus) this.functionalRoleStatusCode.getValue();
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

    @Hl7XmlMapping({"assignedPrincipalPerson"})
    public PrinicpalPersonBean getAssignedPrincipalPerson() {
        return this.assignedPrincipalPerson;
    }
    public void setAssignedPrincipalPerson(PrinicpalPersonBean assignedPrincipalPerson) {
        this.assignedPrincipalPerson = assignedPrincipalPerson;
    }

    @Hl7XmlMapping({"representedOrganization"})
    public OrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }
    public void setRepresentedOrganization(OrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

    @Hl7XmlMapping({"performance/actDefinitionOrEvent"})
    public List<ActDefinitionOrEventNameBean> getPerformanceActDefinitionOrEvent() {
        return this.performanceActDefinitionOrEvent;
    }

}
