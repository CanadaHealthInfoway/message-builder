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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.prpm_mt306051ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Organization</p>
 * 
 * <p>Supports the requirement to supply additional information 
 * regarding the assigning Organization of the specified 
 * RoleClass</p>
 * 
 * <p>The scoping organization for the specified role class</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306051CA.Organization"})
public class OrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private II id = new IIImpl();
    private ST name = new STImpl();
    private TerritorialAuthorityBean territorialAuthority;


    /**
     * <p>Business Name: Organization Id</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>The unique identifier of the Organization.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Organization Id</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.Organization.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider</p>
     * 
     * <p>The unique identifier of the Organization.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: (Issuing Representing Qualification 
     * Granting Organization Name(s</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider.</p>
     * 
     * <p>The name of the organization supporting the following 
     * three role classes:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider's functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p>
     */
    @Hl7XmlMapping({"name"})
    public String getName() {
        return this.name.getValue();
    }

    /**
     * <p>Business Name: (Issuing Representing Qualification 
     * Granting Organization Name(s</p>
     * 
     * <p>Relationship: PRPM_MT306051CA.Organization.name</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Required attribute supports the validation and 
     * identification of the healthcare provider.</p>
     * 
     * <p>The name of the organization supporting the following 
     * three role classes:</p><p>1. Organization that is 
     * responsible for registering the provider for a specific 
     * healthcare provider role.</p><p>2. Organization associated 
     * with a provider's functional role.</p><p>3. Organization 
     * that grants the qualifications or expertise.</p>
     */
    public void setName(String name) {
        this.name.setValue(name);
    }


    /**
     * <p>Relationship: 
     * PRPM_MT306051CA.Organization.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }

    /**
     * <p>Relationship: 
     * PRPM_MT306051CA.Organization.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     */
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
