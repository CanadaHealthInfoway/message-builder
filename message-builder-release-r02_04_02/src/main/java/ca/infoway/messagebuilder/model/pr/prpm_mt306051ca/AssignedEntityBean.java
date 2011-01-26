/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt306051ca;

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
import ca.infoway.messagebuilder.domainvalue.AssignedRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pr.merged.PrinicpalPerson_2Bean;
import java.util.List;
import java.util.Set;



/**
 * <p>Assigned Entity</p>
 * 
 * <p><p>The role class, assigned entity, captures the critical 
 * information of the provider playing the role of interest. 
 * This includes an identifier for the role, mailing address, 
 * phone number, and the time within which the role is played 
 * (may be open ended). The scooping organization, which may be 
 * omitted if not needed, provides the organizational context 
 * for the entity that actually plays the role. For example, 
 * the role scoper will normally be the party that assigns the 
 * identifier for the role.</p></p>
 * 
 * <p><p>Roleclass required to provide additional information 
 * for the person responsible for providing healthcare services 
 * within a specific healthcare setting</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT306051CA.AssignedEntity"})
public class AssignedEntityBean extends MessagePartBean implements ca.infoway.messagebuilder.model.merged.RoleChoice {

    private static final long serialVersionUID = 20110126L;
    private PrinicpalPerson_2Bean assignedPrincipalPerson;
    private CV functionalRoleType = new CVImpl();
    private SET<II, Identifier> functionalRoleIdentifier = new SETImpl<II, Identifier>(IIImpl.class);
    private OrganizationBean representedOrganization;
    private LIST<PN, PersonName> functionalRoleName = new LISTImpl<PN, PersonName>(PNImpl.class);


    @Hl7XmlMapping({"assignedPrincipalPerson"})
    public PrinicpalPerson_2Bean getAssignedPrincipalPerson() {
        return this.assignedPrincipalPerson;
    }
    public void setAssignedPrincipalPerson(PrinicpalPerson_2Bean assignedPrincipalPerson) {
        this.assignedPrincipalPerson = assignedPrincipalPerson;
    }


    /**
     * <p>Functional Role Type</p>
     * 
     * <p><p>The code identifying the specific functional role.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"code"})
    public AssignedRoleType getFunctionalRoleType() {
        return (AssignedRoleType) this.functionalRoleType.getValue();
    }
    public void setFunctionalRoleType(AssignedRoleType functionalRoleType) {
        this.functionalRoleType.setValue(functionalRoleType);
    }


    /**
     * <p>Functional Role Identifier</p>
     * 
     * <p><p>Identifies specific functional role that a provider 
     * may play within an organization.</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getFunctionalRoleIdentifier() {
        return this.functionalRoleIdentifier.rawSet();
    }


    @Hl7XmlMapping({"representedOrganization"})
    public OrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }
    public void setRepresentedOrganization(OrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }


    /**
     * <p>Functional Role Name</p>
     * 
     * <p><p>The provider'''s name pertaining to the specific 
     * functional role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getFunctionalRoleName() {
        return this.functionalRoleName.rawList();
    }

}
