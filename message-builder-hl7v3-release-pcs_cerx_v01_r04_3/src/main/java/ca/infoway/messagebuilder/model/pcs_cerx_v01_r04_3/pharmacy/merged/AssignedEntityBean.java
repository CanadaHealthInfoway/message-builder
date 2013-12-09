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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7MapByPartType;
import ca.infoway.messagebuilder.annotation.Hl7MapByPartTypes;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"POME_MT010040CA.AssignedEntity1","POME_MT010040CA.AssignedEntity2","POME_MT010040CA.AssignedEntity3","POME_MT010040CA.AssignedEntity4","PORR_MT050016CA.AssignedEntity","PORX_MT980010CA.AssignedEntity","PORX_MT980020CA.AssignedEntity","PORX_MT980030CA.AssignedEntity"})
public class AssignedEntityBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private ST assignedOrganizationName = new STImpl();


    /**
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: PORX_MT980020CA.Organization.name</p>
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
     * <p>Un-merged Business Name: MedicationDocumentAuthorName</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Organization4.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the receiver evaluate the supplied information.</p>
     * 
     * <p>The name of the organization responsible for creating the 
     * medication document.</p>
     * 
     * <p>Un-merged Business Name: RecommendingAuthorityName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization4.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The source of a recommendation may influence prescriber's 
     * willingness to use the recommended dose and is therefore 
     * mandatory</p>
     * 
     * <p>Indicates the name of the organization or agency that 
     * created the dosage recommendation</p>
     * 
     * <p>Un-merged Business Name: FormularyOwnerName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization3.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps identify the circumstances in which the formulary 
     * applies.</p>
     * 
     * <p>The name of the organization or facility responsible for 
     * the formulary.</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: PORX_MT980010CA.Organization.name</p>
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
     * <p>Un-merged Business Name: MonitoringOrganizationName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization2.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps identify the program and understand its context. 
     * May also indicate who to send reports to.</p>
     * 
     * <p>The name of the organization responsible for the 
     * monitoring program</p>
     * 
     * <p>Un-merged Business Name: MonographAuthorName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization1.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the receiver evaluate the supplied information.</p>
     * 
     * <p>The name of the organization responsible for creating the 
     * monograph</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: PORX_MT980030CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     */
    @Hl7XmlMapping({"assignedOrganization/name","representedOrganization/name"})
    @Hl7MapByPartTypes({
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization1"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization2"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization3"),
        @Hl7MapByPartType(name="assignedOrganization", type="POME_MT010040CA.Organization4"),
        @Hl7MapByPartType(name="assignedOrganization", type="PORX_MT980010CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="PORX_MT980020CA.Organization"),
        @Hl7MapByPartType(name="assignedOrganization", type="PORX_MT980030CA.Organization"),
        @Hl7MapByPartType(name="representedOrganization", type="PORR_MT050016CA.Organization4")})
    public String getAssignedOrganizationName() {
        return this.assignedOrganizationName.getValue();
    }

    /**
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: PORX_MT980020CA.Organization.name</p>
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
     * <p>Un-merged Business Name: MedicationDocumentAuthorName</p>
     * 
     * <p>Relationship: PORR_MT050016CA.Organization4.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the receiver evaluate the supplied information.</p>
     * 
     * <p>The name of the organization responsible for creating the 
     * medication document.</p>
     * 
     * <p>Un-merged Business Name: RecommendingAuthorityName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization4.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The source of a recommendation may influence prescriber's 
     * willingness to use the recommended dose and is therefore 
     * mandatory</p>
     * 
     * <p>Indicates the name of the organization or agency that 
     * created the dosage recommendation</p>
     * 
     * <p>Un-merged Business Name: FormularyOwnerName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization3.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps identify the circumstances in which the formulary 
     * applies.</p>
     * 
     * <p>The name of the organization or facility responsible for 
     * the formulary.</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: PORX_MT980010CA.Organization.name</p>
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
     * <p>Un-merged Business Name: MonitoringOrganizationName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization2.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps identify the program and understand its context. 
     * May also indicate who to send reports to.</p>
     * 
     * <p>The name of the organization responsible for the 
     * monitoring program</p>
     * 
     * <p>Un-merged Business Name: MonographAuthorName</p>
     * 
     * <p>Relationship: POME_MT010040CA.Organization1.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Helps the receiver evaluate the supplied information.</p>
     * 
     * <p>The name of the organization responsible for creating the 
     * monograph</p>
     * 
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: PORX_MT980030CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a knowledgebase vendor to be referenced by 
     * name.</p><p>The attribute is mandatory because it is the 
     * only information collected about a knowledgebase vendor.</p>
     * 
     * <p>The name of a clinical knowledgebase vendor 
     * organization.</p>
     */
    public void setAssignedOrganizationName(String assignedOrganizationName) {
        this.assignedOrganizationName.setValue(assignedOrganizationName);
    }

}
