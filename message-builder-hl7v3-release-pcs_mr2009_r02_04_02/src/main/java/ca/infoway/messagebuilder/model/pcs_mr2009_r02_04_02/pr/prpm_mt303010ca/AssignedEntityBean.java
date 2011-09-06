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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt303010ca;

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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.AssignedRoleType;
import ca.infoway.messagebuilder.domainvalue.RoleStatus;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged.ActDefinitionOrEventName_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged.PrinicpalPerson_1Bean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.merged.PrivilegeBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



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
@Hl7PartTypeMapping({"PRPM_MT303010CA.AssignedEntity"})
public class AssignedEntityBean extends MessagePartBean implements RoleChoice {

    private static final long serialVersionUID = 20110906L;
    private List<PrivilegeBean> responsibleForPrivilege = new ArrayList<PrivilegeBean>();
    private II functionalRoleIdentifier = new IIImpl();
    private List<RelatedToBean> relatedTo = new ArrayList<RelatedToBean>();
    private CV functionalRoleType = new CVImpl();
    private LIST<PN, PersonName> functionalRoleName = new LISTImpl<PN, PersonName>(PNImpl.class);
    private LIST<AD, PostalAddress> functionalRoleAddress = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> functionalRoleTelecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private CS functionalRoleStatusCode = new CSImpl();
    private IVL<TS, Interval<Date>> functionalRoleEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private PrinicpalPerson_1Bean assignedPrincipalPerson;
    private OrganizationBean representedOrganization;
    private List<ActDefinitionOrEventName_1Bean> performanceActDefinitionOrEvent = new ArrayList<ActDefinitionOrEventName_1Bean>();


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
     * <p><p>Populated attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getFunctionalRoleIdentifier() {
        return this.functionalRoleIdentifier.getValue();
    }
    public void setFunctionalRoleIdentifier(Identifier functionalRoleIdentifier) {
        this.functionalRoleIdentifier.setValue(functionalRoleIdentifier);
    }


    @Hl7XmlMapping({"relatedTo"})
    public List<RelatedToBean> getRelatedTo() {
        return this.relatedTo;
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


    /**
     * <p>Functional Role Address</p>
     * 
     * <p><p>Address of the provider when playing the functional 
     * role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getFunctionalRoleAddress() {
        return this.functionalRoleAddress.rawList();
    }


    /**
     * <p>Functional Role Telecom</p>
     * 
     * <p><p>Telecom of the provider when playing the functional 
     * role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getFunctionalRoleTelecom() {
        return this.functionalRoleTelecom.rawList();
    }


    /**
     * <p>Functional Role Status Code</p>
     * 
     * <p><p>The status of the provider in the functional role i.e. 
     * Active</p></p>
     * 
     * <p><p>Mandatory attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"statusCode"})
    public RoleStatus getFunctionalRoleStatusCode() {
        return (RoleStatus) this.functionalRoleStatusCode.getValue();
    }
    public void setFunctionalRoleStatusCode(RoleStatus functionalRoleStatusCode) {
        this.functionalRoleStatusCode.setValue(functionalRoleStatusCode);
    }


    /**
     * <p>Functional Role Effective Date</p>
     * 
     * <p><p>The effective date of the provider in the functional 
     * role.</p></p>
     * 
     * <p><p>Required attribute supports the identification of the 
     * healthcare provider</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getFunctionalRoleEffectiveDate() {
        return this.functionalRoleEffectiveDate.getValue();
    }
    public void setFunctionalRoleEffectiveDate(Interval<Date> functionalRoleEffectiveDate) {
        this.functionalRoleEffectiveDate.setValue(functionalRoleEffectiveDate);
    }


    @Hl7XmlMapping({"assignedPrincipalPerson"})
    public PrinicpalPerson_1Bean getAssignedPrincipalPerson() {
        return this.assignedPrincipalPerson;
    }
    public void setAssignedPrincipalPerson(PrinicpalPerson_1Bean assignedPrincipalPerson) {
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
    public List<ActDefinitionOrEventName_1Bean> getPerformanceActDefinitionOrEvent() {
        return this.performanceActDefinitionOrEvent;
    }

}
