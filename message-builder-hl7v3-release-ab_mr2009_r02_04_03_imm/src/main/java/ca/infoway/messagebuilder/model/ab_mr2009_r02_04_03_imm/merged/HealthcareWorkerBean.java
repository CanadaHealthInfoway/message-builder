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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03_imm.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: HealthcareWorker</p>
 * 
 * <p>POIZ_MT030050AB.AssignedEntity: Healthcare Worker</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p>
 * 
 * <p>POIZ_MT030060AB.AssignedEntity: Healthcare Worker</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p>
 * 
 * <p>POIZ_MT060150AB.AssignedEntity: Healthcare Worker</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up. The CMET supports both licensed providers as well 
 * as non-licensed providers such as technicians, 
 * receptionists, etc.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>The person organization assigned to carry out the 
 * associated (linked by a participation) action and/or the 
 * organization under whose authority they are acting.</p>
 */
@Hl7PartTypeMapping({"COCT_MT260010CA.AssignedEntity","COCT_MT260020CA.AssignedEntity","COCT_MT260030CA.AssignedEntity","POIZ_MT030050AB.AssignedEntity","POIZ_MT030060AB.AssignedEntity","POIZ_MT060150AB.AssignedEntity"})
public class HealthcareWorkerBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private ST representedOrganizationName = new STImpl();
    private II representedOrganizationId = new IIImpl();


    /**
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260030CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260010CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT030050AB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT030060AB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260020CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT060150AB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     */
    @Hl7XmlMapping({"assignedOrganization/name","representedOrganization/name"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260010CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260020CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="COCT_MT260030CA.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="POIZ_MT030050AB.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="POIZ_MT030060AB.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="POIZ_MT060150AB.Organization")})
    public String getRepresentedOrganizationName() {
        return this.representedOrganizationName.getValue();
    }

    /**
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260030CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260010CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT030050AB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT030060AB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260020CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: POIZ_MT060150AB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     */
    public void setRepresentedOrganizationName(String representedOrganizationName) {
        this.representedOrganizationName.setValue(representedOrganizationName);
    }


    /**
     * <p>Business Name: OrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030050AB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030060AB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT060150AB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getRepresentedOrganizationId() {
        return this.representedOrganizationId.getValue();
    }

    /**
     * <p>Business Name: OrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030050AB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT030060AB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: POIZ_MT060150AB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    public void setRepresentedOrganizationId(Identifier representedOrganizationId) {
        this.representedOrganizationId.setValue(representedOrganizationId);
    }

}
