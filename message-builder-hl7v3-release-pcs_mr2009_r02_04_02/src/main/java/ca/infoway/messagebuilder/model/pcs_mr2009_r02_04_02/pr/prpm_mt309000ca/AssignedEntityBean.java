/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt309000ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged.ActDefinitionOrEventName_2Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged.PrivilegeBean;
import java.util.ArrayList;
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
@Hl7PartTypeMapping({"PRPM_MT309000CA.AssignedEntity"})
public class AssignedEntityBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20111117L;
    private List<PrivilegeBean> responsibleForPrivilege = new ArrayList<PrivilegeBean>();
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private List<RoleChoice> relatedToRoleChoice = new ArrayList<RoleChoice>();
    private CV code = new CVImpl();
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private PrinicpalPersonBean assignedPrincipalPerson;
    private OrganizationBean representedOrganization;
    private List<ActDefinitionOrEventName_2Bean> performanceActDefinitionOrEvent = new ArrayList<ActDefinitionOrEventName_2Bean>();


    @Hl7XmlMapping({"responsibleFor/privilege"})
    public List<PrivilegeBean> getResponsibleForPrivilege() {
        return this.responsibleForPrivilege;
    }


    /**
     * <p>Functional Role Identifier</p>
     * 
     * <p><p>Identifies specific functional role that a provider 
     * may play within an organization.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    @Hl7XmlMapping({"relatedTo/roleChoice"})
    public List<RoleChoice> getRelatedToRoleChoice() {
        return this.relatedToRoleChoice;
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
    public AssignedRoleType getCode() {
        return (AssignedRoleType) this.code.getValue();
    }
    public void setCode(AssignedRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Functional Role Name</p>
     * 
     * <p><p>The providers name pertaining to the specific 
     * functional role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
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
    public List<ActDefinitionOrEventName_2Bean> getPerformanceActDefinitionOrEvent() {
        return this.performanceActDefinitionOrEvent;
    }

}
