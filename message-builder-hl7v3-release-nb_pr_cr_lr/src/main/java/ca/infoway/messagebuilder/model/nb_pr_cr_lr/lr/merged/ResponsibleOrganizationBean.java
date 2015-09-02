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
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: ResponsibleOrganization</p>
 * 
 * <p>PRLO_MT202015NB.Organization: B:Responsible Organization</p>
 * 
 * <p>To provide additional information regarding the 
 * management and administration of the service delivery 
 * location.</p>
 * 
 * <p>The organization responsible for the operations of the 
 * service delivery location.</p>
 * 
 * <p>PRLO_MT000002NB.Organization: B:Responsible Organization</p>
 * 
 * <p>To provide additional information regarding the 
 * management and administration of the service delivery 
 * location.</p>
 * 
 * <p>The organization responsible for the operations of the 
 * service delivery location.</p>
 * 
 * <p>PRLO_MT202014NB.Organization: B:Responsible Organization</p>
 * 
 * <p>To provide additional information regarding the 
 * management and administration of the service delivery 
 * location.</p>
 * 
 * <p>The organization responsible for the operations of the 
 * service delivery location.</p>
 */
@Hl7PartTypeMapping({"PRLO_MT000002NB.Organization","PRLO_MT202014NB.Organization","PRLO_MT202015NB.Organization"})
public class ResponsibleOrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private ST name = new STImpl();


    /**
     * <p>Business Name: ResponsibleOrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: 
     * ResponsibleOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRLO_MT202015NB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows drilling down for additional information about the 
     * organization. May also be used as a query parameter.</p>
     * 
     * <p>The expectation is that these identifiers can be 
     * retrieved from jurisdictional provider registries. Where 
     * organization identifiers are not maintained in the registry, 
     * they may be omitted or alternative identifier sources may be 
     * used (e.g. identifiers issued by health regions).</p>
     * 
     * <p>Unique identifier for the responsible organization.</p>
     * 
     * <p>Un-merged Business Name: 
     * ResponsibleOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRLO_MT000002NB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows drilling down for additional information about the 
     * organization. May also be used as a query parameter.</p>
     * 
     * <p>The expectation is that these identifiers can be 
     * retrieved from jurisdictional provider registries. Where 
     * organization identifiers are not maintained in the registry, 
     * they may be omitted or alternative identifier sources may be 
     * used (e.g. identifiers issued by health regions).</p>
     * 
     * <p>Unique identifier for the responsible organization.</p>
     * 
     * <p>Un-merged Business Name: 
     * ResponsibleOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRLO_MT202014NB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows drilling down for additional information about the 
     * organization. May also be used as a query parameter.</p>
     * 
     * <p>The expectation is that these identifiers can be 
     * retrieved from jurisdictional provider registries. Where 
     * organization identifiers are not maintained in the registry, 
     * they may be omitted or alternative identifier sources may be 
     * used (e.g. identifiers issued by health regions).</p>
     * 
     * <p>Unique identifier for the responsible organization.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: ResponsibleOrganizationIdentifier</p>
     * 
     * <p>Un-merged Business Name: 
     * ResponsibleOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRLO_MT202015NB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows drilling down for additional information about the 
     * organization. May also be used as a query parameter.</p>
     * 
     * <p>The expectation is that these identifiers can be 
     * retrieved from jurisdictional provider registries. Where 
     * organization identifiers are not maintained in the registry, 
     * they may be omitted or alternative identifier sources may be 
     * used (e.g. identifiers issued by health regions).</p>
     * 
     * <p>Unique identifier for the responsible organization.</p>
     * 
     * <p>Un-merged Business Name: 
     * ResponsibleOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRLO_MT000002NB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows drilling down for additional information about the 
     * organization. May also be used as a query parameter.</p>
     * 
     * <p>The expectation is that these identifiers can be 
     * retrieved from jurisdictional provider registries. Where 
     * organization identifiers are not maintained in the registry, 
     * they may be omitted or alternative identifier sources may be 
     * used (e.g. identifiers issued by health regions).</p>
     * 
     * <p>Unique identifier for the responsible organization.</p>
     * 
     * <p>Un-merged Business Name: 
     * ResponsibleOrganizationIdentifier</p>
     * 
     * <p>Relationship: PRLO_MT202014NB.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Allows drilling down for additional information about the 
     * organization. May also be used as a query parameter.</p>
     * 
     * <p>The expectation is that these identifiers can be 
     * retrieved from jurisdictional provider registries. Where 
     * organization identifiers are not maintained in the registry, 
     * they may be omitted or alternative identifier sources may be 
     * used (e.g. identifiers issued by health regions).</p>
     * 
     * <p>Unique identifier for the responsible organization.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: ResponsibleOrganizationName</p>
     * 
     * <p>Un-merged Business Name: ResponsibleOrganizationName</p>
     * 
     * <p>Relationship: PRLO_MT202015NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a user-accessible label for the organization and 
     * is therefore mandatory.</p>
     * 
     * <p>The label by which the responsible organization is known 
     * and communicated with e.g. Capital Health District.</p>
     * 
     * <p>Un-merged Business Name: ResponsibleOrganizationName</p>
     * 
     * <p>Relationship: PRLO_MT000002NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a user-accessible label for the organization and 
     * is therefore mandatory.</p>
     * 
     * <p>The label by which the responsible organization is known 
     * and communicated with e.g. Capital Health District.</p>
     * 
     * <p>Un-merged Business Name: ResponsibleOrganizationName</p>
     * 
     * <p>Relationship: PRLO_MT202014NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a user-accessible label for the organization and 
     * is therefore mandatory.</p>
     * 
     * <p>The label by which the responsible organization is known 
     * and communicated with e.g. Capital Health District.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: ResponsibleOrganizationName</p>
     * 
     * <p>Un-merged Business Name: ResponsibleOrganizationName</p>
     * 
     * <p>Relationship: PRLO_MT202015NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a user-accessible label for the organization and 
     * is therefore mandatory.</p>
     * 
     * <p>The label by which the responsible organization is known 
     * and communicated with e.g. Capital Health District.</p>
     * 
     * <p>Un-merged Business Name: ResponsibleOrganizationName</p>
     * 
     * <p>Relationship: PRLO_MT000002NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a user-accessible label for the organization and 
     * is therefore mandatory.</p>
     * 
     * <p>The label by which the responsible organization is known 
     * and communicated with e.g. Capital Health District.</p>
     * 
     * <p>Un-merged Business Name: ResponsibleOrganizationName</p>
     * 
     * <p>Relationship: PRLO_MT202014NB.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a user-accessible label for the organization and 
     * is therefore mandatory.</p>
     * 
     * <p>The label by which the responsible organization is known 
     * and communicated with e.g. Capital Health District.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }

}
