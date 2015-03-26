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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt090502ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Healthcare Organization</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up.</p>
 * 
 * <p>The organization under whose authority the associated 
 * action (linked by a participation) was performed.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090502CA.AssignedEntity"})
@Hl7RootType
public class HealthcareOrganizationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.EntererChoice, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.coct_mt911102ca.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.common.merged.AuthorPerson_2 {

    private static final long serialVersionUID = 20150326L;
    private II representedOrganizationId = new IIImpl();
    private ST representedOrganizationName = new STImpl();


    /**
     * <p>Business Name: D: Organization identifier</p>
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
     */
    @Hl7XmlMapping({"representedOrganization/id"})
    public Identifier getRepresentedOrganizationId() {
        return this.representedOrganizationId.getValue();
    }

    /**
     * <p>Business Name: D: Organization identifier</p>
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
     */
    public void setRepresentedOrganizationId(Identifier representedOrganizationId) {
        this.representedOrganizationId.setValue(representedOrganizationId);
    }


    /**
     * <p>Business Name: E: Organization Name</p>
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
     */
    @Hl7XmlMapping({"representedOrganization/name"})
    public String getRepresentedOrganizationName() {
        return this.representedOrganizationName.getValue();
    }

    /**
     * <p>Business Name: E: Organization Name</p>
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
     */
    public void setRepresentedOrganizationName(String representedOrganizationName) {
        this.representedOrganizationName.setValue(representedOrganizationName);
    }

}
