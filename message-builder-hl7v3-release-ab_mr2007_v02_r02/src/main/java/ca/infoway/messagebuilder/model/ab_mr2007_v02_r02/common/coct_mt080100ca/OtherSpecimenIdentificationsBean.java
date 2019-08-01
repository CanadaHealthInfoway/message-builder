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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.common.coct_mt080100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.domainvalue.SpecimenIdentifierRoleType;



/**
 * <p>Business Name: Other Specimen Identifications</p>
 * 
 * <p>Associated specimen identifiers.</p>
 * 
 * <p>For referral and redirected orders, this information 
 * helps keep track of the different id's assigned during each 
 * phase of processing.</p>
 */
@Hl7PartTypeMapping({"COCT_MT080100CA.IdentifiedEntity"})
public class OtherSpecimenIdentificationsBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private II assigningOrganizationId = new IIImpl();
    private ST assigningOrganizationName = new STImpl();


    /**
     * <p>Business Name: Other Specimen Identifiers</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Associated specimen identifiers.</p>
     * 
     * <p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Other Specimen Identifiers</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Associated specimen identifiers.</p>
     * 
     * <p>For referral and redirected orders, this information 
     * helps keep track of the different id's assigned during each 
     * phase of processing.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Other Specimen Identifier Type</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p>
     * 
     * <p>Categorized the type of role identifier.</p>
     */
    @Hl7XmlMapping({"code"})
    public SpecimenIdentifierRoleType getCode() {
        return (SpecimenIdentifierRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Other Specimen Identifier Type</p>
     * 
     * <p>Relationship: COCT_MT080100CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Describes the type of other specimen identifier 
     * (referral, primary, etc.)</p>
     * 
     * <p>Categorized the type of role identifier.</p>
     */
    public void setCode(SpecimenIdentifierRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Organization Identifier</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     */
    @Hl7XmlMapping({"assigningOrganization/id"})
    public Identifier getAssigningOrganizationId() {
        return this.assigningOrganizationId.getValue();
    }

    /**
     * <p>Business Name: Organization Identifier</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>A unique identifier for the organization</p>
     * 
     * <p>Allows the organization to be referenced when determining 
     * privileges and for drill-downs to retrieve additional 
     * information. Because of its importance, the attribute is 
     * mandatory.</p>
     */
    public void setAssigningOrganizationId(Identifier assigningOrganizationId) {
        this.assigningOrganizationId.setValue(assigningOrganizationId);
    }


    /**
     * <p>Business Name: Organization Name</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     */
    @Hl7XmlMapping({"assigningOrganization/name"})
    public String getAssigningOrganizationName() {
        return this.assigningOrganizationName.getValue();
    }

    /**
     * <p>Business Name: Organization Name</p>
     * 
     * <p>Relationship: COCT_MT080100CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies the name of the organization</p>
     * 
     * <p>Allows for human recognition of the organization as well 
     * as confirmation of the identifier. As a result, the 
     * attribute is mandatory.</p>
     */
    public void setAssigningOrganizationName(String assigningOrganizationName) {
        this.assigningOrganizationName.setValue(assigningOrganizationName);
    }

}
