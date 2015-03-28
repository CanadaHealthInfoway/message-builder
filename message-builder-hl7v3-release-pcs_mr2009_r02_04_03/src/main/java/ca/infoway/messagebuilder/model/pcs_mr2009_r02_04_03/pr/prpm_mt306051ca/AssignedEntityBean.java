/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.prpm_mt306051ca;

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
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.pr.merged.PrinicpalPerson_2Bean;
import java.util.List;
import java.util.Set;



/**
 * <p>Business Name: Assigned Entity</p>
 * 
 * <p>Roleclass required to provide additional information for 
 * the person responsible for providing healthcare services 
 * within a specific healthcare setting</p>
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
 */
@Hl7PartTypeMapping({"PRPM_MT306051CA.AssignedEntity"})
public class AssignedEntityBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20150326L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();
    private LIST<PN, PersonName> name = new LISTImpl<PN, PersonName>(PNImpl.class);
    private PrinicpalPerson_2Bean assignedPrincipalPerson;
    private OrganizationBean representedOrganization;


    /**
     * <p>Business Name: Functional Role Identifier</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-50)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>Identifies specific functional role that a provider may 
     * play within an organization.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: Functional Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The code identifying the specific functional role.</p>
     */
    @Hl7XmlMapping({"code"})
    public AssignedRoleType getCode() {
        return (AssignedRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Functional Role Type</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.AssignedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The code identifying the specific functional role.</p>
     */
    public void setCode(AssignedRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Functional Role Name</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.AssignedEntity.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Required attribute supports the identification of the 
     * healthcare provider</p>
     * 
     * <p>The provider's name pertaining to the specific functional 
     * role.</p>
     */
    @Hl7XmlMapping({"name"})
    public List<PersonName> getName() {
        return this.name.rawList();
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306051CA.AssignedEntity.assignedPrincipalPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"assignedPrincipalPerson"})
    public PrinicpalPerson_2Bean getAssignedPrincipalPerson() {
        return this.assignedPrincipalPerson;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306051CA.AssignedEntity.assignedPrincipalPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setAssignedPrincipalPerson(PrinicpalPerson_2Bean assignedPrincipalPerson) {
        this.assignedPrincipalPerson = assignedPrincipalPerson;
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306051CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"representedOrganization"})
    public OrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306051CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setRepresentedOrganization(OrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

}
