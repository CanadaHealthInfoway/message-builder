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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ActingPersonBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ResponsibleOrganizationBean;
import java.util.Set;



/**
 * <p>Business Name: Healthcare Worker</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>The person assigned to carry out the associated action 
 * (linked by a participation) and/or the organization/group 
 * under whose authority they are acting.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090102CA.AssignedEntity"})
@Hl7RootType
public class HealthcareWorkerBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.RoleChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911102ca.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt080100ca.PerformerChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.RecipientChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.AuthorPerson_2, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt470002ca.Recipient, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt470012ca.Recipient, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.EntererChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt011001ca.Assignees, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.polb_mt002000ca.RoleChoice {

    private static final long serialVersionUID = 20190731L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private ActingPersonBean assignedPerson;
    private ResponsibleOrganizationBean representedOrganization;


    /**
     * <p>Business Name: A: Healthcare Worker Identifier</p>
     * 
     * <p>Relationship: COCT_MT090102CA.AssignedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-3)</p>
     * 
     * <p>Allows unique identification of the person which can be 
     * critical for authentication, permissions, drill-down and 
     * traceability and is therefore mandatory.</p>
     * 
     * <p>Unique identifier the person involved in the action.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Relationship: 
     * COCT_MT090102CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"assignedPerson"})
    public ActingPersonBean getAssignedPerson() {
        return this.assignedPerson;
    }

    /**
     * <p>Relationship: 
     * COCT_MT090102CA.AssignedEntity.assignedPerson</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAssignedPerson(ActingPersonBean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }


    /**
     * <p>Relationship: 
     * COCT_MT090102CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"representedOrganization"})
    public ResponsibleOrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }

    /**
     * <p>Relationship: 
     * COCT_MT090102CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setRepresentedOrganization(ResponsibleOrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

}
