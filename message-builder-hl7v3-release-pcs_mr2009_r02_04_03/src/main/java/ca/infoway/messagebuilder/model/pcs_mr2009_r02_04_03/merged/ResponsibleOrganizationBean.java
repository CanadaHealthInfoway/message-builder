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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.HealthcareOrganizationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>COCT_MT090102CA.Organization: Responsible organization</p>
 * 
 * <p>Used for determining responsibility and potentially 
 * confirming permissions.</p>
 * 
 * <p>Identifies the organization or group on whose behalf the 
 * action is performed.</p>
 * 
 * <p>COCT_MT090502CA.Organization: Responsible organization</p>
 * 
 * <p>Used for determining responsibility and potentially 
 * confirming permissions.</p>
 * 
 * <p>Identifies the organization or group on whose behalf the 
 * action is performed.</p>
 * 
 * <p>COCT_MT080100CA.Organization: Specimen Scoping 
 * Organization</p>
 * 
 * <p>To identify or name the specimen identifier scoping 
 * organization.</p>
 * 
 * <p>Identifies the organization or group assigning the 
 * associated specimen identifier.</p>
 * 
 * <p>COCT_MT090508CA.Organization: Responsible organization</p>
 * 
 * <p>Used for determining responsibility and potentially 
 * confirming permissions.</p>
 * 
 * <p>Identifies the organization on whose behalf the action is 
 * performed.</p>
 * 
 * <p>COCT_MT090108CA.Organization: Responsible organization</p>
 * 
 * <p>Used for determining responsibility and potentially 
 * confirming permissions.</p>
 * 
 * <p>Identifies the organization on whose behalf the action is 
 * performed.</p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.Organization","COCT_MT090102CA.Organization","COCT_MT090108CA.Organization","COCT_MT090502CA.Organization","COCT_MT090508CA.Organization","COCT_MT260010CA.Organization","COCT_MT260020CA.Organization","COCT_MT260030CA.Organization","PORX_MT010110CA.Organization","PORX_MT010120CA.Organization","PORX_MT060040CA.Organization","PORX_MT060340CA.Organization"})
public class ResponsibleOrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20131209L;
    private ST name = new STImpl();
    private II id = new IIImpl();
    private CV assignedOrganizationCode = new CVImpl();
    private SET<TEL, TelecommunicationAddress> assignedOrganizationTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);


    /**
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: COCT_MT090102CA.Organization.name</p>
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
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension.</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: COCT_MT090502CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.name</p>
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
     * <p>Relationship: COCT_MT090508CA.Organization.name</p>
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
     * <p>Relationship: COCT_MT090108CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension</p>
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
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260020CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: COCT_MT090102CA.Organization.name</p>
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
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT060340CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension.</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: COCT_MT090502CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT010120CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension</p>
     * 
     * <p>Un-merged Business Name: OrganizationName</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.name</p>
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
     * <p>Relationship: COCT_MT090508CA.Organization.name</p>
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
     * <p>Relationship: COCT_MT090108CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT010110CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension</p>
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
     * <p>Un-merged Business Name: KnowledgebaseVendorName</p>
     * 
     * <p>Relationship: COCT_MT260020CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: PayorName</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Mandatory for display purposes.</p>
     * 
     * <p>The name of the organization responsible for issuing the 
     * coverage extension.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Business Name: OrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT090102CA.Organization.id</p>
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
     * <p>Relationship: COCT_MT090502CA.Organization.id</p>
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
     * <p>Relationship: COCT_MT080100CA.Organization.id</p>
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
     * <p>Relationship: COCT_MT090508CA.Organization.id</p>
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
     * <p>Relationship: COCT_MT090108CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: OrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: OrganizationIdentifier</p>
     * 
     * <p>Relationship: COCT_MT090102CA.Organization.id</p>
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
     * <p>Relationship: COCT_MT090502CA.Organization.id</p>
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
     * <p>Relationship: COCT_MT080100CA.Organization.id</p>
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
     * <p>Relationship: COCT_MT090508CA.Organization.id</p>
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
     * <p>Relationship: COCT_MT090108CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     * 
     * <p>A unique identifier for the organization</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: OrganizationType</p>
     * 
     * <p>Un-merged Business Name: OrganizationType</p>
     * 
     * <p>Relationship: COCT_MT090508CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     */
    @Hl7XmlMapping({"assignedOrganization/code"})
    public HealthcareOrganizationRoleType getAssignedOrganizationCode() {
        return (HealthcareOrganizationRoleType) this.assignedOrganizationCode.getValue();
    }

    /**
     * <p>Business Name: OrganizationType</p>
     * 
     * <p>Un-merged Business Name: OrganizationType</p>
     * 
     * <p>Relationship: COCT_MT090508CA.AssignedOrganization.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides context to the action and is therefore 
     * mandatory.</p>
     * 
     * <p>Identifies the type of organization on whose behalf the 
     * action was taken. E.g. Pharmacy, Clinic, Hospital, etc.</p>
     */
    public void setAssignedOrganizationCode(HealthcareOrganizationRoleType assignedOrganizationCode) {
        this.assignedOrganizationCode.setValue(assignedOrganizationCode);
    }


    /**
     * <p>Business Name: OrganizationPhoneAndEmails</p>
     * 
     * <p>Un-merged Business Name: OrganizationPhoneAndEmails</p>
     * 
     * <p>Relationship: 
     * COCT_MT090508CA.AssignedOrganization.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>This is the most commonly used contact information and is 
     * returned to avoid unnecessary queries against the client 
     * registry.</p>
     * 
     * <p>Identifies contact information for the responsible 
     * organization.</p>
     */
    @Hl7XmlMapping({"assignedOrganization/telecom"})
    public Set<TelecommunicationAddress> getAssignedOrganizationTelecom() {
        return this.assignedOrganizationTelecom.rawSet();
    }

}
